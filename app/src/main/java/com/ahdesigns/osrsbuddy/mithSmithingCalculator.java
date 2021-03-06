package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class mithSmithingCalculator {

    TableRow barrow, daggerrow, axerow, macerow, medhelmrow, boltsrow,
            swordrow, nailsrow, dartrow, arrowrow, scimitarrow, limbsrow,
            javelinrow, longswordrow, fullhelmrow, kniferow, sqshieldrow,
            warhammerrow, grapplerow, battleaxerow, chainbodyrow, kiteshieldrow,
            clawsrow, sword2hrow, skirtrow, legsrow, bodyrow;

    TextView na, bartxt, daggertxt, axetxt, macetxt, medhelmtxt, boltstxt,
            swordtxt, nailstxt, darttxt, arrowtxt, scimitartxt, limbstxt,
            javelintxt, longswordtxt, fullhelmtxt, knifetxt, sqshieldtxt,
            warhammertxt, grappletxt, battleaxetxt, chainbodytxt, kiteshieldtxt,
            clawstxt, sword2htxt, skirttxt, legstxt, bodytxt;

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
        arrowrow = smithing.findViewById(R.id.arrowrow);
        scimitarrow = smithing.findViewById(R.id.scimitarrow);
        limbsrow = smithing.findViewById(R.id.limbsrow);
        javelinrow = smithing.findViewById(R.id.javelinrow);
        longswordrow = smithing.findViewById(R.id.longswordrow);
        fullhelmrow = smithing.findViewById(R.id.fullhelmrow);
        kniferow = smithing.findViewById(R.id.kniferow);
        sqshieldrow = smithing.findViewById(R.id.sqshieldrow);
        warhammerrow = smithing.findViewById(R.id.warhammerrow);
        grapplerow = smithing.findViewById(R.id.grapplerow);
        battleaxerow = smithing.findViewById(R.id.battleaxerow);
        chainbodyrow = smithing.findViewById(R.id.chainbodyrow);
        kiteshieldrow = smithing.findViewById(R.id.kiteshieldrow);
        clawsrow = smithing.findViewById(R.id.clawsrow);
        sword2hrow = smithing.findViewById(R.id.sword2hrow);
        skirtrow = smithing.findViewById(R.id.skirtrow);
        legsrow = smithing.findViewById(R.id.legsrow);
        bodyrow = smithing.findViewById(R.id.bodyrow);

        na = smithing.findViewById(R.id.na);
        bartxt = smithing.findViewById(R.id.bartxt);
        daggertxt = smithing.findViewById(R.id.daggertxt);
        axetxt = smithing.findViewById(R.id.axetxt);
        macetxt = smithing.findViewById(R.id.macetxt);
        medhelmtxt = smithing.findViewById(R.id.medhelmtxt);
        boltstxt = smithing.findViewById(R.id.boltstxt);
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
        grappletxt = smithing.findViewById(R.id.grappletxt);
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

        bar = 30 * bonus;
        smithBar = 50 * bonus;

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

        if(num2 < 50) {
            na.setVisibility(View.VISIBLE);
        }if (num2 >= 50) {
            bartxt.setText(b);
            daggertxt.setText(sB);
        } else {
            barrow.setVisibility(View.GONE);
            daggerrow.setVisibility(View.GONE);
        }if (num2 >= 51) {
            axetxt.setText(sB);
        } else {
            axerow.setVisibility(View.GONE);
        }if (num2 >= 52) {
            macetxt.setText(sB);
        } else {
            macerow.setVisibility(View.GONE);
        }if (num2 >= 53) {
            medhelmtxt.setText(sB);
            boltstxt.setText(sB);
        } else {
            medhelmrow.setVisibility(View.GONE);
            boltsrow.setVisibility(View.GONE);
        }if (num2 >= 54) {
            swordtxt.setText(sB);
            nailstxt.setText(sB);
            darttxt.setText(sB);
        } else {
            swordrow.setVisibility(View.GONE);
            nailsrow.setVisibility(View.GONE);
            dartrow.setVisibility(View.GONE);
        }if (num2 >= 55) {
            arrowtxt.setText(sB);
            scimitartxt.setText(s2B);
        } else {
            arrowrow.setVisibility(View.GONE);
            scimitarrow.setVisibility(View.GONE);
        }if (num2 >= 56) {
            limbstxt.setText(sB);
            javelintxt.setText(sB);
            longswordtxt.setText(s2B);
        } else {
            limbsrow.setVisibility(View.GONE);
            javelinrow.setVisibility(View.GONE);
            longswordrow.setVisibility(View.GONE);
        }if (num2 >= 57) {
            fullhelmtxt.setText(s2B);
            knifetxt.setText(sB);
        } else {
            fullhelmrow.setVisibility(View.GONE);
            kniferow.setVisibility(View.GONE);
        }if (num2 >= 58) {
            sqshieldtxt.setText(s2B);
        } else {
            sqshieldrow.setVisibility(View.GONE);
        }if (num2 >= 59) {
            warhammertxt.setText(s3B);
            grappletxt.setText(sB);
        } else {
            warhammerrow.setVisibility(View.GONE);
            grapplerow.setVisibility(View.GONE);
        }if (num2 >= 60) {
            battleaxetxt.setText(s3B);
        } else {
            battleaxerow.setVisibility(View.GONE);
        }if (num2 >= 61) {
            chainbodytxt.setText(s3B);
        } else {
            chainbodyrow.setVisibility(View.GONE);
        }if (num2 >= 62) {
            kiteshieldtxt.setText(s3B);
        } else {
            kiteshieldrow.setVisibility(View.GONE);
        }if (num2 >= 63) {
            clawstxt.setText(s2B);
        } else {
            clawsrow.setVisibility(View.GONE);
        }if (num2 >= 64) {
            sword2htxt.setText(s3B);
        } else {
            sword2hrow.setVisibility(View.GONE);
        }if (num2 >= 66) {
            skirttxt.setText(s3B);
            legstxt.setText(s3B);
        } else {
            skirtrow.setVisibility(View.GONE);
            legsrow.setVisibility(View.GONE);
        }if (num2 >= 68) {
            bodytxt.setText(s5B);
        } else {
            bodyrow.setVisibility(View.GONE);
        }
    }
}