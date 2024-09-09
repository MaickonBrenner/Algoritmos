#include <stdio.h>
#include <stdlib.h>

//Algoritmo de Escalonamento por Prioridade 

typedef enum {
    PRONTO,
    EM_EXECUCAO,
    BLOQUEADO
} EstadosProcesso;

typedef struct {
    int id;
    int tempo;
    int prioridade;
    EstadosProcesso estado;
} Processo;

void ordernarPorPrioridade(Processo processos[], int numeroProcessos) {
    //BubbleSort
    Processo temp;
    for (int i = 0; i < (numeroProcessos - 1); i++) {
        for (int j = 0; j < (numeroProcessos - i - 1); j++) {
            if (processos[j].prioridade < processos[j + 1].prioridade) {
                temp = processos[j];
                processos[j] = processos[j + 1];
                processos[j + 1] = temp;
            }
        }
    }
}

void escalonamentoPorPrioridade(Processo processos[], int numeroProcessos) {
    ordernarPorPrioridade(processos, numeroProcessos);
    printf("Ordem de execução dos processos: \n");
    for (int i = 0; i < numeroProcessos; i++) {
        printf("P%d \n", processos[i].id);
    }
    printf("\n");
}

int main() {
    int numeroProcessos;
    printf("Digite o numero de processos \n");
    scanf("%d", &numeroProcessos);
    Processo processos[numeroProcessos];

    for (int i = 0; i < numeroProcessos; i++) {
        processos[i].id = i + 1;
        printf("Digite a prioridade para o processo P%d \n", i + 1);
        scanf("%d", &processos[i].prioridade);
        printf("Digite o tempo de execução para o processo P%d \n", i + 1);
        scanf("%d", &processos[i].tempo);
    }

    escalonamentoPorPrioridade(processos, numeroProcessos);
    
    return 0;
}