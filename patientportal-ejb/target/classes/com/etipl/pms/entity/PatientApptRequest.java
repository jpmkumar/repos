/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etipl.pms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edgeware
 */
@Entity
@Table(name = "PATIENT_APPT_REQUEST", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientApptRequest.findAll", query = "SELECT p FROM PatientApptRequest p"),
    @NamedQuery(name = "PatientApptRequest.findById", query = "SELECT p FROM PatientApptRequest p WHERE p.id = :id"),    
    @NamedQuery(name = "PatientApptRequest.findByApptComplaint", query = "SELECT p FROM PatientApptRequest p WHERE p.apptComplaint = :apptComplaint"),
    @NamedQuery(name = "PatientApptRequest.findByRemarks", query = "SELECT p FROM PatientApptRequest p WHERE p.remarks = :remarks"),
    @NamedQuery(name = "PatientApptRequest.findByStatus", query = "SELECT p FROM PatientApptRequest p WHERE p.status = :status")})
public class PatientApptRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;    
    @Basic(optional = false)
    @Column(name = "FROM_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromTime;    
    @Basic(optional = false)
    @Column(name = "TO_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toTime;
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Patient patientId;
    @JoinColumn(name = "CHIEF_COMPLAINT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TypeItems chiefComplaint;
    @Column(name = "APPT_STATUS", length = 15)
    private String apptStatus;
    @Lob
    @Column(name = "REMARKS", length = 65535)
    private String remarks;    
    @JoinColumn(name = "CONSULTING_ROOM", referencedColumnName = "ID")
    @ManyToOne
    private TypeItems consultingRoom; 
    @Column(name = "SLOT_SIZE")
    private Integer slotSize;
    @JoinColumn(name = "FACILITY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Facility facilityId;
    @JoinColumn(name = "SECTION_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Section sectionId;
    @JoinColumn(name = "APPT_TYPE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)  
    private AppointmentType apptTypeId;   
    @JoinColumn(name = "RESOURCE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Resource resourceId;    
    @Column(name = "STATUS", length = 2)
    private String status;
    @JoinColumn(name = "ENTERED_BY", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Resource enteredBy;
    @Basic(optional = false)    
    @Column(name = "ENTRY_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryTime;
    

    public PatientApptRequest() {
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFromTime() {
		return fromTime;
	}


	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}


	public Date getToTime() {
		return toTime;
	}


	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}


	public Patient getPatientId() {
		return patientId;
	}


	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}


	public TypeItems getChiefComplaint() {
		return chiefComplaint;
	}


	public void setChiefComplaint(TypeItems chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}


	public String getApptStatus() {
		return apptStatus;
	}


	public void setApptStatus(String apptStatus) {
		this.apptStatus = apptStatus;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public TypeItems getConsultingRoom() {
		return consultingRoom;
	}


	public void setConsultingRoom(TypeItems consultingRoom) {
		this.consultingRoom = consultingRoom;
	}


	public Integer getSlotSize() {
		return slotSize;
	}


	public void setSlotSize(Integer slotSize) {
		this.slotSize = slotSize;
	}


	public Facility getFacilityId() {
		return facilityId;
	}


	public void setFacilityId(Facility facilityId) {
		this.facilityId = facilityId;
	}


	public Section getSectionId() {
		return sectionId;
	}


	public void setSectionId(Section sectionId) {
		this.sectionId = sectionId;
	}


	public AppointmentType getApptTypeId() {
		return apptTypeId;
	}


	public void setApptTypeId(AppointmentType apptTypeId) {
		this.apptTypeId = apptTypeId;
	}


	public Resource getResourceId() {
		return resourceId;
	}


	public void setResourceId(Resource resourceId) {
		this.resourceId = resourceId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Resource getEnteredBy() {
		return enteredBy;
	}


	public void setEnteredBy(Resource enteredBy) {
		this.enteredBy = enteredBy;
	}


	public Date getEntryTime() {
		return entryTime;
	}


	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
}
