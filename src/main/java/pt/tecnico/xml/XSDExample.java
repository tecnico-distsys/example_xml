package pt.tecnico.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;

/**
 * XSD stands for XML Schema Definition
 *
 * This example program reads an XML to a DOM tree in memory validating it with
 * a XSD
 *
 */
public class XSDExample {

	public static void main(String[] args) throws Exception {

		// check arguments
		if (args.length < 2) {
			System.err.println("args: (schema-file) (input-file)");
			return;
		}
		final File schemaFile = new File(args[0]);
		final File inputFile = new File(args[1]);

		// Create DocumentBuilder instance.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		System.out.println("Parsing file " + inputFile + " ...");
		Document document = builder.parse(inputFile);

		System.out.println("Loading schema file " + schemaFile + " ...");
		Source schemaSource = new StreamSource(schemaFile);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaSource);

		System.out.println("Validate ...");
		Validator validator = schema.newValidator();
		validator.validate(new DOMSource(document));

		System.out.println("DOM tree:");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(System.out));

		System.out.println();
	}

}
