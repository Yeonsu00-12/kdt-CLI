import java.util.Scanner;

public class CommunicationGame extends Thread {
    private JobCharacter jobCharacter;

    public CommunicationGame(JobCharacter jobCharacter) {
        this.jobCharacter = jobCharacter;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "고객이 불만을 제기하면 어떻게 대응하시겠습니까? (A: 사과, B: 무시)",
                "고객의 요구사항을 잘 이해했는지 확인하시겠습니까? (A: 예, B: 아니오)",
                "고객의 피드백을 중요하게 생각하시나요? (A: 예, B: 아니오)"
        };
        int score = 0;

        for (String question : questions) {
            System.out.println(question);
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("A")) {
                score++;
            }
        }

        if (score >= 2) {
            System.out.println("축하합니다! 고객 지원 테스트를 통과했습니다.");
            jobCharacter.gainExperience(10);
        } else {
            System.out.println("고객 지원 테스트에 실패했습니다.");
            jobCharacter.modifyEnergy(-10);
        }
    }
}
