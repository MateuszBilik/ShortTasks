import java.util.ArrayList;
import java.util.List;

class SiblingNumber {
    public int findMax(int N) {
        if (N > 100000000 || N < 1) {
            return -1;
        }
        String[] listStrings = String.valueOf(N).split("");
        List<Integer> listNumb = new ArrayList<>();
        for (String s : listStrings) {
            listNumb.add(Integer.parseInt(s));
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!listNumb.isEmpty()) {
            Integer max = 0;
            int index = 0;
            for (int i = 0; i < listNumb.size(); i++) {
                if (max < listNumb.get(i)) {
                    max = listNumb.get(i);
                    index = i;
                }
            }
            stringBuilder.append(max);
            listNumb.remove(index);
        }
        int response = Integer.parseInt(stringBuilder.toString());
        if (response > 100000000){
            return -1;
        }
        return response;
    }
}