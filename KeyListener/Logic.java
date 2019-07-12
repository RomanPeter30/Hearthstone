package KeyListener;

public class Logic {

    Roboter roboter = new Roboter();

    public void printChar(int code) {
        switch (code) {
            case 28:
                roboter.endTurn();
                break;
            case 57:
                roboter.selectCard();
                break;
            case 57416:
                roboter.moveMouseDown();
                break;
            case 57419:
                roboter.moveMouseLeft();
                break;
            case 57421:
                roboter.moveMouseRigth();
                break;
            case 57424:
                roboter.moveMouseUp();
            default:
                System.out.println("Noch nicht implementiert");
        }
    }
}
