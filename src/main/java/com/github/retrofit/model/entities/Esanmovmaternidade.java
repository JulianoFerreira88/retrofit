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
@Table(name = "ESANMOVMATERNIDADE", catalog = "", schema = "")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Esanmovmaternidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDMOVMATERNIDADE")
    private Integer cdmovmaternidade;
    @Column(name = "DTREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtregistro;
    @Column(name = "DTMOVIMENTACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmovimentacao;
    @Column(name = "QTANIMAIS")
    private Integer qtanimais;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "FLMAEDELEITE")
    private String flmaedeleite;
    @Column(name = "DTMEDIANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmedianascimento;
    @Column(name = "PESOMEDIONASCIMENTO")
    private Double pesomedionascimento;
    
    @Column(name = "CDPARTOORIGEM")
    private Integer cdpartoorigem;

    @Column(name = "CDPARTODESTINO")
    private Integer cdpartodestino;

    @Column(name = "CDDESMAME")
    private Integer cddesmame;

   
}
