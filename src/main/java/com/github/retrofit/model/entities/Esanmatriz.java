package com.github.retrofit.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ESANMATRIZ", catalog = "", schema = "")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Esanmatriz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CDMATRIZ")
    private Integer cdmatriz;
    @Column(name = "ID1")
    private String id1;
    @Column(name = "ID2")
    private String id2;
    @Column(name = "DTNASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @Column(name = "DTENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Column(name = "NUCICLOS")
    private Short ciclos;
    @Column(name = "CICLOENTRADA")
    private Short cicloentrada;
    @Column(name = "FLESTADOREPRODUTIVO")
    private String estadoreprodutivo;
    @Column(name = "FLSITUACAO")
    private String situacao;
    @Column(name = "FLMAEDELEITE")
    private String maeDeLeite;
    @Column(name = "DTPRIMEIRACOBERTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primeiraCobertura;
    @Column(name = "DTCOBERTCOMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date compra;
    @Column(name = "FLCOMPRAGESTANTE")
    private String compragestante;
    @Column(name = "CDRACA", insertable = false, updatable = false)
    private Integer cdraca;

    @JoinColumn(name = "cdraca")
    @ManyToOne(targetEntity = Esanraca.class)
    private Esanraca raca;

    @OneToMany(mappedBy = "cdmatriz")
    private List<Esancobertura> coberturas;

    public List<Esanparto> getPartos() {
        List<Esanparto> partos = new ArrayList<>();
        for (Esancobertura c : getCoberturas()) {
            for (Esanparto p : c.getPartos()) {
                partos.add(p);
            }
        }
        Collections.sort(partos, new Comparator<Esanparto>() {
            @Override
            public int compare(Esanparto t, Esanparto t1) {
                if (t.getDtmedianascimento().getTime() > t1.getDtmedianascimento().getTime()) {
                    return 1;
                }
                if (t.getDtmedianascimento().getTime() < t1.getDtmedianascimento().getTime()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return partos;
    }

    public Esanparto getPartoAtual() {
        return getPartos().get(getPartos().size() - 1);
    }

    public int getDiasLactacao() {
        Esanparto partoAtual = getPartos().get(getPartos().size() - 1);
        Date dtInicio = partoAtual.getDtmedianascimento();
        Date dtFim = new Date();
        return (int) (dtInicio.getTime() - dtFim.getTime());
    }

    public double getSaldoAtual() {
        double saldo = getPartoAtual().getSaldo();
        return saldo;

    }

    public double getNota() {
        return 0.0;
    }

    public double getTotalNascidosVivos() {
        double totalNascidosVivos = 0.0;
        for (Esanparto parto : getPartos()) {
            totalNascidosVivos += parto.getNuvivo();
        }
        return totalNascidosVivos;
    }

    public double getTotalNatimortos() {
        double totalNtimortos = 0.0;
        for (Esanparto parto : getPartos()) {
            totalNtimortos += parto.getNunatimorto();
        }
        return totalNtimortos;
    }

    public double getTotalMumificados() {
        double totalMumificados = 0.0;
        for (Esanparto parto : getPartos()) {
            totalMumificados += parto.getNumumificado();
        }
        return totalMumificados;
    }

    public double getTotalMorteAoNascer() {
        double totalMorteAoNascer = 0.0;
        for (Esanparto parto : getPartos()) {
            totalMorteAoNascer += parto.getNumortoaonascer();
        }
        return totalMorteAoNascer;
    }

    public double getTotalNascidosTotais() {
        return getTotalNascidosVivos() + getTotalNatimortos() + getTotalMumificados() + getTotalMorteAoNascer();
    }

    public double getMediaNascidosTotais() {
        return getTotalNascidosTotais() / getPartos().size();
    }

    public double getMediaMumificados() {
        return getTotalMumificados() / getPartos().size();
    }

    public double getMediaNascidosVivos() {
        return getTotalNascidosVivos() / getPartos().size();
    }

    public double getMediaNatimortos() {
        return getTotalNatimortos() / getPartos().size();
    }

    public double getMediaMorteAoNascer() {
        return getTotalMorteAoNascer() / getPartos().size();
    }

    public double getTotalBaixaViabilidade() {
        double totalBaixaViabilidade = 0.0;
        for (Esanparto p : getPartos()) {
            totalBaixaViabilidade += p.getNuleitoesabaixo();
        }
        return totalBaixaViabilidade;
    }

    public double getMediaBaixaViabilidade() {
        return getTotalBaixaViabilidade() / getPartos().size();
    }

    public long getIdade() {
        Date hoje = new Date();
        Date dtNascimento = this.getNascimento();
        long diff = hoje.getTime() - dtNascimento.getTime();
        return diff;
    }

    public double getPercentualNatimortos() {
        return (getTotalNatimortos() * 100) / getTotalNascidosTotais();
    }

    private double getPercent(double value) {
        return (value * 100) / getTotalNascidosTotais();
    }

    public double getPercentualMumificados() {
        return getPercent(getTotalMumificados());
    }

    public double getPercentualMorteAoNascer() {
        return getPercent(getTotalMorteAoNascer());
    }

    public double getPercentualBaixaViabilidade() {
        return (getTotalBaixaViabilidade() * 100) / getTotalNascidosVivos();
    }

}
