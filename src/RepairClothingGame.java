import java.util.Random;
import java.util.Scanner;

public class RepairClothingGame extends Thread {
    private Clothing clothing;
    private Scanner sc;

    public RepairClothingGame(Clothing clothing, Scanner sc) {
        this.clothing = clothing;
        this.sc = sc;
    }

    @Override
    public void run() {
        if (clothing.durability == 100) {
            System.out.println(clothing.type + "의 내구성이 이미 최대치입니다.");
        } else {
            System.out.println(clothing.type + "을(를) 수리하려면 숫자 맞추기 게임을 완료해야 합니다. 1부터 10 사이의 숫자를 맞춰보세요.");
            Random rand = new Random();
            int correctNumber = rand.nextInt(10) + 1;
            boolean isRepaired = false;

            for (int i = 0; i < 3; i++) {
                System.out.println("숫자를 입력하세요: ");
                int userGuess = sc.nextInt();
                sc.nextLine();
                if (userGuess == correctNumber) {
                    System.out.println("맞췄습니다! " + clothing.type + "이(가) 수리되었습니다.");
                    clothing.repair();
                    isRepaired = true;
                    break;
                } else if (userGuess < correctNumber) {
                    System.out.println("입력한 숫자가 정답보다 작습니다.");
                } else {
                    System.out.println("입력한 숫자가 정답보다 큽니다.");
                }
            }
            if (!isRepaired) {
                System.out.println("기회를 모두 사용했습니다. 옷 수리에 실패하셨습니다.");
            }
        }
    }
}