package br.com.turma.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;
import br.com.turma.simulabanco.Banco;

@WebServlet("/mostrar")
public class MostraServert extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsuarioDao usuariodao = new UsuarioDao();
		ArrayList<Usuario> usuarios = usuariodao.mostrarTodos();

		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("/formMostrar.jsp");
		rd.forward(request, response);
	}

}
