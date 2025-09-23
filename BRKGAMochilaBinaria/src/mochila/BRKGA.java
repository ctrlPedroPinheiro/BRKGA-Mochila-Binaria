//Nomes dos componentes do grupo: Messias da Silva, Pedro Pinheiro
package mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BRKGA {

    private final InstanciaMochila instancia;
    private final int tamanhoPopulacao;
    private final int numGeracoes;
    private final double percentualElite;
    private final double percentualMutantes;
    private final double probHerancaElite;

    private List<Individuo> populacao;
    private Individuo melhorSolucao;

    public BRKGA(InstanciaMochila instancia, int tamanhoPopulacao, int numGeracoes, double percentualElite, double percentualMutantes, double probHerancaElite) {
        this.instancia = instancia;
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.numGeracoes = numGeracoes;
        this.percentualElite = percentualElite;
        this.percentualMutantes = percentualMutantes;
        this.probHerancaElite = probHerancaElite;
        this.populacao = new ArrayList<>(tamanhoPopulacao);
        this.melhorSolucao = null;
    }

    public void evoluir() {
        inicializarPopulacao();

        for (int g = 0; g < numGeracoes; g++) {
            // Decodifica e calcula o fitness de cada indivíduo
            for (Individuo ind : populacao) {
                Decodificador.decodificar(ind, instancia);
            }

            // Ordena a população pelo fitness decresceente
            Collections.sort(populacao);

            // Atualiza a melhor solução encontrada
            if (melhorSolucao == null || populacao.get(0).getFitness() > melhorSolucao.getFitness()) {
                melhorSolucao = new Individuo(populacao.get(0).getChaves());
                melhorSolucao.setFitness(populacao.get(0).getFitness());
            }

            // Cria a próxima populacao
            List<Individuo> proximaGeracao = new ArrayList<>();

            // primeiro os melhores indivíduos passam diretamente
            int numElite = (int) (tamanhoPopulacao * percentualElite);
            for (int i = 0; i < numElite; i++) {
                proximaGeracao.add(populacao.get(i));
            }

            // segundo novos indivíduos aleatórios são criados
            int numMutantes = (int) (tamanhoPopulacao * percentualMutantes);
            for (int i = 0; i < numMutantes; i++) {
                proximaGeracao.add(new Individuo(instancia.getNumItens()));
            }

            // treiceiro crossover gera o restante da população
            int numCrossover = tamanhoPopulacao - numElite - numMutantes;
            Random rand = new Random();

            List<Individuo> elite = populacao.subList(0, numElite);
            List<Individuo> naoElite = populacao.subList(numElite, tamanhoPopulacao);

            for (int i = 0; i < numCrossover; i++) {
                Individuo paiElite = elite.get(rand.nextInt(elite.size()));
                Individuo paiNaoElite = naoElite.get(rand.nextInt(naoElite.size()));
                Individuo filho = crossover(paiElite, paiNaoElite);
                proximaGeracao.add(filho);
            }

            populacao = proximaGeracao;

            // Imprime o progresso
            if ((g + 1) % 10 == 0) {
                System.out.println("Geração " + (g + 1) + " | Melhor Fitness: " + melhorSolucao.getFitness());
            }
        }
    }

    private void inicializarPopulacao() {
        for (int i = 0; i < tamanhoPopulacao; i++) {
            populacao.add(new Individuo(instancia.getNumItens()));
        }
    }


    // faz o crossover entre um pai de elite e um pai não elite.
    private Individuo crossover(Individuo paiElite, Individuo paiNaoElite) {
        int numGenes = paiElite.getNumGenes();
        double[] chavesFilho = new double[numGenes];
        Random rand = new Random();

        for (int i = 0; i < numGenes; i++) {
            // Com probabilidade o gene vem do pai de elite
            if (rand.nextDouble() < probHerancaElite) {
                chavesFilho[i] = paiElite.getChave(i);
            } else {
                chavesFilho[i] = paiNaoElite.getChave(i);
            }
        }
        return new Individuo(chavesFilho);
    }

    public Individuo getMelhorSolucao() {
        return melhorSolucao;
    }
}