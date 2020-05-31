import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
  private int duration;

  public SplashScreen(int d) {
    duration = d;
  }

  // Un Metodo para centrar un screen 
  // Dando al Screen una construccion
  public void showSplash() {
    JPanel content = (JPanel) getContentPane();
    content.setBackground(Color.white);

    // Centrando la Ventana
    int width = 300;
    int height = 200;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;
    setBounds(x, y, width, height);

    // Construyendo el Splash
    JLabel label = new JLabel(new ImageIcon("tunkysp.gif"));
    JLabel copyrt = new JLabel("Copyleft 2005, Developers & H4ck3r5",
        JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(156, 20, 20, 255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    // Mostrando esto :D
    setVisible(true);

    // ESperar un Tiempo Mientras Cargan los Recursos
    try {
      Thread.sleep(duration);
    } catch (Exception e) {
    }

    setVisible(false);
  }

  public void showSplashAndExit() {
    showSplash();
    //System.exit(0);
  }
}