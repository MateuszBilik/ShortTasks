import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Break {

    private final int HOURSINDAY = 24;
    private final int MINUTESINHOUR = 60;
    private final int DAYSINWEEK = 7;

    public int maxBreak(String S) {
        int minutesInWeek = MINUTESINHOUR * HOURSINDAY * DAYSINWEEK;
        if (S.isEmpty()) {
            return minutesInWeek;
        }
        List<Meeting> meetings = createList(S);
        Collections.sort(meetings);
        return findMaxBreak(minutesInWeek, meetings);
    }

    private List<Meeting> createList(String S) {
        String[] rawData = S.split(" ");
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < rawData.length; i += 2) {
            int hoursFromTheBeginningOfWeek = changeNameOfDayOnNumber(rawData, i) * MINUTESINHOUR;
            String[] meetingTime = rawData[i + 1].split("-");

            String[] meetingTimeStart = meetingTime[0].split(":");
            String[] meetingTimeEnd = meetingTime[1].split(":");
            meetings.add(new Meeting(
                    hoursFromTheBeginningOfWeek +
                            Integer.parseInt(meetingTimeStart[0]) * MINUTESINHOUR +
                            Integer.parseInt(meetingTimeStart[1]),
                    hoursFromTheBeginningOfWeek +
                            Integer.parseInt(meetingTimeEnd[0]) * MINUTESINHOUR +
                            Integer.parseInt(meetingTimeEnd[1])));
        }
        return meetings;
    }

    private int findMaxBreak(int minutesInWeek, List<Meeting> meetings) {
        int maxFreeBreak = meetings.get(0).getStartFromTheBeginningOfWeek();
        int maxIndex = meetings.size() - 1;
        for (int i = 0; i < maxIndex; i++) {
            int breakBetweenMeetings =
                    meetings.get(i).getEndFromTheBeginningOfWeek() - meetings.get(i + 1).getStartFromTheBeginningOfWeek();
            if (maxFreeBreak < breakBetweenMeetings){
                maxFreeBreak = breakBetweenMeetings;
            }
        }
        int lastBreak = minutesInWeek - meetings.get(maxIndex).getEndFromTheBeginningOfWeek();
        if(maxFreeBreak < lastBreak){
            maxFreeBreak = lastBreak;
        }
        return maxFreeBreak;
    }

    private int changeNameOfDayOnNumber(String[] rawData, int i) {
        List<String> days = List.of("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        for (int j = 0; j < days.size(); j++) {
            if (rawData[i].equals(days.get(j))) {
                return j * HOURSINDAY;
            }
        }
        return -1;
    }
}

class Meeting implements Comparable<Meeting> {
    private int startFromTheBeginningOfWeek;
    private int endFromTheBeginningOfWeek;

    public Meeting(int startFromTheBeginningOfWeek, int endFromTheBeginningOfWeek) {
        this.startFromTheBeginningOfWeek = startFromTheBeginningOfWeek;
        this.endFromTheBeginningOfWeek = endFromTheBeginningOfWeek;
    }

    @Override
    public String toString() {
        return "\nMeeting{" +
                "startFromTheBeginningOfWeek=" + startFromTheBeginningOfWeek +
                ", endFromTheBeginningOfWeek=" + endFromTheBeginningOfWeek +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        int compareResult = Integer.compare(this.startFromTheBeginningOfWeek, o.startFromTheBeginningOfWeek);
        return compareResult;
    }

    public int getStartFromTheBeginningOfWeek() {
        return startFromTheBeginningOfWeek;
    }

    public int getEndFromTheBeginningOfWeek() {
        return endFromTheBeginningOfWeek;
    }
}