/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class FornecedorDAO {
    public static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    
    public static void novoFornIndieShop(){
        String nome = "IndieShop", descrip = "Conectando desenvolvedores e jogadores.";
        String endereco = "Rua número 8, 55", compl = "";
        int senha = 1234, cep = 22456222, code = 123321;
        Fornecedor forn = new Fornecedor(descrip, nome, senha, endereco, compl, cep, endereco, compl, cep, code);
        fornecedores.add(forn);
    }
    
    public static void novoFornecedor() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Fornecedor forn = new Fornecedor();
    forn.cadNome();
    forn.cadSenha();
    forn.cadDescriçãoDev();
    forn.cadEndereço();
    forn.cadEndCobrança();
    int fornNum = (int)(Math.random()*(999999-100000+1)+100000);  
    forn.setDevNum(fornNum);
    fornecedores.add(forn);
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    forn.printAll();
    forn.printDevNum();
  }
    
    public static void alterarFornecedor(int codigo) {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    int indice = -1;
    Fornecedor aux = new Fornecedor();
    for (int i = 0; i < fornecedores.size(); i++) {
      aux = fornecedores.get(i);
      if (codigo == aux.getDevNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      System.out.println("=-------------------------------------Dados atuais-------------------------------------=\n");
      aux.printAll();
      System.out.println("\n=--------------------------------------------------------------------------------------=\n");
      System.out.println("Novos dados: ");
      aux.cadNome();
      aux.cadSenha();
      aux.cadDescriçãoDev();
      aux.cadEndereço();
      aux.cadEndCobrança();
      fornecedores.set(indice, aux);
      System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    } else {
      System.out.println("\n!-----------------------------------código invalido------------------------------------!\n");
    }
    }
    
    public static void excluirFornecedor(int codigo) {
        int tryCatch;
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Scanner scanner = new Scanner(System.in);
    int indice = -1;
    Fornecedor aux = new Fornecedor();
    for (int i = 0; i < fornecedores.size(); i++) {
      aux = fornecedores.get(i);
      if (codigo == aux.getDevNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      System.out.println("=-------------------------------------Dados atuais-------------------------------------=\n");
      aux.printAll();
      int opSn= 0;
      do{
      System.out.println("\n=--------------------------------------------------------------------------------------=\n");
      do{try{
      System.out.print("Confirmar exclusão? Digite 1 para sim ou 2 para não: ");
      opSn = scanner.nextInt();
      tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
	switch(opSn){
	case 1:
            fornecedores.remove(indice);
            opSn = 2;
            break;
	case 2:
            break;
	default:
            System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!");
	}
       }while(opSn != 2);
    } else {
      System.out.println("\n!---------------------------------fornecedor invalido----------------------------------!\n");
    }
    }

    public static void listarFornecedor() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Iterator<Fornecedor> listForn = fornecedores.iterator();
    int cont = 0;
    while (listForn.hasNext()) {
      listForn.next().printAll();
      cont++;
    }
    System.out.println("Total de fornecedores:[" + cont + "].");
  }
    
  public static boolean verificarFornecedor(int codigo) {
    int indice = -1;
    Fornecedor aux = new Fornecedor();
    for (int i = 0; i < fornecedores.size(); i++) {
      aux = fornecedores.get(i);
      if (codigo == aux.getDevNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      return true;
    } else {
      return false;
    }
  }
  
  public static boolean verificarFornSenha(int codigo, int senha) {
    int indice = -1;
    Fornecedor aux = new Fornecedor();
    for (int i = 0; i < fornecedores.size(); i++) {
      aux = fornecedores.get(i);
      if (codigo == aux.getDevNum()) {
          if(senha == aux.getSenha()){
              indice = i;
              break;
          }
      }
    }
    if (indice != -1) {
      return true;
    } else {
      return false;
    }
  }
}
