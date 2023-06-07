
import java.util.ArrayList;

public class Seguradora{
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    //*************************** Construtor **********************************
    
        public Seguradora(String cnpj, String nome, String telefone, 
        String email, String endereco){
            this.cnpj = cnpj;
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.endereco = endereco;
        
    }
    
    //*************************************************************************
   
        public boolean cadastrarCliente(Cliente cliente){
        //verifica se o cliente já está na lista
            for (int i =0; i < getListaClientes().size(); i++){
                if(getListaClientes().get(i) == cliente){
                    return false;
                }
            }
            // verifica se o cpf é válido
            boolean valido;
            if (cliente instanceof ClientePF){
                ClientePF clientePF = (ClientePF)cliente; 
                valido = Validacao.validarCPF(clientePF.getCpf());
                //System.out.println("valor do validar cpf: " + valido);
                if (valido){
                    getListaClientes().add(clientePF);
                    return true;
                }
            }
            else{
                ClientePJ clientePJ = (ClientePJ)cliente;
                valido = Validacao.validarCNPJ(clientePJ.getCnpj());
                if (valido){
                    getListaClientes().add(clientePJ);
                    return true;
                }
            }
            return false;
            
            
        }
        public boolean removerCliente(String nome_cliente){
            for(int i = 0; i < getListaClientes().size(); i++){
                if(getListaClientes().get(i).getNome().equals(nome_cliente)){
                    getListaClientes().remove(i);
                    return true;
                }
            }
            return false;
        }
        
        public void listarClientes(String tipoCliente){
            System.out.println("Lista clientes do tipo: "+ tipoCliente);
            for (int i =0; i < getListaClientes().size();i++){
                if (tipoCliente.equals("ClientePJ") && getListaClientes().get(i) instanceof ClientePJ){
                    System.out.println(getListaClientes().get(i).toString());
                }
                else if(tipoCliente.equals("ClientePF") && getListaClientes().get(i) instanceof ClientePF){
                    System.out.println(getListaClientes().get(i).toString());
                }
            }
        }
        
        public boolean gerarSeguro(Frota frota, ClientePJ cliente){
            SeguroPJ seguroPJ = new SeguroPJ(this, frota, cliente);
            
            for(int i = 0; i < listaSeguros.size(); i++){
                if(seguroPJ.equals(listaSeguros.get(i))){
                    return false;
                }
            }
            
            listaSeguros.add(seguroPJ);
            return true;
        }
        public boolean gerarSeguro(Veiculo veiculo, ClientePF cliente){
            
            SeguroPF seguroPF = new SeguroPF(this, veiculo, cliente);
            
            for(int i = 0; i < listaSeguros.size(); i++){
                if(seguroPF.equals(listaSeguros.get(i))){
                    return false;
                }
            }
            
            listaSeguros.add(seguroPF);
            return true;
        }
        
        
        public boolean cancelarSeguro(Seguro seguro){
            for(Seguro s : listaSeguros){
                if (s.equals(seguro)){
                    listaSeguros.remove(seguro);
                    return true;
                }
            }
            return false;
        }
        public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
            ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
            for(int i = 0; i < listaSeguros.size();i++){
                if(listaSeguros.get(i).getCliente().equals(cliente)){
                    segurosCliente.add(listaSeguros.get(i));
                }
            }
            return segurosCliente; 
        }
        public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
            
            ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
            
            for(int i = 0; i < listaSeguros.size(); i++){
                
                if (cliente.equals(listaSeguros.get(i).getCliente())){
                    //Adiciona Sinistros de cada seguro do cliente
                    ArrayList<Sinistro> sinsitrosSeguro = listaSeguros.get(i).getListaSinistros();
                    for(Sinistro sinistro : sinsitrosSeguro){
                        sinistrosCliente.add(sinistro);
                    }
                }
            }
            return sinistrosCliente;
        }
        public double calcularReceita(){
            double receita = 0.0;
            for (int i = 0; i < listaSeguros.size(); i++){
                receita += listaSeguros.get(i).getValorMensal();
            }
            return receita;
        }
        
        //*************************** Getters **********************************
            
            public String getCnpj(){
                return cnpj;
            }
            public String getNome() {
                return nome;
            }
            public String getTelefone() {
                return telefone;
            }
            public String getEmail() {
                return email;
            }
            public String getEndereco() {
                return endereco;
            }
            public ArrayList<Cliente> getListaClientes(){
                return this.listaClientes;
            }
            public ArrayList<Seguro> getListaSeguros(){
                return listaSeguros;
            }
            
        
        //*************************** Setters **********************************
            public void setCnpj(String cnpj){
                this.cnpj = cnpj;
            }
            public void setNome(String nome) {
                this.nome = nome;
            }
            public void setTelefone(String telefone) {
                this.telefone = telefone;
            }
            public void setEmail(String email) {
                this.email = email;
            }
            public void setEndereco(String endereco) {
                this.endereco = endereco;
            }
            
            public String toString(){
                String out = "";
                out += "\nSEGURADORA: \n" + 
                            "\t CNPJ: " + getNome() + "\n" 
                            + "\t Telefone: " +   getTelefone() + "\n" 
                            + "\t Email: " +getEmail() + "\n" 
                            + "\t Endereco: " + getEndereco();
                return out;
                
            }
        /* public boolean gerarSinistro(Cliente cliente, LocalDate data, Veiculo veiculo){
            Sinistro sinistro = new Sinistro(data, cliente.getEndereco(), veiculo, cliente, this);
            for (int i =0; i < listaSinistros.size();i++){
                if (sinistro == listaSinistros.get(i)){
                    return false;
                }
            }
            listaSinistros.add(sinistro);
            return true;
        }
        public boolean visualizarSinistro(String nome){
            for(int i = 0; i < listaSinistros.size();i++){
                if(listaSinistros.get(i).getCliente().getNome().equals(nome)){
                    System.out.println(listaSinistros.get(i));
                    return true;
                }
            } return false;
        }
        public void listarSinistros(){
            System.out.println("\nLista de Sinistros: ");
            for (int i =0; i < listaSinistros.size(); i++){
                System.out.println(listaSinistros.get(i).toString());
            }
        }
        public int calculaNumSinistros(Cliente cliente){
            int num = 0;
            for (int i = 0; i< listaSinistros.size(); i++){
                if (listaSinistros.get(i).getCliente() == cliente){
                    num++;
                }
            }
            return num;
        }
        */
        /* public void calcularPrecoSeguroCliente(Cliente cliente){
            if (cliente instanceof ClientePF){
                ClientePF clientePF = (ClientePF)cliente;
                cliente.setValorSeguro(clientePF.calculaScore() * (1 + calculaNumSinistros(cliente)));
            }
            else{
                ClientePJ clientePJ = (ClientePJ)cliente;
                cliente.setValorSeguro(clientePJ.calculaScore() * (1 + calculaNumSinistros(cliente)));
                
            }
        } */
        
        
        
        
    }    
    
    