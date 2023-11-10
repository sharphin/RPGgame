package panel;
import java.util.*;

public class Charctor_status {
    static int HP = 2500;    //キャラのHP  Battle.javs以外での書き換えを禁止する
    static int MP = 500;     //キャラのMP  Battle.java以外での書き換えを禁止する
    static int offence = 350;//キャラの攻撃力 
    static int defence = 250;//キャラの防御力
    static int my_money = 20000;

    static List<String> list = new ArrayList<>(10);
    //リストを使ってもよかったけどあえて配列にした
    static int quantity[] = {1,1,1,1,1,1,1,1,1,1};

    static Map<String,String> hashmap = new HashMap<>(30);
    static String equip[] = {"",""};
}