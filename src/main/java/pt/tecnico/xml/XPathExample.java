package pt.tecnico.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample {

	public static void main(String[] args) throws Exception {

		// check arguments
		if (args.length != 1) {
			System.err.println("args: (input-file)");
			return;
		}
		final File inputFile = new File(args[0]);

		// Create DocumentBuilder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		System.out.println("Parsing file " + inputFile + " ...");
		Document document = builder.parse(inputFile);

		// Create XPath object to navigate DOM tree
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xPath = xPathFactory.newXPath();

		// Define namespace context
		xPath.setNamespaceContext(new XPathNamespaceContext());

		// Define XPath expression
		String xPathExpression = "//msg:message[msg:from='Alice']/msg:body/text()";
		System.out.println("XPath expression: " + xPathExpression);

		System.out.println("Compiling expression ...");
		XPathExpression expr = xPath.compile(xPathExpression);

		System.out.println("Evaluating expression ...");
		Object result = expr.evaluate(document, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;

		System.out.println("Results:");
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
	}

}
