package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
				novoAtleta.setJuiz1A(Double.parseDouble(atleta[4]));
				novoAtleta.setJuiz2A(Double.parseDouble(atleta[5]));
				novoAtleta.setJuiz3A(Double.parseDouble(atleta[6]));
				novoAtleta.setJuiz1B(Double.parseDouble(atleta[7]));
				novoAtleta.setJuiz2B(Double.parseDouble(atleta[8]));
				novoAtleta.setJuiz3B(Double.parseDouble(atleta[9]));
				notasAtletas.add(novoAtleta);
				//if (novoAtleta.getJuiz1A() != 0 & novoAtleta.getJuiz2A() != 0 & novoAtleta.getJuiz3A() != 0){
				//	notasAtletas.add(novoAtleta);
				//}
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
		for (int atleta1 = 0; atleta1 < atletasEmpatados.size(); atleta1++){
			for (int atleta2 = 0; atleta2 < atletasEmpatados.size(); atleta2++){
				double vitorias = 0;
				if ((atleta1 != atleta2) && (atleta2 > atleta1)){
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1B() ||
							( App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1B() )){
						vitorias += 1;
					}
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz1B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz1B() ){
						vitorias += 0.5;
					}
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2B() ||
							( App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2B() )){
						vitorias += 1;
					}
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz2B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz2B() ){
						vitorias += 0.5;
					}
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3B() ||
							( App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3B() )){
						vitorias += 1;
					}
					if (App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3B() == App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3A() + App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3B() && 
									App.teste.get(atletasEmpatados.get(atleta1) - 1).getJuiz3B() > App.teste.get(atletasEmpatados.get(atleta2) - 1).getJuiz3B() ){
						vitorias += 0.5;
					}
					if (vitorias > 1.5){
						listaDesempate6.set(atleta1, listaDesempate6.get(atleta1) + 1.0);
					}
					else if (vitorias == 1.5){
						listaDesempate6.set(atleta1, listaDesempate6.get(atleta1) + 0.5);
						listaDesempate6.set(atleta2, listaDesempate6.get(atleta2) + 0.5);
					}
					else {
						listaDesempate6.set(atleta2, listaDesempate6.get(atleta2) + 1.0);
					}
				}
			}
		}
		return listaDesempate6;
	}
	
	public static TreeMap<Double, Integer> desempateRegra7b10a(List<Integer> atletasEmpatados) {
		TreeMap<Double, Integer> treeMapDesempate7b10a = new TreeMap<Double, Integer>();
		
		return treeMapDesempate7b10a;
	}
}
