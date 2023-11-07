import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};

        for (int tamanho : tamanhos) {
            long tempoExecucaoTotal = 0;
            long trocasTotal = 0;
            long comparacoesTotal = 0;

            for (int execucao = 0; execucao < 5; execucao++) {
                int[] arr = gerarVetorAleatorio(tamanho);
                long startTime = System.nanoTime();
                long[] resultados = quickSort(arr, 0, tamanho - 1);
                long endTime = System.nanoTime();

                tempoExecucaoTotal += (endTime - startTime);
                trocasTotal += resultados[0];
                comparacoesTotal += resultados[1];
            }

            long tempoExecucaoMedio = tempoExecucaoTotal / 5;
            long trocasMedias = trocasTotal / 5;
            long comparacoesMedias = comparacoesTotal / 5;

            System.out.println("Tamanho: " + tamanho);
            System.out.println("Tempo Médio de Execução (nanossegundos): " + tempoExecucaoMedio);
            System.out.println("Trocas Médias: " + trocasMedias);
            System.out.println("Comparações Médias: " + comparacoesMedias);
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt(1000); // Gere números inteiros aleatórios entre 0 e 999
        }
        return arr;
    }

    public static long[] quickSort(int[] arr, int baixo, int alto) {
        long trocas = 0;
        long comparacoes = 0;

        if (baixo < alto) {
            int indicePivo = particionar(arr, baixo, alto);
            long[] resultadosEsquerda = quickSort(arr, baixo, indicePivo - 1);
            long[] resultadosDireita = quickSort(arr, indicePivo + 1, alto);

            trocas = resultadosEsquerda[0] + resultadosDireita[0] + indicePivo - baixo + alto - indicePivo;
            comparacoes = resultadosEsquerda[1] + resultadosDireita[1] + alto - baixo;
        }

        return new long[]{trocas, comparacoes};
    }

    public static int particionar(int[] arr, int baixo, int alto) {
        int pivo = arr[alto];
        int i = (baixo - 1);

        for (int j = baixo; j < alto; j++) {
            if (arr[j] < pivo) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }
}
