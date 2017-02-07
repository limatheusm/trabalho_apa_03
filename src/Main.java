import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		
		int choise = Integer.parseInt(args[0]);

        BufferedReader inReader =
                       new BufferedReader(new InputStreamReader(System.in));
        String line;
        int k = 0;
        int size = 0;

        try {

            //Lendo primeira linha, vendo tamanho do vetor e criando array
            size = Integer.parseInt(inReader.readLine());
            int[] array = new int[size];

            //Preenchendo o array
            while((line = inReader.readLine()) != null) {
                array[k] = Integer.parseInt(line);
                k++;
            }

            inReader.close();

            //Escolha do Metodo de ordenacao
            switch (choise) {
                case 1: { CountingSort.sort(array); break; }
                case 2: { BucketSort.sort(array); break; }
                case 3: { RadixSort.sort(array); break; }
  
                default: { System.err.println("Invalid Command!"); return; }
            }

            //Exibe vetor ordenado
            for (int i = 0; i < array.length; i++) 
                 System.out.println(array[i]);            

            //Verifica se esta ordenado
        	// for (int i = 0; i < array.length-1; i++)
         //    	if(array[i]>array[i+1]) System.out.println("ERRO SORTER: "+i);

        } catch (IOException e) {
            System.err.print(e.getMessage());
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
	}
}