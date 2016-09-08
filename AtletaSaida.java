package base;

public class AtletaSaida {
	private int numSaida;
	private String numFederacao;
	private String nome;
	private String clube;
	
	//Construtores
	public AtletaSaida(){
		this.numSaida = 0;
		this.numFederacao = new String();
		this.nome = new String();
		this.clube = new String();
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%4d \t", numSaida));
		//sb.append(numFederacao);
		//sb.append("\t");
		sb.append(String.format("%-35s \t", nome));
		sb.append(String.format("%-5s", clube));
		return sb.toString();
	}
}
