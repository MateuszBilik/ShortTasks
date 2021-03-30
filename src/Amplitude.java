import java.util.*;

class Amplitude {

    final static int SEASONS = 4;
    List<Integer> list = new ArrayList<>();

    public String seasonWithTheGreatestAmplitude(int[] T) {
        int daysForSeason = T.length / SEASONS;
        createList(T);

        Integer winterAmplitude = amplitude(daysForSeason);
        Integer springAmplitude = amplitude(daysForSeason);
        Integer summerAmplitude = amplitude(daysForSeason);
        Integer autumnAmplitude = amplitude(daysForSeason);

        return greatestAmplitude(winterAmplitude, springAmplitude, summerAmplitude, autumnAmplitude);
    }

    private String greatestAmplitude(Integer winterAmplitude,
                                     Integer springAmplitude,
                                     Integer summerAmplitude,
                                     Integer autumnAmplitude) {
        if (winterAmplitude > springAmplitude &
                winterAmplitude > summerAmplitude &
                winterAmplitude > autumnAmplitude) {
            return Seasons.WINTER.toString();
        }
        if (springAmplitude > summerAmplitude &
                springAmplitude > autumnAmplitude) {
            return Seasons.SPRING.toString();
        }
        if (summerAmplitude > autumnAmplitude) {
            return Seasons.SUMMER.toString();
        }
        return Seasons.AUTUMN.toString();
    }

    private Integer amplitude(int daysForSeason) {
        int maxTemp = this.list.get(0);
        int minTemp = this.list.get(0);
        for (int i = 0; i < daysForSeason; i++) {
            int temp = this.list.get(0);
            if (temp > maxTemp) {
                maxTemp = temp;
            }
            if (temp < minTemp) {
                minTemp = temp;
            }
            this.list.remove(0);
        }
        return maxTemp - minTemp;
    }

    private void createList(int[] T) {
        for (int i : T) {
            this.list.add(i);
        }
    }
}

enum Seasons {
    WINTER, SPRING, SUMMER, AUTUMN
}