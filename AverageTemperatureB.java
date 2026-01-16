
public class AverageTemperatureB {
	public static void main(String[] args) {

        int[] temperature = {20, 25, 22, 24, 21};
        int n = temperature.length;

        double sum = temperature[0];

        for (int i = 1; i < n; i++) {
            sum = sum + temperature[i];
        }

        for (int i = 0; i < n; i++) {
            sum = sum / n;
        }

        System.out.println("Result = " + sum);
    }

}
