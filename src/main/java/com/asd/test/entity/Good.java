/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teddy
 */
@Entity
@Table(name = "GOOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Good.findAll", query = "SELECT g FROM Good g"),
    @NamedQuery(name = "Good.findByGoodName", query = "SELECT g FROM Good g WHERE g.goodName = :goodName"),
    @NamedQuery(name = "Good.findBySerial", query = "SELECT g FROM Good g WHERE g.serial = :serial"),
    @NamedQuery(name = "Good.findByStockId", query = "SELECT g FROM Good g WHERE g.stockId = :stockId"),
    @NamedQuery(name = "Good.findByWeight", query = "SELECT g FROM Good g WHERE g.weight = :weight"),
    @NamedQuery(name = "Good.findByHeight", query = "SELECT g FROM Good g WHERE g.height = :height"),
    @NamedQuery(name = "Good.findByWidth", query = "SELECT g FROM Good g WHERE g.width = :width"),
    @NamedQuery(name = "Good.findByLongitude", query = "SELECT g FROM Good g WHERE g.longitude = :longitude"),
    @NamedQuery(name = "Good.findByPurchaseValue", query = "SELECT g FROM Good g WHERE g.purchaseValue = :purchaseValue"),
    @NamedQuery(name = "Good.findByPurchaseDate", query = "SELECT g FROM Good g WHERE g.purchaseDate = :purchaseDate"),
    @NamedQuery(name = "Good.findByDischargeDate", query = "SELECT g FROM Good g WHERE g.dischargeDate = :dischargeDate"),
    @NamedQuery(name = "Good.findByColor", query = "SELECT g FROM Good g WHERE g.color = :color"),
    @NamedQuery(name = "Good.findByDescription", query = "SELECT g FROM Good g WHERE g.description = :description"),
    @NamedQuery(name = "Good.findByRelType", query = "SELECT g FROM Good g WHERE g.relType = :relType"),
    @NamedQuery(name = "Good.findByGoodId", query = "SELECT g FROM Good g WHERE g.goodId = :goodId"),
    @NamedQuery(name = "Good.findByAreaId", query = "SELECT g FROM Good g WHERE g.areaId = :areaId"),
    @NamedQuery(name = "Good.findByGoodStatusId", query = "SELECT g FROM Good g WHERE g.goodStatusId = :goodStatusId"),
    @NamedQuery(name = "Good.findByGoodTypeId", query = "SELECT g FROM Good g WHERE g.goodTypeId = :goodTypeId"),
    @NamedQuery(name = "Good.findByPeopleId", query = "SELECT g FROM Good g WHERE g.peopleId = :peopleId")})
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GOOD_NAME")
    private String goodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERIAL")
    private BigInteger serial;
    @Column(name = "STOCK_ID")
    private BigInteger stockId;
    @Column(name = "WEIGHT")
    private BigInteger weight;
    @Column(name = "HEIGHT")
    private BigInteger height;
    @Column(name = "WIDTH")
    private BigInteger width;
    @Column(name = "LONGITUDE")
    private BigInteger longitude;
    @Column(name = "PURCHASE_VALUE")
    private BigInteger purchaseValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PURCHASE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
    @Column(name = "DISCHARGE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dischargeDate;
    @Size(max = 50)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REL_TYPE")
    private Character relType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(generator="goodSeq") 
    @SequenceGenerator(name="goodSeq",sequenceName="GOOD_SEQ", allocationSize=1) 
    @Column(name = "GOOD_ID")
    private BigDecimal goodId;
    @Column(name = "AREA_ID")
    private BigInteger areaId;
    @Column(name = "GOOD_STATUS_ID")
    private BigInteger goodStatusId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GOOD_TYPE_ID")
    private BigInteger goodTypeId;
    @Column(name = "PEOPLE_ID")
    private BigInteger peopleId;

    public Good() {
    }

    public Good(BigDecimal goodId) {
        this.goodId = goodId;
    }

    public Good(BigDecimal goodId, String goodName, BigInteger serial, Date purchaseDate, Character relType, BigInteger goodTypeId) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.serial = serial;
        this.purchaseDate = purchaseDate;
        this.relType = relType;
        this.goodTypeId = goodTypeId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigInteger getSerial() {
        return serial;
    }

    public void setSerial(BigInteger serial) {
        this.serial = serial;
    }

    public BigInteger getStockId() {
        return stockId;
    }

    public void setStockId(BigInteger stockId) {
        this.stockId = stockId;
    }

    public BigInteger getWeight() {
        return weight;
    }

    public void setWeight(BigInteger weight) {
        this.weight = weight;
    }

    public BigInteger getHeight() {
        return height;
    }

    public void setHeight(BigInteger height) {
        this.height = height;
    }

    public BigInteger getWidth() {
        return width;
    }

    public void setWidth(BigInteger width) {
        this.width = width;
    }

    public BigInteger getLongitude() {
        return longitude;
    }

    public void setLongitude(BigInteger longitude) {
        this.longitude = longitude;
    }

    public BigInteger getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(BigInteger purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getRelType() {
        return relType;
    }

    public void setRelType(Character relType) {
        this.relType = relType;
    }

    public BigDecimal getGoodId() {
        return goodId;
    }

    public void setGoodId(BigDecimal goodId) {
        this.goodId = goodId;
    }

    public BigInteger getAreaId() {
        return areaId;
    }

    public void setAreaId(BigInteger areaId) {
        this.areaId = areaId;
    }

    public BigInteger getGoodStatusId() {
        return goodStatusId;
    }

    public void setGoodStatusId(BigInteger goodStatusId) {
        this.goodStatusId = goodStatusId;
    }

    public BigInteger getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(BigInteger goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public BigInteger getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(BigInteger peopleId) {
        this.peopleId = peopleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodId != null ? goodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Good)) {
            return false;
        }
        Good other = (Good) object;
        if ((this.goodId == null && other.goodId != null) || (this.goodId != null && !this.goodId.equals(other.goodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asd.test.entity.Good[ goodId=" + goodId + " ]";
    }
    
}
