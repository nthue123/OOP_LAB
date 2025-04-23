package hust.soict.hespi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Thay bằng file thật
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char)b; // Tạo garbage
        }
        System.out.println("GarbageCreator time: " +
                (System.currentTimeMillis() - startTime) + "ms");
    }
}

class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe"; // Thay bằng file thật
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char)b); // Không tạo garbage
        }
        System.out.println("NoGarbage (StringBuilder) time: " +
                (System.currentTimeMillis() - startTime) + "ms");
    }
}