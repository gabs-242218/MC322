import java.nio.channels.ClosedByInterruptException;
import java.time.LocalDate;


import java.util.LinkedList;


public class Cliente_PJ extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;
    private int qntFuncionarios;

    public Cliente_PJ(String nome, String endereco, String cnpj, LocalDate dataFundacao){

        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }



    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }




    
    public double calculaScore(){return 0.0;};

    public double calculaScore(Cliente cliente){

        return (CalcSeguro.VALOR_BASE.getConstante() * (1+(this.qntFuncionarios)/100) * this.pega_Qnt_Veiculos(cliente));

    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", endereco='" + getEndereco() + "'" +
            " cnpj='" + getCnpj() + "'" +
            ", dataFundacao='" + getDataFundacao() + "'" +
            "}";
    }

}

