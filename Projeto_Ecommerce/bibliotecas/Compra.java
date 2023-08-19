/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Compra {
    public static ArrayList<Integer> carrinho = new ArrayList<>();
    public static ArrayList<Integer> quantia = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int quant = 0, code = 0, tryCatch;
    
    public static void addCarrinho(){
        boolean retorno;
        
        ProdutoDAO.listarProdutoClient();
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        do{try{
        System.out.print("Digite o código do produto que deseja: ");
        code = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        do{try{
        System.out.print("Digite a quanto desse produto deseja: ");
        quant = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        retorno = ProdutoDAO.verificarProduto(code);
        
        if(retorno == true){
        System.out.println("\n=---------------------------------produto adicionado-----------------------------------=\n");
        ProdutoDAO.printProdClientPerspecDAO(code);
        carrinho.add(code);
        quantia.add(quant);
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        }else{
        System.out.println("\n!----------------------------------produto invalido------------------------------------!\n");
        }
    }
    
    public static void printCarrinho(){
        int i = 0;
        int car2;
        boolean retorno;
        while(i < carrinho.size()){
            car2 = carrinho.get(i);
            retorno = ProdutoDAO.verificarProduto(car2);
            if(retorno == true){
                ProdutoDAO.printProdClientPerspec2DAO(car2);
                System.out.println("\n=--------------------------------------------------------------------------------------=\n");
                System.out.println("\tQuantia: "+quantia.get(i));
                System.out.println("\n=--------------------------------------------------------------------------------------=\n");
            }
            i++;
        }
    }
    
    public static void delProdCar(){
        int backCode = 0;
        boolean retorno;
        int posição;
        
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        do{try{
        System.out.print("Digite o código do produto a ser retirado do carrinho: ");
        backCode = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        retorno = ProdutoDAO.verificarProduto(backCode);
        if(retorno == true){
            posição = carrinho.indexOf(backCode);
            carrinho.remove(posição);
            quantia.remove(posição);
            System.out.println("\n=----------------------------------produto removido------------------------------------=\n");
            printCarrinho();
        }
        else{
            System.out.println("\n!----------------------------------produto invalido------------------------------------!\n");
        }
    }
    
    public static void remoçãoEstoc(){
        int i = 0, backQuant;
        int backCode;
        boolean retorno;
        
        while(i < quantia.size()){
            backQuant = quantia.get(i);
            backCode = carrinho.get(i);
            retorno = ProdutoDAO.verificarProduto(backCode);
            if(retorno == true){
                ProdutoDAO.subtrEstoc(backQuant, backCode);
                i++;
            }
        }
    }
    
    public static double valTotal(){
        int i = 0, backQuant;
        int backCode;
        double valor, valTotal = 0;
        boolean retorno;
        
        while(i < quantia.size()){
            backQuant = quantia.get(i);
            backCode = carrinho.get(i);
            retorno = ProdutoDAO.verificarProduto(backCode);
            if(retorno == true){
                valor = ProdutoDAO.returnVal(code);
                valTotal = valTotal + (valor * backQuant);
                i++;
            }
        }
        return valTotal;
    }
    
    public static void compra(){
        Cartão card = new Cartão();
        int op = 0;
        
        System.out.println("\n=--------------------------------------------------------------------------------------=");
        System.out.println("\n\tValor total da compra: "+ new DecimalFormat("#,##0.00").format(Compra.valTotal()));
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        System.out.println("Antes de realizar a compra, é preciso informar os dados do cartão.\n");
        card.cadCardAll();
        card.printCardAll();
        do{try{
        System.out.print("Os dados estão corretos? Digite 1 para sim ou 2 para não: ");
        op = scanner.nextInt();
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
        if(op == 2){
            return;
        }
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        card.cadSenha();
        remoçãoEstoc();
        carrinho.clear();
        quantia.clear();
        System.out.print("\n=--------------------------------------------------------------------------------------=\n");
        System.out.print("\n=--------------------------Compra realizada com sucesso--------------------------------=\n");
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
    }
}
