package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_supermercado")
public class Supermercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supermercado")
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cnpj;

    @OneToMany(mappedBy = "supermercado", cascade= CascadeType.ALL)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "supermercado", cascade= CascadeType.ALL)
    private List<Cliente> clientes;

    @OneToMany(mappedBy = "supermercado", cascade= CascadeType.ALL)
    private  List<Venda> vendas;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
