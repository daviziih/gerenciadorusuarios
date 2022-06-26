package br.com.turma.testes;

import java.util.Date;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

public class TesteCadastrarUsuario {

	public static void main(String[] args) {

		Usuario usuario = new Usuario("Davi Gamer", new Date(), "gamerdaci", "teste");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrar(usuario);
	}

}
