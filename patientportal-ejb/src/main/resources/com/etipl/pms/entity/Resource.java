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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edgeware
 */
@Entity
@Table(name = "RESOURCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
    @NamedQuery(name = "Resource.findById", query = "SELECT r FROM Resource r WHERE r.id = :id"),
    @NamedQuery(name = "Resource.findByResourceCode", query = "SELECT r FROM Resource r WHERE r.resourceCode = :resourceCode"),
    @NamedQuery(name = "Resource.findByCredentials", query = "SELECT r FROM Resource r WHERE r.credentials = :credentials"),
    @NamedQuery(name = "Resource.findBySex", query = "SELECT r FROM Resource r WHERE r.sex = :sex"),
    @NamedQuery(name = "Resource.findByAddress1", query = "SELECT r FROM Resource r WHERE r.address1 = :address1"),
    @NamedQuery(name = "Resource.findByAddress2", query = "SELECT r FROM Resource r WHERE r.address2 = :address2"),
    @NamedQuery(name = "Resource.findByCity", query = "SELECT r FROM Resource r WHERE r.city = :city"),
    @NamedQuery(name = "Resource.findByState", query = "SELECT r FROM Resource r WHERE r.state = :state"),
    @NamedQuery(name = "Resource.findByZip", query = "SELECT r FROM Resource r WHERE r.zip = :zip"),
    @NamedQuery(name = "Resource.findByEmail", query = "SELECT r FROM Resource r WHERE r.email = :email"),
    @NamedQuery(name = "Resource.findBySpiNo", query = "SELECT r FROM Resource r WHERE r.spiNo = :spiNo"),
    @NamedQuery(name = "Resource.findByWphone", query = "SELECT r FROM Resource r WHERE r.wphone = :wphone"),
    @NamedQuery(name = "Resource.findByFax", query = "SELECT r FROM Resource r WHERE r.fax = :fax"),
    @NamedQuery(name = "Resource.findByHphone", query = "SELECT r FROM Resource r WHERE r.hphone = :hphone"),
    @NamedQuery(name = "Resource.findByCphone", query = "SELECT r FROM Resource r WHERE r.cphone = :cphone"),
    @NamedQuery(name = "Resource.findBySsn", query = "SELECT r FROM Resource r WHERE r.ssn = :ssn"),
    @NamedQuery(name = "Resource.findByDeaNo", query = "SELECT r FROM Resource r WHERE r.deaNo = :deaNo"),
    @NamedQuery(name = "Resource.findByFederalTaxId", query = "SELECT r FROM Resource r WHERE r.federalTaxId = :federalTaxId"),
    @NamedQuery(name = "Resource.findByNpi", query = "SELECT r FROM Resource r WHERE r.npi = :npi"),
    @NamedQuery(name = "Resource.findByUpin", query = "SELECT r FROM Resource r WHERE r.upin = :upin"),
    @NamedQuery(name = "Resource.findByTaxonomy", query = "SELECT r FROM Resource r WHERE r.taxonomy = :taxonomy"),
    @NamedQuery(name = "Resource.findByDateOfJoin", query = "SELECT r FROM Resource r WHERE r.dateOfJoin = :dateOfJoin"),
    @NamedQuery(name = "Resource.findByDateOfRetire", query = "SELECT r FROM Resource r WHERE r.dateOfRetire = :dateOfRetire"),
    @NamedQuery(name = "Resource.findByDefaultRoomNo", query = "SELECT r FROM Resource r WHERE r.defaultRoomNo = :defaultRoomNo"),
    @NamedQuery(name = "Resource.findByFirstRate", query = "SELECT r FROM Resource r WHERE r.firstRate = :firstRate"),
    @NamedQuery(name = "Resource.findBySubsequentRate", query = "SELECT r FROM Resource r WHERE r.subsequentRate = :subsequentRate"),
    @NamedQuery(name = "Resource.findByRemarks", query = "SELECT r FROM Resource r WHERE r.remarks = :remarks"),
    @NamedQuery(name = "Resource.findByStateLicenceNo", query = "SELECT r FROM Resource r WHERE r.stateLicenceNo = :stateLicenceNo"),
    @NamedQuery(name = "Resource.findByVistaIen", query = "SELECT r FROM Resource r WHERE r.vistaIen = :vistaIen"),
    @NamedQuery(name = "Resource.findByLastName", query = "SELECT r FROM Resource r WHERE r.lastName = :lastName"),
    @NamedQuery(name = "Resource.findByMiddleName", query = "SELECT r FROM Resource r WHERE r.middleName = :middleName"),
    @NamedQuery(name = "Resource.findByFirstName", query = "SELECT r FROM Resource r WHERE r.firstName = :firstName"),
    @NamedQuery(name = "Resource.findByStatus", query = "SELECT r FROM Resource r WHERE r.status = :status"),
    @NamedQuery(name = "Resource.findByInactiveBy", query = "SELECT r FROM Resource r WHERE r.inactiveBy = :inactiveBy"),
    @NamedQuery(name = "Resource.findByInactiveDateTime", query = "SELECT r FROM Resource r WHERE r.inactiveDateTime = :inactiveDateTime")})
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "RESOURCE_CODE", length = 10)
    private String resourceCode;
    @Column(name = "CREDENTIALS", length = 20)
    private String credentials;
    @Column(name = "SEX", length = 1)
    private String sex;
    @Column(name = "ADDRESS1", length = 50)
    private String address1;
    @Column(name = "ADDRESS2", length = 100)
    private String address2;
    @Column(name = "City", length = 50)
    private String city;
    @Column(name = "State", length = 50)
    private String state;
    @Column(name = "Zip", length = 10)
    private String zip;
    @Column(name = "EMAIL", length = 50)
    private String email;
    @Column(name = "SPI_NO", length = 15)
    private String spiNo;
    @Column(name = "WPHONE", length = 20)
    private String wphone;
    @Column(name = "FAX", length = 20)
    private String fax;
    @Column(name = "HPHONE", length = 20, nullable = false)
    private String hphone;
    @Column(name = "CPHONE", length = 20)
    private String cphone;
    @Column(name = "SSN", length = 15)
    private String ssn;
    @Column(name = "DEA_NO", length = 20)
    private String deaNo;
    @Column(name = "FEDERAL_TAX_ID", length = 15)
    private String federalTaxId;
    @Column(name = "NPI", length = 15)
    private String npi;
    @Column(name = "UPIN", length = 15)
    private String upin;
    @Column(name = "TAXONOMY", length = 50)
    private String taxonomy;
    @Column(name = "DATE_OF_JOIN")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoin;
    @Column(name = "DATE_OF_RETIRE")
    @Temporal(TemporalType.DATE)
    private Date dateOfRetire;
    @Column(name = "DEFAULT_ROOM_NO", length = 10)
    private String defaultRoomNo;
    @Column(name = "FIRST_RATE")
    private Integer firstRate;
    @Column(name = "SUBSEQUENT_RATE")
    private Integer subsequentRate;
    @Column(name = "REMARKS", length = 50)
    private String remarks;
    @Column(name = "STATE_LICENCE_NO", length = 20)
    private String stateLicenceNo;
    @Column(name = "VISTA_IEN")
    private Integer vistaIen;
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;
    @Column(name = "MIDDLE_NAME", length = 50)
    private String middleName;
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "STATUS", nullable = false, length = 2)
    private String status;
    @Column(name = "INACTIVE_BY")
    private Integer inactiveBy;
    @Column(name = "INACTIVE_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inactiveDateTime;
    @JoinColumn(name = "RESOURCE_TYPE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TypeItems resourceTypeId;
    @OneToMany(mappedBy = "referringPhysician")
    private Collection<Patient> patientCollection;
    @OneToMany(mappedBy = "primaryPhysician")
    private Collection<Patient> patientCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referredFrom")
    private Collection<Slot> slotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceCode")
    private Collection<Slot> slotCollection1;
    @OneToMany(mappedBy = "resourceId")
    private Collection<Block> blockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceId")
    private Collection<GroupResources> groupResourcesCollection;    
	@JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "FACILITY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Facility facilityId;    

    public Resource() {
    }

    public Resource(Integer id) {
        this.id = id;
    }

    public Resource(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpiNo() {
        return spiNo;
    }

    public void setSpiNo(String spiNo) {
        this.spiNo = spiNo;
    }

    public String getWphone() {
        return wphone;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDeaNo() {
        return deaNo;
    }

    public void setDeaNo(String deaNo) {
        this.deaNo = deaNo;
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

    public String getUpin() {
        return upin;
    }

    public void setUpin(String upin) {
        this.upin = upin;
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Date getDateOfRetire() {
        return dateOfRetire;
    }

    public void setDateOfRetire(Date dateOfRetire) {
        this.dateOfRetire = dateOfRetire;
    }

    public String getDefaultRoomNo() {
        return defaultRoomNo;
    }

    public void setDefaultRoomNo(String defaultRoomNo) {
        this.defaultRoomNo = defaultRoomNo;
    }

    public Integer getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(Integer firstRate) {
        this.firstRate = firstRate;
    }

    public Integer getSubsequentRate() {
        return subsequentRate;
    }

    public void setSubsequentRate(Integer subsequentRate) {
        this.subsequentRate = subsequentRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStateLicenceNo() {
        return stateLicenceNo;
    }

    public void setStateLicenceNo(String stateLicenceNo) {
        this.stateLicenceNo = stateLicenceNo;
    }

    public Integer getVistaIen() {
        return vistaIen;
    }

    public void setVistaIen(Integer vistaIen) {
        this.vistaIen = vistaIen;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInactiveBy() {
        return inactiveBy;
    }

    public void setInactiveBy(Integer inactiveBy) {
        this.inactiveBy = inactiveBy;
    }

    public Date getInactiveDateTime() {
        return inactiveDateTime;
    }

    public void setInactiveDateTime(Date inactiveDateTime) {
        this.inactiveDateTime = inactiveDateTime;
    }

    public TypeItems getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(TypeItems resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }
    
    public Facility getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Facility facilityId) {
		this.facilityId = facilityId;
	}

	public Service getServiceId() {
		return serviceId;
	}

	public void setServiceId(Service serviceId) {
		this.serviceId = serviceId;
	}

	@XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection1() {
        return patientCollection1;
    }

    public void setPatientCollection1(Collection<Patient> patientCollection1) {
        this.patientCollection1 = patientCollection1;
    }

    @XmlTransient
    public Collection<Slot> getSlotCollection() {
        return slotCollection;
    }

    public void setSlotCollection(Collection<Slot> slotCollection) {
        this.slotCollection = slotCollection;
    }

    @XmlTransient
    public Collection<Slot> getSlotCollection1() {
        return slotCollection1;
    }

    public void setSlotCollection1(Collection<Slot> slotCollection1) {
        this.slotCollection1 = slotCollection1;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection() {
        return blockCollection;
    }

    public void setBlockCollection(Collection<Block> blockCollection) {
        this.blockCollection = blockCollection;
    }

    @XmlTransient
    public Collection<GroupResources> getGroupResourcesCollection() {
        return groupResourcesCollection;
    }

    public void setGroupResourcesCollection(Collection<GroupResources> groupResourcesCollection) {
        this.groupResourcesCollection = groupResourcesCollection;
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
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etipl.pms.entity.Resource[ id=" + id + " ]";
    }
    
}
