import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class symbol {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   // input string
        String s = reader.readLine();
        Pattern pattern = Pattern.compile("[a-z]+");                                    // creating pattern and matcher for string.
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {                                                        // if string is ok
            for (int i = 0; i < s.length(); i++) {
                // if first call of this char = last call, that char never repeated (unique). Print first unique char, then break.
                if (i == s.lastIndexOf(s.charAt(i)) && i == s.indexOf(s.charAt(i))) {
                    System.out.println(s.charAt(i));
                    break;
}}}}}