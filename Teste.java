
public class Teste {

    public static void main(String[] args) {
    	
        PerceptronJava p = new PerceptronJava();
        double input_data[][] = {{0,0},{0,1},{1,0},{1,1}};
        /* Vetor de saidas desejadas*/
        int output_data[] = {0,0,0,1};

        p.Treinamento(input_data, output_data,0.1, 0.01, 2000);
        System.out.println(p.Saida(new double[]{0,0}));
        System.out.println(p.Saida(new double[]{0,1}));
        System.out.println(p.Saida(new double[]{1,0}));
        System.out.println(p.Saida(new double[]{1,1}));

    }

}
