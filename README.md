# BRKGA - Mochila Binária

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Optimization](https://img.shields.io/badge/Pesquisa%20Operacional-Optimization-success?style=for-the-badge)

Projeto desenvolvido para a disciplina de **Pesquisa Operacional**. Consiste na implementação de um Algoritmo Genético de Chaves Aleatórias Viciadas (**BRKGA** - *Biased Randomized-Key Genetic Algorithm*) para solucionar o clássico **Problema da Mochila Binária** (Knapsack Problem).

## Sobre o Projeto

O Problema da Mochila Binária é um desafio de otimização combinatória onde o objetivo é preencher uma mochila com itens de diferentes pesos e valores de forma a maximizar o valor total, sem ultrapassar a capacidade máxima de peso da mochila.

Este projeto resolve esse problema através de **Metaheurísticas** (BRKGA), evoluindo populações de soluções ao longo de gerações para encontrar o melhor resultado possível.

### Estrutura do Algoritmo
* **Cromossomos:** Representados por chaves aleatórias (números reais entre 0 e 1).
* **Decodificador:** Transforma a chave aleatória numa solução válida (escolhendo quais itens entram na mochila).
* **Evolução:** Cruzamento parametrizado favorecendo o "Pai de Elite" para convergir para melhores soluções.

## Estrutura do Repositório

* `BRKGAMochilaBinaria/`: Pasta principal contendo o código-fonte Java com as classes que modelam os itens, a mochila, a população e o algoritmo evolutivo.

## Como Executar

1. **Clone este repositório:**
   ```bash
   git clone [https://github.com/ctrlPedroPinheiro/BRKGA-Mochila-Binaria.git](https://github.com/ctrlPedroPinheiro/BRKGA-Mochila-Binaria.git)
