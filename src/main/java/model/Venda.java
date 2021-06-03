package model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_venda")
public class Venda {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_venda" )
    private Integer id;

    @JoinColumn(name = "cliente_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany( mappedBy = "venda")
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "id_supermercado")
    private Supermercado supermercado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }
}