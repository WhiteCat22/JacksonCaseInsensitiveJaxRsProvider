package io.openliberty.ibmi.jaxrs;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */
    @Test
    public void testJsonSerialization() throws JsonGenerationException, JsonMappingException, IOException
    {
        Person person = new Person();
        person.setNAME("Adam");

        ObjectMapper om = new ObjectMapper();
        // om.setPropertyNamingStrategy(new CaseInsensitiveNamingStrategy());
        
        String jsonString = om.writeValueAsString(person);
        System.out.println(jsonString);
        // assertTrue( jsonString.contains("NAME") );
    }

    @Test
    public void testJsonSerializationWithCustomNamingStrategy() throws JsonGenerationException, JsonMappingException, IOException
    {
        Person person = new Person();
        person.setNAME("Adam");

        ObjectMapper om = new ObjectMapper();
        om.setPropertyNamingStrategy(new CaseInsensitiveNamingStrategy());
        
        String jsonString = om.writeValueAsString(person);
        System.out.println(jsonString);
        assertTrue( jsonString.contains("NAME") );
    }
}
