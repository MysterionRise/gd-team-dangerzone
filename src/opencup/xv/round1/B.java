package opencup.xv.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

// WA 5
public class B {

    private BufferedReader br;
    private PrintWriter out;
    private StringTokenizer st;

    public B() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            a[i] = nextInt();
        }
        int m = nextInt();
        int[] b = new int[m + 1];
        for (int i = 0; i < m + 1; ++i) {
            b[i] = nextInt();
        }
        long a1 = 1L;
        long b1 = 1L * a[n];
        for (int i = n - 1; i > 0; --i) {
            long tmp = b1;
            b1 = b1 * a[i] + a1;
            a1 = tmp;
            long gcd = gcd(a1, b1);
            a1 /= gcd;
            b1 /= gcd;
        }
        if (n > 0) {
            a1 += a[0] * b1;
        }
        long a2 = 1L;
        long b2 = 1L * b[m];
        for (int i = m - 1; i > 0; --i) {
            long tmp = b2;
            b2 = b2 * b[i] + a2;
            a2 = tmp;
            long gcd = gcd(a2, b2);
            a2 /= gcd;
            b2 /= gcd;
        }
        if (m > 0) {
            a2 += b[0] * b2;
        }
        long gcd = gcd(a1, b1);
        a1 /= gcd;
        b1 /= gcd;
        gcd = gcd(a2, b2);
        a2 /= gcd;
        b2 /= gcd;
        if (b2 < 0) {
            a2 = -a2;
            b2 = -b2;
        }
        if (b1 < 0) {
            a1 = -a1;
            b1 = -b1;
        }
        if (a1 * b2 < a2 * b1) {
            out.println("<");
        } else if (a1 * b2 > a2 * b1) {
            out.println(">");
        } else {
            out.println("=");
        }
        out.println(a1 + "/" + b1);
        out.println(a2 + "/" + b2);
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
