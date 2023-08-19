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
public class Fornecedor extends Usuario{
    private String descriçãoDev;
    private int devNum;
    Endereço endereço = new Endereço();
    Endereço endCobrança = new Endereço();

    public String getDescriçãoDev() {
        return descriçãoDev;
    }

    public void setDescriçãoDev(String descriçãoDev) {
        this.descriçãoDev = descriçãoDev;
    }

    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
    }

    public Fornecedor(String descriçãoDev, String nome, int senha, String endereco, String complemento, int CEP, String endereco2, String complemento2, int CEP2, int devNumb) {
        super(nome, senha);
        this.descriçãoDev = descriçãoDev;
        endereço.endereço = endereco;
        endereço.complemento = complemento;
        endereço.CEP = CEP;
        endCobrança.endereço = endereco2;
        endCobrança.complemento = complemento2;
        endCobrança.CEP = CEP;
        this.devNum = devNumb;
    }
    
    public Fornecedor(String nome, int senha) {
        super(nome, senha);
    }
    
    public Fornecedor(){}
    
    public void cadDescriçãoDev(){
        int tryCatch = 1;
        Scanner scanner = new Scanner(System.in);
        int opSn = 1;
        System.out.println("Deseja escrever uma breve descrição sobre você ou sua empresa?");
        while(opSn == 1){
        do{try{
        System.out.print("Digite 1 para sim ou 2 para não: ");
        opSn = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            opSn = 0;
        }
        }while(opSn == 0);
        
        if(opSn == 1){
        do{try{
        System.out.print("Digite uma descrição de você/empresa: "); //DescriçãoDev
        scanner.nextLine(); //Limpando erro
        setDescriçãoDev(scanner.nextLine());
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
    
    public void cadEndereço(){  //Endereço
        System.out.println("\n=--------------------------------------Endereço----------------------------------------=\n");
        endereço.cadScanEndereço();
        endereço.cadScanComplemento();
        endereço.cadScanCEP();
    }
    
    public void cadEndCobrança(){  //Endereço cobrança
        System.out.println("\n=--------------------------------Endereço de cobrança----------------------------------=\n");
        endCobrança.cadScanEndereço();
        endCobrança.cadScanComplemento();
        endCobrança.cadScanCEP();
    }
    
    
    public void printDevNum(){
        if(getDevNum() == 0){
        } else{
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        System.out.println("Seu código de fornecedor é: "+ getDevNum());
        }
    }
    
    public void printDescriçãoDev(){
        if(getDescriçãoDev() == null){
        } else{
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        System.out.println("Descrição: "+ getDescriçãoDev());
        }
    }

    public void printEndereço(){  //Endereço
        System.out.println("\n=--------------------------------------Endereço----------------------------------------=\n");
        endereço.printEndereço();
        endereço.printComplemento();
        endereço.printCEP();
    }
    
    public void printEndCobrança(){  //Endereço cobrança
        System.out.println("\n=--------------------------------Endereço de cobrança----------------------------------=\n");
        endCobrança.printEndereço();
        endCobrança.printComplemento();
        endCobrança.printCEP();
    }
    
    @Override
    public void printAll(){  //Ajeitar
        printUserName();
        printDescriçãoDev();
        printEndereço();
        printEndCobrança();
    }
}
