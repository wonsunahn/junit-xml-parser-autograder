package org.openmbee.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.openmbee.junit.model.JUnitTestSuite;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.net.URL;

class IntegrationTest {

    @Test
    @DisplayName("Test unmarshalling of JUnit report")
    void testUnmarshalling() throws Exception {
        URL resource = getClass().getClassLoader().getResource("org/openmbee/junit/report.xml");
        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources!");
        }
        File file = new File(resource.toURI());
        FileInputStream fileInputStream = new FileInputStream(file);
        // FileInputStream fileInputStream = new FileInputStream(Paths.get("/org/openmbee/junit/report.xml").toFile());
        JUnitTestSuite testSuite = JUnitMarshalling.unmarshalTestSuite(fileInputStream);
        // Then: Assert the result
        assertNotNull(testSuite, "The JUnit test suite should be loaded.");
    }
}
