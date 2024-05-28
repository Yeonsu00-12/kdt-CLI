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

    public void modifyHealth(int amount) {
        this.health += amount;
        if (this.health > 100) this.health = 100;
        if (this.health < 0) this.health = 0;
    }

    public void modifyEnergy(int amount) {
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
