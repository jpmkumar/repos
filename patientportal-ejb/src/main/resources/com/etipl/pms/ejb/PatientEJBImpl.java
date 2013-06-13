package com.etipl.pms.ejb;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etipl.osgi.dto.PatientInfo;
import com.etipl.osgi.service.CommonIf;
import com.etipl.osgi.service.CommonImpl;
import com.etipl.pms.dto.PatientSearchTO;
import com.etipl.pms.entity.Facility;
import com.etipl.pms.entity.Patient;
import com.etipl.pms.entity.PatientApptRequest;
import com.etipl.pms.entity.PatientInsurance;
import com.etipl.pms.entity.Users;
import com.etipl.pms.utilities.PMSUtilities;
import com.etipl.pms.utilities.StringUtils;

@Stateless
public class PatientEJBImpl implements PatientEJBIf {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientEJBImpl.class);

	@PersistenceContext(unitName = "pmsUnit")
	EntityManager em = null;
	
	@EJB
	private FacilityMasterIf facif;

	/**
	 * Execute query to search a record from the values provided.
	 * 
	 * @param patient
	 * @param patientInsurance
	 * @return Collection<PatientSearchTO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<PatientSearchTO> getPatientMaster(Patient patient,
			PatientInsurance patientInsurance) {
		Collection<PatientSearchTO> lstPatient = null;
		Collection<Object[]> lstObject = null;

		try {
			logger.info("Entered getPatientMaster");

			StringBuilder sb = new StringBuilder();

			sb.append("select p.id,p.lastName,p.firstName,p.middleName,p.dob,p.sex,p.ssn,"
					+ " p.phone,p.status,concat(pi.insuranceCompanyId,'(',pi.insuranceType,')')");
			sb.append(" from Patient p left join p.patientInsuranceCollection pi with pi.status='A'");
			if (patientInsurance == null) { // To show only Primary insurance
				sb.append(" and pi.insuranceType like 'P'");
			}

			sb.append(" where 1=1 ");
			if (patientInsurance != null) {
				sb.append(" and pi.insuranceCompanyId = '"
						+ patientInsurance.getInsuranceCompanyId() + "'");
			}
			if (!StringUtils.isNullOrBlank(patient.getLastName())) {
				sb.append(" AND p.lastName like '" + patient.getLastName()
						+ "%'");
			}
			if (!StringUtils.isNullOrBlank(patient.getFirstName())) {
				sb.append(" AND p.firstName like '" + patient.getFirstName()
						+ "%'");
			}
			if (!StringUtils.isNullOrBlank(PMSUtilities
					.getStringDatefromDate(patient.getDob()))) {
				sb.append(" AND p.dob like ?");
			}
			if (!StringUtils.isNullOrBlank(patient.getSex())) {
				sb.append(" AND p.sex like '" + patient.getSex() + "%'");
			}
			if (!StringUtils.isNullOrBlank(patient.getSsn())) {
				sb.append(" AND p.ssn like '" + patient.getSsn() + "%'");
			}
			if (!StringUtils.isNullOrBlank(patient.getPhone())) {
				sb.append(" AND p.phone like '" + patient.getPhone() + "%'");
			}
			if (patient.getFacilityId() !=null && patient.getFacilityId().getId()>0) {
				sb.append(" AND p.facilityId = " + patient.getFacilityId().getId() );
			}

			sb.append(" AND p.status like ?");

			Query q = em.createQuery(sb.toString());

			logger.info("Test query:" + sb.toString());

			int parameterIndex = 1;

			if (!StringUtils.isNullOrBlank(PMSUtilities
					.getStringDatefromDate(patient.getDob()))) {
				q.setParameter(parameterIndex, patient.getDob(),
						TemporalType.DATE);
				parameterIndex++;
			}

			if (!StringUtils.isNullOrBlank(patient.getStatus())) {
				q.setParameter(parameterIndex, patient.getStatus());
			} else {
				q.setParameter(parameterIndex, "A");
			}

			lstObject = q.getResultList();
			logger.info("Entering patient info length:", lstObject.size());

			if (lstObject != null) {
				lstPatient = new LinkedList<PatientSearchTO>();

				for (Object[] result : lstObject) {
					logger.info("Entering patient info");

					PatientSearchTO pat = new PatientSearchTO();

					pat.setId((Integer) result[0]);

					if (result[1] != null) {
						pat.setLastName(result[1].toString());
					}
					if (result[2] != null) {
						pat.setFirstName(result[2].toString());
					}
					if (result[3] != null) {
						pat.setMiddleName(result[3].toString());
					}

					if (result[4] != null) {
						pat.setDob(PMSUtilities.getMysqlOnlyDatetoGUI(result[4]
								+ ""));
					}

					if (result[5] != null) {
						pat.setSex(result[5].toString());
					}

					if (result[6] != null) {
						pat.setSsn(result[6].toString());
					}

					if (result[7] != null) {
						pat.setPhone(result[7].toString());
					}
					if (result[8] != null) {
						pat.setStatus(result[8].toString());
					}

					if (result[9] != null) {
						pat.setPatientInsuranceId(result[9] + "");
					}

					lstPatient.add(pat);
				}
			}
			logger.info("End getPatientMaster");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception getPatientMaster", e);
		}
		return lstPatient;
	}

	/**
	 * Execute query to get patient insurance
	 * 
	 * @param Nothing
	 * @return Collection<PatientInsurance>
	 */
	@Override
	public Collection<PatientInsurance> getPatientInsurance() {
		Collection<PatientInsurance> patientInsurance = null;
		try {
			logger.info("Entered getPatientInsurance");

			TypedQuery<PatientInsurance> q = em
					.createQuery(
							"select pi from PatientInsurance pi GROUP BY pi.insuranceCompanyId ORDER BY pi.insuranceCompanyId",
							PatientInsurance.class);
			patientInsurance = q.getResultList();

			logger.info("End getPatientInsurance");
		} catch (Exception e) {
			logger.error("Exception getPatientInsurance", e);
		}
		return patientInsurance;
	}

	/**
	 * Execute query to get patient details by Id
	 * 
	 * @param Noting
	 * @return Collection<PatientInsurance>
	 */
	@Override
	public Patient getPatientDataById(int patientId) {
		Patient patient = null;
		try {
			logger.info("Entered getPatientDataById");

			Query q = em.createQuery("select p from Patient p where p.id = ?");

			q.setParameter(1, patientId);
			patient = (Patient) q.getSingleResult();

			logger.info("End getPatientDataById");
		} catch (Exception e) {
			logger.error("Exception getPatientDataById", e.getMessage());
		}
		return patient;
	}

	/**
	 * Execute query to get the list of patients from Vista
	 * 
	 * @param search
	 * @param facilityId
	 * @return Collection<PatientInfo>
	 */
	public List<PatientInfo> getVistAPatients(String search, int facilityId) {

		List<PatientInfo> responseFromVista = null;

		CommonIf cif = new CommonImpl();
		Facility f = new Facility();
		f.setId(facilityId);
		logger.info("facility id : " + facilityId);
		Facility fret = facif.getFacilityMasterid(f);

		if (fret.getServerIp() != null && fret.getServerPort() != null
				&& fret.getAccessCode() != null && fret.getVerifyCode() != null) {

			cif.establishConnection(fret.getServerIp(),
					Integer.parseInt(fret.getServerPort()),
					fret.getAccessCode(), fret.getVerifyCode());
			responseFromVista = cif.searchPatients(search);
			cif.disconnect();
		} else {
			logger.error("Vista Connection details not found for this facility  : "
					+ facilityId);
		}
		return responseFromVista;
	}

	/**
	 * Execute query to get patient details from VistA
	 * 
	 * @param patDFN
	 * @param facilityId
	 * @return String
	 */
	public String addPatient(int patDFN, int facilityId, String lastName, String firstName, String dob, String gender, String ssn,int userId) {

		Patient p = new Patient ();
		p.setPatientDfn(patDFN);
		p.setHrn(patDFN + "");
		p.setFirstName(firstName);
		p.setLastName(lastName);
		
		p.setDob(PMSUtilities.getDatefromStringDate(dob));
		Users u = new Users();
		u.setId(userId);
		p.setCreatedBy(u);
		p.setUpdatedBy(u);
		Date createdDateTime = new Date();
		p.setCreatedDateTime(createdDateTime);
		p.setInactiveBy(1);
		p.setPatientPortalActive("N");
		p.setSsn(ssn);
		p.setSex(gender);
		p.setStatus("A");
		
		String errorString = "";
		try {
			if (facilityId != 0) {
				Facility fac = new Facility();
				fac.setId(facilityId);
				logger.info("facility : " + fac);
				p.setFacilityId(fac);
				logger.info("facility set in patient entity");

			} else {
				logger.info("facility id null while storing data in patient table");
			}
			if (p != null) {
				int patId = patientExist(patDFN, facilityId);
				if (patId != 0) {
					logger.info("updating existing patient details from Vista");
					p.setId(patId);
					em.merge(p);
				} else {
					logger.info("saving a new patient from Vista");
					em.persist(p);
				}
			}
		} catch (Exception e) {
			errorString = e.getMessage();
			e.printStackTrace();
		}
		return errorString;
	}
	/**
	 * Execute query to get patient detail from VistA by dfn
	 * 
	 * @param patDFN
	 * @param facilityId
	 * @return Patient
	 */
	public Patient getPatientDetail(int patDFN, int facilityId) {

		Patient p = getPatientDetailsfromVista(patDFN, facilityId);
		logger.info(p.toString());
		return p;
	}

	/**
	 * Execute query to get patient details from VistA
	 * 
	 * @param patDFN
	 * @param facilityId
	 * @return int
	 */
	@SuppressWarnings("unchecked")
	public int patientExist(int patDFN, int facilityId) {
		int patId = 0;
		Collection<Patient> patient = null;
		Facility fac = new Facility();
		fac.setId(facilityId);
		Query q = em.createQuery("select p from Patient p where p.patientDfn='"
				+ patDFN + "' and p.facilityId=" + fac.getId());
		logger.info("checking patient dfn and facility id in database");
		patient = q.getResultList();
		logger.info("query executed");
		if (patient != null) {
			for (Patient pat : patient) {
				patId = pat.getId();
			}
		}
		return patId;
	}

	/**
	 * Execute query to get patient details from VistA
	 * 
	 * @param patDFN
	 * @param facilityId
	 * @return Patient
	 */
	public Patient getPatientDetailsfromVista(int patDFN, int facilityId) {

		Patient p = new Patient();
		CommonIf cif = new CommonImpl();

		Facility f = new Facility();
		f.setId(facilityId);
		logger.info("facility id " + facilityId);
		Facility fret = facif.getFacilityMasterid(f);
		if (fret.getServerIp() != null && fret.getServerPort() != null
				&& fret.getAccessCode() != null && fret.getVerifyCode() != null) {

			cif.establishConnection(fret.getServerIp(),
					Integer.parseInt(fret.getServerPort()),
					fret.getAccessCode(), fret.getVerifyCode());

			PatientInfo patinfo = cif.getPatientDetails(patDFN);
			logger.info("patient info " + patinfo);
			cif.disconnect();
			logger.info("setting dfn" + patDFN);
			p.setPatientDfn(patDFN);
			logger.info("dfn set");
			try {
				String name[] = patinfo.getPatName().split(",");

				p.setLastName(name[0]);
				p.setFirstName(name[1]);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

			p.setHrn(patDFN + "");
			logger.info("dob:" + patinfo.getPatDOB());
			p.setDob(PMSUtilities.changeDateFormatfromFilemantoDatabase(patinfo
					.getPatDOB()));
			logger.info("conversion of date end");
			Users u = new Users();
			u.setId(1);
			p.setCreatedBy(u);
			p.setUpdatedBy(u);
			Date createdDateTime = new Date();
			p.setCreatedDateTime(createdDateTime);
			p.setInactiveBy(1);
			p.setPatientPortalActive("N");
			p.setSsn(patinfo.getPatSSN());
			p.setSex(patinfo.getPatSex());
			p.setStatus("A");
		} else {
			logger.error("Vista Connection details not found for this facility  : "
					+ facilityId);
		}
		return p;
	}

	/*************************Added by Sumit*********************************/
	/**
	 * Execute query to check patient authentication
	 * 
	 * @param userName
	 * @param password
	 * @return int
	 */
	@Override
	public Collection<PatientSearchTO> patientLogin(PatientSearchTO pst) {
		
		Collection<PatientSearchTO> col = null;
		Collection<Object[]> obj = null;
		
		try
		{
		Query q = em.createQuery("select p.lastName, p.firstName, p.middleName, p.ssn, p.dob, p.sex, p.id from Patient p where p.userName ='"
				+ pst.getUsername()+ "' and p.password=" + pst.getPassword());
		
		obj = q.getResultList();
		
		if(obj != null)
		{
			col = new LinkedList<PatientSearchTO>();
			
			for(Object[] result : obj)
			{
				PatientSearchTO ps = new PatientSearchTO();
				
				if(result[0] != "" && result[0] != null)
				{
					ps.setLastName(result[0].toString());
				}
				
				if(result[1] != "" && result[1] != null)
				{
					ps.setFirstName(result[1].toString());
				}
				
				if(result[2] != "" && result[2] != null)
				{
					ps.setMiddleName(result[2].toString());
				}
				
				if(result[3] != "" && result[3] != null)
				{
					ps.setSsn(result[3].toString());
				}
				
				if(result[4] != "" && result[4] != null)
				{
					ps.setDob(result[4].toString());
				}
				
				if(result[5] != "" && result[5] != null)
				{
					ps.setSex(result[5].toString());
				}
				
				if(result[6] != "" && result[6] != null)
				{
					ps.setId(Integer.parseInt(result[6].toString()));
				}
				
				col.add(ps);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return col;
	}

	@Override
	public void addPatientReq(PatientApptRequest pat) {
		
			System.out.println("Inside EJB");
			if (pat != null) {
				em.persist(pat);
				System.out.println("persist Done!!!");
		
							}
	}
	
	@Override
	public Collection<PatientApptRequest> searchPatientReq(PatientSearchTO pst) {
		
		Collection<PatientApptRequest> lstobj = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select pat from PatientApptRequest pat where pat.patientId = '"+pst.getId()+"'");
		
		if((pst.getFac() != -1))
		{
			sb.append(" and pat.facilityId = '"+pst.getFac()+"'");
		}
		if(pst.getService() != -1)
		{
			sb.append(" and pat.serviceId = '"+pst.getService()+"'");
		}
		if(pst.getResource() != -1)
		{
			sb.append(" and pat.resourceId = '"+pst.getResource()+"'");
		}
		if(pst.getApptType()!=-1)
		{
			sb.append(" and pat.apptType = '"+pst.getApptType()+"'");
		}
		if(pst.getDate()!=null && pst.getDate()!="")
		{
			sb.append(" and pat.date like '"+pst.getDate()+"'");
		}
		if(pst.getTime()!=null && pst.getTime()!="")
		{
			sb.append(" and pat.time = '"+pst.getTime()+"'");
		}

		TypedQuery<PatientApptRequest> q = em.createQuery(sb.toString(),PatientApptRequest.class);
		lstobj = q.getResultList();	
	
		
		return lstobj;
	}
	
	/***************************************************************************/

	
}
