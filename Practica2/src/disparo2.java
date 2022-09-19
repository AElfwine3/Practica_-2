
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ushi
 */
public class disparo2 extends JLabel {

    ImageIcon shoot2;

    public disparo2() {

        imagen();
        setIcon(shoot2);
    }

    public void imagen() {
        switch (Control.indice_2) {
            case 0:
                shoot2 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 1:
                shoot2 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp2.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 2:
                shoot2 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp3.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 3:
                shoot2 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp4.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            default:
                break;
        }
    }
}
