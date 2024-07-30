package io.openliberty.ibmi.jaxrs;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class AppTest 
{

    /* 
     * Test default json serialization.
     */
    @Test
    public void testJsonSerialization() throws JsonGenerationException, JsonMappingException, IOException
    {
        Person person = new Person();
        person.setNAME("Adam");

        ObjectMapper om = new ObjectMapper();
        
        String jsonString = om.writeValueAsString(person);
        System.out.println(jsonString);
        assertTrue( jsonString.contains("name") ); // by default, Jackson lower cases all UPPERCASE variables
    }

    /*
     * Test json serialization with our custom PropertyNamingStrategy
     */
    @Test
    public void testJsonSerializationWithCustomNamingStrategy() throws JsonGenerationException, JsonMappingException, IOException
    {
        Person person = new Person();
        person.setNAME("Adam");

        ObjectMapper om = new ObjectMapper();
        om.setPropertyNamingStrategy(new CaseInsensitiveNamingStrategy());
        
        String jsonString = om.writeValueAsString(person);
        System.out.println(jsonString);
        assertTrue( jsonString.contains("NAME") ); // Jackson shouldn't lowercase UPPERCASE variables with our custom PropertyNamingStrategy
    }
}
