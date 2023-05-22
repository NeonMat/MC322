
import java.util.ArrayList;
import java.util.Date;

public class Seguradora{
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        
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
    public ArrayList<Sinistro> getListaSinistros(){
        return listaSinistros;
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
        out += "SEGURADORA: " + getNome() + ", " +  getTelefone() + ", " + getEmail() + ", " + getEndereco() + "\n";
        return out;
    }
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
    
    public boolean gerarSinistro(Cliente cliente, Date data, Veiculo veiculo){
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
    
    public void calcularPrecoSeguroCliente(Cliente cliente){
        if (cliente instanceof ClientePF){
            ClientePF clientePF = (ClientePF)cliente;
            cliente.setValorSeguro(clientePF.calculaScore() * (1 + calculaNumSinistros(cliente)));
        }
        else{
            ClientePJ clientePJ = (ClientePJ)cliente;
            cliente.setValorSeguro(clientePJ.calculaScore() * (1 + calculaNumSinistros(cliente)));

        }
    }
    public double calcularReceita(){
        double receita = 0.0;
        for (int i = 0; i < getListaClientes().size(); i++){
            calcularPrecoSeguroCliente(getListaClientes().get(i));
            receita += getListaClientes().get(i).getValorSeguro();
        }
        return receita;
    }

}
