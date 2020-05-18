package pt.tecnico.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX stands for Simple API for XML
 *
 * This example program reads an XML file and generates events from it
 *
 */
public class SAXRead {

	public static void main(String[] args) throws Exception {

		// check arguments
		if (args.length != 1) {
			System.err.println("args: (input-file)");
			return;
		}
		final File inputFile = new File(args[0]);

		// Create SAXParser
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		spfactory.setNamespaceAware(true);
		SAXParser saxparser = spfactory.newSAXParser();

		// Create object that will handle events
		DefaultHandler handler = new SAXHandler();

		// Process XML file
		System.out.println("Parsing file " + inputFile + " ...");
		saxparser.parse(inputFile, handler);
		System.out.println("Done.");
	}

}
