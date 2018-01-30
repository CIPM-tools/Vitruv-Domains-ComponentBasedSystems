package tools.vitruv.dsls.reactions.codegen.classgenerators

import java.util.LinkedHashMap
import java.util.Map
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmVisibility
import tools.vitruv.dsls.common.helper.ClassNameGenerator
import tools.vitruv.dsls.reactions.codegen.typesbuilder.TypesBuilderExtensionProvider
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsSegment
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutinesFacade
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRoutinesFacadesProvider
import tools.vitruv.extensions.dslsruntime.reactions.RoutinesFacadeExecutionState
import tools.vitruv.extensions.dslsruntime.reactions.structure.ReactionsImportPath

import static extension tools.vitruv.dsls.reactions.codegen.helper.ClassNamesGenerators.*
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsImportsHelper.*
import static extension tools.vitruv.dsls.reactions.codegen.helper.ReactionsLanguageHelper.*

class RoutinesFacadesProviderClassGenerator extends ClassGenerator {

	val ReactionsSegment reactionsSegment;
	var JvmGenericType generatedClass;

	new(ReactionsSegment reactionsSegment, TypesBuilderExtensionProvider typesBuilderExtensionProvider) {
		super(typesBuilderExtensionProvider)
		if (!reactionsSegment.isComplete) {
			throw new IllegalArgumentException("incomplete");
		}
		this.reactionsSegment = reactionsSegment;
	}

	override generateEmptyClass() {
		generatedClass = reactionsSegment.toClass(reactionsSegment.routinesFacadesProviderClassNameGenerator.qualifiedName) [
			visibility = JvmVisibility.PUBLIC;
		];
	}

	override generateBody() {
		generatedClass => [
			superTypes += typeRef(AbstractRoutinesFacadesProvider);
			members += reactionsSegment.toConstructor()[];

			// create routines facades for the whole reactions import hierarchy:
			members += reactionsSegment.toMethod("createRoutinesFacade", typeRef(AbstractRepairRoutinesFacade)) [
				visibility = JvmVisibility.PUBLIC;
				val reactionsImportPathParameter = generateParameter("reactionsImportPath", typeRef(ReactionsImportPath));
				val sharedExecutionStateParameter = generateParameter("sharedExecutionState", typeRef(RoutinesFacadeExecutionState));
				parameters += reactionsImportPathParameter;
				parameters += sharedExecutionStateParameter;
				body = '''
					switch(«reactionsImportPathParameter.name».getPathString()) {
					«FOR importHierarchyEntry : reactionsSegment.importHierarchyRoutinesFacades.entrySet»
						«val importPath = importHierarchyEntry.key»
						«val routinesFacadeClassNameGenerator = importHierarchyEntry.value»
							case "«importPath.pathString»": {
								return new «routinesFacadeClassNameGenerator.qualifiedName»(this, «reactionsImportPathParameter.name», «sharedExecutionStateParameter.name»);
							}
					«ENDFOR»
						default: {
							return null;
						}
					}
				'''
			]
		]
	}

	// gets the routines facade class name generators for all reactions segments in the routines import hierarchy, including the root segment:
	private static def Map<ReactionsImportPath, ClassNameGenerator> getImportHierarchyRoutinesFacades(ReactionsSegment rootReactionsSegment) {
		val importHierarchyRoutinesFacades = new LinkedHashMap<ReactionsImportPath, ClassNameGenerator>();
		for (importHierarchyEntry : rootReactionsSegment.routinesImportHierarchy.entrySet) {
			// for each reactions segment in the import hierarchy determine the routines facade class of the top-most reactions segment
			// in the import hierarchy overriding routines of it:
			val absoluteImportPath = importHierarchyEntry.key;
			val relativeImportPath = absoluteImportPath.tail; // relative to root segment, null for root segment 
			val currentReactionsSegment = importHierarchyEntry.value;
			val routinesOverrideRoot = rootReactionsSegment.getRoutinesOverrideRoot(relativeImportPath, true);
			var ClassNameGenerator routinesFacadeClassNameGenerator;
			if (routinesOverrideRoot.name.equals(currentReactionsSegment.name)) {
				// no other reactions segment is overriding routines of this reactions segment -> using the original routines facade:
				routinesFacadeClassNameGenerator = currentReactionsSegment.routinesFacadeClassNameGenerator;
			} else {
				// get the overridden routines facade from the override root:
				val overrideRootRelativeImportPath = absoluteImportPath.relativeTo(routinesOverrideRoot.name); // relative to override root
				routinesFacadeClassNameGenerator = routinesOverrideRoot.getOverriddenRoutinesFacadeClassNameGenerator(overrideRootRelativeImportPath);
			}
			importHierarchyRoutinesFacades.put(absoluteImportPath, routinesFacadeClassNameGenerator);
		}
		return importHierarchyRoutinesFacades;
	}
}
