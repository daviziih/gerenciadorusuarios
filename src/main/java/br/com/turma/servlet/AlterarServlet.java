package br.com.turma.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.modelo.Usuario;
import br.com.turma.modelo.UsuarioDao;
import br.com.turma.simulabanco.Banco;

@WebServlet("/alterar")
public class AlterarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer codigo = Integer.valueOf(request.getParameter("codigo"));

		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscarPorCodigo(codigo);

		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterar.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer codigo = Integer.valueOf(request.getParameter("txtcodigo"));
		String nome = request.getParameter("txtnome");
		Date dataNascimento = converterParaDate(request.getParameter("txtdatanascimento"));
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");

		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuario.setNome(nome);
		usuario.setDataNascimento(dataNascimento);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.alterar(usuario);

		response.sendRedirect("mostrar");

	}

	Date converterParaDate(String dataComString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(dataComString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
}
