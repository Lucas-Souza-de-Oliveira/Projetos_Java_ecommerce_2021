/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecas;


/**
 *
 * @author lucas
 */
public class Cliente extends Usuario{
    private int clientNum;
    Endereço endEntrega = new Endereço();
    Endereço endCobrança = new Endereço();

    public int getClientNum() {
        return clientNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public Cliente(String nome, int senha) {
        super(nome, senha);
    }
    
    public Cliente() {}
    
    public void cadEndEntrega(){  //Endereço entrega
        System.out.println("\n=---------------------------------Endereço de entrega----------------------------------=\n");
        endEntrega.cadScanEndereço();
        endEntrega.cadScanComplemento();
        endEntrega.cadScanCEP();
    }
    
    public void cadEndCobrança(){  //Endereço cobrança
        System.out.println("\n=--------------------------------Endereço de cobrança----------------------------------=\n");
        endCobrança.cadScanEndereço();
        endCobrança.cadScanComplemento();
        endCobrança.cadScanCEP();
    }
    
    public void printClientNum(){
        if(getClientNum() == 0){
        } else{
        System.out.println("\n=--------------------------------------------------------------------------------------=\n");
        System.out.println("Seu código de cliente é: "+ getClientNum());
        }
    }
    
    public void printEndEntrega(){  //Endereço entrega
        System.out.println("\n=---------------------------------Endereço de entrega----------------------------------=\n");
        endEntrega.printEndereço();
        endEntrega.printComplemento();
        endEntrega.printCEP();
    }
    
    public void printEndCobrança(){  //Endereço cobrança
        System.out.println("\n=--------------------------------Endereço de cobrança----------------------------------=\n");
        endCobrança.printEndereço();
        endCobrança.printComplemento();
        endCobrança.printCEP();
    }
    
    @Override
    public void printAll(){   //Ajeitar
        printUserName();
        printEndEntrega();
        printEndCobrança();
    }
}
