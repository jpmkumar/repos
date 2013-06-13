/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etipl.pms.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edgeware
 */
@Entity
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findById", query = "SELECT p FROM Patient p WHERE p.id = :id"),
    @NamedQuery(name = "Patient.findByHrn", query = "SELECT p FROM Patient p WHERE p.hrn = :hrn"),
    @NamedQuery(name = "Patient.findByFirstName", query = "SELECT p FROM Patient p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Patient.findByLastName", query = "SELECT p FROM Patient p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Patient.findByMiddleName", query = "SELECT p FROM Patient p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "Patient.findByRegistrationDateTime", query = "SELECT p FROM Patient p WHERE p.registrationDateTime = :registrationDateTime"),
    @NamedQuery(name = "Patient.findByDob", query = "SELECT p FROM Patient p WHERE p.dob = :dob"),
    @NamedQuery(name = "Patient.findBySex", query = "SELECT p FROM Patient p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patient.findByPadd1", query = "SELECT p FROM Patient p WHERE p.padd1 = :padd1"),
    @NamedQuery(name = "Patient.findByPaddCity", query = "SELECT p FROM Patient p WHERE p.paddCity = :paddCity"),
    @NamedQuery(name = "Patient.findByPaddState", query = "SELECT p FROM Patient p WHERE p.paddState = :paddState"),
    @NamedQuery(name = "Patient.findByPaddZip", query = "SELECT p FROM Patient p WHERE p.paddZip = :paddZip"),
    @NamedQuery(name = "Patient.findByPaddCountry", query = "SELECT p FROM Patient p WHERE p.paddCountry = :paddCountry"),
    @NamedQuery(name = "Patient.findByLadd1", query = "SELECT p FROM Patient p WHERE p.ladd1 = :ladd1"),
    @NamedQuery(name = "Patient.findByLaddCity", query = "SELECT p FROM Patient p WHERE p.laddCity = :laddCity"),
    @NamedQuery(name = "Patient.findByLaddState", query = "SELECT p FROM Patient p WHERE p.laddState = :laddState"),
    @NamedQuery(name = "Patient.findByLaddZip", query = "SELECT p FROM Patient p WHERE p.laddZip = :laddZip"),
    @NamedQuery(name = "Patient.findByLaddCountry", query = "SELECT p FROM Patient p WHERE p.laddCountry = :laddCountry"),
    @NamedQuery(name = "Patient.findByPhone", query = "SELECT p FROM Patient p WHERE p.phone = :phone"),
    @NamedQuery(name = "Patient.findByReligion", query = "SELECT p FROM Patient p WHERE p.religion = :religion"),
    @NamedQuery(name = "Patient.findByNationality", query = "SELECT p FROM Patient p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "Patient.findByCreatedDateTime", query = "SELECT p FROM Patient p WHERE p.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "Patient.findByUpdatedDateTime", query = "SELECT p FROM Patient p WHERE p.updatedDateTime = :updatedDateTime"),
    @NamedQuery(name = "Patient.findByUpdateCount", query = "SELECT p FROM Patient p WHERE p.updateCount = :updateCount"),
    @NamedQuery(name = "Patient.findByMdatetime", query = "SELECT p FROM Patient p WHERE p.mdatetime = :mdatetime"),
    @NamedQuery(name = "Patient.findBySsn", query = "SELECT p FROM Patient p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "Patient.findByTitle", query = "SELECT p FROM Patient p WHERE p.title = :title"),
    @NamedQuery(name = "Patient.findBySalutation", query = "SELECT p FROM Patient p WHERE p.salutation = :salutation"),
    @NamedQuery(name = "Patient.findByMaritalStatus", query = "SELECT p FROM Patient p WHERE p.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Patient.findByWphone", query = "SELECT p FROM Patient p WHERE p.wphone = :wphone"),
    @NamedQuery(name = "Patient.findByCphone", query = "SELECT p FROM Patient p WHERE p.cphone = :cphone"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email"),
    @NamedQuery(name = "Patient.findByEmergencyContactHrn", query = "SELECT p FROM Patient p WHERE p.emergencyContactHrn = :emergencyContactHrn"),
    @NamedQuery(name = "Patient.findByGuarantorContactHrn", query = "SELECT p FROM Patient p WHERE p.guarantorContactHrn = :guarantorContactHrn"),
    @NamedQuery(name = "Patient.findByHohContactHrn", query = "SELECT p FROM Patient p WHERE p.hohContactHrn = :hohContactHrn"),
    @NamedQuery(name = "Patient.findByRelationshipEc", query = "SELECT p FROM Patient p WHERE p.relationshipEc = :relationshipEc"),
    @NamedQuery(name = "Patient.findByRelationshipGuarantor", query = "SELECT p FROM Patient p WHERE p.relationshipGuarantor = :relationshipGuarantor"),
    @NamedQuery(name = "Patient.findByRelationshipHoh", query = "SELECT p FROM Patient p WHERE p.relationshipHoh = :relationshipHoh"),
    @NamedQuery(name = "Patient.findByStatus", query = "SELECT p FROM Patient p WHERE p.status = :status"),
    @NamedQuery(name = "Patient.findByInactiveDatetime", query = "SELECT p FROM Patient p WHERE p.inactiveDatetime = :inactiveDatetime"),
    @NamedQuery(name = "Patient.findByInactiveBy", query = "SELECT p FROM Patient p WHERE p.inactiveBy = :inactiveBy"),
    @NamedQuery(name = "Patient.findByPatientMergeHrn", query = "SELECT p FROM Patient p WHERE p.patientMergeHrn = :patientMergeHrn"),
    @NamedQuery(name = "Patient.findBySignOnFileHipaa", query = "SELECT p FROM Patient p WHERE p.signOnFileHipaa = :signOnFileHipaa"),
    @NamedQuery(name = "Patient.findByDateOfSof", query = "SELECT p FROM Patient p WHERE p.dateOfSof = :dateOfSof"),
    @NamedQuery(name = "Patient.findByMphone", query = "SELECT p FROM Patient p WHERE p.mphone = :mphone"),
    @NamedQuery(name = "Patient.findByOccupation", query = "SELECT p FROM Patient p WHERE p.occupation = :occupation"),
    @NamedQuery(name = "Patient.findByEthnicity", query = "SELECT p FROM Patient p WHERE p.ethnicity = :ethnicity"),
    @NamedQuery(name = "Patient.findByRace", query = "SELECT p FROM Patient p WHERE p.race = :race"),
    @NamedQuery(name = "Patient.findByFax", query = "SELECT p FROM Patient p WHERE p.fax = :fax"),
    @NamedQuery(name = "Patient.findByFamilyIncome", query = "SELECT p FROM Patient p WHERE p.familyIncome = :familyIncome"),
    @NamedQuery(name = "Patient.findByFamilyMembers", query = "SELECT p FROM Patient p WHERE p.familyMembers = :familyMembers"),
    @NamedQuery(name = "Patient.findBySlidingCode", query = "SELECT p FROM Patient p WHERE p.slidingCode = :slidingCode"),
    @NamedQuery(name = "Patient.findByLangSpokenAtHome", query = "SELECT p FROM Patient p WHERE p.langSpokenAtHome = :langSpokenAtHome"),
    @NamedQuery(name = "Patient.findByEducation", query = "SELECT p FROM Patient p WHERE p.education = :education"),
    @NamedQuery(name = "Patient.findBySamePermanentAdd", query = "SELECT p FROM Patient p WHERE p.samePermanentAdd = :samePermanentAdd"),
    @NamedQuery(name = "Patient.findByEmployerName", query = "SELECT p FROM Patient p WHERE p.employerName = :employerName"),
    @NamedQuery(name = "Patient.findByRadiologyCode", query = "SELECT p FROM Patient p WHERE p.radiologyCode = :radiologyCode"),
    @NamedQuery(name = "Patient.findByPharmacyNcpdpid", query = "SELECT p FROM Patient p WHERE p.pharmacyNcpdpid = :pharmacyNcpdpid"),
    @NamedQuery(name = "Patient.findByEnableEmailReminders", query = "SELECT p FROM Patient p WHERE p.enableEmailReminders = :enableEmailReminders"),
    @NamedQuery(name = "Patient.findByEmergencyCheck", query = "SELECT p FROM Patient p WHERE p.emergencyCheck = :emergencyCheck"),
    @NamedQuery(name = "Patient.findByEmergencyEntityId", query = "SELECT p FROM Patient p WHERE p.emergencyEntityId = :emergencyEntityId"),
    @NamedQuery(name = "Patient.findByGuarantorCheck", query = "SELECT p FROM Patient p WHERE p.guarantorCheck = :guarantorCheck"),
    @NamedQuery(name = "Patient.findByGuarantorEntityId", query = "SELECT p FROM Patient p WHERE p.guarantorEntityId = :guarantorEntityId"),
    @NamedQuery(name = "Patient.findByHohCheck", query = "SELECT p FROM Patient p WHERE p.hohCheck = :hohCheck"),
    @NamedQuery(name = "Patient.findByHohEntityId", query = "SELECT p FROM Patient p WHERE p.hohEntityId = :hohEntityId"),
    @NamedQuery(name = "Patient.findByPatientPortalPassword", query = "SELECT p FROM Patient p WHERE p.patientPortalPassword = :patientPortalPassword"),
    @NamedQuery(name = "Patient.findByPatientPortalActive", query = "SELECT p FROM Patient p WHERE p.patientPortalActive = :patientPortalActive"),
    @NamedQuery(name = "Patient.findByPatientPortalDt", query = "SELECT p FROM Patient p WHERE p.patientPortalDt = :patientPortalDt"),
    @NamedQuery(name = "Patient.findByEmailUnknown", query = "SELECT p FROM Patient p WHERE p.emailUnknown = :emailUnknown"),
    @NamedQuery(name = "Patient.findByPatientPortalPreferedLang", query = "SELECT p FROM Patient p WHERE p.patientPortalPreferedLang = :patientPortalPreferedLang"),
    @NamedQuery(name = "Patient.findByPatientDfn", query = "SELECT p FROM Patient p WHERE p.patientDfn = :patientDfn"),
    @NamedQuery(name = "Patient.findByPatientDfnandfaciltyId", query = "SELECT p FROM Patient p WHERE p.patientDfn = :patientDfn and p.facilityId = :facilityId")
    })
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "HRN", nullable = false, length = 15)
    private String hrn;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;
    @Column(name = "MIDDLE_NAME", length = 50)
    private String middleName;
    @Column(name = "REGISTRATION_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDateTime;
    @Basic(optional = false)
    @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "SEX", nullable = false, length = 2)
    private String sex;
    @Column(name = "PADD1", length = 30)
    private String padd1;
    @Lob
    @Column(name = "PADD2", length = 65535)
    private String padd2;
    @Column(name = "PADD_CITY", length = 25)
    private String paddCity;
    @Column(name = "PADD_STATE", length = 10)
    private String paddState;
    @Column(name = "PADD_ZIP", length = 10)
    private String paddZip;
    @Column(name = "PADD_COUNTRY", length = 50)
    private String paddCountry;
    @Column(name = "LADD1", length = 30)
    private String ladd1;
    @Lob
    @Column(name = "LADD2", length = 65535)
    private String ladd2;
    @Column(name = "LADD_CITY", length = 25)
    private String laddCity;
    @Column(name = "LADD_STATE", length = 10)
    private String laddState;
    @Column(name = "LADD_ZIP", length = 10)
    private String laddZip;
    @Column(name = "LADD_COUNTRY", length = 50)
    private String laddCountry;
    @Column(name = "PHONE", length = 15)
    private String phone;
    @Column(name = "RELIGION", length = 30)
    private String religion;
    @Column(name = "NATIONALITY", length = 30)
    private String nationality;
    @Column(name = "Created_DateTime",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column(name = "Updated_DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDateTime;
    @Column(name = "Update_Count")
    private Integer updateCount;
    @Column(name = "MDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mdatetime;
    @Lob
    @Column(name = "REMARKS", length = 65535)
    private String remarks;
    @Column(name = "SSN", length = 15)
    private String ssn;
    @Column(name = "TITLE", length = 10)
    private String title;
    @Column(name = "SALUTATION", length = 50)
    private String salutation;
    @Column(name = "MARITAL_STATUS", length = 20)
    private String maritalStatus;
    @Lob
    @Column(name = "COMMENTS", length = 65535)
    private String comments;
    @Column(name = "WPHONE", length = 15)
    private String wphone;
    @Column(name = "CPHONE", length = 15)
    private String cphone;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "EMERGENCY_CONTACT_HRN", length = 15)
    private String emergencyContactHrn;
    @Column(name = "GUARANTOR_CONTACT_HRN", length = 15)
    private String guarantorContactHrn;
    @Column(name = "HOH_CONTACT_HRN", length = 15)
    private String hohContactHrn;
    @Column(name = "RELATIONSHIP_EC", length = 15)
    private String relationshipEc;
    @Column(name = "RELATIONSHIP_GUARANTOR", length = 15)
    private String relationshipGuarantor;
    @Column(name = "RELATIONSHIP_HOH", length = 15)
    private String relationshipHoh;
    @Column(name = "STATUS", length = 2)
    private String status;
    @Column(name = "INACTIVE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inactiveDatetime;
    @Column(name = "INACTIVE_BY")
    private int inactiveBy;
    @Column(name = "PATIENT_MERGE_HRN", length = 15)
    private String patientMergeHrn;
    @Column(name = "SIGN_ON_FILE_HIPAA", length = 2)
    private String signOnFileHipaa;
    @Column(name = "DATE_OF_SOF")
    @Temporal(TemporalType.DATE)
    private Date dateOfSof;
    @Column(name = "MPHONE", length = 15)
    private String mphone;
    @Column(name = "Occupation", length = 30)
    private String occupation;
    @Column(name = "ETHNICITY", length = 30)
    private String ethnicity;
    @Column(name = "RACE", length = 30)
    private String race;
    @Column(name = "Fax", length = 15)
    private String fax;
    @Column(name = "Family_Income")
    private Integer familyIncome;
    @Column(name = "Family_Members")
    private Integer familyMembers;
    @Column(name = "SLIDING_CODE", length = 20)
    private String slidingCode;
    @Column(name = "LANG_SPOKEN_AT_HOME", length = 30)
    private String langSpokenAtHome;
    @Column(name = "EDUCATION", length = 30)
    private String education;
    @Column(name = "SAME_PERMANENT_ADD", length = 2)
    private String samePermanentAdd;
    @Column(name = "EMPLOYER_NAME", length = 100)
    private String employerName;
    @Column(name = "RADIOLOGY_CODE", length = 10)
    private String radiologyCode;
    @Column(name = "PHARMACY_NCPDPID", length = 10)
    private String pharmacyNcpdpid;
    @Column(name = "ENABLE_EMAIL_REMINDERS", length = 2)
    private String enableEmailReminders;
    @Column(name = "EMERGENCY_CHECK", length = 2)
    private String emergencyCheck;
    @Column(name = "EMERGENCY_ENTITY_ID", length = 10)
    private String emergencyEntityId;
    @Column(name = "GUARANTOR_CHECK", length = 2)
    private String guarantorCheck;
    @Column(name = "GUARANTOR_ENTITY_ID", length = 10)
    private String guarantorEntityId;
    @Column(name = "HOH_CHECK", length = 2)
    private String hohCheck;
    @Column(name = "HOH_ENTITY_ID", length = 10)
    private String hohEntityId;
    @Column(name = "PATIENT_PORTAL_PASSWORD", length = 50)
    private String patientPortalPassword;
    @Basic
    @Column(name = "PATIENT_PORTAL_ACTIVE", length = 2)
    private String patientPortalActive;
    @Column(name = "PATIENT_PORTAL_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientPortalDt;
    @Column(name = "EMAIL_UNKNOWN", length = 2)
    private String emailUnknown;
    @Column(name = "PATIENT_PORTAL_PREFERED_LANG", length = 15)
    private String patientPortalPreferedLang;
    @Column(name = "PATIENT_DFN")
    private Integer patientDfn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientID")
    private Collection<PatientInsurance> patientInsuranceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<CommunicationLog> communicationLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<GroupPatients> groupPatientsCollection;
    @JoinColumn(name = "REFERRING_PHYSICIAN", referencedColumnName = "ID")
    @ManyToOne
    private Resource referringPhysician;
    @JoinColumn(name = "PRIMARY_PHYSICIAN", referencedColumnName = "ID")
    @ManyToOne
    private Resource primaryPhysician;
    @JoinColumn(name = "Updated_By", referencedColumnName = "ID")
    @ManyToOne
    private Users updatedBy;
    @JoinColumn(name = "FACILITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Facility facilityId;    
    @JoinColumn(name = "Created_By", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Users createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Slot> slotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<PatientAlert> patientAlertCollection;

    public Patient() {
    }

    public Patient(Integer id) {
        this.id = id;
    }

    public Patient(Integer id, String hrn, String firstName, String lastName, Date dob, String sex, int inactiveBy, String patientPortalActive) {
        this.id = id;
        this.hrn = hrn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.sex = sex;
        this.inactiveBy = inactiveBy;
        this.patientPortalActive = patientPortalActive;
    }

    
    
    public Facility getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Facility facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public Date getMdatetime() {
        return mdatetime;
    }

    public void setMdatetime(Date mdatetime) {
        this.mdatetime = mdatetime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @XmlTransient
    public Collection<PatientInsurance> getPatientInsuranceCollection() {
        return patientInsuranceCollection;
    }

    public void setPatientInsuranceCollection(Collection<PatientInsurance> patientInsuranceCollection) {
        this.patientInsuranceCollection = patientInsuranceCollection;
    }

    @XmlTransient
    public Collection<CommunicationLog> getCommunicationLogCollection() {
        return communicationLogCollection;
    }

    public void setCommunicationLogCollection(Collection<CommunicationLog> communicationLogCollection) {
        this.communicationLogCollection = communicationLogCollection;
    }

    @XmlTransient
    public Collection<GroupPatients> getGroupPatientsCollection() {
        return groupPatientsCollection;
    }

    public void setGroupPatientsCollection(Collection<GroupPatients> groupPatientsCollection) {
        this.groupPatientsCollection = groupPatientsCollection;
    }

    public Resource getReferringPhysician() {
        return referringPhysician;
    }

    public void setReferringPhysician(Resource referringPhysician) {
        this.referringPhysician = referringPhysician;
    }

    public Resource getPrimaryPhysician() {
        return primaryPhysician;
    }

    public void setPrimaryPhysician(Resource primaryPhysician) {
        this.primaryPhysician = primaryPhysician;
    }

    public Users getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Users updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    @XmlTransient
    public Collection<Slot> getSlotCollection() {
        return slotCollection;
    }

    public void setSlotCollection(Collection<Slot> slotCollection) {
        this.slotCollection = slotCollection;
    }

    @XmlTransient
    public Collection<PatientAlert> getPatientAlertCollection() {
        return patientAlertCollection;
    }

    public void setPatientAlertCollection(Collection<PatientAlert> patientAlertCollection) {
        this.patientAlertCollection = patientAlertCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etipl.pms.entity.Patient[ id=" + id + " ]";
    }
    
}
