package people;

import java.util.Arrays;

public class Participant {
    public String lastName;
    public String firstName;
    public int[] scores; // 4 элементов

    public Participant(String lastName, String firstName, int[] scores) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + Arrays.toString(scores);
    }
}
