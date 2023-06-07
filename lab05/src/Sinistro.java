
import java.time.LocalDate;
import java.util.Random;

public class Sinistro{
    private final int id;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro){
        Random gerador = new Random();
        this.id = gerador.nextInt();            
        this.data = data;
        this.endereco = endereco;
        this.seguro = seguro;

    }
    
    public int getId(){
        return id;
    }
    public LocalDate getData(){
        return data;
    }
    public String getEndereco(){
        return endereco;
    }
    public Seguro getSeguro(){
        return seguro;
    }
    public Condutor getCondutor(){
        return condutor;
    }
    

    public void setData(LocalDate data){
        this.data = data;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setSeguro(Seguro seguro){
        this.seguro = seguro;
    }
    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }

     public String toString(){
        String out = "";
        out += "\nSINISTRO: " + 
                    "\n\t ID: " + getId() + 
                    "\n\t Condutor: " + getCondutor().getNome() +
                    "\n\t Seguro de ID: " + getSeguro().getId() + 
                    "\n\t Endereco: " + getEndereco() + 
                    "\n\t Data: " + getData();
        return out;
     }
}

