import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String newStr = "";

        for (int i = 0; i < str.length(); i = i + 2) {
            newStr = newStr + str.charAt(i);
        }

        System.out.println(newStr);
    }
}