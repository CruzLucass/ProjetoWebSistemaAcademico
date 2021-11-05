<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Alunos</title>
</head>
<body>
     
     <form action="controlleralunos" method="post">
     
        <label>Matricula</label>
        <input type="text" name="matricula"/>
        <br/>
        
        <label>Nome</label>
        <input type="text" name="nome"/>
        <br/>
        
        <label>Data de Nascimento</label>
        <input type="text" name="dataNascimento"/>
        <br/>
        
        <label>Rua</label>
        <input type="text" name="rua"/>
        <br/>
        
        <label>Numero</label>
        <input type="text" name="nr"/>
        <br/>
        
        <label>Cidade</label>
        <input type="text" name="cidade"/>        
        <br/>
        
        <input type="submit" value="Salvar">
        
     </form>
     
</body>
</html>