package com.github.jbeullen.openapigeneratorissue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openapitools.client.model.Animal;
import org.openapitools.client.model.Cat;

public class MapMultipleSpeciesToCatTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testMapTigerToCat() throws JsonProcessingException {
        final Cat tiger = new Cat();
        tiger.setSpecies("Tiger");
        tiger.setName("Tigger");
        tiger.color("yellow with stripes");

        final String s = mapper.writeValueAsString(tiger);

        final Animal animal = mapper.readValue(s, Animal.class);

        Assertions.assertThat(animal).isInstanceOf(Cat.class);
        Assertions.assertThat(animal.getSpecies()).isEqualTo("Tiger");
    }

    @Test
    public void testMapTigerToJson() throws JsonProcessingException {
        final Cat tiger = new Cat();
        tiger.setSpecies("Tiger");
        tiger.setName("Tigger");
        tiger.color("yellow with stripes");

        final String s = mapper.writeValueAsString(tiger);
        Assertions.assertThat(s).contains("\"species\":\"Tiger\"");
    }
}
