import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class Cliente implements Comparable<Cliente>{
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }



    @Override
    public int compareTo(Cliente c) {
        return String.CASE_INSENSITIVE_ORDER.compare(nome, c.getNome());
    }
}
