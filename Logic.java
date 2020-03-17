import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;

public class Logic {

    Overlay overlay;

    Logic(Overlay overlay) {
        this.overlay = overlay;
    }

    //StringProperty for HandCards
    private StringProperty handString = new SimpleStringProperty();
    public StringProperty handString() {
        return handString;
    }
    public String getHandString() {
        return handString.get();
    }
    public void setHandString(String handString) {
        this.handString.set(handString);
    }

    //IntegerPoperty for Handcards
    private IntegerProperty handcards = new SimpleIntegerProperty();
    public IntegerProperty handcards() {
        return handcards;
    }
    public int getHandcards() {
        return handcards.get();
    }
    public void setHandcards(int handcards) {
        this.handcards.set(handcards);
    }

    //StringProperty for EnemyMinions
    private StringProperty enemyMinionsString = new SimpleStringProperty();
    public StringProperty enemyMinionsString() {
        return enemyMinionsString;
    }
    public String getEnemyMinionsString() {
        return enemyMinionsString.get();
    }
    public void setEnemyMinionsString(String enemyMinionsString) {
        this.enemyMinionsString.set(enemyMinionsString);
    }

    //IntegerPoperty for EnemyMinions
    private IntegerProperty enemyMinions = new SimpleIntegerProperty();
    public IntegerProperty enemyMinions() {
        return enemyMinions;
    }
    public int getEnemyMinions() {
        return enemyMinions.get();
    }
    public void setEnemyMinions(int enemyMinions) {
        this.enemyMinions.set(enemyMinions);
    }

    //StringProperty for FriendlyMinions
    private StringProperty friendlyMinionsString = new SimpleStringProperty();
    public StringProperty friendlyMinionsString() {
        return friendlyMinionsString;
    }
    public String getFriendlyMinionsString() {
        return friendlyMinionsString.get();
    }
    public void setFriendlyMinionsString(String friendlyMinionsString) {
        this.friendlyMinionsString.set(friendlyMinionsString);
    }

    //IntegerPoperty for FriendlyMinions
    private IntegerProperty friendlyMinions = new SimpleIntegerProperty();
    public IntegerProperty friendlyMinions() {
        return friendlyMinions;
    }
    public int getFriendlyMinions() {
        return friendlyMinions.get();
    }
    public void setFriendlyMinions(int friendlyMinions) {
        this.friendlyMinions.set(friendlyMinions);
    }

    public boolean confirmed = false;
    public boolean attack = false;
    public boolean selected = false;
    public boolean cardToPlay = false;
    public boolean cardToAttack = false;
    public boolean playCard = true;
    public int selection;
    public int posToAttack;
    public int timesSel;
    public int timesPos;

    //Starten
    public void start() {
        handString.bind(handcards.asString());
        enemyMinionsString.bind(enemyMinions.asString());
        friendlyMinionsString.bind(friendlyMinions.asString());
    }

    public void doAction(int code) throws AWTException {
        timesSel = 0;
        timesPos = 0;

        //Minions
        if (getEnemyMinions() % 2 == 0) {
            posToAttack = 610;
        } else {
            posToAttack = 540;
        }

        //Handcards
        if (getHandcards() == 4) {
            selection = 620;
        } else if (getHandcards() == 6) {
            selection = 400;
        }

        //Create Robot
        Roboter r = new Roboter();
        r.start();

        //Generelle Logik
        if (code == 2 || code == 3 || code == 4 || code == 5 || code == 6 || code == 7 || code == 8 || code == 9 || code == 10 || code == 11) {
            if (cardToAttack) { //Attack
                r.attack(posToAttack, code - 2);
                cardToAttack = false;
            } else if (!cardToPlay && confirmed && playCard) {
                r.playCard(overlay.xHands, overlay.addHands, code - 1);
                cardToPlay = true;
            } else if (!confirmed) { //Select Card to put away
                r.select(selection, code - 2);
            } else if (!playCard) {
                r.chooseAttackCard(overlay.x, code - 1);
                cardToAttack = true;
            } else {
                r.posToPlay(overlay.x, code - 1);
                cardToPlay = false;
            }
        }

        //Logic
        if (code == 3658) { //NumPad Plus
            setHandcards(getHandcards() - 1);
        } else if (code == 3662) { //NumPad Minus
            setHandcards(getHandcards() + 1);
        } else if (code == 57416) { //NumPad 8
            setFriendlyMinions(getFriendlyMinions() + 1);
        } else if (code == 57424) { //NumPad 2
            setFriendlyMinions(getFriendlyMinions() - 1);
        } else if (code == 57419) { //NumPad 4
            setEnemyMinions(getEnemyMinions() - 1);
        } else if (code == 57421) { //NumPad 6
            setEnemyMinions(getEnemyMinions() + 1);
        } else if (code == 31) {
            r.startGame();
        } else if (code == 46) { //Confirm
            r.confirm();
            confirmed = true;
        } else if (code == 30) { //Attack
            attack = true;
        } else if (code == 18) {
            r.endTurn();
        } else if (code == 25) {
            if(playCard) {
                playCard = false;
            } else {
                playCard = true;
            }
        } else if (code == 4) {
            if (!confirmed && !selected) { //Select Handsize at startc
                setHandcards(4);
                selected = true;
            }
        } else if (code == 5) {
            if (!confirmed && !selected) { //Select Handsize at start
                setHandcards(6);
                selected = true;
            } else if (!confirmed && getHandcards() == 6) { //Select Card to put away
                timesSel = 3;
                r.select(selection, timesSel);
            }
        }
    }
}
