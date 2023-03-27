public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;

    //Construtor
    public Veiculo(String placa, String marca, String modelo){

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    //getters e setters
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getmodelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String toString(){
        String str =
        "\n" +
        "\n" +
        "##############################" +"\n" +
        "#           Veiculo          #" +"\n" +
        "##############################"+"\n" + 
        "Placa do Veiculo: " + placa + "\n" + 
        "Modelo do Veiculo: " + modelo + "\n"+
        "Marca do Veiculo: "+ marca + "\n"+
        "##############################";
        return str;
    }
}

