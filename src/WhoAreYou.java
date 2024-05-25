import java.util.Random;
import java.util.Scanner;

interface Displayable {
    void displayInfo();
}

class Character implements Displayable {
    String name;
    String gender;
    int age;
    int health;
    int energy;
    int experience;
    static final int basic_cost = 3000; // 캐릭터 만드는 기본 비용

    Character(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.health = 100; // 기본 건강 상태
        this.energy = 100; // 기본 에너지 상태
        this.experience = 0; // 기본 경험치
    }

    void modifyHealth(int amount) {
        this.health += amount;
        if (this.health > 100) this.health = 100;
        if (this.health < 0) this.health = 0;
    }

    void modifyEnergy(int amount) {
        this.energy += amount;
        if (this.energy > 100) this.energy = 100;
        if (this.energy < 0) this.energy = 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("캐릭터 이름: " + name + " 성별: " + gender + " 나이: " + age);
        System.out.println("건강 상태: " + health + " 에너지 상태: " + energy + " 경험치: " + experience);
    }
}

class SpecialAbility {
    String specialAbility;
    int abilityLevel;

    SpecialAbility() {
        this.specialAbility = "";
        this.abilityLevel = 1; // 기본 능력 레벨
    }

    void chooseAbility(String ability) {
        this.specialAbility = ability;
    }

    void useAbility(JobCharacter jobCharacter, Task task) {
        if (abilityLevel > 0 && !specialAbility.isEmpty()) {
            switch (specialAbility) {
                case "커뮤니케이션 능력":
                    jobCharacter.modifyEnergy(-5);
                    jobCharacter.gainExperience(task.experienceGained + 10);// Reduce energy cost
                    System.out.println("커뮤니케이션 능력 사용! 경험치 +10 획득. 에너지 소모 감소.");
                    break;
                case "F 같은 T":
                    jobCharacter.modifyEnergy(-20);
                    jobCharacter.gainExperience(task.experienceGained + 50);// Reduce energy cost
                    System.out.println("F 같은 T 능력 사용! 경험치 + 50 획득. 에너지 소모 감소.");
                    break;
                case "T 같은 F":
                    jobCharacter.modifyEnergy(-20);
                    jobCharacter.gainExperience(task.experienceGained + 30); // Increase experience gain
                    System.out.println(specialAbility + " 능력 사용! 추가 경험치 획득.");
                    break;
                case "개발 능력 만랩":
                    jobCharacter.modifyEnergy(-30);
                    jobCharacter.gainExperience(task.experienceGained * 2); // Double experience gain
                    System.out.println("개발 능력 만랩 사용! 경험치 두 배 획득.");
                    break;
                case "아이디어 방출 만랩":
                    jobCharacter.modifyEnergy(-40); // Reduce energy cost significantly
                    System.out.println("아이디어 방출 만랩 사용! 에너지 소모 크게 감소.");
                    break;
                default:
                    System.out.println("알 수 없는 능력입니다.");
            }
        } else {
            System.out.println("능력 레벨이 너무 낮거나 능력이 선택되지 않아 사용할 수 없습니다.");
        }
    }

    void upgradeAbility() {
        abilityLevel++;
        System.out.println("특별 능력이 업그레이드 되었습니다: " + specialAbility + " 레벨 " + abilityLevel);
    }

    void displayInfo() {
        System.out.println("특별 능력: " + specialAbility + " 레벨: " + abilityLevel);
    }
}

class SpecialJobCharacter extends JobCharacter {
    SpecialAbility specialAbility;

    SpecialJobCharacter(String name, String gender, int age) {
        super(name, gender, age);
        this.specialAbility = new SpecialAbility();
    }

    void chooseAbility(String ability) {
        specialAbility.chooseAbility(ability);
    }

    void useAbility(Task task) {
        specialAbility.useAbility(this, task);
    }

    void upgradeAbility() {
        specialAbility.upgradeAbility();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        specialAbility.displayInfo();
    }
}

class JobCharacter extends Character {
    String jobTitle;
    String salary;
    int experience;

    JobCharacter(String name, String gender, int age) {
        super(name, gender, age);
        this.jobTitle = "무직";
        this.salary = "0";
        this.experience = 0;
    }

    void setJob(int jobChoice) {
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

    void gainExperience(int exp) {
        this.experience += exp;
        System.out.println(jobTitle + " 경험치가 " + exp + "만큼 증가했습니다. 현재 경험치: " + experience);
        if (experience >= 100) {
            promote();
        }
    }

    void promote() {
        System.out.println("축하합니다! " + jobTitle + " 직급이 승진했습니다.");
        experience = 0; // 경험치 초기화
        int currentSalary = Integer.parseInt(salary.replace(",", ""));
        currentSalary += 5000000; // 임의로 연봉 증가
        salary = String.format("%,d", currentSalary); // 다시 문자열로 변환하여 쉼표 추가
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("직업: " + jobTitle + " 연봉: " + salary + " 경험치: " + experience);
    }
}

class Task {
    String taskName;
    int experienceGained;
    int energyCost;

    Task(String taskName, int experienceGained, int energyCost) {
        this.taskName = taskName;
        this.experienceGained = experienceGained;
        this.energyCost = energyCost;
    }

    void completeTask(JobCharacter job) {
        if (job.energy >= energyCost) {
            job.energy -= energyCost;
            job.gainExperience(experienceGained);
            System.out.println(taskName + " 작업을 완료했습니다. 에너지가 " + energyCost + "만큼 감소했습니다.");
        } else {
            System.out.println("에너지가 부족합니다. 에너지를 충전해야 합니다.");
        }
    }
}

class Clothing implements Displayable {
    String type;
    String color;
    int price;
    int durability;

    Clothing(String type, String color) {
        this.type = type;
        this.color = color;
        this.price = setPrice(type);
        this.durability = 100; // 기본 내구성
    }

    protected int setPrice(String type) {
        switch (type) {
            case "티셔츠": return 15000;
            case "후드티": return 80000;
            case "셔츠": return 60000;
            case "롱슬리브": return 35000;
            default: return 5000;
        }
    }

    void wear() {
        durability -= 10;
        if (durability < 0) durability = 0;
        System.out.println(type + "을(를) 착용했습니다. 내구성: " + durability);
    }

    void repair() {
        durability = 100;
        System.out.println(type + "이(가) 수리되었습니다. 내구성: " + durability);
    }

    @Override
    public void displayInfo() {
        System.out.println("상의는 " + type + "에 색상은 " + color + "야. 상의 가격은 " + price + "원이야! 내구성: " + durability);
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "티셔츠";
            case 2: return "후드티";
            case 3: return "셔츠";
            case 4: return "롱슬리브";
            default: return "후질근 기본 티..";
        }
    }
}

class Bottom extends Clothing {
    Bottom(String type, String color) {
        super(type, color);
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
    public void displayInfo() {
        System.out.println("하의는 " + type + "이고 색상은 " + color + "이야. 하의의 가격은 " + price + "원이야. 내구성: " + durability);
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "청바지";
            case 2: return "슬랙스";
            case 3: return "반바지";
            case 4: return "치노팬츠";
            default: return "근본 츄리닝이 짱이지!..";
        }
    }
}

class Shoes extends Clothing {
    int size;

    Shoes(String type, String color, int size) {
        super(type, color);
        this.size = size;
    }

    @Override
    protected int setPrice(String type) {
        switch (type) {
            case "스니커즈": return 30000;
            case "운동화": return 80000;
            case "로퍼": return 100000;
            case "슬리퍼": return 50000;
            default: return 0;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("신발 사이즈는 " + size + "cm 이고 신발의 가격은 " + price + "원이야. 내구성: " + durability);
    }

    static String chooseType(int choice) {
        switch (choice) {
            case 1: return "스니커즈";
            case 2: return "운동화";
            case 3: return "로퍼";
            case 4: return "슬리퍼";
            default: return "맨발 당첨ㅋ";
        }
    }
}

class Payment {
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

    void displayMainMenu() {
        System.out.println("♪ .•*¨*•.¸¸♬✧♪ .•*¨*•.¸¸♬✧");
        System.out.println("1. 캐릭터 만들기");
        System.out.println("2. 작업 실행하기");
        System.out.println("3. 종료");
        System.out.println("♪ .•*¨*•.¸¸♬✧♪ .•*¨*•.¸¸♬✧");
    }
}

public class WhoAreYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Message msg = new Message();
        Payment paymentProcessor = new Payment(sc);
        Character character = null;
        Clothing top = null;
        Bottom bottom = null;
        Shoes shoes = null;

        msg.displayWelcomeMessage();
        String choice = sc.nextLine();

        while (choice.equalsIgnoreCase("Y")) {
            msg.displayMainMenu();
            int mainChoice = sc.nextInt();
            sc.nextLine();

            if (mainChoice == 3) {
                msg.displayGoodbyeMessage();
                break;
            }

            if (mainChoice == 1) {
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

                System.out.println("기본 캐릭터를 만들겠습니까? 아니면 직업 캐릭터 또는 특별 직업 캐릭터를 만들겠습니까? (1: 기본, 2: 직업, 3: 특별 직업)");
                int characterTypeChoice = sc.nextInt();
                sc.nextLine();

                if (characterTypeChoice == 1) {
                    character = new Character(name, gender, age);
                } else if (characterTypeChoice == 2) {
                    character = new JobCharacter(name, gender, age);
                    System.out.println("직업을 선택해 주세요. 1. 소프트웨어 개발자 2. 데이터 분석가 3. 임베디드 개발자 4. 클라우드 개발자 5. 정보보안전문가 6. QA 7. 기획자 8. 디자이너 9. 네트워크 엔지니어 10. DBA");
                    int jobChoice = sc.nextInt();
                    sc.nextLine();
                    ((JobCharacter) character).setJob(jobChoice);
                } else if (characterTypeChoice == 3) {
                    character = new SpecialJobCharacter(name, gender, age);
                    System.out.println("직업을 선택해 주세요. 1. 소프트웨어 개발자 2. 데이터 분석가 3. 임베디드 개발자 4. 클라우드 개발자 5. 정보보안전문가 6. QA 7. 기획자 8. 디자이너 9. 네트워크 엔지니어 10. DBA");
                    int jobChoice = sc.nextInt();
                    sc.nextLine();
                    ((JobCharacter) character).setJob(jobChoice);

                    System.out.println("특별 능력을 선택해 주세요. 1. 커뮤니케이션 능력 2. F 같은 T 3. T 같은 F 4. 개발 능력 만랩 5. 아이디어 방출 만랩");
                    int abilityChoice = sc.nextInt();
                    sc.nextLine();
                    String[] abilities = {"커뮤니케이션 능력", "F 같은 T", "T 같은 F", "개발 능력 만랩", "아이디어 방출 만랩"};
                    ((SpecialJobCharacter) character).chooseAbility(abilities[abilityChoice - 1]);

                    System.out.println("특별 능력을 사용하려면 추가 비용이 듭니다. 계속 진행하시겠습니까? (Y/N)");
                    String abilityCostChoice = sc.nextLine();
                    if (abilityCostChoice.equalsIgnoreCase("Y")) {
                        paymentProcessor.processPayment(5000); // 임의의 추가 비용
                    } else {
                        ((SpecialJobCharacter) character).specialAbility.specialAbility = "";
                    }
                }

                character.displayInfo();
                msg.displayDivider();

                System.out.println("이제 옷을 선택해 주세요.");
                System.out.println("상의부터 골라볼까?? \n 1. 티셔츠\n 2. 후드티\n 3. 셔츠\n 4. 롱슬리브 ");
                int topChoice = sc.nextInt();
                sc.nextLine();
                String topType = Clothing.chooseType(topChoice);
                System.out.println("색상을 입력해줘!");
                String topColor = sc.nextLine();
                top = new Clothing(topType, topColor);
                top.displayInfo();
                System.out.println("이 옷을 입겠습니까? 아니면 가지고 있겠습니까? (1: 입기, 2: 가지고 있기)");
                int wearTopChoice = sc.nextInt();
                sc.nextLine();
                if (wearTopChoice == 1) {
                    top.wear();
                } else {
                    System.out.println(top.type + "을(를) 가지고 있습니다. 내구성은 변하지 않습니다.");
                }
                msg.displayDivider();

                System.out.println("하의도 골라볼까?? \n 1.청바지\n 2. 슬랙스\n 3. 반바지\n 4. 치노팬츠 ");
                int bottomChoice = sc.nextInt();
                sc.nextLine();
                String bottomType = Bottom.chooseType(bottomChoice);
                System.out.println("색상을 골라봐!");
                String bottomColor = sc.nextLine();
                bottom = new Bottom(bottomType, bottomColor);
                bottom.displayInfo();
                System.out.println("이 옷을 입겠습니까? 아니면 가지고 있겠습니까? (1: 입기, 2: 가지고 있기)");
                int wearBottomChoice = sc.nextInt();
                sc.nextLine();
                if (wearBottomChoice == 1) {
                    bottom.wear();
                } else {
                    System.out.println(bottom.type + "을(를) 가지고 있습니다. 내구성은 변하지 않습니다.");
                }
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
                shoes = new Shoes(shoesType, shoesColor, shoeSize);
                shoes.displayInfo();
                System.out.println("이 신발을 신겠습니까? 아니면 가지고 있겠습니까? (1: 신기, 2: 가지고 있기)");
                int wearShoesChoice = sc.nextInt();
                sc.nextLine();
                if (wearShoesChoice == 1) {
                    shoes.wear();
                } else {
                    System.out.println(shoes.type + "을(를) 가지고 있습니다. 내구성은 변하지 않습니다.");
                }
                msg.displayDivider();

                int totalPrice = Character.basic_cost + top.price + bottom.price + shoes.price;
                top.displayInfo();
                bottom.displayInfo();
                shoes.displayInfo();
                msg.displayDivider();
                System.out.println("캐릭터 만들기 비용은 기본 " + Character.basic_cost + ", 상의의 가격은 " + top.price + ", 하의 가격은 " + bottom.price + ", 신발 가격은 " + shoes.price + "원이야.");
                System.out.println("너가 지불해야 할 총 금액은 " + totalPrice + "이야!");

                paymentProcessor.processPayment(totalPrice);
            } else if (mainChoice == 2) {
                if (character == null) {
                    System.out.println("캐릭터를 만들고 진행해주세요.");
                    continue;
                }

                while (true) {
                    System.out.println("무엇을 하시겠습니까? 1. 작업 선택 2. 에너지 충전 3. 옷 수리 4. 종료");
                    int actionChoice = sc.nextInt();
                    sc.nextLine();
                    if (actionChoice == 4) {
                        break;
                    }

                    if (character == null) {
                        System.out.println("캐릭터가 없습니다. 먼저 캐릭터를 생성해 주세요.");
                        continue;
                    }

                    switch (actionChoice) {
                        case 1:
                            if (character instanceof JobCharacter) {
                                JobCharacter jobCharacter = (JobCharacter) character;
                                System.out.println("작업을 선택해 주세요. 1. 프로젝트 완료 2. 팀 리더십 3. 고객 지원 4. 기술 문서 작성 5. 연구 및 개발");
                                int taskChoice = sc.nextInt();
                                sc.nextLine();
                                switch (taskChoice) {
                                    case 1:
                                        hangmanGame(jobCharacter);
                                        break;
                                    case 2:
                                        leadershipTest(jobCharacter);
                                        break;
                                    case 3:
                                        communicationGame(jobCharacter);
                                        break;
                                    case 4:
                                        documentReview(jobCharacter);
                                        break;
                                    case 5:
                                        javaQuiz(jobCharacter);
                                        break;
                                    default:
                                        System.out.println("잘못된 선택입니다.");
                                }
                            } else {
                                System.out.println("기본 캐릭터는 작업을 수행할 수 없습니다.");
                            }
                            break;
                        case 2:
                            if (character.energy == 100) {
                                System.out.println("에너지가 이미 최대치입니다.");
                            } else if (character.health >= 10) {
                                character.modifyHealth(-10);
                                character.modifyEnergy(100);
                                System.out.println("에너지가 100으로 충전되었습니다. 건강이 10 감소했습니다.");
                            } else {
                                System.out.println("건강이 충분하지 않습니다. 에너지를 충전할 수 없습니다.");
                            }
                            break;
                        case 3:
                            System.out.println("어떤 옷을 수리하시겠습니까? 1. 상의 2. 하의 3. 신발");
                            int repairChoice = sc.nextInt();
                            sc.nextLine();
                            switch (repairChoice) {
                                case 1:
                                    repairClothing(top, sc);
                                    break;
                                case 2:
                                    repairClothing(bottom, sc);
                                    break;
                                case 3:
                                    repairClothing(shoes, sc);
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다.");
                            }
                            break;
                        default:
                            System.out.println("잘못된 선택입니다.");
                    }

                    character.displayInfo();
                    msg.displayDivider();
                }
            }
        }

        sc.close();
    }

    public static void repairClothing(Clothing clothing, Scanner sc) {
        if (clothing.durability == 100) {
            System.out.println(clothing.type + "의 내구성이 이미 최대치입니다.");
        } else {
            System.out.println(clothing.type + "을(를) 수리하려면 숫자 맞추기 게임을 완료해야 합니다. 1부터 10 사이의 숫자를 맞춰보세요.");
            Random rand = new Random();
            int correctNumber = rand.nextInt(10) + 1;
            boolean isRepaired = false;

            for (int i = 0; i < 3; i++) {
                System.out.println("숫자를 입력하세요: ");
                int userGuess = sc.nextInt();
                sc.nextLine();
                if (userGuess == correctNumber) {
                    System.out.println("맞췄습니다! " + clothing.type + "이(가) 수리되었습니다.");
                    clothing.repair();
                    isRepaired = true;
                    break;
                } else {
                    System.out.println("틀렸습니다.");
                }
            }

            if (!isRepaired) {
                System.out.println("기회를 모두 사용했습니다. 다음에 다시 시도해주세요.");
            }
        }
    }

    // 작업 수행 시 실행할 미니 게임들

    public static void hangmanGame(JobCharacter jobCharacter) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"java", "program", "hangman", "object", "inheritance"};
        String word = words[new Random().nextInt(words.length)];
        char[] guessWord = new char[word.length()];
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = '_';
        }

        int tries = 6;
        while (tries > 0) {
            System.out.println("현재 상태: " + new String(guessWord));
            System.out.println("남은 시도 횟수: " + tries);
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
                return;
            }
        }

        System.out.println("실패했습니다. 단어는: " + word);
        jobCharacter.modifyEnergy(-20);
    }

    public static void leadershipTest(JobCharacter jobCharacter) {
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

    public static void communicationGame(JobCharacter jobCharacter) {
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

    public static void documentReview(JobCharacter jobCharacter) {
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

    public static void javaQuiz(JobCharacter jobCharacter) {
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
