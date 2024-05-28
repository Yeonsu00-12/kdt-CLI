import java.util.Random;
import java.util.Scanner;

public class HangmanGameThread extends Thread {
    private JobCharacter jobCharacter;
    private HintThread hintThread;
    private String word;
    private int remainingHints;

    public HangmanGameThread(JobCharacter jobCharacter) {
        this.jobCharacter = jobCharacter;
        this.remainingHints = 2; // 힌트 사용 가능 횟수
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] words = {"java", "program", "hangman", "object", "inheritance"};
        word = words[new Random().nextInt(words.length)];
        char[] guessWord = new char[word.length()];
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = '_';
        }

        // 힌트 스레드 시작
        hintThread = new HintThread(word, this);
        hintThread.start();

        int tries = 6;
        while (tries > 0) {
            System.out.println("현재 상태: " + new String(guessWord));
            System.out.println("남은 시도 횟수: " + tries);
            System.out.println("1. 단어 입력 2. 힌트 요청");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 2) {
                if (remainingHints > 0) {
                    synchronized (hintThread) {
                        hintThread.notify(); // 힌트 스레드 깨우기
                    }
                    remainingHints--;
                    try {
                        Thread.sleep(1000); // 힌트를 읽을 수 있는 시간 제공
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("힌트를 더 이상 사용할 수 없습니다.");
                }
            } else if (choice == 1) {
                System.out.print("글자를 추측하세요: ");
                char guess = sc.nextLine().charAt(0);

                boolean correctGuess = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    tries--;
                }

                if (new String(guessWord).equals(word)) {
                    System.out.println("축하합니다! 단어를 맞췄습니다: " + word);
                    jobCharacter.gainExperience(30);
                    hintThread.interrupt(); // 힌트 스레드 중단
                    return;
                }
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }

        System.out.println("실패했습니다. 단어는: " + word);
        jobCharacter.modifyEnergy(-20);
        hintThread.interrupt(); // 힌트 스레드 중단
    }

    public synchronized char getHint() {
        Random random = new Random();
        while (true) {
            char hint = word.charAt(random.nextInt(word.length()));
            if (hint != '_') {
                return hint;
            }
        }
    }
}

