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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ESANLOTE", catalog = "", schema = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Esanlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDLOTE")
    private Integer cdlote;
    @Column(name = "NMLOTE")
    private String nmlote;
    @Column(name = "FLSITUACAO")
    private String flsituacao;
    @Column(name = "FLSITUACAO2")
    private String flsituacao2;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "DTMEDIANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmedianascimento;
    @Column(name = "DTMEDIANASCIMENTO2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmedianascimento2;

    @OneToMany(targetEntity = Esanmovanimais.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "CDLOTE")
    private List<Esanmovanimais> movimentacoes;
    
   

}
