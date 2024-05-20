import java.util.Random;
import java.util.Scanner;

class Character {
    String name;
    String gender;
    int age;
    static final int basic_cost = 3000; // 캐릭터 만드는 기본 비용

    Character(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("당신의 캐릭터의 이름은 " + name + "이고 성별은 " + gender + ", 나이는 " + age + "이야🩷");
    }
}

class Job extends Character {
    String jobTitle;
    String salary;

    Job(String name, String gender, int age, String jobTitle, String salary) {
        super(name, gender, age);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    void setJob(int jobChoice){
        switch (jobChoice) {
            case 1: jobTitle = "소프트웨어 개발자"; salary = "164,939,827"; break;
            case 2: jobTitle = "데이터 분석가"; salary = "95,365,440"; break;
            case 3: jobTitle = "임베디드 개발자"; salary = "129,140,700"; break;
            case 4: jobTitle = "클라우드 개발자"; salary = "182,665,878"; break;
            case 5: jobTitle = "정보보안전문가"; salary = "171,024,671"; break;
            case 6: jobTitle = "QA"; salary = "121,298,217"; break;
            case 7: jobTitle = "기획자"; salary = "105,961,600"; break;
            case 8: jobTitle = "디자이너"; salary = "122,518,100"; break;
            case 9: jobTitle = "네트워크 엔지니어"; salary = "126,194,968"; break;
            case 10: jobTitle = "DBA"; salary = "174,016,762"; break;
            default: jobTitle = "무직"; salary = "0"; break;
        }
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("직업은 " + jobTitle + "이고, 이 직업의 올해 평균 연봉이 " + salary+ "이야!!");
    }
}

class SpecialAbility extends Job {
    String specialAbility;

    SpecialAbility(String name, String gender, int age, String jobTitle, String salary) {
        super(name, gender, age, jobTitle, salary);
        this.specialAbility = assignRandomAbility();
    }

    private String assignRandomAbility() {
        String[] abilities = {"커뮤니케이션 능력", "F 같은 T","T 같은 F","개발 능력 만랩","아이디어 방출 만랩"};
        Random rand = new Random();
        return abilities[rand.nextInt(abilities.length)];
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("랜덤 뽑기@@ 특별 능력은 " + specialAbility+ "이야!");
    }
}

class Clothing {
    String type;
    String color;
    int price;

    Clothing(String type, String color) {
        this.type = type;
        this.color = color;
        this.price = setPrice(type);
    }

    protected int setPrice(String type) {
        switch (type) {
            case "티셔츠" : return 15000;
            case "후드티" : return 80000;
            case "셔츠" : return 60000;
            case "롱슬리브" : return 35000;
            default : return 5000;
        }
    }

    void displayClothingInfo() {
        System.out.println("상의는 " + type + "에 색상은 " + color + "야. 상의 가격은 " + price + "원이야!");
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "티셔츠";
            case 2: return "후드티";
            case 3: return "셔츠";
            case 4: return "롱슬리브";
            default : return "후질근 기본 티..";
        }
    }
}

class Bottom extends Clothing {
    Bottom(String type, String color) {
        super(type, color);
        this.price = setPrice(type);
    }

    @Override
    protected int setPrice(String type) {
        switch (type) {
            case "청바지": return 50000;
            case "슬랙스": return 30000;
            case "반바지": return 15000;
            case "치노팬츠": return 90000;
            default: return 10000;
        }
    }

    @Override
    void displayClothingInfo() {
        System.out.println("하의는 " + type + "이고 색상은 " + color+ "이야. 하의의 가격은 " +price +"야.");
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "청바지";
            case 2: return "슬랙스";
            case 3: return "반바지";
            case 4: return "치노팬츠";
            default : return "근본 츄리닝이 짱이지!..";
        }
    }
}

class Shoes extends Clothing {
    int size;

    Shoes(String type, String color, int size) {
        super(type, color);
        this.size = size;
        this.price = setPrice(type);
    }

    @Override
    protected int setPrice(String type) {
        switch (type) {
            case "스니커즈" : return 30000;
            case "운동화" : return 80000;
            case "로퍼" : return 100000;
            case "슬리퍼" : return 50000;
            default : return 0;
        }
    }

    @Override
    void displayClothingInfo() {
        System.out.println("신발 사이즈는 " + size + "cm 이고 신발의 가격은 " +price + "원이야.");
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "스니커즈";
            case 2: return "운동화";
            case 3: return "로퍼";
            case 4: return "슬리퍼";
            default : return "맨발 당첨ㅋ";
        }
    }
}

class Payment {
    Scanner sc;

    Payment(Scanner sc) {
        this.sc = sc;
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
    }
}

class Message {
    void displayWelcomeMessage() {
        System.out.println("╔═══*.·:·.☽✧    ✦    ✧☾.·:·.*═══╗");
        System.out.println("ㅈΓㅂΓ로 캐릭터 口ざ들øł보ブl");
        System.out.println("캐릭터 만들러 온 걸 환영해.");
        System.out.println("시작해볼래? Y/N");
        System.out.println("╚═══*.·:·.☽✧    ✦    ✧☾.·:·.*═══╝");
    }

    void displayDivider() {
        System.out.println("♪ .•*¨*•.¸¸♬✧♪ .•*¨*•.¸¸♬✧");
    }

    void displayGoodbyeMessage() {
        System.out.println("♪ .•*¨*•.¸¸♬✧♪ .•*¨*•.¸¸♬✧");
        System.out.println("이용해줘서 고마워! 다음에 또 찾아줘");
        System.out.println("Bye ~ Bye ~ Bye ~ Good Bye ~");
        System.out.println("♪ .•*¨*•.¸¸♬✧♪ .•*¨*•.¸¸♬✧");
    }
}


public class WhoAreYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Message msg = new Message();
        Payment paymentProcessor = new Payment(sc);

        msg.displayWelcomeMessage();
        String choice = sc.nextLine();

        while (choice.equalsIgnoreCase("Y")) {
            boolean isValidInput = false;
            String name = "";
            String gender = "";
            int age = 0;

            while (!isValidInput) {
                System.out.println("캐릭터의 이름은?");
                name = sc.nextLine();

                System.out.println("성별을 골라줘! 1. 남자 2. 여자");
                int genderChoice = sc.nextInt();
                sc.nextLine();
                gender = (genderChoice == 1 ? "남자" : "여자");

                System.out.println("캐릭터 나이는?");
                age = sc.nextInt();
                sc.nextLine();

                if (!name.isEmpty() && (genderChoice == 1 || genderChoice == 2) && age > 0) {
                    isValidInput = true;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                }
            }

            Character character = new Character(name, gender, age);
            character.displayInfo();
            msg.displayDivider();

            boolean isDecorateValid = false;
            int choice2 = 0;

            while (!isDecorateValid) {
                System.out.println("이제 기본적으로 캐릭터를 구성하는 건 끝났어!");
                System.out.println("이제 꾸미러 가볼까??\n 꾸미고 싶다면 1번, 그렇지 않다면 2번을 눌러줘! 만약, 다시 만들고 싶다면 3번을 눌러줘🫧");
                choice2 = sc.nextInt();
                sc.nextLine();

                switch (choice2) {
                    case 1:
                        isDecorateValid = true;
                        System.out.println("자, 그럼 본격적으로 어떤 사람이 되게 너의 캐릭터를 만들건지 설정해보자!");
                        System.out.println("작업을 골라줘!\n 1. 소프트웨어 개발자\n 2. 데이터 분석가\n 3. 임베디드 개발자\n 4. 클라우드 개발자\n 5. 정보보안전문가\n 6. QA\n 7. 기획자\n 8. 디자이너\n 9. 네트워크 엔지니어\n 10. DBA ");

                        int jobChoice = sc.nextInt();
                        sc.nextLine();

                        Job job;
                        System.out.println("특별 능력을 부여할래??? Y/N");
                        String specialAbility = sc.nextLine();
                        if (specialAbility.equalsIgnoreCase("y")) {
                            job = new SpecialAbility(name, gender, age, "", "");
                        } else {
                            job = new Job(name, gender, age,"","");
                        }
                        job.setJob(jobChoice);
                        job.displayInfo();
                        msg.displayDivider();
                        System.out.println("자, 그럼 본격적으로 어떤 옷을 입힐지 골라보자.");

                        System.out.println("상의부터 골라볼까?? \n 1. 티셔츠\n 2. 후드티\n 3. 셔츠\n 4. 롱슬리브 ");
                        int topChoice = sc.nextInt();
                        sc.nextLine();
                        String topType = Clothing.chooseType(topChoice);
                        System.out.println("색상을 입력해줘!");
                        String topColor = sc.nextLine();
                        Clothing top = new Clothing(topType, topColor);
                        top.displayClothingInfo();
                        msg.displayDivider();

                        System.out.println("하의도 골라볼까?? \n 1.청바지\n 2. 슬랙스\n 3. 반바지\n 4. 치노팬츠 ");
                        int bottomChoice = sc.nextInt();
                        sc.nextLine();
                        String bottomType = Bottom.chooseType(bottomChoice);
                        System.out.println("색상을 골라봐!");
                        String bottomColor = sc.nextLine();
                        Bottom bottom = new Bottom(bottomType, bottomColor);
                        bottom.displayClothingInfo();
                        msg.displayDivider();

                        System.out.println("마지막으로 신발 고르기! \n 1.운동화\n 2. 스니커즈\n 3. 로퍼\n 4. 슬리퍼 ");
                        int shoesChoice = sc.nextInt();
                        sc.nextLine();
                        String shoesType = Shoes.chooseType(shoesChoice);
                        System.out.println("색상을 골라봐!");
                        String shoesColor = sc.nextLine();
                        System.out.println("사이즈 선택은 !?");
                        int shoeSize = sc.nextInt();
                        sc.nextLine();
                        Shoes shoes = new Shoes(shoesType, shoesColor, shoeSize);
                        shoes.displayClothingInfo();
                        msg.displayDivider();

                        int totalPrice = Character.basic_cost + top.price + bottom.price + shoes.price;
                        top.displayClothingInfo();
                        bottom.displayClothingInfo();
                        shoes.displayClothingInfo();
                        msg.displayDivider();
                        System.out.println("캐릭터 만들기 비용은 기본 " + Character.basic_cost + ", 상의의 가격은 " + top.price + ", 하의 가격은 " + bottom.price + ", 신발 가격은 " + shoes.price + "원이야.");
                        System.out.println("너가 지불해야 할 총 금액은 " + totalPrice + "이야!");

                        paymentProcessor.processPayment(totalPrice);
                        msg.displayGoodbyeMessage();
                        break;
                    case 2:
                        int pay = Character.basic_cost;
                        System.out.println("기본 캐릭터만 만든 비용은 " + pay + "원을 입금해줘!");
                        paymentProcessor.processPayment(pay);
                        msg.displayGoodbyeMessage();
                        isDecorateValid = true;
                        break;
                    case 3:
                        System.out.println("다시 시작합니다.");
                        isDecorateValid = true;
                        break;
                    default:
                        System.out.println("올바른 선택이 아니야. 다시 선택해줘!");
                        break;
                }
            }
            if (choice2 == 3) {
                continue; // 루프의 처음으로 돌아가 다시 시작
            }
            break;
        }

        sc.close();
    }
}