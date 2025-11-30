import cat.Cat;
import fraction.Fraction;
import fraction.Fractionable;
import list.ListMerger;
import meow.Meowable;
import people.Participant;
import people.PersonNumber;
import point.Point;
import point.Polyline;
import queue.QueueBuilder;
import set.RussianLetterCounter;
import utils.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        // --- Задание 1: Fraction + кэш ---
        System.out.println("Задание 1: Fraction");
        Fractionable f1 = new Fraction(1, 2);
        Fractionable f2 = new Fraction(2, 4);
        Fractionable f3 = new Fraction(-3, -6);

        System.out.println("f1 = " + f1 + " -> " + f1.getValue());
        System.out.println("f2 = " + f2 + " -> " + f2.getValue());
        System.out.println("f3 = " + f3 + " -> " + f3.getValue());

        System.out.println("f1.equals(f2)? " + f1.equals(f2));
        System.out.println("f1.equals(f3)? " + f1.equals(f3));

        f1.setNumerator(3);
        f1.setDenominator(4);
        System.out.println("f1 после изменения: " + f1 + " -> " + f1.getValue());

        // --- Задание 2: Кот + мяук ---
        System.out.println("\nЗадание 2: Кот и мяук");
        Cat cat = new Cat("Барсик");
        MeowCounter counter = new MeowCounter(() -> System.out.println(cat.name + ": мяу!"));
        MeowUtils.makeAllMeow(counter, counter, counter);
        System.out.println("Кот мяукал " + counter.getCount() + " раз(а)");

        // --- Задание 3: Слияние списков ---
        System.out.println("\nЗадание 3: Слияние списков");
        ListMerger lm = new ListMerger(Arrays.asList(1,3,5,9), Arrays.asList(2,4,6,9));
        List<Integer> merged = lm.merge();
        System.out.println("Merged: " + merged);

        // --- Задание 4: Многоборье (из файла) ---
        System.out.println("\nЗадание 4: Многоборье");
        List<Participant> participants = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of("C://Users//user//IdeaProjects//5//src//mnogo.txt"));
        for (String line : lines) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 6) continue;
            String lastName = parts[0], firstName = parts[1];
            int[] scores = new int[4];
            try { for (int i = 0; i < 4; i++) scores[i] = Integer.parseInt(parts[i+2]); }
            catch (NumberFormatException e) { continue; }
            participants.add(new Participant(lastName, firstName, scores));
        }
        participants.sort(Comparator.comparingInt((Participant p)->Arrays.stream(p.scores).sum()).reversed());
        List<Participant> topList = ParticipantUtils.getTopWithTies(participants, 3);
        for (Participant p : topList) System.out.println(p.lastName + " " + p.firstName + " - " + Arrays.stream(p.scores).sum());

        // --- Задание 5: Русские буквы (из файла) ---
        System.out.println("\nЗадание 5: Русские буквы");
        String text = Files.readString(Path.of("C://Users//user//IdeaProjects//5//src//text.txt"));
        int uniqueCount = TextUtils.countUniqueRussianLetters(text);
        System.out.println("Текст: " + text);
        System.out.println("Количество различных букв: " + uniqueCount);

        // --- Задание 6: Очередь ---
        System.out.println("\nЗадание 6: Очередь");
        Queue<Integer> queue = QueueUtils.buildSymmetricQueue(Arrays.asList(1,2,3));
        System.out.println("Очередь: " + queue);

        // --- Задание 7.1: Polyline ---
        System.out.println("\nЗадание 7.1: Polyline");
        Point[] pts = { new Point(1,-2), new Point(3,4), new Point(2,-1), new Point(1,-2), new Point(5,-3) };
        Point[] processed = Arrays.stream(pts)
                .map(p -> new Point(p.x, Math.abs(p.y)))
                .distinct()
                .toArray(Point[]::new);
        Arrays.sort(processed, Comparator.comparingDouble(p -> p.x));
        Polyline polyline = new Polyline(processed);
        System.out.println(polyline);

        // --- Задание 7.2: Группировка по номеру (из файла) ---
        System.out.println("\nЗадание 7.2: Группировка по номеру");
        List<PersonNumber> people = new ArrayList<>();
        List<String> pnLines = Files.readAllLines(Path.of("C://Users//user//IdeaProjects//5//src//name.txt"));
        for (String line : pnLines) {
            if (line.isBlank()) continue;
            String[] parts = line.split(":");
            String name = StringUtils.capitalize(parts[0].trim());
            Integer number = parts.length > 1 && !parts[1].isBlank() ? Integer.parseInt(parts[1].trim()) : null;
            people.add(new PersonNumber(name, number));
        }
        Map<Integer, List<String>> grouped = people.stream()
                .filter(p -> p.number != null)
                .collect(Collectors.groupingBy(p -> p.number, LinkedHashMap::new, Collectors.mapping(p -> p.name, Collectors.toList())));
        System.out.println("Группировка: " + grouped);
    }
}
