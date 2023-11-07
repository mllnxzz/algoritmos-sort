import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        int rodadas = 5;
        
        for (int tamanho : tamanhos) {
            long tempoTotalExecucao = 0;
            long trocasTotal = 0;
            long iteracoesTotal = 0;
            
            for (int rodada = 0; rodada < rodadas; rodada++) {
                int[] array = gerarArrayAleatorio(tamanho);
                
                long inicioTempo = System.nanoTime();
                int trocas = ordenacaoShell(array);
                long fimTempo = System.nanoTime();
                
                long tempoExecucao = (fimTempo - inicioTempo) / 1000000; // Converter para milissegundos
                
                tempoTotalExecucao += tempoExecucao;
                trocasTotal += trocas;
                iteracoesTotal += tamanho; // Na ordenação Shell, o número de iterações varia
            }
            
            double tempoMedioExecucao = (double) tempoTotalExecucao / rodadas;
            double trocasMedias = (double) trocasTotal / rodadas;
            double iteracoesMedias = (double) iteracoesTotal / rodadas;
            
            System.out.println("Ordenação Shell - Tamanho do Array: " + tamanho);
            System.out.println("Tempo Médio de Execução (ms): " + tempoMedioExecucao);
            System.out.println("Trocas Médias: " + trocasMedias);
            System.out.println("Iterações Médias: " + iteracoesMedias);
            System.out.println();
        }
    }
    
    public static int ordenacaoShell(int[] array) {
        int n = array.length;
        int trocas = 0;
        
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= intervalo && array[j - intervalo] > temp; j -= intervalo) {
                    array[j] = array[j - intervalo];
                    trocas++;
                }
                array[j] = temp;
            }
        }
        
        return trocas;
    }
    
    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        Random random = new Random();
        
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(1000); // Altere o intervalo conforme necessário
        }
        
        return array;
    }
}
