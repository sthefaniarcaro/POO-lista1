/* 3 Escreva um programa que receba do usuário um vetor de inteiros e imprima esse vetor or-
denado. */

import java.util.Scanner;

public class Exer3 {
    // atributos
    int n;
    double[] vetor;

    void criarvetor(int n){
        vetor = new double[n];

        try (Scanner scan = new Scanner(System.in)){
            for(int i=0; i<n; i++){
                System.out.printf("digite o %do valor numerico: ", i+1);
                vetor[i]= scan.nextDouble();
            }
        }
    }

    void ordenarvetor(int n, double[] vetor){
        double aux;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(vetor[i] > vetor[j]){
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
    }

    void exibirvetor(int n, double[] vetor){
        for(int i=0; i<n; i++){
            System.out.printf("%.2f ", vetor[i]);
        }
    }

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            Exer3 vet = new Exer3();

            System.out.print("digite o tamanho do vetor: ");
            vet.n = scan.nextInt();

            vet.criarvetor(vet.n);
            vet.ordenarvetor(vet.n, vet.vetor);
            vet.exibirvetor(vet.n, vet.vetor);

        }
    }
}
