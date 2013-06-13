package com.etipl.pms.pmsRest;

import java.util.Date;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;


@Path("/")

public interface PatientIf {
	
	@GET
	@Path("/patientsDetail")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PatientMasters getPatientMasterData(
			 @QueryParam("patLastName") String patLastName
			,@QueryParam("patFirstName") String patFirstName
			,@QueryParam("patGender") String patGender
			,@QueryParam("patDOB") String patDOB
			,@QueryParam("patSSN") String patSSN
			,@QueryParam("patPhone") String patPhone
			,@QueryParam("insuranceId") String insuranceId
			,@QueryParam("status") String status
			,@QueryParam("cmbPSMedFacility") String facility
			);
	
	@GET
	@Path("/patientsDetail/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PatientMaster getPatientMaster(@PathParam("id") int id);
	
	
	
	@GET
	@Path("/vistapatients")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})	
	public PatientMasters getPatientList(@QueryParam("patLastName") String patLastName, @QueryParam("facilityId") int facilityId);

	
	@GET
	@Path("/vistapatients/{patid}/{facid}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})	
	public PatientMaster getPatientDetail(@PathParam("patid") int patid, @PathParam("facid") int facid);
	
	@POST
	@Path("/vistapatients")
	//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String addPatientMaster(@Context HttpServletRequest req,
						@QueryParam("patDFN") int patDFN, 
								@QueryParam("facilityId") int facilityId,
								@QueryParam("lastName") String lastName,
								@QueryParam("firstName") String firstName,
								@QueryParam("dob") String dob,
								@QueryParam("gender") String gender,
								@QueryParam("ssn") String ssn);		
			
/***************************Added by Sumit****************************/
	
	@GET
	@Path("/patientLogin}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int getPatientLoginData(@QueryParam("userName") String userName,
										  @QueryParam("password") String password);
	
	@POST
	@Path("/patientReq")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String addPatientRequest(@QueryParam("id") int id, 
								@QueryParam("top") int top, 
								@QueryParam("fac") int fac,
								@QueryParam("service") int service,
								@QueryParam("section") int section,
								@QueryParam("resource") int resource,
								@QueryParam("apptType") int apptType,
								@QueryParam("date") String date,
								@QueryParam("time") String time,
								@QueryParam("remarks") String remarks,
								@QueryParam("complaint") int complaint);
	
	@GET
	@Path("/patientReqData}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public int getPatientRequestData(@QueryParam("id") int id, 
			@QueryParam("top") int top, 
			@QueryParam("fac") int fac,
			@QueryParam("service") int service,
			@QueryParam("section") int section,
			@QueryParam("resource") int resource,
			@QueryParam("apptType") int apptType,
			@QueryParam("date") String date,
			@QueryParam("time") String time,
			@QueryParam("complaint") int complaint);
	
	/**************************************************************/
	
}
