package br.com.turma.testes;

import br.com.turma.modelo.UsuarioDao;

public class TesteRemoverUsuario {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.remover(9);

		System.err.println(usuarioDao + " removido!!");
	}

}
