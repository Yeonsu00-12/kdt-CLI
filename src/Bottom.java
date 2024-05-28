public class Bottom extends Clothing {
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
        System.out.println("하의는 " + type + "이고 색상은 " + color + "이야. 내구성: " + durability);
    }

    public static String chooseType(int choice) {
        switch (choice) {
            case 1: return "청바지";
            case 2: return "슬랙스";
            case 3: return "반바지";
            case 4: return "치노팬츠";
            default: return "근본 츄리닝이 짱이지!..";
        }
    }
}