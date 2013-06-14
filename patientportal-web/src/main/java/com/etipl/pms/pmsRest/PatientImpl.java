

package com.etipl.pms.pmsRest;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etipl.osgi.dto.PatientInfo;
import com.etipl.pms.Utilities.PMSGUIUtilities;

import com.etipl.pms.dto.PatientSearchTO;
import com.etipl.pms.ejb.LoginEJBIf;
import com.etipl.pms.ejb.PatientEJBIf;
import com.etipl.pms.entity.AppointmentType;
import com.etipl.pms.entity.Facility;
import com.etipl.pms.entity.Patient;
import com.etipl.pms.entity.PatientApptRequest;
import com.etipl.pms.entity.PatientInsurance;
import com.etipl.pms.entity.Resource;
import com.etipl.pms.entity.Section;
import com.etipl.pms.entity.TypeItems;
import com.etipl.pms.entity.Users;
import com.etipl.pms.utilities.PMSUtilities;
import com.etipl.pms.utilities.StringUtils;
@Stateless

public class PatientImpl implements PatientIf{

	private static final Logger logger = LoggerFactory.getLogger(PatientImpl.class);
	
	@EJB
	private PatientEJBIf pmif;
	
	/**
     * Search a record from the values provided.  Return a JSON OR XML response with either
     * 200 ok, and related errors.
     * @param patLastName,patFirstName,patGender,patDOB,patSSN,patPhone,insuranceId,status 
     * @return Collection of all the records
     */
	@Override
	public PatientMasters getPatientMasterData(
			String patLastName,
			String patFirstName,
			String patGender,
			String patDOB,
			String patSSN,
			String patPhone,
			String insuranceId,
			String status,
			String facility) {
		
			PatientMasters patientMasters = null;
			try{
				logger.info("Entered getPatientMasterData");
						Patient patient = new Patient();
						
						patient.setLastName(patLastName);
						patient.setFirstName(patFirstName);
						if(!StringUtils.isNullOrBlank(patGender)){
							if(!patGender.equalsIgnoreCase("-1")){
								logger.info("Gender :"+patGender);
								patient.setSex(patGender);
							}
						}
						patient.setDob(PMSGUIUtilities.getDateFromString(patDOB));
						patient.setSsn(patSSN);
						patient.setPhone(patPhone);						
					
						if(!StringUtils.isNullOrBlank(status) && !status.equalsIgnoreCase("B")){						
							patient.setStatus(status);
						}
						PatientInsurance patientInsurance = null;
						if(!StringUtils.isNullOrBlank(insuranceId) && !insuranceId.equalsIgnoreCase("-1")){						
							patientInsurance = new PatientInsurance();
							patientInsurance.setInsuranceCompanyId(insuranceId);
						}
						Facility fac = null;
						if(facility != null){
							if(!facility.equalsIgnoreCase("-1")){
								fac  = new Facility();							
								fac.setId(Integer.parseInt(facility.split(",")[0])); /** splitting id and timezone **/
								patient.setFacilityId(fac);
							}
						}
										
				Collection<PatientSearchTO> lstPatient = pmif.getPatientMaster(patient,patientInsurance);
				int patientSize = lstPatient.size();
				Collection<PatientMaster> patMasr = new ArrayList<PatientMaster>(patientSize);
				if(lstPatient != null){
					patientMasters = new PatientMasters();
									
					for(PatientSearchTO pat:lstPatient){
						PatientMaster pm = new PatientMaster();
											
						String patientName = "";
						if(!StringUtils.isNullOrBlank(pat.getLastName())){
							patientName = pat.getLastName();
						}
						if(!StringUtils.isNullOrBlank(pat.getFirstName())){
							patientName = patientName +", "+pat.getFirstName();
						}
						if(!StringUtils.isNullOrBlank(pat.getMiddleName())){
							patientName = patientName+" "+pat.getMiddleName();
						}	
						
						pm.setLastName(patientName);
						
						if(!StringUtils.isNullOrBlank(pat.getSex())){
							if(pat.getSex().equalsIgnoreCase("M")){
								pat.setSex("Male");
							}
							if(pat.getSex().equalsIgnoreCase("F")){
								pat.setSex("Female");							
														}
							if(pat.getSex().equalsIgnoreCase("U")){
								pat.setSex("Unknown");
							}
							pm.setSex(pat.getSex());
						}
						if(pat.getFacility() != null){
							pm.setFacilityId(pat.getFacility().getFacilityName());/** id field is used as name **/			
							logger.info("FacilityName:"+pat.getFacility().getFacilityName());
						}
						if(!StringUtils.isNullOrBlank(pat.getDob())){
							pm.setDob(pat.getDob());
						}
						pm.setSsn(pat.getSsn());
						pm.setPhone(pat.getPhone());
						pm.setId(pat.getId());
						pm.setHref("pmsRest/patientsDetail/"+pm.getId()) ;
						pm.setPatientInsuranceId(pat.getPatientInsuranceId());
						pm.setStatus(pat.getStatus());
						
						patMasr.add(pm);
					}
					
				}
				
				patientMasters.setiTotalDisplayRecords(patientSize);
				patientMasters.setiTotalRecords(patientSize);
				patientMasters.setPatientMaster(patMasr);
				logger.info("End getPatientMasterData");
			}catch(Exception e){		
				logger.info("Exception getPatientMasterData");
				throw new WebApplicationException(Response.serverError().build());
			}
			return patientMasters;
	}

	/**
     * Gets a record from the id value provided. Return a JSON OR XML response with either
     * 200 ok, and related errors.
     * @param id of clicked row
     * @return All the columns for clicked row
     */
	@Override
	public PatientMaster getPatientMaster(int id) {
		PatientMaster patientMaster = null;
		try{
			logger.info("Entered getPatientMaster");
			Patient pm = pmif.getPatientDataById(id);			
			
			String patientName = "";
			if(!StringUtils.isNullOrBlank(pm.getLastName())){
				patientName = pm.getLastName();
			}
			if(!StringUtils.isNullOrBlank(pm.getFirstName())){
				patientName = patientName +", "+pm.getFirstName();
			}
			if(!StringUtils.isNullOrBlank(pm.getMiddleName())){
				patientName = patientName+" "+pm.getMiddleName();
			}	
			
			
			patientMaster = new PatientMaster();
			
			patientMaster.setLastName(patientName);
			patientMaster.setSex(pm.getSex());
			patientMaster.setDob(PMSGUIUtilities.getMysqlOnlyDatetoGUI(pm.getDob()+""));
			patientMaster.setSsn(pm.getSsn());
			patientMaster.setId(pm.getId());
			patientMaster.setPhone(pm.getPhone());
			
						
			logger.info("End getPatientMaster");
		}catch(Exception e){
			logger.error("Exception getPatientMaster",e.getMessage());
			throw new WebApplicationException(Response.serverError().build());
		}		
		return patientMaster;
	}
	
	/**
     * Gets a record from the id value provided. Return a JSON OR XML response with either
     * 200 ok, and related errors.
     * @param id of clicked row, facilityId
     * @return All the columns for clicked row
     */
	@Override
	public PatientMasters getPatientList(String patLastName, int facilityId){
		
		PatientMasters patientMasters = new PatientMasters();
		logger.info("rest facility id "+facilityId);
		List<PatientInfo> lstresponse = pmif.getVistAPatients(patLastName, facilityId);
		try{
			Collection<PatientMaster> patMasr = new ArrayList<PatientMaster>(lstresponse.size());
			
			for(int i=0;i<lstresponse.size();i++){
				
				PatientMaster pm = new PatientMaster();
				pm.setLastName(lstresponse.get(i).getPatName());
				pm.setHref("pmsRest/vistapatients/"+Integer.parseInt(lstresponse.get(i).getPatDFN())+"/"+facilityId);
				pm.setPatientDfn(Integer.parseInt(lstresponse.get(i).getPatDFN()));
				patMasr.add(pm);
				
			}
			
			patientMasters.setiTotalDisplayRecords(lstresponse.size());
			patientMasters.setiTotalRecords(lstresponse.size());
			patientMasters.setPatientMaster(patMasr);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return patientMasters;
	}	
	
	public PatientMaster getPatientDetail(int patid,int facid){
		PatientMaster pm = new PatientMaster();
		Patient p = pmif.getPatientDetail(patid, facid);
		//pm.setId(p.getPatientDfn());
		logger.info("dfn set");
		pm.setLastName(p.getLastName());
		pm.setFirstName(p.getFirstName());
		pm.setId(p.getPatientDfn());
		pm.setHrn(p.getHrn());
		pm.setDob(PMSUtilities.getStringDateOnlyFromDate(p.getDob()));
		pm.setSsn(p.getSsn());
		pm.setSex(p.getSex());
		pm.setFacilityId(facid+"");
		
		return pm;
	}
	
	
	/**
     * Add a record from the values provided. Return a JSON OR XML response with either
     * 200 ok, and related errors.
     * @param patDFN, facilityId
     * @return String
     */
	@EJB
	private LoginEJBIf loginejbif;
	@Override
	public String addPatientMaster(HttpServletRequest req, int patDFN, int facilityId,String lastName, String firstName, String dob, String gender, String ssn){
		logger.info("rest (patient dfn)"+patDFN);
		
		Principal p = req.getUserPrincipal();
		String userName=p.getName();
		int userId=loginejbif.getUserId(userName);
		String str = pmif.addPatient(patDFN, facilityId, lastName, firstName, dob, gender, ssn, userId);
		return str;
	}
	
	/******************************Added by Sumit*********************************/
	/**
     * Gets a record patient login record. Return a JSON OR XML response with either 200 ok, and related errors.
     * @param userName, password
     * @return int
     */
	@Override
	public int getPatientLoginData(String userName, String password){
		PatientMaster pm = new PatientMaster();
		PatientSearchTO pst = new PatientSearchTO();
		pst.setUsername(userName);
		pst.setPassword(password);
		
		Collection<PatientSearchTO> lstObj = pmif.patientLogin(pst);
		
		if(lstObj == null)
		{
			return 0;
		}
		
		Collection<PatientMaster> patientMaster = new ArrayList<PatientMaster>(lstObj.size());
		
		
		
		for(PatientSearchTO p : lstObj)
		{
			pm.setLastName(p.getLastName()+", "+pm.getFirstName()+" "+pm.getMiddleName());
			pm.setSsn(p.getSsn());
			pm.setDob(p.getDob());
			pm.setId(p.getId());
			
			patientMaster.add(pm);
		}
		
		return pm.getId(); 
	}

	@Override
	public String addPatientRequest(int id,int top,int fac,int service,int section,int resource,int apptType,
			String date,String time,String remarks,int complaint) 
	{
		PatientApptRequest pst =new PatientApptRequest();
		
		String fromDate = date+" "+time;
		
		Facility f = new Facility();
		f.setId(fac);
		Section sec = new Section();
		sec.setId(section);
		Resource r = new Resource();
		r.setId(resource);
		AppointmentType apt = new AppointmentType();
		apt.setId(apptType);
		TypeItems ti = new TypeItems();
		ti.setId(complaint);
		
		pst.setId(id);
		pst.setFacilityId(f);
		pst.setSectionId(sec);
		pst.setResourceId(r);
		pst.setApptTypeId(apt);
		pst.setRemarks(remarks);
		pst.setToTime(PMSUtilities.getDateTimeFromString(PMSUtilities.getToTime(fromDate, apt.getApptTypeDuration())));
		pst.setFromTime(PMSUtilities.getDateTimeFromString(fromDate));
		pst.setChiefComplaint(ti);
		
		pmif.addPatientReq(pst);
		
		
		
		return null;
	}

	@Override
	public int getPatientRequestData(int id,int top,int fac,int service,int section,int resource,int apptType, String date, String time,
			                         int complaint) {
		
		PatientSearchTO pst =new PatientSearchTO();
		
			pst.setId(id);
			pst.setFac(fac);
			pst.setService(service);
			pst.setSection(section);
			pst.setResource(resource);
			pst.setApptType(apptType);
			pst.setDate(date);
			pst.setTime(time);
			pst.setComplaint(complaint);
			
			Collection<PatientApptRequest> lstObj = pmif.searchPatientReq(pst);
			
			if(lstObj == null)
			{
				return 0;
			}
			
			Collection<PatientMaster> patientMaster = new ArrayList<PatientMaster>(lstObj.size());
			
			for(PatientApptRequest p : lstObj)
			{
				PatientMaster pat = new PatientMaster();
				
				Facility f = new Facility();
				TypeItems ti = new TypeItems();
				pat.setFromTime(p.getFromTime().toString());
				pat.setToTime(p.getToTime().toString());
				pat.setComplaint(p.getChiefComplaint().getDescription());
				pat.setFacilityId(p.getFacilityId().getFacilityName());
				patientMaster.add(pat);
			}
			
			
		
		return 0;
	}
	
	/***********************************************************************************/
}
