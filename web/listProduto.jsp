<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Todos os Produtos</title>
    </head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Veiculo</th>
                <th>Peso Liquido</th>
                <th>Peso Bruto</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.id}" /></td>
                    <td><c:out value="${produto.nome}" /></td>
                    <td><c:out value="${produto.veiculo}" /></td>
                    <td><c:out value="${produto.pesoLiquido}" /></td>
                    <td><c:out value="${produto.pesoBruto}" /></td>
                    <td><a href="ProdutoController?action=edit&Id=<c:out value="${produto.id}"/>">Update</a></td>
                    <td><a href="ProdutoController?action=delete&Id=<c:out value="${produto.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ProdutoController?action=insert">Cadastrar</a></p>
</body>
</html>