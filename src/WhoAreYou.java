import java.util.*;

public class WhoAreYou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Message msg = new Message();
        Payment paymentProcessor = new Payment(sc);
        List<Character> characters = new ArrayList<>();
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

                Character character = null;
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

                    System.out.println("특별 능력을 사용하려면 추가 비용이 듭니다. 계속 진행하시겠습니까? - 추가 능력 비용 5000원 (Y/N)");
                    String abilityCostChoice = sc.nextLine();
                    if (abilityCostChoice.equalsIgnoreCase("Y")) {
                        paymentProcessor.processPayment(5000);
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
                msg.displayDivider();

                System.out.println("하의도 골라볼까?? \n 1.청바지\n 2. 슬랙스\n 3. 반바지\n 4. 치노팬츠 ");
                int bottomChoice = sc.nextInt();
                sc.nextLine();
                String bottomType = Bottom.chooseType(bottomChoice);
                System.out.println("색상을 골라봐!");
                String bottomColor = sc.nextLine();
                bottom = new Bottom(bottomType, bottomColor);
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
                msg.displayDivider();

                int totalPrice = Character.basic_cost + top.price + bottom.price + shoes.price;
                System.out.println("캐릭터 만들기 비용은 기본 " + Character.basic_cost + ", 상의의 가격은 " + top.price + ", 하의 가격은 " + bottom.price + ", 신발 가격은 " + shoes.price + "원이야.");
                System.out.println("너가 지불해야 할 총 금액은 " + totalPrice + "이야!");

                paymentProcessor.processPayment(totalPrice);
                msg.displayDivider();

                CharacterActionThread ct = new CharacterActionThread();
                ct.start();
                try {
                    ct.join(); // 캐릭터 생성 스레드가 완료될 때까지 대기
                    top.displayInfo();
                    bottom.displayInfo();
                    shoes.displayInfo();
                } catch (InterruptedException e) {
                    System.out.println("캐릭터 생성 중에 오류가 발생했습니다.");
                }

                characters.add(character);
            } else if (mainChoice == 2) {
                if (characters.isEmpty()) {
                    System.out.println("캐릭터를 만들고 진행해주세요.");
                    continue;
                }
                System.out.println("작업을 실행할 캐릭터를 선택해 주세요:");
                for (int i = 0; i < characters.size(); i++) {
                    System.out.println((i + 1) + ". " + characters.get(i).name);
                }
                int selectedCharacterIndex = sc.nextInt() - 1;
                sc.nextLine();
                if (selectedCharacterIndex < 0 || selectedCharacterIndex >= characters.size()) {
                    System.out.println("잘못된 선택입니다.");
                    continue;
                }
                Character selectedCharacter = characters.get(selectedCharacterIndex);

                while (true) {
                    System.out.println("무엇을 하시겠습니까? 1. 작업 선택 2. 에너지 충전 3. 옷 수리 4. 산책 5. 종료");

                    int actionChoice = sc.nextInt();
                    sc.nextLine();
                    if (actionChoice == 5) {
                        break;
                    }

                    if (characters == null) {
                        System.out.println("캐릭터가 없습니다. 먼저 캐릭터를 생성해 주세요.");
                        continue;
                    }

                    switch (actionChoice) {
                        case 1:
                            if (selectedCharacter instanceof JobCharacter) {
                                JobCharacter jobCharacter = (JobCharacter) selectedCharacter;
                                System.out.println("작업을 선택해 주세요. 1. 프로젝트 완료 2. 팀 리더십 3. 고객 지원 4. 기술 문서 작성 5. 연구 및 개발");
                                int taskChoice = sc.nextInt();
                                sc.nextLine();
                                Thread gameThread;
                                switch (taskChoice) {
                                    case 1:
                                        gameThread = new HangmanGameThread(jobCharacter);
                                        gameThread.start();
                                        try {
                                            System.out.println("행맨 게임을 시작합니다..>>>>");
                                            gameThread.join();
                                        } catch (InterruptedException e) {
                                            System.out.println("게임 실행 중 오류가 발생했습니다.");
                                        }
                                        break;
                                    case 2:
                                        gameThread = new LeadershipTest(jobCharacter);
                                        gameThread.start();
                                        try{
                                            System.out.println("리더쉽 테스트 게임을 시작합니다..>>>>");
                                            gameThread.join();
                                        } catch (InterruptedException e){
                                            System.out.println("게임 실행 중 오류가 발생했습니다.");
                                        }
                                        break;
                                    case 3:
                                        gameThread = new CommunicationGame(jobCharacter);
                                        gameThread.start();
                                        try{
                                            System.out.println("커뮤니케이션 테스트 게임을 시작합니다..>>>>");
                                            gameThread.join();
                                        } catch (InterruptedException e){
                                            System.out.println("게임 실행 중 오류가 발생했습니다.");
                                        }
                                        break;
                                    case 4:
                                        gameThread = new DocumentReview(jobCharacter);
                                        gameThread.start();
                                        try{
                                            System.out.println("문서작성 테스트 게임을 시작합니다..>>>>");
                                            gameThread.join();
                                        } catch (InterruptedException e){
                                            System.out.println("게임 실행 중 오류가 발생했습니다.");
                                        }
                                        break;
                                    case 5:
                                        gameThread = new JavaQuiz(jobCharacter);
                                        gameThread.start();
                                        try{
                                            System.out.println("자바 테스트 게임을 시작합니다..>>>>");
                                            gameThread.join();
                                        } catch (InterruptedException e){
                                            System.out.println("게임 실행 중 오류가 발생했습니다.");
                                        }
                                        break;
                                    default:
                                        System.out.println("잘못된 선택입니다.");
                                }
                            } else {
                                System.out.println("기본 캐릭터는 작업을 수행할 수 없습니다.");
                            }
                            break;
                        case 2:
                            if (selectedCharacter.energy == 100) {
                                System.out.println("에너지가 이미 최대치입니다.");
                            } else if (selectedCharacter.health >= 10) {
                                selectedCharacter.modifyHealth(-10);
                                selectedCharacter.modifyEnergy(100);
                                System.out.println("에너지가 100으로 충전되었습니다. 건강이 10 감소했습니다.");
                            } else {
                                System.out.println("건강이 충분하지 않습니다. 에너지를 충전할 수 없습니다.");
                            }
                            break;
                        case 3:
                            System.out.println("어떤 옷을 수리하시겠습니까?");
                            System.out.println("1. 상의 (" + top.durability + " 내구성)");
                            System.out.println("2. 하의 (" + bottom.durability + " 내구성)");
                            System.out.println("3. 신발 (" + shoes.durability + " 내구성)");
                            int repairChoice = sc.nextInt();
                            sc.nextLine();
                            RepairClothingGame repairThread;
                            switch (repairChoice) {
                                case 1:
                                    repairThread = new RepairClothingGame(top, sc);
                                    repairThread.start();
                                    try {
                                        System.out.println("옷 수리 게임 시작 ...>>>>>>");
                                        repairThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("게임 중 오류가 발생했습니다.");
                                    }
                                    break;
                                case 2:
                                    repairThread = new RepairClothingGame(bottom, sc);
                                    repairThread.start();
                                    try {
                                        System.out.println("옷 수리 게임 시작 ...>>>>>>");
                                        repairThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("게임 중 오류가 발생했습니다.");
                                    }
                                    break;
                                case 3:
                                    repairThread = new RepairClothingGame(shoes, sc);
                                    repairThread.start();
                                    try {
                                        System.out.println("옷 수리 게임 시작 ...>>>>>>");
                                        repairThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("게임 중 오류가 발생했습니다.");
                                    }
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다.");
                            }
                            break;
                        case 4:
                            System.out.println("어떤 옷을 입고 산책하시겠습니까? 1. 상의 2. 하의 3. 신발");
                            int walkChoice = sc.nextInt();
                            sc.nextLine();
                            WalkGame walkThread;
                            switch (walkChoice) {
                                case 1:
                                    walkThread = new WalkGame(selectedCharacter, top, sc);
                                    walkThread.start();
                                    try {
                                        walkThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("산책 중 오류가 발생했습니다.");
                                    }
                                    break;
                                case 2:
                                    walkThread = new WalkGame(selectedCharacter, bottom, sc);
                                    walkThread.start();
                                    try {
                                        walkThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("산책 중 오류가 발생했습니다.");
                                    }
                                    break;
                                case 3:
                                    walkThread = new WalkGame(selectedCharacter, shoes, sc);
                                    walkThread.start();
                                    try {
                                        walkThread.join();
                                    } catch (InterruptedException e) {
                                        System.out.println("산책 중 오류가 발생했습니다.");
                                    }
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다.");
                            }
                            break;
                        default:
                            System.out.println("잘못된 선택입니다.");
                    }
                    selectedCharacter.displayInfo();
                    msg.displayDivider();
                }
            }
        }
        sc.close();
    }
}