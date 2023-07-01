import java.util.ArrayList;
import java.io.*;

public class ArquivoClientePJ implements I_Arquivo<ClientePJ>{
    @Override
    public ArrayList<String> ler(){
        System.out.println("\nLendo Arquivo de clientesPJ");
        String path = "ArquivosCSV/clientesPJ.csv/";
        ArrayList<String> dadosCliente = new ArrayList<String>();
        File file = new File(new File(".."), path);
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String inLine;
            while((inLine = in.readLine()) != null){
                dadosCliente.add(inLine);
            }
            in.close();
            
            
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
            
        }
        dadosCliente.remove(0);
        return dadosCliente;
    }
    
    public void escrever(ArrayList<ClientePJ> clientes){}

}