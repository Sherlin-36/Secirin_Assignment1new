package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {

    public static void main(String[] args) {
        try {
            // 1. JSON Mapper
            ObjectMapper jsonMapper = new ObjectMapper();

            // 2. Load JSON file from resources
            File jsonFile = new File("src/main/resources/input.json");

            // 3. Read JSON as JsonNode
            JsonNode jsonNode = jsonMapper.readTree(jsonFile);

            // 4. XML Mapper
            XmlMapper xmlMapper = new XmlMapper();

            // 5. Convert JSON to XML String
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // 6. Print XML
            System.out.println("Generated XML:\n" + xml);

            // 7. Write XML to a new file
            File xmlFile = new File("src/main/resources/output.xml");
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, jsonNode);

            System.out.println("XML file created at: " + xmlFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}