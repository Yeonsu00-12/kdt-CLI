public class SpecialAbility {
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
                    jobCharacter.modifyEnergy(-40);
                    jobCharacter.gainExperience(task.experienceGained + 20);// Reduce energy cost significantly
                    System.out.println("아이디어 방출 만랩 사용! 추가 경험치 +20. 에너지 소모 크게 감소.");
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