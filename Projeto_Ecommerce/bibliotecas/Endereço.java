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
public class Endereço {
    String endereço, complemento;
    int CEP;

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }
    
    public void cadScanEndereço(){  //Metodo scan Endereço
        int tryCatch;
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o endereço: ");
        setEndereço(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadScanComplemento(){  //Metodo scan Complemento
        int opSn = 1, tryCatch;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seu endereço possui complemento?");
        while(opSn == 1){
            do{try{
        System.out.print("Digite 1 para sim ou 2 para não: ");
        opSn = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        if(opSn == 1){
            do{try{
        System.out.print("Digite o complemento: ");
        scanner.nextLine(); //Limpando erro
        setComplemento(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        opSn = 2;
        }else if(opSn != 2){
        System.out.println("\n!-----------------------------------opção invalida-----------------------------------!\n");
        opSn = 1;
        }
        }
    }
    
    public void cadScanCEP(){  //Metodo scan CEP
        int tryCatch;
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o CEP: ");
        setCEP(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void printEndereço(){  //Metodo print Endereço
        if(getEndereço() == null){
        } else{
        System.out.println("Endereço: "+getEndereço());
        }
    }
    
    public void printComplemento(){  //Metodo print Complemento
        if(getComplemento() == null){
        } else{
        System.out.println("Complemento: " +getComplemento());
        }
    }
    
    public void printCEP(){  //Metodo print CEP
        if(getCEP() == 0){
        } else{
        System.out.println("CEP: " +getCEP());
        }
    }
}
