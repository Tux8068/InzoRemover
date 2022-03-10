package tux.inzo.remover;

import tux.inzo.remover.util.SearchUtil;
import tux.inzo.remover.util.MiscUtil;
import tux.inzo.remover.util.TrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String [] args) throws IOException {
        System.out.println(MiscUtil.PREFIX + "Checking for persistence: ");

        for (File file : SearchUtil.getContaining(MiscUtil.file)) {
            if (file.getName().equals("Windows_Python-Startup.pyw") || file.getName().endsWith(".pyw")) {
                MiscUtil.zipSingleFile(Path.of(file.getPath()), Path.of(file.getParent()) + File.separator + "archive-" + MiscUtil.generateChars("123456789", 6) + ".zip");

                TrayUtil.setTray("WARNING!", MiscUtil.PREFIX + "harmful file found.", "Found file: " + file.getName());

                System.out.println(MiscUtil.PREFIX + "Found persistence, removing.");
                file.delete();

            }

        }




    }
}
