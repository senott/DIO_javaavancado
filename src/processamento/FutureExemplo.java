package processamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService pessoasParaTrabalhar = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        List<? extends Future<?>> futuros = casa.obterAfazeresCasa().stream()
                .map(atividade -> pessoasParaTrabalhar.submit(atividade::realizar))
                .collect(Collectors.toList());
        pessoasParaTrabalhar.shutdown();
    }
}

class Casa {
    private List<Comodo> comodos;

    Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obterAfazeresCasa() {
        return this.comodos.stream().map(Comodo::obterAtividadesComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    void realizar();
}

abstract class Comodo {
    abstract List<Atividade> obterAtividadesComodo();
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAtividadesComodo() {
        return Arrays.asList(
                this::arrumarCama,
                this::varrerQuarto,
                this::arrumarGuardaRoupa
        );
    }

    private void arrumarGuardaRoupa() {
        System.out.println("Arrumar o guarda roupa");
    }

    private void varrerQuarto() {
        System.out.println("Varrer o quarto");
    }

    private void arrumarCama() {
        System.out.println("Arrumar a cama");
    }
}
