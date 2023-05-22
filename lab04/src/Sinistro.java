
import java.util.Date;
import java.util.Random;

public class Sinistro{
    private final int id;
    private Date data;
    private String endereco;
    private Veiculo veiculo;
    private Cliente cliente;
    private Seguradora seguradora;

    public Sinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente, Seguradora seguradora){
        Random gerador = new Random();
        this.id = gerador.nextInt();            
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
    public Date getData(){
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
    

    public void setData(Date data){
        this.data = data;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

     public String toString(){
        String out = "";
        out += "SINISTRO: " + getCliente().getNome() + ", " + getVeiculo().getMarca() + " " + getVeiculo().getModelo() + ", " + getSeguradora().getNome() 
        + ", " + getEndereco() + ", " + getData() + ", " + getId();
        return out;
     }
}

