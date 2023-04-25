import java.util.*;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private static LinkedList<Sinistro> listaSinistros = new LinkedList<>();
    private static LinkedList<Cliente> listaClientes = new LinkedList<>();
    ArrayList <Veiculo> lista_Geral_de_Veiculos_seguradora = new ArrayList<>();

    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }



    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean cadastrarCliente(Cliente cliente){

        if(cliente instanceof Cliente_PF){

            if(((Cliente_PF)cliente).validarCPF(((Cliente_PF)cliente).getCpf()) == true){
                listaClientes.add(cliente);
                System.out.println("Cliente adicionado com sucesso");
                return true;
    
            }
            
            System.out.println("CPF do cliente inválido, por favor, tente novamente.");
            return false; 
        }

        else if(cliente instanceof Cliente_PJ){

            if(((Cliente_PJ)cliente).validarCNPJ(((Cliente_PJ)cliente).getCnpj()) == true){
                listaClientes.add(cliente);
                System.out.println("Empresa adicionada com sucesso.");
                return true;
            }
    
            System.out.println("CNPJ da empresa inválido, por favor, tente novamente");
    
            return false;
        }
        return false;
    }



    public boolean removerCliente( String nome_cliente){

        for(Cliente cliente: listaClientes){
            if(cliente.getNome().equals(nome_cliente) == true){

                if(cliente instanceof Cliente_PF){

                    listaClientes.remove(listaClientes.indexOf(cliente));
                    System.out.println("Cliente removido com sucesso!");
                    return true;
                    
                }
        
                else if(cliente instanceof Cliente_PJ){
        
                    listaClientes.remove(listaClientes.indexOf(cliente));
                    System.out.println("Empresa removida com sucesso!");
                    return true;
                
                }
            }
        }

        System.out.println("Cliente ou Empresa não encontrado!");
        return false;
    }


    public void listarClientes(String tipo){

        switch (tipo) {
            case "PJ":

                for(Cliente cliente: listaClientes){

                    if(cliente instanceof Cliente_PJ){
                        System.out.println(((Cliente_PJ)cliente).toString());
                        System.out.println("*****");
                    }
                }
                
                break;
        

            case "PF":

                for(Cliente cliente: listaClientes){

                    if(cliente instanceof Cliente_PF){
                        System.out.println(cliente.toString());
                        System.out.println("*****");
                    }
                }


                break;

            default:
                break;
        }
    }

    public void gerarSinistro(){

        Scanner entrada_sinistro = new Scanner(System.in);

        System.out.println("Digite a data do Sinistro: \n");
        String data_sinistro = entrada_sinistro.nextLine();

        System.out.println("Digite o endereço no qual o Sinistro aconteceu: \n");
        String endereco_sinistro = entrada_sinistro.nextLine();
        System.out.println("Digite a placa do veiculo: \n");
        String placa_sinistro = entrada_sinistro.nextLine();

        System.out.println("Digite o nome do Cliente: \n");
        String nome_sinistro = entrada_sinistro.nextLine();

        Cliente cliente_sinistro = this.procura_e_adiciona_cliente(nome_sinistro);

        if(cliente_sinistro.getNome() == null){

            return;
        }

        for(Veiculo veiculo : lista_Geral_de_Veiculos_seguradora){
            if(veiculo.getPlaca().equals(placa_sinistro)){
                Veiculo veiculo_sinistro = new Veiculo(veiculo.getPlaca(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
                Sinistro novo_Sinistro = new Sinistro(data_sinistro, endereco_sinistro, this, veiculo_sinistro, cliente_sinistro);
                this.adiciona_Sinistro(novo_Sinistro);
            }

        }
        System.out.println("Sinistro adicionado com sucesso!");

        return;

    }

    public boolean visualizarSinistro(String string){

        for(Sinistro acidente: listaSinistros){
            if(acidente.getCliente().getNome().equals(string)){

                System.out.println(acidente.toString());
                System.out.println("#####");
            }
            return true;
        }

        System.out.println("Sinistro Inexistente!");

        return false;
    }

    public void listarSinistros(){

        int i = 0;
        for(Sinistro sinistro: listaSinistros){
            System.out.println("Sinistro [" + i + "]:\n" + sinistro.toString() + "\n");
            i++;
        }

    }

    public Cliente procura_e_adiciona_cliente(String cliente){


        for(Cliente pessoa : listaClientes){
            if(pessoa.getNome().equals(cliente)){
                return pessoa;
            }
        }
        System.out.println("Nao foi possivel encontrar o Cliente!\n");
        return null;
    }

    public void adiciona_Sinistro(Sinistro sinistro){

        listaSinistros.add(sinistro);
    }

    public void lista_todos_Sinistros(){
        for(Sinistro sinistro : listaSinistros){
            System.out.println(sinistro.toString());
            System.out.println("***************");
        }
    }



    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", email='" + getEmail() + "'" +
            ", endereco='" + getEndereco() + "'" +
            "}";
    }




}
