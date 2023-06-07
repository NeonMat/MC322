import java.time.LocalDate;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(Seguradora seguradora, 
                        Veiculo veiculo, ClientePF cliente){
        
        super(seguradora);
        this.cliente = cliente;
        this.veiculo = veiculo; 
        super.setValorMensal(this.calcularValor());

    }
    public void autorizarCondutor(Condutor c){
        for (Condutor condutor : super.getListaCondutores()){
            if (condutor.equals(c)){
                break;
            }
        }
        this.getListaCondutores().add(c);
    }
    public void desautorizarCondutor(Condutor c){
        
        for(int i = 0; i < (super.getListaCondutores().size()); i ++){
            if(super.getListaCondutores().get(i).getCpf().equals(c.getCpf())){
                super.getListaCondutores().remove(i);
                System.out.println("\nCondutor de CPF #" + super.getListaCondutores().get(i).getCpf() + " desautorizado.");
                break;
            }
        }
        System.out.println("\nErro: Condutor não pode ser desautorizado, porque não está entre os condutores autorizados.");
    }
    public void gerarSinistro(LocalDate data, String endereco, Condutor condutor){
        Sinistro s =  new Sinistro(data, endereco, condutor, this);
        super.getListaSinistros().add(s);
    }
    public double calculaFatorIdade(){
        return 1.0;
    }
    public double calcularValor(){
        int VALOR_BASE = 10;
        double FATOR_IDADE = this.calculaFatorIdade();
        double numSinistros = 0.0;
        for(Condutor condutor: super.getListaCondutores()){
            numSinistros += condutor.getListaSinistros().size();
        }
        double valor = (VALOR_BASE * FATOR_IDADE * (1.0 + 1.0/(double)(this.cliente.getListaVeiculos().size() + 2.0)) *
                        (2.0 + (double)(super.getListaSinistros().size())/10.0) *
                        (5.0 + (double)(numSinistros)/10.0)
                        );
        return valor;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public ClientePF getCliente(){
        return cliente;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public void setCliente(ClientePF cliente){
        this.cliente = cliente;
    }
    
}
