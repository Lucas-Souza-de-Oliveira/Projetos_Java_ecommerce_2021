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
public class Cartão {
    private String cardName;
    private int codSeguran, dataVali, cardNum, senha, tryCatch;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCodSeguran() {
        return codSeguran;
    }

    public void setCodSeguran(int codSeguran) {
        this.codSeguran = codSeguran;
    }

    public int getDataVali() {
        return dataVali;
    }

    public void setDataVali(int dataVali) {
        this.dataVali = dataVali;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    public void cadNomeCartão(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o seu nome como está escrito em seu cartão: "); //Nome do Cartão
        setCardName(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadCodigoSegurança(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o código de segurança de seu cartão: "); //cod segurança Cartão
        setCodSeguran(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadVencimento(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite a data de vencimento de seu cartão: "); //vencimento Cartão
        setDataVali(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadCardNum(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o número de seu cartão: "); //Número Cartão
        setCardNum(scanner.nextInt());
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
        do{try{
        System.out.print("Digite a senha de seu cartão: "); //Senha Cartão
        setSenha(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadCardAll(){
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        cadNomeCartão();
        cadCodigoSegurança();
        cadVencimento();
        cadCardNum();
    }
    
    public void printCardName(){
        if(getCardName() == null){
        } else{
        System.out.println("Nome presente no cartão: "+ getCardName());
        }
    }
    
    public void printCodigoSegurança(){
        if(getCodSeguran() == 0){
        } else{
        System.out.println("Código de segurança do cartão: "+ getCodSeguran());
        }
    }
    
    public void printVencimento(){
        if(getDataVali() == 0){
        } else{
        System.out.println("Vencimento do cartão: "+ getDataVali());
        }
    }
    
    public void printCardNum(){
        if(getCardNum() == 0){
        } else{
        System.out.println("Número do cartão: "+ getCardNum());
        }
    }
    
    public void printCardAll(){
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        printCardName();
        printCodigoSegurança();
        printVencimento();
        printCardNum();
    }
}
