/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.retrofit.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "ESANCOBERTURA", catalog = "", schema = "")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Esancobertura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDCOBERTURA")
    private Integer cdcobertura;
    @Column(name = "DTREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtregistro;
    @Column(name = "DTCOBERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtcobertura;
    @Column(name = "HORACOBERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horacobertura;
    @Column(name = "CICLO")
    private Integer ciclo;
    @Column(name = "FLMAEDELEITE")
    private String maeDeLeite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "IDCOBERTURA")
    private Integer idcobertura;
    @Column(name = "FLINSEMINACAO")
    private String flinseminacao;
    @Column(name = "OBS")
    private String obs;

    @Column(name = "FLCOBERTANALACTACAO")
    private String flcobertanalactacao;
    @Column(name = "NUBAIA")
    private String nubaia;

    @Column(name = "FLCOMPRAGESTANTE")
    private String flcompragestante;

    @Column(name = "CDMATRIZ")
    private Integer cdmatriz;

//    @Column(name = "CDFUNCIONARIO", )
//    private Integer cdfuncionario;

    @JoinColumn(name = "cdfuncionario")
    @ManyToOne(targetEntity = Esanfuncionario.class)
    private Esanfuncionario funcionario;
    
    @OneToMany(mappedBy = "cdcobertura")
    private List<Esanparto> partos;

    @OneToMany(mappedBy = "cdcobertura")
    private List<Esandesmame> desmames;

    @OneToMany(mappedBy = "cdcobertura")
    private List<Econdesmamesparciais> desmamesParcias;
}
