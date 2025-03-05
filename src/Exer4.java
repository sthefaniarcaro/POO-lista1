/*4 Implemente um programa que receba duas matrizes de mesmas dimensões e imprima a
soma das mesmas. */

import java.util.Scanner;

public class Exer4 {
    // atributos
    double[][] matriz1;
    double[][] matriz2;
    int n, m;

    // metodos
    void soma_matrizes(double[][] matriz1, double[][] matriz2){
        double[][] soma = new double[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                soma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        System.out.println("soma das matrizes: ");
        exibir_matriz(soma);
    }

    void exibir_matriz(double[][] matriz){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.printf("%10.2f ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void gerar_matriz(double[][] matriz, Scanner scan){
        int op;

            do {
                System.out.print("\nselecione a opcao:\n");
                System.out.print("1 - inserir numeros manualmente.\n");
                System.out.println("2 - gerar numeros aleatoriamente.");
                op = scan.nextInt();
        
            } while(op != 1 && op != 2);
        
            if (op ==1 ){
                for(int i=0; i<n; i++){
                    for (int j=0; j<m; j++){
                        System.out.printf("digite o numero da matriz[%d][%d]: ", i, j);
                        matriz[i][j] = scan.nextDouble();

                    }
                }
            } else {
                for(int i=0; i<n; i++) {
                    for (int j=0; j<m; j++){
                        matriz[i][j] = Math.random()*100;
                    }
                }
            }
    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            Exer4 matrizes = new Exer4();

            System.out.print("digite o numero de linhas da matriz: ");
            matrizes.n = scan.nextInt();
            System.out.print("digite o numero de colunas da matriz: ");
            matrizes.m = scan.nextInt();

            System.out.println();

            matrizes.matriz1 = new double[matrizes.n][matrizes.m];
            matrizes.matriz2 = new double[matrizes.n][matrizes.m];

            System.out.println("\ngerar matriz 1: ");
            matrizes.gerar_matriz(matrizes.matriz1, scan);

            System.out.println("\ngerar matriz 2: ");
            matrizes.gerar_matriz(matrizes.matriz2, scan);
             
            System.out.println("matriz 1: ");
            matrizes.exibir_matriz(matrizes.matriz1);
            System.out.println("matriz 2: ");
            matrizes.exibir_matriz(matrizes.matriz2);
         
            matrizes.soma_matrizes(matrizes.matriz1, matrizes.matriz2);

        }
    }
}

