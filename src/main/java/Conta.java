import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public void sacar(double valor){
        saldo -= valor;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino){
        sacar(valor);
        contaDestino.depositar(valor);
    }


    public abstract void imprimirExtrato();

    public void imprimirInfoComuns(){
        System.out.println(String.format("Titular: %s",this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Conta: %d",this.numero));
        System.out.println(String.format("Saldo: %.2f",this.saldo));
    }

}
