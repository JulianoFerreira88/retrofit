package com.github.retrofit.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ESANPARTO", catalog = "", schema = "")
@XmlRootElement
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Esanparto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDPARTO")
    private Integer cdparto;
    @Column(name = "CDCOBERTURA")
    private Integer cdcobertura;
    @Column(name = "DTREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtregistro;
    @Column(name = "DTINICIOPARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtinicioparto;
    @Column(name = "DTFIMPARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtfimparto;
    @Column(name = "HORAINICIOPARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horainicioparto;
    @Column(name = "HORAFIMPARTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafimparto;
    @Column(name = "PESOLEITEGADA")
    private Double pesoleitegada;
    @Column(name = "NUMUMIFICADO")
    private Integer numumificado;
    @Column(name = "NUNATIMORTO")
    private Integer nunatimorto;
    @Column(name = "NUMORTOAONASCER")
    private Integer numortoaonascer;
    @Column(name = "NUVIVO")
    private Integer nuvivo;
    @Column(name = "NUDOADO")
    private Integer nudoado;
    @Column(name = "NURECEBIDO")
    private Integer nurecebido;
    @Column(name = "PESOMEDIONASCIMENTO")
    private Double pesomedionascimento;
    @Column(name = "DTMEDIANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmedianascimento;
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CICLO")
    private Integer ciclo;
    @Column(name = "NUBAIA")
    private String nubaia;
    @Column(name = "NULEITOESABAIXO")
    private Integer nuleitoesabaixo;
    @Column(name = "NULEITOESENTRE")
    private Integer nuleitoesentre;
    @Column(name = "NULEITOESACIMA")
    private Integer nuleitoesacima;
    @Column(name = "DURACAO")
    private String duracao;
    @Column(name = "CDMATRIZ")
    private Integer cdmatriz;

    @JoinColumn(name = "cdfuncionario")
    @ManyToOne(targetEntity = Esanfuncionario.class)
    private Esanfuncionario funcionario;
    @Column(name = "CDFUNCIONARIO", insertable = false, updatable = false)
    private Integer cdfuncionario;

    @Column(name = "CDTIPOPARTO", insertable = false, updatable = false)
    private Integer cdtipoparto;

    @JoinColumn(name = "cdtipoparto")
    @ManyToOne(targetEntity = Esantipoparto.class)
    private Esantipoparto tipoDeParto;
    @OneToMany(mappedBy = "cdrelacionado")
    private List<Esanmovanimais> movimentacoes;

    @OneToMany(mappedBy = "cdpartoorigem")
    private List<Esanmovmaternidade> saidas;

    @OneToMany(mappedBy = "cdpartodestino")
    private List<Esanmovmaternidade> entradas;

    public double getSaldo() {
        Integer nv = getNuvivo();
        Integer doados = getNudoado();
        Integer recebidos = getNurecebido();
        Integer mortes = 0;
        List<Esanmovanimais> movs = getMovimentacoes();
        movs.removeIf((Esanmovanimais t) -> !t.getFltipo().equals("O"));
        for (Esanmovanimais mov : movs) {
            mortes += Math.abs(mov.getQtanimais());
        }
        return (nv + recebidos) - (doados + mortes);
    }
}
