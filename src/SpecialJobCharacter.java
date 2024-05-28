public class SpecialJobCharacter extends JobCharacter {
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