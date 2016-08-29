package edu.kit.ipd.sdq.vitruvius.dsls.mapping.api.interfaces;

import edu.kit.ipd.sdq.vitruvius.dsls.mapping.api.MappingExecutionState;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.EChange;

/**
 * Represents a MIR mapping. Concrete implementations are generated by
 * {@link MIRCodeGenerator}.
 * @author Dominik Werle
 *
 */
public interface MappingRealization {
	/**
	 * Applies the mapping.
	 * @param eChange
	 * @param correspondenceModel
	 */
	@Deprecated
	public default void applyEChange(EChange eChange, Blackboard blackboard, MappingExecutionState state) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Returns an ID that is unique for all mapping realizations.
	 * @return
	 */
	public String getMappingID();
}

