import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FromTo {

    public void fromTo() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] numbers = reader.readLine().split(",");
    int[] numbersInt = getInts(numbers);
    List<String> response = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
        int firstNumber = numbersInt[i];
        int nextNumber = numbersInt[i];
        while (true){
            if ((i + 1) < numbers.length) {
                if (numbersInt[i] == numbersInt[i + 1] || (numbersInt[i] + 1) == numbersInt[i + 1]) {
                    i++;
                    nextNumber = numbersInt[i];
                } else {
                    response.add(firstNumber + "->" + nextNumber);
                    break;
                }
            } else {
                response.add(firstNumber + "->" + nextNumber);
                break;
            }
        }
    }
        System.out.println(response.toString());
}

    private static int[] getInts(String[] numbers) {
        int[] numbersInt = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }
        return numbersInt;
    }
}
