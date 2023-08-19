/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop;

import bibliotecas.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author lucas
 */
public class IndieShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0, code = 0;
        boolean retorno;
        Scanner scanner = new Scanner(System.in);
        FornecedorDAO.novoFornIndieShop();
        ProdutoDAO.novoProdIndieShop();

        do{
        System.out.print("\n=--------------------------------------------------------------------------------------=");
        System.out.print("\n=-------------------------------------IndieShop----------------------------------------=");
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        System.out.println("\t1- Cadastro de fornecedor\n\t2- Cadastro de Cliente\n\t3- Login\n\t4- Encerrar acesso\n");
        System.out.println("=--------------------------------------------------------------------------------------=\n");
        do{try{
        System.out.print("Digite o número da opção desejada: ");
        op = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
        }
        }while(op == 0);
        switch(op){
            case 1:
                FornecedorDAO.novoFornecedor();
                System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                break;
            case 2:
                ClienteDAO.novoCliente();
                System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                break;
            case 3:
                do{
                System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                System.out.println("\t1- Login de fornecedor\n\t2- Login de cliente\n\t3- Retornar ao menu principal\n");
                do{try{
                System.out.print("Digite o número da opção desejada: ");
                op = scanner.nextInt();
                }catch (InputMismatchException inputMismatchException){
                    System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
                    scanner.nextLine();
                    op = 0;
                }
                }while(op == 0);
                switch(op){
                    case 1:
                        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                        do{try{
                        System.out.print("Digite o seu código de fornecedor: ");
                        code = scanner.nextInt();
                        }catch (InputMismatchException inputMismatchException){
                            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
                            scanner.nextLine();
                            code = 0;
                        }
                        }while(code == 0);
                        retorno = Login.compararSenhaDev(code);
                        if(retorno == true){
                            fornLoged(code);
                        }else{
                            System.out.println("\n!------------------------------código e/ou senha invalido------------------------------!\n");
                        }
                        break;
                    case 2:
                        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                        do{try{
                        System.out.print("Digite o seu código de cliente: ");
                        code = scanner.nextInt();
                        }catch (InputMismatchException inputMismatchException){
                            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
                            scanner.nextLine();
                            code = 0;
                        }
                        }while(code == 0);
                        retorno = Login.compararSenhaClient(code);
                        if(retorno == true){
                            clientLoged(code);
                        }else{
                            System.out.println("\n!------------------------------código e/ou senha invalido------------------------------!\n");
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!\n");
                        break;
                }
                }while(op != 3);
                break;
            case 4:
                System.out.println("\n=--------------------------------------------------------------------------------------=");
                System.out.println("\tObrigado por acessar a IndieShop.");
                System.out.println("=--------------------------------------------------------------------------------------=\n");
                break;
            default:
                    System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!\n");
                    break;
        }
        }while(op != 4);
    }
    
    public static void fornLoged(int code){
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        
        do{
        System.out.print("\n=--------------------------------------------------------------------------------------=");
        System.out.print("\n=----------------------------------Menu do fornecedor----------------------------------=");
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        
        System.out.println("\t1- Cadastrar produtos\n\t2- Excluir produto\n\t3- Alterar dados da conta\n\t4- Excluir conta\n\t5- Sair\n");
        do{try{
        System.out.print("Digite o número da opção desejada: ");
        op = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            op = 0;
        }
        }while(op == 0);
        
        switch(op){
            case 1:
                ProdutoDAO.novoProduto(code);
                break;
            case 2:
                ProdutoDAO.excluirProduto();
                break;
            case 3:
                FornecedorDAO.alterarFornecedor(code);
                break;
            case 4:
                FornecedorDAO.excluirFornecedor(code);
                op = 5;
                break;
            case 5:
                break;
            default:
                System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!\n");
                break;
        }
        }while(op != 5);
    }
    
    public static void clientLoged(int code){
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        
        do{
        System.out.print("\n=--------------------------------------------------------------------------------------=");
        System.out.print("\n=-----------------------------------Menu do cliente------------------------------------=");
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        
        System.out.println("\t1- Ir a loja\n\t2- Alterar dados da conta\n\t3- Excluir conta\n\t4- Sair\n");
        do{try{
        System.out.print("Digite o número da opção desejada: ");
        op = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            op = 0;
        }
        }while(op == 0);
        
        switch(op){
            case 1:
                menuCompra();
                break;
            case 2:
                ClienteDAO.alterarCliente(code);
                break;
            case 3:
                ClienteDAO.excluirCliente(code);
                op = 4;
                break;
            case 4:
                break;
            default:
                System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!\n");
                break;
        }
        }while(op != 4);
    }
    
    public static void menuCompra(){
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        
        do{
        System.out.print("\n=--------------------------------------------------------------------------------------=");
        System.out.print("\n=------------------------------------Loja IndieShop------------------------------------=");
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        
        System.out.println("\t1- Ver produtos\n\t2- Adicionar ao carrinho\n\t3- Retirar protudo do carrinho\n\t4- Exibir carrinho\n\t5- Finalizar compra\n\t6- Sair\n");
        do{try{
        System.out.print("Digite o número da opção desejada: ");
        op = scanner.nextInt();
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            op = 0;
        }
        }while(op == 0);
        
        switch(op){
            case 1:
                ProdutoDAO.listarProdutoClient();
                break;
            case 2:
                Compra.addCarrinho();
                break;
            case 3:
                Compra.delProdCar();
                break;
            case 4:
                Compra.printCarrinho();
                break;
            case 5:
                Compra.compra();
                break;
            case 6:
                break;
            default:
                System.out.println("\n!-----------------------------------Opção invalida-------------------------------------!\n");
                break;
        }
        }while(op != 6);
    }
}
