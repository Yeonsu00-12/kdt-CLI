public class CharacterActionThread extends Thread {
    public void run() {
        try {
            String[] frames = {
                    "캐릭터가 생성되고 있습니다. [■□□□□□□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■□□□□□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■□□□□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■□□□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■□□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■■□□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■■■□□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■■■■□□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■■■■■□]",
                    "캐릭터가 생성되고 있습니다. [■■■■■■■■■■]"
            };

            for (String frame : frames) {
                System.out.print("\r" + frame);
                Thread.sleep(500);
            }
            System.out.println("\n캐릭터 생성이 완료되었습니다!");
        } catch (InterruptedException e) {
            System.out.println("캐릭터 생성 스레드가 중단되었습니다.");
        }
    }
}
