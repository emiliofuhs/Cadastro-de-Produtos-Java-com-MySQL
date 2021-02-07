<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Erro</title>
    </head>
    <<body>
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
    <h1>Nao foi possivel cadastrar o produto, valor do pesso Liquido nao pode ser MAIOR que o pesso Bruto</h1>
</body>
       
    </body>
</html>
