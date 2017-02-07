import java.util.*;

class RadixSort {
    
    // retorna o valor maximo do vetor
    private static int getMax(int vector[]){
        int max = vector[0];
        for (int i = 1; i < vector.length; i++) 
            if (vector[i] > max) 
                max = vector[i];
        return max;
    }
 
    //Faz contagem de acordo com o dígito representado por exp.
    //
    private static void countingSort(int vector[], int exp){
        int size = vector.length;
        int sorted[] = new int[size]; // sorted vector
        int count[] = new int[10];
        Arrays.fill(count,0); //preenche com zeros
 
        // armazena acumulador de ocorrencia de digitos em count[]
        // (vector[i]/exp)%10 -> Recupera o digito atual da iteracao
        for (int i = 0; i < size; i++)
            count[ (vector[i]/exp)%10 ]++;
 
        // Acumulador para conter posicao ordenada autal do digito
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Ordena o vetor de acordo com o digito atual da iteracao
        for (int i = size - 1; i >= 0; i--){
            sorted[ count[(vector[i]/exp)%10] - 1 ] = vector[i];
            count[ (vector[i]/exp)%10 ]--;
        }
 
        //copia o array com os digitos atuais da iteracao ordenados
        for (int i = 0; i < size; i++)
            vector[i] = sorted[i];      

    }
 
    // main
    public static void sort(int vector[]){
        // Encontrar o valor max para saber o numero de digitos
        int max = getMax(vector);
 
        // Ordenar countingSort para cada digito.
        // Caso chegue no fim do digito de maior valor, fim do laco
        // exp eh 10^i e i corresponde ao digito da iteracao atual
        
        for (int exp = 1; max/exp > 0; exp *= 10)
            countingSort(vector, exp);
    }
}