import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org. "
                    + "Also, you can reach sales at sales@my-domain.co.in";

        String regex = "[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
