package edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.vitruvius.changesynchronizer.extensions;

import java.util.List;

import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.VURI;

/**
 * A provider for model URIs. It is not limited to URIs of a particular type of models.
 */
public interface ModelURIProvider {
    
	/**
	 * @return A set of model URIs.
	 */
    List<VURI> getAllRelevantURIs();
    
}
