package com.example.theworldofzouple;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import java.util.HashMap;

public class SpellsActivity extends AppCompatActivity {

    private TextView tvGoldSpell;
    private Button btBuySpell1;
    private Button btBuySpell2;
    private Button btBuySpell3;
    private Button btBuySpell4;
    private Button btBuySpell5;
    private Button btBuySpell6;
    private Button btBuySpell7;
    private Button btBuySpell8;
    private Button btBuySpell9;
    private Button btBuySpell10;
    private Button btBuySpell11;
    private Button btBuySpell12;

    static boolean AlreadyBuySpell1=false;
    static boolean AlreadyBuySpell2=false;
    static boolean AlreadyBuySpell3=false;
    static boolean AlreadyBuySpell4=false;
    static boolean AlreadyBuySpell5=false;
    static boolean AlreadyBuySpell6=false;
    static boolean AlreadyBuySpell7=false;
    static boolean AlreadyBuySpell8=false;
    static boolean AlreadyBuySpell9=false;
    static boolean AlreadyBuySpell10=false;
    static boolean AlreadyBuySpell11=false;
    static boolean AlreadyBuySpell12=false;

    private TextView costSpell1;

    private Button btClose;
    HashMap<String, Spell> dic_spells = new HashMap<String, Spell>();
    //static Spell currentSpell;


    private int Golds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Slidr.attach(this);

        Golds = SecondActivity.currentCaracter.gold; // get the value
        btClose= findViewById(R.id.btClose);



        tvGoldSpell=findViewById(R.id.tvGoldSpell);
        tvGoldSpell.setText(String.valueOf(Golds));

        costSpell1=findViewById(R.id.costSpell1);


        btBuySpell1= findViewById(R.id.btBuySpell1);
        btBuySpell2= findViewById(R.id.btBuySpell2);
        btBuySpell3= findViewById(R.id.btBuySpell3);
        btBuySpell4= findViewById(R.id.btBuySpell4);
        btBuySpell5= findViewById(R.id.btBuySpell5);
        btBuySpell6= findViewById(R.id.btBuySpell6);
        btBuySpell7= findViewById(R.id.btBuySpell7);
        btBuySpell8= findViewById(R.id.btBuySpell8);
        btBuySpell9= findViewById(R.id.btBuySpell9);
        btBuySpell10= findViewById(R.id.btBuySpell10);
        btBuySpell11= findViewById(R.id.btBuySpell11);
        btBuySpell12= findViewById(R.id.btBuySpell12);

        initialiseBtImg(AlreadyBuySpell1,btBuySpell1);
        initialiseBtImg(AlreadyBuySpell2,btBuySpell2);
        initialiseBtImg(AlreadyBuySpell3,btBuySpell3);
        initialiseBtImg(AlreadyBuySpell4,btBuySpell4);
        initialiseBtImg(AlreadyBuySpell5,btBuySpell5);
        initialiseBtImg(AlreadyBuySpell6,btBuySpell6);
        initialiseBtImg(AlreadyBuySpell7,btBuySpell7);
        initialiseBtImg(AlreadyBuySpell8,btBuySpell8);
        initialiseBtImg(AlreadyBuySpell9,btBuySpell9);
        initialiseBtImg(AlreadyBuySpell10,btBuySpell10);
        initialiseBtImg(AlreadyBuySpell11,btBuySpell11);
        initialiseBtImg(AlreadyBuySpell12,btBuySpell12);

        dic_spells.put("Spell1",new Spell("Spell1","boulefeu2_foreground",1.2,1500));
        dic_spells.put("Spell2",new Spell("Spell2","attackcaracter_foreground",1.4,5000));
        dic_spells.put("Spell3",new Spell("Spell3","boulefeuforte_foreground",1.6,10000));
        dic_spells.put("Spell4",new Spell("Spell4","boulefeu3_foreground",1.8,18000));
        dic_spells.put("Spell5",new Spell("Spell5","boulefeu4_foreground",2,45000));
        dic_spells.put("Spell6",new Spell("Spell6","boulefeu5_foreground",2.2,70000));
;       dic_spells.put("Spell7",new Spell("Spell7","boulefeu6_foreground",2.4,120000));
        dic_spells.put("Spell8",new Spell("Spell8","boulefeu7_foreground",2.6,210000));
        dic_spells.put("Spell9",new Spell("Spell9","boulefeu8_foreground",2.8,350000));
        dic_spells.put("Spell10",new Spell("Spell10","boulefeu9_foreground",3,570000));
        dic_spells.put("Spell11",new Spell("Spell11","boulefeu10_foreground",3.5,770000));
        dic_spells.put("Spell12",new Spell("Spell12","boulefeu11_foreground",4,1000000));

        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpellsActivity.this.finish();
            }
        });

        btBuySpell1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell1")||AlreadyBuySpell1)
                    return;
                AlreadyBuySpell1=setAchat(dic_spells.get("Spell1"));
                initialiseBtImg(AlreadyBuySpell1,btBuySpell1);
            }
        });
        btBuySpell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell2")||AlreadyBuySpell2)
                    return;
                AlreadyBuySpell2=setAchat(dic_spells.get("Spell2"));
                initialiseBtImg(AlreadyBuySpell2,btBuySpell2);
            }
        });
        btBuySpell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell3")||AlreadyBuySpell3)
                    return;
                AlreadyBuySpell3=setAchat(dic_spells.get("Spell3"));
                initialiseBtImg(AlreadyBuySpell3,btBuySpell3);
            }
        });
        btBuySpell4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell4")||AlreadyBuySpell4)
                    return;
                AlreadyBuySpell4=setAchat(dic_spells.get("Spell4"));
                initialiseBtImg(AlreadyBuySpell4,btBuySpell4);
            }
        });
        btBuySpell5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell5")||AlreadyBuySpell5)
                    return;
                AlreadyBuySpell5=setAchat(dic_spells.get("Spell5"));
                initialiseBtImg(AlreadyBuySpell5,btBuySpell5);
            }
        });
        btBuySpell6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell6")||AlreadyBuySpell6)
                    return;
                AlreadyBuySpell6=setAchat(dic_spells.get("Spell6"));
                initialiseBtImg(AlreadyBuySpell6,btBuySpell6);
            }
        });
        btBuySpell7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell7")||AlreadyBuySpell7)
                    return;
                AlreadyBuySpell7=setAchat(dic_spells.get("Spell7"));
                initialiseBtImg(AlreadyBuySpell7,btBuySpell7);
            }
        });
        btBuySpell8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell8")||AlreadyBuySpell8)
                    return;
                AlreadyBuySpell8=setAchat(dic_spells.get("Spell8"));
                initialiseBtImg(AlreadyBuySpell8,btBuySpell8);
            }
        });
        btBuySpell9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell9")||AlreadyBuySpell9)
                    return;
                AlreadyBuySpell9=setAchat(dic_spells.get("Spell9"));
                initialiseBtImg(AlreadyBuySpell9,btBuySpell9);
            }
        });
        btBuySpell10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell10")||AlreadyBuySpell10)
                    return;
                AlreadyBuySpell10=setAchat(dic_spells.get("Spell10"));
                initialiseBtImg(AlreadyBuySpell10,btBuySpell10);
            }
        });
        btBuySpell11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell11")||AlreadyBuySpell11)
                    return;
                AlreadyBuySpell11=setAchat(dic_spells.get("Spell11"));
                initialiseBtImg(AlreadyBuySpell11,btBuySpell11);
            }
        });
        btBuySpell12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dic_spells.containsKey("Spell12")||AlreadyBuySpell12)
                    return;
                AlreadyBuySpell12=setAchat(dic_spells.get("Spell12"));
                initialiseBtImg(AlreadyBuySpell12,btBuySpell12);
            }
        });

    }


    //currentSpell=spell;

    public boolean setAchat(Spell spell){

        if(Golds>= spell.cost){
            setDamagesWithAnOtherBuy();
            Golds=Golds-spell.cost;
            SecondActivity.currentCaracter.setGold(Golds);
            tvGoldSpell.setText(String.valueOf(SecondActivity.currentCaracter.gold));
            SecondActivity.tvGold.setText(String.valueOf(SecondActivity.currentCaracter.gold));
            SecondActivity.currentCaracter.caracteristic.damages*=spell.ratioDamagesBonus;
            SecondActivity.currentCaracter.setCaracterAttackImg(spell.spellImg);
            return true;

        }

        return false;
    }
    public void setDamagesWithAnOtherBuy(){
        if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell1").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell1").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell2").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell2").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell3").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell3").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell4").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell4").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell5").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell5").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell6").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell6").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell7").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell7").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell8").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell8").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell9").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell9").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell10").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell10").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell11").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell11").ratioDamagesBonus;
        else if(SecondActivity.currentCaracter.CaracterAttackImg==dic_spells.get("Spell12").spellImg)
            SecondActivity.currentCaracter.caracteristic.damages/=dic_spells.get("Spell12").ratioDamagesBonus;
    }

    public void initialiseBtImg(boolean bool,Button bt){

        if(bool==true){
            int res = getResources().getIdentifier("achetefini_foreground", "mipmap", getPackageName());
            bt.setBackgroundResource(res);
        }
    }
}