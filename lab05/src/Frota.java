import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private final int code;
    ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(){
        Random geraCode = new Random();
        this.code = geraCode.nextInt(); 
    }
    
    public boolean addVeiculo(Veiculo v){
        for (int i =0; i< listaVeiculos.size();i++){
            if (listaVeiculos.get(i) == v){
                System.out.println("\nERRO: Esse veículo já foi adicionado à Frota.");
                return false;
            }
        }
        listaVeiculos.add(v);
        System.out.println("\nVeiculo adicionado.");
        return true;
    }
    public boolean removeVeiculo(String placa){
        for (int i = 0; i < listaVeiculos.size(); i++){
            if (placa.equalsIgnoreCase(listaVeiculos.get(i).getPlaca())){
                listaVeiculos.remove(i);
                System.out.println("\nVeículo removido.");
                return true;
            }
        }
        System.out.println("\nERRO: Esse veículo não está na frota e, sendo assim, não pode ser removido.");
        return false;
    }

    //*************************** Getters e Setters **********************************

    public int getCode(){
        return code;
    }
    public ArrayList<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }

}
