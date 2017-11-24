
public class Perceptron {
		
		int[][] input_data = new int[4][3];

	    double[] weight = new double[3]; 
	    double theta = 0;
	    int max_int = 1000;
	    int sum = 0;
	    double learning_rate=0.5;
	    
	  Perceptron() {
		/*valores inicias da matriz = dados de entrada da porta logica and*/  
	    this.input_data[0][0] = 0; 
	    this.input_data[0][1] = 0;
	    this.input_data[0][2] = 0; // valor de saida esperado

	    this.input_data[1][0] = 0;
	    this.input_data[1][1] = 1;
	    this.input_data[1][2] = 0; // valor de saida esperado

	    this.input_data[2][0] = 1; 
	    this.input_data[2][1] = 0; 
	    this.input_data[2][2] = 0; // valor de saida esperado

	   
	    this.input_data[3][0] = 1; 
	    this.input_data[3][1] = 1; 
	    this.input_data[3][2] = 1;// valor de saida esperado

	    weight[0] = 0;
	    weight[1] = 0;
	    weight[2]= 0;

	}
	  //função de ativação
	    int activation(int x1, int x2) {

	       
	       theta = (x1 * weight[0]) + (x2 * weight[1]) + (weight[2]);

	        if (theta > 0) {
	            return 1;
	        }
	        return 0;
	    }

	  //Treinamento do algoritmo
	    public void trainning() {

	        boolean trained= true;
	        int saida;

	        for (int i = 0; i < 4; i++) {
	            saida = activation(input_data[i][0], input_data[i][1]);
	            if (saida != input_data[i][2]) { 
	                weightUpdate(i, saida);
	                trained = false;
	            }
	        }
	        this.sum++;

	        if((trained == false) && (this.sum< this.max_int)) {
	            trainning();
	        }

	    }    
	    // Atualizacao de valores dos pesos
	    void weightUpdate(int i, int saida) {

	    	weight[0] = weight[0] + ((input_data[i][2] - saida) * input_data[i][0]*learning_rate);
	    	weight[1] = weight[1] + ( (input_data[i][2] - saida) * input_data[i][1]*learning_rate);
	    	weight[2] = weight[2] + ( (input_data[i][2] - saida)*learning_rate);

	    }

	    void print() {

	    		System.out.println( "==== AND Logical Gate ===");
	        System.out.println("0 e 0 = " + activation(0, 0));
	        System.out.println("0 e 1 = " + activation(0, 1));
	        System.out.println("1 e 0 = " + activation(1, 0));
	        System.out.println("1 e 1 = " + activation(1, 1));
	        System.out.println( "=========================");

	    }

	    public static void main(String[] arguments) {

	        Perceptron p = new Perceptron();
	        p.trainning();
	        p.print();

	    }
	}
