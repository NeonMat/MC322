import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ArquivoClientePF implements I_Arquivo<ClientePF>{
    @Override
    public ArrayList<String> ler(){
        System.out.println("\nLendo Arquivo de clientesPF");
        String path = "ArquivosCSV/clientesPF.csv/";
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
    
    public void escrever(ArrayList<ClientePF> clientes){
        System.out.println("\nEscrevendo arquivo de clientesPF");
        String path = "../ArquivosCSV/clientesPF.csv";
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, true))) {
            StringBuilder sb = new StringBuilder();
            
            
            for (ClientePF cliente : clientes) {
                sb.append(cliente.getCpf()).append(",")
                        .append(cliente.getNome()).append(",")
                        .append(cliente.getTelefone()).append(",")
                        .append(cliente.getEndereco()).append(",")
                        .append(cliente.getEmail()).append(",")
                        .append(cliente.getGenero()).append(",")
                        .append(cliente.getEducacao()).append(",")
                        .append(cliente.getDataNascimento()).append(",");
                if (!cliente.getListaVeiculos().isEmpty()) {
                    sb.append(cliente.getListaVeiculos().get(0).getPlaca()).append("\n");
                }
            }
            
            out.write("\n" + sb.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
        
    }
    public static void main(String[] args) {
        ArquivoClientePF io = new ArquivoClientePF();
        ArrayList<String> dadosClientes = io.ler();
        ArrayList<ClientePF> clientes = new ArrayList<>();
    
        for (String dadosCliente : dadosClientes) {
            String[] listArg = dadosCliente.split(",");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataNascimento = LocalDate.parse(listArg[7], dateFormat);
            ClientePF cliente = new ClientePF(listArg[1], listArg[2], listArg[4], listArg[3], listArg[0], listArg[5], listArg[6], dataNascimento);
            cliente.cadastrarVeiculo(new Veiculo(listArg[8], null, null, 0));
            clientes.add(cliente);
        }
    
        io.escrever(clientes);
    }
    

}