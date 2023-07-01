import java.util.ArrayList;
import java.io.*;

public class ArquivoSeguro implements I_Arquivo<Seguro> {
    private final String path = "ArquivosCSV/seguros.csv";

    @Override
    public ArrayList<String> ler() {
        ArrayList<String> dadosSeguros = new ArrayList<>();
        return dadosSeguros;
    }

    @Override
    public void escrever(ArrayList<Seguro> seguros) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            for (Seguro seguro : seguros) {
                StringBuilder sb = new StringBuilder();
                sb.append(seguro.getId()).append(",")
                  .append(seguro.getDataInicio()).append(",")
                  .append(seguro.getDataFim()).append(",")
                  .append(seguro.getSeguradora().getNome()).append(",")
                  .append(seguro.getValorMensal()).append(",");
                
                // Escreve informações específicas do SeguroPF
                if (seguro instanceof SeguroPF) {
                    SeguroPF seguroPF = (SeguroPF) seguro;
                    sb.append(seguroPF.getVeiculo().getPlaca()).append(",")
                      .append(seguroPF.getCliente().getCpf());
                }
               // Escreve informações específicas do SeguroPJ
                else{
                    SeguroPJ seguroPJ = (SeguroPJ) seguro;
                    sb.append(seguroPJ.getFrota().getCode()).append(",")
                        .append(seguroPJ.getCliente().getCnpj());
                }
                
                String linha = sb.toString();
                out.write("\n" + linha);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
