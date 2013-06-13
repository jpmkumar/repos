/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etipl.pms.entity;

import java.io.Serializable;
import java.util.Collection;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edgeware
 */
@Entity
@Table(name = "APPOINTMENT_TYPE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppointmentType.findAll", query = "SELECT a FROM AppointmentType a"),
    @NamedQuery(name = "AppointmentType.findById", query = "SELECT a FROM AppointmentType a WHERE a.id = :id"),
    @NamedQuery(name = "AppointmentType.findByApptType", query = "SELECT a FROM AppointmentType a WHERE a.apptType = :apptType"),
    @NamedQuery(name = "AppointmentType.findByApptTypeDescription", query = "SELECT a FROM AppointmentType a WHERE a.apptTypeDescription = :apptTypeDescription"),
    @NamedQuery(name = "AppointmentType.findByApptTypeDuration", query = "SELECT a FROM AppointmentType a WHERE a.apptTypeDuration = :apptTypeDuration"),
    @NamedQuery(name = "AppointmentType.findByColor", query = "SELECT a FROM AppointmentType a WHERE a.color = :color"),
    @NamedQuery(name = "AppointmentType.findByStatus", query = "SELECT a FROM AppointmentType a WHERE a.status = :status")})
public class AppointmentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "APPOINTMENT_CATEGORY	", referencedColumnName = "ID")
    @ManyToOne
    private TypeItems apptCat;
    @Column(name = "APPT_TYPE", length = 10)
    private String apptType;
    @Column(name = "APPT_TYPE_DESCRIPTION", length = 50)
    private String apptTypeDescription;
    @Column(name = "APPT_TYPE_DURATION", length = 3)
    private String apptTypeDuration;
    @Column(name = "DSS_STOP", length = 10)
    private String dssStop;
    @Column(name = "DSS_CREDIT", length = 10)
    private String dssCredit;
    @Column(name = "COLOR", length = 10)
    private String color;
    @Column(name = "BACKGROUND_COLOR", length = 10)
    private String backgroundColor;
    @Column(name = "STATUS", length = 2)
    private String status;
    @Column(name = "AVAILABILITY_COLOR", length = 10)
    private String availabilityColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apptTypeId")
    private Collection<ResourceAvailability> resourceAvailabilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apptTypeId")
    private Collection<PatientApptRequest> patientApptRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apptTypeId")
    private Collection<Slot> slotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apptTypeId")
    private Collection<ApptTemplateDetail> apptTemplateDetailCollection;

    public AppointmentType() {
    }

    public AppointmentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeItems getApptCat() {
		return apptCat;
	}

	public void setApptCat(TypeItems apptCat) {
		this.apptCat = apptCat;
	}

	public String getDssStop() {
		return dssStop;
	}

	public void setDssStop(String dssStop) {
		this.dssStop = dssStop;
	}

	public String getDssCredit() {
		return dssCredit;
	}

	public void setDssCredit(String dssCredit) {
		this.dssCredit = dssCredit;
	}

	public String getApptType() {
        return apptType;
    }
    
    public void setApptType(String apptType) {
        this.apptType = apptType;
    }

    public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	    public String getApptTypeDescription() {
        return apptTypeDescription;
    }

    public void setApptTypeDescription(String apptTypeDescription) {
        this.apptTypeDescription = apptTypeDescription;
    }

    public String getApptTypeDuration() {
        return apptTypeDuration;
    }

    public void setApptTypeDuration(String apptTypeDuration) {
        this.apptTypeDuration = apptTypeDuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getAvailabilityColor() {
		return availabilityColor;
	}

	public void setAvailabilityColor(String availabilityColor) {
		this.availabilityColor = availabilityColor;
	}

	@XmlTransient
    public Collection<ResourceAvailability> getResourceAvailabilityCollection() {
        return resourceAvailabilityCollection;
    }

    public void setResourceAvailabilityCollection(Collection<ResourceAvailability> resourceAvailabilityCollection) {
        this.resourceAvailabilityCollection = resourceAvailabilityCollection;
    }

    @XmlTransient
    public Collection<PatientApptRequest> getPatientApptRequestCollection() {
        return patientApptRequestCollection;
    }

    public void setPatientApptRequestCollection(Collection<PatientApptRequest> patientApptRequestCollection) {
        this.patientApptRequestCollection = patientApptRequestCollection;
    }

    @XmlTransient
    public Collection<Slot> getSlotCollection() {
        return slotCollection;
    }

    public void setSlotCollection(Collection<Slot> slotCollection) {
        this.slotCollection = slotCollection;
    }

    @XmlTransient
    public Collection<ApptTemplateDetail> getApptTemplateDetailCollection() {
        return apptTemplateDetailCollection;
    }

    public void setApptTemplateDetailCollection(Collection<ApptTemplateDetail> apptTemplateDetailCollection) {
        this.apptTemplateDetailCollection = apptTemplateDetailCollection;
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
        if (!(object instanceof AppointmentType)) {
            return false;
        }
        AppointmentType other = (AppointmentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etipl.pms.entity.AppointmentType[ id=" + id + " ]";
    }
    
}
