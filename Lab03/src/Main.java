import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main (String[] args){

        Seguradora Porto = new Seguradora("Porto Seguro", "(11) 4003-9675", "seguros@portoseguro.com", "Av. Paulista, 1265");

        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Veiculo veiculo1 = new Veiculo("BEE 4R22", "BMW", "X1", 2015);
        Veiculo veiculo2 = new Veiculo("RTY 8C43", "FIAT", "Punto", 2022);
        Veiculo veiculo3 = new Veiculo("XZP 0A58" ,"Hyundai", "HB20", 2016 );
        Veiculo veiculo4 = new Veiculo("POI 1E67", "Chevrolet", "Onix", 2011);
        Veiculo veiculo5 = new Veiculo("TSU 7G88", "Volkswagen", "Gol", 2014);

        ArrayList <Veiculo> lista_Geral_de_Veiculos = new ArrayList<>();
        lista_Geral_de_Veiculos.add(veiculo1);
        lista_Geral_de_Veiculos.add(veiculo2);
        lista_Geral_de_Veiculos.add(veiculo3);
        lista_Geral_de_Veiculos.add(veiculo4);
        lista_Geral_de_Veiculos.add(veiculo5);

        

        for(Veiculo veiculo: lista_Geral_de_Veiculos){
            System.out.println("Oia um veiculo: " + veiculo.toString());
        }
        System.out.println("no more veiculos");


        System.out.println("******* Bem vindo ao Sistema Geral de Cadastros! *******");

        boolean continuar = true;
        while(continuar == true){
            System.out.println("O que gostaria de fazer?\n*Cadastrar Cliente\n*Remover Cliente\n*Listar todos os Clientes\n*Gerar Sinistro\n*Visualizar Sinistro\n*Listar todos os Sinistros\n*Sair");
            
            Scanner entrada = new Scanner(System.in);
            String acao = entrada.nextLine();

            switch (acao) {

                case "Sair":
                    continuar = false;
                    break;


                case "Cadastrar Cliente":

                    LinkedList<Veiculo> listaCarros_Cliente = new LinkedList<>();

                    System.out.println("Digite o tipo de Cliente (PF ou PJ):\n");
                    String tipo_de_Cliente = entrada.nextLine();
                    System.out.println("Digite o nome do Cliente:\n");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o endereco do Cliente:\n");
                    String endereco = entrada.nextLine();
                    System.out.println("Digite quantos carros o Cliente tem:\n");
                    int n_carros = entrada.nextInt();
                    entrada.nextLine();

                    for(int i = 0; i < n_carros; i++){
                        System.out.println("Digite a placa do veiculo a ser adicionado neste Cliente:\n");
                        String placa = entrada.nextLine();

                        for(Veiculo veiculo: lista_Geral_de_Veiculos){

                            if(veiculo.getPlaca().equals(placa)){
                                listaCarros_Cliente.add(veiculo);
                                System.out.println("Veiculo adicionado!\n");
                                break;
                            }
                            // System.out.println(("O Veiculo da placa " + placa + " não existe na nossa base de dados!\n"));  
                            //adicionar break especifico para interromper o cadastro do cliente
                            // break;
                             
                        }
                        
                    }

                    if(tipo_de_Cliente.equals("PF")){

                        System.out.println("Digite o CPF do Cliente:\n");
                        String cpf = entrada.nextLine();
                        System.out.println("Digite o Genero do Cliente:\n");
                        String genero = entrada.nextLine();
                        System.out.println("Digite a data da Licença:\n");
                        String data_licenca = entrada.nextLine();
                        LocalDate data_licenca_formatada = LocalDate.parse(data_licenca, date_format);
                        System.out.println("Digite o nivel de escolaridade do Cliente:\n");
                        String escolaridade = entrada.nextLine();
                        System.out.println("Digite a data de Nascimento:\n");
                        String data_nascimento = entrada.nextLine();
                        LocalDate data_nascimento_formatada = LocalDate.parse(data_nascimento, date_format);
                        System.out.println("Digite a Classe Economica do Cliente:\n");
                        String classe_economica = entrada.nextLine();

                        Cliente_PF cliente_pf = new Cliente_PF(nome, endereco, listaCarros_Cliente, cpf, genero, data_licenca_formatada, escolaridade, data_nascimento_formatada, classe_economica);
                        
                        Porto.cadastrarCliente(cliente_pf);
                    }
                    
                    else if(tipo_de_Cliente.equals("PJ")){

                        System.out.println("Digite o CNPJ da Empresa:\n");
                        String cnpj = entrada.nextLine();
                        System.out.println("Digite a data de Fundação da Empresa:\n");
                        String data_fundac = entrada.nextLine();
                        LocalDate data_fundacao_formatada = LocalDate.parse(data_fundac,date_format);

                        Cliente_PJ cliente_pj = new Cliente_PJ(nome, endereco, listaCarros_Cliente, cnpj, data_fundacao_formatada);

                        Porto.cadastrarCliente(cliente_pj);
                        // System.out.println("\n Dados do Cliente PJ cadastrado: \n\n " + cliente_pj.toString());
                        // Porto.listarClientes("PJ");
                    }

                    break;
                
                case "Remover Cliente":
                    System.out.println("Digite o nome do Cliente ou Empresa a ser removido:\n");
                    String nome_cliente = entrada.nextLine();

                    Porto.removerCliente(nome_cliente);
                    break;

                case "Listar todos os Clientes":
                    System.out.println("Digite o tipo de Cliente a ser listado (PF ou PJ):\n");
                    String tipo = entrada.nextLine();

                    Porto.listarClientes(tipo);
                    break;
                
                case "Gerar Sinistro":

                    
                    System.out.println("Digite a data do Sinistro: \n");
                    String data_sinistro = entrada.nextLine();
                    LocalDate Data_Sinistro_formatada = LocalDate.parse(data_sinistro, date_format);
                    System.out.println("Digite o endereço no qual o Sinistro aconteceu: \n");
                    String endereco_sinistro = entrada.nextLine();
                    System.out.println("Digite a placa do veiculo: \n");
                    String placa_sinistro = entrada.nextLine();

                    System.out.println("Digite o nome do Cliente: \n");
                    String nome_sinistro = entrada.nextLine();

                    Cliente cliente_sinistro = Porto.procura_e_adiciona_cliente(nome_sinistro);

                    if(cliente_sinistro.getNome() == null){
                        break;
                    }

                    for(Veiculo veiculo : lista_Geral_de_Veiculos){
                        if(veiculo.getPlaca().equals(placa_sinistro)){
                            Veiculo veiculo_sinistro = new Veiculo(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
                            Sinistro novo_Sinistro = new Sinistro(data_sinistro, endereco_sinistro, Porto, veiculo_sinistro, cliente_sinistro);
                            Porto.adiciona_Sinistro(novo_Sinistro);
                        }

                    }

                    break;

                case "Visualizar Sinistro":
                    System.out.println("Digite o nome do Cliente com o qual aconteceu o Acidente:\n");
                    String nome_Cliente = entrada.nextLine();
                    Porto.visualizarSinistro(nome_Cliente);
                    break;
                
                case "Listar todos os Sinistros":

                    Porto.lista_todos_Sinistros();
                    
                    break;
                    
            
                default:
                    break;
            }
        
        
        }
        System.out.println("Programa finalizado!");
    }
}
