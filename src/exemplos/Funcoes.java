package exemplos;

import java.util.function.Function;

public class Funcoes {

    public static void main(String[] args) {
        Function<String, String> retornaInversoString = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> retornaInteiroDobrado = texto -> Integer.valueOf(texto) * 2;

        System.out.println(retornaInversoString.apply("João"));
        System.out.println(retornaInteiroDobrado.apply("12500"));
    }
}
