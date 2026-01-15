import java.util.HashSet;
import java.util.Set;

public class TextUtils {
    public static int countUniqueRussianLetters(String text) {
        if (text == null) return 0;
        Set<Character> set = new HashSet<>();
        for (char ch : text.toLowerCase().toCharArray()) {
            if ((ch >= 'а' && ch <= 'я') || ch == 'ё') set.add(ch);
        }
        return set.size();
    }
}
