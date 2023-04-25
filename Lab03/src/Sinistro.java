public class Sinistro {
    final int ID;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.ID = geraId();
    }

    private int geraId(){
        double doublenumAleatorio = Math.random();
        int id = (int)(doublenumAleatorio*1_000_000);
        return id;
    }

    public int getID(){
        return this.ID;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    


    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", data='" + getData() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", seguradora='" + getSeguradora() + "'" +
            ", veiculo='" + getVeiculo() + "'" +
            ", cliente='" + getCliente() + "'" +
            "}";
    }
    

}