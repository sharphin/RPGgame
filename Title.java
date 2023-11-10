//�^�C�g����ʂ̃N���X
import java.awt.*;

import java.awt.event.*;
import javax.swing.JPanel;
public class Title extends JPanel{

    Image title= Toolkit.getDefaultToolkit().getImage("image/title.jpg");
    private Color black = new Color(0, 0, 0, 200);
    private Color cyan = new Color(0,174,239,100);
    
    private final Font font = new Font("Serif", Font.BOLD, 28);
    private final Font font_n = new Font("HGPGothicM", Font.PLAIN, 15);
    private int y= 50;

    Load_panel lp = new Load_panel();
    public Title(){
        setSize(512, 480);
    }
    public void paintComponent(Graphics g) {//�����͑S���̏�������������
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        if(Load_panel.load_panel_open) {
            lp.paint_load_panel(g, font_n);
            return;
        }
        g.drawImage(title, 0,0,this);
        g.setFont(font);
        g.setColor(black);
        g.fillRoundRect(140,210,200,200,70,70);
        g.setColor(Color.WHITE);
        g.drawRoundRect(140,210,200,200,70,70);
        g.setColor(Color.WHITE);
        g.drawString("�莞�ގ�RPG",155,160);
        g.drawString("�J�n����",180,280);
        g.drawString("���[�h",190,330);
        g.drawString("�I������",180,375);
        g.setColor(cyan);

        g.fillRect(150,195+y,180,50);
    }
    public void aaa(int p) {
       y = 50 * p;
    }
    public void conrtoll(KeyEvent e, int key) {
        lp.load_panel_controll(e, key);
        repaint();
    }
}