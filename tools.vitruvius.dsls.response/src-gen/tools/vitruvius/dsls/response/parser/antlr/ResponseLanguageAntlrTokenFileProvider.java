/*
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ResponseLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("tools.vitruvius/dsls/response/parser/antlr/internal/InternalResponseLanguage.tokens");
	}
}
