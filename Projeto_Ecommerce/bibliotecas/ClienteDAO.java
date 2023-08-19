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
public class ClienteDAO {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public static void novoCliente() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Cliente client = new Cliente();
    client.cadNome();
    client.cadSenha();
    client.cadEndEntrega();
    client.cadEndCobrança();
    int clieNum = (int)(Math.random()*(999999999-100000+1)+100000);  
    client.setClientNum(clieNum);
    clientes.add(client);
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    client.printAll();
    client.printClientNum();
  }
    
    public static void alterarCliente(int codigo) {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    int indice = -1;
    Cliente aux = new Cliente();
    for (int i = 0; i < clientes.size(); i++) {
      aux = clientes.get(i);
      if (codigo == aux.getClientNum()) {
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
      aux.cadEndEntrega();
      aux.cadEndCobrança();
      clientes.set(indice, aux);
    } else {
      System.out.println("\n!-----------------------------------código invalido------------------------------------!\n");
    }
    }
    
    public static void excluirCliente(int codigo) {
        int tryCatch;
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Scanner scanner = new Scanner(System.in);
    int indice = -1;
    Cliente aux = new Cliente();
    for (int i = 0; i < clientes.size(); i++) {
      aux = clientes.get(i);
      if (codigo == aux.getClientNum()) {
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
            clientes.remove(indice);
            opSn = 2;
            break;
	case 2:
            break;
	default:
            System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!");
	}
       }while(opSn != 2);
    } else {
      System.out.println("\n!----------------------------------cliente invalido------------------------------------!\n");
    }
    }

    public static void listarCliente() {
    System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    Iterator<Cliente> listForn = clientes.iterator();
    int cont = 0;
    while (listForn.hasNext()) {
      listForn.next().printAll();
      cont++;
    }
    System.out.println("Total de clientes:[" + cont + "].");
  }
    
  public static boolean verificarCliente(int codigo) {
    int indice = -1;
    Cliente aux = new Cliente();
    for (int i = 0; i < clientes.size(); i++) {
      aux = clientes.get(i);
      if (codigo == aux.getClientNum()) {
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
  
  public static boolean verificarClientSenha(int codigo, int senha) {
    int indice = -1;
    Cliente aux = new Cliente();
    for (int i = 0; i < clientes.size(); i++) {
      aux = clientes.get(i);
      if (codigo == aux.getClientNum()) {
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
