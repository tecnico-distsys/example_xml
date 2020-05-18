package pt.tecnico.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * DOM stands for Document Object Model
 *
 * This example program reads an XML to a DOM tree in memory and prints it
 *
 */
public class DOMWrite {

	public static void main(String[] args) throws Exception {

		// check arguments
		if (args.length < 1) {
			System.err.println("args: (input-file) (name) (output-file");
			return;
		}
		final File inputFile = new File(args[0]);
		final String name = args[1];
		final File outputFile = new File(args[2]);

		// Create DocumentBuilder instance.
		// A document build is an XML parser that builds a document tree in memory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		System.out.println("Parsing file " + inputFile + " ...");
		Document document = builder.parse(inputFile);

		// Navigate tree
		for (Node node = document.getDocumentElement().getFirstChild(); node != null; node = node.getNextSibling()) {

			// Find node where new element will be added
			if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("to")) {
				System.out.println("Found node");

				// Create new element
				Text text = document.createTextNode(", " + name);

				// Append new element
				System.out.println("Appending text node ...");
				node.appendChild(text);

				// exit loop
				break;
			}
		}

		System.out.println("Modified DOM tree:");
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(System.out));

		System.out.println();

		System.out.println("Saving result to " + outputFile + " ...");
		transformer.transform(new DOMSource(document), new StreamResult(outputFile));
		System.out.println("Done.");

	}

}
