package com.etipl.pms.entity;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edgeware
 */
@Entity
@Table(name = "TIMEZONES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timezones.findAll", query = "SELECT t FROM Timezones t"),
    @NamedQuery(name = "Timezones.findById", query = "SELECT t FROM Timezones t WHERE t.id = :id"),
    @NamedQuery(name = "Timezones.findByTimezone", query = "SELECT t FROM Timezones t WHERE t.timezone = :timezone"),
    @NamedQuery(name = "Timezones.findByOffset", query = "SELECT t FROM Timezones t WHERE t.offset = :offset"),
    @NamedQuery(name = "Timezones.findByDayLightSavings", query = "SELECT t FROM Timezones t WHERE t.dayLightSavings = :dayLightSavings")})
public class Timezones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "TIMEZONE", length = 50)
    private String timezone;
    @Column(name = "OFFSET", length = 50)
    private String offset;
    @Column(name = "DAY_LIGHT_SAVINGS", length = 2)
    private String dayLightSavings;
    @Column(name = "STATUS", length = 2)
    private String status;

    
    
    public Timezones() {
    }

    public Timezones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getDayLightSavings() {
        return dayLightSavings;
    }

    public void setDayLightSavings(String dayLightSavings) {
        this.dayLightSavings = dayLightSavings;
    }

    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "com.etipl.pms.entity.Timezones[ id=" + id + " ]";
    }
    
}
