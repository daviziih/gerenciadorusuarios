package br.com.turma.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.turma.jdbc.Conexao;

public class UsuarioDao {

	public void cadastrar(Usuario usuario) {

		Connection con = Conexao.obterConexao();

		String sql = "insert into usuario(nome,datanascimento,login,senha) values(?,?,?,?);";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setDate(2, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(3, usuario.getLogin());
			preparador.setString(4, usuario.getSenha());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> mostrarTodos() {
		

		Connection con = Conexao.obterConexao();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("datanascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				usuarios.add(usuario);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario buscarPorCodigo(Integer codigo) {

		Connection con = Conexao.obterConexao();
		Usuario usuario = null;
		String sql = "select * from usuario where codigo=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setDataNascimento(new java.util.Date(resultado.getDate("datanascimento").getTime()));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public void remover(Integer codigo) {

		Connection con = Conexao.obterConexao();

		String sql = "delete from usuario where codigo = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {

		Connection con = Conexao.obterConexao();

		String sql = "update usuario set nome=?,datanascimento=?,login=?,senha=? where codigo =?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setDate(2, new Date(usuario.getDataNascimento().getTime()));
			preparador.setString(3, usuario.getLogin());
			preparador.setString(4, usuario.getSenha());
			preparador.setInt(5, usuario.getCodigo());

			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
