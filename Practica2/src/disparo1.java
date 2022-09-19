
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
public class disparo1 extends JLabel {

    //stage pers = new stage();
    ImageIcon shoot1;

    public disparo1() {
        //creardisparo1();
        imagen();
        setIcon(shoot1);
    }

    /*public void creardisparo1(){
        setBounds(205, 175, 20, 40);
        setVisible(true);
    }*/
    public void imagen() {
        switch (Control.indice_1) {
            case 0:
                shoot1 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 1:
                shoot1 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp2.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 2:
                shoot1 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp3.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            case 3:
                shoot1 = new ImageIcon(
                        new ImageIcon("src/Imagenes/disp4.png").getImage()
                        //.getScaledInstance(persona.getWidth(), persona.getHeight(), Image.SCALE_DEFAULT)
                );  break;
            default:
                break;
        }
    }

}
