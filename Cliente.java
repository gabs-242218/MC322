public class Cliente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;


    //Construtor
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco){

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return cpf;
    }
    public void setCPF(String cpf){

        
    this.cpf = cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
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
        "#           Cliente          #" +"\n" +
        "##############################" + "\n" + 
        "Nome do Cliente: " + nome + "\n" + 
        "CPF do Cliente: " + cpf + "\n" + 
        "Data de Nascimento do Cliente: " + dataNascimento + "\n" + 
        "Idade do Cliente: " + idade + "\n" + 
        "Endereco do Cliente: " + endereco+ "\n" +
        "##############################";

        return str;
    }

    public boolean validarCPF(String cpf){ // Função que valida o CPF do Cliente;

        boolean valido = true;

        long primeiroDigitoVerif;
        long segundoDigitoVerif;

        cpf = formata_CPF(cpf);  // remove "." e "-";
            
        
        long cpfTeste = Long.parseLong(cpf);
        long cpf_Original = cpfTeste;  
        

        valido = verifica_Qnt_Digitos(cpfTeste);
        if (valido == false){
            return false;
        }

        valido = verifica_Se_Todos_Digitos_Iguais(cpfTeste);
        if(valido == false){
            return false;
        }

        cpfTeste = (cpfTeste-(cpfTeste%100))/100; // retira dígitos verificadores do CPF;

 
        primeiroDigitoVerif = pega_Digito_Verificador(cpfTeste);                //Calcula o primeiro digito verificador do CPF;
        cpfTeste = removePrimeiroDigito(cpfTeste);                              //Remove primeiro digito em preparação para o calculo do segundo digito verificador;
        cpfTeste = acrescenta_Digito_Verificador(cpfTeste, primeiroDigitoVerif);//Acrescenta digito verificador para calculo do segundo digito verificador;


        segundoDigitoVerif = pega_Digito_Verificador(cpfTeste);                 //Calcula o segundo digito verificador do CPF;
        cpfTeste = removePrimeiroDigito(cpfTeste);
        cpfTeste = acrescenta_Digito_Verificador(cpfTeste, segundoDigitoVerif);

        long digito_Verificador_Completo = primeiroDigitoVerif*10+segundoDigitoVerif;

        if(cpf_Original%100 != digito_Verificador_Completo){
            System.out.println("*Você digitou um CPF inválido.*\n*Por favor, defina um valor válido para o CPF do Cliente acima!*");
            return false;
        }

        return true;
    }

    private String formata_CPF(String cpf){
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf;
    }

    private boolean verifica_Qnt_Digitos(long cpfTeste){
        int qntDigitos = 0;

        while (cpfTeste!=0){
            cpfTeste = removeUltimoDigito(cpfTeste);
            qntDigitos += 1;
        }

        if (qntDigitos != 11){
            System.out.println("*Este CPF contem um numero errado de digitos!*");
            return false;
        }

        return true;
    }

    private boolean verifica_Se_Todos_Digitos_Iguais(long cpfTeste){
        long aux = cpfTeste;
        long ultimoDigito = aux%10;
        long penultimoDigito = (aux%100 - aux%10)/10;

        int i=11;
        while(i>0){
            if (ultimoDigito != penultimoDigito){
                aux = removeUltimoDigito(aux);
                ultimoDigito = aux%10;
                penultimoDigito = (aux%100 - aux%10);
                return true;
            }
            i--;
        }
        System.out.println("*Todos os dígitos deste CPF são iguais!*");
        return false;
    }

    private long removeUltimoDigito(long cpfTeste){
        cpfTeste = (cpfTeste-(cpfTeste%10))/10;
        return cpfTeste;
    }

    private long removePrimeiroDigito(long cpfTeste) {
        cpfTeste = cpfTeste%(100000000);
        return cpfTeste;
    }

    private long acrescenta_Digito_Verificador (long cpfTeste, long primeiroDigitoVerif){
        cpfTeste = cpfTeste*10;
        cpfTeste += primeiroDigitoVerif;
        return cpfTeste;
    }

    private long pega_Digito_Verificador(long cpfTeste){
        long digito_Verificador;
        long CPF_aux = cpfTeste;
        long soma = 0;

        for(int i = 2; i <= 10; i++){
            soma += (CPF_aux%10)*i;
            CPF_aux = removeUltimoDigito(CPF_aux);
        }

        digito_Verificador = soma%11;

        if(digito_Verificador == 0 || digito_Verificador == 1){
            digito_Verificador = 0;
        }
        else{
            digito_Verificador = 11-digito_Verificador;
        }

        return digito_Verificador;
    }    
}

