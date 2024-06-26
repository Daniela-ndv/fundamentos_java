package banco;

public class Teste {
    public static void main(String[] args) {
        
        /*
        //Conta corrente
        Conta cc = new Conta();

        cc.setAgencia(123);
        cc.setNumero(1);
        cc.depositar(50);

        System.out.println("##### Conta corrente #####");
        System.out.println("Agência: " + cc.getAgencia() + "\nNúmero cc: " + cc.getNumero());
        System.out.println("Saldo atual: R$"+ cc.getSaldo() + "\n");

        cc.depositar(500.0);
        System.out.println("Depósito de R$ 500,00 realizado. \nSaldo atual: R$"+ cc.getSaldo() + "\n");

        cc.sacar(1000);
        System.out.println("Saque de R$1000,00 realizado. \nSaldo atual: R$"+ cc.getSaldo()+ "\n");


        //Conta poupança
        Conta poupanca = new Conta(456, 2, 1000.50);

        System.out.println("##### Conta poupuança #####");
        System.out.println("Agência: " + poupanca.getAgencia() + "\nNúmero poupança: " + poupanca.getNumero());
        System.out.println("Saldo atual: R$"+ poupanca.getSaldo() + "\n");

        poupanca.sacar(50);
        System.out.println("Saque de R$50,00 realizado. \nSaldo atual: R$"+ poupanca.getSaldo()+ "\n");
        */


        //ContaCorrente cc = new ContaCorrente();
        // // Objetos da superclasse
        // cc.setAgencia(222);
        // cc.setNumero(3);
        // // Objetos da subclasse
        // cc.setTipo("PF");
        // cc.setChequeEspecial(1000);


        /*
        Conta conta = new Conta(); // Objeto da superclasse
        Conta cc = new ContaCorrente(); // Obsejo da subclasse, e variáveis da superclasse

        // Casting: conversão de objetos ou tipos primitivos de um tipo para outro tipo dentro da hierarquia de classe
        ContaCorrente c1 = (ContaCorrente) cc; // Down Castins
        
        // Verifica se a variável é uma instância do objeto esperado
        if (conta instanceof ContaCorrente) {
            ContaCorrente c2 = (ContaCorrente) conta;
        }
        */


        Conta conta1 = new Conta();
        conta1.depositar(1000);
        conta1.sacar(100);

        ContaCorrente conta2 = new ContaCorrente();
        conta2.depositar(1000);
        conta2.sacar(100);

        Conta conta3 = new ContaCorrente();
        conta3.depositar(1000);
        conta3.sacar(100);
        
        System.out.println("Conta1: " + conta1.getSaldo());  // Utiliza o método da superclasse      
        System.out.println("Conta2: " + conta2.getSaldo());        
        System.out.println("Conta3: " + conta3.getSaldo());        

    }
}
