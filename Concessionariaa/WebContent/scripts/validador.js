/**
 * validacao de campos preenchidos
 * @author nicolas cardoso
 */
 
 function validar(){
	let marca = frmCarro.marca.value;
	let modelo = frmCarro.modelo.value;
	let anomod = frmCarro.anomod.value;
	let anofab = frmCarro.anofab.value;
	let placa = frmCarro.placa.value;
	let cor = frmCarro.cor.value;
	let qtdporta = frmCarro.qtdporta.value;
	let datainsercao = frmCarro.datainsercao.value;
	
	if (marca === ""){
		window.alert("Preencha o Campo Marca");
		frmCarro.marca.focus();
		return false;	
	}else if (modelo === ""){
		window.alert("Preencha o Campo Modelo");
		frmCarro.modelo.focus();
		return false;
	}else if (anomod === ""){
		window.alert("Preencha o Campo Ano Modelo");
		frmCarro.anomod.focus();
		return false;
	}else if (anofab === ""){
		window.alert("Preencha o Campo Ano Fabricação");
		frmCarro.anofab.focus();
		return false;
	}else if (placa === ""){
		window.alert("Preencha o Campo Placa");
		frmCarro.placa.focus();
		return false;
	}else if (cor === ""){
		window.alert("Preencha o Campo Cor");
		frmCarro.cor.focus();
		return false;
	}else if (qtdporta === ""){
		window.alert("Preencha o Campo Quantidade de Portas");
		frmCarro.qtdporta.focus();
		return false;
	}else if (datainsercao === ""){
		window.alert("Preencha o Campo da Data de Inserção");
		frmCarro.datainsercao.focus();
		return false;
	}else {
		document.forms["frmCarro"].submit();
	}

}