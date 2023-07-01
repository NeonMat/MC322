public enum MenuCadastrar {
    CADASTRAR_CLIENTEPF(1),
    CADASTRAR_CLIENTEPJ(2),
    CADASTRAR_CONDUTOR(3),
    CADASTRAR_FROTA(4),
    CADASTRAR_SEGURADORA(5),
    CADASTRAR_SEGURO_PF(6),
    CADASTRAR_SEGURO_PJ(7),
    CADASTRAR_VEICULO(8),
    GERAR_SINISTRO(9),
    VOLTAR(0);

    private final int operacao;

    private MenuCadastrar(int operacao){
        this.operacao = operacao;
    }
    public static MenuCadastrar getEnum(int operacao){
        for (MenuCadastrar enum_: MenuCadastrar.values()){
            if (operacao == enum_.getOperacao()){
                return enum_;
            }
        }
        return null;
    }
    public int getOperacao() {
        return operacao;
    }
    
}
