import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static long naDziesietna(String s) {
        long wartosc = 0;
        for (char c : s.toCharArray()) {
            wartosc *= 3;
            if (c == '+') wartosc += 1;
            else if (c == '*') wartosc += 2;
        }
        return wartosc;
    }


    static String naSymbole(long n) {
        if (n == 0) return "o";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long r = n % 3;
            if (r == 0) sb.append('o');
            else if (r == 1) sb.append('+');
            else sb.append('*');
            n /= 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("symbole.txt"));
        List<String> napisy = new ArrayList<>();
        String linia;

        while ((linia = br.readLine()) != null) {
            napisy.add(linia.trim());
        }
        br.close();

        PrintWriter out = new PrintWriter(new FileWriter("wyniki2.txt"));

        // ===== Zadanie 1 =====
        out.println("1.");
        for (String s : napisy) {
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                out.println(s);
            }
        }


        long max = -1;
        String maxNapis = "";

        for (String s : napisy) {
            long v = naDziesietna(s);
            if (v > max) {
                max = v;
                maxNapis = s;
            }
        }

        out.println("2.");
        out.println(max);
        out.println(maxNapis);


        long suma = 0;
        for (String s : napisy) {
            suma += naDziesietna(s);
        }

        out.println("3.");
        out.println(suma);
        out.println(naSymbole(suma));

        out.close();
    }
}