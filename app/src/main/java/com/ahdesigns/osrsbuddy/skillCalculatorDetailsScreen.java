package com.ahdesigns.osrsbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class skillCalculatorDetailsScreen extends AppCompatActivity {

    TextView text, text2, targetLevel,
            nextLevel, nextXP;
    String username, skill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skillcalculatordetailsscreen);

        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);
        targetLevel = findViewById(R.id.targetLevel);
        nextLevel = findViewById(R.id.nextLevel);
        nextXP = findViewById(R.id.nextXP);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        username = extras.getString("username");
        skill = extras.getString("skill");

        text.setText(username);
        text2.setText(skill);

        String num;

        num = targetLevel.getText().toString();

        if(targetLevel.getText() != null) {
            DecimalFormat df = new DecimalFormat();
            df.setGroupingUsed(true);
            df.setGroupingSize(3);

            switch (num) {
                case "50":
                    nextLevel.setText(R.string.text_51);
                    nextXP.setText(df.format(Long.valueOf("111945")));
                    break;
                case "51":
                    nextLevel.setText(R.string.text_52);
                    nextXP.setText(df.format(Long.valueOf("123660")));
                    break;
                case "52":
                    nextLevel.setText(R.string.text_53);
                    nextXP.setText(df.format(Long.valueOf("136594")));
                    break;
                case "53":
                    nextLevel.setText(R.string.text_54);
                    nextXP.setText(df.format(Long.valueOf("150,872")));
                    break;
                case "54":
                    nextLevel.setText(R.string.text_55);
                    nextXP.setText(df.format(Long.valueOf("166,636")));
                    break;
                case "55":
                    nextLevel.setText(R.string.text_56);
                    nextXP.setText(df.format(Long.valueOf("184,040")));
                    break;
                default:
                    nextLevel.setText(R.string.text_2);
                    nextXP.setText(df.format(Long.valueOf("83")));
                    break;
            }
        }
    }
}