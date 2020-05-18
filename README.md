# XML example

This is a Java application that contains several XML examples.
Each example has its own main method.

The SAXRead example reads an XML file using a SAX parser that generates events.
SAX is the low level of XML parsers and is used by DOM.

The DOMRead example reads an XML file to a DOM tree in memory and prints it.

The DOMWrite example reads an XML file, adds a text node to it, 
and saves the result in a new file.

The XSDExample reads an XML file to a DOM tree in memory.
Next it reads an XSD file and uses it to validate the first document.

XML parsing checks if a document is well-formed.
XSD validation checks if a document is valid 
i.e. has a specific format dictated by the schema.

The XPath example reads an XML file to a DOM tree 
and then creates an XPath expression to navigate in it
and prints the results.



## Maven instructions

To compile the source code:

```
mvn compile
```

To run the default example:

```
mvn exec:java
```

To list available profiles (one for each example):

```
mvn help:all-profiles
```

To run a specific example, select the profile with -P:

```
mvn exec:java -P xpath
```

## To configure the Maven project in Eclipse

'File', 'Import...', 'Maven'-'Existing Maven Projects'

'Select root directory' and 'Browse' to the project base folder.

Check that the desired POM is selected and 'Finish'.


----

[SD Faculty](mailto:leic-sod@disciplinas.tecnico.ulisboa.pt)
