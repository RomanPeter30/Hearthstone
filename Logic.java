import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Logic {

    //IntegerPoperty for Handcards
    private IntegerProperty handcards = new SimpleIntegerProperty();
    public IntegerProperty handcards() {return handcards;}
    public int getHandcards() {return handcards.get();}
    public void setHandcards(int handcards) {this.handcards.set(handcards);}

    public void start() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyListener());
    }
}
