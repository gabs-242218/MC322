import java.time.LocalDate;


import java.util.LinkedList;


public class Cliente_PJ extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;

    public Cliente_PJ(String nome, String endereco,LinkedList<Veiculo> lista_Veiculos_Cliente, String cnpj, LocalDate dataFundacao){

        super(nome, endereco,lista_Veiculos_Cliente);
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



    public boolean validarCNPJ(String cnpj){ // Função que valida o cnpj do Cliente;

        boolean valido = true;

        long primeiroDigitoVerif;
        long segundoDigitoVerif;

        cnpj = formata_CNPJ(cnpj);  // remove "." e "-";
            
        
        long cnpjTeste = Long.parseLong(cnpj);
        long cnpj_Original = cnpjTeste;  
        

        valido = verifica_Qnt_Digitos(cnpjTeste);
        if (valido == false){
            return false;
        }

        valido = verifica_Se_Todos_Digitos_Iguais(cnpjTeste);
        if(valido == false){
            return false;
        }

        cnpjTeste = (cnpjTeste-(cnpjTeste%100))/100; // retira dígitos verificadores do cnpj;

 
        primeiroDigitoVerif = pega_Digito_Verificador(cnpjTeste);                //Calcula o primeiro digito verificador do cnpj;
       
        cnpjTeste = acrescenta_Digito_Verificador(cnpjTeste, primeiroDigitoVerif);//Acrescenta digito verificador para calculo do segundo digito verificador;

        segundoDigitoVerif = pega_Digito_Verificador(cnpjTeste);                 //Calcula o segundo digito verificador do cnpj;

        cnpjTeste = acrescenta_Digito_Verificador(cnpjTeste, segundoDigitoVerif);



        long digito_Verificador_Completo = primeiroDigitoVerif*10+segundoDigitoVerif;


        if(cnpj_Original%100 != digito_Verificador_Completo){
            System.out.println("*Você digitou um cnpj inválido.*\n*Por favor, defina um valor válido para o cnpj do Cliente acima!*");
            return false;
        }

        return true;
    }

    private String formata_CNPJ(String cnpj){
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");
        return cnpj;
    }

    private boolean verifica_Qnt_Digitos(long cnpjTeste){
        int qntDigitos = 0;

        while (cnpjTeste!=0){
            cnpjTeste = removeUltimoDigito(cnpjTeste);
            qntDigitos += 1;
        }

        if (qntDigitos != 14){
            System.out.println("*Este cnpj contem um numero errado de digitos!*");
            return false;
        }

        return true;
    }

    private boolean verifica_Se_Todos_Digitos_Iguais(long cnpjTeste){
        long aux = cnpjTeste;
        long ultimoDigito = aux%10;
        long penultimoDigito = (aux%100 - aux%10)/10;

        int i=14;
        while(i>0){
            if (ultimoDigito != penultimoDigito){
                aux = removeUltimoDigito(aux);
                ultimoDigito = aux%10;
                penultimoDigito = (aux%100 - aux%10);
                return true;
            }
            i--;
        }
        System.out.println("*Todos os dígitos deste cnpj são iguais!*");
        return false;
    }

    private long removeUltimoDigito(long cnpjTeste){
        cnpjTeste = (cnpjTeste-(cnpjTeste%10))/10;
        return cnpjTeste;
    }

    private long acrescenta_Digito_Verificador (long cnpjTeste, long primeiroDigitoVerif){
        cnpjTeste = cnpjTeste*10;
        cnpjTeste += primeiroDigitoVerif;
        return cnpjTeste;
    }

    private long pega_Digito_Verificador(long cnpjTeste){
        long digito_Verificador;
        long cnpj_aux = cnpjTeste;
        long soma = 0;

        int i=9;
        while(cnpj_aux != 0){

            

            if (i == 1){
                i = 9;
            }

            soma += (cnpj_aux%10)*i;
            cnpj_aux = removeUltimoDigito(cnpj_aux);
            i--;
        }

        digito_Verificador = soma%11;

        if(digito_Verificador == 10 || digito_Verificador == 11){
            digito_Verificador = 0;
        }

        return digito_Verificador;
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