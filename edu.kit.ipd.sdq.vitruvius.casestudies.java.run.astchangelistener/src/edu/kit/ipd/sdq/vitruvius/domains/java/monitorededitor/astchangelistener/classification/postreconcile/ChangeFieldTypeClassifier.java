package edu.kit.ipd.sdq.vitruvius.domains.java.monitorededitor.astchangelistener.classification.postreconcile;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.dom.FieldDeclaration;

import edu.kit.ipd.sdq.vitruvius.domains.java.monitorededitor.changeclassification.events.ChangeClassifyingEvent;
import edu.kit.ipd.sdq.vitruvius.domains.java.monitorededitor.changeclassification.events.ChangeFieldTypeEvent;

public class ChangeFieldTypeClassifier extends ChangeFieldClassifier {

    @Override
    protected ChangeClassifyingEvent classifyChange(IField ifield, FieldDeclaration original, FieldDeclaration changed,
            int line) {
        String originalTypeName = original.getType().toString();
        String changedTypeName = changed.getType().toString();
        if (!originalTypeName.equals(changedTypeName)) {
            return new ChangeFieldTypeEvent(original, changed, line);
        }
        return null;
    }
}
