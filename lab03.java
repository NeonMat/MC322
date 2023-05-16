import java.util.Random;

public class Lab03{
    
    public class Seguradora{
        private String nome;
        private String telefone;
        private String email;
        private String endereco;
        ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        ArrayList<Cliente> listaClientes = new ArrayLits<Cliente>();

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
            return listaCliente;
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
        public boolean cadastrarCliente(Cliente cliente){
            //verifica se o cliente já está na lista
            for (int i =0; i < listaCliente.size(); i++){
                if(listaCliente.get(i) == cliente){
                    return false;
                }
            }
            // verifica se o cpf é válido
            boolean valido;
            if (cliente instanceof ClientePF){
                valido = cliente.validarCPF(cliente.getCpf());
            }
            else{
                valido = cliente.validarCNPJ(cliente.getCnpj());
            }
            if(valido){
                listaCliente.add(cliente);
                return true;
            }
            else{
                return false;
            }
            

        }
        public boolean removerCliente(String nome_cliente){
            for(int i = 0; i < listaCliente.size(); i++){
                if(listaCliente.get(i).getNome().equals(nome_cliente)){
                    listaCliente.remove(i);
                    return true;
                }
            }
            return false;
        }
        public void listarClientes(String tipoCliente){
            for (int i =0; i < listaCliente.size();i++){
                if (tipoCliente == "ClientePJ" && listaCliente.get(i) instanceof ClientePJ){
                    System.out.println(listaCliente.get(i).getNome());
                }
                else if(tipoCliente == "ClientePF" && listaCliente.get(i) instanceof ClientePF){
                    System.out.println(listaCliente.get(i).getNome());
                }
            }
        }
        public boolean gerarSinistro(Cliente cliente, Date data, Veiculo veiculo){
            Sinistro sinistro = new Sinistro(data, cliente.getEndereco(), veiculo);
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
                if(listaSinistros.get(i).getCliente().getNome() == nome){
                    System.out.println(listaSinistros.get(i));
                    return true;
                }
            } return false;
        }
        public void listarSinistros(){
            for (int i =0; i < listaSinistros.size(); i++){
                System.out.println(listaSinistros.get(i));
            }
        }
        public int calculaNumSinistros(Cliente cliente){
            int num = 0;
            for (int i = 0; i< listaSinistros.size(); i++){
                if (listaSinistros.get(i).getCliente == cliente){
                    num++;
                }
            }
            return num;
        }
        public double calcularPrecoSeguroCliente(Cliente cliente){
            cliente.setValorSeguro(cliente.calculaScore() * (1 + calculaNumSinistros(cliente)))
            return cliente.getValorSeguro();
        }
        public double calcularReceita(){
            double receita = 0.0;
            for (int i = 0; i < listaCliente.size(); i++){
                receita += calcularPrecoSeguroCliente(listaCliente.get(i));
            }
            return receita;
        }

    }

    public class Cliente{
        private String nome;
        private String endereco;
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        private double valorSeguro;
        
        public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos){
            this.nome = nome;
            this.endereco = endereco;
            this.listaVeiculos = listaVeiculos;
        }
        
        public String getNome (){
            return nome;
        }
        public String getEndereco (){
            return endereco;
        }

        public ArrayList<Veiculo> getListaVeiculos(){
            return listaVeiculos;
        }
        public double getValorSeguro(){
            return valorSeguro;
        }

        public void setNome(string nome){
            this.nome = nome;
        }

        public void setEndereco(String endereco){
            this.endereco = endereco;
        }
        public void setValorSeguro(double valorSeguro){
            this.valorSeguro = valorSeguro;
        }
        //SET DE LISTA DE VEICULOS
        public String toString(){
            String out = "";
            out = getCpf() + getDataNascimento() + getEndereco() + getIdade() + getNome();
            return out;
        }
        
       


    }

    public class Veiculo{
        private String placa;
        private String marca;
        private String modelo;
        private int anoFabricacao;

        public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
            this.anoFabricacao = anoFabricacao;
        }

        public String getPlaca(){
            return placa;
        }
        public String getMarca(){
            return marca;
        }
        public String getModelo(){
            return modelo;
        }
        public int getAnoFabricao(){
            return anoFabricacao;
        }

        public void setPlaca(String placa){
            this.placa = placa;
        }
        public void setMarca(String marca){
            this.marca = marca;
        }
        public void setModelo(String modelo){
            this.modelo = modelo;
        }
        public void setAnoFabricacao(int anoFabricacao){
            this.anoFabricacao = anoFabricacao;
        }
         public String toString(){
            String out = "";
            out = getPlaca() + getMarca() + getModelo() + getAnoFabricao();
            return out;
         }
    }
    public class Sinistro{
        private final int id;
        private String data;
        private String endereco;
        private Veiculo veiculo;
        private Cliente cliente;
        private Seguradora seguradora;

        public Sinistro(String data, String endereco, Veiculo veiculo, CLiente cliente, Seguradora seguradora){
            this.id = setId();
            this.data = data;
            this.endereco = endereco;
            this.veiculo = veiculo;
            this.cliente = cliente;
            this.seguradora = seguradora;

        }
        public Cliente getCliente(){
            return cliente;
        }
        public int getId(){
            return id;
        }
        public String getData(){
            return data;
        }
        public String getEndereco(){
            return endereco;
        }
        public Veiculo getVeiculo(){
            return veiculo;
        }
        public Seguradora getSeguradora(){
            return seguradora;
        }
        
        public void setId(){
            Random gerador = new Random();
            this.id = gerador.nextInt();
        }
        public void setData(String data){
            this.data = data;
        }
        public void setEndereco(String endereco){
            this.endereco = endereco;
        }
        public void setCliente(Cliente cliente){
            this.cliente = cliente
        }
        public void setVeiculo(Veiculo veiculo){
            this.veiculo = veiculo;
        }
        public void setSeguradora(Seguradora seguradora){
            this.seguradora = seguradora;
        }

         public String toString(){
            String out = "";
            out = getCliente() + getVeiculo() + getSeguradora() + getEndereco() + getData() + getId();
            return out;
         }
    }
    public class AllCharactersSame{    
        static boolean allCharactersSame(String s)
        {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
            
        return true;
        }
    }
    public class ClientePF extends Cliente {
        private final String cpf;
        private String genero;
        private Date dataLicenca;
        private String educacao;
        private Date dataNascimento;
        private String classeEconomica;

        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        public String getCpf(){
            return cpf;
        }
        public String getGenero(){
            return genero;
        }
        public String getEducacao(){
            return educacao;
        }
        public String getClasseEconomica(){
            return classeEconomica;
        }
        public Date getDataNascimento(){
            return dataNascimento;
        }
        public Date getDataLicenca(){
            return dataLicenca;
        }

        public void setGenero(String genero){
            this.genero = genero;
        }
        public void setCpf(String cpf){
            this.cpf = cpf;
        }
        public void setEducacao(String educacao){
            this.educacao = educacao;
        }
        public void setClasseEconomica(String classeEconomica){
            this.classeEconomica = classeEconomica;
        }
        public void setDataNascimento(Date dataNascimento){
            this.dataNascimento = dataNascimento;
        }
        public void setDataLicenca(Date dataLicenca){
            this.dataLicenca =dataLicenca;
        }
         public String toString(){
            String out = "";
            out = getCpf() + getGenero() + getDataLicenca() + getEducacao() + getDataNascimento() + getClasseEconomica();
            return out;
        }
        public double calculaScore(){
            //ACHAR FATOR_IDADE
            return CalcSeguro.VALOR_BASE * FATOR_IDADE * getListaVeiculos().size();
        }
         

    }
    public class ClientePJ extends Cliente{
        private final String cnpj;
        private Date dataFundacao;
        private int qtdeFuncionarios;

        public String getCnpj(){
            return cnpj;
        }
        public String getDataFundacao(){
            return dataFundacao;
        }
        public int getQtdeFuncionarios(){
            return qtdeFuncionarios;
        }
        public void setQtdeFuncionarios(int qtdeFuncionarios){
            this.qtdeFuncionarios = qtdeFuncionarios;
        }
        public void setCnpj(String cnpj){
            this.cnpj = cnpj;
        }
        public void setDataFundacao(Date dataFundacao){
            this.dataFundacao = dataFundacao;
        }
        public String toString(){
            String out = "";
            out = getCnpj() + getDataFundacao() + getQtdeFuncionarios(); 
            return out;
        }

        public double calculaScore(){
            return CalcSeguro.VALOR_BASE * (1+ (qtdeFuncionarios)/100) * getListaVeiculos().size;
        }
    }
        
    public static class Validacao{
        public  static boolean validarCPF(String cpf) {
            this.cpf = cpf.replaceAll("[^A-z]","")
            if (this.cpf.length() =! 11){
                return false; 
            }
            else{
                if (AllCharactersSame.allCharactersSame(this.cpf))
                    return false;
            }
            
            
            int soma = 0;
            for(int i =0; i < 9; i++){
                soma += Integer.parseInt(this.cpf.charAt(i)) * (10 - i);
            }
            resto = soma % 11;
            if (resto > 1){
                int primeiro_dig = 11 - resto;
            }
            else{
                int primeiro_dig = 0;
            }
            if (primeiro_dig != Integer.parseInt(this.cpf.charAt(9))){
                return false;
            }
            
            int soma2 = 0;
            for(int i =0; i < 10; i++){
                soma2 += Integer.parseInt(this.cpf.charAt(i)) * (11-i);
            }
            int resto2 = soma2 % 11;
            if (resto2 > 1){
                int segundo_dig = 11 - resto2;
            }
            else{
                int segundo_dig = 0;
            }
            if (segundo_dig != Integer.parseInt(this.cpf.charAt(10))){
                return false;
            }
            
            return true;


        }
        public static boolean validarCNPJ(String cnpj){
            this.cnpj = cnpj.replaceAll("[^A-z]","")
            if (this.cnpj.length() =! 14){
                return false; 
            }
            else{
                if (AllCharactersSame.allCharactersSame(this.cnpj))
                    return false;
            }
            
            //Cálculo do primeiro dígito
            int soma = 0;
            for(int i =0; i < 4; i++){
                soma += Integer.parseInt(this.cnpj.charAt(i)) * (5 - i);
            }
            for(int i =4; i < 12; i++){
                soma += Integer.parseInt(this.cnpj.charAt(i)) * (13 - i);
            }
            resto = soma % 11;
            res = 11 - resto;
            if (res >= 2){
                int primeiro_dig = 11 - resto;
            }
            else{
                int primeiro_dig = 0;
            }
            if (primeiro_dig != Integer.parseInt(this.cpf.charAt(12))){
                return false;
            }
            //Cálculo do segundo dígito
            int soma2 = 0;
            for(int i =0; i < 5; i++){
                soma += Integer.parseInt(this.cnpj.charAt(i)) * (6 - i);
            }
            for(int i =5; i < 13; i++){
                soma += Integer.parseInt(this.cnpj.charAt(i)) * (14 - i);
            }
            int resto2 = soma2 % 11;
            if (resto2 >= 2){
                int segundo_dig = 11 - resto2;
            }
            else{
                int segundo_dig = 0;
            }
            if (segundo_dig != Integer.parseInt(this.cpf.charAt(13))){
                return false;
            }
            
            return true;
        }

    }

    public enum CalcSeguro{
        VALOR_BASE (100.0),
        FATOR_18_30 (1.2),
        FATOR_30_60 (1.0),
        FATOR_60_90 (1.5);
        
        private final double valor; 
        public CalcSeguro(double valor){
            this.valor = valor;
        }
        public double getValor(){
            return valor;
        }
    }
    public enum MenuOperacoes{
        CADASTROS (1),
        LISTAR(2),
        EXCLUIR(3),
        
    }
    
}
