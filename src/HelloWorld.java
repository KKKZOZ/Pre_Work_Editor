import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloWorld {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String answer = reader.readLine();
            System.out.println(answer+"666");
        }

    }
}
