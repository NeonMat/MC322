
public abstract class Cliente{
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    
    public Cliente(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone =telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
    public String toString(){
        String out = "";
        out = "\nCLIENTE:\n" 
        + "\tNome: " + getNome() + "\n\tEndereco" +  getEndereco() + "\n\tTelefone: "+ getTelefone() +"\n\tEmail: " +  getEmail();
        return out;
    }

    //*************************** Getters e Setters **********************************
      
        public String getTelefone(){
            return telefone;
        }
        public String getEmail(){
            return email;
        }
        public String getNome (){
            return nome;
        }
        public String getEndereco (){
            return endereco;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        public void setTelefone(String telefone){
            this.telefone = telefone;
        }
        public void setEmail (String email){
            this.email = email;
        }
        public void setEndereco(String endereco){
            this.endereco = endereco;
        }
}
