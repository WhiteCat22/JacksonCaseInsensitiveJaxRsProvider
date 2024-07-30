package io.openliberty.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Consumes({MediaType.APPLICATION_JSON, "text/json"})
@Produces({MediaType.APPLICATION_JSON, "text/json"})
public class CustomJacksonJsonProvider extends JacksonJsonProvider {

    protected ObjectMapper om = new ObjectMapper();

    CustomJacksonJsonProvider() {
        super();
        om.setPropertyNamingStrategy(new CaseInsensitiveNamingStrategy());
        setMapper(om);
    }
}
