import java.util.Scanner;

public class JavaQuiz extends Thread {
    private JobCharacter jobCharacter;

    public JavaQuiz(JobCharacter jobCharacter) {
        this.jobCharacter = jobCharacter;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
                "자바의 기본 자료형이 아닌 것은? (A: int, B: float, C: String)",
                "자바에서 상속을 나타내는 키워드는? (A: extends, B: implements, C: inherit)",
                "자바에서 예외를 처리하기 위한 블록은? (A: try-catch, B: exception, C: throw-catch)"
        };
        String[] correctAnswers = {"C", "A", "A"};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }

        if (score >= 2) {
            System.out.println("축하합니다! 자바 퀴즈를 통과했습니다.");
            jobCharacter.gainExperience(25);
        } else {
            System.out.println("자바 퀴즈에 실패했습니다.");
            jobCharacter.modifyEnergy(-25);
        }
    }
}
