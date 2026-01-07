package firstProjectPackage;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class WindowDesign extends JFrame {
   public MainCode panel = new MainCode(this);

   public WindowDesign() {
      this.setLayout(new GridLayout(1, 1, 0, 0));
      this.add(this.panel);
   }
}
    