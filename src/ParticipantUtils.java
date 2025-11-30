package utils;

import people.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantUtils {
    public static List<Participant> getTopWithTies(List<Participant> participants, int topN) {
        List<Participant> result = new ArrayList<>();
        if (participants.isEmpty()) return result;

        int count = 0;
        Integer lastScore = null;
        for (Participant p : participants) {
            int sum = Arrays.stream(p.scores).sum();
            if (count < topN) {
                result.add(p);
                lastScore = sum;
                count++;
            } else if (sum == lastScore) {
                result.add(p);
            } else {
                break;
            }
        }
        return result;
    }
}
