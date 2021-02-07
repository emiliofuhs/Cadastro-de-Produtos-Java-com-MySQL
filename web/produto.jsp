<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.js"></script>
<script type="text/javascript" src="http://www.godtur.no/godtur/js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Cadastrar novo Produto</title>
</head>
<body>
    <form method="POST" action='ProdutoController' name="frmAddProduto">
        
        ID : <input type="disabled" readonly="readonly" name="id"
            value="<c:out value="${produto.id}" />" /> 
        
        <br /> 
        
        Nome : <input type="text" required="required" name="nome" maxlength="200"
            value="<c:out value="${produto.nome}" />" /> 
        
        <br /> 
        
        Veiculo: <input type="text" name="veiculo" maxlength="200"
            value="<c:out value="${produto.veiculo}" />" /> 
        
        <br /> 
        
        Peso Liquido :
        <input type="text" placeholder="00,00" required="required" name="pesoliquido" 
            value="<fmt:formatNumber value="${produto.pesoLiquido}" />" /> 
        
        <br /> 
        
        Peso Bruto : <input type="text"  placeholder="00,00" required="required" name="pesobruto" 
            value="<fmt:formatNumber value="${produto.pesoBruto}" />" /> 
        
        <br /> 
        
        <input type="submit" value="Submit" />
    </form>
</body>
</html>