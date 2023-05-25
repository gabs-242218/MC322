import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public class Main {

    static DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static ArrayList <Veiculo> lista_Geral_de_Veiculos = new ArrayList<>();
    static ArrayList <Seguradora> lista_Seguradoras = new ArrayList<>();
    static Seguradora Porto = new Seguradora("Porto Seguro", "(11) 4003-9675", "seguros@portoseguro.com", "Av. Paulista, 1265");

    public static void instancia_tudo(){

        
        lista_Seguradoras.add(Porto);
        


        Veiculo veiculo1 = new Veiculo("BEE 4R22", "BMW", "X1", 2015);
        Veiculo veiculo2 = new Veiculo("RTY 8C43", "FIAT", "Punto", 2022);
        Veiculo veiculo3 = new Veiculo("XZP 0A58" ,"Hyundai", "HB20", 2016 );
        Veiculo veiculo4 = new Veiculo("POI 1E67", "Chevrolet", "Onix", 2011);
        Veiculo veiculo5 = new Veiculo("TSU 7G88", "Volkswagen", "Gol", 2014);

        
        lista_Geral_de_Veiculos.add(veiculo1);
        lista_Geral_de_Veiculos.add(veiculo2);
        lista_Geral_de_Veiculos.add(veiculo3);
        lista_Geral_de_Veiculos.add(veiculo4);
        lista_Geral_de_Veiculos.add(veiculo5);

        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo1);
        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo2);
        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo3);
        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo4);
        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo5);

        // String data1 = "12/02/2002";
        // LocalDate data1_formatada = LocalDate.parse(data1);
        // String data2 = "18/06/2005";
        // LocalDate data2_formatada = LocalDate.parse(data2);
        // String data3 = "08/02/1896";
        // LocalDate data3_formatada = LocalDate.parse(data3);



        // Cliente_PF gabriel = new Cliente_PF("gabriel gomes", "Av. um", "507054598-10", "Masculino", data1_formatada, "ensino medio completo", data2_formatada, "pobre");

        // Cliente_PJ Coca = new Cliente_PJ("Coca-cola", "Av. Refrigerante", "12345678/0001-95", data3_formatada);



    }

    public static void cadastrarCliente(){

        Scanner entrada = new Scanner(System.in);


                    System.out.println("Digite o tipo de Cliente (PF ou PJ):\n");
                    String tipo_de_Cliente = entrada.nextLine();
                    System.out.println("Digite o nome do Cliente:\n");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o endereco do Cliente:\n");
                    String endereco = entrada.nextLine();
                    // System.out.println("Digite quantos carros o Cliente tem:\n");
                    // int n_carros = entrada.nextInt();
                    // entrada.nextLine();

                    // for(int i = 0; i < n_carros; i++){
                    //     System.out.println("Digite a placa do veiculo a ser adicionado neste Cliente:\n");
                    //     String placa = entrada.nextLine();

                    //     for(Veiculo veiculo: lista_Geral_de_Veiculos){

                    //         if(veiculo.getPlaca().equals(placa)){
                    //             cliente.listaVeiculos.add(veiculo);
                    //             System.out.println("Veiculo adicionado!\n");
                    //             break;
                    //         }
                    //         // System.out.println(("O Veiculo da placa " + placa + " não existe na nossa base de dados!\n"));  
                    //         //adicionar break especifico para interromper o cadastro do cliente
                    //         // break;
                             
                    //     }
                        
                    // }

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

                        Cliente_PF cliente_pf = new Cliente_PF(nome, endereco, cpf, genero, data_licenca_formatada, escolaridade, data_nascimento_formatada, classe_economica);

                        /*
                         * Adicionar aqui a parte comentada em cima de codigo que pede a quantidade de veiculos, pergunta se os veiculos do cliente já estão cadastrados no sistema, se não, cadastra
                         * veiculo e adiciona na lista de veiculos do cliente que ja foii criado usando a lista que ja existe na classe cliente                         * 
                         */
                        
                        Porto.cadastrarCliente(cliente_pf);
                    }
                    
                    else if(tipo_de_Cliente.equals("PJ")){

                        System.out.println("Digite o CNPJ da Empresa:\n");
                        String cnpj = entrada.nextLine();
                        System.out.println("Digite a data de Fundação da Empresa:\n");
                        String data_fundac = entrada.nextLine();
                        LocalDate data_fundacao_formatada = LocalDate.parse(data_fundac,date_format);

                        Cliente_PJ cliente_pj = new Cliente_PJ(nome, endereco, cnpj, data_fundacao_formatada);

                        Porto.cadastrarCliente(cliente_pj);
                        // System.out.println("\n Dados do Cliente PJ cadastrado: \n\n " + cliente_pj.toString());
                        // Porto.listarClientes("PJ");
                    }

 



    }

    public static void cadastrarVeiculo(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a placa do Veiculo: ");
        String placa = entrada.nextLine();

        System.out.println("Digite a marca do Veiculo: ");
        String marca = entrada.nextLine();

        System.out.println("Digite o Modelo do Veiculo: ");
        String modelo = entrada.nextLine();

        System.out.println("Digite o Ano de Fabricação do Veiculo: ");
        int ano = entrada.nextInt();
        entrada.nextLine();

        Veiculo veiculo_cadastrado = new Veiculo(placa, marca, modelo, ano);
        Porto.lista_Geral_de_Veiculos_seguradora.add(veiculo_cadastrado);
    }

    public static void listarClientes(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Listar clientes do tipo PF ou PJ?");
        String tipo = entrada.nextLine();
        Porto.listarClientes(tipo);
    }

    public static void listarSinistros(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o CPF ou CNPJ do Cliente: ");

        String documento = entrada.nextLine();

        Porto.listarSinistros_Cliente(Porto.acha_Cliente(documento));

        
    }

    public static void listarVeiculos(){

        

        System.out.println("Gostaria de:\n0 - Listar veiculos da seguradora\n1 - Listar veiculos de um Cliente");
        Scanner entrada = new Scanner(System.in);

        int opcao = entrada.nextInt();
        entrada.nextLine();

        switch (opcao) {
            case 0:

            for(Veiculo veiculo : Porto.lista_Geral_de_Veiculos_seguradora){
                System.out.println(veiculo.toString());
            }
                
                break;
            case 1:

            System.out.println("Digite o CPF ou CNPJ do Cliente: ");

            String documento = entrada.nextLine();

            Porto.listarVeiculos(Porto.acha_Cliente(documento));
                break;


            default:
                break;
        }



        

    }

    public static void excluirSinistro(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o ID do sinistro: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        Porto.excluirSinistro(id);

    }

    public static void gerarSinistro(){

        Porto.gerarSinistro();
    }

    public static void excluirVeiculo(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a placa do veiculo a ser removido: ");

        String placa = entrada.nextLine();
        Porto.excluirVeiculo(placa);
    }


    public static void excluirCliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o CPF ou CNPJ do Cliente: ");

        String documento = entrada.nextLine();

        Porto.removerCliente(documento);

    }
    public static void calcularReceita(){
        double receita = Porto.calcularReceita();

        System.out.println("A Receita da Seguradora é " + receita);
    }

    public static void cadastrarSeguradora(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome da Seguradora: ");
        String nome = entrada.nextLine();
        System.out.println("Digite o telefone da Seguradora: ");
        String telefone = entrada.nextLine();
        System.out.println("Digite o email da Seguradora: ");
        String email = entrada.nextLine();
        System.out.println("Digite o endereço da Seguradora: ");
        String endereco = entrada.nextLine();
        Seguradora nova_seguradora = new Seguradora(nome, telefone, email, endereco);
        lista_Seguradoras.add(nova_seguradora);
    }

    public static void transfereVeiculo(){

    }


    public static void transferirSeguro(){
        Scanner entrada = new Scanner(System.in);
        String documento_cliente_remetente;
        String documento_cliente_destinatario;

        System.out.println("Digite o documento do qual o Seguro será transferido: ");
        documento_cliente_remetente = entrada.nextLine();
        System.out.println("Digite o documento para o qual o Seguro será transferido: ");
        documento_cliente_destinatario = entrada.nextLine();

        Cliente cliente_remetente = Porto.acha_Cliente(documento_cliente_remetente);
        Cliente cliente_destinatario = Porto.acha_Cliente(documento_cliente_destinatario);

        Porto.transfereVeiculo(cliente_remetente, cliente_destinatario);
    }

    //exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOpcoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				gerarSinistro();
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;
			case CALCULAR_RECEITA:
				calcularReceita();
				break;
			//case SAIR:
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
            cadastrarCliente();
			break;
		case CADASTRAR_VEICULO:
			cadastrarVeiculo();
			break;
		case CADASTRAR_SEGURADORA:
			cadastrarSeguradora();
			break;
		case LISTAR_CLIENTES:
			listarClientes();
			break;
		case LISTAR_SINISTROS:
			listarSinistros();
			break;
		case LISTAR_VEICULOS:
			listarVeiculos();
			break;
		case EXCLUIR_CLIENTE:
			excluirCliente();
			break;
		case EXCLUIR_VEICULO:
			excluirVeiculo();
			break;
		case EXCLUIR_SINISTRO:
			excluirSinistro();
			break;
		//case VOLTAR:
		//	break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
	

    public static void main (String[] args){

        instancia_tudo();

        	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
		MenuOpcoes op;

		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
    }
}
	



    //     System.out.println("******* Bem vindo ao Sistema Geral de Cadastros! *******");

    //     boolean continuar = true;
    //     while(continuar == true){
    //         System.out.println("O que gostaria de fazer?\n*Cadastrar Cliente\n*Remover Cliente\n*Listar todos os Clientes\n*Gerar Sinistro\n*Visualizar Sinistro\n*Listar todos os Sinistros\n*Sair");
            
    //         Scanner entrada = new Scanner(System.in);
    //         String acao = entrada.nextLine();

    //         switch (acao) {

    //             case "Sair":
    //     System.out.println("******* Bem vindo ao Sistema Geral de Cadastros! *******");

    //     boolean continuar = true;
    //     while(continuar == true){
    //         System.out.println("O que gostaria de fazer?\n*Cadastrar Cliente\n*Remover Cliente\n*Listar todos os Clientes\n*Gerar Sinistro\n*Visualizar Sinistro\n*Listar todos os Sinistros\n*Sair");
            
    //         Scanner entrada = new Scanner(System.in);
    //         String acao = entrada.nextLine();

    //         switch (acao) {

    //             case "Sair":
    //                 continuar = false;
    //                 entrada.close();
    //                 break;


    //             case "Cadastrar Cliente":

    //                 
                
    //             case "Remover Cliente":
    //                 System.out.println("Digite o nome do Cliente ou Empresa a ser removido:\n");
    //                 String nome_cliente = entrada.nextLine();

    //                 Porto.removerCliente(nome_cliente);
    //                 break;

    //             case "Listar todos os Clientes":
    //                 System.out.println("Digite o tipo de Cliente a ser listado (PF ou PJ):\n");
    //                 String tipo = entrada.nextLine();

    //                 Porto.listarClientes(tipo);
    //                 break;
                
    //             case "Gerar Sinistro":

    //                 gerarSinistro();

    //                 break;

    //             case "Visualizar Sinistro":
    //                 System.out.println("Digite o nome do Cliente com o qual aconteceu o Acidente:\n");
    //                 String nome_Cliente = entrada.nextLine();
    //                 Porto.visualizarSinistro(nome_Cliente);
    //                 break;
                
    //             case "Listar todos os Sinistros":

    //                 Porto.lista_todos_Sinistros();
                    
    //                 break;
                    
            
    //             default:
    //                 break;
    //         }
        
        
    //     }
    //     System.out.println("Programa finalizado!");
    // }
    //                     String genero = entrada.nextLine();
    //                     System.out.println("Digite a data da Licença:\n");
    //                     String data_licenca = entrada.nextLine();
    //                     LocalDate data_licenca_formatada = LocalDate.parse(data_licenca, date_format);
    //                     System.out.println("Digite o nivel de escolaridade do Cliente:\n");
    //                     String escolaridade = entrada.nextLine();
    //                     System.out.println("Digite a data de Nascimento:\n");
    //                     String data_nascimento = entrada.nextLine();
    //                     LocalDate data_nascimento_formatada = LocalDate.parse(data_nascimento, date_format);
    //                     System.out.println("Digite a Classe Economica do Cliente:\n");
    //                     String classe_economica = entrada.nextLine();

    //                     Cliente_PF cliente_pf = new Cliente_PF(nome, endereco, listaCarros_Cliente, cpf, genero, data_licenca_formatada, escolaridade, data_nascimento_formatada, classe_economica);
                        
    //                     Porto.cadastrarCliente(cliente_pf);
    //                 }
                    
    //                 else if(tipo_de_Cliente.equals("PJ")){

    //                     System.out.println("Digite o CNPJ da Empresa:\n");
    //                     String cnpj = entrada.nextLine();
    //                     System.out.println("Digite a data de Fundação da Empresa:\n");
    //                     String data_fundac = entrada.nextLine();
    //                     LocalDate data_fundacao_formatada = LocalDate.parse(data_fundac,date_format);

    //                     Cliente_PJ cliente_pj = new Cliente_PJ(nome, endereco, listaCarros_Cliente, cnpj, data_fundacao_formatada);

    //                     Porto.cadastrarCliente(cliente_pj);
    //                     // System.out.println("\n Dados do Cliente PJ cadastrado: \n\n " + cliente_pj.toString());
    //                     // Porto.listarClientes("PJ");
    //                 }

    //                 break;
                
    //             case "Remover Cliente":
    //                 System.out.println("Digite o nome do Cliente ou Empresa a ser removido:\n");
    //                 String nome_cliente = entrada.nextLine();

    //                 Porto.removerCliente(nome_cliente);
    //                 break;

    //             case "Listar todos os Clientes":
    //                 System.out.println("Digite o tipo de Cliente a ser listado (PF ou PJ):\n");
    //                 String tipo = entrada.nextLine();

    //                 Porto.listarClientes(tipo);
    //                 break;
                
    //             case "Gerar Sinistro":

    //                 Porto.gerarSinistro();

    //                 break;

    //             case "Visualizar Sinistro":
    //                 System.out.println("Digite o nome do Cliente com o qual aconteceu o Acidente:\n");
    //                 String nome_Cliente = entrada.nextLine();
    //                 Porto.visualizarSinistro(nome_Cliente);
    //                 break;
                
    //             case "Listar todos os Sinistros":

    //                 Porto.lista_todos_Sinistros();
                    
    //                 break;
                    
            
    //             default:
    //                 break;
    //         }
        
        
    //     }
    //     System.out.println("Programa finalizado!");
    // }

