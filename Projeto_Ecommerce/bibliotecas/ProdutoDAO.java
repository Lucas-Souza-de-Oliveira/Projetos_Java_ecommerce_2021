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
public class ProdutoDAO {
    public static ArrayList<Produto> produtos = new ArrayList<Produto>();
    
    public static void novoProdIndieShop(){
        String nome = "Camisa IndieShop", descrip = "Camisa de algodão estampada, tamanho M, cor preta.", categ = "Camisa";
        int estoc = 200, estocMin = 10, prodNumb = 1111111;
        double price = 23.99;
        
        Produto prod = new Produto(nome, descrip, categ, estoc, estocMin, price, prodNumb);
        produtos.add(prod);
    }
    
    public static void novoProduto(int devNum) {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Produto prod = new Produto();
    prod.cadNome();
    prod.cadDescrição();
    prod.cadCategoria();
    prod.cadEstoque();
    prod.cadEstoqueMin();
    prod.cadValor();
    prod.setDevNumBack(devNum);
    int prodNum = (int)(Math.random()*(999999999-100+1)+100);  
    prod.setProdNum(prodNum);
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    prod.printProdNum();
    produtos.add(prod);
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
  }
    
    public static void alterarProduto() {
        int tryCatch;
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Scanner scanner = new Scanner(System.in);
    int codigo = 0;
    do{try{
    System.out.print("Digite o código do produto a ser alterado: ");
    codigo = scanner.nextInt();
    tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    int indice = -1;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      System.out.println("Dados atuais: ");
      aux.printProdAll();
      System.out.println("\n=--------------------------------------------------------------------------------------=\n");
      System.out.println("Novos dados: ");
      aux.cadNome();
      aux.cadDescrição();
      aux.cadCategoria();
      aux.cadEstoque();
      aux.cadEstoqueMin();
      aux.cadValor();
      produtos.set(indice, aux);
    } else {
      System.out.println("\n!-----------------------------------código invalido------------------------------------!\n");
    }
    }
    
    public static void excluirProduto() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Scanner scanner = new Scanner(System.in);
    int codigo = 0, tryCatch;
    do{try{
    System.out.print("Digite o código do produto a ser excluido: ");
    codigo = scanner.nextInt();
    tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    int indice = -1;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      System.out.println("Dados anteriores:");
      aux.printProdAll();
      int opSn= 0;
      while(opSn != 1 || opSn != 2){
          do{try{
      System.out.print("Confirmar exclusão? Digite 1 para sim ou 2 para não: ");
      opSn = Integer.parseInt(scanner.nextLine());
      tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
      if (opSn == 1) {
      produtos.remove(indice);
      }
      }
    } else {
      System.out.println("\n!----------------------------------produto invalido------------------------------------!\n");
    }
    }

    public static void listarProduto() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Iterator<Produto> listForn = produtos.iterator();
    int cont = 0;
    while (listForn.hasNext()) {
      listForn.next().printProdAll();
      System.out.println("\n=--------------------------------------------------------------------------------------=");
      cont++;
    }
    System.out.println("Total de produtos:[" + cont + "].");
  }
    
    public static void listarProdutoClient() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Iterator<Produto> listForn = produtos.iterator();
    int cont = 0;
    while (listForn.hasNext()) {
      listForn.next().printProdClientPerspec();
      System.out.println("\n=--------------------------------------------------------------------------------------=\n");
      cont++;
    }
    System.out.println("\tTotal de produtos: " + cont + "");
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
  }
    
  public static boolean verificarProduto(int codigo) {
    int indice = -1;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
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
  
  public static double returnVal(int codigo) {
    int indice = -1;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
        indice = i;
        break;
      }
    }
    if (indice != -1) {
      return aux.getValor();
    } else{
        return 0;
    }
  }
  
  public int retornoPosição(int code){
      int retorno;
      retorno = produtos.indexOf(code);
     return retorno;
  }
  
  public static void subtrEstoc(int estoc, int code) {
      int backEstoque;

    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (code == aux.getProdNum()) {
          backEstoque = aux.getEstoque();
          backEstoque =backEstoque - aux.getEstoqueMin();
          if(estoc < backEstoque){
              backEstoque = backEstoque - estoc;
              aux.setEstoque(backEstoque);
          }
      }
    }
  }
  
  public static void printProdClientPerspecDAO(int codigo){
    int ref = 0;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
        aux.printProdClientPerspec();
        ref = 1;
        break;
      }
    }
    if(ref == 0){
    System.out.println("\n!----------------------------------produto invalido------------------------------------!\n");
    }
  }
  
  public static void printProdClientPerspec2DAO(int codigo){
    int ref = 0;
    Produto aux = new Produto();
    for (int i = 0; i < produtos.size(); i++) {
      aux = produtos.get(i);
      if (codigo == aux.getProdNum()) {
        aux.printProdClientPerspec2();
        ref = 1;
        break;
      }
    }
    if(ref == 0){
    System.out.println("\n!----------------------------------produto invalido------------------------------------!\n");
    }
  }
}
