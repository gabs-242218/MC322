import java.util.*;

public class Cliente {

    private String nome;
    private String endereco;
    private LinkedList<Veiculo> listaVeiculos = new LinkedList<>();


    public Cliente(String nome, String endereco, LinkedList<Veiculo> lista_Veiculos_Cliente){
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = lista_Veiculos_Cliente;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LinkedList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(LinkedList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }



    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            "}";
    }
    
}
