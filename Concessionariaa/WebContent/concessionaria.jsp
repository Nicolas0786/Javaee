<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("carros");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Revendedora de Carros</title>
<link rel="icon" href="imagens/icone.png">
<link rel="styLesheet" href="style.css">
</head>
<body>
	<h1>Revendedora de Carros Sorriso</h1>
	<a href="novo.html" class="Botao1">Novo Carro</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Marca</th>
				<th>Modelo</th>
				<th>Ano Modelo</th>
				<th>Ano Fabricação</th>
				<th>Placa</th>
				<th>Cor</th>
				<th>Quantidade de Portas</th>
				<th>Data de Inserção</th>
				<th>Valor</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdCarro()%></td>
				<td><%=lista.get(i).getMarca()%></td>
				<td><%=lista.get(i).getModelo()%></td>
				<td><%=lista.get(i).getAnoModelo()%></td>
				<td><%=lista.get(i).getAnoFabricacao()%></td>
				<td><%=lista.get(i).getPlaca()%></td>
				<td><%=lista.get(i).getCor()%></td>
				<td><%=lista.get(i).getQtdPortas()%></td>
				<td><%=lista.get(i).getDataInsercaoCarro()%></td>
				<td><%=lista.get(i).getValor()%></td>
				<td><a href="select?idCarro=<%=lista.get(i).getIdCarro()%>"
					class="Botao1">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdCarro()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>