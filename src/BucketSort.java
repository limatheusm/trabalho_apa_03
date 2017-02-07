import java.util.*;

class BucketSort {
	
	public static void sort(int[] vector){

		//busca maior elemento
		int larger = vector[0];
 		for (int i = 1; i < vector.length; i++) 
	    	if (vector[i] > larger) 
				larger = vector[i];

		//seta o numero dos baldes
		int numBuckets = larger / 5;

		//cria baldes - array de listas encadeadas
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>> (numBuckets);
		for(int i = 0; i < numBuckets; i++){
			//lista interna de cada balde (seu conteudo sera o conteudo de cada balde)
			ArrayList<Integer> innerBucket = new ArrayList<Integer>();
			bucket.add(innerBucket);
		}

		int currentBucket = 0;
		//Coloca os elementos no balde correto
		for (int i = 0; i < vector.length; i++) {
			currentBucket = numBuckets - 1;
			while (true){
				if(currentBucket < 0){
					 break;
				}
				if(vector[i] >= (currentBucket * 5)){
					 bucket.get(currentBucket).add(vector[i]);
					 break;
				}
				currentBucket--;
			}
		}

		//Ordena e atualiza
		int index = 0;
		for (int i = 0; i < numBuckets; i++){

			int[] aux = new int[bucket.get(i).size()];

			//Coloca cada balde em um vetor aux
			for (int j = 0; j < aux.length; j++){
					aux[j] = (Integer) bucket.get(i).get(j);
			}

			InsertionSort.sort(aux); //ordena o vetor (antigo balde)

			// Por fim, o novo vetor eh populado usando a sequencia ordenada
			for (int j = 0; j < aux.length; j++){
				vector[index] = aux[j];
				index++;
			}

		}
	}
}