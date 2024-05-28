public class Shoes extends Clothing {
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
        System.out.println("신발은 "+type+", 사이즈는 " + size + "cm 이야. 내구성: " + durability);
    }

    public static String chooseType(int choice) {
        switch (choice) {
            case 1: return "스니커즈";
            case 2: return "운동화";
            case 3: return "로퍼";
            case 4: return "슬리퍼";
            default: return "맨발 당첨ㅋ";
        }
    }
}