import java.io.IOException;
import java.io.InputStream;

class MyScanner {
    private InputStream in;
    private char c;

    MyScanner(InputStream in) {
        this.in = in;
        nextChar();
    }

    private char nextChar() {

        try {
            c = (char) in.read();
        } catch (IOException e) {
            throw new Error(e);
        }
        return c;
    }

    String nextLine() {

        StringBuilder lineBuilder = new StringBuilder();

        lineBuilder.append(String.valueOf(c));
        while (nextChar() != '\n') {
            lineBuilder.append(String.valueOf(c));
        }
        return lineBuilder.toString();
    }
/*
    private long nextLong() {
        while ('0' > c || c > '9') {
            nextChar();
        }
        long value = c - '0';
        nextChar();
        while ('0' <= c && c <= '9') {
            value *= 10;
            value += c - '0';
            nextChar();
        }
        return value;
    }

    public int nextInt() {
        long longValue = nextLong();
        return (int) longValue;
    }*/
}
