package main_panel;
//メインパネルクラス
import panel.*;
import panel.epi_and_pro.*;

import save_load.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
public class Charctor extends JPanel implements KeyListener,Runnable{

    private Image jiki= Toolkit.getDefaultToolkit().getImage("image/enemy1.png");

    private int dire, direction;
    private int x, y,floor_num; 

    private boolean front_leg_left, new_game;
    private final int width, height;
    private int alpha = 255;
    private int next_serif;
    private final Font font = new Font("HGPGothicM", Font.PLAIN, 15);
    private final Font font_n = new Font("HGPGothicM", Font.PLAIN, 25);
    private final Font font_s = new Font("HGPGothicM", Font.PLAIN, 18);
    
    private static int floors[][][] = Maps.floors();
    Items im;

    Floors fs = new Floors(floors);
    Battle bt = new Battle();
    Prologue pro = new Prologue();
    Communicate cm = new Communicate(); 

    public Charctor(int x, int y, int floor_num, boolean new_game, Items im, int height, int width) {
        this.im = im;
        this.new_game = new_game;
        this.x = x;
        this.y = y;
        this.floor_num = floor_num;
        this.width = width; 
        this.height = height;

        setSize(width, height);
        addKeyListener(this);
        setFocusable(true);

        Thread th = new Thread(this);
        th.start(); 
        Charactor_walk char_walk = new Charactor_walk(); 
        char_walk.start();
    }
    public void paintComponent(Graphics g) {//描画
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON); 
        bt.paint_battle(g,font_n,font_s);
        if((bt.flgs & 1) == 1) return;

        fs.paint_map(g, scroll_x(), scroll_y(), floor_num);
        cm.paint_message(g,font);
        int xx = x-14+scroll_x();
        int yy = y-45+scroll_y();
        int y1 = 120;
        int x1 = 0;
        if(dire != 0) direction = dire;
        switch(direction) {
            case 1:  y1 = 40;   break;
            case 2:  y1 = 0;    break;
            case 3:  y1 = 80;   break;
            case 4:  y1 = 120;  break; 
        }
        if(front_leg_left) {
            x1 = 40;
        } else {
            x1 =  0;
        }
        g.drawImage(jiki, xx, yy, xx+28, yy+28, x1, y1, x1+40, y1+40, null);
        im.paint_items(g,font);
        if(new_game)  pro.paint_opening(g,alpha,font);
        Epilogue.paint_ending(g,font);
    }
    private boolean can_move(int x, int y) {//衝突しているか否かを返す関数
        if(floors[floor_num][y][x] >= 1 &&
           floors[floor_num][y][x] <= 69) return false;     
        return true;
    }
    private void char_move() {//移動速度や当たり判定を調節
        int speed = 3;
        int fx = 0, fx1 = 0, fy = 0, fy1 = 0;
        switch(dire) {
            case 1: fx = (x-7 - speed) >> 5;
                    fy = (y-7) >> 5;
                    fy1 = (y+7) >> 5;
                    if(can_move(fx,fy) && can_move(fx,fy1))  x -= speed;
                    break;
            case 2: fx = (x+7 + speed) >> 5;
                    fy = (y-7) >> 5;
                    fy1 = (y+7) >> 5;
                    if(can_move(fx,fy) && can_move(fx,fy1))  x += speed;
                    break;
            case 3: fy = (y-13-speed) >> 5;
                    fx = (x-5) >> 5;
                    fx1 = (x+5) >> 5;
                    if(can_move(fx,fy) && can_move(fx1,fy))  y -= speed;
                    break;
            case 4: fy = (y+13+speed) >> 5;
                    fx = (x-5) >> 5;
                    fx1 = (x+5) >> 5;
                    if(can_move(fx,fy) && can_move(fx1,fy))  y += speed;
                    break; 
        }
        Save.save_coords(x,y,floor_num);
    }
    private void floor_change(int xx, int yy) {//階段を上るor下る
        if(floors[floor_num][yy][xx] == 71) {
            x = 530;  floor_num++;
            y = 80;  direction = 3;
            direction = 4;
        } else if(floors[floor_num][yy][xx] == 70) {
            x = 592;  floor_num--;
            y = 80;  direction = 3;
            direction = 4;
        }    
    }
    private int scroll_x() {//x方向にスクロールする関数
        int map_width = floors[floor_num][0].length;
        int panel_width = map_width << 5;
        if(x >= panel_width-(width >> 1))  return width - panel_width;
        if(x <= width >> 1) return 0;
        return (width >> 1) - x;
    }
    private int scroll_y() {//y方向にスクロールする関数
        int map_height = floors[floor_num].length;
        int panel_height = map_height << 5;
        if(y >= panel_height-((height >> 1)+32)) return height - panel_height+32;
        if(y <= height >> 1) return 0;
        return (height >> 1) - y;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_ENTER && new_game && pro.can_serif_change()) {
            if(next_serif < 4) {
                pro.serif_change(++next_serif);
            } else if(next_serif >= 4) {
                next_serif++;
            }
        }
        if(new_game) return;
        int xx = x >> 5;
        int yy = y >> 5;

        int object_num = floors[floor_num][yy][xx];

        if(bt.flgs == 0 && !im.item_check && cm.flgs == 0 && !new_game) {
            if(key == KeyEvent.VK_LEFT)    dire = 1;
            if(key == KeyEvent.VK_RIGHT)   dire = 2;
            if(key == KeyEvent.VK_UP)      dire = 3;
            if(key == KeyEvent.VK_DOWN)    dire = 4;
        }
        if(key == KeyEvent.VK_SPACE && !im.item_check && cm.flgs == 0) {
            floor_change(xx,yy);
            if(cm.battle_start()) {
                bt.battle_flg(floor_num, object_num,cm.enemy_num);
                cm.communicate_flg(floor_num, object_num,false); 
            } else if(bt.flgs == 0) cm.communicate_flg(floor_num, object_num,true); 
        }
        if(key == KeyEvent.VK_A && cm.flgs == 0 && bt.flgs == 0) {
            im.item_open();
        }
        if(key == KeyEvent.VK_S) {
            if(!im.item_check) {
                object_num = floors[floor_num][yy][xx];
                im.item_add(floors, floor_num, xx, yy);
            }
        }
        if(im.item_check) {  
            im.controll(e, key);
        } else {
            if(cm.flgs != 0)  cm.controll(e, key);
            if(bt.flgs != 0)  bt.controll(e, key);
        }
    } 
    public void keyReleased(KeyEvent e) {
        dire = 0;
    }
    public static final void array_trans_form(int x, int y, int floor_num, int after) {
        floors[floor_num][x][y] = after;
    }
    public void keyTyped(KeyEvent e) {}
    public void run() {
        while(true) {
            if(cm.flgs == 0 && bt.flgs == 0 && !im.item_check && !new_game) {
                char_move();
            }
            if(next_serif > 4 && alpha > 1) { alpha -= 2;
            } else if(alpha <= 1) { new_game = false;}
            repaint();
            try{
                Thread.sleep(14);
            } catch(InterruptedException e) {}
        }
    }
    private class Charactor_walk extends Thread {//右足か左足か
        public void run() {
            while(true) {
                if(dire != 0) front_leg_left = !front_leg_left;
                try{
                    Thread.sleep(300);
                } catch(InterruptedException e) {}
            }
        }
    }
}
