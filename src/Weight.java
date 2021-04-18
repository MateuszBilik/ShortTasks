import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Weight {

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        Integer barbellWeight = 0;

        while (!weights.isEmpty()) {
            Integer max = 0;
            for (Integer i : weights) {
                if (i > max) {
                    max = i;
                }
            }
            if (maxCapacity > barbellWeight + max) {
                barbellWeight += max;
            }

            weights.remove(max);
        }
        return barbellWeight;
    }

    public static int segment(int x, List<Integer> space) {
        List<Integer> listMin = new ArrayList<>();
        for (int i = 0; i < space.size() + 1 - x; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < x; j++) {
                if (min > space.get(i + j)) {
                    min = space.get(i + j);
                }
            }
            listMin.add(min);
        }
        return Collections.max(listMin);
    }
}
