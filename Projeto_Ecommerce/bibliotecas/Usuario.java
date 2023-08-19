/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public abstract class Usuario {
    private String nome;
    private int senha, tryCatch;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public Usuario(String nome, int senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario() {}
    
    public void cadNome(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Nome: "); //Nome
        setNome(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadSenha(){  
        Scanner scanner = new Scanner(System.in);
        int backSenha = 0, backSetSenha = 0;
        
        do{
            do{try{
        System.out.print("Digite sua senha: "); //Senha
        backSetSenha = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
            do{try{
        System.out.print("Digite sua senha novamente: ");
        backSenha = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        
        if(backSetSenha != backSenha){
            System.out.println("\n!----------------------------Senha invalida-----------------------------!\n");
        }
        }while(backSetSenha != backSenha);
        
        setSenha(backSetSenha);
    }
    
    public void printUserName(){ //Metodo print nome do Usuario (apenas se tiver sido atribuido)
        if(getNome() == null){
        } else{
        System.out.println("Nome: "+ getNome());
        }
    }
    
    public abstract void printAll(); //Metodo print todos atributos
}
