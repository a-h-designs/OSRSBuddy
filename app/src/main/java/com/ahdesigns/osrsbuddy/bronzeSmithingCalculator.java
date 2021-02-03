package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class bronzeSmithingCalculator {

    TableRow barrow, daggerrow, axerow, macerow, medhelmrow, boltsrow,
            swordrow, nailsrow, dartrow, wirerow, arrowrow, scimitarrow,
            limbsrow, javelinrow, longswordrow, fullhelmrow, kniferow,
            sqshieldrow, warhammerrow, battleaxerow, chainbodyrow,
            kiteshieldrow, clawsrow, sword2hrow, skirtrow, legsrow, bodyrow;

    TextView bartxt, daggertxt, axetxt, macetxt, medhelmtxt, boltstxt,
            swordtxt, nailstxt, darttxt, wiretxt, arrowtxt, scimitartxt,
            limbstxt, javelintxt, longswordtxt, fullhelmtxt, knifetxt,
            sqshieldtxt, warhammertxt, battleaxetxt, chainbodytxt,
            kiteshieldtxt, clawstxt, sword2htxt, skirttxt, legstxt, bodytxt;

    String b, sB, s2B, s3B, s5B;

    int barToGo, smithBarToGo, smith2BarToGo, smith3BarToGo, smith5BarToGo, bonus = 1;

    double bar, smithBar;

    public void calculate(Integer num2, Integer xpLeft, View smithing, String smelting,
                          String artisan, String wisdom) {

        barrow = smithing.findViewById(R.id.barrow);
        daggerrow = smithing.findViewById(R.id.daggerrow);
        axerow = smithing.findViewById(R.id.axerow);
        macerow = smithing.findViewById(R.id.macerow);
        medhelmrow = smithing.findViewById(R.id.medhelmrow);
        boltsrow = smithing.findViewById(R.id.boltsrow);
        swordrow = smithing.findViewById(R.id.swordrow);
        nailsrow = smithing.findViewById(R.id.nailsrow);
        dartrow = smithing.findViewById(R.id.dartrow);
        wirerow = smithing.findViewById(R.id.wirerow);
        arrowrow = smithing.findViewById(R.id.arrowrow);
        scimitarrow = smithing.findViewById(R.id.scimitarrow);
        limbsrow = smithing.findViewById(R.id.limbsrow);
        javelinrow = smithing.findViewById(R.id.javelinrow);
        longswordrow = smithing.findViewById(R.id.longswordrow);
        fullhelmrow = smithing.findViewById(R.id.fullhelmrow);
        kniferow = smithing.findViewById(R.id.kniferow);
        sqshieldrow = smithing.findViewById(R.id.sqshieldrow);
        warhammerrow = smithing.findViewById(R.id.warhammerrow);
        battleaxerow = smithing.findViewById(R.id.battleaxerow);
        chainbodyrow = smithing.findViewById(R.id.chainbodyrow);
        kiteshieldrow = smithing.findViewById(R.id.kiteshieldrow);
        clawsrow = smithing.findViewById(R.id.clawsrow);
        sword2hrow = smithing.findViewById(R.id.sword2hrow);
        skirtrow = smithing.findViewById(R.id.skirtrow);
        legsrow = smithing.findViewById(R.id.legsrow);
        bodyrow = smithing.findViewById(R.id.bodyrow);

        bartxt = smithing.findViewById(R.id.bartxt);
        daggertxt = smithing.findViewById(R.id.daggertxt);
        axetxt = smithing.findViewById(R.id.axetxt);
        macetxt = smithing.findViewById(R.id.macetxt);
        medhelmtxt = smithing.findViewById(R.id.medhelmtxt);
        boltstxt = smithing.findViewById(R.id.boltstxt);
        wiretxt = smithing.findViewById(R.id.wiretxt);
        swordtxt = smithing.findViewById(R.id.swordtxt);
        nailstxt = smithing.findViewById(R.id.nailstxt);
        darttxt = smithing.findViewById(R.id.darttxt);
        arrowtxt = smithing.findViewById(R.id.arrowtxt);
        scimitartxt = smithing.findViewById(R.id.scimitartxt);
        limbstxt = smithing.findViewById(R.id.limbstxt);
        javelintxt = smithing.findViewById(R.id.javelintxt);
        longswordtxt = smithing.findViewById(R.id.longswordtxt);
        fullhelmtxt = smithing.findViewById(R.id.fullhelmtxt);
        knifetxt = smithing.findViewById(R.id.knifetxt);
        sqshieldtxt = smithing.findViewById(R.id.sqshieldtxt);
        warhammertxt = smithing.findViewById(R.id.warhammertxt);
        battleaxetxt = smithing.findViewById(R.id.battleaxetxt);
        chainbodytxt = smithing.findViewById(R.id.chainbodytxt);
        kiteshieldtxt = smithing.findViewById(R.id.kiteshieldtxt);
        clawstxt = smithing.findViewById(R.id.clawstxt);
        sword2htxt = smithing.findViewById(R.id.sword2htxt);
        skirttxt = smithing.findViewById(R.id.skirttxt);
        legstxt = smithing.findViewById(R.id.legstxt);
        bodytxt = smithing.findViewById(R.id.bodytxt);

        if (artisan.equals("true") && wisdom.equals("true")) {
            bonus = 4;
        } else if (artisan.equals("true") && wisdom.equals("false")) {
            bonus = 2;
        } else if (artisan.equals("false") && wisdom.equals("true")) {
            bonus = 2;
        }

        bar = 6.25 * bonus;
        smithBar = 12.5 * bonus;

        barToGo = (int) (xpLeft / bar + 1);
        if (smelting.equals("true")) {
            smithBarToGo = (int) (xpLeft / (smithBar + bar) + 1);
            smith2BarToGo = (int) (xpLeft / ((smithBar * 2) + (bar * 2)) + 1);
            smith3BarToGo = (int) (xpLeft / ((smithBar * 3) + (bar * 3)) + 1);
            smith5BarToGo = (int) (xpLeft / ((smithBar * 5) + (bar * 5)) + 1);
        } else {
            smithBarToGo = (int) (xpLeft / smithBar + 1);
            smith2BarToGo = (int) (xpLeft / (smithBar * 2) + 1);
            smith3BarToGo = (int) (xpLeft / (smithBar * 3) + 1);
            smith5BarToGo = (int) (xpLeft / (smithBar * 5) + 1);
        }

        b = NumberFormat.getIntegerInstance().format(barToGo);
        sB = NumberFormat.getIntegerInstance().format(smithBarToGo);
        s2B = NumberFormat.getIntegerInstance().format(smith2BarToGo);
        s3B = NumberFormat.getIntegerInstance().format(smith3BarToGo);
        s5B = NumberFormat.getIntegerInstance().format(smith5BarToGo);


        bartxt.setText(b);
        daggertxt.setText(sB);
        axetxt.setText(sB);
        if (num2 >= 2) {
            macetxt.setText(sB);
        } else {
            macerow.setVisibility(View.GONE);
        }if (num2 >= 3) {
            medhelmtxt.setText(sB);
            boltstxt.setText(sB);
        } else {
            medhelmrow.setVisibility(View.GONE);
            boltsrow.setVisibility(View.GONE);
        }if (num2 >= 4) {
            swordtxt.setText(sB);
            nailstxt.setText(sB);
            darttxt.setText(sB);
            wiretxt.setText(sB);
        } else {
            swordrow.setVisibility(View.GONE);
            nailsrow.setVisibility(View.GONE);
            dartrow.setVisibility(View.GONE);
            wirerow.setVisibility(View.GONE);
        }if (num2 >= 5) {
            arrowtxt.setText(sB);
            scimitartxt.setText(s2B);
        } else {
            arrowrow.setVisibility(View.GONE);
            scimitarrow.setVisibility(View.GONE);
        }if (num2 >= 6) {
            limbstxt.setText(sB);
            javelintxt.setText(sB);
            longswordtxt.setText(s2B);
        } else {
            limbsrow.setVisibility(View.GONE);
            javelinrow.setVisibility(View.GONE);
            longswordrow.setVisibility(View.GONE);
        }if (num2 >= 7) {
            fullhelmtxt.setText(s2B);
            knifetxt.setText(sB);
        } else {
            fullhelmrow.setVisibility(View.GONE);
            kniferow.setVisibility(View.GONE);
        }if (num2 >= 8) {
            sqshieldtxt.setText(s2B);
        } else {
            sqshieldrow.setVisibility(View.GONE);
        }if (num2 >= 9) {
            warhammertxt.setText(s3B);
        } else {
            warhammerrow.setVisibility(View.GONE);
        }if (num2 >= 10) {
            battleaxetxt.setText(s3B);
        } else {
            battleaxerow.setVisibility(View.GONE);
        }if (num2 >= 11) {
            chainbodytxt.setText(s3B);
        } else {
            chainbodyrow.setVisibility(View.GONE);
        }if (num2 >= 12) {
            kiteshieldtxt.setText(s3B);
        } else {
            kiteshieldrow.setVisibility(View.GONE);
        }if (num2 >= 13) {
            clawstxt.setText(s2B);
        } else {
            clawsrow.setVisibility(View.GONE);
        }if (num2 >= 14) {
            sword2htxt.setText(s3B);
        } else {
            sword2hrow.setVisibility(View.GONE);
        }if (num2 >= 16) {
            skirttxt.setText(s3B);
            legstxt.setText(s3B);
        } else {
            skirtrow.setVisibility(View.GONE);
            legsrow.setVisibility(View.GONE);
        }if (num2 >= 18) {
            bodytxt.setText(s5B);
        } else {
            bodyrow.setVisibility(View.GONE);
        }
    }
}