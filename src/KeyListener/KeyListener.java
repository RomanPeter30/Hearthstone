package KeyListener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener implements  NativeKeyListener{
    public static void main(String[] args) {
        Logger logger = Logger.getLogger((GlobalScreen.class.getPackage().getName()));
        logger.setLevel(Level.OFF);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new KeyListener());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println(e.getKeyCode());
        Logic logic = new Logic();
        logic.printChar(e.getKeyCode());
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {

    }
}

