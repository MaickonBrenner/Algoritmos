#include <stdio.h>
#include <stdlib.h>

main() {
    /*
    printf("Digite o tamanho da matriz: (Ex.: 2x2 ou 3x3)");
    scanf();
    */
    int n = 2;
    int matriz[n][n];
    int i, j;

    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            printf("Digite o valor da linha %d, coluna %d", i + 1, j + 1);
            scanf("%d ", &matriz[i][j]);
        }
        printf("\n");
    }

    printf("\n");

    printf("Matriz original: \n");
    for (i = 0; i < n; i++) {
        for(j = 0; j < n; j++) {
            printf("%d ", matriz[i][j]);
        }
        printf("\n");
    }

    printf("\n");

    printf("Matriz transposta: \n");
    for (i = 0; i < n; i++) {
        for(j = 0; j < n; j++) {
            printf("%d ", matriz[j][i]);
        }
        printf("\n");
    }

    return 0;
}