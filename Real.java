//メインクラス。現実的なゲームがコンセプトだからReal
import sound.Sounds;
import panel.Items;
import main_panel.Charctor;

import javax.swing.*;
import java.awt.event.*;

public final class Real extends JFrame implements KeyListener{
    public static final int MASU = 15;
    public static final int WIDTH = (MASU+1) << 5;
    public static final int HEIGHT = MASU << 5;

    private int v = 1;
    static long status;
    static int coords,power;
    static int item_quantity[] = new int[10];
    static String items[] = new String[10];
    static String equip[] = new String[2];

    Items im;
    Charctor charc;
    Title ti = new Title();
    Sounds sound = new Sounds();
    private static Real frame = new Real();

    public static void main(String[] args) {
        frame_generator();
    }
    public static Real frame_generator() {
        return frame;
    }
    private Real() {
        super.add(ti);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300,100,WIDTH+16, HEIGHT+39);
        setTitle("Othello");
        setVisible(true);
        setResizable(false);
        addKeyListener(this);
    }
    private void panel_change(JPanel panel, int v) {//パネルチェンジ
        frame_generator().getContentPane().removeAll();	
        frame_generator().add(panel);
        if(v != 2) panel.requestFocus();
        repaint();
    }
    public void load_confirm(int coords) {//xy座標と階数を抽出
        int x = coords >>12;
        int y = (coords >> 2) & 0b1111111111;
        int floor_num = (coords & 3);

        if(Load_panel.load_confirm) {
            im = new Items(items,status,power,item_quantity,equip);
            panel_change(charc = new Charctor(x,y,floor_num,false,im ,HEIGHT, WIDTH), v);
        }
    }
    public void keyPressed(KeyEvent e) {
        int dire = 0;
        int key = e.getKeyCode();
        if(Load_panel.load_panel_open) {
            ti.conrtoll(e, key);
        } else if(!Load_panel.load_panel_open) {

            if(key == KeyEvent.VK_UP)      dire = 3;
            if(key == KeyEvent.VK_DOWN)    dire = 4;

            if(dire == 3 && v > 1) v--;
            if(dire == 4 && v < 3) v++;
        
            ti.aaa(v);
            if(key == KeyEvent.VK_ENTER) {
                if(v == 3) {
                    System.exit(0);
                } else if(v == 2) {
                    panel_change(ti = new Title(), v);
                    Load_panel.load_panel_open = true;
                    v = 1;
                } else {
                    im = new Items();
                    panel_change(charc = new Charctor(85,125,0,true,im,HEIGHT, WIDTH), v);
                    Sounds.sound_chage(true);
                }
            } 
        }
        load_confirm(coords);
        repaint();
    } 
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}