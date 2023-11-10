package panel.epi_and_pro;

import javax.swing.JPanel;

import java.awt.*;

import java.util.Timer;
import java.util.TimerTask;

public class Prologue extends JPanel{
    private String serif[] ={
    "KUROI-COMPANY�������",
    "���̉�Ђ́A�j���Ј��͓�������c�Ƃ��������Ă���",
    "�����Ј��͏�i����̃Z�N�n���ɑς�����X�ł���B",
    "�e��蓖���Ȃ��A���R�c�Ƒ���x�����邱�Ƃ͂Ȃ��B",
    "���̖��̒ʂ�u���b�N�ȉ�Ђł���B"};

    Color color;
    private String col_one = "";
    private StringBuilder bui1 = new StringBuilder();

    private String array[] ={""};
    private int i = 0;
    private int serif_index;
    Timer time = new Timer();

    public Prologue() {
        setSize(512, 480);
        time.scheduleAtFixedRate(new Task(), 1500, 100);
    }
    public void paint_opening(Graphics g,int alpha, Font font) {
        color = new Color(0,0,0,alpha);
        g.setFont(font);
        g.setColor(color);

        g.fillRect(0,0,512, 480);//�w�i
        g.setColor(new Color(0,0,0));
        g.fillRoundRect(75, 350, 350, 100, 10, 10);
        g.setColor(Color.WHITE);
        g.drawRoundRect(75, 350, 350, 100, 10, 10);
        g.setColor(new Color(0,0,0));
        g.fillRoundRect(90, 340, 140, 25, 10, 10);
        g.setColor(Color.WHITE);
        g.drawRoundRect(90, 340, 140, 25, 10, 10);

        g.drawString("��Ј�",95,360);
        g.drawString(col_one,80,382);
    }
    private void concatenate(int i) {
        bui1.append(array[i]);
        col_one = bui1.toString();
    }
    public void serif_change(int j) {
        if(i >= array.length) {
            bui1.delete(0,30);
            serif_index = j;
            i = 0;
        }
    }
    public boolean can_serif_change() {
        if(i < array.length) return false;
        return true;
    }
    private class Task extends TimerTask{
        public void run() {
            array = serif[serif_index].split("");
            if(i < array.length) {
                concatenate(i);
                i++;
            }
        }
    }
}