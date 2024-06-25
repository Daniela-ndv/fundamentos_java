package banco;

public class VerificaConta {
    public static void main(String[] args) {
        
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

    }
}
