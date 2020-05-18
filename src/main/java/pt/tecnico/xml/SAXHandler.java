package pt.tecnico.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

	// override some ContentHandler methods

	public void characters(char buf[], int offset, int len) throws SAXException {

		String s = new String(buf, offset, len);
		System.out.println("characters: '" + s + "'");

	}

	public void startDocument() throws SAXException {

		System.out.println("startDocument");

	}

	public void endDocument() throws SAXException {

		System.out.println("endDocument");

	}

	public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException {

		System.out.println("startElement: " + "namespaceURI '" + namespaceURI + "', simpleName '" + sName
				+ "', qualifiedName '" + qName + "', attributes '...'");

	}

	public void endElement(String namespaceURI, String sName, String qName) throws SAXException {

		System.out.println("endElement: " + "namespaceURI '" + namespaceURI + "', simpleName '" + sName
				+ "', qualifiedName '" + qName + "'");

	}

	// override all ErrorHandler methods

	public void warning(SAXParseException e) throws SAXException {

		System.out.print("warning: ");
		printSAXParseException(e);
		System.out.println();

	}

	public void error(SAXParseException e) throws SAXException {

		System.out.print("error: ");
		printSAXParseException(e);
		System.out.println();

	}

	public void fatalError(SAXParseException e) throws SAXException {

		System.out.print("fatalError: ");
		printSAXParseException(e);
		System.out.println();
		throw e;

	}

	private void printSAXParseException(SAXParseException e) {
		System.out.print("line '" + e.getLineNumber());
		System.out.print("', column '" + e.getColumnNumber());
		System.out.print("', publicId '" + e.getPublicId());
		System.out.print("', systemId '" + e.getSystemId());
		System.out.print("', message '" + e.getMessage() + "'");
		if (e.getException() != null) {
			System.out.print(", exception '" + e.getException().toString());
			System.out.print("', exception message '" + e.getException().getMessage() + "'");
		}

	}

}
