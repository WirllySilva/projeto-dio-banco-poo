import java.util.ArrayList;
import java.util.List;

public class Banco {
   private String nome;
   private List<Conta> contas = new ArrayList<>();

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public List<Conta> getContas() {
      return contas;
   }

   public void setContas(List<Conta> contas) {
      this.contas = contas;
   }

   // Adiciona uma conta à lista de contas do banco
   public void adicionarConta(Conta conta) {
      this.contas.add(conta);
   }

   // Gera um relatório com os extratos de todas as contas do banco
   public void gerarRelatorio() {
      System.out.println("Relatório do Banco:");
      for (Conta conta : contas) {
         conta.imprimirExtratos();
      }
   }
}