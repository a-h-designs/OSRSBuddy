package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class miningCalculator {

    int  clay, clayToGo, copperToGo, limestoneToGo, iron, ironToGo,
            silver, silverToGo, coal, coalToGo, paydirt, paydirtToGo,
            sandstone1, sandstone1ToGo, denseess, denseessToGo,
            gold, goldToGo, granite5, granite5ToGo, mith, mithToGo,
            addy, addyToGo, rune, runeToGo, amethyst, amethystToGo;

    double copper, limestone;

    @SuppressLint("InflateParams")
    public void calculate(Integer num2, Integer xpLeft, View mining) {

        TableRow limestonerow = mining.findViewById(R.id.limestonerow);
        TableRow ironrow = mining.findViewById(R.id.ironrow);
        TableRow silverrow = mining.findViewById(R.id.silverrow);
        TableRow pure_essencerow = mining.findViewById(R.id.pure_essencerow);
        TableRow coalrow = mining.findViewById(R.id.coalrow);
        TableRow paydirtrow = mining.findViewById(R.id.paydirtrow);
        TableRow sandstone_1kgrow = mining.findViewById(R.id.sandstone_1kgrow);
        TableRow sandstone_2kgrow = mining.findViewById(R.id.sandstone_2kgrow);
        TableRow sandstone_5kgrow = mining.findViewById(R.id.sandstone_5kgrow);
        TableRow sandstone_10kgrow = mining.findViewById(R.id.sandstone_10kgrow);
        TableRow dense_essencerow = mining.findViewById(R.id.dense_essencerow);
        TableRow goldrow = mining.findViewById(R.id.goldrow);
        TableRow gemrow = mining.findViewById(R.id.gemrow);
        TableRow granite_500grow = mining.findViewById(R.id.granite_500grow);
        TableRow granite_2kgrow = mining.findViewById(R.id.granite_2kgrow);
        TableRow granite_5kgrow = mining.findViewById(R.id.granite_5kgrow);
        TableRow mithrow = mining.findViewById(R.id.mithrow);
        TableRow addyrow = mining.findViewById(R.id.addyrow);
        TableRow runerow = mining.findViewById(R.id.runerow);
        TableRow amethystrow = mining.findViewById(R.id.amethystrow);
        TextView claytxt = mining.findViewById(R.id.claytxt);
        TextView rune_esstxt = mining.findViewById(R.id.rune_essencetxt);
        TextView coppertxt = mining.findViewById(R.id.coppertxt);
        TextView tintxt = mining.findViewById(R.id.tintxt);
        TextView limestonetxt = mining.findViewById(R.id.limestonetxt);
        TextView irontxt = mining.findViewById(R.id.irontxt);
        TextView silvertxt = mining.findViewById(R.id.silvertxt);
        TextView pure_esstxt = mining.findViewById(R.id.pure_essencetxt);
        TextView coalTxt = mining.findViewById(R.id.coaltxt);
        TextView paydirtTxt = mining.findViewById(R.id.paydirttxt);
        TextView sandstone1txt = mining.findViewById(R.id.sandstone_1kgtxt);
        TextView sandstone2txt = mining.findViewById(R.id.sandstone_2kgtxt);
        TextView sandstone5txt = mining.findViewById(R.id.sandstone_5kgtxt);
        TextView sandstone10txt = mining.findViewById(R.id.sandstone_10kgtxt);
        TextView denseesstxt = mining.findViewById(R.id.dense_essencetxt);
        TextView goldTxt = mining.findViewById(R.id.goldtxt);
        TextView gemTxt = mining.findViewById(R.id.gemtxt);
        TextView granite500Txt = mining.findViewById(R.id.granite_500gtxt);
        TextView granite2Txt = mining.findViewById(R.id.granite_2kgtxt);
        TextView granite5Txt = mining.findViewById(R.id.granite_5kgtxt);
        TextView mithTxt = mining.findViewById(R.id.mithtxt);
        TextView addyTxt = mining.findViewById(R.id.addytxt);
        TextView runeTxt = mining.findViewById(R.id.runetxt);
        TextView amethystTxt = mining.findViewById(R.id.amethysttxt);
        clay = 5;
        denseess = 12;
        copper = 17.5;
        limestone = 26.5;
        sandstone1 = 30;
        iron = 35;
        silver = 40;
        coal = 50;
        paydirt = 60;
        gold = 65;
        granite5 = 75;
        mith = 80;
        addy = 95;
        rune = 125;
        amethyst = 240;
        clayToGo = xpLeft / clay;
        denseessToGo = xpLeft / denseess;
        copperToGo = (int) (xpLeft / copper);
        limestoneToGo = (int) (xpLeft / limestone);
        sandstone1ToGo = xpLeft / sandstone1;
        ironToGo = xpLeft / iron;
        silverToGo = xpLeft / silver;
        coalToGo = xpLeft / coal;
        paydirtToGo = xpLeft / paydirt;
        goldToGo = xpLeft / gold;
        granite5ToGo = xpLeft / granite5;
        mithToGo = xpLeft / mith;
        addyToGo = xpLeft / addy;
        runeToGo = xpLeft / rune;
        amethystToGo = xpLeft / amethyst;
        String cl = NumberFormat.getIntegerInstance().format(clayToGo);
        String co = NumberFormat.getIntegerInstance().format(copperToGo);
        String l = NumberFormat.getIntegerInstance().format(limestoneToGo);
        String i = NumberFormat.getIntegerInstance().format(ironToGo);
        String s = NumberFormat.getIntegerInstance().format(silverToGo);
        String c = NumberFormat.getIntegerInstance().format(coalToGo);
        String pd = NumberFormat.getIntegerInstance().format(paydirtToGo);
        String ss1 = NumberFormat.getIntegerInstance().format(sandstone1ToGo);
        String de = NumberFormat.getIntegerInstance().format(denseessToGo);
        String g = NumberFormat.getIntegerInstance().format(goldToGo);
        String g5 = NumberFormat.getIntegerInstance().format(granite5ToGo);
        String m = NumberFormat.getIntegerInstance().format(mithToGo);
        String a = NumberFormat.getIntegerInstance().format(addyToGo);
        String r = NumberFormat.getIntegerInstance().format(runeToGo);
        String am = NumberFormat.getIntegerInstance().format(amethystToGo);
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
