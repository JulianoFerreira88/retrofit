/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.retrofit.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ECUSCASTROLANDAFINANCEIRO", catalog = "", schema = "")
@XmlRootElement
public class Ecuscastrolandafinanceiro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDCASTROLANDAFINANCEIRO")
    private Integer cdcastrolandafinanceiro;
    @Column(name = "DTLANCAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtlancamento;
    @Column(name = "CDEMPRESA")
    private Integer cdempresa;
    @ManyToOne(targetEntity = Ecuscastrolandaconta.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "CDCONTAFINANCEIRA")
    private Ecuscastrolandaconta cdcontafinanceira;
    @Column(name = "NMPRODUTO")
    private String nmproduto;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    @Column(name = "VALORTOTAL")
    private Integer valortotal;
    @Column(name = "CDENTIDADE")
    private Integer cdentidade;
    @Column(name = "NUNOTA")
    private String nunota;
    @Column(name = "NUSERIE")
    private String nuserie;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "FLIMPORTACASTROLANDA")
    private String flimportacastrolanda;
    @Column(name = "DTREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtregistro;
    @Column(name = "VOLUME")
    private Integer volume;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdcastrolandafinanceiro != null ? cdcastrolandafinanceiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecuscastrolandafinanceiro)) {
            return false;
        }
        Ecuscastrolandafinanceiro other = (Ecuscastrolandafinanceiro) object;
        if ((this.cdcastrolandafinanceiro == null && other.cdcastrolandafinanceiro != null) || (this.cdcastrolandafinanceiro != null && !this.cdcastrolandafinanceiro.equals(other.cdcastrolandafinanceiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springfirebird.model.entities.financeiro.Ecuscastrolandafinanceiro[ cdcastrolandafinanceiro=" + cdcastrolandafinanceiro + " ]";
    }

}
