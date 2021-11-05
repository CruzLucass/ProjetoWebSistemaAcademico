<%@page import="model.Aluno"%>
<%@page import="dao.AlunoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Alunos</title>
</head>
<body>
    <%
    int alunosId = Integer.parseInt(request.getParameter("id"));
    AlunoDao daoAluno = new AlunoDao();
    Aluno alunocon = daoAluno.get(alunosId);
    %>
    <form action="controlleralunos" method="get">
        <input type="hidden" name="alunoid" value="<%= alunosId %>"/>
        
        <label>Matricula</label>
        <input type="text" name="matricula" value="<%= alunocon.getMatricula() %>"/>
        <br/>
        
        <label>Nome</label>
        <input type="text" name="nome" value="<%= alunocon.getNome() %>"/>
        <br/>
        
        <label>Data de Nascimento</label>
        <input type="text" name="dataNascimento" value="<%= alunocon.getDataNascimento() %>"/>
        <br/>
        
        <label>Rua</label>
        <input type="text" name="rua" value="<%= alunocon.getEndereco().getRua() %>"/>
        <br/>
        
        <label>Numero</label>
        <input type="text" name="nr" value="<%= alunocon.getEndereco().getNr() %>"/>
        <br/>
        
        <label>Cidade</label>
        <input type="text" name="cidade" value="<%= alunocon.getEndereco().getCidade() %>"/>        
        <br/>
        
        <input type="submit" value="Salvar" />
        <input type="submit" value="Deletar" />
     </form>
</body>
</html>