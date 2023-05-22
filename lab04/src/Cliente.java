
import java.util.ArrayList;

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

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setValorSeguro(double valorSeguro){
        this.valorSeguro = valorSeguro;
    }
    public void addVeiculo(Veiculo veiculo){
        this.getListaVeiculos().add(veiculo);
    }
    //public String toString(){
      //  String out = "";
        //out = "DADOS DO CLIENTE: " + getNome() + " " +  getEndereco() + " " + getValorSeguro() + "\n";
        //return out;
    //}
}

