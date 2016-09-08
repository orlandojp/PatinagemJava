package base;

import java.math.BigDecimal;

public class AtletaProva {
	private int numSaida;
	private String numFederacao;
	private String nome;
	private String clube;
	private BigDecimal juiz1A;
	private BigDecimal juiz1B;
	private BigDecimal juiz2A;
	private BigDecimal juiz2B;
	private BigDecimal juiz3A;
	private BigDecimal juiz3B;
	private BigDecimal totalJuizes;
	
	//Construtores
	public AtletaProva(){
		this.numSaida = 0;
		this.numFederacao = new String();
		this.nome = new String();
		this.clube = new String();
		this.juiz1A = new BigDecimal(0);
		this.juiz1A = new BigDecimal(0);
		this.juiz1B = new BigDecimal(0);
		this.juiz2A = new BigDecimal(0);
		this.juiz2B = new BigDecimal(0);
		this.juiz3A = new BigDecimal(0);
		this.juiz3B = new BigDecimal(0);
		this.totalJuizes = new BigDecimal(0);
	}
	
	//Getters
	
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
	public BigDecimal getJuiz1A() {
		return juiz1A;
	}
	
	/**
	 * @return the juiz1B
	 */
	public BigDecimal getJuiz1B() {
		return juiz1B;
	}
	
	/**
	 * @return the juiz2A
	 */
	public BigDecimal getJuiz2A() {
		return juiz2A;
	}
	
	/**
	 * @return the juiz2B
	 */
	public BigDecimal getJuiz2B() {
		return juiz2B;
	}
	
	/**
	 * @return the juiz3A
	 */
	public BigDecimal getJuiz3A() {
		return juiz3A;
	}
	
	/**
	 * @return the juiz3B
	 */
	public BigDecimal getJuiz3B() {
		return juiz3B;
	}
	
	/**
	 * @return the totalJuizes
	 */
	public BigDecimal getTotalJuizes() {
		return totalJuizes;
	}
	
	//Setters
	
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
	public void setJuiz1A(String juiz1A) {
		this.juiz1A = new BigDecimal(juiz1A);
	}

	/**
	 * @param juiz1b the juiz1B to set
	 */
	public void setJuiz1B(String juiz1B) {
		this.juiz1B = new BigDecimal(juiz1B);
	}
	
	/**
	 * @param juiz2a the juiz2A to set
	 */
	public void setJuiz2A(String juiz2A) {
		this.juiz2A = new BigDecimal(juiz2A);
	}
	
	/**
	 * @param juiz2b the juiz2B to set
	 */
	public void setJuiz2B(String juiz2B) {
		this.juiz2B = new BigDecimal(juiz2B);
	}
	
	/**
	 * @param juiz3a the juiz3A to set
	 */
	public void setJuiz3A(String juiz3A) {
		this.juiz3A = new BigDecimal(juiz3A);
	}
	
	/**
	 * @param juiz3b the juiz3B to set
	 */
	public void setJuiz3B(String juiz3B) {
		this.juiz3B = new BigDecimal(juiz3B);
	}
	
	public void setTotalJuizes() {
		this.totalJuizes = totalJuizes.add(getJuiz1A().add(juiz1B.add(juiz2A.add(juiz2B.add(juiz3A.add(juiz3B))))));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return numSaida + "\t" + numFederacao + "\t" +  nome + "\t" + clube + "\t" + juiz1A + "\t" + juiz2A + "\t" + juiz3A + "\t" + juiz1B + "\t" + juiz2B + "\t" + juiz3B;
	}
	
	public static double comparaNotas(AtletaProva atleta1, AtletaProva atleta2){
		double vitorias = 0;
		BigDecimal juiz1Atleta1 = new BigDecimal(0);
		BigDecimal juiz2Atleta1 = new BigDecimal(0);
		BigDecimal juiz3Atleta1 = new BigDecimal(0);
		BigDecimal juiz1Atleta2 = new BigDecimal(0);
		BigDecimal juiz2Atleta2 = new BigDecimal(0);
		BigDecimal juiz3Atleta2 = new BigDecimal(0);
		juiz1Atleta1 = atleta1.getJuiz1A().add(atleta1.getJuiz1B());
		juiz2Atleta1 = atleta1.getJuiz2A().add(atleta1.getJuiz2B());
		juiz3Atleta1 = atleta1.getJuiz3A().add(atleta1.getJuiz3B());
		juiz1Atleta2 = atleta2.getJuiz1A().add(atleta2.getJuiz1B());
		juiz2Atleta2 = atleta2.getJuiz2A().add(atleta2.getJuiz2B());
		juiz3Atleta2 = atleta2.getJuiz3A().add(atleta2.getJuiz3B());
		if (juiz1Atleta1.compareTo(juiz1Atleta2) > 0 || (juiz1Atleta1.compareTo(juiz1Atleta2) == 0 && atleta1.getJuiz1B().compareTo(atleta2.getJuiz1B()) > 0)){
			vitorias += 1;
		}
		if (juiz1Atleta1.compareTo(juiz1Atleta2) == 0 && atleta1.getJuiz1B().compareTo(atleta2.getJuiz1B()) == 0){
			vitorias += 0.5;
		}
		if (juiz2Atleta1.compareTo(juiz2Atleta2) > 0 || (juiz2Atleta1.compareTo(juiz2Atleta2) == 0 && atleta1.getJuiz2B().compareTo(atleta2.getJuiz2B()) > 0)){
			vitorias += 1;
		}
		if (juiz2Atleta1.compareTo(juiz2Atleta2) == 0 && atleta1.getJuiz2B().compareTo(atleta2.getJuiz2B()) == 0){
			vitorias += 0.5;
		}
		if (juiz3Atleta1.compareTo(juiz3Atleta2) > 0 || (juiz3Atleta1.compareTo(juiz3Atleta2) == 0 && atleta1.getJuiz3B().compareTo(atleta2.getJuiz3B()) > 0)){
			vitorias += 1;
		}
		if (juiz3Atleta1.compareTo(juiz3Atleta2) == 0 && atleta1.getJuiz3B().compareTo(atleta2.getJuiz3B()) == 0){
			vitorias += 0.5;
		}
		return vitorias;
	}
}
