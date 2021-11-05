<%@page import="dao.AlunoDao"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <%
    AlunoDao daoAluno = new AlunoDao();
    List<Aluno> listaAlunos = daoAluno.getAll();        
    %>
    
    <a href="alunosadd.jsp">Novo Aluno</a>
    
    <% if(!listaAlunos.isEmpty()){ %>
    
    <table>
	    <thead>
	        <tr>
	            <th>Matricula</th>
	            <th>Nome</th>
	            <th>Data Nascimento</th>
	            <th>Ações</th>    
	        </tr>
	    
	    </thead>
	    <tbody>
	    
	       <% for(Aluno aluno: listaAlunos){ %>
	       
	       <tr>
	           <td><%= aluno.getMatricula() %></td>
	           <td><%= aluno.getNome() %></td>
	           <td><%= aluno.getDataNascimento() %></td>
	           <td><a href="alunosedit.jsp?id=<%=aluno.getId() %>" > Editar </a> Excluir</td>
	       </tr>
	       
	       <%} %>
	       
	    </tbody>
    </table>
    
    <% }else{ %>
    
    <p> SEM ALUNOS CADASTRADOS </p>
    
    <% } %>
    
</body>
</html>