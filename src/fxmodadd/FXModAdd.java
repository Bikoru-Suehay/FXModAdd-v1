/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fxmodadd;

import fxmodadd.model.util.Constant;
import fxmodadd.view.App;
import java.io.IOException;

/**
 *
 * @author Vìctor
 */
public class FXModAdd {

    public static void main(String[] args) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
