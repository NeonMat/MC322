import java.util.ArrayList;
import java.io.*;


public class ArquivoSinistro implements I_Arquivo<Sinistro> {
    @Override
    public ArrayList<String> ler() {
        System.out.println("\nLendo Arquivo de sinistros");
        String path = "ArquivosCSV/sinistros.csv";
        ArrayList<String> dadosSinistro = new ArrayList<String>();
        File file = new File(new File(".."), path);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String inLine;
            while ((inLine = in.readLine()) != null) {
                dadosSinistro.add(inLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        dadosSinistro.remove(0);
        return dadosSinistro;
    }

    public void escrever(ArrayList<Sinistro> sinistros) {
        System.out.println("\nEscrevendo arquivo de sinistros");
        String path = "../ArquivosCSV/sinistros.csv";

        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append("ID,DATA,ENDERECO,CPF_SEGURO\n"); // Cabeçalho do arquivo

            for (Sinistro sinistro : sinistros) {
                sb.append(sinistro.getId()).append(",")
                  .append(sinistro.getData()).append(",")
                  .append(sinistro.getEndereco()).append(",")
                  .append(sinistro.getCondutor().getCpf()).append("\n");
            }

            out.write(sb.toString());
        } catch (IOException e) {
            System.err.println("Erro ao escrever arquivo de sinistros: " + e.getMessage());
        }
    }
}
