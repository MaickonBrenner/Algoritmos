#include <stdio.h>
#include <stdlib.h>

//(Algoritmo Escalador First in - First out)

typedef enum {
    PRONTO, //0
    EM_EXECUCAO, //1
    BLOQUEADO //2
} EstadoProcesso;

typedef struct {
    int id;
    int tempo;
    EstadoProcesso estado;
} Processo;

void pacpas(Processo processos[], int num_processos) { //FIFO
    int tempo_atual = 0;

    for (int i = 0; i < num_processos; i++) {
        processos[i].estado = EM_EXECUCAO;
        printf("Tempo %d: Processo %d em execucao\n", 
            tempo_atual, processos[i].id);

        while(processos[i].tempo >= 0) {
            tempo_atual++;
            processos[i].tempo--;
            printf("Tempo %d: Processo %d em execucao\n", 
            tempo_atual, processos[i].id);
        }
        printf("Tempo %d: Processo %d concluido\n", 
            tempo_atual, processos[i].id);
    }
} 

int main() {
    Processo processos[] = {
        {1, 5, PRONTO},
        {2, 3, PRONTO},
        {3, 7, PRONTO}
    };
    
    int num_processos = sizeof(processos) / sizeof(processos[0]);

    pacpas(processos, num_processos);
    
    return 0;
}