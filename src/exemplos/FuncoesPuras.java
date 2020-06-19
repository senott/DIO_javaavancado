package exemplos;

import java.util.function.BiPredicate;

public class FuncoesPuras {

    public static void main(String[] args) {

        BiPredicate<Integer, Integer> varificarMaior = (parametro, comparacao) -> parametro > comparacao;

        System.out.println(varificarMaior.test(12, 13));
        System.out.println(varificarMaior.test(12, 13));
    }
}
