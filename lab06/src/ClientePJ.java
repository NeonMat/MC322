import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
    
    public ClientePJ(String nome, String telefone, String email, String endereco, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios) {
        super(nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    
    public boolean cadastrarFrota(Frota frota){
        for(int i = 0; i < listaFrotas.size(); i++){
            if(frota == listaFrotas.get(i)){
                System.out.println("ERRO: Frota já cadastrada.");
                return false;
            }
        }
        listaFrotas.add(frota);
        return true;
    }
    public boolean atualizarFrota(){
        return true;
    }
    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota){
        for (int i = 0; i < listaFrotas.size(); i++){
            if (listaFrotas.get(i).equals(frota)){
                return listaFrotas.get(i).getListaVeiculos();
            }
        }
        return null;
    }
    //@Override
    public String toString(){
        String out = "";
        out = "\nDADOS PESSOA JURIDICA: \n" 
                + "\t Nome: " + getNome()
                + "\n\t Endereco: " + getEndereco()  
                + "\n\t CNPJ: " + getCnpj() + "\n\t Data de Fundação: " + getDataFundacao(); 
        return out;
    }
//*************************** Getters e Setters **********************************

    public String getCnpj(){
        return cnpj;
    }
    public LocalDate getDataFundacao(){
        return dataFundacao;
    }
    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }
    public ArrayList<Frota> getListaFrotas(){
        return listaFrotas;
    }
    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
}

