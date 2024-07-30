# Jackson Case Insensiteve JAX-RS Provider

This project is an example of how you can create a custom `PropertyNamingStrategy` to control how Jackson serializes/deserializes json. Included is a JAX-RS `MessageBodyReader`/`MessageBodyWriter` that uses an `ObjectMapper` configured with the custom `PropertyNamingStrategy` to serialize/deserialize JAX-RS payloads.

Additionally, custom Liberty features are included to add the JAX-RS provider to Liberty's runtime rather than including it in all deployed applications directly or including via a shared library.

## Building

Simply execute `mvn install`
