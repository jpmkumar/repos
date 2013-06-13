package com.etipl.pms.pmsRest;

import java.util.Date;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="patientMaster")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientMaster {
    
	@XmlElement(name="id")
    private Integer id;
	
	@XmlAttribute(name="href")
	private String href;
	
	private String patientInsuranceId;
	
	
	@FormParam("hrn")
    private String hrn;
	@FormParam("first_name")
    private String firstName;
	@FormParam("last_name")
    private String lastName;
	@FormParam("middle_name")	
    private String middleName;
	@FormParam("registration_date_time")
    private Date registrationDateTime;
	@FormParam("dob")
    private String dob;
	@FormParam("lstGender")
    private String sex;	
	@FormParam("permanent_add1")
    private String padd1;
	@FormParam("permanent_add2")
    private String padd2;	
	@FormParam("permanent_city")
    private String paddCity;
	@FormParam("permanent_state")
    private String paddState;
	@FormParam("permanent_zip")
    private String paddZip;
	@FormParam("permanent_country")
    private String paddCountry;
	@FormParam("mailing_add1")
    private String ladd1;
	@FormParam("mailing_add2")
    private String ladd2;
	@FormParam("mailing_city")
    private String laddCity;
	@FormParam("mailing_state")
    private String laddState;
	@FormParam("mailing_zip")
    private String laddZip;
	@FormParam("mailing_country")
    private String laddCountry;
	@FormParam("phone")
    private String phone;
	@FormParam("religion")
    private String religion;
	@FormParam("nationality")
    private String nationality;
	@FormParam("created_datetime")
    private Date createdDateTime;
	@FormParam("updated_Datetime")
    private Date updatedDateTime;
	@FormParam("update_count")
    private Integer updateCount;
	@FormParam("modified_datetime")
    private Date mdatetme;
	@FormParam("remarks")
    private String remarks;
	@FormParam("ssn")
    private String ssn;
	@FormParam("title")
    private String title;
	@FormParam("salutation")
    private String salutation;
	@FormParam("marital_status")
    private String maritalStatus;
	@FormParam("comments")
    private String comments;
	@FormParam("work_phone")
    private String wphone;
	@FormParam("cell_phone")
    private String cphone;
	@FormParam("email")
    private String email;
	@FormParam("emergency_contact_hrn")
    private String emergencyContactHrn;
	@FormParam("gurantor_contact_hrn")
    private String guarantorContactHrn;
	@FormParam("hoh_contact_hrn")
    private String hohContactHrn;
	@FormParam("relationship_ec")
    private String relationshipEc;
	@FormParam("relationship_gurantor")
    private String relationshipGuarantor;
	@FormParam("relationship_hoh")
    private String relationshipHoh;
	@FormParam("active")
    private String active;
	@FormParam("inactive_datetime")
    private Date inactiveDatetime;
	@FormParam("inactive_by")
    private int inactiveBy;
	@FormParam("patient_merge_hrn")
    private String patientMergeHrn;
	@FormParam("signonfile_hipaa")
    private String signOnFileHipaa;
	@FormParam("dateof_sof")    
    private Date dateOfSof;
	@FormParam("mobile_phone")
    private String mphone;
	@FormParam("occupation")
    private String occupation;
	@FormParam("ethnicity")
    private String ethnicity;
	@FormParam("race")
    private String race;
	@FormParam("fax")
    private String fax;
	@FormParam("famlily_income")
    private Integer familyIncome;
	@FormParam("family_members")
    private Integer familyMembers;
	@FormParam("sliding_code")
    private String slidingCode;
	@FormParam("language_spokenathome")
    private String langSpokenAtHome;
	@FormParam("education")
    private String education;
	@FormParam("same_permanent_add")
    private String samePermanentAdd;
	@FormParam("employer_name")
    private String employerName;
	@FormParam("radiology_code")
    private String radiologyCode;
	@FormParam("pharmacy_ncpdpid")
    private String pharmacyNcpdpid;
	@FormParam("enable_email_remainders")
    private String enableEmailReminders;
	@FormParam("emergency_check")
    private String emergencyCheck;
	@FormParam("emergency_entity_id")
    private String emergencyEntityId;
	@FormParam("guarantor_check")
    private String guarantorCheck;
	@FormParam("gurantor_entity_id")
    private String guarantorEntityId;
	@FormParam("hoh_check")
    private String hohCheck;
	@FormParam("hoh_entity_id")
    private String hohEntityId;
	@FormParam("patient_portal_password")
    private String patientPortalPassword;
	@FormParam("patient_portal_active")
    private String patientPortalActive;
	@FormParam("patient_portal_date")
    private Date patientPortalDt;
	@FormParam("email_unknown")
    private String emailUnknown;
	@FormParam("patient_portal_preferredlang")
    private String patientPortalPreferedLang;
	@FormParam("patient_dfn")
    private Integer patientDfn;
	@FormParam("status")
    private String status;

	/***** Added by Sumit*******/
	
	@FormParam("userName")
    private String username;
	@FormParam("password")
    private String password;
	@FormParam("fromTime")
    private String fromTime;
	@FormParam("complaint")
    private String complaint;
	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@FormParam("toTime")
    private String toTime;
	
	/****************************/
	
	
	private String facilityId;
    
	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PatientMaster()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHrn() {
		return hrn;
	}

	public void setHrn(String hrn) {
		this.hrn = hrn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getRegistrationDateTime() {
		return registrationDateTime;
	}

	public void setRegistrationDateTime(Date registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPadd1() {
		return padd1;
	}

	public void setPadd1(String padd1) {
		this.padd1 = padd1;
	}

	public String getPadd2() {
		return padd2;
	}

	public void setPadd2(String padd2) {
		this.padd2 = padd2;
	}

	public String getPaddCity() {
		return paddCity;
	}

	public void setPaddCity(String paddCity) {
		this.paddCity = paddCity;
	}

	public String getPaddState() {
		return paddState;
	}

	public void setPaddState(String paddState) {
		this.paddState = paddState;
	}

	public String getPaddZip() {
		return paddZip;
	}

	public void setPaddZip(String paddZip) {
		this.paddZip = paddZip;
	}

	public String getPaddCountry() {
		return paddCountry;
	}

	public void setPaddCountry(String paddCountry) {
		this.paddCountry = paddCountry;
	}

	public String getLadd1() {
		return ladd1;
	}

	public void setLadd1(String ladd1) {
		this.ladd1 = ladd1;
	}

	public String getLadd2() {
		return ladd2;
	}

	public void setLadd2(String ladd2) {
		this.ladd2 = ladd2;
	}

	public String getLaddCity() {
		return laddCity;
	}

	public void setLaddCity(String laddCity) {
		this.laddCity = laddCity;
	}

	public String getLaddState() {
		return laddState;
	}

	public void setLaddState(String laddState) {
		this.laddState = laddState;
	}

	public String getLaddZip() {
		return laddZip;
	}

	public void setLaddZip(String laddZip) {
		this.laddZip = laddZip;
	}

	public String getLaddCountry() {
		return laddCountry;
	}

	public void setLaddCountry(String laddCountry) {
		this.laddCountry = laddCountry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Integer getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	public Date getMdatetme() {
		return mdatetme;
	}

	public void setMdatetme(Date mdatetme) {
		this.mdatetme = mdatetme;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getWphone() {
		return wphone;
	}

	public void setWphone(String wphone) {
		this.wphone = wphone;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmergencyContactHrn() {
		return emergencyContactHrn;
	}

	public void setEmergencyContactHrn(String emergencyContactHrn) {
		this.emergencyContactHrn = emergencyContactHrn;
	}

	public String getGuarantorContactHrn() {
		return guarantorContactHrn;
	}

	public void setGuarantorContactHrn(String guarantorContactHrn) {
		this.guarantorContactHrn = guarantorContactHrn;
	}

	public String getHohContactHrn() {
		return hohContactHrn;
	}

	public void setHohContactHrn(String hohContactHrn) {
		this.hohContactHrn = hohContactHrn;
	}

	public String getRelationshipEc() {
		return relationshipEc;
	}

	public void setRelationshipEc(String relationshipEc) {
		this.relationshipEc = relationshipEc;
	}

	public String getRelationshipGuarantor() {
		return relationshipGuarantor;
	}

	public void setRelationshipGuarantor(String relationshipGuarantor) {
		this.relationshipGuarantor = relationshipGuarantor;
	}

	public String getRelationshipHoh() {
		return relationshipHoh;
	}

	public void setRelationshipHoh(String relationshipHoh) {
		this.relationshipHoh = relationshipHoh;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getInactiveDatetime() {
		return inactiveDatetime;
	}

	public void setInactiveDatetime(Date inactiveDatetime) {
		this.inactiveDatetime = inactiveDatetime;
	}

	public int getInactiveBy() {
		return inactiveBy;
	}

	public void setInactiveBy(int inactiveBy) {
		this.inactiveBy = inactiveBy;
	}

	public String getPatientMergeHrn() {
		return patientMergeHrn;
	}

	public void setPatientMergeHrn(String patientMergeHrn) {
		this.patientMergeHrn = patientMergeHrn;
	}

	public String getSignOnFileHipaa() {
		return signOnFileHipaa;
	}

	public void setSignOnFileHipaa(String signOnFileHipaa) {
		this.signOnFileHipaa = signOnFileHipaa;
	}

	public Date getDateOfSof() {
		return dateOfSof;
	}

	public void setDateOfSof(Date dateOfSof) {
		this.dateOfSof = dateOfSof;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(Integer familyIncome) {
		this.familyIncome = familyIncome;
	}

	public Integer getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Integer familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getSlidingCode() {
		return slidingCode;
	}

	public void setSlidingCode(String slidingCode) {
		this.slidingCode = slidingCode;
	}

	public String getLangSpokenAtHome() {
		return langSpokenAtHome;
	}

	public void setLangSpokenAtHome(String langSpokenAtHome) {
		this.langSpokenAtHome = langSpokenAtHome;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSamePermanentAdd() {
		return samePermanentAdd;
	}

	public void setSamePermanentAdd(String samePermanentAdd) {
		this.samePermanentAdd = samePermanentAdd;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getRadiologyCode() {
		return radiologyCode;
	}

	public void setRadiologyCode(String radiologyCode) {
		this.radiologyCode = radiologyCode;
	}

	public String getPharmacyNcpdpid() {
		return pharmacyNcpdpid;
	}

	public void setPharmacyNcpdpid(String pharmacyNcpdpid) {
		this.pharmacyNcpdpid = pharmacyNcpdpid;
	}

	public String getEnableEmailReminders() {
		return enableEmailReminders;
	}

	public void setEnableEmailReminders(String enableEmailReminders) {
		this.enableEmailReminders = enableEmailReminders;
	}

	public String getEmergencyCheck() {
		return emergencyCheck;
	}

	public void setEmergencyCheck(String emergencyCheck) {
		this.emergencyCheck = emergencyCheck;
	}

	public String getEmergencyEntityId() {
		return emergencyEntityId;
	}

	public void setEmergencyEntityId(String emergencyEntityId) {
		this.emergencyEntityId = emergencyEntityId;
	}

	public String getGuarantorCheck() {
		return guarantorCheck;
	}

	public void setGuarantorCheck(String guarantorCheck) {
		this.guarantorCheck = guarantorCheck;
	}

	public String getGuarantorEntityId() {
		return guarantorEntityId;
	}

	public void setGuarantorEntityId(String guarantorEntityId) {
		this.guarantorEntityId = guarantorEntityId;
	}

	public String getHohCheck() {
		return hohCheck;
	}

	public void setHohCheck(String hohCheck) {
		this.hohCheck = hohCheck;
	}

	public String getHohEntityId() {
		return hohEntityId;
	}

	public void setHohEntityId(String hohEntityId) {
		this.hohEntityId = hohEntityId;
	}

	public String getPatientPortalPassword() {
		return patientPortalPassword;
	}

	public void setPatientPortalPassword(String patientPortalPassword) {
		this.patientPortalPassword = patientPortalPassword;
	}

	public String getPatientPortalActive() {
		return patientPortalActive;
	}

	public void setPatientPortalActive(String patientPortalActive) {
		this.patientPortalActive = patientPortalActive;
	}

	public Date getPatientPortalDt() {
		return patientPortalDt;
	}

	public void setPatientPortalDt(Date patientPortalDt) {
		this.patientPortalDt = patientPortalDt;
	}

	public String getEmailUnknown() {
		return emailUnknown;
	}

	public void setEmailUnknown(String emailUnknown) {
		this.emailUnknown = emailUnknown;
	}

	public String getPatientPortalPreferedLang() {
		return patientPortalPreferedLang;
	}

	public void setPatientPortalPreferedLang(String patientPortalPreferedLang) {
		this.patientPortalPreferedLang = patientPortalPreferedLang;
	}

	public Integer getPatientDfn() {
		return patientDfn;
	}

	public void setPatientDfn(Integer patientDfn) {
		this.patientDfn = patientDfn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPatientInsuranceId() {
		return patientInsuranceId;
	}

	public void setPatientInsuranceId(String patientInsuranceId) {
		this.patientInsuranceId = patientInsuranceId;
	}
}
