//Nomes dos componentes do grupo: Messias da Silva, Pedro Pinheiro
package mochila;

import java.util.Arrays;
import java.util.Random;

// Representa um cromossomo na população
public class Individuo implements Comparable<Individuo> {

    private final double[] chaves;
    private int fitness;

    // Cria um novo indivíduo com chaves aleatórias
    public Individuo(int numGenes) {
        this.chaves = new double[numGenes];
        Random rand = new Random();
        for (int i = 0; i < numGenes; i++) {
            this.chaves[i] = rand.nextDouble();
        }
        this.fitness = 0;
    }

    // Construtor para criar um indivíduo com chaves existentes para o crossover
    public Individuo(double[] chaves) {
        this.chaves = Arrays.copyOf(chaves, chaves.length);
        this.fitness = 0;
    }

    public double[] getChaves() {
        return chaves;
    }

    public double getChave(int index) {
        return chaves[index];
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getNumGenes() {
        return chaves.length;
    }

    // Compara os fitness dos indivíduos em ordem decrescente.
    @Override
    public int compareTo(Individuo outro) {
        return Integer.compare(outro.fitness, this.fitness);
    }

    @Override
    public String toString() {
        return "Individuo{fitness=" + fitness + ", chaves=" + Arrays.toString(chaves) + "}";
    }
}
