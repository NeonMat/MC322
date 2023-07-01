import java.util.ArrayList;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class ArquivoCondutor implements I_Arquivo<Condutor> {
    private final String path = "ArquivosCSV/condutores.csv";

    @Override
    public ArrayList<String> ler() {
        System.out.println("\nLendo Arquivo de condutores");
        ArrayList<String> dadosCondutores = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String inLine;
            while ((inLine = in.readLine()) != null) {
                dadosCondutores.add(inLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        dadosCondutores.remove(0); // Remove cabeçalho dos dados
        return dadosCondutores;
    }

    @Override
    public void escrever(ArrayList<Condutor> condutores) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            out.write("CPF_CONDUTOR,NOME_CONDUTOR,TELEFONE,ENDERECO,EMAIL,DATA_NASCIMENTO\n");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (Condutor condutor : condutores) {
                StringBuilder sb = new StringBuilder();
                sb.append(condutor.getCpf()).append(",")
                    .append(condutor.getNome()).append(",")
                    .append(condutor.getTelefone()).append(",")
                    .append(condutor.getEndereco()).append(",")
                    .append(condutor.getEmail()).append(",")
                    .append(condutor.getDataNascimento().format(dateFormat));

                String linha = sb.toString();

                out.write("n" + linha);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
