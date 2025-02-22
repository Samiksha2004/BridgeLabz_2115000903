
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeats = new HashSet<>();
        while (matcher.find()) {
            repeats.add(matcher.group(1).toLowerCase());
        }

        for (String word : repeats) {
            System.out.println(word);
        }
    }
}
