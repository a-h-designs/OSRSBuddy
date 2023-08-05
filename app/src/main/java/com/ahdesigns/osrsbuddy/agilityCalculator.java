package com.ahdesigns.osrsbuddy;

import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.NumberFormat;

public class agilityCalculator {

    TableRow draynorrow, edgevillerow, alkharidrow, floorspikesrow, handholdsrow, pressurepadsrow,
            varrockrow, penguinrow, pyramidrow, barbarianrow, canifisrow, spinningbladesrow,
            dartsrow, aperow, faladorrow, wildernessrow, hallowed1row, seersrow, werewolfrow,
            hallowed2row, pollnivneachrow, dorgeshrow, hallowed3row, prifrow, rellekkarow,
            hallowed4row, ardougnerow, hallowed5row;

    TextView gnometxt, planktxt, lowwalltxt, balancingropetxt, logbalancetxt, monkeybarstxt,
            balancingledgetxt, pillartxt, ropeswingtxt, draynortxt, edgevilletxt, alkharidtxt,
            floorspikestxt, handholdstxt, pressurepadstxt, varrocktxt, penguintxt, pyramidtxt,
            barbariantxt, canifistxt, spinningbladestxt, dartstxt, apetxt, faladortxt,
            wildernesstxt, hallowed1txt, seerstxt, werewolftxt, hallowed2txt, pollnivneachtxt,
            dorgeshtxt, hallowed3txt, priftxt, rellekkatxt, hallowed4txt, ardougnetxt, hallowed5txt;

    String g, p, l, br, lb, mb, bl, pi, rs, d, a, fs, pp, v, pe, py, b, c, sb, da, ap, f, w, h1, s,
            ww, h2, po, dor, h3, pr, r, h4, ar, h5;

    int gnomeToGo, plank, plankToGo, lowwall, lowwallToGo, balancingrope, balancingropeToGo,
        logbalance, logbalanceToGo, monkeybars, monkeybarsToGo, balancingledge, balancingledgeToGo,
        pillar, pillarToGo, ropeswing, ropeswingToGo, draynor, draynorToGo, alkharid, alkharidToGo,
        floorspikes, floorspikesToGo, pressurepads, pressurepadsToGo, varrock, varrockToGo,
        penguin, penguinToGo, pyramid, pyramidToGo, barbarianToGo, canifis, canifisToGo,
        spinningblades, spinningbladesToGo, darts, dartsToGo, ape, apeToGo, falador, faladorToGo,
        wildernessToGo, hallowed1, hallowed1ToGo, seers, seersToGo, werewolf, werewolfToGo,
        hallowed2, hallowed2ToGo, pollnivneach, pollnivneachToGo, dorgesh, dorgeshToGo, hallowed3,
        hallowed3ToGo, prifToGo, rellekka, rellekkaToGo, hallowed4, hallowed4ToGo, ardougne,
        ardougneToGo, hallowed5, hallowed5ToGo, bonus = 1;

    double gnome, barbarian, wilderness, prif;

    public void calculate(Integer num2, Integer xpLeft, View agility, String wisdom) {

        gnometxt = agility.findViewById(R.id.gnometxt);
        planktxt = agility.findViewById(R.id.planktxt);
        lowwalltxt = agility.findViewById(R.id.lowwalltxt);
        balancingropetxt = agility.findViewById(R.id.balancingropetxt);
        logbalancetxt = agility.findViewById(R.id.logbalancetxt);
        monkeybarstxt = agility.findViewById(R.id.monkeybarstxt);
        balancingledgetxt = agility.findViewById(R.id.balancingledgetxt);
        pillartxt = agility.findViewById(R.id.pillartxt);
        ropeswingtxt = agility.findViewById(R.id.ropeswingtxt);
        draynorrow = agility.findViewById(R.id.draynorrow);
        edgevillerow = agility.findViewById(R.id.edgevillerow);
        alkharidrow = agility.findViewById(R.id.alkharidrow);
        floorspikesrow = agility.findViewById(R.id.floorspikesrow);
        handholdsrow = agility.findViewById(R.id.handholdsrow);
        pressurepadsrow = agility.findViewById(R.id.pressurepadsrow);
        varrockrow = agility.findViewById(R.id.varrockrow);
        penguinrow = agility.findViewById(R.id.penguinrow);
        pyramidrow = agility.findViewById(R.id.pyramidrow);
        barbarianrow = agility.findViewById(R.id.barbarianrow);
        canifisrow = agility.findViewById(R.id.canifisrow);
        spinningbladesrow = agility.findViewById(R.id.spinningbladesrow);
        dartsrow = agility.findViewById(R.id.dartsrow);
        aperow = agility.findViewById(R.id.aperow);
        faladorrow = agility.findViewById(R.id.faladorrow);
        wildernessrow = agility.findViewById(R.id.wildernessrow);
        hallowed1row = agility.findViewById(R.id.hallowed1row);
        seersrow = agility.findViewById(R.id.seersrow);
        werewolfrow = agility.findViewById(R.id.werewolfrow);
        hallowed2row = agility.findViewById(R.id.hallowed2row);
        pollnivneachrow = agility.findViewById(R.id.pollnivneachrow);
        dorgeshrow = agility.findViewById(R.id.dorgeshrow);
        hallowed3row = agility.findViewById(R.id.hallowed3row);
        prifrow = agility.findViewById(R.id.prifrow);
        rellekkarow = agility.findViewById(R.id.rellekkarow);
        hallowed4row = agility.findViewById(R.id.hallowed4row);
        ardougnerow = agility.findViewById(R.id.ardougnerow);
        hallowed5row = agility.findViewById(R.id.hallowed5row);

        draynortxt = agility.findViewById(R.id.draynortxt);
        edgevilletxt = agility.findViewById(R.id.edgevilletxt);
        alkharidtxt = agility.findViewById(R.id.alkharidtxt);
        floorspikestxt = agility.findViewById(R.id.floorspikestxt);
        handholdstxt = agility.findViewById(R.id.handholdstxt);
        pressurepadstxt = agility.findViewById(R.id.pressurepadstxt);
        varrocktxt = agility.findViewById(R.id.varrocktxt);
        penguintxt = agility.findViewById(R.id.penguintxt);
        pyramidtxt = agility.findViewById(R.id.pyramidtxt);
        barbariantxt = agility.findViewById(R.id.barbariantxt);
        canifistxt = agility.findViewById(R.id.canifistxt);
        spinningbladestxt = agility.findViewById(R.id.spinningbladestxt);
        dartstxt = agility.findViewById(R.id.dartstxt);
        apetxt = agility.findViewById(R.id.apetxt);
        faladortxt = agility.findViewById(R.id.faladortxt);
        wildernesstxt = agility.findViewById(R.id.wildernesstxt);
        hallowed1txt = agility.findViewById(R.id.hallowed1txt);
        seerstxt = agility.findViewById(R.id.seerstxt);
        werewolftxt = agility.findViewById(R.id.werewolftxt);
        hallowed2txt = agility.findViewById(R.id.hallowed2txt);
        pollnivneachtxt = agility.findViewById(R.id.pollnivneachtxt);
        dorgeshtxt = agility.findViewById(R.id.dorgeshtxt);
        hallowed3txt = agility.findViewById(R.id.hallowed3txt);
        priftxt = agility.findViewById(R.id.priftxt);
        rellekkatxt = agility.findViewById(R.id.rellekkatxt);
        hallowed4txt = agility.findViewById(R.id.hallowed4txt);
        ardougnetxt = agility.findViewById(R.id.ardougnetxt);
        hallowed5txt = agility.findViewById(R.id.hallowed5txt);

        if (wisdom.equals("true")) {
            bonus = 2;
        }

        gnome = 86.5 * bonus;
        plank = 6 * bonus;
        lowwall = 8 * bonus;
        balancingrope = 40 * bonus;
        logbalance = 12 * bonus;
        monkeybars = 14 * bonus;
        balancingledge = 16 * bonus;
        pillar = 18 * bonus;
        ropeswing = 20 * bonus;
        draynor = 120 * bonus;
        alkharid = 180 * bonus;
        floorspikes = 22 * bonus;
        pressurepads = 26 * bonus;
        varrock = 238 * bonus;
        penguin = 540 * bonus;
        pyramid = 1030 * bonus;
        barbarian = 152.5 * bonus;
        canifis = 240 * bonus;
        spinningblades = 28 * bonus;
        darts = 30 * bonus;
        ape = 580 * bonus;
        falador = 440 * bonus;
        wilderness = 571.4 * bonus;
        hallowed1 = 575 * bonus;
        seers = 570 * bonus;
        werewolf = 730 * bonus;
        hallowed2 = 1500 * bonus;
        pollnivneach = 890 * bonus;
        dorgesh = 2750 * bonus;
        hallowed3 = 3000 * bonus;
        prif = 1312.5 * bonus;
        rellekka = 780 * bonus;
        hallowed4 = 5700 * bonus;
        ardougne = 793 * bonus;
        hallowed5 = 11700 * bonus;

        gnomeToGo = (int) (xpLeft / gnome + 1);
        plankToGo = (int) (xpLeft / plank + 1);
        lowwallToGo = (int) (xpLeft / lowwall + 1);
        balancingropeToGo = (int) (xpLeft / balancingrope + 1);
        logbalanceToGo = (int) (xpLeft / logbalance + 1);
        monkeybarsToGo = (int) (xpLeft / monkeybars + 1);
        balancingledgeToGo = (int) (xpLeft / balancingledge + 1);
        pillarToGo = (int) (xpLeft / pillar + 1);
        ropeswingToGo = (int) (xpLeft / ropeswing + 1);
        draynorToGo = (int) (xpLeft / draynor + 1);
        alkharidToGo = (int) (xpLeft / alkharid + 1);
        floorspikesToGo = (int) (xpLeft / floorspikes + 1);
        pressurepadsToGo = (int) (xpLeft / pressurepads + 1);
        varrockToGo = (int) (xpLeft / varrock + 1);
        penguinToGo = (int) (xpLeft / penguin + 1);
        pyramidToGo = (int) (xpLeft / pyramid + 1);
        barbarianToGo = (int) (xpLeft / barbarian + 1);
        canifisToGo = (int) (xpLeft / canifis + 1);
        spinningbladesToGo = (int) (xpLeft / spinningblades + 1);
        dartsToGo = (int) (xpLeft / darts + 1);
        apeToGo = (int) (xpLeft / ape + 1);
        faladorToGo = (int) (xpLeft / falador + 1);
        wildernessToGo = (int) (xpLeft / wilderness + 1);
        hallowed1ToGo = (int) (xpLeft / hallowed1 + 1);
        seersToGo = (int) (xpLeft / seers + 1);
        werewolfToGo = (int) (xpLeft / werewolf + 1);
        hallowed2ToGo = (int) (xpLeft / hallowed2 + 1);
        pollnivneachToGo = (int) (xpLeft / pollnivneach + 1);
        dorgeshToGo = (int) (xpLeft / dorgesh + 1);
        hallowed3ToGo = (int) (xpLeft / hallowed3 + 1);
        prifToGo = (int) (xpLeft / prif + 1);
        rellekkaToGo = (int) (xpLeft / rellekka + 1);
        hallowed4ToGo = (int) (xpLeft / hallowed4 + 1);
        ardougneToGo = (int) (xpLeft / ardougne + 1);
        hallowed5ToGo = (int) (xpLeft / hallowed5 + 1);
        g = NumberFormat.getIntegerInstance().format(gnomeToGo);
        p = NumberFormat.getIntegerInstance().format(plankToGo);
        l = NumberFormat.getIntegerInstance().format(lowwallToGo);
        br = NumberFormat.getIntegerInstance().format(balancingropeToGo);
        lb = NumberFormat.getIntegerInstance().format(logbalanceToGo);
        mb = NumberFormat.getIntegerInstance().format(monkeybarsToGo);
        bl = NumberFormat.getIntegerInstance().format(balancingledgeToGo);
        pi = NumberFormat.getIntegerInstance().format(pillarToGo);
        rs = NumberFormat.getIntegerInstance().format(ropeswingToGo);
        d = NumberFormat.getIntegerInstance().format(draynorToGo);
        a = NumberFormat.getIntegerInstance().format(alkharidToGo);
        fs = NumberFormat.getIntegerInstance().format(floorspikesToGo);
        pp = NumberFormat.getIntegerInstance().format(pressurepadsToGo);
        v = NumberFormat.getIntegerInstance().format(varrockToGo);
        pe = NumberFormat.getIntegerInstance().format(penguinToGo);
        py = NumberFormat.getIntegerInstance().format(pyramidToGo);
        b = NumberFormat.getIntegerInstance().format(barbarianToGo);
        c = NumberFormat.getIntegerInstance().format(canifisToGo);
        sb = NumberFormat.getIntegerInstance().format(spinningbladesToGo);
        da = NumberFormat.getIntegerInstance().format(dartsToGo);
        ap = NumberFormat.getIntegerInstance().format(apeToGo);
        f = NumberFormat.getIntegerInstance().format(faladorToGo);
        w = NumberFormat.getIntegerInstance().format(wildernessToGo);
        h1 = NumberFormat.getIntegerInstance().format(hallowed1ToGo);
        s = NumberFormat.getIntegerInstance().format(seersToGo);
        ww = NumberFormat.getIntegerInstance().format(werewolfToGo);
        h2 = NumberFormat.getIntegerInstance().format(hallowed2ToGo);
        po = NumberFormat.getIntegerInstance().format(pollnivneachToGo);
        dor = NumberFormat.getIntegerInstance().format(dorgeshToGo);
        h3 = NumberFormat.getIntegerInstance().format(hallowed3ToGo);
        pr = NumberFormat.getIntegerInstance().format(prifToGo);
        r = NumberFormat.getIntegerInstance().format(rellekkaToGo);
        h4 = NumberFormat.getIntegerInstance().format(hallowed4ToGo);
        ar = NumberFormat.getIntegerInstance().format(ardougneToGo);
        h5 = NumberFormat.getIntegerInstance().format(hallowed5ToGo);
        gnometxt.setText(g);
        planktxt.setText(p);
        lowwalltxt.setText(l);
        balancingropetxt.setText(br);
        logbalancetxt.setText(lb);
        monkeybarstxt.setText(mb);
        balancingledgetxt.setText(bl);
        pillartxt.setText(pi);
        ropeswingtxt.setText(rs);

        if (num2 >= 10) {
            draynortxt.setText(d);
        } else {
            draynorrow.setVisibility(View.GONE);
        }
        if (num2 >= 15) {
            edgevilletxt.setText(rs);
        } else {
            edgevillerow.setVisibility(View.GONE);
        }
        if (num2 >= 20) {
            alkharidtxt.setText(a);
            floorspikestxt.setText(fs);
            handholdstxt.setText(fs);
            pressurepadstxt.setText(pp);
        } else {
            alkharidrow.setVisibility(View.GONE);
            floorspikesrow.setVisibility(View.GONE);
            handholdsrow.setVisibility(View.GONE);
            pressurepadsrow.setVisibility(View.GONE);
        }
        if (num2 >= 30) {
            varrocktxt.setText(v);
            penguintxt.setText(pe);
            pyramidtxt.setText(py);
        } else {
            varrockrow.setVisibility(View.GONE);
            penguinrow.setVisibility(View.GONE);
            pyramidrow.setVisibility(View.GONE);
        }
        if (num2 >= 35) {
            barbariantxt.setText(b);
        } else {
            barbarianrow.setVisibility(View.GONE);
        }
        if (num2 >= 40) {
            canifistxt.setText(c);
            spinningbladestxt.setText(sb);
            dartstxt.setText(da);
        } else {
            canifisrow.setVisibility(View.GONE);
            spinningbladesrow.setVisibility(View.GONE);
            dartsrow.setVisibility(View.GONE);
        }
        if (num2 >= 48) {
            apetxt.setText(ap);
        } else {
            aperow.setVisibility(View.GONE);
        }
        if (num2 >= 50) {
            faladortxt.setText(f);
        } else {
            faladorrow.setVisibility(View.GONE);
        }
        if (num2 >= 52) {
            wildernesstxt.setText(w);
            hallowed1txt.setText(h1);
        } else {
            wildernessrow.setVisibility(View.GONE);
            hallowed1row.setVisibility(View.GONE);
        }
        if (num2 >= 60) {
            seerstxt.setText(s);
            werewolftxt.setText(ww);
        } else {
            seersrow.setVisibility(View.GONE);
            werewolfrow.setVisibility(View.GONE);
        }
        if (num2 >= 62) {
            hallowed2txt.setText(h2);
        } else {
            hallowed2row.setVisibility(View.GONE);
        }
        if (num2 >= 70) {
            pollnivneachtxt.setText(po);
            dorgeshtxt.setText(dor);
        } else {
            pollnivneachrow.setVisibility(View.GONE);
            dorgeshrow.setVisibility(View.GONE);
        }
        if (num2 >= 72) {
            hallowed3txt.setText(h3);
        } else {
            hallowed3row.setVisibility(View.GONE);
        }
        if (num2 >= 75) {
            priftxt.setText(pr);
        } else {
            prifrow.setVisibility(View.GONE);
        }
        if (num2 >= 80) {
            rellekkatxt.setText(r);
        } else {
            rellekkarow.setVisibility(View.GONE);
        }
        if (num2 >= 82) {
            hallowed4txt.setText(h4);
        } else {
            hallowed4row.setVisibility(View.GONE);
        }
        if (num2 >= 90) {
            ardougnetxt.setText(ar);
        } else {
            ardougnerow.setVisibility(View.GONE);
        }
        if (num2 >= 92) {
            hallowed5txt.setText(h5);
        } else {
            hallowed5row.setVisibility(View.GONE);
        }
    }
}