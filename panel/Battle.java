package panel;
//戦闘画面関係の処理はここにまとめる
import sound.Sounds;
import static panel.Charctor_status.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.SplittableRandom;

public class Battle extends JPanel {
    Damege_effect de;
    SplittableRandom random;

    public Battle() {
        random = new SplittableRandom();
        de = new Damege_effect();
        de.start();
    }
    public int flgs;
    private int y, x = 20, v, used_v, width_x;
    private final Image back_img = Toolkit.getDefaultToolkit().getImage("image/battle.jpg");
    private static Image enemy_img;
    
    private static final int ATTACK = 1 << 4;
    private static final int DEFENCE = 1 << 5;
    private static final int ITEM_VIEW = 1 << 6;
    private static final int SKILL_VIEW = 1 << 7;
    private static final int ITEM_USE = 1 << 8;
    private static final int SKILL_USE = 1 << 9;
    private static final int ITEM_USED = 1 << 10;
    private static final int SKILL_USED = 1 << 11;
    private static final int LOSE_OR_WIN = 1 << 14;

    private final Color dark_gray = new Color(0,50,0,200);
    private final Color orange = new Color(255,165,0);
    private final Color blue = new Color(30,144,255);
    private final Color cyan = new Color(0,174,239,100);

    private final String battle_mode[] = {" 戦う ","調べる","逃げる"};
    private final String attack[] = {" 攻撃"," 防御","所持品"," 特技"," 戻る"};

    private final String skills[] = {"ため口","愚痴","ごますり","我慢","戻る"};
    private final int consume[] =   { 50,        50,        175,       250};
    private final String ccoment[] = {"武器で攻撃します","ダメージを半減します",
                                      "道具を使います","技を使用します"};

    private final String scoment[] = {"50%の確率で相手を「興奮」させる(4ターン)",
                                      "攻撃力、防御力が10%上がる(5ターン)",
                                      "相手の攻撃力をこの戦闘中5％下げる(3ターン)",
                                      "次の自分の攻撃のダメージを2倍にする"};
    private String battle_log = "";
    private String enemy_name = "";
    private int enemy_hp;
    private int offe_power_enemy;
    
    private int turn_count, use_turn;
    private int offe_power = offence, defe_power = defence; 
    private int damege = 500, item_view_range; 
    private static int enemy_num;

    private boolean visible = true, cant_use,item_select;

    public void paint_battle(Graphics g,Font font_n,Font font_s) {
        if((flgs & 1) == 0) return;
        g.setFont(font_n);
        g.drawImage(back_img, 0,0,this);
        g.drawString(enemy_name+ "　"+"HP：" +enemy_hp,140,30);//相手のHP表記
        if(visible)  g.drawImage(enemy_img, 150,90,this);//相手の画像

        g.setColor(Color.RED);
        g.fillRect(40,40,enemy_hp/gage_length(enemy_num),25);//相手のHPバー
        g.setColor(dark_gray);
        if((flgs & 2) == 0) {//最初と行動結果のログ枠
            g.fillRoundRect(0,280,512,200,30,30);
        } else if((flgs & 2) == 2) {//コマンド選択ログ枠
            g.fillRoundRect(0,290,512,30,30,30);
            g.fillRoundRect(0,320,100,160,30,30);
            g.fillRoundRect(100,320,412,160,30,30);
            g.setColor(Color.WHITE);
            if((flgs & 4) == 0) {
                for(int i = 0; i < battle_mode.length; i++) {
                    g.drawString(battle_mode[i],15,(i*30)+350);
                }
            } else if((flgs & 4) == 4) {      
                for(int i = 0; i < attack.length; i++) {
                    g.drawString(attack[i],15,(i*30)+350);
                }
                if(v < 4 && flgs < ITEM_VIEW) {
                    g.setFont(font_s);
                    g.drawString(ccoment[v],15,313);
                    g.setFont(font_n);
                }
            }
            if((flgs & ITEM_VIEW) == ITEM_VIEW) {
                int i;
                for(i = item_view_range; i < 4+item_view_range; i++) {
                    int j = i-item_view_range;
                    if(i >= list.size() || i < 0)  break;
                    g.drawString(list.get(i),125,(30*j)+350);
                    if(quantity[i] > 1) g.drawString("×"+quantity[i],350,(30*j)+350);//アイテムの数
                }
                g.drawString("戻る",125,(30*(i-item_view_range))+350);//戻（所持）
                if(v < list.size()) {
                    g.setFont(font_s);
                    g.drawString(hashmap.get(list.get(v)).substring(2),15,313);//アイテムの説明
                    g.setFont(font_n);
                }
            } else if((flgs & SKILL_VIEW) == SKILL_VIEW) {
                for(int i = 0; i < 4; i++) {
                    g.drawString(skills[i],125,(30*i) + 350);//特技ログ
                    g.drawString("　消費MP : " + consume[i],200,(30*i) + 350);
                }
                g.drawString(skills[4],125,470);//戻る（特）
                if(v < 4) {
                    g.setFont(font_s);
                    g.drawString(scoment[v],15,313);//特技説明
                    g.setFont(font_n);
                }
            } else {//自分のステ
                g.drawString("HP:" + HP,140,390);
                //g.drawString("HP:2500",140,390);//確認用
                g.drawString("MP:" + MP,140,430);
                //g.drawString("MP:500",140,430);//確認用
                g.drawRect(240,365,255,30);//HP枠
                g.drawRect(240,405,255,30);//MP枠
                g.drawString("部落　車竹",115,350);
                g.setColor(orange);
                g.fillRect(243,368,HP/10,25);//現HPバー
                g.setColor(blue);
                g.fillRect(243,408,MP>>1,25);//現MPバー
                g.setColor(cyan);
                //g.fillRect(x-18,y+20,width_x,28);
            }
            g.setColor(cyan);
            g.fillRect(x-18,y+20,width_x,28);
        }
        g.setColor(Color.WHITE);
        g.setFont(font_n);
        if(flgs == 1) {
            g.drawString(enemy_name + "が立ちふさがった！",105,370);
        } else if((flgs & (1 << 3)) == (1 << 3)) {
            g.drawString("相手は様子をうかがっている",40,370);
        } else if((flgs & ATTACK) == ATTACK) {
            g.drawString("主人公の攻撃！",40,305);
            g.drawString(offe_power+ "のダメージ!",40,340);
        } else if((flgs & DEFENCE) == DEFENCE) {
            g.drawString("主人公は身を守った！",40,305);  //防御
            g.drawString("ダメージが半減する",40,340);
        } else if((flgs & ITEM_USE) == ITEM_USE) {
            if(!cant_use) g.drawString(list.get(v) + "を使った！",40,305);
            g.drawString(battle_log,40,340);
        } else if((flgs & SKILL_USE) == SKILL_USE) {
            if(!cant_use)g.drawString("主人公は" + skills[v] + "をした！",40,305);
            g.drawString(battle_log,40,340);
        } else if((flgs & LOSE_OR_WIN) == LOSE_OR_WIN) g.drawString(battle_log,40,340);
        if(flgs >= (1 << 10)) {
            g.drawString(enemy_name + "の攻撃！",40,410);
            g.drawString(damege + "のダメージ!",40,445);
        }
        //g.drawString(turn_count+"ターン目",50,50);
        //g.drawString("攻撃力: "+offe_power,180,50);
        //g.drawString("防御力: "+defe_power,350,50);
    }
    private void select_square_info(int flgs) {
        int j = v-item_view_range;
        y = (30*j)+307;
        if((flgs & ITEM_VIEW) == ITEM_VIEW || (flgs & SKILL_VIEW) == SKILL_VIEW) {
            x = 165; width_x = 240;
            
        } else { x = 25; width_x = 85;}
    }
    private int select_square_range(int flgs) {
        int range = 0;
        if((flgs & 4) == 0) return 2;
        if((flgs & 4) == 4)  range = 4;
        if((flgs & ITEM_VIEW) == ITEM_VIEW)  return list.size(); 
        if((flgs & SKILL_VIEW) == SKILL_VIEW)  return 4;
        return range;
    }
    public void controll(KeyEvent e, int key) {
        if(flgs == 0)  return; 
        int dire = 0;
        int select_range = select_square_range(flgs);
        select_square_info(flgs);
        switch(key) {
            case KeyEvent.VK_UP:     dire = 1;   break;
            case KeyEvent.VK_DOWN:   dire = 2;   break;
        }
        if((flgs & 2) != 0) {
            if(dire == 1 && v > 0) v--;
            if(dire == 2 && v < select_range) v++;
        }
        if(key == KeyEvent.VK_ENTER){
            if((flgs & LOSE_OR_WIN) == LOSE_OR_WIN) {
                battle_finish();
                return;
            }
            if(flgs == 1) {
                flgs = 3; return;
            }
            if((flgs & 2) == 0 && (flgs >= 1024 || (flgs & 8) == 8)) {
                turn_count++;
                int enable_turn = 0;
                switch(used_v) {
                    case 0: enable_turn = 4; break;
                    case 1: enable_turn = 5; break;
                    case 2: enable_turn = 3; break;
                    case 3: enable_turn = 1; break;
                }
                skill_effect(enable_turn);
                if((flgs & ITEM_USED) == ITEM_USED) {
                    //if(!cant_use) Items.equip_or_heal(list.get(v),v, true);
                    decrease_hp();
                }
                if(HP <= 0) {
                    battle_log = enemy_name+"に負けた・・・";
                    HP = 2500; MP = 500;
                    flgs = LOSE_OR_WIN+1;
                } else if(enemy_hp <= 0) {
                    battle_log = enemy_name+"を倒した";
                    flgs = LOSE_OR_WIN+1;
                } else if((flgs & 4) == 0) {
                    flgs = 3;
                } else if((flgs & 4) == 4) {
                    flgs = 7;
                }
            } else if((flgs & ITEM_USE) == ITEM_USE) {
                flgs = ITEM_USED+ITEM_USE+5;
            } else if((flgs & SKILL_USE) == SKILL_USE) {
                used_v = v;
                decrease_hp();
                flgs = SKILL_USED+SKILL_USE+5;
            } else if((flgs & ITEM_VIEW) == ITEM_VIEW) {//ここ書き換え
                if(v < list.size()) {
                    int item_id = Items.get_item_id(list.get(v));
                    battle_log_update(item_id,false);
                    flgs = ITEM_USE+5;
                } else if(v >= list.size()) {
                    flgs = 7; v = 0;
                    item_view_range = 0;
                }
            } else if((flgs & SKILL_VIEW) == SKILL_VIEW) {
                if(v < 4) {
                    battle_log_update(v,true);
                    skill_use(v);
                    flgs = SKILL_USE+5;
                } else if(v >= 4) {
                    flgs = 7; v = 0;
                }
            } else if((flgs & ATTACK) == ATTACK) {
                decrease_hp();
                flgs = (1<<12)+ATTACK+5;
            } else if((flgs & DEFENCE) == DEFENCE) {
                decrease_hp();
                flgs = (1<<13)+DEFENCE+5;
            } else if((flgs & 4) == 4) {
                if(v == 0) {
                    flgs = ATTACK+5;
                    attack_by_me();
                }
                if(v == 1) flgs = DEFENCE+5;
                if(v == 2) {
                    flgs = ITEM_VIEW+7; v = 0; item_select = true;
                } else if(v == 3) {
                    flgs = SKILL_VIEW+7; v = 0;
                } else if(v == 4) {
                    flgs = 3; v = 0;
                }
            } else if((flgs & 4) == 0) {
                if(v == 0) flgs = (1<<2)+3;
                if(v == 1) flgs = (1<<3)+1;
                if(v == 2) battle_finish();
            }
        }
        if(item_select) {
            int ivr = v-item_view_range;
            if(ivr >= 4 && v < select_range) {
                item_view_range++;
            } else if(ivr < 0) {
                item_view_range--;
                if(item_view_range < 0) item_view_range = 0;
            }
        }
        select_square_info(flgs);
        if(flgs == 0)  Sounds.sound_chage(true);
    }
    private void battle_log_update(int id, boolean skill_used) {
        if(skill_used) {//falseなら使ったのはアイテムでやで
            int rand = random.nextInt(2);
            if(id == 0) {
                if(rand == 0) battle_log = enemy_name + "には効かなかった！";
                if(rand == 1) battle_log = enemy_name + "は興奮した！";
            } else if(id == 1) {
                battle_log = "主人公の攻撃力と防御力が上がった！";
            } else if(id == 2) {
                battle_log = enemy_name + "の攻撃力がこの戦闘中5%下がる！";
            } else if(id == 3) {
                battle_log = "次の攻撃によるダメージが倍になった！";
            }
            return;
        }
        if(id == 52) {
            int rand = random.nextInt(6);
            switch(rand) {
                case 0: battle_log = "主人公に" + HP / 5 + "のダメージ！";
                case 1: battle_log = enemy_name + "に" +attack+ "のダメージ！";
                case 2: battle_log = "HPが" + (HP << 1) + "回復した！";
                case 3: battle_log = "HPが" + (HP / 10) + "回復した！";
                case 4: battle_log = "次の攻撃のダメージが倍になる";
                case 5: battle_log = "ダメージを無効化する";           
            }
            return;
        }
        switch(id) {
            case 11: battle_log = "HPが"+(int)(HP*0.15) +"回復した！"; break;
            case 21: battle_log = "MPが"+(int)(MP*0.15) +"回復した！"; break;
            case 12: battle_log = "HPが"+(int)(HP>>1) +"回復した！"; break;
            case 22: battle_log = "MPが"+(int)(MP>>1) +"回復した！"; break;
            case 13: battle_log = "HPが全回復した！"; break;
            case 23: battle_log = "MPが全回復した！"; break;
        }
        cant_use = false;
        if(30 < id && id < 45) {
            cant_use = true;
            battle_log = "戦闘中は装備できないよ";
        } else if(id == 51) {
            battle_log = (HP/10)+"のダメージ。その代わり攻撃力が上がった";      
            item_effect(3);
        } else if(id >= 53) {
            battle_log = "ERROR";
            cant_use = true;
        }
    }
    private void skill_use(int index) {
        use_turn = turn_count;
        if(MP < consume[index]) {
            cant_use = true;
            battle_log = "MPが足りないよ";
        } else {
            MP -= consume[index];
        }
        if(MP <= 0) MP = 0;
    }
    private void item_effect(int enable_turn) {
        use_turn = turn_count;
        if((turn_count - use_turn) <= enable_turn) {
            if(enable_turn == 3) {
                HP = HP-(HP/10);
                offe_power = offence+(offence/5);
            }
        } else {
            offe_power = offence;
        }       
    }
    private void skill_effect(int enable_turn) {
        if((turn_count - use_turn) <= enable_turn) {
            switch(enable_turn) {
                case 4: offe_power = offence+(offence/10); 
                        damege = offe_power_enemy+(offe_power_enemy/10);
                        break;
                case 5: offe_power = offence+(offence/10);
                        defe_power = defence+(defence/10);
                        break;
                case 3: damege = offe_power_enemy-(int)(offe_power_enemy*0.05);
                        break;
                case 1: offe_power = (offence << 1); break;
            }
        } else {
            offe_power = offence;
            defe_power = defence;
            damege = offe_power_enemy;
        }
    }
    private void decrease_hp() {
        HP -= damege;
        if(HP <= 0) HP = 0;
        if(damege < 0) damege = 0;
    }
    private void attack_by_me() {
        enemy_hp -= offe_power;
    }
    private int gage_length(int i) {
        if(i == 1) return 15;
        if(i == 2) return 20;
        if(i == 3) return 25;
        return 10;
    }
    public void battle_flg(int floor_num, int object_num,int enemy_num) {
        if((flgs & 1) == 0) {
            String enemys[] ={"image/enemy1.png",
                              "image/enemy2.png",
                              "image/enemy3.png",
                              "image/enemy4.png"};
            enemy_img = Toolkit.getDefaultToolkit().getImage(enemys[enemy_num]);
            Battle.enemy_num = enemy_num;
            enemy_name = enemy_select(enemy_num);
            enemy_hp = enemy_hp_select(enemy_num);
            offe_power_enemy = enemy_power_select(enemy_num);
            flgs = 1; 
            v = 0;
            Sounds.sound_chage(false);
        }
    }
    private String enemy_select(int index) {
        String enemy_name[] = {"課長","部長","専務","社長"};
        return enemy_name[index];
    }
    private int enemy_hp_select(int index) {
        int enemy_hp[] = {3000, 4500, 6000, 7500};
        return enemy_hp[index];
    } 
    private int enemy_power_select(int index) {
        int enemy_power[] = {500, 600, 700, 800};
        return enemy_power[index];    
    }    
    private void battle_finish() {
        flgs = 0;
        Communicate.battle_begin = false;
    }
    private class Damege_effect extends Thread{
        private int i = 0;
        public void run(){
            while(true){
                if((flgs & 16) == 16 && i < 8) {
                    visible = !visible;
                    i++;
                } else if((flgs & 16) == 0 && i >= 8){
                    i = 0;
                }
                try{
                    Thread.sleep(70);
                }catch(InterruptedException e){}
            }
        }
    }
}