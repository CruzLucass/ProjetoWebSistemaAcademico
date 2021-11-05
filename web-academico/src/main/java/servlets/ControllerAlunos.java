package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.EnderecoDao;
import model.Aluno;
import model.Endereco;

/**
 * Servlet implementation class ControllerAlunos
 */
@WebServlet({ "/ControllerAlunos", "/controlleralunos" })
public class ControllerAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAlunos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlunoDao daoAluno = new AlunoDao();
		int alunoid = Integer.parseInt(request.getParameter("alunoId"));
		
		if(alunoid>0) {			
			
			Aluno alu = daoAluno.get(alunoid);
			
			alu.getEndereco().setRua(request.getParameter("rua"));
			alu.getEndereco().setNr(request.getParameter("nr"));
			alu.getEndereco().setCidade(request.getParameter("cidade"));

			alu.setMatricula(request.getParameter("matricula"));
			alu.setNome(request.getParameter("nome"));
			alu.setDataNascimento(request.getParameter("dataNascimento"));
			
			daoAluno.update(alu);
			
			response.sendRedirect("alunoscom.jsp?msg=add");
		}else
		{
			Endereco address = new Endereco();
			address.setRua(request.getParameter("rua"));
			address.setNr(request.getParameter("nr"));
			address.setCidade(request.getParameter("cidade"));
			
			
			Aluno alu = new Aluno();
			alu.setMatricula(request.getParameter("matricula"));
			alu.setNome(request.getParameter("nome"));
			alu.setDataNascimento(request.getParameter("dataNascimento"));
			alu.setEndereco(address);
			
			daoAluno.save(alu);
		}
		
	}

}
