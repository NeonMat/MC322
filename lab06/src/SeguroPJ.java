import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(Seguradora seguradora,
         Frota frota, ClientePJ cliente){
        super(seguradora);
        this.frota = frota;
        this.cliente = cliente;
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
    public double calcularValor(){
        int VALOR_BASE = 10;
        double numSinistros = 0.0;
        for(Condutor condutor: super.getListaCondutores()){
            numSinistros += condutor.getListaSinistros().size();
        }
        Period periodoFundacao = Period.between(cliente.getDataFundacao(), LocalDate.now());
        double anosPosFundacao = periodoFundacao.getYears();
        double valor = (VALOR_BASE * (10.0 + (double)(cliente.getQtdeFuncionarios())/10.0) *
                        (1.0 + 1.0/(double)(this.frota.getListaVeiculos().size() + 2.0)) *
                        (1.0 + 1.0/(double)(anosPosFundacao+2.0)) *
                        (2.0 + (double)(super.getListaSinistros().size())/10.0) *
                        (5.0 + (double)(numSinistros)/10.0)
                        );
        return valor;
    }
    public Frota getFrota(){
        return frota;
    }
    public ClientePJ getCliente(){
        return cliente;
    }
    public void setFrota(Frota frota){
        this.frota = frota;        
    }
    public void setCliente(ClientePJ cliente){
        this.cliente = cliente;
    }
    
}
