//Nomes dos componentes do grupo: Messias da Silva, Pedro Pinheiro
package mochila;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Decodificador {

    // Decodifica um indivíduo para encontrar uma solução
    public static List<Item> decodificar(Individuo individuo, InstanciaMochila instancia) {
        List<Item> itensDaMochila = new ArrayList<>();
        int pesoAtual = 0;
        int valorTotal = 0;

        // Cria uma lista de índices para ordenar os itens por suas chaves
        List<Integer> indicesOrdenados = new ArrayList<>();
        for (int i = 0; i < instancia.getNumItens(); i++) {
            indicesOrdenados.add(i);
        }

        // Ordena os índices dos itens / maior chave primeiro / maior chave primeiro
        indicesOrdenados.sort(Comparator.comparingDouble(individuo::getChave).reversed());

        for (int index : indicesOrdenados) {
            Item itemAtual = instancia.getItens().get(index);
            if (pesoAtual + itemAtual.peso() <= instancia.getCapacidade()) {
                // Adiciona o item a mochila se tiver capacidade
                itensDaMochila.add(itemAtual);
                pesoAtual += itemAtual.peso();
                valorTotal += itemAtual.valor();
            }
        }

        // Define o fitness do indivíduo
        individuo.setFitness(valorTotal);

        return itensDaMochila;
    }
}
