package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class barsSmithingCalculator {

    TableRow ironrow, silverrow, steelrow, goldrow, goldgauntletsrow,
            mithrow, addyrow, runerow;

    TextView bronzetxt, irontxt, silvertxt, steeltxt, goldtxt, goldgauntletstxt,
            mithtxt, addytxt, runetxt;

    String b, i, si, s, g, gg, m, a, r;

    int bronzeToGo, ironToGo, silverToGo, steelToGo, goldToGo, goldgauntletsToGo,
            mith, mithToGo, addyToGo, rune, runeToGo, bonus = 1;

    double bronze, iron, silver, steel, gold, goldgauntlets, addy;

    public void calculate(Integer num2, Integer xpLeft, View smithing, String artisan,
                          String wisdom) {

        ironrow = smithing.findViewById(R.id.ironrow);
        silverrow = smithing.findViewById(R.id.silverrow);
        steelrow = smithing.findViewById(R.id.steelrow);
        goldrow = smithing.findViewById(R.id.goldrow);
        goldgauntletsrow = smithing.findViewById(R.id.goldgauntletsrow);
        mithrow = smithing.findViewById(R.id.mithrow);
        addyrow = smithing.findViewById(R.id.addyrow);
        runerow = smithing.findViewById(R.id.runerow);

        bronzetxt = smithing.findViewById(R.id.bronzetxt);
        irontxt = smithing.findViewById(R.id.irontxt);
        silvertxt = smithing.findViewById(R.id.silvertxt);
        steeltxt = smithing.findViewById(R.id.steeltxt);
        goldtxt = smithing.findViewById(R.id.goldtxt);
        goldgauntletstxt = smithing.findViewById(R.id.goldgauntletstxt);
        mithtxt = smithing.findViewById(R.id.mithtxt);
        addytxt = smithing.findViewById(R.id.addytxt);
        runetxt = smithing.findViewById(R.id.runetxt);

        if (artisan.equals("true") && wisdom.equals("true")) {
            bonus = 4;
        } else if (artisan.equals("true") && wisdom.equals("false")) {
            bonus = 2;
        } else if (artisan.equals("false") && wisdom.equals("true")) {
            bonus = 2;
        }

        bronze = 6.25 * bonus;
        iron = 12.5 * bonus;
        silver = 13.7 * bonus;
        steel = 17.5 * bonus;
        gold = 22.5 * bonus;
        goldgauntlets = 56.2 * bonus;
        mith = 30 * bonus;
        addy = 37.5 * bonus;
        rune = 50 * bonus;

        bronzeToGo = (int) (xpLeft / bronze + 1);
        ironToGo = (int) (xpLeft / iron + 1);
        silverToGo = (int) (xpLeft / silver + 1);
        steelToGo = (int) (xpLeft / steel + 1);
        goldToGo = (int) (xpLeft / gold + 1);
        goldgauntletsToGo = (int) (xpLeft / goldgauntlets + 1);
        mithToGo = xpLeft / mith + 1;
        addyToGo = (int) (xpLeft / addy + 1);
        runeToGo = xpLeft / rune + 1;

        b = NumberFormat.getIntegerInstance().format(bronzeToGo);
        i = NumberFormat.getIntegerInstance().format(ironToGo);
        si = NumberFormat.getIntegerInstance().format(silverToGo);
        s = NumberFormat.getIntegerInstance().format(steelToGo);
        g = NumberFormat.getIntegerInstance().format(goldToGo);
        gg = NumberFormat.getIntegerInstance().format(goldgauntletsToGo);
        m = NumberFormat.getIntegerInstance().format(mithToGo);
        a = NumberFormat.getIntegerInstance().format(addyToGo);
        r = NumberFormat.getIntegerInstance().format(runeToGo);

        bronzetxt.setText(b);
        if (num2 >= 15) {
            irontxt.setText(i);
        } else {
            ironrow.setVisibility(View.GONE);
        }
        if (num2 >= 20) {
            silvertxt.setText(si);
        } else {
            silverrow.setVisibility(View.GONE);
        }
        if (num2 >= 30) {
            steeltxt.setText(s);
        } else {
            steelrow.setVisibility(View.GONE);
        }
        if (num2 >= 40) {
            goldtxt.setText(g);
            goldgauntletstxt.setText(gg);
        } else {
            goldrow.setVisibility(View.GONE);
            goldgauntletsrow.setVisibility(View.GONE);
        }
        if (num2 >= 50) {
            mithtxt.setText(m);
        } else {
            mithrow.setVisibility(View.GONE);
        }
        if (num2 >= 70) {
            addytxt.setText(a);
        } else {
            addyrow.setVisibility(View.GONE);
        }
        if (num2 >= 85) {
            runetxt.setText(r);
        } else {
            runerow.setVisibility(View.GONE);
        }
    }
}
