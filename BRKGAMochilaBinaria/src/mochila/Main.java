//Nomes dos componentes do grupo: Messias da Silva, Pedro Pinheiro
package mochila;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

 public static void main(String[] args) {
     String caminhoArquivo = "instancia.txt";

     try {
         InstanciaMochila instancia = new InstanciaMochila(caminhoArquivo);

         int tamanhoPopulacao = 100;
         int numGeracoes = 100;
         double percentualElite = 0.10;
         double percentualMutantes = 0.40;
         double probHerancaElite = 0.60;

         BRKGA brkga = new BRKGA(instancia, tamanhoPopulacao, numGeracoes, percentualElite, percentualMutantes, probHerancaElite);
         
         System.out.println("Iniciando a execução do BRKGA...");
         brkga.evoluir();

         Individuo melhorSolucao = brkga.getMelhorSolucao();
         
         List<Item> itensEscolhidos = Decodificador.decodificar(melhorSolucao, instancia);

         System.out.println("\n--- Execução do BRKGA Finalizada ---");
         System.out.println("Melhor valor encontrado: " + melhorSolucao.getFitness());

         int pesoTotal = 0;
         System.out.println("Itens na mochila:");
         for (Item item : itensEscolhidos) {
             System.out.println("- Valor: " + item.valor() + ", Peso: " + item.peso());
             pesoTotal += item.peso();
         }

         System.out.println("\nPeso total da mochila: " + pesoTotal);
         System.out.println("Capacidade da mochila: " + instancia.getCapacidade());

     } catch (FileNotFoundException e) {
         System.err.println("Erro: Arquivo de instância não encontrado em '" + caminhoArquivo + "'");
     }
 }
}
