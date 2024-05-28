public class HintThread extends Thread {
    private String word;
    private HangmanGameThread hangmanGameThread;

    public HintThread(String word, HangmanGameThread hangmanGameThread) {
        this.word = word;
        this.hangmanGameThread = hangmanGameThread;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    wait(); // 힌트 요청 대기
                }
                char hint = hangmanGameThread.getHint();
                System.out.println("힌트: 단어에 '" + hint + "'가 포함되어 있습니다.");
            }
        } catch (InterruptedException e) {
            System.out.println("힌트 스레드가 종료되었습니다.");
        }
    }
}
