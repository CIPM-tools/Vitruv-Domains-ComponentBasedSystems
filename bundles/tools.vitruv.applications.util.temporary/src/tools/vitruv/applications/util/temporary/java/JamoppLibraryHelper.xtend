package tools.vitruv.applications.util.temporary.java

import org.emftext.language.java.JavaClasspath
import org.eclipse.emf.common.util.URI
import java.nio.file.Path

/**
 * This helper class allows to load the Java standard library in JaMoPP also with
 * Java versions 9 and above.
 * In Java 9 the boot classpath was removed and the standard library is packaged
 * differently, which is corrected by this patch.
 */
class JamoppLibraryHelper {
	/**
	 * Registers the Java standard library. In case of Java 8 and below, this is the deployed standard library.
	 * In case of Java 9 and above, this is the "java.base" module. Further modules can be registered with
	 * the {@link #registerStdLibraryModule} method.
	 */
	static def void registerStdLib() {
		JavaClasspath.get().registerStdLib();
	}

	/**
	 * Registers the Java standard library module with the given name.
	 * This may only be called when using Java in version 9 or above.
	 * Otherwise, it will throw an {@link IllegalStateException}.
	 * @param name - the name of the module to register
	 */
	static def void registerStdLibraryModule(String name) {
		JavaClasspath.get().registerStdLib();
	}

	/**
	 * Registers the library placed at the given path to. The library must
	 * be an archive (like a ".jar" file) directly containing the package structure
	 * to be imported.
	 * @param pathToLibrary - the path to the library to register
	 */
	static def void registerLocalLibrary(Path pathToLibrary) {
		JavaClasspath.get().registerZip(URI.createFileURI(pathToLibrary.toString));
	}

}
