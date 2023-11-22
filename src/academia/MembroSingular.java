package academia;

public class MembroSingular extends Membro {
    private int clube;

    public MembroSingular(char tipoMembro, int NumMembro, String nome, double mensalidade, int clube) {
        super(tipoMembro, NumMembro, nome, mensalidade);
        this.clube = clube;
    }

    public int getClube() {
        return clube;
    }

    public void setClube(int clube) {
        this.clube = clube;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + clube;
    }
}
