#include <stdio.h>
#include <stdlib.h>

//Algoritmo de Escalonamento Tarefa Mais Curta Primeiro - STF (Shortest Task First)

typedef enum {
    PRONTO, //0
    EM_EXECUCAO, //1
    BLOQUEADO //2
} EstadosProcesso;

typedef struct {
    int id;
    int tempo;
    EstadosProcesso estado;
} Processo;

int encontrarMenorTempo(Processo processos[], int num_processos) {
    int menorTempo = 99999; //Valor inicial grande para comparação
    int indiceMenorTempo = -1;

    for (int i = 0; i < num_processos; i++) { 
        if(processos[i].estado == 0 && processos[i].tempo < menorTempo) {
            menorTempo = processos[i].tempo;
            indiceMenorTempo = i;
        }
    }

    return indiceMenorTempo;
}

void tarefaMaisCurtaPrimeiro (Processo processos[], int num_processos) {
    while(1) {
        int indiceMenorTempo = encontrarMenorTempo(processos, num_processos);

        if(indiceMenorTempo == -1) {
            break;
        }
        
        processos[indiceMenorTempo].estado = 1; //EM_EXECUCAO
        int tempo_atual = 0;
        printf("Tempo %d Processo %d em execucao\n", tempo_atual, processos[indiceMenorTempo].id);

        while(processos[indiceMenorTempo].tempo > 0) {
            tempo_atual++;
            processos[indiceMenorTempo].tempo--;
            printf("Tempo %d Processo %d - Tempo Restante %d\n", tempo_atual, processos[indiceMenorTempo].id, processos[indiceMenorTempo].tempo);
        }

        printf("Processo %d concluido\n", processos[indiceMenorTempo].id);
    }
}

int main() {

    Processo processos[] = {
        {1, 8, PRONTO},
        {2, 12, PRONTO},
        {3, 15, PRONTO},
        {4, 6, PRONTO},
        {5, 20, PRONTO},
        {6, 14, PRONTO},
        {7, 4, PRONTO},
        {8, 3, PRONTO},
        {9, 8, PRONTO},
        {10, 5, PRONTO}
    };
    
    int num_processos = sizeof(processos) / sizeof(processos[0]);
    tarefaMaisCurtaPrimeiro(processos, num_processos);
          
    return 0;
}