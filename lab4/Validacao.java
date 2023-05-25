public abstract class Validacao{

    public static boolean validarCNPJ(String cnpj){ // Função que valida o cnpj do Cliente;

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

    private static String formata_CNPJ(String cnpj){
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");
        return cnpj;
    }

    private static boolean verifica_Qnt_Digitos_cnpj(long cnpjTeste){
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

    private static boolean verifica_Se_Todos_Digitos_Iguais_cnpj(long cnpjTeste){
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

    private static long removeUltimoDigito_cnpj(long cnpjTeste){
        cnpjTeste = (cnpjTeste-(cnpjTeste%10))/10;
        return cnpjTeste;
    }

    private static long acrescenta_Digito_Verificador_cnpj (long cnpjTeste, long primeiroDigitoVerif){
        cnpjTeste = cnpjTeste*10;
        cnpjTeste += primeiroDigitoVerif;
        return cnpjTeste;
    }

    private static long pega_Digito_Verificador_cnpj(long cnpjTeste){
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


    public static boolean validarCPF(String cpf){ // Função que valida o CPF do Cliente;

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

    private static String formata_CPF(String cpf){
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        return cpf;
    }

    private static boolean verifica_Qnt_Digitos(long cpfTeste){
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

    private static boolean verifica_Se_Todos_Digitos_Iguais(long cpfTeste){
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

    private static long removeUltimoDigito(long cpfTeste){
        cpfTeste = (cpfTeste-(cpfTeste%10))/10;
        return cpfTeste;
    }

    private static long removePrimeiroDigito(long cpfTeste) {
        cpfTeste = cpfTeste%(100000000);
        return cpfTeste;
    }

    private static long acrescenta_Digito_Verificador (long cpfTeste, long primeiroDigitoVerif){
        cpfTeste = cpfTeste*10;
        cpfTeste += primeiroDigitoVerif;
        return cpfTeste;
    }

    private static long pega_Digito_Verificador(long cpfTeste){
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