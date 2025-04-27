import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> subsetsOfSizeN(int[] S, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(S, n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] S, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < S.length; i++) {
            current.add(S[i]);
            backtrack(S, n, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static int minimoNumeroDeMoedas(int quantidade, int[] moedas) {
        Arrays.sort(moedas);
        int count = 0;
        for (int i = moedas.length - 1; i >= 0; i--) {
            while (quantidade >= moedas[i]) {
                quantidade -= moedas[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Exercício 1 - Subconjuntos:");
        int[] S1 = {1, 2, 3};
        int n1 = 2;
        List<List<Integer>> resultado1 = subsetsOfSizeN(S1, n1);
        System.out.println("Entrada: " + Arrays.toString(S1) + ", n = " + n1);
        System.out.println("Saída: " + resultado1);

        int[] S2 = {1, 2, 3, 4};
        int n2 = 1;
        List<List<Integer>> resultado2 = subsetsOfSizeN(S2, n2);
        System.out.println("Entrada: " + Arrays.toString(S2) + ", n = " + n2);
        System.out.println("Saída: " + resultado2);

        System.out.println();

        System.out.println("Exercício 2 - Troco com Algoritmo Guloso:");
        int[] moedas = {5, 2, 1};
        int quantidade = 18;
        int resultadoTroco = minimoNumeroDeMoedas(quantidade, moedas);
        System.out.println("Entrada: Quantia = " + quantidade + ", Moedas disponíveis = " + Arrays.toString(moedas));
        System.out.println("Saída: Número mínimo de moedas = " + resultadoTroco);
    }
}
