import java.util.Scanner;

public class Mutest {
    public static void main(String[] args) {
        Mutest mutest = new Mutest();
        mutest.printTable(5, 6);


    }


    public void printTable(int n, int m) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        StringBuilder builder3 = new StringBuilder();
        String h = "+---";
        String s = "|";
        String spaces = "   ";
        String line = "\n";

        for (int i = 1; i <= m; i++) {
            builder1.append(h);
            builder2.append(s).append(spaces);
            if (i == m) {
                builder1.append("+").append(line);
                builder2.append(s).append(line);
            }
        }

        for (int i = 1; i <= n; i++) {
            builder3.append(builder1).append(builder2);
            if (i == n) {
                builder3.append(builder1);
            }
        }
        System.out.println(builder3);

    }
}
