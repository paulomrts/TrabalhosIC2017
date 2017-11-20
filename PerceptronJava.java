import java.util.*;

public class PerceptronJava {

	double[] pesos;
	double limite;
	
	public void Treinamento(double [][] input_data, int[] output_data, double rate, double epoca, double limite) {
		this.limite = limite;
		int x = input_data[0].length;
		int p = output_data.length;
		/*Sorteio aleatorio de pesos*/
		pesos = new double [x];
		Random n = new Random();
		
		for(int i=0; i<x;i++) {	
			pesos[i]=n.nextDouble();
		}
		for(int i=0; i<epoca;i++) {
			int erro_total = 0;
			for(int j=0;j<epoca;j++) {
				int saida = Saida(input_data[j]);
				int erro = output_data[j]-saida;
				erro_total += erro;
					for(int k=0;k<x;k++) {
						double alfa = rate * input_data[j][k] * erro_total;
						pesos[k] += alfa;
					}
			}
		}
		
	}
	
		public int Saida(double[] input_data) {
			double soma = 0;
			for(int i=0; i<input_data.length;i++) {
				soma+=pesos[i]*input_data[i];
			}
			if(soma>limite)
				return 1;
			else
				return 0;
		}
			
}


