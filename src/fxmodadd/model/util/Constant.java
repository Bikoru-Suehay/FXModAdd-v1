/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fxmodadd.model.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Vìctor
 */
public class Constant {

    private static String DIR;

    static {
        try {
            DIR = new File(Constant.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            e.getReason();
        }
    }
    private static String CONTAINER = DIR.substring(0, DIR.lastIndexOf("\\"));
    private static String JARDIR;
    private static String COMMAND;

    public static boolean autoRun() {
        File aux = new File(CONTAINER);
        for (File f : aux.listFiles()) {
            if (f.getName().contains(".jar")) {
                JARDIR = f.getAbsolutePath();
            }
        }
        COMMAND = "java --module-path=" + CONTAINER + "\\SDK\\lib --add-modules=javafx.controls,javafx.fxml -jar " + JARDIR;
        try {
            Process p = Runtime.getRuntime().exec(COMMAND);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static boolean autoRun(String name, String modules) {
        File aux = new File(CONTAINER);
        for (File f : aux.listFiles()) {
            if (f.getName().contains(".jar")&&f.getName().toLowerCase().contains(name.trim().toLowerCase())) {
                JARDIR = f.getAbsolutePath();
            }
        }
        COMMAND = "java --module-path=" + CONTAINER + "\\SDK\\lib --add-modules="+modules+" -jar " + JARDIR;
        System.out.println(COMMAND);
        try {
            Process p = Runtime.getRuntime().exec(COMMAND);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        autoRun();
    }
}
