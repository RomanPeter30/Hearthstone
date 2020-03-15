import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;

public class Logic {
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

    //Starten
    public void start() {
        handString.bind(handcards.asString());
        enemyMinionsString.bind(enemyMinions.asString());
        friendlyMinionsString.bind(friendlyMinions.asString());
    }

    public void doAction(int code) throws AWTException {
        Roboter r = new Roboter();
        r.start();
        if(code == 3658) { //NumPad Plus
            setHandcards(getHandcards() - 1);
        } else if(code == 3662) { //NumPad Minus
            setHandcards(getHandcards() + 1);
        } else if(code == 57416) { //NumPad 8
            setFriendlyMinions(getFriendlyMinions() + 1);
        } else if(code == 57424) { //NumPad 2
            setFriendlyMinions(getFriendlyMinions() - 1);
        } else if(code == 57419) { //NumPad 4
            setEnemyMinions(getEnemyMinions() - 1);
        } else if(code == 57421) { //NumPad 6
            setEnemyMinions(getEnemyMinions() + 1);
        } else if(code == 31) {
            r.startGame();
        }
    }
}
