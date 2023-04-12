package JavaAPIHomework.service;

import JavaAPIHomework.entity.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

public class MockData {
    public List<Person> getPeople() throws IOException {
        String file = "src/main/resources/person.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        ObjectMapper mapper = new ObjectMapper();
        List<Person> customersFromFile = mapper.readValue(json, new TypeReference<>() {
        });
        return customersFromFile;
    }
}
