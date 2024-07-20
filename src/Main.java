public class Main {
    public static void main(String[] args) {
        // Criação de um cliente
        Cliente wirlly = new Cliente();
        wirlly.setNome("Wirlly Pereira da Silva");

        // Criação de contas corrente e poupança para o cliente
        ContaCorrente cc = new ContaCorrente(wirlly);
        ContaPoupanca cp = new ContaPoupanca(wirlly);

        // Realização de operações financeiras
        cc.depositar(100);
        cc.transferir(50, cp);

        // Impressão dos extratos das contas
        cc.imprimirExtratos();
        cp.imprimirExtratos();
    }
}