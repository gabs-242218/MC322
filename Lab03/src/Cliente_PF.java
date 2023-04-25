import java.util.LinkedList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Cliente_PF extends Cliente{
    final String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    public Cliente_PF(String nome, String endereco,LinkedList lista_Veiculos_Cliente, String cpf,
     String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica){

        super(nome, endereco, lista_Veiculos_Cliente);
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