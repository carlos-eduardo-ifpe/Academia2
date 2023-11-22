package academia;

public class MultiMembros extends Membro {
    private int pontosDeFidelidade;

    public MultiMembros(char tipoMembro, int NumMembro, String nome, double mensalidade, int pontosDeFidelidade) {
        super(tipoMembro, NumMembro, nome, mensalidade);
        this.pontosDeFidelidade = pontosDeFidelidade;
    }

    public int getPontosDeFidelidade() {
        return pontosDeFidelidade;
    }

    public void setPontosDeFidelidade(int pontosDeFidelidade) {
        this.pontosDeFidelidade = pontosDeFidelidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + pontosDeFidelidade;
    }
}
