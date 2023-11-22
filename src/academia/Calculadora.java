package academia;

@FunctionalInterface
public interface Calculadora<C extends Number> {
    double calculaMensalidade(C numeroDoClube);
}

