package com.github.retrofit.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ESANRACA", catalog = "", schema = "")
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Esanraca implements Serializable {

     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDRACA")
    private Integer cdraca;
    @Column(name = "NMRACA")
    private String nmraca;
    @Column(name = "FLSITUACAO")
    private String situacao;

}
