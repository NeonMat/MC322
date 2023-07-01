
import java.util.ArrayList;
public interface I_Arquivo<T> {
    public ArrayList<String> ler();

    public void escrever(ArrayList<T> objeto);
}
