package ca.uhn.example.provider;

import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import java.util.*;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.IdType;

public class OrganizationResourceProvider implements IResourceProvider {

  /**
   * The getResourceType method comes from IResourceProvider, and must be overridden to indicate what type of resource this provider supplies.
   */
  @Override
  public Class<Organization> getResourceType() {
    return Organization.class;
  }

  /**
   * The "@Read" annotation indicates that this method supports the read operation. It takes one argument, the Resource type being returned.
   *
   * @param theId
   *            The read operation takes one parameter, which must be of type IdDt and must be annotated with the "@Read.IdParam" annotation.
   * @return Returns a resource matching this identifier, or null if none exists.
   */
  @Read
  public Organization getResourceById(@IdParam IdType theId) {
    /*
     * We only support one Organization, so the follwing
     * exception causes an HTTP 404 response if the
     * ID of "1" isn't used.
     */

    if (!"1".equals(theId.getIdPart())) {
      throw new ResourceNotFoundException(theId);
    }
    Organization retVal = new Organization();
    retVal.setId("1");
    retVal
      .addIdentifier()
      .setSystem("urn:example:orgs")
      .setValue("FooOrganization");
    retVal.addAddress().addLine("123 Fake Street").setCity("Toronto");
    retVal.addTelecom().setUse(ContactPointUse.WORK).setValue("1-888-123-4567");

    return retVal;
  }

  @Search
  public List<Organization> findOrganizationsUsingArbitraryCtriteria() {
    LinkedList<Organization> retVal = new LinkedList<Organization>();

    return retVal;
  }
}
