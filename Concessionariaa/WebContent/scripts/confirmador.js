/**
 * confirmar a exclusao de um carro
 * @author nicolas cardoso
 * @param idCarro
 */
 
 function confirmar(idCarro){
	let resposta = confirm("Confirma a exclusão deste carro ?");
	if (resposta === true){
		window.location.href = "delete?idCarro=" + idCarro;
	}
}
