package academia;

import java.util.Objects;

public class Membro {
    private char tipoMembro;
    private int NumMembro;
    private String nome;
    private double mensalidade;

    public Membro(char tipoMembro, int NumMembro, String nome, double mensalidade) {
        this.tipoMembro = tipoMembro;
        this.NumMembro = NumMembro;
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public char getTipoMembro() {
        return tipoMembro;
    }

    public int getNumMembro() {
        return NumMembro;
    }

    public String getNome() {
        return nome;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    @Override
    public String toString() {
        return tipoMembro + ", " + NumMembro + ", " + nome + ", " + mensalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return NumMembro == membro.NumMembro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumMembro);
    }
}
