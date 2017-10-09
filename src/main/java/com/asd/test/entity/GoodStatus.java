/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teddy
 */
@Entity
@Table(name = "GOOD_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodStatus.findAll", query = "SELECT g FROM GoodStatus g"),
    @NamedQuery(name = "GoodStatus.findByGoodStatusId", query = "SELECT g FROM GoodStatus g WHERE g.goodStatusId = :goodStatusId"),
    @NamedQuery(name = "GoodStatus.findByGoodStatus", query = "SELECT g FROM GoodStatus g WHERE g.goodStatus = :goodStatus"),
    @NamedQuery(name = "GoodStatus.findByDescription", query = "SELECT g FROM GoodStatus g WHERE g.description = :description")})
public class GoodStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GOOD_STATUS_ID")
    private BigDecimal goodStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GOOD_STATUS")
    private String goodStatus;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;

    public GoodStatus() {
    }

    public GoodStatus(BigDecimal goodStatusId) {
        this.goodStatusId = goodStatusId;
    }

    public GoodStatus(BigDecimal goodStatusId, String goodStatus) {
        this.goodStatusId = goodStatusId;
        this.goodStatus = goodStatus;
    }

    public BigDecimal getGoodStatusId() {
        return goodStatusId;
    }

    public void setGoodStatusId(BigDecimal goodStatusId) {
        this.goodStatusId = goodStatusId;
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodStatusId != null ? goodStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodStatus)) {
            return false;
        }
        GoodStatus other = (GoodStatus) object;
        if ((this.goodStatusId == null && other.goodStatusId != null) || (this.goodStatusId != null && !this.goodStatusId.equals(other.goodStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.test.entity.GoodStatus[ goodStatusId=" + goodStatusId + " ]";
    }
    
}
