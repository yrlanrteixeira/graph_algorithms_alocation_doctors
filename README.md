# Graph Algorithms Allocation Doctors

Este projeto é uma aplicação de alocação de médicos usando algoritmos de grafos. Ele permite alocar médicos para períodos de férias garantindo que todos os dias de férias sejam cobertos e respeitando restrições específicas, como o número máximo de dias de trabalho por médico e a disponibilidade de cada médico.

## Índice

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Instruções de Uso](#instruções-de-uso)
- [Exemplos de Entrada e Saída](#exemplos-de-entrada-e-saída)

## Visão Geral

O objetivo deste projeto é resolver o problema de alocação de médicos durante períodos de férias, garantindo que haja pelo menos um médico de plantão em cada dia de férias. O algoritmo utilizado é baseado em fluxos em rede para garantir a otimização e a correta alocação dos médicos.

## Funcionalidades

- Alocação de médicos para períodos de férias com base em suas disponibilidades.
- Respeito às restrições de dias máximos de trabalho por médico.
- Algoritmo eficiente baseado em fluxos em rede (Edmond-Karp).

## Tecnologias Utilizadas

- Java

## Configuração do Ambiente

### Pré-requisitos

- Java JDK 22

### Passos para Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/yrlanrteixeira/graph_algorithms_alocation_doctors.git
   cd graph_algorithms_alocation_doctors


2. Execute a aplicação:
  
   Com a sua IDE favorita execute o arquivo 'main.java.com.doctorswithoutweekends.Main.java' e ele irá aparecer as instruções no terminal.

## Instruções de Uso

### Interface de Uso

O programa irá pedir que você indique algumas informações para que ele possa realizar a associação dos médicos com os dias disponíveis, dentre as informações pedidas estão:

1. **Número de Médicos:** Insira o número (inteiro) total de médicos (Exemplo: 3).
2. **Número de dias disponíveis para o médico X:** Insira o número de dias disponíveis que o médico X tem (Exemplo: 3).
3. **Dias disponíveis para o médico X:** Insira os dias que o médico X tem disponibilidade (Os dias devem ser separados por espaço. Exemplo: 1 2 3).
4. **Número de período de férias:** Insira a quantidade de periodo de férias que o hospital terá (Exemplo: 2).
5. **Números de dias de férias do periodo X:** Insira a quantidade de dias que o periodo de férias X terá (Exemplo: 2).
6. **Dias do período de férias X:** Insira os dias pertencentes ao periodo de férias X (Os dias devem ser separados por espaço. Exemplo: 1 2 3).
7. **Número máximo de dias de férias que um médico pode trabalhar:** Insira o número máximo de dias que um médico pode trabalhar (Exemplo: 2).

## Exemplos de Entrada e Saída

### Exemplo

**ENTRADA:**
- Número de Médicos: 3
   - Médico 1:
      - Número de dias: 3
      - Dias disponíveis: 1 2 3
   - Médico 2:
      - Número de dias: 3
      - Dias disponíveis: 2 3 4
   - Médico 3:
      - Número de dias: 2
      - Dias disponíveis: 1 4
         
- Número de Períodos de Férias: 2
   - Período 1:
      - Número de dias: 2
      - Dias disponíveis: 1 2
    
   - Período 2:
      - Número de dias: 2
      - Dias disponíveis: 3 4
       
- Máximo de Dias de Férias por Médico: 2

**SAÍDA:**

É possível realizar a seguinte atribuição de médicos:

- Médico 1 ao dia 1 (Período 1)
- Médico 1 ao dia 2 (Período 1)
- Médico 2 ao dia 3 (Período 2)
- Médico 2 ao dia 4 (Período 2)

