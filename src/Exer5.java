/* 5 - Suponha um cadastro de alunos onde cada aluno contém os campos: Nome, Data de Nas-
cimento (dia, mês, ano), RG, Endereço (Rua, Cidade, Estado, CEP), Telefone, RA (Regis-
tro de Aluno) e CR (Coeficiente de Rendimento: número real entre 0 e 10). Faça um pro-
grama que realize o cadastro de alunos em um vetor com 100 posições. O programa deve

manipular este cadastro com as seguintes opções:
a. Inserir um novo aluno no cadastro
b. Ler o valor de um RA e imprimir os dados do aluno com este RA (se houver)
c. Imprimir todos os cadastros, com o usuário podendo escolher se:
i. Ordenados por RA
ii. Ordenados por Nome
iii. Ordenados por CR

Observações: você deve criar uma classe Aluno, subclasse de Pessoa, com os campos
necessários e ao menos os métodos para:
- obter e alterar o valor dos campos
- imprimir os dados do aluno */

import java.util.Scanner;

// classe
class Aluno {
    // atributos
        String nome, endereco, RA, RG, telefone, nascimento;
        double CR;
    
    // metodos

    // construtor da classe Aluno com os atributos da classe Aluno
    // ele serve para criar um objeto da classe Aluno com os atributos da classe Aluno definidos
    public Aluno(String nome, String endereco, String RA, String RG, String telefone, String nascimento, double CR){
        this.nome = nome;
        this.endereco = endereco;
        this.RA = RA;
        this.RG = RG;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.CR = CR;
    }

    // metodos 
    public void exibir_aluno(){
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Endereco: %s\n", endereco);
        System.out.printf("RA: %s\n", RA);
        System.out.printf("RG: %s\n", RG);
        System.out.printf("Telefone: %s\n", telefone);
        System.out.printf("Nascimento: %s\n", nascimento);
        System.out.printf("CR: %.2f\n", CR);

    }

}

public class Exer5 {
    Aluno[] cadastro = new Aluno[100]; // vetor de alunos da classe Aluno
    int total_alunos = 0; // contador de alunos cadastrados

    int menu(Scanner scan){
        int op;
        do { 
            System.out.printf("selecione a opcao:\n\n");
            System.out.printf("0 - sair do programa.\n");
            System.out.printf("1 - inserir um novo aluno no cadastro.\n");
            System.out.printf("2 - buscar aluno por RA.\n");
            System.out.printf("3 - exibir dados.\n");
            op = scan.nextInt();
        } while (op != 0 && op != 1 && op != 2 && op != 3);
        return op;
    }
    void inserir_aluno(Scanner scan){
        System.out.print("digite o nome do aluno: ");
        String nome = scan.next();

        System.out.print("digite o endereco do aluno: ");
        String endereco = scan.next();

        System.out.print("digite o RA do aluno: ");
        String RA = scan.next();

        System.out.print("digite o RG do aluno: ");
        String RG = scan.next();

        System.out.print("digite o telefone do aluno: ");
        String telefone = scan.next();

        System.out.print("digite a data de nascimento do aluno: ");
        String nascimento = scan.next();

        System.out.print("digite o CR do aluno: ");
        double CR = scan.nextDouble();

        Aluno novo = new Aluno(nome, endereco, RA, RG, telefone, nascimento, CR); // objeto da classe Aluno 
        cadastro[total_alunos] = novo; // será igual aos dados inseridos
        total_alunos++;
    }

    public void exibir_aluno(){
        System.out.printf("Nome: %s \n", nome);
        System.out.printf("Endereco: %s \n ", endereco);
        System.out.printf("RA: %s \n", RA);
        System.out.printf("RG: %s \n", RG);
        System.out.printf("Telefone: %s \n", telefone);
        System.out.printf("Nascimento: %s \n", nascimento);
        System.out.printf("CR: %.2f \n", CR);
        System.out.println();
    }


    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            Exer5 exer5 = new Exer5(); // objeto da classe Exer5
            
            int op;
            do {
            // exer5.menu(scan); pois o método menu é um método de instancia dentro da classe Exer5
            switch (op = exer5.menu(scan)){ 
                case 1:
                    exer5.inserir_aluno(scan);
                    break;
                
                case 2:
                    System.out.print("digite o RA do aluno: ");
                    String RA = scan.next();
                    boolean encontrado = false;

                    for(int i=0; i<exer5.total_alunos; i++){
                        if(RA.equals(exer5.cadastro[i].RA)){
                            exer5.cadastro[i].exibir_aluno();
                            encontrado = true;
                            break;
                        } 
                    }

                    if (!encontrado){
                        System.out.println("RA nao encontrado.");
                    }
                    
                default:
                    throw new AssertionError();
                }
            } while (op !=0);
        }
    
    }
    
}
