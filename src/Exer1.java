/* 1 Escreva um programa que receba pelo teclado os coeficientes de uma equação de segun-
do grau (ax2 + bx + c = 0), resolva-a e imprima o resultado na tela. */

import java.util.Scanner;

// classe
public class Exer1 {

    //metodos 
    void equacao2(double a, double b, double c){
        //atributos = variaveis
        double x1, x2;
        double delta = Math.pow(b,2) - 4*a*c;

        if (a == 0) {
            System.out.printf("o coeficiente 'a' nao pode ser zero!\n");
        } else 
        if (delta < 0){
            System.out.printf("a equacao nao possui raizes reais!\n");
        } else if (delta ==0) {
            x1 = (-b + Math.sqrt(delta))/(2*a);
            System.out.printf("a equacao possui uma raiz real: %.2f\n", x1);
        } else {
            x1 = (-b +Math.sqrt(delta))/(2*a);
            x2 = (-b -Math.sqrt(delta))/(2*a);
            System.out.printf("a equacao possui duas raizes reais: %.2f e %.2f\n", x1,x2);
        }
    }

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){

            System.out.print("calculo de equacao de segundo grau!\n");

            System.out.print("digite o valor de a: ");
            double a = scan.nextDouble();
            System.out.print("digite o valor de b: ");
            double b = scan.nextDouble();
            System.out.print("digite o valor de c: ");
            double c = scan.nextDouble();

            //objetos
            Exer1 coeficientes = new Exer1();
            coeficientes.equacao2(a, b, c);
        }
    }
    
}
