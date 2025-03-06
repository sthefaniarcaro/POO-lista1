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

class Pessoa{
    protected String nome, endereco, RG, telefone, nascimento; // protected é usado para permitir acesso a atributos e metodos que implementam a classe principal - ex: classe aluno terá acesso aos atributos da classe pessoa
}

// classe
class Aluno extends Pessoa{
    // atributos
    private String RA;
    private double CR;
    
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
    
    // usado para acessar variaveis privates
    public String getRa(){
        return this.RA;
    }

    public double getCR(){
        return this.CR;
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

    private static int menu(Scanner scan){
        int op;
        do { 
            System.out.printf("selecione a opcao:\n\n");
            System.out.printf("0 - sair do programa.\n");
            System.out.printf("1 - inserir um novo aluno no cadastro.\n");
            System.out.printf("2 - buscar aluno por RA.\n");
            System.out.printf("3 - exibir dados de alunos.\n");
            op = scan.nextInt();
        } while (op != 0 && op != 1 && op != 2 && op != 3);
        return op;
    }

    private static void inserir_aluno(Aluno[] cadastro, int total_alunos, Scanner scan){

        if (total_alunos >= 100) {
            System.out.println("O cadastro esta cheio!");
            return;
        }

        scan.nextLine();

        System.out.print("digite o nome do aluno: ");
        String nome = scan.nextLine();

        System.out.print("digite o endereco do aluno: ");
        String endereco = scan.nextLine();

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

    public static void main(String[] args){
        try(Scanner scan = new Scanner(System.in)){
            Aluno[] cadastro = new Aluno[100]; // vetor de alunos da classe Aluno
            int total_alunos = 0; // contador de alunos cadastrados
            
            int op;
            do {
            // exer5.menu(scan); pois o método menu é um método de instancia dentro da classe Exer5
            switch (op = menu(scan)){ 
                case 1:
                    inserir_aluno(cadastro, total_alunos, scan);
                    break;
                
                case 2:
                    System.out.print("digite o RA do aluno: ");
                    String RA = scan.next();
                    boolean encontrado = false;

                    for(int i=0; i<total_alunos; i++){
                        if(RA.equals(cadastro[i].getRa())){
                            cadastro[i].exibir_aluno();
                            encontrado = true;
                            break;
                        } 
                    }

                    if (!encontrado){
                        System.out.println("RA nao encontrado.");
                    }
                    break;

                case 3: 
                int opcao;
                    do {
                        System.out.printf("selecione a opcao:\n\n");
                        System.out.printf("0 - voltar ao menu principal.\n");
                        System.out.printf("1 - ordenar por RA.\n");
                        System.out.printf("2 - ordenar por nome.\n");
                        System.out.printf("3 - ordenar por CR.\n");
                        opcao = scan.nextInt();

                    } while(opcao != 0 && opcao != 1 && opcao != 2 && opcao != 3);
                
                     if(opcao ==1){
                            for(int i =0; i<total_alunos; i++){
                                for(int j=i+1; j<total_alunos; j++){
                                    if(cadastro[i].getRa().compareTo(cadastro[j].getRa()) > 0){
                                        Aluno aux = cadastro[i];
                                        cadastro[i] = cadastro[j];
                                        cadastro[j] = aux;
                                    }
                                }
                            }   
                     } else if(opcao == 2){
                            for(int i=0;i<total_alunos;i++){
                                for(int j=i+1;j<total_alunos;j++){
                                    if(cadastro[i].nome.compareTo(cadastro[j].nome)>0){
                                        Aluno aux = cadastro[i];
                                        cadastro[i] = cadastro[j];
                                        cadastro[j] = aux;
                                    }
                                }
                            }
                        } else if(opcao == 3){
                          
                            for(int i=0; i<total_alunos; i++){
                                for(int j= i+1; j<total_alunos;j++){
                                    if(cadastro[i].getCR() > cadastro[j].getCR()){
                                        Aluno aux = cadastro[i];
                                        cadastro[i] = cadastro[j];  
                                        cadastro[j] = aux;
                                    }
                                }
                            } 
                    } else {
                        break;
                    }
                    for(int i=0; i<total_alunos; i++){
                        cadastro[i].exibir_aluno();
                    }

                break;
                default:
                    throw new AssertionError();
                }
            } while (op !=0);
        }
    
    }
    
}
