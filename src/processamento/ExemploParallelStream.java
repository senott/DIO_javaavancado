package processamento;

import java.util.stream.IntStream;

public class ExemploParallelStream {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach( numero -> fatorial(numero)); // Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial :: " + (fim - inicio));

        inicio = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach( numero -> fatorial(numero)); // Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel :: " + (fim - inicio));

    }

    public static long fatorial(long numero) {

        long fat = 1;

        for (long i = 2; i <= numero; i++) {
            fat *= i;
        }

        return fat;
    }
}
