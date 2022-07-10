/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.retrofit.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juliano
 */
@Entity
@Table(name = "ECUSCASTROLANDACONTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecuscastrolandaconta.findAll", query = "SELECT e FROM Ecuscastrolandaconta e"),
    @NamedQuery(name = "Ecuscastrolandaconta.findByCdconta", query = "SELECT e FROM Ecuscastrolandaconta e WHERE e.cdconta = :cdconta"),
    @NamedQuery(name = "Ecuscastrolandaconta.findByNmconta", query = "SELECT e FROM Ecuscastrolandaconta e WHERE e.nmconta = :nmconta"),
    @NamedQuery(name = "Ecuscastrolandaconta.findByCdgrupoconta", query = "SELECT e FROM Ecuscastrolandaconta e WHERE e.cdgrupoconta = :cdgrupoconta"),
    @NamedQuery(name = "Ecuscastrolandaconta.findByFltipoconta", query = "SELECT e FROM Ecuscastrolandaconta e WHERE e.fltipoconta = :fltipoconta")})
public class Ecuscastrolandaconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDCONTA")
    private Integer cdconta;
    @Column(name = "NMCONTA")
    private String nmconta;
    @Column(name = "CDGRUPOCONTA")
    private Integer cdgrupoconta;
    @Column(name = "FLTIPOCONTA")
    private String fltipoconta;

    public Ecuscastrolandaconta() {
    }

    public Ecuscastrolandaconta(Integer cdconta) {
        this.cdconta = cdconta;
    }

    public Integer getCdconta() {
        return cdconta;
    }

    public void setCdconta(Integer cdconta) {
        this.cdconta = cdconta;
    }

    public String getNmconta() {
        return nmconta;
    }

    public void setNmconta(String nmconta) {
        this.nmconta = nmconta;
    }

    public Integer getCdgrupoconta() {
        return cdgrupoconta;
    }

    public void setCdgrupoconta(Integer cdgrupoconta) {
        this.cdgrupoconta = cdgrupoconta;
    }

    public String getFltipoconta() {
        return fltipoconta;
    }

    public void setFltipoconta(String fltipoconta) {
        this.fltipoconta = fltipoconta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdconta != null ? cdconta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecuscastrolandaconta)) {
            return false;
        }
        Ecuscastrolandaconta other = (Ecuscastrolandaconta) object;
        if ((this.cdconta == null && other.cdconta != null) || (this.cdconta != null && !this.cdconta.equals(other.cdconta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springfirebird.model.entities.financeiro.Ecuscastrolandaconta[ cdconta=" + cdconta + " ]";
    }
    
}
