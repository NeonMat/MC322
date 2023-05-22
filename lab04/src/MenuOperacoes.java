import java.util.Scanner;

public enum MenuOperacoes{
    CADASTRAR (1),
    EXLUIR (2),
    SAIR (0),
    GERAR_SINISTRO (4),
    TRANSFERIR_SEGURO (5),
    CALCULAR_RECEITA (6);

    private final int operacao;

    private MenuOperacoes(int operacao){
        this.operacao = operacao;
    }
    public int getOperacao() {
        return operacao;
    }
    public static MenuOperacoes getEnum(int operacao){
        for (MenuOperacoes enum_: MenuOperacoes.values()){
            if (operacao == enum_.getOperacao()){
                return enum_;
            }
        }
        return null;
    }
    public static boolean runOperacao(){
        Scanner input = new Scanner(System.in);
        boolean bool = true;
        while(bool){
            switch(operacao){
                case 1:
                    int subOp = input.nextInt();
                    switch(subOp){
                        case 1:
                            seguradora.cadastrarCliente(cliente);
                        case 2:
                            cliente.addVeiculo(Veiculo);
                        case 3:
// nao consegui terminar por conta de uma prova :(
                            


                    }
                    break;
                default:
                    break;
            }
        } 
    }
}