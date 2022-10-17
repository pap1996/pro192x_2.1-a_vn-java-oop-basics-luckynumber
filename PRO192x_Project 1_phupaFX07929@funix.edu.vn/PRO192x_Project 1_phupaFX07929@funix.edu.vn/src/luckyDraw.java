import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class luckyDraw {
    // Khởi tạo các thông số report mảng để lưu số lần đoán của mỗi lượt
    private  static ArrayList<Integer> numGuess = new ArrayList<>();
    public static void main (String args[]){
        play();
    }

    public static void play() {
        // Tạo số Lucky Number ngẫu nhiên
        Random rand = new Random() ;
        int luckyNumber = rand.nextInt(100);
        System.out.println("Bắt đầu trò chơi nào!");

        // Lấy input từ người chơi
        Scanner input = new Scanner(System.in);
        int yourGuess = input.nextInt();
        int countGuess = 1;

        // Kiểm tra input với Lucky Number
        while (yourGuess != luckyNumber) {
            if (yourGuess < luckyNumber) {
                System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
            } else {
                System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
            }
            yourGuess = input.nextInt();
            countGuess ++;
        }
        System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau "+ countGuess + " lần dự đoán.");
        numGuess.add(countGuess);

        // Xử lý phần tiếp tục chơi
        System.out.println("Bạn có muốn tiếp tục chơi không?");
        String answer = input.next();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            play();
        } else {
            report();
        }
    }

    private static void report() {
        int sumGuess = 0;
        int bestGame = 1;
        int bestGuess = numGuess.get(0);
        for (int i = 0; i < numGuess.size(); i++) {
            sumGuess += numGuess.get(i);
            if (numGuess.get(i) < bestGuess) {
                bestGame = i + 1;
                bestGuess = numGuess.get(i);
            }
        }
        System.out.println("Tổng số lượt chơi : " + numGuess.size());
        System.out.println("Tổng số lượt đoán : " + sumGuess);
        System.out.println("Số lượt đoán trung bình : " + sumGuess*1.0/numGuess.size());
        System.out.println("Lượt chơi xuất sắc nhất : lượt thứ " + bestGame + " với " + bestGuess + " lượt đoán");
    }
}
