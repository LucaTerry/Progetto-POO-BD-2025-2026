package main;

import controller.Controller;
import gui.MainFrame;

public class Main {
    public static void main(String[] args){

        // 1. Accendiamo il "cervello" (Il Controller)
        Controller controller = new Controller();

        // 2. Accendiamo la "faccia" (La View) e le presentiamo il cervello
        MainFrame finestraPrincipale = new MainFrame(controller);

        // 3. Rendiamo visibile la finestra
        finestraPrincipale.setVisible(true);

    }
}
