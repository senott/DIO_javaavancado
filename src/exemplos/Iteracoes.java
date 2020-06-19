package exemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {

    public static void main(String[] args) {
        String[] nomes = { "João", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
        Integer[] numeros = { 1, 2, 3, 4, 5};

        imprimirNomesFiltrados(nomes);

        imprimirTodosNomes(nomes);

        imprimirDobroNumeros(numeros);

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor Front-End");
        profissoes.add("Desenvolvedor Back-End");
        profissoes.add("Analista de Sistemas");
        profissoes.add("Analista de Qualidade");
        profissoes.add("Gerente de Projetos");
        profissoes.add("Gerente de Sistemas");
        profissoes.add("Gerente de Qualidade");

        profissoes.stream().filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);
    }

    public static void imprimirNomesFiltrados(String... nomes) {

        String nomesParaImprimir = "";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("João")) {
                nomesParaImprimir += " " + nomes[i];
            }
        }

        System.out.println(nomesParaImprimir);

        String nomesParaImprimirStream = Stream.of(nomes)
                .filter(nome -> nome.equals("João"))
                .collect(Collectors.joining());

        System.out.println("-> " + nomesParaImprimirStream);

    }

    public static void imprimirTodosNomes(String... nomes) {
        for (String nome : nomes) {
            System.out.println(" - " + nome);
        }

        Stream.of(nomes)
                .forEach((nome) -> System.out.println(" -- " + nome));
    }

    public static void imprimirDobroNumeros(Integer... numeros) {

        for (Integer numero : numeros) {
            System.out.println(numero * 2);
        }

        Stream.of(numeros).map(numero -> numero * 2)
                .forEach(System.out::println);
    }
}
