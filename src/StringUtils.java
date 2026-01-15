public class StringUtils {
    public static String capitalize(String s) {
        if (s == null || s.isBlank()) return s;
        s = s.toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
