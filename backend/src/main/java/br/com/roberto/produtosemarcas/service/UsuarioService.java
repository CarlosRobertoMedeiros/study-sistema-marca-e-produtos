package br.com.roberto.produtosemarcas.service;

import br.com.roberto.produtosemarcas.dao.UsuarioDAO;
import br.com.roberto.produtosemarcas.model.Usuario;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario recuperarUsuarioComLoginESenha(String usuario, String password) {
        return usuarioDAO.recuperarUsuarioPorUsernameEPassword(usuario, password);
    }

}
