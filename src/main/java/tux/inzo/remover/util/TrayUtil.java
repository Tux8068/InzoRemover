package tux.inzo.remover.util;

import tux.inzo.remover.Main;

import java.awt.*;

public class TrayUtil {

    public static void setTray(String tooltip, String caption, String text) {

        SystemTray tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().createImage(Main.class.getResource("/images/97044373.jpg"));

        TrayIcon trayIcon = new TrayIcon(image, tooltip);
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip(tooltip);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        trayIcon.displayMessage(caption, text, TrayIcon.MessageType.WARNING);



    }
}
