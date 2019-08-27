package KeyListener;

public class Logic {

    Roboter roboter = new Roboter();
    boolean selected = false;
    boolean attackCardChosen = false;

    public void performAction(int code) {
        switch (code) {
            case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                if(attackCardChosen) {
                    roboter.chooseTarget(code);
                    attackCardChosen = false;
                } else {
                    roboter.choosePlace(code);
                    attackCardChosen = true;
                }
                break;
            case 18:
                roboter.endTurn();
                break;
            case 31:
                roboter.startGame();
                break;
            case 33:
                roboter.goFace();
                break;
            case 35:
                roboter.heroPower();
                break;
            case 57:
                if(selected) {
                    roboter.releaseCard();
                    selected = false;
                } else {
                    roboter.selectCard();
                    selected = true;
                }
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
                break;
            default:
                System.out.println("Noch nicht implementiert");
        }
    }
}