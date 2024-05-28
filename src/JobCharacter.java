public class JobCharacter extends Character {
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
