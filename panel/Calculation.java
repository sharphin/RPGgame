public class Calculation{
    public static int kouturncount;  //���������^�[���o�߂�����
    public static int guchiturncount;  //��s�����^�[���o�߂�����
    public static boolean koufun = false;  //����
    public static boolean guchi = false;  //��s
    public static boolean gomasuri = false;  //���܂���
    public static boolean gamann = false;  //�䖝
    public static boolean defense = false;  //�h��
    public static boolean damagecut = false;  //�_���[�W����
    public static boolean randomeffect = false;  //��̈��ݕ��̌���(�_���[�W�{)
    public static boolean salesman = false;  //���ƃl�N�^�C�̃Z�b�g����
    public static int et;  //�n���Z���̃N���e�B�J�����𒲐�����
    public static int zihyou;  //���\�g�p��
    public static boolean muteki = false;  //���\�ƌ_�񏑂̃Z�b�g���ʁi���G���j
    private int set;  //���Z��MP����z��̏ꏊ�Q�Ɨp
    private int Hheal;  //HP��
    private int Mheal;  //MP��
    private int zisyou;  //�������_���[�W���󂯂����p
    private int skillplus;  //���Z�ɂ��_���[�W�̕ω�
    private int ran;  //�����̍U���̃_���[�W
    private int aran;  //����̍U���̃_���[�W
    private int tuika;  //���\�̒ǉ��_���[�W

    public Calculation(){
    }

    public void Hhealcheak(int HP){  //HP���I�[�o�[�q�[�����Ȃ����̊m�F
        if(HP < 2500) bt.setHP(HP);
        else if(HP >= 2500) bt.setHP(2500);
    }

    public void Mhealcheak(int MP){  //MP���I�[�o�[�q�[�����Ȃ����̊m�F
        if(MP < 500) bt.setMP(MP);
        else if(MP >= 500) bt.setMP(500);
    }

    public void setDefense(boolean defense){ this.defense = defense; }
    public void setDamagecut(boolean damagecut){ this.damagecut = damagecut; }
    public void setRandomeffect(boolean randomeffect){ this.randomeffect = randomeffect; }

    public static boolean getDefense(){ return defense; }
    public static boolean getDamagecut(){ return damagecut; }
    public static boolean getRandomeffect(){ return randomeffect; }

    public void allreset(){  //�قڂ��ׂĂ�������
        bt.setF(0);
        bt.setA(0);
        bt.setB(0);
        bt.setC(0);
        bt.setH(0);
        bt.setCheak(false);
    }

    public void seteffect(int j,int k){  //�Z�b�g����
        if(j == 0 && k == 0){
        }else if(j == 1 && k == 1){
            salesman = true;  //�U���͉�����
        }else if(j == 2 && k == 2){
            et = 2;  //�n���Z���̃N���e�B�J�����A�b�v
        }else if(j == 3 && k == 3){
            bt.setCounter(100);  //���\�������Ǝg����
            bt.setMuteki(true);  //���G�ɂȂ�
            bt.setPossible(true);  //���\�̌��ʔ��f�p
        }else{
            salesman = false;
            et = 1;
            bt.setCounter(3);
            bt.setMuteki(false);
            bt.setPossible(false);
        }
    }

    public void attack(int j,int k,int r,int AHP){  //�����̍U��
        if(AHP > 0){  //����̗̑͂����鎞
            Sounds.play_sound(1);
            bt.setBC(3);
            bt.setTen(true);
            seteffect(j,k);  //�Z�b�g���ʊm�F
            int counter = bt.getCounter();  //���\���g������
            int zihyou = bt.getZihyou();  //���\�g�p��
            if(koufun == false && guchi == false) skillplus = 450;
            else if(koufun == true) skillplus = 540;
            else if(guchi == true) skillplus = 495;
            else if(koufun == true && guchi == true) skillplus = 585;
            ran = new java.util.Random().nextInt(100) + skillplus + bt.offense[j];  //�_���[�W�v�Z
            if(bt.getPossible() == true) tuika = bt.ahp[r] / 5;  //���\�̒ǉ��Œ�_���[�W
            if(bt.getPossible() == false) tuika = bt.ahp[r] / 10;  //����
            int absorb = bt.hp[2] / 10;  //���\��HP�񕜌���
            if(gamann == true) ran = ran * 2;  //�䖝�ɂ��_���[�W�{
            if(gamann == true) gamann = false;  //���ʃI�t
            int han = new java.util.Random().nextInt(10);  //�m���ɂ����ʔ��f�p
            if(j == 2) if(han < 2 * et) ran = ran * 2;  //�n���Z���̃N���e�B�J�����f
            if(j == 2) if(han < 2 * et) bt.setCritical(true);  //�N���e�B�J�����o���m�F
            if(randomeffect == true) ran = ran * 2;  //�G�i�h���̃_���[�W�{�ɂȂ����
            if(randomeffect == true) randomeffect = false;  //���ʃI�t
            if(j == 3 && zihyou == counter) bt.setPossible(false);  //���\�̌��ʂ��g�p�ł��Ȃ��Ȃ�
            if(j == 3) if(zihyou < counter) Hhealcheak(bt.getHP() + absorb);  //���\�̉񕜌��ʊm�F
            if(j != 3 || (j == 3 && zihyou >= counter)) bt.setRan(ran);  //�U���Ŕ��������_���[�W
            if(j != 3 || (j == 3 && zihyou >= counter)) bt.setAHP(AHP - ran);  //����̗̑͂����炷
            if(j == 3) if(zihyou < counter) bt.setRan(ran);  //�U���Ŕ��������_���[�W
            if(j == 3) if(zihyou < counter) bt.setAHP(AHP - (ran + tuika));  //���\�̌��ʓK����
            if(j == 3) bt.setZihyou(zihyou + 1);  //���\�̎g�p�񐔑���
            bt.setChange(2);
            Sounds.play_sound(4);
        }
    }

    public void enemycheak(int number,int j,int k,int r,int HP,int bc){  //����̏�Ԃ̊m�F
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

    public void enemyattack(int part,int number,int j,int k,int r,int HP,int bc){  //����̍U��
        int q = bt.getQ();
        if(q == 0){
            seteffect(j,k);  //�Z�b�g���ʊm�F
            aran = new java.util.Random().nextInt(100);  //�_���[�W�̌덷
            Sounds.play_sound(4);
            if(part == 0) skillplus = 100;
            else if(part == 1) skillplus = 115;
            else if(part == 2) skillplus = 90;
            else if(part == 3) skillplus = 95;
            else if(part == 4) skillplus = 105;
            else if(part == 5) skillplus = 110;
            else if(part == 6) skillplus = 85;
            else if(part == 7) skillplus = 100;
            if(part == 1 || part == 4 || part == 5 || part == 7) kouturncount++;  //���Z�̃^�[���o��
            if(part == 2 || part == 4 || part == 6 || part == 7) guchiturncount++;  //����
            if(koufun == true && kouturncount == 3) koufun = false;  //���ʃI�t
            if(koufun == true && kouturncount == 3) kouturncount = 0;  //�J�E���g���Z�b�g
            if(guchi == true && guchiturncount == 5) guchi = false;  //���ʃI�t
            if(guchi == true && guchiturncount == 5) guchiturncount = 0;  //�J�E���g���Z�b�g
            if(r == 3) r = 2;  //�В��̃_���[�W����
            aran = aran + ((r + 1) * skillplus + (r + 1) * 200) - bt.defense[k];  //�_���[�W�v�Z
            if(k == 1) aran = aran - (aran / 10);  //�l�N�^�C����
            if(salesman == true) aran = aran / 4 * 3;  //���ƃl�N�^�C�̃Z�b�g����
            if(defense == true) aran = aran / 2;  //�h�䎞
            if(aran < 0) aran = 0;  //�_���[�W���}�C�i�X�\������Ȃ��悤��
            int han = new java.util.Random().nextInt(10);  //�m���ɂ����ʔ��f�p
            if(k == 2) if(han < 2) bt.setOwarai(true);  //�@�ዾ�̖������ʔ��f
            if(k == 3) if(han < 5) damagecut = true;  //�_�񏑂̖������ʔ��f
            if(damagecut == true) aran = 0;  //�_���[�W��������
            if(damagecut == true) damagecut = false;  //�_���[�W�������ʃI�t
            if(bt.getOwarai() == true) aran = 0;  //�_���[�W��������
            if(bt.getMuteki() == true) aran = 0;  //���\�ƌ_�񏑂̃Z�b�g���ʁi���G�j
            bt.setAran(aran);  //����̍U���ɂ��_���[�W
            bt.setHP(HP - aran);  //�������HP�v�Z
            bt.setQ(1);
        }else{  //����̍U����
            if(HP == 0) defeat();  //����
            if(HP != 0){  //HP���c���Ă���
                if(bc == 10){  //�A�C�e���g�p��Ȃ�
                    if(bt.have.get(number) <= 0){  //�A�C�e���g�p���Ė����Ȃ����Ȃ�
                        bt.litem.remove(number);  //���X�g�i�`��j����폜
                        bt.have.remove(number);  //����
                        bt.lcoment.remove(number);  //����
                    }
                }
                allreset();
                bt.setBC(0);
                bt.setQ(0);
                bt.setChange(0);
                if(defense == true) defense = false;  //�h��I�t
                if(bt.getCritical() == true) bt.setCritical(false);  //�N���e�B�J���m�F���I�t
                if(bt.getOwarai() == true) bt.setOwarai(false);  //�_���[�W�������ʃI�t
            }
        }
    }

    public void win(){  //��������
        bt.setChange(2);
        bt.setBC(7);
    }

    public void defeat(){  //��������
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