package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class miningCalculator {

    TableRow limestonerow, ironrow, silverrow, pure_essencerow, coalrow, paydirtrow,
            sandstone_1kgrow, sandstone_2kgrow, sandstone_5kgrow, sandstone_10kgrow,
            dense_essencerow, goldrow, gemrow, granite_500grow, granite_2kgrow,
            granite_5kgrow,  mithrow, addyrow, runerow, amethystrow;

    TextView claytxt, rune_esstxt, coppertxt, tintxt, limestonetxt, irontxt,
            silvertxt, pure_esstxt, coalTxt, paydirtTxt, sandstone1txt, sandstone2txt,
            sandstone5txt, sandstone10txt, denseesstxt, goldTxt, gemTxt, granite500Txt,
            granite2Txt, granite5Txt, mithTxt, addyTxt, runeTxt, amethystTxt;

    String cl, co, l, i, s, c, pd, ss1, de, g, g5, m, a, r, am;

    double clay, clayToGo, copper, copperToGo, limestone, limestoneToGo,
            iron, ironToGo, silver, silverToGo, coal, coalToGo, paydirt,
            paydirtToGo, sandstone1, sandstone1ToGo, denseess, denseessToGo,
            gold, goldToGo, granite5, granite5ToGo, mith, mithToGo,
            addy, addyToGo, rune, runeToGo, amethyst, amethystToGo,
            clayPercent = 0, copperPercent = 0, limestonePercent = 0,
            ironPercent = 0, silverPercent = 0, coalPercent = 0, paydirtPercent = 0,
            sandstone1Percent = 0, denseessPercent = 0, goldPercent = 0,
            granite5Percent = 0, mithPercent = 0, addyPercent = 0, runePercent = 0,
            amethystPercent = 0, bonus = 1;

    public void calculate(Integer num2, Integer xpLeft, View mining, String prospect,
                          String gatherer, String wisdom) {

        limestonerow = mining.findViewById(R.id.limestonerow);
        ironrow = mining.findViewById(R.id.ironrow);
        silverrow = mining.findViewById(R.id.silverrow);
        pure_essencerow = mining.findViewById(R.id.pure_essencerow);
        coalrow = mining.findViewById(R.id.coalrow);
        paydirtrow = mining.findViewById(R.id.paydirtrow);
        sandstone_1kgrow = mining.findViewById(R.id.sandstone_1kgrow);
        sandstone_2kgrow = mining.findViewById(R.id.sandstone_2kgrow);
        sandstone_5kgrow = mining.findViewById(R.id.sandstone_5kgrow);
        sandstone_10kgrow = mining.findViewById(R.id.sandstone_10kgrow);
        dense_essencerow = mining.findViewById(R.id.dense_essencerow);
        goldrow = mining.findViewById(R.id.goldrow);
        gemrow = mining.findViewById(R.id.gemrow);
        granite_500grow = mining.findViewById(R.id.granite_500grow);
        granite_2kgrow = mining.findViewById(R.id.granite_2kgrow);
        granite_5kgrow = mining.findViewById(R.id.granite_5kgrow);
        mithrow = mining.findViewById(R.id.mithrow);
        addyrow = mining.findViewById(R.id.addyrow);
        runerow = mining.findViewById(R.id.runerow);
        amethystrow = mining.findViewById(R.id.amethystrow);

        claytxt = mining.findViewById(R.id.claytxt);
        rune_esstxt = mining.findViewById(R.id.rune_essencetxt);
        coppertxt = mining.findViewById(R.id.coppertxt);
        tintxt = mining.findViewById(R.id.tintxt);
        limestonetxt = mining.findViewById(R.id.limestonetxt);
        irontxt = mining.findViewById(R.id.irontxt);
        silvertxt = mining.findViewById(R.id.silvertxt);
        pure_esstxt = mining.findViewById(R.id.pure_essencetxt);
        coalTxt = mining.findViewById(R.id.coaltxt);
        paydirtTxt = mining.findViewById(R.id.paydirttxt);
        sandstone1txt = mining.findViewById(R.id.sandstone_1kgtxt);
        sandstone2txt = mining.findViewById(R.id.sandstone_2kgtxt);
        sandstone5txt = mining.findViewById(R.id.sandstone_5kgtxt);
        sandstone10txt = mining.findViewById(R.id.sandstone_10kgtxt);
        denseesstxt = mining.findViewById(R.id.dense_essencetxt);
        goldTxt = mining.findViewById(R.id.goldtxt);
        gemTxt = mining.findViewById(R.id.gemtxt);
        granite500Txt = mining.findViewById(R.id.granite_500gtxt);
        granite2Txt = mining.findViewById(R.id.granite_2kgtxt);
        granite5Txt = mining.findViewById(R.id.granite_5kgtxt);
        mithTxt = mining.findViewById(R.id.mithtxt);
        addyTxt = mining.findViewById(R.id.addytxt);
        runeTxt = mining.findViewById(R.id.runetxt);
        amethystTxt = mining.findViewById(R.id.amethysttxt);

        if (prospect.equals("true") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
            clayPercent = 5 + (5 * 2.5) / 100.0;
            denseessPercent = 12 + (12 * 2.5) / 100.0;
            copperPercent = 17.5 + (17.5 * 2.5) / 100.0;
            limestonePercent = 26.5 + (26.5 * 2.5) / 100.0;
            sandstone1Percent = 30 + (30 * 2.5) / 100.0;
            ironPercent = 35 + (35 * 2.5) / 100.0;
            silverPercent = 40 + (40 * 2.5) / 100.0;
            coalPercent = 50 + (50 * 2.5) / 100.0;
            paydirtPercent = 60 + (60 * 2.5) / 100.0;
            goldPercent = 65 + (65 * 2.5) / 100.0;
            granite5Percent = 75 + (75 * 2.5) / 100.0;
            mithPercent = 80 + (80 * 2.5) / 100.0;
            addyPercent = 95 + (95 * 2.5) / 100.0;
            runePercent = 125 + (125 * 2.5) / 100.0;
            amethystPercent = 240 + (240 * 2.5) / 100.0;
        } else if (prospect.equals("true") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
            clayPercent = 5 + (5 * 2.5) / 100.0;
            denseessPercent = 12 + (12 * 2.5) / 100.0;
            copperPercent = 17.5 + (17.5 * 2.5) / 100.0;
            limestonePercent = 26.5 + (26.5 * 2.5) / 100.0;
            sandstone1Percent = 30 + (30 * 2.5) / 100.0;
            ironPercent = 35 + (35 * 2.5) / 100.0;
            silverPercent = 40 + (40 * 2.5) / 100.0;
            coalPercent = 50 + (50 * 2.5) / 100.0;
            paydirtPercent = 60 + (60 * 2.5) / 100.0;
            goldPercent = 65 + (65 * 2.5) / 100.0;
            granite5Percent = 75 + (75 * 2.5) / 100.0;
            mithPercent = 80 + (80 * 2.5) / 100.0;
            addyPercent = 95 + (95 * 2.5) / 100.0;
            runePercent = 125 + (125 * 2.5) / 100.0;
            amethystPercent = 240 + (240 * 2.5) / 100.0;
        } else if (prospect.equals("true") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;
            clayPercent = 5 + (5 * 2.5) / 100.0;
            denseessPercent = 12 + (12 * 2.5) / 100.0;
            copperPercent = 17.5 + (17.5 * 2.5) / 100.0;
            limestonePercent = 26.5 + (26.5 * 2.5) / 100.0;
            sandstone1Percent = 30 + (30 * 2.5) / 100.0;
            ironPercent = 35 + (35 * 2.5) / 100.0;
            silverPercent = 40 + (40 * 2.5) / 100.0;
            coalPercent = 50 + (50 * 2.5) / 100.0;
            paydirtPercent = 60 + (60 * 2.5) / 100.0;
            goldPercent = 65 + (65 * 2.5) / 100.0;
            granite5Percent = 75 + (75 * 2.5) / 100.0;
            mithPercent = 80 + (80 * 2.5) / 100.0;
            addyPercent = 95 + (95 * 2.5) / 100.0;
            runePercent = 125 + (125 * 2.5) / 100.0;
            amethystPercent = 240 + (240 * 2.5) / 100.0;
        } else if (prospect.equals("true") && gatherer.equals("false") && wisdom.equals("false")) {
            clayPercent = (5 * 2.5) / 100.0;
            denseessPercent = (12 * 2.5) / 100.0;
            copperPercent = (17.5 * 2.5) / 100.0;
            limestonePercent = (26.5 * 2.5) / 100.0;
            sandstone1Percent = (30 * 2.5) / 100.0;
            ironPercent = (35 * 2.5) / 100.0;
            silverPercent =(40 * 2.5) / 100.0;
            coalPercent = (50 * 2.5) / 100.0;
            paydirtPercent = (60 * 2.5) / 100.0;
            goldPercent = (65 * 2.5) / 100.0;
            granite5Percent = (75 * 2.5) / 100.0;
            mithPercent = (80 * 2.5) / 100.0;
            addyPercent = (95 * 2.5) / 100.0;
            runePercent = (125 * 2.5) / 100.0;
            amethystPercent = (240 * 2.5) / 100.0;
        } else if (prospect.equals("false") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
        } else if (prospect.equals("false") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
        } else if (prospect.equals("false") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;

        }

        clay = (5 * bonus) + clayPercent;
        denseess = (12 * bonus) + denseessPercent;
        copper = (17.5 * bonus) + copperPercent;
        limestone = (26.5 * bonus) + limestonePercent;
        sandstone1 = (30 * bonus) + sandstone1Percent;
        iron = (35 * bonus) + ironPercent;
        silver = (40 * bonus) + silverPercent;
        coal = (50 * bonus) + coalPercent;
        paydirt = (60 * bonus) + paydirtPercent;
        gold = (65 * bonus) + goldPercent;
        granite5 = (75 * bonus) + granite5Percent;
        mith = (80 * bonus) + mithPercent;
        addy = (95 * bonus) + addyPercent;
        rune = (125 * bonus) + runePercent;
        amethyst = (240 * bonus) + amethystPercent;

        clayToGo = xpLeft / clay + 1;
        denseessToGo = xpLeft / denseess + 1;
        copperToGo = (int) (xpLeft / copper + 1);
        limestoneToGo = (int) (xpLeft / limestone + 1);
        sandstone1ToGo = xpLeft / sandstone1 + 1;
        ironToGo = xpLeft / iron + 1;
        silverToGo = xpLeft / silver + 1;
        coalToGo = xpLeft / coal + 1;
        paydirtToGo = xpLeft / paydirt + 1;
        goldToGo = xpLeft / gold + 1;
        granite5ToGo = xpLeft / granite5 + 1;
        mithToGo = xpLeft / mith + 1;
        addyToGo = xpLeft / addy + 1;
        runeToGo = xpLeft / rune + 1;
        amethystToGo = xpLeft / amethyst + 1;

        cl = NumberFormat.getIntegerInstance().format(clayToGo);
        co = NumberFormat.getIntegerInstance().format(copperToGo);
        l = NumberFormat.getIntegerInstance().format(limestoneToGo);
        i = NumberFormat.getIntegerInstance().format(ironToGo);
        s = NumberFormat.getIntegerInstance().format(silverToGo);
        c = NumberFormat.getIntegerInstance().format(coalToGo);
        pd = NumberFormat.getIntegerInstance().format(paydirtToGo);
        ss1 = NumberFormat.getIntegerInstance().format(sandstone1ToGo);
        de = NumberFormat.getIntegerInstance().format(denseessToGo);
        g = NumberFormat.getIntegerInstance().format(goldToGo);
        g5 = NumberFormat.getIntegerInstance().format(granite5ToGo);
        m = NumberFormat.getIntegerInstance().format(mithToGo);
        a = NumberFormat.getIntegerInstance().format(addyToGo);
        r = NumberFormat.getIntegerInstance().format(runeToGo);
        am = NumberFormat.getIntegerInstance().format(amethystToGo);

        claytxt.setText(cl);
        rune_esstxt.setText(cl);
        coppertxt.setText(co);
        tintxt.setText(co);
        if (num2 >= 10) {
            limestonetxt.setText(l);
        } else {
            limestonerow.setVisibility(View.GONE);
        }
        if (num2 >= 15) {
            irontxt.setText(i);
        } else {
            ironrow.setVisibility(View.GONE);
        }
        if (num2 >= 20) {
            silvertxt.setText(s);
        } else {
            silverrow.setVisibility(View.GONE);
        }
        if (num2 >= 30) {
            pure_esstxt.setText(cl);
            coalTxt.setText(c);
            paydirtTxt.setText(pd);
        } else {
            pure_essencerow.setVisibility(View.GONE);
            coalrow.setVisibility(View.GONE);
            paydirtrow.setVisibility(View.GONE);
        }
        if (num2 >= 35) {
            sandstone1txt.setText(ss1);
            sandstone2txt.setText(s);
            sandstone5txt.setText(c);
            sandstone10txt.setText(pd);
        } else {
            sandstone_1kgrow.setVisibility(View.GONE);
            sandstone_2kgrow.setVisibility(View.GONE);
            sandstone_5kgrow.setVisibility(View.GONE);
            sandstone_10kgrow.setVisibility(View.GONE);
        }
        if (num2 >= 38) {
            denseesstxt.setText(de);
        } else {
            dense_essencerow.setVisibility(View.GONE);
        }
        if (num2 >= 40) {
            goldTxt.setText(g);
            gemTxt.setText(g);
        } else {
            goldrow.setVisibility(View.GONE);
            gemrow.setVisibility(View.GONE);
        }
        if (num2 >= 45) {
            granite500Txt.setText(c);
            granite2Txt.setText(pd);
            granite5Txt.setText(g5);
        } else {
            granite_500grow.setVisibility(View.GONE);
            granite_2kgrow.setVisibility(View.GONE);
            granite_5kgrow.setVisibility(View.GONE);
        }
        if (num2 >= 55) {
            mithTxt.setText(m);
        } else {
            mithrow.setVisibility(View.GONE);
        }
        if (num2 >= 70) {
            addyTxt.setText(a);
        } else {
            addyrow.setVisibility(View.GONE);
        }
        if (num2 >= 85) {
            runeTxt.setText(r);
        } else {
            runerow.setVisibility(View.GONE);
        }
        if (num2 >= 92) {
            amethystTxt.setText(am);
        } else {
            amethystrow.setVisibility(View.GONE);
        }
    }
}
