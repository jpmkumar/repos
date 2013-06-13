/**
* @Author Muthu
* @version 1.0
*
*  This is the Patient Search object model detail java file,
*  it contains all the fields required to search the patient(s).
*/
package com.etipl.pms.dto;

import java.io.Serializable;

import com.etipl.pms.entity.Facility;


@SuppressWarnings("serial")
public class PatientSearchTO implements Serializable{
	private int id;
	private String hrn;
	private String firstName;
	private String lastName;
	private String middleName;
	private String dob;
	private String sex;
	private String ssn;
	private String phone;
	private String patientInsuranceId;
	private String status;
	private Facility facility;
	
	/**************** Added by Sumit ****************/
	private String username;
	private String password;
	private int top;
	private int fac;
	private int service;
	private int section;
	private int resource;
	private int apptType;
	private String date;
	private String time;
	private int complaint;
	private String fromTime;
	private String toTime;
	
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
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getFac() {
		return fac;
	}
	public void setFac(int fac) {
		this.fac = fac;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getResource() {
		return resource;
	}
	public void setResource(int resource) {
		this.resource = resource;
	}
	public int getApptType() {
		return apptType;
	}
	public void setApptType(int apptType) {
		this.apptType = apptType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getComplaint() {
		return complaint;
	}
	public void setComplaint(int complaint) {
		this.complaint = complaint;
	}
	
	/*********************************/
	
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPatientInsuranceId() {
		return patientInsuranceId;
	}
	public void setPatientInsuranceId(String patientInsuranceId) {
		this.patientInsuranceId = patientInsuranceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
