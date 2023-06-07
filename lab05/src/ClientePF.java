
import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePF extends Cliente {
    
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();


    public ClientePF(String nome, String telefone, String email, String endereco, String cpf, 
                        String genero, String educacao, LocalDate dataNascimento) {
        super(nome, telefone, email, endereco);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
    }

    public boolean cadastrarVeiculo(Veiculo v){
        for (int i = 0; i < listaVeiculos.size(); i++){
            if (v.getPlaca() == listaVeiculos.get(i).getPlaca()){
                System.out.println("\nEsse veículo já foi cadastrado.");
                return false;
            }
        }       
        listaVeiculos.add(v);
        System.out.println("\nVeiculo com placa #" + v.getPlaca() + " cadastrado.");
        return true;
    }
    public boolean removerVeiculo(Veiculo v){
        for (int i = 0; i < listaVeiculos.size(); i++){
            if (v.getPlaca() == listaVeiculos.get(i).getPlaca()){
                listaVeiculos.remove(i);
                System.out.println("\nVeiculo com placa #" + v.getPlaca() + " removido.");
                return true;
            }
        }
        System.out.println("\nEsse veiculo não foi cadastrado");
        return false;
        
    }
    
    //*************************** Getters e Setters **********************************
    
    public String getCpf(){
        return cpf;
    }
    public String getGenero(){
        return genero;
    }
    public String getEducacao(){
        return educacao;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public ArrayList<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    public void setEducacao(String educacao){
        this.educacao = educacao;
    }
    
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    //@Override
    public String toString(){
        String out = "";
        out = "\nDADOS CLIENTE PESSOA FISICA: " + getNome() + " " + getCpf() + " " + getGenero()
        + " " + getEducacao() + " " + getDataNascimento() +  "\n";
        return out;
    }
    
}

