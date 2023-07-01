import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;
public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;  
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores = new ArrayList<Condutor>();
    private double valorMensal;

    public Seguro(Seguradora seguradora){
        Random randomGen = new Random();
        this.id = randomGen.nextInt();
        this.dataInicio = LocalDate.now();
        this.dataFim = dataInicio.plusYears(5);
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
    }
    public abstract void desautorizarCondutor(Condutor c);

    public abstract void autorizarCondutor(Condutor c);

    public abstract double calcularValor();

    public abstract void gerarSinistro(LocalDate data, String endereco, Condutor condutor);
    public abstract Cliente getCliente();
    
//*************************** Getters e Setters **********************************
    
    public int getId(){
        return id;
    }
    public LocalDate getDataInicio(){
        return dataInicio;
    }
    public LocalDate getDataFim(){
        return dataFim;
    }
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public ArrayList<Sinistro> getListaSinistros(){
        return listaSinistros;
    }
    public ArrayList<Condutor> getListaCondutores(){
        return listaCondutores;
    }
    public double getValorMensal(){
        return valorMensal;
    }

    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }
    public void setDataFim(LocalDate dataFim){
        this.dataFim = dataFim;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
    }
    public void setCondutor(Condutor condutor){
        this.listaCondutores.add(condutor);
    }
    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }

}
