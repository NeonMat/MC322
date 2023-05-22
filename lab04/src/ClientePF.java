
import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
    
    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cpf, 
                        String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }
    
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
    @Override
    public String toString(){
        String out = "";
        out = "DADOS CLIENTE PESSOA FISICA: " + getNome() + " " + getCpf() + " " + getGenero() + " " + getDataLicenca() 
        + " " + getEducacao() + " " + getDataNascimento() + " " + getClasseEconomica() + "\n";
        return out;
    }
    public double calculaScore(){
        //ACHAR FATOR_IDADE
        double FATOR_IDADE = 0.0;
        return CalcSeguro.VALOR_BASE.getValor() * FATOR_IDADE * getListaVeiculos().size();
    }
     

}

