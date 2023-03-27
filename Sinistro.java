public class Sinistro {

    private int id;
    private String data;
    private String endereco;

    //Construtor
    public Sinistro(String data, String endereco){
        this.id = geraId();
        this.data = data;
        this.endereco = endereco;
    }

    //getters e setters
    public int getId(){
        return id;
    } 
    private int geraId(){
        double doublenumAleatorio = Math.random();
        int id = (int)(doublenumAleatorio*1_000_000);
        return id;
    }

    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String toString(){
        String str = 
        "\n" +
        "\n" +
        "##############################" +"\n" +
        "#          Sinistro          #" +"\n" +
        "##############################" + "\n" + 
        "Data do Acidente: " + data + "\n" + 
        "Endereço do Acidente: " + endereco+ "\n" + 
        "ID do Acidente: " + id + "\n" + 
        "##############################";
        return str;
    }

    
    
}

