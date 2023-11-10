package panel;

import java.awt.*;
import javax.swing.JPanel;

public class Floors extends JPanel{
    private Image map = Toolkit.getDefaultToolkit().getImage("image/unnamed.jpg");
    private Image charc = Toolkit.getDefaultToolkit().getImage("image/charc.png");
    private int floors[][][];

    public Floors(int three_array[][][]) {
        this.floors = three_array;
    }
    public final void paint_map(Graphics g, int sx, int sy, int floor_num) {
        int x1=1, y1=1, x2 = 0;
        for(int i = 1; i < floors[floor_num].length; i++) {
            y1 = ((i-1) << 5)+sy;
            for(int j = 0; j < floors[floor_num][i].length; j++) {
                x1 = (j << 5)+sx;
                switch(floors[floor_num][i][j]){
                    case 1:  x2 = 0;     break;
                    case 2:  x2 = 40;    break;
                    case 3:  x2 = 80;    break;
                    case 4:  x2 = 120;   break;
                    case 5:  x2 = 160;   break;
                    case 6:  x2 = 200;   break;
                    case 7:  x2 = 240;   break;
                    case 8:  x2 = 280;   break;
                    case 9:  x2 = 320;   break;
                    case 10: x2 = 360;   break;
                    case 11: x2 = 400;   break;
                    case 12: x2 = 440;   break;
                    case 13: x2 = 480;   break;
                    case 14: x2 = 520;   break;
                    case 70: x2 = 560;   break;
                    case 71: x2 = 600;   break;
                    default: x2 = 640;   break;
                } 
                g.drawImage(map, x1, y1, x1+32, y1+32,
                                 x2, 0, x2+40, 40,this);
                switch(floors[floor_num][i][j]){
                    case 55:  x2 = 80;     break;
                    case 54:  x2 = 80;     break;
                    default: continue;
                } 
                g.drawImage(charc, x1, y1, x1+28, y1+28,
                                   x2, 0, x2+40, 40,this);
            }
        }
    }
}