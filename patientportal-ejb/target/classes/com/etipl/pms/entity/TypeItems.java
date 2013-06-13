/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etipl.pms.entity;

import java.io.Serializable;
import java.util.Collection;

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
@Table(name = "TYPE_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeItems.findAll", query = "SELECT t FROM TypeItems t"),
    @NamedQuery(name = "TypeItems.findById", query = "SELECT t FROM TypeItems t WHERE t.id = :id"),
    @NamedQuery(name = "TypeItems.findByCode", query = "SELECT t FROM TypeItems t WHERE t.code = :code"),
    @NamedQuery(name = "TypeItems.findByDescription", query = "SELECT t FROM TypeItems t WHERE t.description = :description"),
    @NamedQuery(name = "TypeItems.findByStatus", query = "SELECT t FROM TypeItems t WHERE t.status = :status"),
    @NamedQuery(name = "TypeItems.findByHtmlComments", query = "SELECT t FROM TypeItems t WHERE t.htmlComments = :htmlComments")})
public class TypeItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "Code", length = 10, nullable = false)
    private String code;
    @Column(name = "Description", length = 100)
    private String description;
    @Column(name = "Status", length = 2)
    private String status;
    @Lob
    @Column(name = "COMMENTS", length = 65535)
    private String comments;
    @Column(name = "HTML_COMMENTS", length = 250)
    private String htmlComments;
    @JoinColumn(name = "Type_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne
    private Type typeID;
    @OneToMany(mappedBy = "vison")
    private Collection<Facility> facilityCollection;

    public TypeItems() {
    }

    public TypeItems(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getHtmlComments() {
        return htmlComments;
    }

    public void setHtmlComments(String htmlComments) {
        this.htmlComments = htmlComments;
    }

    public Type getTypeID() {
        return typeID;
    }

    public void setTypeID(Type typeID) {
        this.typeID = typeID;
    }

    @XmlTransient
    public Collection<Facility> getFacilityCollection() {
        return facilityCollection;
    }

    public void setFacilityCollection(Collection<Facility> facilityCollection) {
        this.facilityCollection = facilityCollection;
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
        if (!(object instanceof TypeItems)) {
            return false;
        }
        TypeItems other = (TypeItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etipl.pms.entity.TypeItems[ id=" + id + " ]";
    }
    
}
