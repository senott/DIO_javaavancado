package exemplos;

public class FuncaoAltaOrdem {

    public static void main(String[] args) {
        Calculo soma = (a, b) -> a + b;
        Calculo subtracao = (a, b) -> a - b;
        Calculo multiplicacao = (a, b) -> a * b;
        Calculo divisao = (a, b) -> a / b;


        System.out.println(executarOperacao(soma, 1, 3));
        System.out.println(executarOperacao(subtracao, 147, 3));
        System.out.println(executarOperacao(multiplicacao, 9, 3));
        System.out.println(executarOperacao(divisao, 30, 3));

    }

    public static int executarOperacao(Calculo calculo, int a, int b) {
        return calculo.calcular(a, b);
    }

}

@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}
