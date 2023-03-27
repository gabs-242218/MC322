public class Seguradora {

    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    //Construtor
    public Seguradora (String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //getters e setters
    public String getNome(){
    return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
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
        "#         Seguradora         #" +"\n" +
        "##############################" + "\n" + 
        "Nome da Seguradora: " + nome+ "\n" + 
        "Telefone da Seguradora: " + telefone+ "\n" + 
        "Endereco da Seguradora: " + endereco+ "\n" + 
        "Email da Seguradora: " + email+ "\n" + 
        "##############################";
        return str;
    }
}

