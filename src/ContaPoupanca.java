public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.02; // Taxa de rendimento mensal

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    // Aplica o rendimento mensal à conta
    public void aplicarRendimento() {
        double rendimento = this.saldo * TAXA_RENDIMENTO;
        this.depositar(rendimento);
        this.transacoes.add(new Transacao("Rendimento", rendimento)); // Registra o rendimento como uma transação
    }

    @Override
    public void imprimirExtratos() {
        System.out.println("== Extrato Conta Poupança ==");
        super.imprimirInfoComuns();
    }
}