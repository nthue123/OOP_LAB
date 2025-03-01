import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số thực từ người dùng
        System.out.print("Nhập số thứ nhất: ");
        double num1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập số thứ hai: ");
        double num2 = Double.parseDouble(scanner.nextLine());

        // Tính toán và hiển thị kết quả
        System.out.println("Tổng: " + (num1 + num2));
        System.out.println("Hiệu: " + (num1 - num2));
        System.out.println("Tích: " + (num1 * num2));

        // Kiểm tra số chia trước khi thực hiện phép chia
        if (num2 != 0) {
            System.out.println("Thương: " + (num1 / num2));
        } else {
            System.out.println("Không thể chia cho 0.");
        }

        scanner.close();
    }
}