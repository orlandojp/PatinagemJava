package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class App {

	static ArrayList<AtletaProva> listaAtletasCompetiram = new ArrayList<AtletaProva>();
	static ArrayList<AtletaSaida> teste2 = new ArrayList<AtletaSaida>();
	static TreeMap<Double, Collection<Integer>> classificacaoMap = new TreeMap<Double, Collection<Integer>>(Collections.reverseOrder());
	
	public static double converteNota(double nota){
		if (nota > 10) return nota/10.;
		else return nota;
	}
	
	public static void leNotas(int proximo) throws IOException{
		Boolean novoAtleta = true;
		Scanner sc = new Scanner(System.in);
		String continuar;
		
		String nomeFicheiro = "atletas.txt";						//le o nome do ficheiro a abrir
		String desktop = System.getProperty ("user.home") + "/Desktop/";	//obtem o caminho para o desktop
		nomeFicheiro = desktop + nomeFicheiro;	//cria o caminho completo para o ficheiro
		
		BufferedWriter bw = null;
		File file = new File (nomeFicheiro);
		// se o ficheiro não existir cria-o
		if (!file.exists()){
			file.createNewFile();
		}
		
		while (novoAtleta){
			AtletaProva atletaInserir = new AtletaProva();
			atletaInserir.setNumSaida(teste2.get(proximo).getNumSaida());
			atletaInserir.setNumFederacao(teste2.get(proximo).getNumFederacao());
			atletaInserir.setNome(teste2.get(proximo).getNome());
			atletaInserir.setClube(teste2.get(proximo).getClube());
			System.out.println("Atleta: " + teste2.get(proximo).getNome() + " " + teste2.get(proximo).getClube());
			System.out.println("Nota A");
			System.out.println("Juiz 1: ");
			atletaInserir.setJuiz1A(sc.nextLine());
			System.out.println("Juiz 2: ");
			atletaInserir.setJuiz2A(sc.nextLine());
			System.out.println("Juiz 3: ");
			atletaInserir.setJuiz3A(sc.nextLine());
			System.out.println("Nota B");
			System.out.println("Juiz 1: ");
			atletaInserir.setJuiz1B(sc.nextLine());
			System.out.println("Juiz 2: ");
			atletaInserir.setJuiz2B(sc.nextLine());
			System.out.println("Juiz 3: ");
			atletaInserir.setJuiz3B(sc.nextLine());
			proximo += 1;
			listaAtletasCompetiram.add(atletaInserir);
			String atletaAEscrever = atletaInserir.toString();
			// Abre o ficheiro especificado e o parametro true é para acrescentar a informação e não escrever por cima
			FileWriter fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			bw.write(atletaAEscrever);	// escreve o atleta
			bw.newLine();				// muda de linha
			bw.close();					// fecha o buffer para que a escrita seja efectuada 
			System.out.println("Deseja Introduzir um novo atleta? ");
			continuar = sc.next();
			if (!continuar.equals("s")){ 
				novoAtleta = false;
			}
		}
		sc.close();	
	}
	
	public static void calculaClassificacao (){
		
		double matrizVitorias[][] = new double[listaAtletasCompetiram.size()][listaAtletasCompetiram.size()];
		int totalZeros = 0;
		
		for (int linha = 0; linha < listaAtletasCompetiram.size(); linha++){
			AtletaProva atleta1 = listaAtletasCompetiram.get(linha);
			for (int coluna = 0; coluna < listaAtletasCompetiram.size(); coluna++){
				double vitorias = 0;
				AtletaProva atleta2 = listaAtletasCompetiram.get(coluna);
				if (linha != coluna){
					vitorias = AtletaProva.comparaNotas(atleta1, atleta2);
				}
				matrizVitorias[linha][coluna] = vitorias;
			}
		}
		/*
		// Teste de impressão da matriz
		for (int i=0; i<matrizVitorias.length; i++) {
		   for (int j=0; j<matrizVitorias[i].length; j++) {
		      System.out.print(matrizVitorias[i][j] + "\t");
		   }
		   System.out.printf("\n");
		}*/

		for (int linha = 0; linha < matrizVitorias.length;linha++){
			double total = 0;
			for( int coluna = 0; coluna < matrizVitorias.length;coluna++){
				if (matrizVitorias[linha][coluna] > 1.5){
					total++;
				}
				if (matrizVitorias[linha][coluna] == 1.5){
					total += 0.5;
				} 
			}
			if(classificacaoMap.containsKey(total)){
				classificacaoMap.get(total).add(listaAtletasCompetiram.get(linha).getNumSaida());
			}
			else{
				classificacaoMap.put(total,new ArrayList<Integer>());
				classificacaoMap.get(total).add(listaAtletasCompetiram.get(linha).getNumSaida());
			}
		}

		Set<Entry<Double, Collection<Integer>>> set = classificacaoMap.entrySet();
	    Iterator<Entry<Double, Collection<Integer>>> i = set.iterator();
	    
	    if (classificacaoMap.containsKey(0.0)){
	    	totalZeros = classificacaoMap.get(0.0).size();
   	 	}
	    
	    while(i.hasNext()) {
	         @SuppressWarnings("rawtypes")
			 Map.Entry me = (Map.Entry)i.next();
	         @SuppressWarnings("unchecked")
			 ArrayList<Integer> atletasPorNotas = (ArrayList<Integer>) me.getValue();
	         //System.out.printf("%.3f: ", me.getKey());
	         //System.out.println(me.getValue());
	         
	         if (atletasPorNotas.size() == 1){
	        	 NotasAtleta.imprimeAtleta(atletasPorNotas.get(0) - 1, (Double) me.getKey() - totalZeros);
	         }
	         
	         if (atletasPorNotas.size() == 2){
	        	 double novasVitorias = 0;
	        	 AtletaProva atleta1 = listaAtletasCompetiram.get(atletasPorNotas.get(0) - 1);
	        	 AtletaProva atleta2 = listaAtletasCompetiram.get(atletasPorNotas.get(1) - 1);
	        	 
	        	 novasVitorias = AtletaProva.comparaNotas(atleta1, atleta2);
	        	 if (novasVitorias >= 2){
	        		 NotasAtleta.imprimeAtleta(atletasPorNotas.get(0) - 1, (Double) me.getKey() - totalZeros);
	        		 NotasAtleta.imprimeAtleta(atletasPorNotas.get(1) - 1, (Double) me.getKey() - totalZeros);
	        	 }
	        	 else{
	        		 NotasAtleta.imprimeAtleta(atletasPorNotas.get(1) - 1, (Double) me.getKey() - totalZeros);
	        		 NotasAtleta.imprimeAtleta(atletasPorNotas.get(0) - 1, (Double) me.getKey() - totalZeros);
	        	 }
	         }
	         
	         if (atletasPorNotas.size() > 2){
	        	 ArrayList<Double> desempate6 = NotasAtleta.desempateRegra6(atletasPorNotas);        	 
	        	 if (Collections.max(desempate6) < 1.5){
	        		 TreeMap<BigDecimal, Integer> desempate7b10a = NotasAtleta.desempateRegra7b10a(atletasPorNotas);
	        		 while (desempate7b10a.size() > 0){
	        			 NotasAtleta.imprimeAtleta(desempate7b10a.get(desempate7b10a.lastKey()) - 1, (Double) me.getKey() - totalZeros);
	        			 desempate7b10a.remove(desempate7b10a.lastKey());
	        		 }
	        	 }
	         }
	      }
	}
	
	public static void main(String[] args) throws IOException {
		
		//int proximo;
		
		listaAtletasCompetiram = NotasAtleta.atletasCompetiram();
		teste2 = NotasAtleta.atletasCompetir();
		
		if (listaAtletasCompetiram.size() != 0){
			for (AtletaProva atleta : listaAtletasCompetiram){
				System.out.println(atleta);
			}	
		}else{
			System.out.println("Lista vazia");
		}

		//proximo = listaAtletasCompetiram.size();
		//leNotas(proximo);
		
		calculaClassificacao();
		//MenuClube.start();
	}
}
