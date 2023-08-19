/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecas;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Produto {
    private String nome, descrição, categoria;
    private int estoque, estoqueMin, devNumBack, prodNum, tryCatch;
    private double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDevNumBack() {
        return devNumBack;
    }

    public void setDevNumBack(int devNumBack) {
        this.devNumBack = devNumBack;
    }

    public int getProdNum() {
        return prodNum;
    }

    public void setProdNum(int prodNum) {
        this.prodNum = prodNum;
    }

    public Produto(String nome, String descrição, String categoria, int estoque, int estoqueMin, double valor, int prodNumb) {
        this.nome = nome;
        this.descrição = descrição;
        this.categoria = categoria;
        this.estoque = estoque;
        this.estoqueMin = estoqueMin;
        this.valor = valor;
        this.prodNum = prodNumb;
    }
    
    public Produto(String nome, String categoria, int estoque, int estoqueMin, double valor) {
        this.nome = nome;
        this.categoria = categoria;
        this.estoque = estoque;
        this.estoqueMin = estoqueMin;
        this.valor = valor;
    }  //Sem Descrição

    public Produto() {}
    
    public void cadNome(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o nome do produto: "); //Nome
        setNome(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadDescrição(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite a descrição do produto: "); //Descrição
        setDescrição(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadCategoria(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite a categoria do produto: "); //Categoria
        setCategoria(scanner.nextLine());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadEstoque(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite a quantia do estoque do produto: "); //Estoque
        setEstoque(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadEstoqueMin(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite a quantia minima do estoque do produto: "); //EstoqueMin
        setEstoqueMin(scanner.nextInt());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }
    
    public void cadValor(){
        Scanner scanner = new Scanner(System.in);
        do{try{
        System.out.print("Digite o valor do produto: "); //Valor
        setValor(scanner.nextDouble());
        tryCatch = 1;
        }catch (InputMismatchException inputMismatchException){
            System.out.println("\nOs dados que você digitou não batem com o que foi pedido.\n");
            scanner.nextLine();
            tryCatch = 0;
        }
        }while(tryCatch == 0);
    }

    public void printProdName(){
        if(getNome() == null){
        } else{
        System.out.println("Nome do produto: "+ getNome());
        }
    }
    
    public void printProdDescrip(){
        if(getDescrição() == null){
        } else{
        System.out.println("Descrição do produto: "+ getDescrição());
        }
    }
    
    public void printProdCateg(){
        if(getCategoria() == null){
        } else{
        System.out.println("Categoria: "+ getCategoria());
        }
    }
    
    public void printProdEstoc(){
        if(getEstoque() == 0){
        } else{
        System.out.println("Quantia em estoque: "+ getEstoque());
        }
    }
    
    public void printProdEstocClientPerspec(){
        int backEstoc;
        
        if(getEstoque() == 0){
        } else{
            backEstoc = getEstoque() - getEstoqueMin(); 
        System.out.println("Quantia em estoque: "+ backEstoc);
        }
    }
    
    public void printProdEstocMin(){
        if(getEstoqueMin() == 0){
        } else{
        System.out.println("Quantia minima de estoque: "+ getEstoqueMin());
        }
    }
    
    public void printProdPrice(){
        if(getValor() == 0){
        } else{
        System.out.println("Valor: R$"+ new DecimalFormat("#,##0.00").format(getValor()));
        }
    }
    
    public void printDevNumBack(){
        if(getDevNumBack() == 0){
        } else{
        System.out.println("Código do fornecedor: "+ getDevNumBack());
        }
    }
    
    public void printProdNum(){
        if(getProdNum() == 0){
        } else{
        System.out.println("Código do produto: "+ getProdNum());
        }
    }
    
    public void printProdAll(){
        System.out.println("=--------------------------------------------------------------------------------------=\n");
        printProdName();
        printProdNum();
        printProdDescrip();
        printProdCateg();
        printProdEstoc();
        printProdEstocMin();
        printProdPrice();
    }
    
    public void printProdClientPerspec(){  //Print do que aparece para clientes
        System.out.println("=--------------------------------------------------------------------------------------=\n");
        printProdName();
        printProdNum();
        printProdDescrip();
        printProdCateg();
        printProdEstocClientPerspec();
        printProdPrice();
    }
    
    public void printProdClientPerspec2(){  //Print do que aparece para clientes 2
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        printProdName();
        printProdNum();
        printProdDescrip();
        printProdCateg();
        printProdPrice();
    }
}
