
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) throws Exception {
        Veiculo veiculo1 = new Veiculo("BRA2E19", "Mercedez",
        "Classe A", 2006);
        Veiculo veiculo2 = new Veiculo("BRA2E20","Toyota", 
        "Etios", 2013);
        DateFormat f = DateFormat.getDateInstance();
        Date dataLicenca = f.parse("16/05/2023");
        Date dataNascimento = f.parse("04/02/2002");
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        ClientePF clientepf1 = new ClientePF("Matheus", "Rua Um", 
                    listaVeiculos, "43860312863", "Masculino", 
                    dataLicenca, "Ensino Superior Incompleto", 
                    dataNascimento, "Classe Media" );
        ArrayList<Veiculo> listaVeiculos2 = new ArrayList<Veiculo>();
        Date dataFundacao = f.parse("01/01/1955");
        ClientePJ clientepj1 = new ClientePJ("Unicamp", "Campinas", listaVeiculos2, 
                                "11222333000181", dataFundacao, 20000);
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        Seguradora seguradora = new Seguradora("Porto Seguro", "11 9876-5432", "portoseguro@email.com", "Porto Seguro");
        listaSeguradoras.add(seguradora);
        clientepf1.addVeiculo(veiculo1);
        clientepj1.addVeiculo(veiculo2);
        boolean bool = false;
        bool = seguradora.cadastrarCliente(clientepf1);
        bool = seguradora.cadastrarCliente(clientepj1);
        bool = seguradora.gerarSinistro(clientepj1, dataFundacao, veiculo2);
        bool = seguradora.gerarSinistro(clientepf1, dataLicenca, veiculo1);
        seguradora.listarClientes("ClientePJ");
        seguradora.listarClientes("ClientePF");
        seguradora.visualizarSinistro("Matheus");
        seguradora.listarSinistros();
        double receita = seguradora.calcularReceita();
        for (int i = 0; i < seguradora.getListaClientes().size(); i++){    
            seguradora.calcularPrecoSeguroCliente(seguradora.getListaClientes().get(i));
        }
        receita = seguradora.calcularReceita();
        System.out.println(receita);
        MenuOperacoes.runOperacao();
        

        
    }
}
