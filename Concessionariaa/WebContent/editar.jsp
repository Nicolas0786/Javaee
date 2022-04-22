<%@ page language="java" contentType="text/html; charse=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Revendedora de Carros</title>
<link rel="icon" href="imagens/icone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Carro</h1>
	<form name="frmCarro" action="update">
		<table>
			<tr>
				<td><input type="text" name="idCarro" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idCarro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="marca" class="Caixa1"
					value="<%out.print(request.getAttribute("marca"));%>"
					placeholder="Marca"></td>
			</tr>
			<tr>
				<td><input type="text" name="modelo" class="Caixa1"
					value="<%out.print(request.getAttribute("modelo"));%>"
					placeholder="Modelo"></td>
			</tr>
			<tr>
				<td><input type="number" name="anomod" class="Caixa2"
					value="<%out.print(request.getAttribute("anomod"));%>"
					placeholder="Ano Modelo"></td>
			</tr>
			<tr>
				<td><input type="number" name="anofab" class="Caixa2"
					value="<%out.print(request.getAttribute("anofab"));%>"
					placeholder="Ano Fabricação"></td>
			</tr>
			<tr>
				<td><input type="text" name="placa" class="Caixa1"
					value="<%out.print(request.getAttribute("placa"));%>"
					placeholder="Placa"></td>
			</tr>
			<tr>
				<td><input type="text" name="cor" class="Caixa1"
					value="<%out.print(request.getAttribute("cor"));%>"
					placeholder="Cor"></td>
			</tr>
			<tr>
				<td><input type="number" name="qtdporta" class="Caixa2"
					value="<%out.print(request.getAttribute("qtdporta"));%>"
					placeholder="Quantidade de Portas"></td>
			</tr>
			<tr>
				<td><input type="date" name="datainsercao" class="Caixa2"
					value="<%out.print(request.getAttribute("datainsercao"));%>"></td>
			</tr>
			<tr>
				<td><input type="number" name="valor" class="Caixa2"
					value="<%out.print(request.getAttribute("valor"));%>"
					placeholder="Valor"></td>
			</tr>

		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>

</body>
</html>