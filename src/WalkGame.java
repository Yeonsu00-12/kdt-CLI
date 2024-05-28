import java.util.Random;
import java.util.Scanner;

public class WalkGame extends Thread {
    private Character character;
    private Clothing clothing;
    private Scanner sc;

    public WalkGame(Character character, Clothing clothing, Scanner sc) {
        this.character = character;
        this.clothing = clothing;
        this.sc = sc;
    }

    @Override
    public void run() {
        if (clothing.durability == 0) {
            System.out.println(clothing.type + "의 내구성이 다 떨어져서 더 이상 산책할 수 없습니다.");
            return;
        }

        Random rand = new Random();
        String[] events = {
                "산책 중 길을 벗어났습니다.",
                "산책 중 돌에 걸려 넘어졌습니다.",
                "산책 중 갑작스러운 비를 맞았습니다.",
                "산책 중 아무 일도 일어나지 않았습니다.",
                "산책 중 가시덤불에 걸렸습니다.",
                "산책 중 물구덩이에 빠졌습니다.",
                "산책 중 응가를 밟았습니다.",
                "산책 중 더러워졌지만 물티슈로 닦았습니다."
        };

        System.out.println("산책을 시작합니다...");

        for (int i = 0; i < 5; i++) {
            String event = events[rand.nextInt(events.length)];
            System.out.println(event);

            switch (event) {
                case "산책 중 길을 벗어났습니다.":
                    System.out.println("옷에 먼지가 묻었습니다.");
                    clothing.durability -= 5;
                    break;
                case "산책 중 돌에 걸려 넘어졌습니다.":
                    System.out.println("옷에 구멍이 났습니다.");
                    clothing.durability -= 20;
                    break;
                case "산책 중 갑작스러운 비를 맞았습니다.":
                    System.out.println("옷이 젖었습니다.");
                    clothing.durability -= 10;
                    break;
                case "산책 중 아무 일도 일어나지 않았습니다.":
                    System.out.println("옷은 멀쩡합니다.");
                    break;
                case "산책 중 가시덤불에 걸렸습니다.":
                    System.out.println("옷이 찢어졌습니다.");
                    clothing.durability -= 35;
                    break;
                case "산책 중 물구덩이에 빠졌습니다.":
                    System.out.println("옷이 젖었습니다.");
                    clothing.durability -= 15;
                    break;
                case "산책 중 응가를 밟았습니다.":
                    System.out.println("옷에서 냄새가 납니다.");
                    clothing.durability -= 50;
                    break;
                case "산책 중 더러워졌지만 물티슈로 닦았습니다." :
                    System.out.println("옷은 아무이상 없습니다.");
                    break;
            }

            if (clothing.durability < 0) {
                clothing.durability = 0;
            }

            System.out.println(clothing.type + "의 현재 내구성: " + clothing.durability);

            try {
                Thread.sleep(1500); // 잠시 대기
            } catch (InterruptedException e) {
                System.out.println("산책 중 오류가 발생했습니다.");
            }
        }

        System.out.println("산책이 끝났습니다. 옷을 확인해보세요.");
    }
}
