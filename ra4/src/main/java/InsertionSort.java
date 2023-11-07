import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        int rodadas = 5;
        
        for (int tamanho : tamanhos) {
            long tempoTotalExecucao = 0;
            long totalTrocas = 0;
            long totalIteracoes = 0;
            
            for (int rodada = 0; rodada < rodadas; rodada++) {
                int[] array = gerarArrayAleatorio(tamanho);
                
                long horaInicio = System.nanoTime();
                int trocas = ordenacaoInsercao(array);
                long horaFim = System.nanoTime();
                
                long tempoExecucao = (horaFim - horaInicio) / 1000000;
                
                tempoTotalExecucao += tempoExecucao;
                totalTrocas += trocas;
                totalIteracoes += tamanho - 1; 
            }
            
            double mediaTempoExecucao = (double) tempoTotalExecucao / rodadas;
            double mediaTrocas = (double) totalTrocas / rodadas;
            double mediaIteracoes = (double) totalIteracoes / rodadas;
            
            System.out.println("Ordenação por Inserção - Tamanho do Array: " + tamanho);
            System.out.println("Média de Tempo de Execução (ms): " + mediaTempoExecucao);
            System.out.println("Média de Trocas: " + mediaTrocas);
            System.out.println("Média de Iterações: " + mediaIteracoes);
            System.out.println();
        }
    }
    
    public static int ordenacaoInsercao(int[] array) {
        int n = array.length;
        int trocas = 0;
        
        for (int i = 1; i < n; i++) {
            int chave = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
                trocas++;
            }
            
            array[j + 1] = chave;
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
