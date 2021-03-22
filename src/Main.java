public class Main {

    public static void main(String[] args) {

        String list = "Thu 01:00-23:00 Tue 01:00-23:00 Wed 01:00-23:00 Fri 01:00-23:00 Sat 01:00-23:00 Sun 01:00-21:00 Mon 01:00-23:00";

        System.out.println(new Break().maxBreak(list));
    }
}
