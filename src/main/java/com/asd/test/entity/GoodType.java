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
@Table(name = "GOOD_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodType.findAll", query = "SELECT g FROM GoodType g"),
    @NamedQuery(name = "GoodType.findByGoodTypeId", query = "SELECT g FROM GoodType g WHERE g.goodTypeId = :goodTypeId"),
    @NamedQuery(name = "GoodType.findByGoodType", query = "SELECT g FROM GoodType g WHERE g.goodType = :goodType"),
    @NamedQuery(name = "GoodType.findByDescription", query = "SELECT g FROM GoodType g WHERE g.description = :description")})
public class GoodType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GOOD_TYPE_ID")
    private BigDecimal goodTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GOOD_TYPE")
    private String goodType;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;

    public GoodType() {
    }

    public GoodType(BigDecimal goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public GoodType(BigDecimal goodTypeId, String goodType) {
        this.goodTypeId = goodTypeId;
        this.goodType = goodType;
    }

    public BigDecimal getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(BigDecimal goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
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
        hash += (goodTypeId != null ? goodTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodType)) {
            return false;
        }
        GoodType other = (GoodType) object;
        if ((this.goodTypeId == null && other.goodTypeId != null) || (this.goodTypeId != null && !this.goodTypeId.equals(other.goodTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.test.entity.GoodType[ goodTypeId=" + goodTypeId + " ]";
    }
    
}
