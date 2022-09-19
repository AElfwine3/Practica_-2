
import java.awt.Image;
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
public class disparojefe extends JLabel {

    ImageIcon shootj;

    public disparojefe() {
        //creardisparo1();
        imagen();
        setIcon(shootj);
    }

    public void imagen() {
        if (stage.Disparos_Jefes.equals("stage1")) {
            shootj = new ImageIcon(
                    new ImageIcon("src/Imagenes/dispjefe.png").getImage()
                            .getScaledInstance(66, 23, Image.SCALE_DEFAULT)
            );
        } else if (stage.Disparos_Jefes.equals("stage2")){
            shootj = new ImageIcon(
                    new ImageIcon("src/Imagenes/dispjefe2.png").getImage()
                            .getScaledInstance(40, 40, Image.SCALE_DEFAULT)
            );
        }

    }
}
