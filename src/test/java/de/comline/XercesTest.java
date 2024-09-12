package de.comline;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

class XercesTest {
    @Test
    void readDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        System.out.println("*** DocumentBuilderFactory class: " + factory.getClass().getName());

        factory.setIgnoringElementContentWhitespace(true);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("iso-8859-15.xml")) {
            Document document = builder.parse(input);
            assertEquals("ISO-8859-15", document.getInputEncoding());
        }
    }
}
