# XML encoding error PoC

## Motivation

Our software needs to process XML files in various encodings. 

While updating to JDK 21, we tried to get rid of the Xerces dependency as it seems to be included in the JDK now. If you `jmod extract` the java.xml module, the `legal/xerces.md` starts with `## Apache Xerces v2.12.2`.

So it looks like Xerces v2.12.2 is included in the JDK. But the behaviour of the version included in the JDK behaves differently than the original with regard to encodings. 

The encoding specified in the XML preamble of a document does not seem to be preserved by the Xerces included in the JDK. Instead, the parsed document is converted to UTF-8 internally.

Parsing the same document using the Xerces 2.12.2 library, the encoding is preserved.

## Reproduction

This project demonstrates the described behaviour. It has two Maven profiles:

 * The default profile parses the document using the JDK Xerces and fails the test
 * The "xerces" profile uses the Xerces 2.12.2 library and passes the test

To see which DocumentBuilder is used, the test prints its class name.
