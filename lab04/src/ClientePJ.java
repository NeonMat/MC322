import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;
    
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    public String getCnpj(){
        return cnpj;
    }
    public Date getDataFundacao(){
        return dataFundacao;
    }
    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    @Override
    public String toString(){
        String out = "";
        out = "DADOS PESSOA JURIDICA: " + " " + getNome()+ " " + getEndereco()  
        + " " + getCnpj() + " " + getDataFundacao() + " " + getQtdeFuncionarios() + " " + "\n"; 
        return out;
    }

    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getValor() * (1+ (qtdeFuncionarios)/100) * getListaVeiculos().size();
    }
}

