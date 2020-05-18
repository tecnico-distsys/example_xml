package pt.tecnico.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * DOM stands for Document Object Model
 *
 * This example program reads an XML to a DOM tree in memory and prints it
 *
 */
public class DOMRead {

	public static void main(String[] args) throws Exception {

		// check arguments
		if (args.length != 1) {
			System.err.println("args: (input-file)");
			return;
		}
		final File inputFile = new File(args[0]);

		// Create DocumentBuilder instance.
		// A document build is an XML parser that builds a document tree in memory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		System.out.println("Parsing file " + inputFile + " ...");
		Document document = builder.parse(inputFile);

		System.out.println("DOM tree:");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(System.out));

		System.out.println();
	}

}
