import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class AppMain {
    public static void main(String[] args) throws Exception {
        Seguradora seguradora = new Seguradora("12.345.678/0001-90", "Seguradora XYZ", "(11) 1234-5678", 
                "seguradora@exemplo.com", "Rua Principal, 123");

        LocalDate dataNascimento = LocalDate.of(1990, 5, 15); // Exemplo de data de nascimento
        ClientePF clientePF = new ClientePF("Fulano", "(11) 1234-5678", "fulano@example.com", "Rua Principal, 123",
                "123.456.789-00", "Masculino", "Ensino Superior", dataNascimento);
        seguradora.cadastrarCliente(clientePF);

        ClientePJ clientePJ = new ClientePJ("Empresa XYZ", "11 9876-5432", "empresa.xyz@example.com",
                "Rua Principal, 123", "12.345.678/0001-90", LocalDate.of(2000, 5, 15), 100);
        seguradora.cadastrarCliente(clientePJ);
        
        Veiculo veiculo = new Veiculo("ABC1234", "Ford", "Focus", 2020);
        clientePF.cadastrarVeiculo(veiculo);
        
        Frota frota = new Frota();

        Veiculo veiculo1 = new Veiculo("ABC1234", "Ford", "Focus", 2020);
        Veiculo veiculo2 = new Veiculo("DEF5678", "Chevrolet", "Cruze", 2018);
        Veiculo veiculo3 = new Veiculo("GHI9012", "Volkswagen", "Golf", 2019);
        Veiculo veiculo4 = new Veiculo("JKL3456", "Toyota", "Corolla", 2021);

        frota.addVeiculo(veiculo1);
        frota.addVeiculo(veiculo2);
        frota.addVeiculo(veiculo3);
        frota.addVeiculo(veiculo4);
        clientePJ.cadastrarFrota(frota);
        seguradora.gerarSeguro(veiculo, clientePF);
        seguradora.gerarSeguro(frota, clientePJ);
        
        LocalDate dataNascimentoC = LocalDate.of(1990, 5, 15);
        Condutor condutor = new Condutor("12345678901", "João Silva", "(11) 9876-5432",
                "Rua Principal, 123", "joao.silva@example.com", dataNascimentoC);
        seguradora.getListaSeguros().get(0).autorizarCondutor(condutor);
        LocalDate dataSinistro = LocalDate.now();
        seguradora.getListaSeguros().get(1).gerarSinistro(dataSinistro, "Rua Principal, 123", condutor);

        ArquivoClientePF ioClientePF = new ArquivoClientePF();
        ArrayList<String> clientesPF = ioClientePF.ler();
        for(int i = 0; i < clientesPF.size(); i++){
            String[] listArg = clientesPF.get(i).split(",");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascimento_i = LocalDate.parse(listArg[7], dateFormat);
            seguradora.cadastrarCliente(new ClientePF(listArg[1], listArg[2], listArg[4], listArg[3], listArg[0], listArg[5], listArg[6], dataNascimento_i));
        }

        ArquivoClientePJ ioPJ = new ArquivoClientePJ();
        ArrayList<String> clientesPJ = ioPJ.ler();
        for (int i = 0; i < clientesPJ.size(); i++) {
            String[] listArg = clientesPJ.get(i).split(",");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataFundacao_i = LocalDate.parse(listArg[5], dateFormat);
            seguradora.cadastrarCliente(new ClientePJ(listArg[1], listArg[2], listArg[4], listArg[3], listArg[0], dataFundacao_i, Integer.parseInt(listArg[6])));
        }

        ArquivoVeiculo ioVeiculo = new ArquivoVeiculo();
        ArrayList<String> veiculos = ioVeiculo.ler();
        for (int i = 0; i < veiculos.size(); i++) {
            String[] listArg = veiculos.get(i).split(",");
            clientePJ.getListaFrotas().get(0).addVeiculo(new Veiculo(listArg[0], listArg[1], listArg[2], Integer.parseInt(listArg[3])));
        }

        ArquivoCondutor ioCondutor = new ArquivoCondutor();
        ArrayList<String> condutores = ioCondutor.ler();
        for (int i = 0; i < condutores.size(); i++) {
            String[] listArg = condutores.get(i).split(",");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascimento_i = LocalDate.parse(listArg[5], dateFormat);
            seguradora.getListaSeguros().get(0).autorizarCondutor(new Condutor(listArg[0], listArg[1], listArg[2], listArg[3], listArg[4], dataNascimento_i));
        }
        MenuIterativo.run();

    }
}
