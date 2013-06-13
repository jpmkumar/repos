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
@Table(name = "SECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.fetchIdName", query = "SELECT s.id,s.sectionName FROM Section s"),
    @NamedQuery(name = "Section.findById", query = "SELECT s FROM Section s WHERE s.id = :id"),
    @NamedQuery(name = "Section.findBySectionCode", query = "SELECT s FROM Section s WHERE s.sectionCode = :sectionCode"),
    @NamedQuery(name = "Section.findBySectionName", query = "SELECT s FROM Section s WHERE s.sectionName = :sectionName"),
    @NamedQuery(name = "Section.findByFromHours", query = "SELECT s FROM Section s WHERE s.fromHours = :fromHours"),
    @NamedQuery(name = "Section.findByToHours", query = "SELECT s FROM Section s WHERE s.toHours = :toHours"),
    @NamedQuery(name = "Section.findByLocation", query = "SELECT s FROM Section s WHERE s.location = :location"),
    @NamedQuery(name = "Section.findByStatus", query = "SELECT s FROM Section s WHERE s.status = :status")})
public class Section implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "SECTION_CODE", length = 10)
    private String sectionCode;
    @Column(name = "SECTION_NAME", length = 50)
    private String sectionName;
    @Column(name = "FROM_HOURS")
    @Temporal(TemporalType.TIME)
    private Date fromHours;
    @Column(name = "TO_HOURS")
    @Temporal(TemporalType.TIME)
    private Date toHours;
    @Column(name = "LOCATION", length = 50)
    private String location;
    @Column(name = "STATUS", length = 2)
    private String status;
    @Column(name = "VISTA_IEN")
    private Integer vista_ien;
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "FACILITY_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Facility facilityId;
    @Column(name = "DSS_CODE", length = 50)
    private String dss_code;

    public String getDss_code() {
		return dss_code;
	}

	public void setDss_code(String dss_code) {
		this.dss_code = dss_code;
	}

	public Section() {
    }

    public Section(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }
    
    
    public Integer getVista_ien() {
		return vista_ien;
	}

	public void setVista_ien(Integer vista_ien) {
		this.vista_ien = vista_ien;
	}

	public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Date getFromHours() {
        return fromHours;
    }

    public void setFromHours(Date fromHours) {
        this.fromHours = fromHours;
    }

    public Date getToHours() {
        return toHours;
    }

    public void setToHours(Date date) {
        this.toHours = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
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
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etipl.pms.entity.Section[ id=" + id + " ]";
    }
    
}
