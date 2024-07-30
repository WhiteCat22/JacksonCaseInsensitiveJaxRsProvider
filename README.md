# Jackson Case Insensitive JAX-RS Provider

This project is an example of how you can create a custom `PropertyNamingStrategy` to control how Jackson serializes/deserializes json.

It is also an example of how you can configure a JAX-RS `MessageBodyReader`/`MessageBodyWriter` that uses Jackson's `ObjectMapper` configured with the custom `PropertyNamingStrategy` to serialize/deserialize JAX-RS payloads.

Additionally, a custom Liberty feature is included with instructions on how to add the JAX-RS provider to Liberty's runtime rather than including it in all deployed applications directly or including it via a shared library.

## Building

Simply execute `mvn install`

## Deploying

Copy `JacksonCaseInsensitiveJaxRsProviderFeature.mf` to `/usr/extension/lib/features`

Copy `target/customjacksonprovider-1.0.jar` to `usr/extension/lib`

Add `<feature>usr:JacksonCaseInsensitiveJaxRsProviderFeature</feature>` to your `server.xml`
```
    <featureManager>
        <feature>jaxrs-1.1</feature> <!-- note: applicable to `jaxrs-2.0` as well -->
        <feature>usr:JacksonCaseInsensitiveJaxRsProviderFeature</feature>
    </featureManager>
```

## Modifying

It is important that the `Subsystem-Content` in your feature file (`JacksonCaseInsensitiveJaxRsProviderFeature.mf`) matches the `Bundle-SymbolicName` in your `MANIFEST.MF`.

For this project I use the `org.apache.felix:maven-bundle-plugin` and `<packaging>bundle</packaging>` in the `pom.xml` to set the header.

Feature:
```
Subsystem-Content: JacksonCaseInsensitiveJaxRsProvider;version="1.0.0"
```

`MANIFEST.MF`:
```
Bundle-SymbolicName: JacksonCaseInsensitiveJaxRsProvider
Bundle-Version: 1.0.0
```

`pom.xml`:
```
  <groupId>io.openliberty.jaxrs</groupId>
  <artifactId>customjacksonprovider</artifactId>
  <version>1.0</version>
  <packaging>bundle</packaging>

...

      <plugin>
        <groupId>org.apache.felix</groupId>
        <artifactId>maven-bundle-plugin</artifactId>
        <version>5.1.9</version>
        <extensions>true</extensions>
        <configuration>
          <instructions>
                <!-- This is how we set the Bundle-SymbolicName in the MANIFEST.MF -->
                <Bundle-SymbolicName>JacksonCaseInsensitiveJaxRsProvider</Bundle-SymbolicName>
                <Bundle-Version>1.0.0</Bundle-Version>
            </instructions>
        </configuration>
      </plugin>
```