import java.util.ArrayList;
import java.io.*;


public class ArquivoVeiculo implements I_Arquivo<Veiculo> {
    private final String path = "ArquivosCSV/veiculos.csv";

    @Override
    public ArrayList<String> ler() {
        System.out.println("\nLendo Arquivo de veículos");
        ArrayList<String> dadosVeiculos = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String inLine;
            while ((inLine = in.readLine()) != null) {
                dadosVeiculos.add(inLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        dadosVeiculos.remove(0); // Remove cabeçalho dos dados
        return dadosVeiculos;
    }

    @Override
    public void escrever(ArrayList<Veiculo> veiculos) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            
            for (Veiculo veiculo : veiculos) {
                String linha = veiculo.getPlaca() + ","
                        + veiculo.getMarca() + ","
                        + veiculo.getModelo() + ","
                        + veiculo.getAnoFabricacao();
                out.write("n" + linha);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
