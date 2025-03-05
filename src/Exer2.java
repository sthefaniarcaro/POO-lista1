/*2 Implemente um programa que receba do usuário um valor natural N e imprima na tela o N-
ésimo Termo de Fibonacci. */

import java.util.Scanner;

//classe
public class Exer2 {
    // atributos
    int n;
    
        // metodos
        void fibonacci(int n){
            int a, b, c;
            b=1;
            a=0;
    
            for(int i=0; i<n; i++){
                c = b + a;
                a = b;
                b = c;
                System.out.printf("%d ", c);
            }

        }
    
        public static void main(String[] args) {
            try(Scanner scan = new Scanner(System.in)){
                //objetos
                Exer2 fibo = new Exer2();
    
                System.out.print("digite um valor numerico: ");
                fibo.n = scan.nextInt();
    
                fibo.fibonacci(fibo.n);
        }
    }
}





