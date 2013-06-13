package com.etipl.pms.ejb;

import java.util.Collection;
import java.util.List;

import com.etipl.osgi.dto.PatientInfo;
import com.etipl.pms.dto.PatientSearchTO;
import com.etipl.pms.entity.Patient;
import com.etipl.pms.entity.PatientApptRequest;
import com.etipl.pms.entity.PatientInsurance;



public interface PatientEJBIf {
	/**
	 * To get the list of Patient(s) by criteria
	 * @param patient
	 * @return Collection<PatientSearchTO>
	 */
	public Collection<PatientSearchTO> getPatientMaster(Patient patient,PatientInsurance patientInsurance);
	
	/**
	 * To get the Patient record by ID
	 * @param patientId
	 * @return Patient
	 */
	public Patient getPatientDataById(int patientId);
	
	/**
	 * To get the list of Patient Insurance
	 * @param No parameter
	 * @return Collection<PatientInsurance>
	 */
	public Collection<PatientInsurance> getPatientInsurance();
	
	/**
	 * To get the list of Patient Insurance
	 * @param search
	 * @param facilityId
	 * @return List<PatientInfo>
	 */
	public List<PatientInfo> getVistAPatients(String search, int facilityId);
	
	/**
	 * Execute query to get patient detail from VistA by dfn
	 * 
	 * @param patDFN
	 * @param facilityId
	 * @return Patient
	 */	
	public Patient getPatientDetail(int patDFN, int facilityId);
	
	/**
	 * To add the Patient details by getting the records from VistA using DFN
	 * @param patDFN
	 * @param facilityId
	 * @return String
	 */	
	public String addPatient(int patDFN, int facilityId, String lastName, String firstName, String dob, String gender, String ssn, int userId);
	
	
	/******************************Added by Sumit******************************/
	/**
	 * To Check the Patient login by username and password
	 * @param username
	 * @param password
	 * @return int
	 */	
	public Collection<PatientSearchTO> patientLogin(PatientSearchTO pst);
	
	/**
	 * To Add the Patient request
	 * @param PatientApptRequest
	 */
	public void addPatientReq(PatientApptRequest pst);
	
	/**
	 * To Search the Patient request
	 * @param PatientSearchTO
	 * @return 
	 */
	public Collection<PatientApptRequest> searchPatientReq(PatientSearchTO pst);
	
	/*************************************************************************/
}
