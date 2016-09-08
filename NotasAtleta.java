package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class NotasAtleta {
	
	public static ArrayList<AtletaProva> atletasCompetiram() {
		ArrayList<AtletaProva> notasAtletas = new ArrayList<AtletaProva>();
		String nome, linha = null;
		String[] atleta;
		
		
		nome = "atletas - copia.txt";						//le o nome do ficheiro a abrir
		String desktop = System.getProperty ("user.home") + "/Desktop/";	//obtem o caminho para o desktop
		nome = desktop + nome;	//cria o caminho completo para o ficheiro

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			while ((linha = lerArq.readLine()) != null) {
				AtletaProva novoAtleta = new AtletaProva(); 		//temos que criar um novo objecto para cada atleta para evitar que crie uma list com todos os elementos iguais
				atleta = linha.split("\t");
				novoAtleta.setNumSaida(Integer.parseInt(atleta[0]));
				novoAtleta.setNumFederacao(atleta[1]);
				novoAtleta.setNome(atleta[2]);
				novoAtleta.setClube(atleta[3]);
				novoAtleta.setJuiz1A(atleta[4]);
				novoAtleta.setJuiz2A(atleta[5]);
				novoAtleta.setJuiz3A(atleta[6]);
				novoAtleta.setJuiz1B(atleta[7]);
				novoAtleta.setJuiz2B(atleta[8]);
				novoAtleta.setJuiz3B(atleta[9]);
				novoAtleta.setTotalJuizes();
				notasAtletas.add(novoAtleta);
			}
			arq.close();
		}
		catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return notasAtletas;
		}
	return notasAtletas;
	}
	
	public static ArrayList<AtletaSaida> atletasCompetir() {
		ArrayList<AtletaSaida> notasAtletas = new ArrayList<AtletaSaida>();
		String nome, linha = null;
		String[] atleta;
		
		nome = "OrdemSaida.txt";
		String desktop = System.getProperty ("user.home") + "/Desktop/";	//obtem o caminho para o desktop
		nome = desktop + nome;	//cria o caminho completo para o ficheiro

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			while ((linha = lerArq.readLine()) != null) {
				AtletaSaida novoAtleta = new AtletaSaida(); 		//temos que criar um novo objecto para cada atleta para evitar que crie uma list com todos os elementos iguais
				atleta = linha.split("\t");
				novoAtleta.setNumSaida(Integer.parseInt(atleta[0]));
				novoAtleta.setNumFederacao(atleta[1]);
				novoAtleta.setNome(atleta[2]);
				novoAtleta.setClube(atleta[3]);
				notasAtletas.add(novoAtleta);
			}
			arq.close();
		}
		catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return notasAtletas;
		}
	System.out.println();
	return notasAtletas;
	}
	
	public static ArrayList<Double>  desempateRegra6(List<Integer> atletasEmpatados){
		ArrayList<Double> listaDesempate6 = new ArrayList<Double>();
		for (int i = 0; i < atletasEmpatados.size(); i++){
			listaDesempate6.add(i, 0.0);
		}
		for (int x = 0; x < atletasEmpatados.size() - 1; x++){
			AtletaProva atleta1 = atletasCompetiram().get(atletasEmpatados.get(x) - 1);
			for (int y = x + 1; y < atletasEmpatados.size(); y++){
				double vitorias = 0;
				AtletaProva atleta2 = atletasCompetiram().get(atletasEmpatados.get(y) - 1);
				if ((atleta1 != atleta2) && (atleta2.getNumSaida() > atleta1.getNumSaida())){
					vitorias = AtletaProva.comparaNotas(atleta1, atleta2);
					if (vitorias > 1.5){
						listaDesempate6.set(x, listaDesempate6.get(x) + 1.0);
					}
					else if (vitorias == 1.5){
						listaDesempate6.set(x, listaDesempate6.get(x) + 0.5);
						listaDesempate6.set(y, listaDesempate6.get(y) + 0.5);
					}
					else {
						listaDesempate6.set(y, listaDesempate6.get(y) + 1.0);
					}
				}
			}
		}
		return listaDesempate6;
	}

	public static TreeMap<BigDecimal, Integer> desempateRegra7b10a(List<Integer> atletasEmpatados) {
		TreeMap<BigDecimal, Integer> treeMapDesempate7b10a = new TreeMap<BigDecimal, Integer>();
		for(Integer num : atletasEmpatados){
			BigDecimal nota = new BigDecimal(0);
			nota = nota.add(App.listaAtletasCompetiram.get(num -1).getJuiz1B());
			nota = nota.add(App.listaAtletasCompetiram.get(num -1).getJuiz2B());
			nota = nota.add(App.listaAtletasCompetiram.get(num -1).getJuiz3B());
			treeMapDesempate7b10a.put(nota, num);
		}
		return treeMapDesempate7b10a;
	}
	
	public static void imprimeAtleta(Integer numAtleta, Double vn){
		StringBuilder sc = new StringBuilder();
		//System.out.format("%-30s", App.listaAtletasCompetiram.get(numAtleta).getNome());
		//System.out.format("%6.03f", App.listaAtletasCompetiram.get(numAtleta).getTotalJuizes());
		//System.out.format("%7.1f \n", vn);
		sc.append(String.format("%-30s", App.listaAtletasCompetiram.get(numAtleta).getNome()));
		sc.append(String.format("%6.03f", App.listaAtletasCompetiram.get(numAtleta).getTotalJuizes()));
		sc.append(String.format("%7.1f \n", vn));
		System.out.print(sc.toString());
		Layout.classificacao.add(sc.toString());
	}
}
