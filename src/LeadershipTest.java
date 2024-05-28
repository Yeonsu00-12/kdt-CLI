import java.util.Scanner;

public class LeadershipTest extends Thread {
    private JobCharacter jobCharacter;

    public LeadershipTest(JobCharacter jobCharacter) {
        this.jobCharacter = jobCharacter;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "팀원들이 의견을 나눌 수 있는 시간을 주나요? (Y/N)",
                "팀원들이 어려움을 겪을 때 도움을 주나요? (Y/N)",
                "팀원들에게 피드백을 자주 주나요? (Y/N)",
                "팀원들의 의견을 경청하나요? (Y/N)"
        };
        int score = 0;

        for (String question : questions) {
            System.out.println(question);
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                score++;
            }
        }

        if (score >= 3) {
            System.out.println("축하합니다! 리더십 테스트를 통과했습니다.");
            jobCharacter.gainExperience(20);
        } else {
            System.out.println("리더십 테스트에 실패했습니다.");
            jobCharacter.modifyEnergy(-15);
        }
    }
}
