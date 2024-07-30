# Jackson Case Insensitive JAX-RS Provider

This project is an example of how you can create a custom `PropertyNamingStrategy` to control how Jackson serializes/deserializes json. Included is a JAX-RS `MessageBodyReader`/`MessageBodyWriter` that uses an `ObjectMapper` configured with the custom `PropertyNamingStrategy` to serialize/deserialize JAX-RS payloads.

Additionally, custom Liberty features are included to add the JAX-RS provider to Liberty's runtime rather than including it in all deployed applications directly or including via a shared library.

## Building

Simply execute `mvn install`

## Deploying

Copy `CustomFeature.mf` to `/usr/extension/lib/features`

Copy `target/customjacksonprovider-1.0.jar` to `usr/extension/lib`

Add `<feature>usr:JacksonCaseInsensitiveJaxRsProviderFeature</feature>` to your `server.xml`
```
    <featureManager>
        <feature>jaxrs-1.1</feature>
        <feature>usr:JacksonCaseInsensitiveJaxRsProviderFeature</feature>
    </featureManager>
```