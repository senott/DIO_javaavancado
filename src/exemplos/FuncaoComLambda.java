package exemplos;

public class FuncaoComLambda {
    public static void main(String[] args) {
        Funcao colocarPrefixoSr = valor -> "Sr. " + valor;
        System.out.println(colocarPrefixoSr.gerar("João"));
    }
}
