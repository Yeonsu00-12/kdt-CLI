import java.util.Scanner;

public class DocumentReview extends Thread {
    private JobCharacter jobCharacter;

    public DocumentReview(JobCharacter jobCharacter) {
        this.jobCharacter = jobCharacter;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] documents = {
                "프로그램의 목표를 명확히 설명합니다.",
                "코드의 가독성을 높이기 위해 주석을 달아야 합니다.",
                "변수명을 이해하기 쉽게 정합니다.",
                "테스트 케이스를 충분히 작성해야 합니다."
        };
        String[] mistakes = {
                "프로그램의 목표를 명확히 설명한다.",
                "코드의 가독성을 높이기 위해 주석을 달아야 한다.",
                "변수명을 이해하기 쉽게 정해야 한다.",
                "테스트 케이스를 충분히 작성한다."
        };
        int score = 0;

        for (int i = 0; i < documents.length; i++) {
            System.out.println("문서를 검토하세요: " + documents[i]);
            System.out.print("문서에 틀린 부분이 있습니까? (Y/N): ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.print("틀린 부분을 고치세요: ");
                String correction = sc.nextLine();
                if (correction.equals(mistakes[i])) {
                    score++;
                }
            }
        }

        if (score >= 2) {
            System.out.println("축하합니다! 문서 작성 테스트를 통과했습니다.");
            jobCharacter.gainExperience(15);
        } else {
            System.out.println("문서 작성 테스트에 실패했습니다.");
            jobCharacter.modifyEnergy(-10);
        }
    }
}
