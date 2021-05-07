import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ZeroInTheEnd {

    public void zeroInTheEnd() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(",");
        int[] numbersResponse = new int[numbers.length];

        int next = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i]) != 0){
                numbersResponse[next] = Integer.parseInt(numbers[i]);
                next++;
            }
        }
        System.out.println(Arrays.toString(numbersResponse));

    }
}
