package firstProjectPackage;

import java.awt.Component;
import javax.swing.JFrame;

public class MainClass extends JFrame {
   public static WindowDesign f;

   public static void main(String[] args) {
      f = new WindowDesign();
      f.setVisible(true);
      f.setDefaultCloseOperation(3);
      f.setResizable(false);
      f.setSize(800, 600);
      f.setTitle("Rainbow Rocket Squad");
      f.setLocationRelativeTo((Component)null);
   }
}