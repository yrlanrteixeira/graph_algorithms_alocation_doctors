# Graph Algorithms Allocation Doctors

Este projeto é uma aplicação de alocação de médicos usando algoritmos de grafos. Ele permite alocar médicos para períodos de férias garantindo que todos os dias de férias sejam cobertos e respeitando restrições específicas, como o número máximo de dias de trabalho por médico e a disponibilidade de cada médico.

## Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Instruções de Uso](#instruções-de-uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Exemplos de Entrada e Saída](#exemplos-de-entrada-e-saída)
- [Licença](#licença)

## Visão Geral

O objetivo deste projeto é resolver o problema de alocação de médicos durante períodos de férias, garantindo que haja pelo menos um médico de plantão em cada dia de férias. O algoritmo utilizado é baseado em fluxos em rede para garantir a otimização e a correta alocação dos médicos.

## Funcionalidades

- Alocação de médicos para períodos de férias com base em suas disponibilidades.
- Respeito às restrições de dias máximos de trabalho por médico.
- Interface gráfica para entrada de dados e visualização dos resultados.
- Algoritmo eficiente baseado em fluxos em rede.

## Tecnologias Utilizadas

- Java
- Swing (para a interface gráfica)
- Maven (para gerenciamento de dependências)

## Configuração do Ambiente

### Pré-requisitos

- Java JDK 11 ou superior
- Maven

### Passos para Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/yrlanrteixeira/graph_algorithms_alocation_doctors.git
   cd graph_algorithms_alocation_doctors


2. Configure o projeto com Maven:

   ```bash
   mvn clean install
   ```

3. Execute a aplicação:
  
   ```bash
   mvn exec:java
   ```

## Instruções de Uso

### Interface Gráfica

1. **Número de Médicos:** Insira o número total de médicos.
2. **Número de Períodos de Férias:** Insira o número total de períodos de férias.
3. **Máximo de Dias de Férias por Médico:** Insira o número máximo de dias de férias que cada médico pode trabalhar.
4. Clique em "Adicionar Períodos de Férias" para gerar campos de entrada para os períodos de férias.
5. Insira os dias de cada período de férias nos campos gerados.
6. Clique em "Adicionar Disponibilidade dos Médicos" para gerar campos de entrada para a disponibilidade dos médicos.
7. Insira os dias de disponibilidade de cada médico nos campos gerados.
8. Clique em "Processar" para calcular e exibir a alocação dos médicos.


## Exemplos de Entrada e Saída

### Exemplo 1

**Entrada:**
- Número de Médicos: 3
- Número de Períodos de Férias: 2
- Máximo de Dias de Férias por Médico: 2

**Períodos de Férias:**
- Período 1: 1 2 3
- Período 2: 4 5

**Disponibilidade dos Médicos:**
- Médico 1: 1 2 4
- Médico 2: 2 3 5
- Médico 3: 1 5

**Saída:**
É possível selecionar um médico para cada dia de férias.
