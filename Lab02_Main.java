public class Lab02_Main {

    public static void main (String[] args){
        // teste sinistro;
        Sinistro acidente = new Sinistro("10/12/1960", "Rua joao buarque da silva, 1275");
        System.out.println(acidente.toString());

        // teste cliente com cpf de números identicos;
        Cliente gabriel = new Cliente("Gabriel", "222.222.222-22", "23/05/1976", 30, "Avenida Santa Isabel, 1125");
        System.out.println(gabriel.toString());

        if(gabriel.validarCPF(gabriel.getCPF()) == false){
            System.out.println("Você digitou um CPF inválido.\nPor favor, defina um valor válido para o CPF do Cliente acima!\n");
        }

        //teste cliente com CPF faltando números;
        Cliente erivelton = new Cliente("Erivelton", "463.094.5-43", "30/12/2000", 23 ,"Rua das Bandeiras, 125");
        System.out.println(erivelton.toString());

        if(erivelton.validarCPF(erivelton.getCPF()) == false){
            System.out.println("Você digitou um CPF inválido.\nPor favor, defina um valor válido no formato xxx.xxx.xxx-xx para o CPF do Cliente acima!\n");
        }


        //teste cliente com cpf válido
        Cliente luisa = new Cliente("Luisa Sonza", "688.275.985-53", "03/03/2002", 20, "Rua das Campinas, 22");
        System.out.println(luisa.toString());

        if(luisa.validarCPF(luisa.getCPF()) == false){
            System.out.println("*Você digitou um CPF inválido.*\n*Por favor, defina um valor válido para o CPF do Cliente acima!*\n");
        }

        // teste seguradora
        Seguradora porto_seguro = new Seguradora("Porto Seguro", "4002-8922", "portinho@gmail.com", "Rua do porto muito seguro, 441");
        System.out.println(porto_seguro.toString());

        //teste veiculo
        Veiculo carro_jose = new Veiculo("OIO-5478", "BMW", "Corsa");
        System.out.println(carro_jose.toString());

        //Testando a alteração dos dados
        System.out.println("\nNome da Luisa: " + luisa.getNome());
        luisa.setNome("Condessa Aristóteles Martires Filomena Krivos Dracor Sadimis III");
        System.out.println("Novo nome da Luisa: " + luisa.getNome());





    }
    
}

