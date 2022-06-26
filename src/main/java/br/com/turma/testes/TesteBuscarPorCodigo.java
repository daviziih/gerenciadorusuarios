package br.com.turma.testes;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

public class TesteBuscarPorCodigo {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscarPorCodigo(8);

		System.out.println("Codigo: " + usuario.getCodigo());
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println();
	}
}
