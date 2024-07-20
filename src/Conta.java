import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static int SEQUENCIAL = 1;
    private static final int AGENCIA_PADRAO = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>(); // Inicializa a lista de transações
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
        this.transacoes.add(new Transacao("Saque", -valor)); // Registra a transação
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.transacoes.add(new Transacao("Depósito", valor)); // Registra a transação
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        this.transacoes.add(new Transacao("Transferência para conta " + contaDestino.getNumero(), -valor)); // Registra a transferência
        contaDestino.transacoes.add(new Transacao("Transferência recebida da conta " + this.getNumero(), valor)); // Registra a transferência na conta destino
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(String.format("%s - %s: %.2f", transacao.getData(), transacao.getDescricao(), transacao.getValor()));
        }
    }
}
