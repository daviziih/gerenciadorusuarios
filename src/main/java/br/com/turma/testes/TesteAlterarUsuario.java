package br.com.turma.testes;

import java.util.Date;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;

public class TesteAlterarUsuario {
	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(4);
		
		usuario.setNome("Davi");
		usuario.setDataNascimento(new Date());
		usuario.setLogin("Daviziih");
		usuario.setSenha("sw1234");
		
		UsuarioDao usuariodao = new UsuarioDao();
		usuariodao.alterar(usuario);
		
	}

}
