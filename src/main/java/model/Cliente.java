package model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Diego Patrício
 * */

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_supermercado")
    private Supermercado supermercado;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Venda getVendas() {
        return venda;
    }

    public void setVendas(Venda venda) {
        this.venda = venda;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    @Override
    public String toString() {
        return "ID: " + id +
            " | Nome: " + nome +
            " | CPF: " + cpf + "\n";
    }
}
