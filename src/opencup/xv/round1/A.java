package opencup.xv.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {

    private BufferedReader br;
    private PrintWriter out;
    private StringTokenizer st;
    private Scanner in;

    public A() throws IOException {
        in = new Scanner(System.in);
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public static void main(String[] args) throws IOException {
        new A().solve();
    }

    private void solve() throws IOException {
        Set<String> colors = new HashSet<>(Arrays.asList("white", "blue", "red", "gray", "green"));
        Set<String> items = new HashSet<>(Arrays.asList("Barabashka", "book", "chair", "mouse", "bottle"));
        Set<String> correctItems = new HashSet<>(Arrays.asList("white Barabashka", "blue book", "red chair", "gray mouse", "green bottle"));
        for (int i = 0; i < 5; ++i) {
            boolean flag = true;
            Set<String> existColors = new HashSet<>();
            Set<String> existItems = new HashSet<>();
            final String sentence = in.nextLine();
            List<String> tokens = new ArrayList<>();
            tokens.addAll(Arrays.asList(sentence.split("[\\s,.'-]+")));
            for (int j = 0; j < tokens.size() - 1 && flag; ++j) {
                if (colors.contains(tokens.get(j))) {
                    existColors.add(tokens.get(j));
                }
                if (colors.contains(tokens.get(j + 1))) {
                    existColors.add(tokens.get(j + 1));
                }
                if (items.contains(tokens.get(j))) {
                    existItems.add(tokens.get(j));
                }
                if (items.contains(tokens.get(j + 1))) {
                    existItems.add(tokens.get(j + 1));
                }
                String item = tokens.get(j) + " " + tokens.get(j + 1);
                if (correctItems.contains(item)) {
                    out.println(item);
                    flag = false;
                }
            }
            if (flag) {
                Set<String> missColors = new HashSet<>();
                missColors.addAll(colors);
                missColors.removeAll(existColors);
                Set<String> missItems = new HashSet<>();
                missItems.addAll(items);
                missItems.removeAll(existItems);
                final Iterator<String> cIt = missColors.iterator();
                while (cIt.hasNext() && flag) {
                    final String color = cIt.next();
                    final Iterator<String> iIt = missItems.iterator();
                    while (iIt.hasNext() && flag) {
                        final String item = iIt.next();
                        if (correctItems.contains(color + " " + item)) {
                            out.println(color + " " + item);
                            flag = false;
                        }
                    }
                }
            }
        }

        out.close();
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
