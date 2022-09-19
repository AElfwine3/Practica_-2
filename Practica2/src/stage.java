
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ushi
 */
public class stage extends JFrame implements KeyListener {

    /* Instancias*/
    teclaso ventana = new teclaso();
    disparo1 disparo;
    disparo2 disparoS;
    disparojefe disparojefesito;
    /*------------------------------*/

 /* Etiquetas para Imagenes */
    JLabel persona = new JLabel();
    JLabel jefe = new JLabel();
    JLabel nj = new JLabel();
    JLabel lblvidajefe = new JLabel();
    JLabel lblvida = new JLabel();
    JLabel lblh = new JLabel();
    JLabel lblhe = new JLabel();
    JLabel lblhea = new JLabel();
    JLabel lblbarra = new JLabel();
    /*-------------------------------*/

 /* Vectores de Imagenes */
    ImageIcon spritesDerecha[];
    ImageIcon spritesIzquierda[];
    ImageIcon spritesSalto[];
    ImageIcon spritesDisparar[];
    ImageIcon spritesDispararFlechas[];
    ImageIcon spritesCastSpell[];
    ImageIcon spritesKickSpell[];
    ImageIcon spritesJefe[];
    ImageIcon spritesJefeMuerto[];
    ImageIcon spritesMorir[];
    ImageIcon spritesVictoria[];
    /*-------------------------------*/

 /* Iconos Estaticos */
    ImageIcon spriteEstaticod;
    ImageIcon spriteEstaticoi;
    ImageIcon jefeI;
    ImageIcon corazon;
    ImageIcon barrav;
    /*------------------------*/

 /* Datos Variables */
    int Vida_Jefe = 40;
    int vida = 3;
    int daño = 4;
    int dañoSegundo = 4;
    int velocidadC = 15;
    int velocidadCS = 15;
    int velocidadJ = 40;
    boolean ingame;

    static String Disparos_Jefes = "";
    static String NombreJefe = "Mago";
    static int velocidad[] = new int[4];
    static int daños[] = new int[4];
    /*---------------------------------*/

 /* Contadores de Animaciones */
    int Contador_Movimiento = 0;
    int Contador_Salto_Arriba = 0;
    int Contador_Salto_Abajo = 3;
    int Contador_Disparo = 0;
    int Contador_Disparo_Arrow = 0;
    int Contador_Disparo_Spell = 0;
    int Contador_Disparo_Kick = 0;
    int Contador_Jefe = 0;
    int Contador_Disparo_Jefe = 0;
    int Contador_Jefe_Muerto = 0;
    int Contador_Muerte = 0;
    int Contador_Victoria = 0;

    /*------------------------*/

 /* Constructor */
    public stage() {
        ingame = true;
        setSize(600, 400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(new ImageIcon(new ImageIcon("src/Imagenes/Background.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT))));
        addKeyListener(this);
        crearLabel();
        imagenes();
        CargarDatosPersonaje();
        persona.setIcon(spriteEstaticod);
        jefe.setIcon(jefeI);
        lblh.setIcon(corazon);
        lblhe.setIcon(corazon);
        lblhea.setIcon(corazon);
        lblbarra.setIcon(barrav);
        lblbarra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        nj.setText(NombreJefe);
        lblvidajefe.setText(Integer.toString(Vida_Jefe));
        lblvida.setText(Integer.toString(vida));
        add(persona);
        add(jefe);
        add(nj);
        add(lblvidajefe);
        add(lblvida);
        add(lblh);
        add(lblhe);
        add(lblhea);
        add(lblbarra);
        setResizable(false);
        new Timer(250, new TimerJefe()).start();
        new Timer(300, new TimerMovJefe()).start();
        //disparojefesito = new disparojefe();
        //disparojefesito.setBounds(jefe.getX() - 45, jefe.getY() + 60, 66, 23);
        //new Timer(40, new TimerDisparoJefe()).start();
        new Timer(10, new TimerColisiones()).start();
    }

    public void crearLabel() {
        persona.setBounds(175, 314, 50, 37);
        jefe.setBounds(425, 200, 78, 148);
        nj.setBounds(425, 48, 60, 20);
        lblvidajefe.setBounds(555, 32, 60, 10);
        lblvida.setBounds(30, 20, 60, 10);
        lblh.setBounds(30, 20, 20, 20);
        lblhe.setBounds(50, 20, 20, 20);
        lblhea.setBounds(10, 20, 20, 20);
        lblbarra.setBounds(350, 30, 200, 15);
        lblvidajefe.setForeground(Color.CYAN);
        nj.setForeground(Color.CYAN);
        persona.setVisible(true);
        jefe.setVisible(true);
        nj.setVisible(true);
        lblvidajefe.setVisible(true);
        lblvida.setVisible(false);
        lblh.setVisible(true);
        lblhe.setVisible(true);
        lblhea.setVisible(true);
        lblbarra.setVisible(true);
    }

    public void imagenes() {
        spritesDerecha = new ImageIcon[4];
        for (int i = 0; i < 4; i++) {
            spritesDerecha[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-idle-0%d.png", i)).getImage()
            );
        }
        spritesIzquierda = new ImageIcon[4];
        for (int i = 0; i < 4; i++) {
            spritesIzquierda[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-run-1%d.png", i)).getImage()
            );
        }

        spritesSalto = new ImageIcon[4];
        for (int i = 0; i < 4; i++) {
            spritesSalto[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-jumps-0%d.png", i)).getImage()
            );
        }

        spritesDisparar = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            spritesDisparar[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-attac-0%d.png", i)).getImage()
            );
        }
        spritesDispararFlechas = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            spritesDispararFlechas[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-bow-0%d.png", i)).getImage()
            );
        }
        spritesCastSpell = new ImageIcon[8];
        for (int i = 0; i < 8; i++) {
            spritesCastSpell[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-cast-0%d.png", i)).getImage()
            );
        }
        spritesKickSpell = new ImageIcon[8];
        for (int i = 0; i < 8; i++) {
            spritesKickSpell[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-kick-0%d.png", i)).getImage()
            );
        }

        spritesJefe = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            spritesJefe[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/wizard0%d.png", i)).getImage()
                            .getScaledInstance(jefe.getWidth(), jefe.getHeight(), Image.SCALE_DEFAULT)
            );
        }
        spritesJefeMuerto = new ImageIcon[10];
        for (int i = 0; i < 10; i++) {
            spritesJefeMuerto[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/wdeath0%d.png", i)).getImage()
                            .getScaledInstance(jefe.getWidth(), jefe.getHeight(), Image.SCALE_DEFAULT)
            );
        }

        spritesMorir = new ImageIcon[7];
        for (int i = 0; i < 7; i++) {
            spritesMorir[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-die-0%d.png", i)).getImage()
            );
        }
        spritesVictoria = new ImageIcon[3];
        for (int i = 0; i < 3; i++) {
            spritesVictoria[i] = new ImageIcon(
                    new ImageIcon(String.format("src/Imagenes/adventurer-items-0%d.png", i)).getImage()
            );
        }

        spriteEstaticod = new ImageIcon(
                new ImageIcon("src/Imagenes/adventurer-estatico-01.png").getImage()
        );
        spriteEstaticoi = new ImageIcon(
                new ImageIcon("src/Imagenes/adventurer-estatico-02.png").getImage()
        );
        jefeI = new ImageIcon(
                new ImageIcon("src/Imagenes/wizard00.png").getImage()
                        .getScaledInstance(jefe.getWidth(), jefe.getHeight(), Image.SCALE_DEFAULT)
        );
        corazon = new ImageIcon(
                new ImageIcon("src/Imagenes/heart.png").getImage()
                        .getScaledInstance(lblh.getWidth(), lblh.getHeight(), Image.SCALE_DEFAULT)
        );
        barrav = new ImageIcon(
                new ImageIcon("src/Imagenes/barra.png").getImage()
                        .getScaledInstance(lblbarra.getWidth(), lblbarra.getHeight(), Image.SCALE_DEFAULT)
        );
    }

    public void CargarDatosPersonaje() {

        switch (Control.indice_1) {
            case 0:
                velocidadC = velocidad[0];
                daño = daños[0];
                break;
            case 1:
                velocidadC = velocidad[1];
                daño = daños[1];
                break;
            case 2:
                velocidadC = velocidad[2];
                daño = daños[2];
                break;
            case 3:
                velocidadC = velocidad[3];
                daño = daños[3];
                break;
            default:
                break;
        }

        switch (Control.indice_2) {
            case 0:
                velocidadCS = velocidad[0];
                dañoSegundo = daños[0];
                break;
            case 1:
                velocidadCS = velocidad[1];
                dañoSegundo = daños[1];
                break;
            case 2:
                velocidadCS = velocidad[2];
                dañoSegundo = daños[2];
                break;
            case 3:
                velocidadCS = velocidad[3];
                dañoSegundo = daños[3];
                break;
            default:
                break;
        }

    }

    private class TimerListenerR implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            persona.setIcon(spritesDerecha[Contador_Movimiento]);
            if (persona.getLocation().x <= 545) {
                persona.setLocation(persona.getLocation().x + 6, persona.getLocation().y);
                Contador_Movimiento++;
                if (Contador_Movimiento >= 3) {
                    Contador_Movimiento = 0;
                }
                //System.out.println(persona.getLocation().x);
                ((Timer) e.getSource()).stop();
            } else {
                if (Contador_Movimiento >= 3) {
                    Contador_Movimiento = 0;
                }
                Contador_Movimiento++;
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private class TimerListenerL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            persona.setIcon(spritesIzquierda[Contador_Movimiento]);
            if (persona.getLocation().x >= -5) {
                persona.setLocation(persona.getLocation().x - 6, persona.getLocation().y);
                Contador_Movimiento++;
                if (Contador_Movimiento >= 3) {
                    Contador_Movimiento = 0;
                }
                //System.out.println(persona.getLocation().x);
                ((Timer) e.getSource()).stop();
            } else {
                if (Contador_Movimiento >= 3) {
                    Contador_Movimiento = 0;
                }
                Contador_Movimiento++;
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private class TimerSalto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            persona.setIcon(spritesSalto[Contador_Salto_Abajo]);
            persona.setLocation(persona.getLocation().x, persona.getLocation().y + 20);
            Contador_Salto_Abajo--;
            if (Contador_Salto_Abajo < 0) {
                Contador_Salto_Abajo = 3;
                persona.setIcon(spriteEstaticod);
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private class TimerSaltar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            persona.setIcon(spritesSalto[Contador_Salto_Arriba]);
            persona.setLocation(persona.getLocation().x, persona.getLocation().y - 20);
            Contador_Salto_Arriba++;
            if (Contador_Salto_Arriba > 3) {
                Contador_Salto_Arriba = 0;
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private class TimerDisparar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            disparo.setLocation(disparo.getX() + 10, disparo.getY());
            Rectangle r1 = disparo.getBounds();
            Rectangle r2 = jefe.getBounds();
            if (disparo.getX() >= 570) {
                disparo.setVisible(false);
                disparo.setLocation(persona.getX() + 30, persona.getY());
                ((Timer) e.getSource()).stop();
            } else if (r1.intersects(r2)) {
                disparo.setVisible(false);
                disparo.setLocation(persona.getX() + 30, persona.getY());
                ((Timer) e.getSource()).stop();
                Vida_Jefe = Vida_Jefe - daño;
                /*if (Vida_Jefe <= 0) {
                    new Timer(60, new TimerMuerteJefe()).start();
                    new Timer(100, new TimerMuerteJefeS()).start();
                }*/
                System.out.println("Vida de Jefe:" + Vida_Jefe);
            }
        }
    }

    private class TimerDispararSegundo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            disparoS.setLocation(disparoS.getX() + 10, disparoS.getY());
            Rectangle r1 = disparoS.getBounds();
            Rectangle r2 = jefe.getBounds();
            if (disparoS.getX() >= 570) {
                disparoS.setVisible(false);
                disparoS.setLocation(persona.getX() + 30, persona.getY());
                ((Timer) e.getSource()).stop();
            } else if (r1.intersects(r2)) {
                disparoS.setVisible(false);
                disparoS.setLocation(persona.getX() + 30, persona.getY());
                ((Timer) e.getSource()).stop();
                Vida_Jefe = Vida_Jefe - dañoSegundo;
                /*if (Vida_Jefe <= 0) {
                    new Timer(60, new TimerMuerteJefe()).start();
                    new Timer(100, new TimerMuerteJefeS()).start();
                }*/
                System.out.println("Vida de Jefe:" + Vida_Jefe);
            }
        }
    }

    private class TimerDisparando implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Control.indice_1) {
                case 0:
                    if (Contador_Disparo <= 5) {
                        persona.setIcon(spritesDisparar[Contador_Disparo]);
                        Contador_Disparo++;
                        if (Contador_Disparo > 5) {
                            Contador_Disparo = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 1:
                    if (Contador_Disparo_Arrow <= 8) {
                        persona.setIcon(spritesDispararFlechas[Contador_Disparo]);
                        Contador_Disparo_Arrow++;
                        if (Contador_Disparo_Arrow > 8) {
                            Contador_Disparo_Arrow = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 2:
                    if (Contador_Disparo_Spell <= 7) {
                        persona.setIcon(spritesCastSpell[Contador_Disparo_Spell]);
                        Contador_Disparo_Spell++;
                        if (Contador_Disparo_Spell > 7) {
                            Contador_Disparo_Spell = 0;
                            //persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 3:
                    if (Contador_Disparo_Kick <= 7) {
                        persona.setIcon(spritesKickSpell[Contador_Disparo_Kick]);
                        Contador_Disparo_Kick++;
                        if (Contador_Disparo_Kick > 7) {
                            Contador_Disparo_Kick = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private class TimerDisparandoSegundo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (Control.indice_2) {
                case 0:
                    if (Contador_Disparo <= 5) {
                        persona.setIcon(spritesDisparar[Contador_Disparo]);
                        Contador_Disparo++;
                        if (Contador_Disparo > 5) {
                            Contador_Disparo = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 1:
                    if (Contador_Disparo_Arrow <= 8) {
                        persona.setIcon(spritesDispararFlechas[Contador_Disparo]);
                        Contador_Disparo_Arrow++;
                        if (Contador_Disparo_Arrow > 8) {
                            Contador_Disparo_Arrow = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 2:
                    if (Contador_Disparo_Spell <= 7) {
                        persona.setIcon(spritesCastSpell[Contador_Disparo_Spell]);
                        Contador_Disparo_Spell++;
                        if (Contador_Disparo_Spell > 7) {
                            Contador_Disparo_Spell = 0;
                            //persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                case 3:
                    if (Contador_Disparo_Kick <= 7) {
                        persona.setIcon(spritesKickSpell[Contador_Disparo_Kick]);
                        Contador_Disparo_Kick++;
                        if (Contador_Disparo_Kick > 7) {
                            Contador_Disparo_Kick = 0;
                            persona.setIcon(spriteEstaticod);
                            ((Timer) e.getSource()).stop();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private class TimerJefe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Contador_Jefe <= 5) {
                jefe.setIcon(spritesJefe[Contador_Jefe]);
                Contador_Jefe++;
                if (Contador_Jefe > 5) {
                    Contador_Jefe = 0;
                }
            }
            if (ingame == false) {
                ((Timer) e.getSource()).stop();
                //vidaJ = 40;
            }
        }
    }

    private class TimerMovJefe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Random r = new Random();
            int posx = (int) (Math.pow(-1, r.nextInt(4))) * (r.nextInt(500));
            int posy = (int) (Math.pow(-1, r.nextInt(4))) * (r.nextInt(250));
            if (posx < 600 && posx > 250 && posy < 400 && posy > 0) {
                jefe.setLocation(posx, posy);
                //nj.setLocation(jefe.getX() + 35, jefe.getY() - 20);
                //System.out.println(posx);
            }
            if (ingame == false) {
                ((Timer) e.getSource()).stop();
            }
        }
    }

    private class TimerDisparoJefe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //contadorjd++;
            disparojefesito.setVisible(true);
            add(disparojefesito);
            //if (Contador_Disparo_Jefe == 5) {
            disparojefesito.setLocation(disparojefesito.getX() - 6, disparojefesito.getY());
            //contadorjd = 0;
            Rectangle r3 = disparojefesito.getBounds();
            Rectangle r4 = persona.getBounds();
            if (disparojefesito.getX() <= 0) {
                disparojefesito.setLocation(jefe.getX() - 45, jefe.getY() + 60);
                disparojefesito.setVisible(false);
                //((Timer) e.getSource()).stop();
            } else if (r3.intersects(r4)) {
                disparojefesito.setVisible(false);
                disparojefesito.setLocation(jefe.getX() - 45, jefe.getY() + 60);
                //((Timer) e.getSource()).stop();
                vida = vida - 1;
                if (vida == 2) {
                    lblhe.setVisible(false);
                }
                if (vida == 1) {
                    lblh.setVisible(false);
                }
                if (vida == 0) {
                    lblhea.setVisible(false);
                    new Timer(60, new TimerMuerte()).start();
                    ((Timer) e.getSource()).stop();
                }
                System.out.println("Vida mia: " + vida);
            }
            if (ingame == false) {
                ((Timer) e.getSource()).stop();
            }
            //jefe.setIcon(jefeI);
            //((Timer) e.getSource()).stop();
            //}
        }
    }

    private class TimerColisiones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lblvidajefe.setText(Integer.toString(Vida_Jefe));
            lblvida.setText(Integer.toString(vida));
            lblbarra.setBounds(350, 30, Vida_Jefe * 5, 15);
            //System.out.println("Yo: " + vida + " - Jefe: " + Vida_Jefe);
            if (Vida_Jefe <= 0) {
                new Timer(60, new TimerMuerteJefe()).start();
                new Timer(100, new TimerMuerteJefeS()).start();
                ((Timer) e.getSource()).stop();
                ingame = false;
                JOptionPane.showMessageDialog(null, "Derrotaste a " + NombreJefe, "Felicidades", JOptionPane.INFORMATION_MESSAGE);
            } else if (vida == 0) {
                ((Timer) e.getSource()).stop();
                JOptionPane.showMessageDialog(null, "Has muerto", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                String name = JOptionPane.showInputDialog("Ingresa Tus Iniciales: ");
                for (int i = 0; i < stage2.iniciales.length; i++) {
                    if (stage2.iniciales[i] == null) {
                        stage2.iniciales[i] = name;
                        break;
                    }
                }
                new Reporte().setVisible(true);
                ingame = false;
            }
        }
    }

    private class TimerMuerte implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //if (Contador_Muerte <= 6) {
            persona.setIcon(spritesMorir[Contador_Muerte]);
            Contador_Muerte++;
            if (Contador_Muerte > 6) {
                Contador_Muerte = 0;
                persona.setIcon(spritesMorir[6]);
                ((Timer) ae.getSource()).stop();
            }
            //}
        }
    }

    private class TimerMuerteJefe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //if (Contador_Muerte <= 6) {
            persona.setIcon(spritesVictoria[Contador_Victoria]);
            Contador_Victoria++;
            Contador_Jefe_Muerto++;
            if (Contador_Victoria > 2) {
                Contador_Victoria = 0;
                //((Timer) ae.getSource()).stop();
            }
            //}
        }
    }

    private class TimerMuerteJefeS implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            jefe.setIcon(spritesJefeMuerto[Contador_Jefe_Muerto]);
            Contador_Jefe_Muerto++;
            if (Contador_Jefe_Muerto > 9) {
                Contador_Jefe_Muerto = 0;
                //jefe.setLocation(jefe.getX(), 300);
                jefe.setIcon(spritesJefeMuerto[9]);
                ((Timer) ae.getSource()).stop();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == ventana.keyderecha) {
            new Timer(40, new TimerListenerR()).start();
            //System.out.println(key + " - " + ventana.keyderecha);
        } else if (key == ventana.keyizquierda) {
            new Timer(40, new TimerListenerL()).start();
            //System.out.println(key + " - " + ventana.keyizquierda);
        } else if (key == ventana.keysalto) {
            new Timer(20, new TimerSaltar()).start();
            new Timer(80, new TimerSalto()).start();
            //System.out.println(key + " - " + ventana.keysalto);
        } else if (key == ventana.keydisparo1) {
            new Timer(velocidadC + 10, new TimerDisparando()).start();
            disparo = new disparo1();
            switch (Control.indice_1) {
                case 0:
                    disparo.setBounds(persona.getX() + 25, persona.getY(), 16, 37);
                    break;
                case 1:
                    disparo.setBounds(persona.getX() + 25, persona.getY(), 28, 18);
                    break;
                case 2:
                    disparo.setBounds(persona.getX() + 25, persona.getY(), 59, 48);
                    break;
                case 3:
                    disparo.setBounds(persona.getX() + 25, persona.getY(), 46, 35);
                    break;
                default:
                    break;
            }
            disparo.setVisible(true);
            add(disparo);
            new Timer(velocidadC, new TimerDisparar()).start();
            //System.out.println(key + " - " + ventana.keydisparo1);
        } else if (key == ventana.keydisparo2) {
            new Timer(velocidadCS + 10, new TimerDisparandoSegundo()).start();
            disparoS = new disparo2();
            switch (Control.indice_2) {
                case 0:
                    disparoS.setBounds(persona.getX() + 25, persona.getY(), 16, 37);
                    break;
                case 1:
                    disparoS.setBounds(persona.getX() + 25, persona.getY(), 28, 18);
                    break;
                case 2:
                    disparoS.setBounds(persona.getX() + 25, persona.getY(), 59, 48);
                    break;
                case 3:
                    disparoS.setBounds(persona.getX() + 25, persona.getY(), 46, 35);
                    break;
                default:
                    break;
            }
            disparoS.setVisible(true);
            add(disparoS);
            new Timer(velocidadCS, new TimerDispararSegundo()).start();
            //System.out.println(key + " - " + ventana.keydisparo1);
        } else if (key == KeyEvent.VK_ESCAPE) {
            this.dispose();
            //vidaJ = 40;
            //vida = 3;
            new Inicio().setVisible(true);
        } else if (key == KeyEvent.VK_0) {
            disparojefesito = new disparojefe();
            disparojefesito.setBounds(jefe.getX() - 45, jefe.getY() + 60, 66, 23);
            new Timer(40, new TimerDisparoJefe()).start();
            //vidaJ = 40;
            //vida = 3;
        } else if (key == KeyEvent.VK_9) {
            Disparos_Jefes = "stage2";
            this.dispose();
            new stage2().setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == ventana.keyderecha) {
            persona.setIcon(spriteEstaticod);
        } else if (key == ventana.keyizquierda) {
            persona.setIcon(spriteEstaticoi);
        }
    }

}
