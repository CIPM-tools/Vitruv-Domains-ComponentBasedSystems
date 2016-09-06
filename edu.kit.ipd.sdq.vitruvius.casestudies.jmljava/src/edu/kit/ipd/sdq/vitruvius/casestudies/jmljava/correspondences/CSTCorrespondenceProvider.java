package edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.correspondences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.correspondences.Java2JMLFileCorrespondenceAdder;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.correspondences.JavaJmlFileMatcher;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.metamodels.JMLMetaModelProvider;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.metamodels.JaMoPPMetaModelProvider;
import edu.kit.ipd.sdq.vitruvius.casestudies.jmljava.vitruvius.changesynchronizer.extensions.CorrespondenceProvider;
import edu.kit.ipd.sdq.vitruvius.framework.correspondence.CorrespondenceModel;
import edu.kit.ipd.sdq.vitruvius.framework.metamodel.Metamodel;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.metamodel.MetamodelManaging;
import edu.kit.ipd.sdq.vitruvius.framework.metamodel.ModelProviding;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;

/**
 * The correspondence provider for code, specifications and tests. It delegates most of the work to
 * <code>CSCorrespondenceProvider</code>.
 */
public class CSTCorrespondenceProvider implements CorrespondenceProvider {

    private static final Logger LOGGER = Logger.getLogger(CSTCorrespondenceProvider.class);
    protected static final List<String> FIRST_MM_EXTENSION = Arrays.asList(JaMoPPMetaModelProvider.EXTENSIONS);
    protected static final List<String> SECOND_MM_EXTENSION = Arrays.asList(JMLMetaModelProvider.EXTENSIONS);
    protected static final VURI FIRST_MM_URI = JaMoPPMetaModelProvider.URI;
    protected static final VURI SECOND_MM_URI = JMLMetaModelProvider.URI;

    @Override
    public void setAllCorrespondences(CorrespondenceModel correspondenceInstance, List<VURI> relevantURIs,
            ModelProviding modelProviding, MetamodelManaging mmManaging) {

        Metamodel mmJava = mmManaging.getMetamodel(FIRST_MM_URI);
        Metamodel mmJml = mmManaging.getMetamodel(SECOND_MM_URI);

        if (correspondenceInstance.getMapping().getMetamodelA() != mmJava
                || correspondenceInstance.getMapping().getMetamodelB() != mmJml) {
            LOGGER.warn("Mapping is in wrong order. Assumed Java2JML. Skipping correspondence generation.");
            return;
        }

        List<VURI> javaURIs = filterRelevantURIsByExtension(FIRST_MM_EXTENSION, relevantURIs);
        List<VURI> jmlURIs = filterRelevantURIsByExtension(SECOND_MM_EXTENSION, relevantURIs);

        JavaJmlFileMatcher javaJmlFM = new JavaJmlFileMatcher(javaURIs, jmlURIs);
        List<Pair<VURI, VURI>> javaJmlCorrespondingFiles = javaJmlFM.findMatchingFiles();

        Java2JMLFileCorrespondenceAdder tmp = new Java2JMLFileCorrespondenceAdder(modelProviding, correspondenceInstance);
        tmp.addCorrespondences(javaJmlCorrespondingFiles);
    }

    /**
     * Filters the given URI by allowed file extensions.
     * 
     * @param extensions
     *            The allowed file extensions.
     * @param uris
     *            The URIs to filter.
     * @return The filtered URIs.
     */
    private List<VURI> filterRelevantURIsByExtension(List<String> extensions, List<VURI> uris) {
        List<VURI> matchedURIs = new ArrayList<VURI>();

        for (VURI uri : uris) {
            if (extensions.contains(uri.getFileExtension())) {
                matchedURIs.add(uri);
            }
        }

        return matchedURIs;
    }

    @Override
    public VURI getFirstMetaModelUri() {
        return FIRST_MM_URI;
    }

    @Override
    public VURI getSecondMetaModelUri() {
        return SECOND_MM_URI;
    }

}
