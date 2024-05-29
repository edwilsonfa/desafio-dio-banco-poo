import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Conta> contas = new ArrayList<>();

        clientes.add(new Cliente("Paulo"));
        clientes.add(new Cliente("Beatriz"));
        clientes.add(new Cliente("Ana"));


        for (int i = 0; i < clientes.size(); i++) {
            if (i % 2 == 0) {
                contas.add(new ContaCorrente(new Cliente(clientes.get(i).getNome())));
                contas.get(i).depositar((i + 1) * 50);
            } else {
                contas.add(new ContaPoupanca(new Cliente(clientes.get(i).getNome())));
                contas.get(i).depositar((i + 1) * 50);
            }
        }

        contas.forEach(Conta::imprimirExtrato);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        for (int i = 0; i < contas.size(); i++) {
            if ((i + 1) < contas.size() && contas.get(i).getSaldo() > 0) {
                contas.get(i).transferir(contas.get(i).getSaldo(), contas.get(i + 1));
            }
            contas.get(i).imprimirExtrato();
        }

        System.out.println("-------------------------");
        Collections.sort(clientes);
        for (Cliente cli : clientes) {
            Predicate<Conta> buscaPeloNome = n -> n.getCliente().getNome() == cli.getNome();
            List<Conta> c = contas.stream().filter(buscaPeloNome).collect(Collectors.toList());
            for (Conta c1 : c) {
                System.out.printf("%s possui na agencia %s a conta de nº %d com saldo de %.2f %n",cli.getNome(), c1.getAgencia(), c1.getNumero(), c1.getSaldo());
            }

        }



    }
}
