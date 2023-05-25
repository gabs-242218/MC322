import java.time.LocalDate;

public class Cliente_PF extends Cliente{
    final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public Cliente_PF(String nome, String endereco, String cpf,
     String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica){

        super(nome, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;

    }


    public String getCpf() {
        return this.cpf;
    }



    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return this.dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return this.educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return this.classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }





    
    
    public double calculaScore(){return 0.0;};

    public double calculaScore(Cliente cliente){

        double fator_Idade;

        int anoAtual = 2023;
        int anoNascimento = dataNascimento.getYear();

        int idadeCliente = (anoAtual - anoNascimento);

        if(18<=idadeCliente && idadeCliente < 30){
            fator_Idade = CalcSeguro.FATOR_18_30.getConstante();
        }
        else if (30<=idadeCliente && idadeCliente<60){
            fator_Idade = CalcSeguro.FATOR_30_60.getConstante();

        }
        else if (60<= idadeCliente && idadeCliente<90){
            fator_Idade = CalcSeguro.FATOR_60_90.getConstante();
        }

        else{
            System.out.println("Esse Cliente não possui uma idade válida para o calculo do Score!");
            return 0;
        }

        return (CalcSeguro.VALOR_BASE.getConstante() * fator_Idade * this.pega_Qnt_Veiculos(cliente));

    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            " endereço='" + getEndereco() + "'" +
            " cpf='" + getCpf() + "'" +
            ", genero='" + getGenero() + "'" +
            ", dataLicenca='" + getDataLicenca() + "'" +
            ", educacao='" + getEducacao() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", classeEconomica='" + getClasseEconomica() + "'" +
            "}";
    }

}


// (Cliente cliente) =new CLiebntePF()

// cliente.calculaScore();

