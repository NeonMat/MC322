import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MenuIterativo {
    
    public static void run(){
        boolean bool = true;
        while (bool){
            MenuOperacoes operacao = MenuIterativo.getMenuOperacoes();
            ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
            Scanner in = new Scanner(System.in);
            switch(operacao){
                case CADASTRAR:
                    {
                        boolean boolCadastrar = true;
                        while(boolCadastrar){
                            MenuCadastrar cadastrar = MenuIterativo.getCadastrar();
                            switch(cadastrar){
                                case CADASTRAR_CLIENTEPJ :    
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o cliente: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
                                        

                                        System.out.println("\nInsira os dados do cliente (PJ)");

                                        System.out.println("\n\tNome da empresa: ");
                                        String nomeClientePJ = in.nextLine();

                                        System.out.println("\n\tTelefone: ");
                                        String telefoneClientePJ = in.nextLine();

                                        System.out.println("\n\temail: ");
                                        String emailClientePJ = in.nextLine();

                                        System.out.println("\n\tEndereço: ");
                                        String enderecoClientePJ = in.nextLine();

                                        System.out.println("\n\tCNPJ: ");
                                        String cnpj = in.nextLine();

                                        System.out.println("\n\tData de Fundação: ");
                                        String strDataFundacao = in.nextLine();
                                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate dataFundacao = LocalDate.parse(strDataFundacao  , dateFormat);

                                        System.out.println("Quantidade de Funcionários: ");
                                        int qtdeFuncionarios = in.nextInt();
                                        
                                        Cliente cliente = new ClientePJ(nomeClientePJ, telefoneClientePJ, emailClientePJ, enderecoClientePJ, cnpj, dataFundacao, qtdeFuncionarios);
                                        seguradora.cadastrarCliente(cliente);
                                    }
                                    break;
                                case CADASTRAR_CLIENTEPF :
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o cliente: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
                                        

                                        System.out.println("\nInsira os dados do cliente (PF)");

                                        System.out.println("\n\tNome: ");
                                        String nomeClientePF = in.nextLine();

                                        System.out.println("\n\tTelefone: ");
                                        String telefoneClientePF = in.nextLine();

                                        System.out.println("\n\temail: ");
                                        String emailClientePF = in.nextLine();

                                        System.out.println("\n\tEndereço: ");
                                        String enderecoClientePF = in.nextLine();

                                        System.out.println("\n\tCPF: ");
                                        String cpf = in.nextLine();

                                        System.out.println("\n\tGênero: ");
                                        String genero = in.nextLine();

                                        System.out.println("\n\tEducação: ");
                                        String educacao = in.nextLine();

                                        System.out.println("\n\tData de Nascimento: ");
                                        String strDataNascimento = in.nextLine();
                                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate dataNascimento = LocalDate.parse(strDataNascimento  , dateFormat);

                                        Cliente cliente = new ClientePF(nomeClientePF, telefoneClientePF, emailClientePF, enderecoClientePF, cpf,genero, educacao, dataNascimento);
                                        seguradora.cadastrarCliente(cliente);
                                    }
                                    break;
                                case CADASTRAR_VEICULO :
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nPara qual desses clientes você deseja cadastrar o veículo: ");
                                        for(int i = 0;i< seguradora.getListaClientes().size(); i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i).getNome());
                                        }
                                        int indexCliente = in.nextInt();
                                        ClientePJ cliente = (ClientePJ)seguradora.getListaClientes().get(indexCliente);
                                        
                                        System.out.println("\nPara qual dessas frotas deseja adicionar o veículo:");
                                        for(int i = 0;i < cliente.getListaFrotas().size(); i++){
                                            System.out.println("\n\t" + i + " - " + cliente.getListaFrotas().get(i).getCode());
                                        }
                                        int indexFrota = in.nextInt();
                                        System.out.println("Digite a placa, marca, modelo e ano de fabricação do veículo, respectivamente: ");
                                        String placa = in.nextLine();
                                        String marca = in.nextLine();
                                        String modelo = in.nextLine();
                                        int anoFabricacao = in.nextInt();
                                        cliente.getListaFrotas().get(indexFrota).addVeiculo(new Veiculo(placa, marca, modelo, anoFabricacao));
                                    
                                    }
                                    break;
                                case CADASTRAR_SEGURADORA :
                                    {    
                                        System.out.println("\nInsira, respectivamente, CNPJ, nome, telefone, email e endereço:");
                                        String cnpjSeguradora = in.nextLine();
                                        String nomeSeguradora = in.nextLine();
                                        String telefoneSeguradora = in.nextLine();
                                        String emailSeguradora = in.nextLine();
                                        String enderecoSeguradora = in.nextLine();
                                        listaSeguradoras.add(new Seguradora(cnpjSeguradora, nomeSeguradora, telefoneSeguradora, emailSeguradora, enderecoSeguradora));
                                    }
                                    break;
                                case CADASTRAR_SEGURO_PJ: 
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o seguro: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
                                    
                                        System.out.println("\nDigite qual dos clientes: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i));
                                        }
                                        int indexCliente = in.nextInt();
                                        ClientePJ cliente = (ClientePJ)seguradora.getListaClientes().get(indexCliente);
                                        seguradora.cadastrarCliente(cliente);
                                    
                                        if(cliente.getListaFrotas().size() == 0){
                                            System.out.println("\nEsse cliente (PJ) não possui nenhuma frota cadastrada e, sendo assim, não é possível cadastrar um seguro");
                                        }
                                        else{
                                            System.out.println("\nDigite para qual dessas frotas deseja gerar o seguro: ");
                                            for(int i = 0;i< cliente.getListaFrotas().size(); i++){
                                                System.out.println("\n\t" + i + " - " + cliente.getListaFrotas().get(i).getCode());
                                            }
                                            int indexFrota = in.nextInt();
                                            seguradora.gerarSeguro(cliente.getListaFrotas().get(indexFrota), cliente);
                                        }


                                    }
                                    break;    
                                case CADASTRAR_SEGURO_PF: 
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o seguro: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
                                        
                                
                                        System.out.println("\nCaso o cliente já seja cadastrado digite 1, do contrário digite 2.");
                                        int cadastrado = in.nextInt();
                                        
                                        ClientePF cliente;
                                        if(cadastrado == 1){
                                            System.out.println("\nDigite qual dos clientes ");
                                            for(int i = 0;i< listaSeguradoras.size(); i++){
                                                System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i));
                                            }
                                            int indexCliente = in.nextInt();
                                            cliente = (ClientePF)seguradora.getListaClientes().get(indexCliente);
                                            seguradora.cadastrarCliente(cliente);
                                        }
                                        else{    
                                            System.out.println("\nDigite, respectivamente, nome, telefone, email, endereço, CPF, gênero, educação e a data de nascimento (dd/MM/yyyy): ");      
                                            String nomeCliente = in.nextLine();
                                            String telefoneCliente = in.nextLine();
                                            String emailCliente = in.nextLine();
                                            String enderecoCliente = in.nextLine();
                                            String cpfCliente = in.nextLine();
                                            String generoCliente = in.nextLine();
                                            String educacaoCliente = in.nextLine();
                                            String usrData  = in.nextLine();
                                            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                            LocalDate dataNascimento = LocalDate.parse(usrData, dateFormat);
                                            cliente = new ClientePF(nomeCliente, telefoneCliente, emailCliente, enderecoCliente, cpfCliente, generoCliente, educacaoCliente, dataNascimento);
                                            seguradora.cadastrarCliente(cliente);
                                        }
                                        System.out.println("Digite a placa, marca, modelo e ano de fabricação do veículo, respectivamente: ");
                                        String placaPF = in.nextLine();
                                        String marcaPF = in.nextLine();
                                        String modeloPF = in.nextLine();
                                        int anoFabricacaoPF = in.nextInt();
                                        seguradora.gerarSeguro(new Veiculo(placaPF, marcaPF, modeloPF, anoFabricacaoPF), (ClientePF)cliente);
                                        
                                    }
                                    break;
                                case CADASTRAR_CONDUTOR :
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o condutor: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite em qual desses seguros deseja adicionar o condutor: ");
                                        for(int i = 0;i< seguradora.getListaSeguros().size(); i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaSeguros().get(i).getId());
                                        }
                                        int indexSeguro = in.nextInt();
                                        Seguro seguro = seguradora.getListaSeguros().get(indexSeguro);

                                        System.out.println("\nDigite abaixo as informações do condutor: ");

                                        System.out.println("\n\tNome: ");
                                        String nomeCondutor = in.nextLine();

                                        System.out.println("\n\tTelefone: ");
                                        String telefoneCondutor = in.nextLine();

                                        System.out.println("\n\temail: ");
                                        String emailCondutor = in.nextLine();

                                        System.out.println("\n\tEndereço: ");
                                        String enderecoCondutor = in.nextLine();

                                        System.out.println("\n\tCPF: ");
                                        String cpf = in.nextLine();

                                        System.out.println("\n\tData de Nascimento: ");
                                        String strDataNascimento = in.nextLine();
                                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate dataNascimento = LocalDate.parse(strDataNascimento  , dateFormat);


                                        seguro.autorizarCondutor(new Condutor(cpf, nomeCondutor, telefoneCondutor, enderecoCondutor, emailCondutor, dataNascimento));


                                    }
                                    break;
                                case CADASTRAR_FROTA :
                                    {   
                                    //Get Seguradora    
                                        System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar a frota: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
                                    //Get Cliente                                    
                                        System.out.println("\nDigite para qual Cliente deseja adicionar uma frota:");
                                        int indice = 1;
                                        ArrayList<ClientePJ> clientesPJ = new ArrayList<ClientePJ>();
                                        for(Cliente c: seguradora.getListaClientes()){
                                            if (c instanceof ClientePJ){    
                                                System.out.println("\n\t" + indice + " - " + c.getNome());
                                                clientesPJ.add((ClientePJ)c);
                                                indice++;
                                            }
                                        }
                                        ClientePJ clienteFrota = clientesPJ.get(in.nextInt());
                                        Frota frota = new Frota();
                                        System.out.println("\nPara cadastrar um veículo nessa frota, digite 1, do contrário digite 0: ");
                                        int cadastrarVeiculo = in.nextInt();
                                        while(cadastrarVeiculo == 1){
                                            System.out.println("\n\tPlaca: ");
                                            String placa = in.nextLine();

                                            System.out.println("\n\tMarca: ");
                                            String marca = in.nextLine();

                                            System.out.println("\n\tModelo: ");
                                            String modelo = in.nextLine();

                                            System.out.println("\n\tAno de Fabricação: ");
                                            int anoFabricacao = in.nextInt();

                                            frota.addVeiculo(new Veiculo(placa, marca, modelo, anoFabricacao));

                                            System.out.println("\nDeseja Adicionar outro veículo? Se sim digite 1, do contrário digite 0");
                                            cadastrarVeiculo = in.nextInt();
                                        }
                                        clienteFrota.getListaFrotas().add(frota);
                                    }//Bloco - CADASTRAR_FROTA                                    
                                    break;
                                case GERAR_SINISTRO:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja gerar o sinistro: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite em qual desses seguros deseja gerar o sinistro: ");
                                        for(int i = 0;i< seguradora.getListaSeguros().size(); i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaSeguros().get(i).getId());
                                        }
                                        int indexSeguro = in.nextInt();
                                        Seguro seguro = seguradora.getListaSeguros().get(indexSeguro);

                                        System.out.println("\nDigite para qual desses condutores o sinistro será gerado: ");
                                        for(int i = 0; i< seguro.getListaCondutores().size();i++){
                                            System.out.println("\n\t" + i + " - " + seguro.getListaCondutores().get(i).getNome());
                                        }
                                        int indexCondutor = in.nextInt();
                                        Condutor condutor = seguro.getListaCondutores().get(indexCondutor);
                                        
                                        System.out.println("\nInsira as informações do sinsitro: ");

                                        System.out.println("Endereço: ");
                                        String endereco = in.nextLine();
                                        
                                        System.out.println("\n\tData: ");
                                        String strDataSinistro = in.nextLine();
                                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate dataSinistro = LocalDate.parse(strDataSinistro  , dateFormat);
                                        
                                        Sinistro sinistro = new Sinistro(dataSinistro, endereco, condutor, seguro);
                                        seguro.getListaSinistros().add(sinistro);
                                        condutor.getListaSinistros().add(sinistro);

                                        
                                    }
                                    break;
                                case VOLTAR: 
                                    boolCadastrar = false;
                                    break;
                                default:
                                    break;
                                    
                                
                            }//Switch Cadastrar
                        }//While Switch Cadastrar
                    }// Bloco case cadastrar
                    break;
                    
                
                case EXCLUIR:
                    {    
                        boolean boolExcluir = true;
                        MenuExcluir excluir = MenuIterativo.getExcluir();
                        while(boolExcluir){  
                            switch(excluir){
                                case EXCLUIR_CLIENTEPF:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir um cliente (PF): ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite qual desses clientes deseja excluir");
                                        int indice = 1;
                                        ArrayList<Integer> indices = new ArrayList<Integer>();
                                        int i = 0;
                                        for(Cliente c: seguradora.getListaClientes()){
                                            if (c instanceof ClientePF){    
                                                System.out.println("\n\t" + indice + " - " + c.getNome());
                                                indices.add(i);
                                                indice++;
                                            }
                                            i++;
                                        }
                                        int indiceExcluir = in.nextInt();
                                        indiceExcluir = indices.get(indiceExcluir);
                                        seguradora.getListaClientes().remove(indiceExcluir);

                                    }
                                    break;
                                case EXCLUIR_CLIENTEPJ:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir o cliente(PJ): ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite qual desses clientes deseja excluir:");
                                        int indice = 1;
                                        ArrayList<Integer> indices = new ArrayList<Integer>();
                                        int i = 0;
                                        for(Cliente c: seguradora.getListaClientes()){
                                            if (c instanceof ClientePJ){    
                                                System.out.println("\n\t" + indice + " - " + c.getNome());
                                                indices.add(i);
                                                indice++;
                                            }
                                            i++;
                                        }
                                        int indiceExcluir = in.nextInt();
                                        indiceExcluir = indices.get(indiceExcluir);
                                        seguradora.getListaClientes().remove(indiceExcluir);
                                        
                                    }
                                    break;
                                case EXCLUIR_CONDUTOR:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir o condutor: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite para qual seguro: ");
                                        for(int i =0; i< seguradora.getListaSeguros().size();i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaSeguros().get(i).getId());
                                        }
                                        int indexSeguro = in.nextInt();
                                        Seguro seguro = seguradora.getListaSeguros().get(indexSeguro);


                                        System.out.println("\nDigite qual condutor: ");
                                        for(int i =0; i< seguro.getListaCondutores().size();i++){
                                            System.out.println("\n\t" + i + " - " + seguro.getListaCondutores().get(i).getNome());
                                        }
                                        int indexCondutor = in.nextInt();
                                        System.out.println("\nCondutor #" + seguro.getListaCondutores().get(indexCondutor).getNome()  + " excluído");
                                        //Excluindo Sinistros do condutor
                                        for(int i = 0; i < seguro.getListaSinistros().size();i++){
                                            if(seguro.getListaSinistros().get(i).getCondutor().equals(seguro.getListaCondutores().get(indexCondutor))){
                                                seguro.getListaSinistros().remove(i);
                                            }
                                        }
                                        seguro.getListaCondutores().remove(indexCondutor);
                                            
                                    }
                                    break;
                                case EXCLUIR_FROTA:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir a frota: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite em qual desses clientes:");
                                        int indice = 1;
                                        ArrayList<Integer> indices = new ArrayList<Integer>();
                                        int i = 0;
                                        for(Cliente c: seguradora.getListaClientes()){
                                            if (c instanceof ClientePJ){    
                                                System.out.println("\n\t" + indice + " - " + c.getNome());
                                                indices.add(i);
                                                indice++;
                                            }
                                            i++;
                                        }
                                        int indexCliente = in.nextInt();
                                        indexCliente = indices.get(indexCliente);
                                        ClientePJ cliente = (ClientePJ)seguradora.getListaClientes().get(indexCliente);
                                        
                                        System.out.println("\nDigite qual frota deseja excluir: ");
                                        for(i = 0;i< cliente.getListaFrotas().size(); i++){
                                            System.out.println("\n\t" + i + " - " + cliente.getListaFrotas().get(i).getCode());
                                        }
                                        int indexFrota = in.nextInt();
                                        cliente.getListaFrotas().remove(indexFrota);
                                        System.out.println("\nFrota Excluída");
                                        

                                    }
                                    break;
                                case EXCLUIR_SEGURADORA:
                                    {
                                        System.out.println("\nDigite qual dessas seguradoras deseja excluir: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        listaSeguradoras.remove(indexSeguradora);
                                    }
                                    break;
                                case EXCLUIR_SEGURO:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir o seguro: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite qual desses seguros deseja excluir: ");
                                        for(int i = 0;i< seguradora.getListaSeguros().size(); i++){
                                            System.out.println("\n\t" + i + " - " + seguradora.getListaSeguros().get(i).getId());
                                        }
                                        int indexSeguro = in.nextInt();
                                        seguradora.getListaSeguros().remove(indexSeguro);

                                    }
                                    break;
                                case EXCLUIR_VEICULO:
                                    {
                                        System.out.println("\nDigite em qual dessas seguradoras deseja excluir o seguro: ");
                                        for(int i = 0;i< listaSeguradoras.size(); i++){
                                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                                        }
                                        int indexSeguradora = in.nextInt();
                                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                                        System.out.println("\nDigite de qual desses clientes é o veículo: ");
                                        int indice = 1;
                                        ArrayList<Integer> indices = new ArrayList<Integer>();
                                        int i = 0;
                                        for(Cliente c: seguradora.getListaClientes()){
                                            if (c instanceof ClientePF){    
                                                System.out.println("\n\t" + indice + " - " + c.getNome());
                                                indices.add(i);
                                                indice++;
                                            }
                                            i++;
                                        }
                                        int indiceCliente = in.nextInt();
                                        indiceCliente = indices.get(indiceCliente);
                                        ClientePF cliente = (ClientePF)seguradora.getListaClientes().get(indiceCliente);

                                        System.out.println("\nQual desses veículos deseja excluir: ");
                                        for(i = 0; i < cliente.getListaVeiculos().size();i++){
                                            System.out.println("\n\t" + i + " - " + cliente.getListaVeiculos().get(i).getMarca() + cliente.getListaVeiculos().get(i).getModelo());
                                        }
                                        int indexVeiculo = in.nextInt();
                                        Veiculo veiculo = cliente.getListaVeiculos().get(indexVeiculo);
                                        for(i = 0; i < seguradora.getListaSeguros().size();i++){
                                            if(seguradora.getListaSeguros().get(i) instanceof SeguroPF){
                                                SeguroPF seguroExcluir = (SeguroPF)seguradora.getListaSeguros().get(i);
                                                if (seguroExcluir.getVeiculo().equals(veiculo)){
                                                    seguradora.getListaSeguros().remove(i);
                                                }
                                            }
                                        }
                                        cliente.getListaVeiculos().remove(indexVeiculo);
                                        System.out.println("Veículo excluído.");


                                    }
                                    break;
                                case VOLTAR:
                                    boolExcluir = false;
                                default:
                                    break;
                                
                            }//Switch Menu Excluir
                        }//Loop Menu Excluir
                    }//Bloco EXCLUIR (Switch Menu principal)
                    break;
                case TRANSFERIR_SEGURO:
                    {
                        System.out.println("\nDigite em qual dessas seguradoras deseja fazer a transferência: ");
                        for(int i = 0;i< listaSeguradoras.size(); i++){
                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                        }
                        int indexSeguradora = in.nextInt();
                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                        System.out.println("\nDigite qual desses seguros deseja transferir: ");
                        for(int i = 0;i< seguradora.getListaSeguros().size(); i++){
                        System.out.println("\n\t" + i + " - " + seguradora.getListaSeguros().get(i).getId());
                        }
                        int indexSeguro = in.nextInt();
                        Seguro seguro = seguradora.getListaSeguros().get(indexSeguro);
                        
                        System.out.println("\nPara qual desses clientes deseja transferir:");
                        for(int i = 0; i < seguradora.getListaClientes().size();i++){
                            System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i).getNome());
                        }
                        int indexCliente = in.nextInt();
                        Cliente cliente = seguradora.getListaClientes().get(indexCliente);
                        Cliente clienteAnterior;
                        if(cliente instanceof ClientePF){
                            ClientePF clientepf = (ClientePF) cliente;
                            SeguroPF seguropf = (SeguroPF)seguro;
                            clienteAnterior = seguropf.getCliente();
                            seguropf.setCliente(clientepf);
                        }
                        else{
                            ClientePJ clientepj = (ClientePJ) cliente;
                            SeguroPJ seguropj = (SeguroPJ) seguro;
                            clienteAnterior = seguropj.getCliente();
                            seguropj.setCliente(clientepj);
                        }
                        System.out.println("\nSeguro transferido do cliente " + clienteAnterior.getNome() + " para o cliente " + cliente.getNome());
                                        





                    }
                    break;
                case CALCULAR_RECEITA:
                    {
                        System.out.println("\nDigite para qual dessas seguradoras deseja calcular a receita: ");
                        for(int i = 0;i< listaSeguradoras.size(); i++){
                            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
                        }
                        int indexSeguradora = in.nextInt();
                        Seguradora seguradora = listaSeguradoras.get(indexSeguradora);

                        double receita = 0.0;
                        for (int i = 0; i < seguradora.listaSeguros.size();i++){
                            receita += seguradora.listaSeguros.get(i).calcularValor();
                        }
                        System.out.println("A receita da seguradora " + seguradora.getNome() + " é de " + receita + " reais.");

                    }
                    break;
                case SAIR:
                    bool = false;
                    in.close();
                    break;
                    

            }//Switch Menu principal
        }//Loop Menu Principal
    }//Função run
    public static Seguradora getSeguradora(ArrayList<Seguradora> listaSeguradoras){
        System.out.println("\nDigite para qual dessas seguradoras: ");
        for(int i = 0;i< listaSeguradoras.size(); i++){
            System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
        }
        Scanner in = new Scanner(System.in);
        int indexSeguradora = in.nextInt();
        in.close();
        return listaSeguradoras.get(indexSeguradora);
    
    }
    public static MenuOperacoes getMenuOperacoes(){
        System.out.println("\nDigite a opção desejada: " +
        "\n\t1 - Menu de cadastro" +
        "\n\t2 - Excluir informações" +  
        "\n\t3 - Transferir Seguro" +
        "\n\t4 - Calcular Receita" +
        "\n\t0 - Sair");
        Scanner scanner = new Scanner(System.in);
        int operacao = scanner.nextInt(); 
        return MenuOperacoes.getEnum(operacao);
    }
    public static MenuCadastrar getCadastrar(){
        System.out.println("\nDigite a opção desejada: " +
        "\n\t1 - Cadastrar Cliente (PF)" +
        "\n\t2 - Cadastrar Cliente (PJ)"+ 
        "\n\t3 - Cadastrar Condutor " +
        "\n\t4 - Cadastrar Frota" +
        "\n\t5 - Cadastrar Seguradora" +
        "\n\t6 - Cadastrar Seguro (PF)" +
        "\n\t7 - Cadastrar Seguro (PJ)" + 
        "\n\t8 - Cadastrar Veículo" +
        "\n\t9 - Gerar Sinistro"+ 
        "\n\t0 - Voltar");
        Scanner scanner = new Scanner(System.in);
        int operacao = scanner.nextInt();
        return MenuCadastrar.getEnum(operacao);
    
    }
    public static MenuExcluir getExcluir(){
        System.out.println("\nDigite a opção desejada: " +
        "\n\t1 - Excluir Cliente (PF)" +
        "\n\t2 - Excluir Cliente (PJ)"+ 
        "\n\t3 - Excluir Condutor " +
        "\n\t4 - Excluir Frota" +
        "\n\t5 - Excluir Seguro" +
        "\n\t6 - Excluir Seguradora" + 
        "\n\t7 - Excluir Veículo" + 
        "\n\t0 - Voltar");
        Scanner scanner = new Scanner(System.in);
        int operacao = scanner.nextInt();
        return MenuExcluir.getEnum(operacao);
    
    }
    

}

//case CADASTRAR_SEGURO :
//     {    
//         System.out.println("\nDigite em qual dessas seguradoras deseja cadastrar o seguro: ");
//         for(int i = 0;i< listaSeguradoras.size(); i++){
//             System.out.println("\n\t" + i + " - " + listaSeguradoras.get(i).getNome());
//         }
//         int indexSeguradora = in.nextInt();
//         Seguradora seguradora = listaSeguradoras.get(indexSeguradora);
        

//         System.out.println("\nCaso o cliente já seja cadastrado digite 1, do contrário digite 2.");
//         int cadastrado = in.nextInt();
//         boolean clienteTypeValid = true;
//         while (clienteTypeValid){    
//             System.out.println("\nDigite 1 para PF e 2 pra PJ: ");
//             int pfpj = in.nextInt();    
//             Cliente cliente;
//             switch(pfpj){
//                 default:        
//                     System.out.println("\nEntrada Inválida");
//                     break;
//                 case 1: //clientepf
//                     {    
//                         if(cadastrado == 1){
//                             System.out.println("\nDigite qual dos clientes ");
//                             for(int i = 0;i< listaSeguradoras.size(); i++){
//                                 System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i));
//                             }
//                             int indexCliente = in.nextInt();
//                             cliente = seguradora.getListaClientes().get(indexCliente);
//                             seguradora.cadastrarCliente(cliente);
//                         }
//                         else{    
//                             System.out.println("\nDigite, respectivamente, nome, telefone, email, endereço, CPF, gênero, educação e a data de nascimento (dd/MM/yyyy): ");      
//                             String nomeCliente = in.nextLine();
//                             String telefoneCliente = in.nextLine();
//                             String emailCliente = in.nextLine();
//                             String enderecoCliente = in.nextLine();
//                             String cpfCliente = in.nextLine();
//                             String generoCliente = in.nextLine();
//                             String educacaoCliente = in.nextLine();
//                             String usrData  = in.nextLine();
//                             DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                             LocalDate dataNascimento = LocalDate.parse(usrData, dateFormat);
//                             cliente = new ClientePF(nomeCliente, telefoneCliente, emailCliente, enderecoCliente, cpfCliente, generoCliente, educacaoCliente, dataNascimento);
//                             seguradora.cadastrarCliente(cliente);
//                         }
//                         System.out.println("Digite a placa, marca, modelo e ano de fabricação do veículo, respectivamente: ");
//                         String placaPF = in.nextLine();
//                         String marcaPF = in.nextLine();
//                         String modeloPF = in.nextLine();
//                         int anoFabricacaoPF = in.nextInt();
//                         seguradora.gerarSeguro(new Veiculo(placaPF, marcaPF, modeloPF, anoFabricacaoPF), (ClientePF)cliente);
//                     }
//                     clienteTypeValid = false;
//                     break;
//                 case 2: //clientepj
//                     {
//                         cliente = cliente;
//                         if (cadastrado == 2){    
//                             System.out.println("\nDigite, respectivamente, nome da empresa, telefone, email, endereço, CNPJ e a data de fundação (dd/MM/yyyy) e quantidade de funcionários: ");      
//                             String nomeClientePJ = in.nextLine();
//                             String telefoneClientePJ = in.nextLine();
//                             String emailClientePJ = in.nextLine();
//                             String enderecoClientePJ = in.nextLine();
//                             String cnpjCliente = in.nextLine();
//                             String generoClientePJ = in.nextLine();
//                             String educacaoClientePJ = in.nextLine();
//                             String usrDataPJ = in.nextLine();
//                             DateTimeFormatter dateFormatPJ = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                             LocalDate dataFundacao = LocalDate.parse(usrDataPJ, dateFormatPJ);
//                             int qtdeFuncionarios = in.nextInt();
//                             cliente = new ClientePJ(nomeClientePJ, telefoneClientePJ, emailClientePJ, enderecoClientePJ, cnpjCliente, dataFundacao, qtdeFuncionarios);
//                             seguradora.cadastrarCliente(cliente);
//                         }
//                         else{
//                             System.out.println("\nDigite qual dos clientes ");
//                             for(int i = 0;i< listaSeguradoras.size(); i++){
//                                 System.out.println("\n\t" + i + " - " + seguradora.getListaClientes().get(i));
//                             }
//                             int indexCliente = in.nextInt();
//                             cliente = seguradora.getListaClientes().get(indexCliente);
//                             seguradora.cadastrarCliente(cliente);
//                         }
//                         if(cliente.getListaFrotas().size() == 0){
//                             System.out.println("\nEsse cliente (PJ) não possui nenhuma frota cadastrada e, sendo assim, não é possível cadastrar um seguro");
//                         }
//                         else{
//                             System.out.println("\nDigite para qual dessas frotas deseja gerar o seguro: ");
//                             for(int i = 0;i< cliente.getListaFrotas().size(); i++){
//                                 System.out.println("\n\t" + i + " - " + clientePJ.getListaFrotas().get(i).getCode());
//                             }
//                             int indexFrota = in.nextInt();
//                             seguradora.gerarSeguro(cliente.getListaFrotas().get(indexFrota), cliente);
//                         }
//                     } 
//                     clienteTypeValid = false;                               
//                     break;
//             }
//         }
//         //gerar sinistros?
//     }
//     break;