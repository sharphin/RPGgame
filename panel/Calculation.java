public class Calculation{
    public static int kouturncount;  //興奮が何ターン経過したか
    public static int guchiturncount;  //愚痴が何ターン経過したか
    public static boolean koufun = false;  //興奮
    public static boolean guchi = false;  //愚痴
    public static boolean gomasuri = false;  //ごますり
    public static boolean gamann = false;  //我慢
    public static boolean defense = false;  //防御
    public static boolean damagecut = false;  //ダメージ無効
    public static boolean randomeffect = false;  //謎の飲み物の効果(ダメージ倍)
    public static boolean salesman = false;  //鞄とネクタイのセット効果
    public static int et;  //ハリセンのクリティカル率を調整する
    public static int zihyou;  //辞表使用回数
    public static boolean muteki = false;  //辞表と契約書のセット効果（無敵化）
    private int set;  //特技のMP消費配列の場所参照用
    private int Hheal;  //HP回復
    private int Mheal;  //MP回復
    private int zisyou;  //自分がダメージを受けた時用
    private int skillplus;  //特技によるダメージの変化
    private int ran;  //自分の攻撃のダメージ
    private int aran;  //相手の攻撃のダメージ
    private int tuika;  //辞表の追加ダメージ

    public Calculation(){
    }

    public void Hhealcheak(int HP){  //HPがオーバーヒールしないかの確認
        if(HP < 2500) bt.setHP(HP);
        else if(HP >= 2500) bt.setHP(2500);
    }

    public void Mhealcheak(int MP){  //MPがオーバーヒールしないかの確認
        if(MP < 500) bt.setMP(MP);
        else if(MP >= 500) bt.setMP(500);
    }

    public void setDefense(boolean defense){ this.defense = defense; }
    public void setDamagecut(boolean damagecut){ this.damagecut = damagecut; }
    public void setRandomeffect(boolean randomeffect){ this.randomeffect = randomeffect; }

    public static boolean getDefense(){ return defense; }
    public static boolean getDamagecut(){ return damagecut; }
    public static boolean getRandomeffect(){ return randomeffect; }

    public void allreset(){  //ほぼすべてを初期化
        bt.setF(0);
        bt.setA(0);
        bt.setB(0);
        bt.setC(0);
        bt.setH(0);
        bt.setCheak(false);
    }

    public void seteffect(int j,int k){  //セット効果
        if(j == 0 && k == 0){
        }else if(j == 1 && k == 1){
            salesman = true;  //攻撃力下げる
        }else if(j == 2 && k == 2){
            et = 2;  //ハリセンのクリティカル率アップ
        }else if(j == 3 && k == 3){
            bt.setCounter(100);  //辞表がずっと使える
            bt.setMuteki(true);  //無敵になる
            bt.setPossible(true);  //辞表の効果判断用
        }else{
            salesman = false;
            et = 1;
            bt.setCounter(3);
            bt.setMuteki(false);
            bt.setPossible(false);
        }
    }

    public void attack(int j,int k,int r,int AHP){  //自分の攻撃
        if(AHP > 0){  //相手の体力がある時
            Sounds.play_sound(1);
            bt.setBC(3);
            bt.setTen(true);
            seteffect(j,k);  //セット効果確認
            int counter = bt.getCounter();  //辞表が使える上限
            int zihyou = bt.getZihyou();  //辞表使用回数
            if(koufun == false && guchi == false) skillplus = 450;
            else if(koufun == true) skillplus = 540;
            else if(guchi == true) skillplus = 495;
            else if(koufun == true && guchi == true) skillplus = 585;
            ran = new java.util.Random().nextInt(100) + skillplus + bt.offense[j];  //ダメージ計算
            if(bt.getPossible() == true) tuika = bt.ahp[r] / 5;  //辞表の追加固定ダメージ
            if(bt.getPossible() == false) tuika = bt.ahp[r] / 10;  //同上
            int absorb = bt.hp[2] / 10;  //辞表のHP回復効果
            if(gamann == true) ran = ran * 2;  //我慢によるダメージ倍
            if(gamann == true) gamann = false;  //効果オフ
            int han = new java.util.Random().nextInt(10);  //確率による効果判断用
            if(j == 2) if(han < 2 * et) ran = ran * 2;  //ハリセンのクリティカル判断
            if(j == 2) if(han < 2 * et) bt.setCritical(true);  //クリティカルが出た確認
            if(randomeffect == true) ran = ran * 2;  //エナドリのダメージ倍になる効果
            if(randomeffect == true) randomeffect = false;  //効果オフ
            if(j == 3 && zihyou == counter) bt.setPossible(false);  //辞表の効果が使用できなくなる
            if(j == 3) if(zihyou < counter) Hhealcheak(bt.getHP() + absorb);  //辞表の回復効果確認
            if(j != 3 || (j == 3 && zihyou >= counter)) bt.setRan(ran);  //攻撃で発生したダメージ
            if(j != 3 || (j == 3 && zihyou >= counter)) bt.setAHP(AHP - ran);  //相手の体力を減らす
            if(j == 3) if(zihyou < counter) bt.setRan(ran);  //攻撃で発生したダメージ
            if(j == 3) if(zihyou < counter) bt.setAHP(AHP - (ran + tuika));  //辞表の効果適応時
            if(j == 3) bt.setZihyou(zihyou + 1);  //辞表の使用回数増加
            bt.setChange(2);
            Sounds.play_sound(4);
        }
    }

    public void enemycheak(int number,int j,int k,int r,int HP,int bc){  //相手の状態の確認
        bt.setTen(false);
        if(koufun == false && guchi == false && gomasuri == false) enemyattack(0,number,j,k,r,HP,bc);
        else if(koufun == true && guchi == true && gomasuri == true) enemyattack(7,number,j,k,r,HP,bc);
        else if(koufun == true && guchi == true) enemyattack(4,number,j,k,r,HP,bc);
        else if(koufun == true && gomasuri == true) enemyattack(5,number,j,k,r,HP,bc);
        else if(guchi == true && gomasuri == true) enemyattack(6,number,j,k,r,HP,bc);
        else if(koufun == true) enemyattack(1,number,j,k,r,HP,bc);
        else if(guchi == true) enemyattack(2,number,j,k,r,HP,bc);
        else if(gomasuri == true) enemyattack(3,number,j,k,r,HP,bc);
    }

    public void enemyattack(int part,int number,int j,int k,int r,int HP,int bc){  //相手の攻撃
        int q = bt.getQ();
        if(q == 0){
            seteffect(j,k);  //セット効果確認
            aran = new java.util.Random().nextInt(100);  //ダメージの誤差
            Sounds.play_sound(4);
            if(part == 0) skillplus = 100;
            else if(part == 1) skillplus = 115;
            else if(part == 2) skillplus = 90;
            else if(part == 3) skillplus = 95;
            else if(part == 4) skillplus = 105;
            else if(part == 5) skillplus = 110;
            else if(part == 6) skillplus = 85;
            else if(part == 7) skillplus = 100;
            if(part == 1 || part == 4 || part == 5 || part == 7) kouturncount++;  //特技のターン経過
            if(part == 2 || part == 4 || part == 6 || part == 7) guchiturncount++;  //同上
            if(koufun == true && kouturncount == 3) koufun = false;  //効果オフ
            if(koufun == true && kouturncount == 3) kouturncount = 0;  //カウントリセット
            if(guchi == true && guchiturncount == 5) guchi = false;  //効果オフ
            if(guchi == true && guchiturncount == 5) guchiturncount = 0;  //カウントリセット
            if(r == 3) r = 2;  //社長のダメージ調整
            aran = aran + ((r + 1) * skillplus + (r + 1) * 200) - bt.defense[k];  //ダメージ計算
            if(k == 1) aran = aran - (aran / 10);  //ネクタイ効果
            if(salesman == true) aran = aran / 4 * 3;  //鞄とネクタイのセット効果
            if(defense == true) aran = aran / 2;  //防御時
            if(aran < 0) aran = 0;  //ダメージがマイナス表示されないように
            int han = new java.util.Random().nextInt(10);  //確率による効果判断用
            if(k == 2) if(han < 2) bt.setOwarai(true);  //鼻眼鏡の無効効果判断
            if(k == 3) if(han < 5) damagecut = true;  //契約書の無効効果判断
            if(damagecut == true) aran = 0;  //ダメージ無効判定
            if(damagecut == true) damagecut = false;  //ダメージ無効効果オフ
            if(bt.getOwarai() == true) aran = 0;  //ダメージ無効判定
            if(bt.getMuteki() == true) aran = 0;  //辞表と契約書のセット効果（無敵）
            bt.setAran(aran);  //相手の攻撃によるダメージ
            bt.setHP(HP - aran);  //こちらのHP計算
            bt.setQ(1);
        }else{  //相手の攻撃後
            if(HP == 0) defeat();  //負け
            if(HP != 0){  //HPが残っている
                if(bc == 10){  //アイテム使用後なら
                    if(bt.have.get(number) <= 0){  //アイテム使用して無くなったなら
                        bt.litem.remove(number);  //リスト（描画）から削除
                        bt.have.remove(number);  //同上
                        bt.lcoment.remove(number);  //同上
                    }
                }
                allreset();
                bt.setBC(0);
                bt.setQ(0);
                bt.setChange(0);
                if(defense == true) defense = false;  //防御オフ
                if(bt.getCritical() == true) bt.setCritical(false);  //クリティカル確認をオフ
                if(bt.getOwarai() == true) bt.setOwarai(false);  //ダメージ無効効果オフ
            }
        }
    }

    public void win(){  //勝った時
        bt.setChange(2);
        bt.setBC(7);
    }

    public void defeat(){  //負けた時
        bt.setChange(2);
        bt.setQ(0);
        bt.setBC(9);
    }

    public void Back(int bc){
        Sounds.play_sound(6);
        if(bc >= 4 && bc <= 6) bt.setBC(2);
        if(bc >= 4 && bc <= 6) bt.setA(bc - 3);
        if(bc == 4) bt.setF(0);
        bt.setChange(0);
    }
}