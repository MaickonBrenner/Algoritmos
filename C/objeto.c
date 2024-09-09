#include <stdio.h>
#include <stdlib.h>

typedef struct {
    float altura;
    int idade;
} Pessoa;

int main() {
    char nome[] = "Nome";

    Pessoa pessoa;
    pessoa.idade = 22;

    printf("Digite a altura: ");
    scanf("%f", &pessoa.altura);
    printf("A altura de pessoa é %.2f e a idade %d", pessoa.altura, pessoa.idade);

    return 0;
}