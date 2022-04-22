package model;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The id carro. */
	private int idCarro;
	
	/** The marca. */
	private String marca;
	
	/** The modelo. */
	private String modelo;
	
	/** The ano modelo. */
	private int anoModelo;
	
	/** The ano fabricacao. */
	private int anoFabricacao;
	
	/** The placa. */
	private String placa;
	
	/** The cor. */
	private String cor;
	
	/** The qtd portas. */
	private int qtdPortas;
	
	/** The data insercao carro. */
	private LocalDate dataInsercaoCarro;
	
	/** The valor. */
	private long valor;

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idCarro the id carro
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param anoModelo the ano modelo
	 * @param anoFabricacao the ano fabricacao
	 * @param placa the placa
	 * @param cor the cor
	 * @param qtdPortas the qtd portas
	 * @param dataInsercaoCarro the data insercao carro
	 * @param valor the valor
	 */
	public JavaBeans(int idCarro, String marca, String modelo, int anoModelo, int anoFabricacao, String placa,
			String cor, int qtdPortas, LocalDate dataInsercaoCarro, long valor) {
		super();
		this.idCarro = idCarro;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.placa = placa;
		this.cor = cor;
		this.qtdPortas = qtdPortas;
		this.dataInsercaoCarro = dataInsercaoCarro;
		this.valor = valor;
	}

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();

	}

	/**
	 * Gets the id carro.
	 *
	 * @return the id carro
	 */
	public int getIdCarro() {
		return idCarro;
	}

	/**
	 * Sets the id carro.
	 *
	 * @param idCarro the new id carro
	 */
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Gets the modelo.
	 *
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Sets the modelo.
	 *
	 * @param modelo the new modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Gets the ano modelo.
	 *
	 * @return the ano modelo
	 */
	public int getAnoModelo() {
		return anoModelo;
	}

	/**
	 * Sets the ano modelo.
	 *
	 * @param anoModelo the new ano modelo
	 */
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	/**
	 * Gets the ano fabricacao.
	 *
	 * @return the ano fabricacao
	 */
	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	/**
	 * Sets the ano fabricacao.
	 *
	 * @param anoFabricacao the new ano fabricacao
	 */
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	/**
	 * Gets the placa.
	 *
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Sets the placa.
	 *
	 * @param placa the new placa
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * Gets the cor.
	 *
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Sets the cor.
	 *
	 * @param cor the new cor
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Gets the qtd portas.
	 *
	 * @return the qtd portas
	 */
	public int getQtdPortas() {
		return qtdPortas;
	}

	/**
	 * Sets the qtd portas.
	 *
	 * @param qtdPortas the new qtd portas
	 */
	public void setQtdPortas(int qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	/**
	 * Gets the data insercao carro.
	 *
	 * @return the data insercao carro
	 */
	public LocalDate getDataInsercaoCarro() {
		return dataInsercaoCarro;
	}

	/**
	 * Sets the data insercao carro.
	 *
	 * @param dataInsercaoCarro the new data insercao carro
	 */
	public void setDataInsercaoCarro(LocalDate dataInsercaoCarro) {
		this.dataInsercaoCarro = dataInsercaoCarro;
	}

	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public long getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(long valor) {
		this.valor = valor;
	}

}

