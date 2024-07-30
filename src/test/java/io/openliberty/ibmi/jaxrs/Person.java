package io.openliberty.ibmi.jaxrs;

public class Person {

    /*
     * By default, Jackson 1.9 will lowercase this variable when serializing the object.
     * It expects camelCase notation.
     * 
     * https://javadoc.io/static/org.codehaus.jackson/jackson-core-asl/1.9.13/org/codehaus/jackson/map/PropertyNamingStrategy.html
     * 
     * https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html#367
     */
    protected String NAME;

    public void setNAME(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return this.NAME;
    }
}
