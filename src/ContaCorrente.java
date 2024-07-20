public class ContaCorrente extends Conta {
    private static final double TAXA_SERVICO = 0.10; // Taxa de serviço para saques

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor + TAXA_SERVICO); // Aplica a taxa de serviço ao sacar
    }

    @Override
    public void imprimirExtratos() {
        System.out.println("== Extrato Conta Corrente ==");
        super.imprimirInfoComuns();
    }
}

