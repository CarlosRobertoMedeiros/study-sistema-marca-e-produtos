package br.com.roberto.produtosemarcas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_role")
    @SequenceGenerator(name = "seq_id_role", sequenceName = "seq_role" , schema = "App" , initialValue = 10)
    private long id;

    private String nome;

    @ManyToMany
    private List<Usuario> usuarios;

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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
