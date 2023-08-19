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
public class Login {
    
    public static boolean compararDev(){
        int code = 0, tryCatch;
        boolean retorno;
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o seu código de fornecedor: ");
        code = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        
        retorno = FornecedorDAO.verificarFornecedor(code);
        
        if(retorno == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean compararSenhaDev(int code){
        int senha = 0, tryCatch;
        boolean retorno;
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite sua senha: ");
        senha = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        
        retorno = FornecedorDAO.verificarFornSenha(code, senha);
        
        if(retorno == true){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean compararClient(){
        int code = 0, tryCatch;
        boolean retorno;
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o seu código de cliente: ");
        code = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        
        retorno = ClienteDAO.verificarCliente(code);
        
        if(retorno == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean compararSenhaClient(int code){
        int senha = 0, tryCatch;
        boolean retorno;
        
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite sua senha: ");
        senha = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        retorno = ClienteDAO.verificarClientSenha(code, senha);
        
        if(retorno == true){
            return true;
        }
        else{
            return false;
        }
    }
}
