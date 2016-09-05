package base;

import java.math.BigDecimal;

public class AtletaProva {
	private int numSaida;
	private String numFederacao;
	private String nome;
	private String clube;
	private BigDecimal teste;
	private double juiz1A;
	private double juiz1B;
	private double juiz2A;
	private double juiz2B;
	private double juiz3A;
	private double juiz3B;
	
	//Construtores
	public AtletaProva(){
		this.numSaida = 0;
		this.numFederacao = new String();
		this.nome = new String();
		this.clube = new String();
		this.teste = new BigDecimal(0);
		this.juiz1A = 0.0;
		this.juiz1B = 0.0;
		this.juiz2A = 0.0;
		this.juiz2B = 0.0;
		this.juiz3A = 0.0;
		this.juiz3B = 0.0;
	}
	
	//Getters
	
	public BigDecimal getTeste(){
		return teste;
	}
	
	/**
	 * @return the numSaida
	 */
	public int getNumSaida() {
		return numSaida;
	}
	
	/**
	 * @return the numFederacao
	 */
	public String getNumFederacao() {
		return numFederacao;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return the clube
	 */
	public String getClube() {
		return clube;
	}
	
	/**
	 * @return the juiz1A
	 */
	public double getJuiz1A() {
		return juiz1A;
	}
	
	/**
	 * @return the juiz1B
	 */
	public double getJuiz1B() {
		return juiz1B;
	}
	
	/**
	 * @return the juiz2A
	 */
	public double getJuiz2A() {
		return juiz2A;
	}
	
	/**
	 * @return the juiz2B
	 */
	public double getJuiz2B() {
		return juiz2B;
	}
	
	/**
	 * @return the juiz3A
	 */
	public double getJuiz3A() {
		return juiz3A;
	}
	
	/**
	 * @return the juiz3B
	 */
	public double getJuiz3B() {
		return juiz3B;
	}
	
	//Setters
	
	public void setTeste(String teste){
		this.teste = new BigDecimal(teste);
	}
	
	/**
	 * @param numSaida the numSaida to set
	 */
	public void setNumSaida(int numSaida) {
		this.numSaida = numSaida;
	}
	
	/**
	 * @param numFederacao the numFederacao to set
	 */
	public void setNumFederacao(String numFederacao) {
		this.numFederacao = numFederacao;
	}
	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @param clube the clube to set
	 */
	public void setClube(String clube) {
		this.clube = clube;
	}
	
	/**
	 * @param juiz1a the juiz1A to set
	 */
	public void setJuiz1A(double juiz1a) {
		juiz1A = juiz1a;
	}
	
	/**
	 * @param juiz1b the juiz1B to set
	 */
	public void setJuiz1B(double juiz1b) {
		juiz1B = juiz1b;
	}
	
	/**
	 * @param juiz2a the juiz2A to set
	 */
	public void setJuiz2A(double juiz2a) {
		juiz2A = juiz2a;
	}
	
	/**
	 * @param juiz2b the juiz2B to set
	 */
	public void setJuiz2B(double juiz2b) {
		juiz2B = juiz2b;
	}
	
	/**
	 * @param juiz3a the juiz3A to set
	 */
	public void setJuiz3A(double juiz3a) {
		juiz3A = juiz3a;
	}
	
	/**
	 * @param juiz3b the juiz3B to set
	 */
	public void setJuiz3B(double juiz3b) {
		juiz3B = juiz3b;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return numSaida + "\t" + numFederacao + "\t" +  nome + "\t" + clube + "\t" + juiz1A + "\t" + juiz2A + "\t" + juiz3A + "\t" + juiz1B + "\t" + juiz2B + "\t" + juiz3B;
	}
}
