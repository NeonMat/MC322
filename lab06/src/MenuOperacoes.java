public enum MenuOperacoes{
    CADASTRAR (1),
    EXCLUIR (2),
    TRANSFERIR_SEGURO (3),
    CALCULAR_RECEITA (4),
    SAIR (0);

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
    
}