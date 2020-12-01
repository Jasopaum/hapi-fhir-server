# POC - HAPI FHIR Server

In this repo, we are testing the capabilities of HAPI fhir plain server.

## How to run the project

To try this project out:

```
mvn jetty:run
```

- Test that your server is running by fetching its CapabilityStatement:

  http://localhost:8080/metadata

- Try reading back a resource from your server using the following URL:

  http://localhost:8080/Patient/1

- Try queries such as:

  http://localhost:8080/Patient?gender=male
