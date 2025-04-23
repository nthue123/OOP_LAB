package hust.soict.hespi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        // Test với String concatenation (+ operator)
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Sử dụng toán tử +
        }
        System.out.println("String concatenation time: " +
                (System.currentTimeMillis() - start) + "ms");

        // Test với StringBuffer
        r = new Random(123); // Reset random với cùng seed
        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbuf.append(r.nextInt(2));
        }
        s = sbuf.toString();
        System.out.println("StringBuffer time: " +
                (System.currentTimeMillis() - start) + "ms");

        // Test với StringBuilder
        r = new Random(123); // Reset random với cùng seed
        start = System.currentTimeMillis();
        StringBuilder sbld = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sbld.append(r.nextInt(2));
        }
        s = sbld.toString();
        System.out.println("StringBuilder time: " +
                (System.currentTimeMillis() - start) + "ms");
    }
}