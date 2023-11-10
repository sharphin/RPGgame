//ロード画面のクラス
import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

import java.util.List;
import java.util.Arrays;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class Load_panel extends JPanel{
    private int x, y;

    private int v, d = 2;
    private int v_range = 1;
    private boolean can_load;
    private boolean load_verification;//ロードするか確認
    static boolean load_panel_open;//ロードパネルが開いている
    static boolean load_confirm;//ロード確定
    

    private String save_items[][] = new String[10][10];//アイテムの種類
    private int item_quantity[][] = new int[8][10];
    private String equip[][] = new String[8][2];

    private String save_name[] = new String[8];//セーブデータの名前
    private String save_date[] = new String[8];//セーブした年月日
    private long save_status[] = new long[8];//セーブした地点の所持金、HP,MP
    private int save_coords[] = new int[8];//セーブした地点のxy座標と階数
    private int save_power[] = new int[8];

    Color box = new Color(0,75,160,255);
    Color mail = new Color(0,65,130,255);
    Color start = new Color(200,200,200,255);

    public Load_panel() {
        setSize(Real.WIDTH, Real.HEIGHT);
        setFocusable(true);
        inputArray_saveData();
    }
    public void paint_load_panel(Graphics g, Font font) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,Real.WIDTH,Real.HEIGHT);
        g.setColor(Color.GRAY);
        g.fillRoundRect(180,40,150,30,10,10);//戻る枠

        g.setColor(mail);
        g.fillRect(0,0,520,25);
        g.setColor(box);
        g.fillRect(0,25,170,500);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("─　　□　　×",410,17);
        g.drawString("受信トレイ-buraku0209intlook.jp-メール",10,17);
        g.drawString("─",20,40);
        g.drawString("─",20,44);
        g.drawString("─",20,48);

        g.drawString("＋　新規メール",20,80);
        g.drawString("Ｖ　お気に入り",20,120);
        g.drawString("　　受信トレイ",20,150);
        g.drawString("　　送信済みアイテム",20,180);
        g.drawString("　　下書き",20,210);
        g.drawString("Ｖ　フォルダー",20,250);
        g.drawString("　　受信トレイ",20,280);
        g.drawString("　　送信済みアイテム",20,340);
        g.drawString("　　下書き",20,310);
        g.drawString("　　削除済みアイテム",20,370);
        g.drawString("　　迷惑メール",20,400);
        g.drawString("　　アーカイブ",20,430);
        g.drawString("　　ゴミ箱",20,460);

        for(int i = 0; i < 8; i++) {
            g.setColor(Color.GRAY);
            g.fillRect(170,72+(i*50),500,2);//データ間線
            g.setColor(Color.BLACK);
            g.drawString(save_name[i],190,90+(i*50));//名前
            g.drawString(save_date[i],190,110+(i*50));//日付
        }
        g.setColor(Color.BLACK);
        if(v != -1) {
            g.drawRoundRect(180+x,75+y,320,45,10,10);
            g.drawString("データ" + (v+1),190,60);
        } else {
            g.drawRoundRect(470,1,39,22,10,10);
            g.drawString("戻る",190,60);
        }
        if(load_verification && can_load) { 
            g.setColor(start);
            g.fillRect(120,180,300,100);
            g.setColor(Color.BLACK);
            g.drawString(save_name[v] +"で出社しますか",200,200);
            g.drawString("はい　　　　　　いいえ",190,250);   
            g.drawRect((d*100)+153,220,100,50);     
        }
    }
    public void load_panel_controll(KeyEvent e, int key) {
        int dire = 0;
        if(!load_verification) {
            if(key == KeyEvent.VK_UP)      dire = 3;
            if(key == KeyEvent.VK_DOWN)    dire = 4;
        } else {
            if(key == KeyEvent.VK_LEFT)      d = 0;
            if(key == KeyEvent.VK_RIGHT)     d = 1;
        }
        for(int i = 0; i < 8; i++) {
            if(save_name[i].equals("")) break;
            v_range = i;
        }
        if(dire == 3 && v >= 0)  v--;
        if(dire == 4 && v < v_range)  v++;      
        if(key == KeyEvent.VK_ENTER) {
            if(!can_load && v != -1) return;
            if(d == 0 && load_verification) {
                load_confirm = true;
            } else if(d == 1 && load_verification){
                load_verification = false;
                d = 2;
            } else if(v != -1) {
                Real.coords = save_coords[v];
                Real.status = save_status[v];
                for(int i = 0; i < Real.items.length; i++) {
                    Real.items[i] = save_items[v][i];
                }
                Real.item_quantity = Arrays.copyOf(item_quantity[v],10);
                Real.equip = equip[v];
                Real.power = save_power[v];
                load_panel_open = true;
                load_verification = true;

                d = 0;
            } else if(v == -1){
                load_panel_open = false;
            }
        }
        if(v == -1) return;
        if(dire == 3 || dire == 4) y = 50*v;
    }
    public void array_init() {
        for(String s[]: save_items) {
            Arrays.fill(s, "");
        }
        Arrays.fill(save_name, "");
        Arrays.fill(save_date, "");
    }
    public void inputArray_saveData() {
        Path path = Paths.get("save_load/saveData.txt");
        Charset charset = Charset.forName("shift-JIS");
        array_init();
        try {
      	    List<String> line_list = Files.readAllLines(path,charset);
            if(line_list.size() > 0)  can_load = true;
            String data[];
            int i = -1;
            for (String line : line_list) {
                i++;
                StringBuilder builder = new StringBuilder();
                data = line.split(",");
                if(data.length == 0) continue;
                builder.append(data[1]).append("年");
                builder.append(data[2]).append("月");
                builder.append(data[3]).append("日");

                String recording_date = builder.toString();
                save_name[i] = data[0];
                save_date[i] = recording_date;

                save_coords[i] = Integer.parseInt(data[4]);
                save_status[i] = Long.parseLong(data[5]);
                save_power[i] = Integer.parseInt(data[6]);  

                equip[i][0] = data[17];
                equip[i][1] = data[18];

                for(int j = 7; j < 17;j++) {
                    item_quantity[i][j-7] = Integer.parseInt(data[j]);
                }
                for(int j = 19; j < data.length;j++) {
                    save_items[i][j-19] = data[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}