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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Juliano
 */
@Entity
@Table(name = "ESANDESMAME", catalog = "", schema = "")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Esandesmame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDDESMAME")
    private Integer cddesmame;
    @Column(name = "CDCOBERTURA")
    private Integer cdcobertura;
    @Column(name = "DTREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtregistro;
    @Column(name = "DTDESMAME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtdesmame;
    @Column(name = "NUDESMAMADO")
    private Integer desmamados;
    @Column(name = "NURECEBIDO")
    private Integer recebidos;
    @Column(name = "NUDOADO")
    private Integer doados;
    @Column(name = "NUMORTO")
    private Integer mortos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESOLEITEGADA")
    private Double pesoleitegada;
    @Column(name = "FLDESMAMEPARCIAL")
    private String fldesmameparcial;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CICLO")
    private Integer ciclo;
    @Column(name = "CDMATRIZ")
    private Integer cdmatriz;

}
