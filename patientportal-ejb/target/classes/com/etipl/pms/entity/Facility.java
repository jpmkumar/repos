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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.FetchType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Edgeware
 */
@Entity
@Table(name = "FACILITY", uniqueConstraints = { @UniqueConstraint(columnNames = { "FACILITY_Code" }) })
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f WHERE f.status ='A'"),
		@NamedQuery(name = "Facility.fetchTopFacIdName", query = "SELECT f.id,f.facilityName FROM Facility f WHERE f.subFacilityId = NULL AND f.status ='A'"),
		@NamedQuery(name = "Facility.fetchMedFacIdName", query = "SELECT f.id,f.facilityName FROM Facility f WHERE f.subFacilityId IS NOT NULL AND f.status ='A'"),
		@NamedQuery(name = "Facility.fetchTopFacIdofMedFacility", query = "SELECT f FROM Facility f WHERE f.id = :id AND f.status ='A'"),
		@NamedQuery(name = "Facility.findAllTop", query = "SELECT f FROM Facility f WHERE f.subFacilityId = NULL AND f.status ='A'"),
		@NamedQuery(name = "Facility.findById", query = "SELECT f FROM Facility f WHERE f.id = :id AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFACILITYCode", query = "SELECT f FROM Facility f WHERE f.fACILITYCode = :fACILITYCode AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFacilityName", query = "SELECT f FROM Facility f WHERE f.facilityName = :facilityName AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByAddress1", query = "SELECT f FROM Facility f WHERE f.address1 = :address1 AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByAddress2", query = "SELECT f FROM Facility f WHERE f.address2 = :address2 AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByCity", query = "SELECT f FROM Facility f WHERE f.city = :city AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByState", query = "SELECT f FROM Facility f WHERE f.state = :state AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByZip", query = "SELECT f FROM Facility f WHERE f.zip = :zip AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByType", query = "SELECT f FROM Facility f WHERE f.type = :type AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByPhone", query = "SELECT f FROM Facility f WHERE f.phone = :phone AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByExtension", query = "SELECT f FROM Facility f WHERE f.extension = :extension AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByCell", query = "SELECT f FROM Facility f WHERE f.cell = :cell AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFax", query = "SELECT f FROM Facility f WHERE f.fax = :fax AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByWphone", query = "SELECT f FROM Facility f WHERE f.wphone = :wphone AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByContactPersonName", query = "SELECT f FROM Facility f WHERE f.contactPersonName = :contactPersonName AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByEmail", query = "SELECT f FROM Facility f WHERE f.email = :email AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFederalTaxId", query = "SELECT f FROM Facility f WHERE f.federalTaxId = :federalTaxId AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByNpi", query = "SELECT f FROM Facility f WHERE f.npi = :npi AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByTaxonomyID", query = "SELECT f FROM Facility f WHERE f.taxonomyID = :taxonomyID AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByCliaNo", query = "SELECT f FROM Facility f WHERE f.cliaNo = :cliaNo AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByStatus", query = "SELECT f FROM Facility f WHERE f.status = :status AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByEncounterVista", query = "SELECT f FROM Facility f WHERE f.encounterVista = :encounterVista AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFromTime", query = "SELECT f FROM Facility f WHERE f.fromTime = :fromTime AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByToTime", query = "SELECT f FROM Facility f WHERE f.toTime = :toTime AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByMon", query = "SELECT f FROM Facility f WHERE f.mon = :mon AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByTue", query = "SELECT f FROM Facility f WHERE f.tue = :tue AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByWed", query = "SELECT f FROM Facility f WHERE f.wed = :wed AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByThu", query = "SELECT f FROM Facility f WHERE f.thu = :thu AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByFri", query = "SELECT f FROM Facility f WHERE f.fri = :fri AND f.status ='A'"),
		@NamedQuery(name = "Facility.findBySat", query = "SELECT f FROM Facility f WHERE f.sat = :sat AND f.status ='A'"),
		@NamedQuery(name = "Facility.findBySun", query = "SELECT f FROM Facility f WHERE f.sun = :sun AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByTimezone", query = "SELECT f FROM Facility f WHERE f.timezone = :timezone AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByServerIp", query = "SELECT f FROM Facility f WHERE f.serverIp = :serverIp AND f.status ='A'"),
		@NamedQuery(name = "Facility.findByServerPort", query = "SELECT f FROM Facility f WHERE f.serverPort = :serverPort AND f.status ='A'") })
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	private Integer id;
	@Column(name = "FACILITY_Code", length = 50)
	private String fACILITYCode;
	@Column(name = "FACILITY_NAME", length = 60)
	private String facilityName;
	@Column(name = "Address1", length = 50)
	private String address1;
	@Column(name = "Address2", length = 100)
	private String address2;
	@Column(name = "City", length = 20)
	private String city;
	@Column(name = "State", length = 10)
	private String state;
	@Column(name = "Zip", length = 10)
	private String zip;
	@Column(name = "Type", length = 2)
	private String type;
	@Column(name = "Phone", length = 20)
	private String phone;
	@Column(name = "Extension", length = 5)
	private String extension;
	@Column(name = "Cell", length = 20)
	private String cell;
	@Column(name = "Fax", length = 20)
	private String fax;
	@Column(name = "WPHONE", length = 15)
	private String wphone;
	@Column(name = "STATION", length = 50)
	private String station;
	@Column(name = "contact_person_name", length = 50)
	private String contactPersonName;
	@Column(name = "email", length = 25)
	private String email;
	@Column(name = "FEDERAL_TAX_ID", length = 50)
	private String federalTaxId;
	@Column(name = "NPI", length = 12)
	private String npi;
	@Column(name = "TaxonomyID", length = 35)
	private String taxonomyID;
	@Column(name = "CLIA_NO", length = 50)
	private String cliaNo;
	@Column(name = "STATUS", length = 2)
	private String status;
	@Column(name = "ENCOUNTER_VISTA", length = 2)
	private String encounterVista;
	@Column(name = "FROM_TIME")
	@Temporal(TemporalType.TIME)
	private Date fromTime;
	@Column(name = "TO_TIME")
	@Temporal(TemporalType.TIME)
	private Date toTime;
	@Column(name = "MON", length = 2)
	private String mon;
	@Column(name = "TUE", length = 2)
	private String tue;
	@Column(name = "WED", length = 2)
	private String wed;
	@Column(name = "THU", length = 2)
	private String thu;
	@Column(name = "FRI", length = 2)
	private String fri;
	@Column(name = "SAT", length = 2)
	private String sat;
	@Column(name = "SUN", length = 2)
	private String sun;
	// @JoinColumn(name = "TIMEZONES", referencedColumnName = "ID")
	// @ManyToOne
	@Column(name = "TIMEZONE", length = 50)
	private String timezone;
	// private Timezones timezone;
	@Column(name = "SERVER_IP", length = 20)
	private String serverIp;
	@Column(name = "SERVER_PORT", length = 6)
	private String serverPort;
	@Column(name = "ACCESS_CODE", length = 100)
	private String accessCode;
	@Column(name = "VERIFY_CODE", length = 100)
	private String verifyCode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
	private Collection<Section> sectionCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
	private Collection<FacilityUsers> facilityUsersCollection;
	@JoinColumn(name = "VISON", referencedColumnName = "ID")
	@ManyToOne
	private TypeItems vison;
	@JoinColumn(name = "FACILITY_TYPE", referencedColumnName = "ID")
	@ManyToOne
	private TypeItems factype;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subFacilityId", fetch = FetchType.EAGER)
	private Collection<Facility> facilityCollection;
	@JoinColumn(name = "SUB_FACILITY_ID", referencedColumnName = "ID", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Facility subFacilityId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
	private Collection<Slot> slotCollection;
	@OneToMany(mappedBy = "facilityId")
	private Collection<Block> blockCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
	private Collection<UserSessions> userSessionsCollection;

	public Facility() {
	}

	public Facility(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFACILITYCode() {
		return fACILITYCode;
	}

	public void setFACILITYCode(String fACILITYCode) {
		this.fACILITYCode = fACILITYCode;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWphone() {
		return wphone;
	}

	public void setWphone(String wphone) {
		this.wphone = wphone;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFederalTaxId() {
		return federalTaxId;
	}

	public void setFederalTaxId(String federalTaxId) {
		this.federalTaxId = federalTaxId;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public String getTaxonomyID() {
		return taxonomyID;
	}

	public void setTaxonomyID(String taxonomyID) {
		this.taxonomyID = taxonomyID;
	}

	public String getCliaNo() {
		return cliaNo;
	}

	public void setCliaNo(String cliaNo) {
		this.cliaNo = cliaNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEncounterVista() {
		return encounterVista;
	}

	public void setEncounterVista(String encounterVista) {
		this.encounterVista = encounterVista;
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

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public String getWed() {
		return wed;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@XmlTransient
	public Collection<Section> getSectionCollection() {
		return sectionCollection;
	}

	public void setSectionCollection(Collection<Section> sectionCollection) {
		this.sectionCollection = sectionCollection;
	}

	@XmlTransient
	public Collection<FacilityUsers> getFacilityUsersCollection() {
		return facilityUsersCollection;
	}

	public void setFacilityUsersCollection(
			Collection<FacilityUsers> facilityUsersCollection) {
		this.facilityUsersCollection = facilityUsersCollection;
	}

	public TypeItems getVison() {
		return vison;
	}

	public TypeItems getFacType() {
		return factype;
	}

	public void setVison(TypeItems vison) {
		this.vison = vison;
	}

	public void setFacType(TypeItems factype) {
		this.factype = factype;
	}

	@XmlTransient
	public Collection<Facility> getFacilityCollection() {
		return facilityCollection;
	}

	public void setFacilityCollection(Collection<Facility> facilityCollection) {
		this.facilityCollection = facilityCollection;
	}

	public Facility getSubFacilityId() {
		return subFacilityId;
	}

	public void setSubFacilityId(Facility subFacilityId) {
		this.subFacilityId = subFacilityId;
	}

	@XmlTransient
	public Collection<Slot> getSlotCollection() {
		return slotCollection;
	}

	public void setSlotCollection(Collection<Slot> slotCollection) {
		this.slotCollection = slotCollection;
	}

	@XmlTransient
	public Collection<Block> getBlockCollection() {
		return blockCollection;
	}

	public void setBlockCollection(Collection<Block> blockCollection) {
		this.blockCollection = blockCollection;
	}

	@XmlTransient
	public Collection<UserSessions> getUserSessionsCollection() {
		return userSessionsCollection;
	}

	public void setUserSessionsCollection(
			Collection<UserSessions> userSessionsCollection) {
		this.userSessionsCollection = userSessionsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Facility)) {
			return false;
		}
		Facility other = (Facility) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.etipl.pms.entity.Facility[ id=" + id + " ]";
	}

}
