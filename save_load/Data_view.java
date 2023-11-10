package save_load;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;

import java.util.List;
import java.awt.*;
import javax.swing.JPanel;
public class Data_view extends JPanel{
    private int y = 30; 

    static String save_list[] = {",,,,,,",",,,,,,",",,,,,,",",,,,,,",
                                 ",,,,,,",",,,,,,",",,,,,,",",,,,,,"};
    Color select = new Color(200,200,200,155);

    private String view_savedata[] = {"","","","","","","",""};
    public Data_view() {
        save_data_read();
    }
    public void paintComponent(Graphics g) {//このメソッドだけは全員の書き換えを許可
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(select);
        g.fillRect(0,y+40,230,30);

        g.setColor(Color.BLACK);
        g.drawRect(0,15,230,325);

        g.drawLine(110,45,110,340);
        g.drawLine(0,45,230,45);
        g.drawLine(0,70,230,70);

        g.drawString("業務日報",87,35);
        g.drawString("月日",45,63);
        g.drawString("記入者",155,63);

        for(int i = 0; i < 8; i++) {
            g.drawString(view_savedata[i],10,(i*30)+90);
        }
        for(int i = 0; i < 8; i++) {
            g.drawLine(0,(i*30)+100,230,(i*30)+100);//データの間の横線
        }
    }
    private void save_data_read() {
        Path path = Paths.get("save_load/saveData.txt");
        Charset charset = Charset.forName("shift-JIS");
        try {
      	    List<String> lineList = Files.readAllLines(path,charset);
            String data[];
            int i = -1;
            for (String line : lineList) {
                i++;
                data = line.split(",");
                if(data.length == 0) continue;
                save_list[i] = line;
                view_savedata[i] = data[1]+"年 "+data[2]+"月 "+data[3]+"日"+"     " +data[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    public void square_up_down(int v) {
        y = 30*v;
    }
}