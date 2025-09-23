//Nomes dos componentes do grupo: Messias da Silva, Pedro Pinheiro
package mochila;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Armazena os dados Problema da Mochila.
public class InstanciaMochila {

    private final int capacidade;
    private final List<Item> itens;
    private final int numItens;

    //carrega os dados do problema de arquivo
    public InstanciaMochila(String caminhoArquivo) throws FileNotFoundException {
        this.itens = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        Scanner leitor = new Scanner(arquivo);

        this.capacidade = leitor.nextInt();
        this.numItens = leitor.nextInt();

        // valor e o peso de cada item
        while (leitor.hasNextInt()) {
            int valor = leitor.nextInt();
            int peso = leitor.nextInt();
            this.itens.add(new Item(valor, peso));
        }

        leitor.close();
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Item> getItens() {
        return itens;
    }

    public int getNumItens() {
        return numItens;
    }
}