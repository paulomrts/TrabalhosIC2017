public class Adaline {
	
    int[][] input_data = new int[4][3];
    double[] weight = new double[3];
    double theta = 0;
    double epsilon = 0.1;
    int max_int = 1000;
    int count = 0;
    double learning_rate = 0.5;
    double SquaredError=0;
    double previousMeanSquaredError=0;
    
    Adaline() {
    	
    		/*valores inicias da matriz = dados de entrada da porta logica and*/
    	
        this.input_data[0][0] = 0; 
        this.input_data[0][1] = 0;
        this.input_data[0][2] = 0; // valor de saida esperado

        this.input_data[1][0] = 0;
        this.input_data[1][1] = 1;
        this.input_data[1][2] = 0; //valor esperado

        this.input_data[2][0] = 1;
        this.input_data[2][1] = 0;
        this.input_data[2][2] = 0; //valor esperado

        this.input_data[3][0] = 1;
        this.input_data[3][1] = 1;
        this.input_data[3][2] = 1;//valor esperado

        weight[0] = 0;
        weight[1] = 0;
        weight[2] = 0;//bias

    }
    
  //função de ativação
    double activation(int x1, int x2) {

        theta = (x1 * weight[0]) + (x2 * weight[1]) + (weight[2]);

       return Math.tanh(theta);
    }
    //Treinamento do algoritmo
    public void trainning() {
  
        double output;
        for (int i = 0; i < 4; i++) {
            output = activation(input_data[i][0], input_data[i][1]);
            sigmaMeanSquareError(i,  output);
            weightUpdate(i,output);  
        }
       
        
        if ((Math.abs(SquaredError-previousMeanSquaredError)>epsilon) && (this.count < this.max_int)) {
           previousMeanSquaredError=SquaredError;
           SquaredError=0;
           this.count++;        
           trainning();
          
        }

    }
    // calculo do erro quadratico medio
 
    double sigmaMeanSquareError(int i,double output){
       SquaredError=SquaredError+Math.pow(input_data[i][2]-output, 2);
       SquaredError=SquaredError/(i+1);
        return SquaredError;
    }
    
 // Atualizacao de valores dos pesos
    void weightUpdate(int i, double output) {

        weight[0] = weight[0] + ((input_data[i][2] - output) * input_data[i][0] * learning_rate);
        weight[1] = weight[1] + ((input_data[i][2] - output) * input_data[i][1] * learning_rate);
        weight[2] = weight[2] + ((input_data[i][2] - output) * learning_rate);
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

        Adaline p = new Adaline();
        p.trainning();
        p.print();

    }
}
