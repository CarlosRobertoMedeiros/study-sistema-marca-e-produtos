package br.com.roberto.produtosemarcas.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuarios")
@SequenceGenerator(name = "Usuario_Id", sequenceName = "seq_usuario" , schema = "App" , initialValue = 1, allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Usuario_Id")
    private long id;

    private String nome;
    private String username;
    private String password;

    @JsonIgnoreProperties("usuarios")
    @ManyToMany(mappedBy = "usuarios")
    private List<Role> roles;

    public Usuario() {}

    public Usuario(String nome, String username, String password) {
        this.nome = nome;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> recuperarRoles() {
        return convertListRolesToListString();
    }

    private List<String> convertListRolesToListString() {
        List<String> regras = new ArrayList<>();
        for (Role role : roles) {
            regras.add(role.getNome());
        }

        return regras;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", Roles=" + roles +
                '}';
    }
}
