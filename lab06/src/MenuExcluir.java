public enum MenuExcluir {
    EXCLUIR_CLIENTEPF(1),
    EXCLUIR_CLIENTEPJ(2),
    EXCLUIR_CONDUTOR(3),
    EXCLUIR_FROTA(4),
    EXCLUIR_SEGURO(5),
    EXCLUIR_SEGURADORA(6),
    EXCLUIR_VEICULO(7),
    VOLTAR(0);
    private final int operacao;
    private MenuExcluir(int operacao){
        this.operacao = operacao;
    }
    public static MenuExcluir getEnum(int operacao){
        for (MenuExcluir enum_: MenuExcluir.values()){
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
