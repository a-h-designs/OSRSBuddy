package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class woodcuttingCalculator {

    TableRow oakrow, willowrow, teakrow, hollowrow, maplerow, mahoganyrow, arcticrow, yewrow,
            blisterwoodrow, sulliusceprow, magicrow, redwoodrow;

    TextView treetxt, acheytxt, oaktxt, willowtxt, teaktxt, hollowtxt, mapletxt, mahoganytxt,
            arctictxt, yewtxt, blisterwoodtxt, sulliusceptxt, magictxt, redwoodtxt;

    String t, o, w, te, h, m, mah, a, y, b, s, ma, r;

    double trees, treesToGo, oak, oakToGo, willow, willowToGo, teak, teakToGo, hollow, hollowToGo,
            maple, mapleToGo, mahogany, mahoganyToGo, arctic, arcticToGo, yew, yewToGo,
            blisterwood, blisterwoodToGo, sulliuscep, sulliuscepToGo, magic, magicToGo, redwood,
            redwoodToGo,
            treesPercent = 0, oakPercent = 0, willowPercent = 0, teakPercent = 0, hollowPercent = 0,
            maplePercent = 0, mahoganyPercent = 0, arcticPercent = 0, yewPercent = 0,
            blisterwoodPercent = 0, sulliuscepPercent = 0, magicPercent = 0, redwoodPercent = 0,
            bonus = 1;

    public void calculate(Integer num2, Integer xpLeft, View woodcutting, String lumber,
                          String gatherer, String wisdom) {

        oakrow = woodcutting.findViewById(R.id.oakrow);
        willowrow = woodcutting.findViewById(R.id.willowrow);
        teakrow = woodcutting.findViewById(R.id.teakrow);
        hollowrow = woodcutting.findViewById(R.id.hollowrow);
        maplerow = woodcutting.findViewById(R.id.maplerow);
        mahoganyrow = woodcutting.findViewById(R.id.mahoganyrow);
        arcticrow = woodcutting.findViewById(R.id.arcticrow);
        yewrow = woodcutting.findViewById(R.id.yewrow);
        blisterwoodrow = woodcutting.findViewById(R.id.blisterwoodrow);
        sulliusceprow = woodcutting.findViewById(R.id.sulliusceprow);
        magicrow = woodcutting.findViewById(R.id.magicrow);
        redwoodrow = woodcutting.findViewById(R.id.redwoodrow);

        treetxt = woodcutting.findViewById(R.id.treetxt);
        acheytxt = woodcutting.findViewById(R.id.acheytxt);
        oaktxt = woodcutting.findViewById(R.id.oaktxt);
        willowtxt = woodcutting.findViewById(R.id.willowtxt);
        teaktxt = woodcutting.findViewById(R.id.teaktxt);
        hollowtxt = woodcutting.findViewById(R.id.hollowtxt);
        mapletxt = woodcutting.findViewById(R.id.mapletxt);
        mahoganytxt = woodcutting.findViewById(R.id.mahoganytxt);
        arctictxt = woodcutting.findViewById(R.id.arctictxt);
        yewtxt = woodcutting.findViewById(R.id.yewtxt);
        blisterwoodtxt = woodcutting.findViewById(R.id.blisterwoodtxt);
        sulliusceptxt = woodcutting.findViewById(R.id.sulliusceptxt);
        magictxt = woodcutting.findViewById(R.id.magictxt);
        redwoodtxt = woodcutting.findViewById(R.id.redwoodtxt);

        if (lumber.equals("true") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
            treesPercent = 25 + (25 * 2.5) / 100.0;
            oakPercent = 37.5 + (37.5 * 2.5) / 100.0;
            willowPercent = 67.5 + (67.5 * 2.5) / 100.0;
            teakPercent = 85 + (85 * 2.5) / 100.0;
            hollowPercent = 82.5 + (82.5 * 2.5) / 100.0;
            maplePercent = 100 + (100 * 2.5) / 100.0;
            mahoganyPercent = 125 + (125 * 2.5) / 100.0;
            arcticPercent = 40 + (40 * 2.5) / 100.0;
            yewPercent = 175 + (175 * 2.5) / 100.0;
            blisterwoodPercent = 76 + (76 * 2.5) / 100.0;
            sulliuscepPercent = 127 + (127 * 2.5) / 100.0;
            magicPercent = 250 + (250 * 2.5) / 100.0;
            redwoodPercent = 380 + (380 * 2.5) / 100.0;
        } else if (lumber.equals("true") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
            treesPercent = 25 + (25 * 2.5) / 100.0;
            oakPercent = 37.5 + (37.5 * 2.5) / 100.0;
            willowPercent = 67.5 + (67.5 * 2.5) / 100.0;
            teakPercent = 85 + (85 * 2.5) / 100.0;
            hollowPercent = 82.5 + (82.5 * 2.5) / 100.0;
            maplePercent = 100 + (100 * 2.5) / 100.0;
            mahoganyPercent = 125 + (125 * 2.5) / 100.0;
            arcticPercent = 40 + (40 * 2.5) / 100.0;
            yewPercent = 175 + (175 * 2.5) / 100.0;
            blisterwoodPercent = 76 + (76 * 2.5) / 100.0;
            sulliuscepPercent = 127 + (127 * 2.5) / 100.0;
            magicPercent = 250 + (250 * 2.5) / 100.0;
            redwoodPercent = 380 + (380 * 2.5) / 100.0;
        } else if (lumber.equals("true") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;
            treesPercent = 25 + (25 * 2.5) / 100.0;
            oakPercent = 37.5 + (37.5 * 2.5) / 100.0;
            willowPercent = 67.5 + (67.5 * 2.5) / 100.0;
            teakPercent = 85 + (85 * 2.5) / 100.0;
            hollowPercent = 82.5 + (82.5 * 2.5) / 100.0;
            maplePercent = 100 + (100 * 2.5) / 100.0;
            mahoganyPercent = 125 + (125 * 2.5) / 100.0;
            arcticPercent = 40 + (40 * 2.5) / 100.0;
            yewPercent = 175 + (175 * 2.5) / 100.0;
            blisterwoodPercent = 76 + (76 * 2.5) / 100.0;
            sulliuscepPercent = 127 + (127 * 2.5) / 100.0;
            magicPercent = 250 + (250 * 2.5) / 100.0;
            redwoodPercent = 380 + (380 * 2.5) / 100.0;
        } else if (lumber.equals("true") && gatherer.equals("false") && wisdom.equals("false")) {
            treesPercent = (25 * 2.5) / 100.0;
            oakPercent = (37.5 * 2.5) / 100.0;
            willowPercent = (67.5 * 2.5) / 100.0;
            teakPercent = (85 * 2.5) / 100.0;
            hollowPercent = (82.5 * 2.5) / 100.0;
            maplePercent = (100 * 2.5) / 100.0;
            mahoganyPercent = (125 * 2.5) / 100.0;
            arcticPercent = (40 * 2.5) / 100.0;
            yewPercent = (175 * 2.5) / 100.0;
            blisterwoodPercent = (76 * 2.5) / 100.0;
            sulliuscepPercent = (127 * 2.5) / 100.0;
            magicPercent = (250 * 2.5) / 100.0;
            redwoodPercent = (380 * 2.5) / 100.0;
        } else if (lumber.equals("false") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
        } else if (lumber.equals("false") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
        } else if (lumber.equals("false") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;

        }

        trees = (25 * bonus) + treesPercent;
        oak = (37.5 * bonus) + oakPercent;
        willow = (67.5 * bonus) + willowPercent;
        teak = (85 * bonus) + teakPercent;
        hollow = (82.5 * bonus) + hollowPercent;
        maple = (100 * bonus) + maplePercent;
        mahogany = (125 * bonus) + mahoganyPercent;
        arctic = (40 * bonus) + arcticPercent;
        yew = (175 * bonus) + yewPercent;
        blisterwood = (76 * bonus) + blisterwoodPercent;
        sulliuscep = (127 * bonus) + sulliuscepPercent;
        magic = (250 * bonus) + magicPercent;
        redwood = (380 * bonus) + redwoodPercent;

        treesToGo = xpLeft / trees + 1;
        oakToGo = xpLeft / oak + 1;
        willowToGo = (int) (xpLeft / willow + 1);
        teakToGo = (int) (xpLeft / teak + 1);
        hollowToGo = xpLeft / hollow + 1;
        mapleToGo = xpLeft / maple + 1;
        mahoganyToGo = xpLeft / mahogany + 1;
        arcticToGo = xpLeft / arctic + 1;
        yewToGo = xpLeft / yew + 1;
        blisterwoodToGo = xpLeft / blisterwood + 1;
        sulliuscepToGo = xpLeft / sulliuscep + 1;
        magicToGo = xpLeft / magic + 1;
        redwoodToGo = xpLeft / redwood + 1;

        t = NumberFormat.getIntegerInstance().format(treesToGo);
        o = NumberFormat.getIntegerInstance().format(oakToGo);
        w = NumberFormat.getIntegerInstance().format(willowToGo);
        te = NumberFormat.getIntegerInstance().format(teakToGo);
        h = NumberFormat.getIntegerInstance().format(hollowToGo);
        m = NumberFormat.getIntegerInstance().format(mapleToGo);
        mah = NumberFormat.getIntegerInstance().format(mahoganyToGo);
        a = NumberFormat.getIntegerInstance().format(arcticToGo);
        y = NumberFormat.getIntegerInstance().format(yewToGo);
        b = NumberFormat.getIntegerInstance().format(blisterwoodToGo);
        s = NumberFormat.getIntegerInstance().format(sulliuscepToGo);
        ma = NumberFormat.getIntegerInstance().format(magicToGo);
        r = NumberFormat.getIntegerInstance().format(redwoodToGo);

        treetxt.setText(t);
        acheytxt.setText(t);
        if (num2 >= 15) {
            oaktxt.setText(o);
        } else {
            oakrow.setVisibility(View.GONE);
        }
        if (num2 >= 30) {
            willowtxt.setText(w);
        } else {
            willowrow.setVisibility(View.GONE);
        }
        if (num2 >= 35) {
            teaktxt.setText(te);
        } else {
            teakrow.setVisibility(View.GONE);
        }
        if (num2 >= 45) {
            hollowtxt.setText(h);
            mapletxt.setText(m);
        } else {
            hollowrow.setVisibility(View.GONE);
            maplerow.setVisibility(View.GONE);
        }
        if (num2 >= 50) {
            mahoganytxt.setText(mah);
        } else {
            mahoganyrow.setVisibility(View.GONE);
        }
        if (num2 >= 54) {
            arctictxt.setText(a);
        } else {
            arcticrow.setVisibility(View.GONE);
        }
        if (num2 >= 60) {
            yewtxt.setText(y);
        } else {
            yewrow.setVisibility(View.GONE);
        }
        if (num2 >= 62) {
            blisterwoodtxt.setText(b);
        } else {
            blisterwoodrow.setVisibility(View.GONE);
        }
        if (num2 >= 65) {
            sulliusceptxt.setText(s);
        } else {
            sulliusceprow.setVisibility(View.GONE);
        }
        if (num2 >= 75) {
            magictxt.setText(ma);
        } else {
            magicrow.setVisibility(View.GONE);
        }
        if (num2 >= 90) {
            redwoodtxt.setText(r);
        } else {
            redwoodrow.setVisibility(View.GONE);
        }
    }
}