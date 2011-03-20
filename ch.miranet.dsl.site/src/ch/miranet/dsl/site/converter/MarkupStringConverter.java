package ch.miranet.dsl.site.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

public class MarkupStringConverter extends AbstractLexerBasedConverter<String> {

	private final String startTag;
	private final String endTag;

	protected MarkupStringConverter(String startTag, String endTag) {
		this.startTag = startTag;
		this.endTag = endTag;
	}

	public String getStartTag() {
		return startTag;
	}

	public String getEndTag() {
		return endTag;
	}

	@Override
	protected String toEscapedString(String value) {
		return String.format("%s %s %s", startTag, value, endTag);
	}

	public String toValue(String string, AbstractNode node) {
		if (string == null)
			return null;
		try {
			final String value = string.substring(startTag.length(), string.length() - endTag.length());
			return value.trim();
		} catch (Exception e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}

}
