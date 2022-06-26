package br.com.turma.simulabanco;

import java.util.ArrayList;
import java.util.Date;

import br.com.turma.modelo.Usuario;

public class Banco {

	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static Integer codigo = 0;

	static {
		Usuario usuario1 = new Usuario("Maria Silva", new Date(846295200000L), "msilva", "ms123");
		Usuario usuario2 = new Usuario("Pedro Ramos", new Date(962506800000L), "pramos", "pr123");
		Usuario usuario3 = new Usuario("Jonas Castro", new Date(399524400000L), "jcastro", "jc123");
		Banco.addUsuario(usuario1);
		Banco.addUsuario(usuario2);
		Banco.addUsuario(usuario3);

	}

	public static void addUsuario(Usuario usuario) {
		usuario.setCodigo(++codigo);
		Banco.usuarios.add(usuario);
	}

	public static ArrayList<Usuario> getUsuarios() {
		return Banco.usuarios;
	}
}
