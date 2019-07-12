package KeyListener;

public class Logic {
    public void printChar(int code) {
        switch (code) {
            case 30:
                System.out.println("a");
                break;
            case 32:
                System.out.println("d");
                break;
            default:
                System.out.println("Noch nicht implementiert");
        }
    }
}
