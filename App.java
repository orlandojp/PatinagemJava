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

	static ArrayList<AtletaProva> teste = new ArrayList<AtletaProva>();
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
			atletaInserir.setJuiz1A(converteNota(sc.nextDouble()));
			System.out.println("Juiz 2: ");
			atletaInserir.setJuiz2A(converteNota(sc.nextDouble()));
			System.out.println("Juiz 3: ");
			atletaInserir.setJuiz3A(converteNota(sc.nextDouble()));
			System.out.println("Nota B");
			System.out.println("Juiz 1: ");
			atletaInserir.setJuiz1B(converteNota(sc.nextDouble()));
			System.out.println("Juiz 2: ");
			atletaInserir.setJuiz2B(converteNota(sc.nextDouble()));
			System.out.println("Juiz 3: ");
			atletaInserir.setJuiz3B(converteNota(sc.nextDouble()));
			proximo += 1;
			teste.add(atletaInserir);
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
		
		double matrizVitorias[][] = new double[teste.size()][teste.size()];
		
		for (int linha = 0; linha < teste.size(); linha++){
			for (int coluna = 0; coluna < teste.size(); coluna++){
				double vitorias = 0;
				if (linha != coluna){
					if (teste.get(linha).getJuiz1A() + teste.get(linha).getJuiz1B() > teste.get(coluna).getJuiz1A() + teste.get(coluna).getJuiz1B() ||
							(teste.get(linha).getJuiz1A() + teste.get(linha).getJuiz1B() == teste.get(coluna).getJuiz1A() + teste.get(coluna).getJuiz1B() &&
									teste.get(linha).getJuiz1B() > teste.get(coluna).getJuiz1B())){
						vitorias += 1;
					}
					if (teste.get(linha).getJuiz1A() + teste.get(linha).getJuiz1B() == teste.get(coluna).getJuiz1A() + teste.get(coluna).getJuiz1B() &&
									teste.get(linha).getJuiz1B() == teste.get(coluna).getJuiz1B()){
						vitorias += 0.5;
					}
					if (teste.get(linha).getJuiz2A() + teste.get(linha).getJuiz2B() > teste.get(coluna).getJuiz2A() + teste.get(coluna).getJuiz2B() ||
							(teste.get(linha).getJuiz2A() + teste.get(linha).getJuiz2B() == teste.get(coluna).getJuiz2A() + teste.get(coluna).getJuiz2B() &&
									teste.get(linha).getJuiz2B() > teste.get(coluna).getJuiz2B())){
						vitorias += 1;
					}
					if (teste.get(linha).getJuiz2A() + teste.get(linha).getJuiz2B() == teste.get(coluna).getJuiz2A() + teste.get(coluna).getJuiz2B() &&
									teste.get(linha).getJuiz2B() == teste.get(coluna).getJuiz2B()){
						vitorias += 0.5;
					}
					if (teste.get(linha).getJuiz3A() + teste.get(linha).getJuiz3B() > teste.get(coluna).getJuiz3A() + teste.get(coluna).getJuiz3B() ||
							(teste.get(linha).getJuiz3A() + teste.get(linha).getJuiz3B() == teste.get(coluna).getJuiz3A() + teste.get(coluna).getJuiz3B() &&
									teste.get(linha).getJuiz3B() > teste.get(coluna).getJuiz3B())){
						vitorias += 1;
					}
					if (teste.get(linha).getJuiz3A() + teste.get(linha).getJuiz3B() == teste.get(coluna).getJuiz3A() + teste.get(coluna).getJuiz3B() &&
									teste.get(linha).getJuiz3B() == teste.get(coluna).getJuiz3B()){
						vitorias += 0.5;
					}
				}
				matrizVitorias[linha][coluna] = vitorias;
			}
		}
		// Teste de impressão da matriz
		for (int i=0; i<matrizVitorias.length; i++) {
		   for (int j=0; j<matrizVitorias[i].length; j++) {
		      System.out.print(matrizVitorias[i][j] + "\t");
		   }
		   System.out.printf("\n");
		}
		
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
				classificacaoMap.get(total).add(teste.get(linha).getNumSaida());
			}
			else{
				classificacaoMap.put(total,new ArrayList<Integer>());
				classificacaoMap.get(total).add(teste.get(linha).getNumSaida());
			}
		}
		
		Set<Entry<Double, Collection<Integer>>> set = classificacaoMap.entrySet();
	    Iterator<Entry<Double, Collection<Integer>>> i = set.iterator();
	    while(i.hasNext()) {
	         @SuppressWarnings("rawtypes")
			 Map.Entry me = (Map.Entry)i.next();
	         @SuppressWarnings("unchecked")
			 ArrayList<Integer> atletasPorNotas = (ArrayList<Integer>) me.getValue();
	         
	         if (atletasPorNotas.size() == 1){
	        	 System.out.println(teste.get(atletasPorNotas.get(0)-1).getNome());
	         }
	         
	         if (atletasPorNotas.size() == 2){
	        	 double novasVitorias = 0;
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz1B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz1B() ||
	        			 (teste.get(atletasPorNotas.get(0) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz1B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz1B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz1B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz1B())){
	        		 novasVitorias += 1;
	        	 }
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz1B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz1A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz1B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz1B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz1B()){
	        		 novasVitorias += 0.5;
	        	 }
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz2B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz2B() ||
	        			 (teste.get(atletasPorNotas.get(0) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz2B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz2B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz2B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz2B())){
	        		 novasVitorias += 1;
	        	 }
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz2B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz2A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz2B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz2B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz2B()){
	        		 novasVitorias += 0.5;
	        	 }
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz3B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz3B() ||
	        			 (teste.get(atletasPorNotas.get(0) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz3B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz3B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz3B() > teste.get(atletasPorNotas.get(1) - 1).getJuiz3B())){
	        		 novasVitorias += 1;
	        	 }
	        	 if (teste.get(atletasPorNotas.get(0) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(0) - 1).getJuiz3B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz3A() + teste.get(atletasPorNotas.get(1) - 1).getJuiz3B() && 
	        					 teste.get(atletasPorNotas.get(0) - 1).getJuiz3B() == teste.get(atletasPorNotas.get(1) - 1).getJuiz3B()){
	        		 novasVitorias += 0.5;
	        	 }
	        	 System.out.println(novasVitorias);
	        	 if (novasVitorias >= 2){
	        		 System.out.println(teste.get(atletasPorNotas.get(0) - 1).getNome());
	        		 System.out.println(teste.get(atletasPorNotas.get(1) - 1).getNome());
	        	 }
	        	 else{
	        		 System.out.println(teste.get(atletasPorNotas.get(1) - 1).getNome());
	        		 System.out.println(teste.get(atletasPorNotas.get(0) - 1).getNome());
	        	 }
	         }
	         /*
	         if (atletasPorNotas.size() > 2){
	        	 ArrayList<Double> desempate6 = NotasAtleta.desempateRegra6(atletasPorNotas);
	        	 
	        	 // Collections.max dá o valor máximo de uma colecção, neste caso do ArrayList desempate 6
	        	 // que se for menor do que 2 é porque nenhum atleta consegue mais vitórias do que os adversários
	        	 if (Collections.max(desempate6) < 1.5){
	        		 TreeMap<Double, Integer> desempate7b10a = NotasAtleta.desempateRegra7b10a(atletasPorNotas);
	        		 while (desempate7b10a.size() > 0){
	        			 System.out.println(teste.get(desempate7b10a.get(desempate7b10a.lastKey())).getNome());
	        			 desempate7b10a.remove(desempate7b10a.lastKey());
	        		 }
	        	 }
	         }*/
	         System.out.printf("%.3f: ", me.getKey());
	         System.out.println(me.getValue());
	      }
	}
	
	public static void main(String[] args) throws IOException {
		
		//int proximo;
		
		teste = NotasAtleta.atletasCompetiram();
		teste2 = NotasAtleta.atletasCompetir();
		
		if (teste.size() != 0){
			for (AtletaProva atleta : teste){
				System.out.println(atleta);
			}	
		}else{
			System.out.println("Lista vazia");
		}

		//proximo = teste.size();
		//leNotas(proximo);
		
		calculaClassificacao();
		//MenuClube.start();
		
		BigDecimal t1, t2;
		t1 = new BigDecimal("3");
		t2 = new BigDecimal("2.7");
		t1 = t1.add(t2);
		AtletaProva novoAtleta = new AtletaProva();
		novoAtleta.setTeste("2.9");
		System.out.println(novoAtleta.getTeste());
		System.out.println(t1 = t1.add(novoAtleta.getTeste()));
	}
}
