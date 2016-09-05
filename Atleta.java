package base;
/**
 * Classe para registo dos atletas existentes em Portugal
 * @author OJ
 * @version 07/2016
 */
public class Atleta {
	private int numFed;
	private String nomeAtleta;
	private int clubeAtleta;
	
	/**
	 * @return the numFed
	 */
	public int getNumFed() {
		return numFed;
	}
	/**
	 * @return the nomeAtleta
	 */
	public String getNomeAtleta() {
		return nomeAtleta;
	}
	/**
	 * @return the clubeAtleta
	 */
	public int getClubeAtleta() {
		return clubeAtleta;
	}
	/**
	 * @param numFed the numFed to set
	 */
	public void setNumFed(int numFed) {
		this.numFed = numFed;
	}
	/**
	 * @param nomeAtleta the nomeAtleta to set
	 */
	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}
	/**
	 * @param clubeAtleta the clubeAtleta to set
	 */
	public void setClubeAtleta(int clubeAtleta) {
		this.clubeAtleta = clubeAtleta;
	}
	
}
