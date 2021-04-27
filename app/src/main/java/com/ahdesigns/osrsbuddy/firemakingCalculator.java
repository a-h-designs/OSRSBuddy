package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class firemakingCalculator {

    TableRow oakrow, willowrow, teakrow, arcticrow, maplerow, mahoganyrow, yewrow, blisterwoodrow,
            magicrow, redwoodrow;

    TextView logstxt, acheytxt, oaktxt, willowtxt, teaktxt, arctictxt, mapletxt, mahoganytxt,
            yewtxt, blisterwoodtxt, magictxt, redwoodtxt;

    String l, o, w, t, a, m, mah, y, b, ma, r;

    double logs, logsToGo, oak, oakToGo, willow, willowToGo, teak, teakToGo,
            arctic, arcticToGo, maple, mapleToGo, mahogany, mahoganyToGo, yew, yewToGo,
            blisterwood, blisterwoodToGo, magic, magicToGo, redwood, redwoodToGo,
            logsPercent = 0, oakPercent = 0,
            willowPercent = 0, teakPercent = 0, arcticPercent = 0, maplePercent = 0,
            mahoganyPercent = 0, yewPercent = 0, blisterwoodPercent = 0,
            magicPercent = 0, redwoodPercent = 0, bonus = 1;

    public void calculate(Integer num2, Integer xpLeft, View mining, String pyro,
                          String gatherer, String wisdom) {

        oakrow = mining.findViewById(R.id.oakrow);
        willowrow = mining.findViewById(R.id.willowrow);
        teakrow = mining.findViewById(R.id.teakrow);
        arcticrow = mining.findViewById(R.id.arcticrow);
        maplerow = mining.findViewById(R.id.maplerow);
        mahoganyrow = mining.findViewById(R.id.mahoganyrow);
        yewrow = mining.findViewById(R.id.yewrow);
        blisterwoodrow = mining.findViewById(R.id.blisterwoodrow);
        magicrow = mining.findViewById(R.id.magicrow);
        redwoodrow = mining.findViewById(R.id.redwoodrow);

        logstxt = mining.findViewById(R.id.logstxt);
        acheytxt = mining.findViewById(R.id.acheytxt);
        oaktxt = mining.findViewById(R.id.oaktxt);
        willowtxt = mining.findViewById(R.id.willowtxt);
        teaktxt = mining.findViewById(R.id.teaktxt);
        arctictxt = mining.findViewById(R.id.arctictxt);
        mapletxt = mining.findViewById(R.id.mapletxt);
        mahoganytxt = mining.findViewById(R.id.mahoganytxt);
        yewtxt = mining.findViewById(R.id.yewtxt);
        blisterwoodtxt = mining.findViewById(R.id.blisterwoodtxt);
        magictxt = mining.findViewById(R.id.magictxt);
        redwoodtxt = mining.findViewById(R.id.redwoodtxt);

        if (pyro.equals("true") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
            logsPercent = 40 + (40 * 2.5) / 100.0;
            oakPercent = 60 + (60 * 2.5) / 100.0;
            willowPercent = 90 + (90 * 2.5) / 100.0;
            teakPercent = 105 + (105 * 2.5) / 100.0;
            arcticPercent = 125 + (125 * 2.5) / 100.0;
            maplePercent = 135 + (135 * 2.5) / 100.0;
            mahoganyPercent = 157.5 + (157.5 * 2.5) / 100.0;
            yewPercent = 202.5 + (202.5 * 2.5) / 100.0;
            blisterwoodPercent = 96 + (96 * 2.5) / 100.0;
            magicPercent = 303.8 + (303.8 * 2.5) / 100.0;
            redwoodPercent = 350 + (350 * 2.5) / 100.0;
        } else if (pyro.equals("true") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
            logsPercent = 40 + (40 * 2.5) / 100.0;
            oakPercent = 60 + (60 * 2.5) / 100.0;
            willowPercent = 90 + (90 * 2.5) / 100.0;
            teakPercent = 105 + (105 * 2.5) / 100.0;
            arcticPercent = 125 + (125 * 2.5) / 100.0;
            maplePercent = 135 + (135 * 2.5) / 100.0;
            mahoganyPercent = 157.5 + (157.5 * 2.5) / 100.0;
            yewPercent = 202.5 + (202.5 * 2.5) / 100.0;
            blisterwoodPercent = 96 + (96 * 2.5) / 100.0;
            magicPercent = 303.8 + (303.8 * 2.5) / 100.0;
            redwoodPercent = 350 + (350 * 2.5) / 100.0;
        } else if (pyro.equals("true") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;
            logsPercent = 40 + (40 * 2.5) / 100.0;
            oakPercent = 60 + (60 * 2.5) / 100.0;
            willowPercent = 90 + (90 * 2.5) / 100.0;
            teakPercent = 105 + (105 * 2.5) / 100.0;
            arcticPercent = 125 + (125 * 2.5) / 100.0;
            maplePercent = 135 + (135 * 2.5) / 100.0;
            mahoganyPercent = 157.5 + (157.5 * 2.5) / 100.0;
            yewPercent = 202.5 + (202.5 * 2.5) / 100.0;
            blisterwoodPercent = 96 + (96 * 2.5) / 100.0;
            magicPercent = 303.8 + (303.8 * 2.5) / 100.0;
            redwoodPercent = 350 + (350 * 2.5) / 100.0;
        } else if (pyro.equals("true") && gatherer.equals("false") && wisdom.equals("false")) {
            logsPercent = (40 * 2.5) / 100.0;
            oakPercent = (60 * 2.5) / 100.0;
            willowPercent = (90 * 2.5) / 100.0;
            teakPercent = (105 * 2.5) / 100.0;
            arcticPercent = (125 * 2.5) / 100.0;
            maplePercent = (135 * 2.5) / 100.0;
            mahoganyPercent = (157.5 * 2.5) / 100.0;
            yewPercent = (202.5 * 2.5) / 100.0;
            blisterwoodPercent = (96 * 2.5) / 100.0;
            magicPercent = (303.8 * 2.5) / 100.0;
            redwoodPercent = (350 * 2.5) / 100.0;
        } else if (pyro.equals("false") && gatherer.equals("true") && wisdom.equals("true")) {
            bonus = 4;
        } else if (pyro.equals("false") && gatherer.equals("true") && wisdom.equals("false")) {
            bonus = 2;
        } else if (pyro.equals("false") && gatherer.equals("false") && wisdom.equals("true")) {
            bonus = 2;

        }

        logs = (40 * bonus) + logsPercent;
        oak = (60 * bonus) + oakPercent;
        willow = (90 * bonus) + willowPercent;
        teak = (105 * bonus) + teakPercent;
        arctic = (125 * bonus) + arcticPercent;
        maple = (135 * bonus) + maplePercent;
        mahogany = (157.5 * bonus) + mahoganyPercent;
        yew = (202.5 * bonus) + yewPercent;
        blisterwood = (96 * bonus) + blisterwoodPercent;
        magic = (303.8 * bonus) + magicPercent;
        redwood = (350 * bonus) + redwoodPercent;

        logsToGo = xpLeft / logs + 1;
        oakToGo = xpLeft / oak + 1;
        willowToGo = (int) (xpLeft / willow + 1);
        teakToGo = (int) (xpLeft / teak + 1);
        arcticToGo = xpLeft / arctic + 1;
        mapleToGo = xpLeft / maple + 1;
        mahoganyToGo = xpLeft / mahogany + 1;
        yewToGo = xpLeft / yew + 1;
        blisterwoodToGo = xpLeft / blisterwood + 1;
        magicToGo = xpLeft / magic + 1;
        redwoodToGo = xpLeft / redwood + 1;

        l = NumberFormat.getIntegerInstance().format(logsToGo);
        o = NumberFormat.getIntegerInstance().format(oakToGo);
        w = NumberFormat.getIntegerInstance().format(willowToGo);
        t = NumberFormat.getIntegerInstance().format(teakToGo);
        a = NumberFormat.getIntegerInstance().format(arcticToGo);
        m = NumberFormat.getIntegerInstance().format(mapleToGo);
        mah = NumberFormat.getIntegerInstance().format(mahoganyToGo);
        y = NumberFormat.getIntegerInstance().format(yewToGo);
        b = NumberFormat.getIntegerInstance().format(blisterwoodToGo);
        ma = NumberFormat.getIntegerInstance().format(magicToGo);
        r = NumberFormat.getIntegerInstance().format(redwoodToGo);

        logstxt.setText(l);
        acheytxt.setText(l);
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
            teaktxt.setText(t);
        } else {
            teakrow.setVisibility(View.GONE);
        }
        if (num2 >= 42) {
            arctictxt.setText(a);
        } else {
            arcticrow.setVisibility(View.GONE);
        }
        if (num2 >= 45) {
            mapletxt.setText(m);
        } else {
            maplerow.setVisibility(View.GONE);
        }
        if (num2 >= 50) {
            mahoganytxt.setText(mah);
        } else {
            mahoganyrow.setVisibility(View.GONE);
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