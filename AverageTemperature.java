
public class AverageTemperature {
	public static void main(String[] args) {

        int[] temperature = {20, 25, 22, 24, 21};
        int n = temperature.length;

        int total = 0;

        for (int i = 0; i < n; i++) {
            total = total + temperature[i];
        }

        double average = (double) total / n;

        System.out.println("Average Temperature = " + average);
    }

}
