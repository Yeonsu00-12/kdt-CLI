public class Clothing implements Displayable {
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

    public void repair() {
        durability = 100;
        System.out.println(type + "이(가) 수리되었습니다. 내구성: " + durability);
    }

    @Override
    public void displayInfo() {
        System.out.println("상의는 " + type + "에 색상은 " + color + "야. 내구성: " + durability);
    }

    public static String chooseType(int choice) {
        switch (choice) {
            case 1: return "티셔츠";
            case 2: return "후드티";
            case 3: return "셔츠";
            case 4: return "롱슬리브";
            default: return "후질근 기본 티..";
        }
    }
}