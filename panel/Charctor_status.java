package panel;
import java.util.*;

public class Charctor_status {
    static int HP = 2500;    //�L������HP  Battle.javs�ȊO�ł̏����������֎~����
    static int MP = 500;     //�L������MP  Battle.java�ȊO�ł̏����������֎~����
    static int offence = 350;//�L�����̍U���� 
    static int defence = 250;//�L�����̖h���
    static int my_money = 20000;

    static List<String> list = new ArrayList<>(10);
    //���X�g���g���Ă��悩�������ǂ����Ĕz��ɂ���
    static int quantity[] = {1,1,1,1,1,1,1,1,1,1};

    static Map<String,String> hashmap = new HashMap<>(30);
    static String equip[] = {"",""};
}