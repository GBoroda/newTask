import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Squares {
    public static void main(String[] args) throws IOException {
        int corners, answer;                                                            // numbers of corners (squares who need 6 matches)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());                                // input data
        float sqrt = (float) Math.sqrt(input);                                          // counting exponents
        int round = Math.round(sqrt);                                                   // round exponent (needed to count corners)

        if (round == sqrt)  corners = (int) (sqrt * 2) - 1;                             // if we have perfect square we remove one corner
        else corners = (int) (sqrt * 2);

        answer = (input * 4) + (corners * 2) + 2;                                       // counting final numbers of squares (+2 for first square who needed 8 matches)
        System.out.println(answer);
}}
