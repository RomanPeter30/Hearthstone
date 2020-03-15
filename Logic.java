import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;

public class Logic {

    KeyListener keyListener;

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

    //Starten
    public void start() {
        handString.bind(handcards.asString());
        this.keyListener = new KeyListener();
        keyListener.start();
    }

    public void doAction(int code) {
        if(code == 18) {
            System.out.println("E");
        }
    }

    public void write() {
        System.out.println("Hello");
    }
}
