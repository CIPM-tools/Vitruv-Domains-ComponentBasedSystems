package tools.vitruv.applications.jmljava.helper.java.shadowcopy;

import tools.vitruv.framework.correspondence.CorrespondenceModel;

/**
 * Factory for a {@link ShadowCopy}. This interface can be used in conjunction with Google Guice.
 */
public interface ShadowCopyFactory {

    /**
     * Creates a new instance of {@link ShadowCopy}.
     * 
     * @param ci
     *            The correspondence instance to use for the initialization.
     * @return The new instance.
     */
    ShadowCopy create(CorrespondenceModel ci);

    /**
     * Creates a new instance of {@link ShadowCopy}.
     * 
     * @param ci
     *            The correspondence instance to use for the initialization.
     * @param useJMLCopy
     *            for copying JML models too.
     * @return The new instance.
     */
    ShadowCopy create(CorrespondenceModel ci, boolean useJMLCopy);

}
