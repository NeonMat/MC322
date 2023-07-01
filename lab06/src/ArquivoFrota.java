import java.util.ArrayList;
import java.io.*;

public class ArquivoFrota implements I_Arquivo<Frota> {
    private final String path = "ArquivosCSV/frotas.csv";

    @Override
    public ArrayList<String> ler() {
        System.out.println("\nLendo Arquivo de frotas");
        ArrayList<String> dadosFrotas = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String inLine;
            while ((inLine = in.readLine()) != null) {
                dadosFrotas.add(inLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        dadosFrotas.remove(0); // Remove cabeçalho dos dados
        return dadosFrotas; // Cada String na lista são os dados de uma frota conforme o cabeçalho
    }

    @Override
    public void escrever(ArrayList<Frota> frotas) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            StringBuilder sb = new StringBuilder();
            for (Frota frota : frotas) {
                sb.append(frota.getCode()).append(",");
                
                if(frota.getListaVeiculos().size() > 2){
                    sb.append(frota.getListaVeiculos().get(0).getPlaca()).append(",")
                        .append(frota.getListaVeiculos().get(1).getPlaca()).append(",")
                        .append(frota.getListaVeiculos().get(2).getPlaca()).append(",");                
                    
                    out.write("\n" + sb);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
