package pt.tecnico.xml;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

public class XPathNamespaceContext implements NamespaceContext {

	public String getNamespaceURI(String prefix) {
		if (prefix == null)
			throw new NullPointerException("Null prefix");
		else if ("msg".equals(prefix))
			return "urn:mydomain:message";
		else if ("schema".equals(prefix))
			return "http://www.w3.org/2001/XMLSchema-instance";
		else if ("xml".equals(prefix))
			return XMLConstants.XML_NS_URI;
		return XMLConstants.NULL_NS_URI;
	}

	// This method is not necessary for XPath processing.
	public String getPrefix(String uri) {
		throw new UnsupportedOperationException();
	}

	// This method is not necessary for XPath processing either.
	public Iterator<String> getPrefixes(String uri) {
		throw new UnsupportedOperationException();
	}

}
