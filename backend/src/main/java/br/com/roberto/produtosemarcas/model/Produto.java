package br.com.roberto.produtosemarcas.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "tb_produtos")
@SequenceGenerator(name = "Produto_Id", sequenceName = "seq_produto" , schema = "App" , initialValue = 1, allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Produto_Id")
    private long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties({"produtos", "nome", "descricao"})
    private Marca marca;

    public Produto() {
    }

    public Produto(long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca= marca;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "titulo='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
