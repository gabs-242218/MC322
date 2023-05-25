import java.util.*;

public abstract class Cliente {

    private String nome;
    private String endereco;
    private LinkedList<Veiculo> listaVeiculos = new LinkedList<>();
    private double valorSeguro;


    public Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
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

    public double getvalorSeguro(){
        return this.valorSeguro;
    }

    public void setValorSeguro(double valorSeguro){
        this.valorSeguro = valorSeguro;
    }


    public LinkedList<Veiculo> getListaVeiculos() {
        return this.listaVeiculos;
    }

    public void setListaVeiculos(LinkedList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public abstract double calculaScore();

    public int pega_Qnt_Veiculos(Cliente cliente){

        int qnt_veiculos = cliente.listaVeiculos.size();

        return qnt_veiculos;
    }


    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            "}";
    }
    
}

