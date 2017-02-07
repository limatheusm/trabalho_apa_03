class CountingSort {
	

	public static void sort(int vector[]){
		
		//busca maior elemento
		int larger = vector[0];
 		for (int i = 1; i < vector.length; i++) 
	    	if (vector[i] > larger) 
				larger = vector[i];
		
		//cria vetor count de tamanho do maior elemento do vetor a ser ordenado
		int count[] = new int[larger];
		
		//contador de ocorrencias de cada elemento
		for(int i = 0; i < vector.length; i++)
			count[ vector[i] - 1 ]++;
		
		//acumulador
		for (int i = 1; i < count.length; i++ )
			count[i] += count[i - 1];	

		//ordena saida
		int[] sorted = new int[vector.length];
		for (int i = 0; i < sorted.length; i++) {
			sorted[ count[ vector[i] - 1 ] -1] = vector[i];
			count[vector[i] - 1]--; //retirou um elemento, atualiza acumulador
		}

		//atualiza vetor de entrada
		for (int i = 0; i < sorted.length; i++) 
			vector[i] = sorted[i];
		
	}

}