import java.util.ArrayList;
import java.time.LocalDate;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Sinistro> listaSinistros = new ArrayList<Sinistro>();

    public Condutor (String cpf, String nome, String telefone, 
    String endereco, String email, LocalDate dataNascimento){
        this.cpf = cpf;
        this.nome= nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
    public void adicionarSinistro(Sinistro sinistro){
        for(int i =0; i < listaSinistros.size(); i++){
            if (sinistro.equals(listaSinistros.get(i))){
                System.out.println("Erro: sinistro já foi adicionado.");
                break;
            }
        }
        listaSinistros.add(sinistro);
    }

    //*************************** Getters e Setters **********************************

    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public ArrayList<Sinistro> getListaSinistros(){
        return listaSinistros;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    


}
