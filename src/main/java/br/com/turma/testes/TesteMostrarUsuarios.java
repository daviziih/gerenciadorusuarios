package br.com.turma.testes;

import java.util.ArrayList;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

public class TesteMostrarUsuarios {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();

		ArrayList<Usuario> listaDeUsuarios = usuarioDao.mostrarTodos();

		for (Usuario usuario : listaDeUsuarios) {
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
			System.out.println("Login: " + usuario.getLogin());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println();

		}
	}
}
