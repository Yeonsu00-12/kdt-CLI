import java.util.Scanner;

public class Payment {
    Scanner sc;
    int balance;

    Payment(Scanner sc) {
        this.sc = sc;
        this.balance = 100000; // 기본 잔액
    }

    void addFunds(int amount) {
        balance += amount;
        System.out.println("잔액이 " + amount + "원 만큼 추가되었습니다. 현재 잔액: " + balance);
    }

    void processPayment(int totalPrice) {
        System.out.println("입금할 돈을 입력해줘: ");
        int payment = sc.nextInt();
        while (payment < totalPrice) {
            int remaining = totalPrice - payment;
            System.out.println("금액이 부족해! 추가로 " + remaining + "원을 더 입금해줘");
            payment += sc.nextInt();
        }
        if (payment > totalPrice) {
            int change = payment - totalPrice;
            System.out.println("결제가 완료되었어! 거스름돈은 " + change + "원이야.");
        } else {
            System.out.println("결제가 완료되었어!");
        }
        balance -= totalPrice;
    }

    void subtractFunds(int amount) {
        balance -= amount;
        System.out.println("잔액이 " + amount + "원 만큼 차감되었습니다. 현재 잔액: " + balance);
    }
}