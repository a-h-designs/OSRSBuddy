package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.widget.TextView;

import java.text.DecimalFormat;

public class calculateXP {

    String nextLvl;

    public static int xpLeft;

    @SuppressLint("SetTextI18n")
    public void calculate(String num, TextView nextLevel){

        nextLvl = nextLevel.getText().toString();

        if(nextLevel.getText() != null) {
            switch (nextLvl) {
                case "10":
                    xpLeft = Integer.parseInt("1154") - Integer.parseInt(num);
                    break;
                case "11":
                    xpLeft = Integer.parseInt("1358") - Integer.parseInt(num);
                    break;
                case "12":
                    xpLeft = Integer.parseInt("1584") - Integer.parseInt(num);
                    break;
                case "13":
                    xpLeft = Integer.parseInt("1833") - Integer.parseInt(num);
                    break;
                case "14":
                    xpLeft = Integer.parseInt("2107") - Integer.parseInt(num);
                    break;
                case "15":
                    xpLeft = Integer.parseInt("2411") - Integer.parseInt(num);
                    break;
                case "16":
                    xpLeft = Integer.parseInt("2746") - Integer.parseInt(num);
                    break;
                case "17":
                    xpLeft = Integer.parseInt("3115") - Integer.parseInt(num);
                    break;
                case "18":
                    xpLeft = Integer.parseInt("3523") - Integer.parseInt(num);
                    break;
                case "19":
                    xpLeft = Integer.parseInt("3973") - Integer.parseInt(num);
                    break;
                case "20":
                    xpLeft = Integer.parseInt("4470") - Integer.parseInt(num);
                    break;
                case "21":
                    xpLeft = Integer.parseInt("5018") - Integer.parseInt(num);
                    break;
                case "22":
                    xpLeft = Integer.parseInt("5624") - Integer.parseInt(num);
                    break;
                case "23":
                    xpLeft = Integer.parseInt("6291") - Integer.parseInt(num);
                    break;
                case "24":
                    xpLeft = Integer.parseInt("7028") - Integer.parseInt(num);
                    break;
                case "25":
                    xpLeft = Integer.parseInt("7842") - Integer.parseInt(num);
                    break;
                case "26":
                    xpLeft = Integer.parseInt("8740") - Integer.parseInt(num);
                    break;
                case "27":
                    xpLeft = Integer.parseInt("9730") - Integer.parseInt(num);
                    break;
                case "28":
                    xpLeft = Integer.parseInt("10824") - Integer.parseInt(num);
                    break;
                case "29":
                    xpLeft = Integer.parseInt("12031") - Integer.parseInt(num);
                    break;
                case "30":
                    xpLeft = Integer.parseInt("13363") - Integer.parseInt(num);
                    break;
                case "31":
                    xpLeft = Integer.parseInt("14833") - Integer.parseInt(num);
                    break;
                case "32":
                    xpLeft = Integer.parseInt("16456") - Integer.parseInt(num);
                    break;
                case "33":
                    xpLeft = Integer.parseInt("18247") - Integer.parseInt(num);
                    break;
                case "34":
                    xpLeft = Integer.parseInt("20224") - Integer.parseInt(num);
                    break;
                case "35":
                    xpLeft = Integer.parseInt("22406") - Integer.parseInt(num);
                    break;
                case "36":
                    xpLeft = Integer.parseInt("24815") - Integer.parseInt(num);
                    break;
                case "37":
                    xpLeft = Integer.parseInt("27473") - Integer.parseInt(num);
                    break;
                case "38":
                    xpLeft = Integer.parseInt("30408") - Integer.parseInt(num);
                    break;
                case "39":
                    xpLeft = Integer.parseInt("33648") - Integer.parseInt(num);
                    break;
                case "40":
                    xpLeft = Integer.parseInt("37224") - Integer.parseInt(num);
                    break;
                case "41":
                    xpLeft = Integer.parseInt("41171") - Integer.parseInt(num);
                    break;
                case "42":
                    xpLeft = Integer.parseInt("45529") - Integer.parseInt(num);
                    break;
                case "43":
                    xpLeft = Integer.parseInt("50339") - Integer.parseInt(num);
                    break;
                case "44":
                    xpLeft = Integer.parseInt("55649") - Integer.parseInt(num);
                    break;
                case "45":
                    xpLeft = Integer.parseInt("61512") - Integer.parseInt(num);
                    break;
                case "46":
                    xpLeft = Integer.parseInt("67983") - Integer.parseInt(num);
                    break;
                case "47":
                    xpLeft = Integer.parseInt("75127") - Integer.parseInt(num);
                    break;
                case "48":
                    xpLeft = Integer.parseInt("83014") - Integer.parseInt(num);
                    break;
                case "49":
                    xpLeft = Integer.parseInt("91721") - Integer.parseInt(num);
                    break;
                case "50":
                    xpLeft = Integer.parseInt("101333") - Integer.parseInt(num);
                    break;
                case "51":
                    xpLeft = Integer.parseInt("111945") - Integer.parseInt(num);
                    break;
                case "52":
                    xpLeft = Integer.parseInt("123660") - Integer.parseInt(num);
                    break;
                case "53":
                    xpLeft = Integer.parseInt("136594") - Integer.parseInt(num);
                    break;
                case "54":
                    xpLeft = Integer.parseInt("150872") - Integer.parseInt(num);
                    break;
                case "55":
                    xpLeft = Integer.parseInt("166636") - Integer.parseInt(num);
                    break;
                case "56":
                    xpLeft = Integer.parseInt("184040") - Integer.parseInt(num);
                    break;
                case "57":
                    xpLeft = Integer.parseInt("203254") - Integer.parseInt(num);
                    break;
                case "58":
                    xpLeft = Integer.parseInt("224466") - Integer.parseInt(num);
                    break;
                case "59":
                    xpLeft = Integer.parseInt("247886") - Integer.parseInt(num);
                    break;
                case "60":
                    xpLeft = Integer.parseInt("273742") - Integer.parseInt(num);
                    break;
                case "61":
                    xpLeft = Integer.parseInt("302288") - Integer.parseInt(num);
                    break;
                case "62":
                    xpLeft = Integer.parseInt("333804") - Integer.parseInt(num);
                    break;
                case "63":
                    xpLeft = Integer.parseInt("368599") - Integer.parseInt(num);
                    break;
                case "64":
                    xpLeft = Integer.parseInt("407015") - Integer.parseInt(num);
                    break;
                case "65":
                    xpLeft = Integer.parseInt("449428") - Integer.parseInt(num);
                    break;
                case "66":
                    xpLeft = Integer.parseInt("496254") - Integer.parseInt(num);
                    break;
                case "67":
                    xpLeft = Integer.parseInt("547953") - Integer.parseInt(num);
                    break;
                case "68":
                    xpLeft = Integer.parseInt("605032") - Integer.parseInt(num);
                    break;
                case "69":
                    xpLeft = Integer.parseInt("668051") - Integer.parseInt(num);
                    break;
                case "70":
                    xpLeft = Integer.parseInt("737627") - Integer.parseInt(num);
                    break;
                case "71":
                    xpLeft = Integer.parseInt("814445") - Integer.parseInt(num);
                    break;
                case "72":
                    xpLeft = Integer.parseInt("899257") - Integer.parseInt(num);
                    break;
                case "73":
                    xpLeft = Integer.parseInt("992895") - Integer.parseInt(num);
                    break;
                case "74":
                    xpLeft = Integer.parseInt("1096278") - Integer.parseInt(num);
                    break;
                case "75":
                    xpLeft = Integer.parseInt("1210421") - Integer.parseInt(num);
                    break;
                case "76":
                    xpLeft = Integer.parseInt("1336443") - Integer.parseInt(num);
                    break;
                case "77":
                    xpLeft = Integer.parseInt("1475581") - Integer.parseInt(num);
                    break;
                case "78":
                    xpLeft = Integer.parseInt("1629200") - Integer.parseInt(num);
                    break;
                case "79":
                    xpLeft = Integer.parseInt("1798808") - Integer.parseInt(num);
                    break;
                case "80":
                    xpLeft = Integer.parseInt("1986068") - Integer.parseInt(num);
                    break;
                case "81":
                    xpLeft = Integer.parseInt("2192818") - Integer.parseInt(num);
                    break;
                case "82":
                    xpLeft = Integer.parseInt("2421087") - Integer.parseInt(num);
                    break;
                case "83":
                    xpLeft = Integer.parseInt("2673114") - Integer.parseInt(num);
                    break;
                case "84":
                    xpLeft = Integer.parseInt("2951373") - Integer.parseInt(num);
                    break;
                case "85":
                    xpLeft = Integer.parseInt("3258594") - Integer.parseInt(num);
                    break;
                case "86":
                    xpLeft = Integer.parseInt("3597792") - Integer.parseInt(num);
                    break;
                case "87":
                    xpLeft = Integer.parseInt("3972294") - Integer.parseInt(num);
                    break;
                case "88":
                    xpLeft = Integer.parseInt("4385776") - Integer.parseInt(num);
                    break;
                case "89":
                    xpLeft = Integer.parseInt("4842295") - Integer.parseInt(num);
                    break;
                case "90":
                    xpLeft = Integer.parseInt("5346332") - Integer.parseInt(num);
                    break;
                case "91":
                    xpLeft = Integer.parseInt("5902831") - Integer.parseInt(num);
                    break;
                case "92":
                    xpLeft = Integer.parseInt("6517253") - Integer.parseInt(num);
                    break;
                case "93":
                    xpLeft = Integer.parseInt("7195629") - Integer.parseInt(num);
                    break;
                case "94":
                    xpLeft = Integer.parseInt("7944614") - Integer.parseInt(num);
                    break;
                case "95":
                    xpLeft = Integer.parseInt("8771558") - Integer.parseInt(num);
                    break;
                case "96":
                    xpLeft = Integer.parseInt("9684577") - Integer.parseInt(num);
                    break;
                case "97":
                    xpLeft = Integer.parseInt("10692629") - Integer.parseInt(num);
                    break;
                case "98":
                    xpLeft = Integer.parseInt("11805606") - Integer.parseInt(num);
                    break;
                case "99":
                    xpLeft = Integer.parseInt("13034431") - Integer.parseInt(num);
                    break;
                case "Max":
                    xpLeft = Integer.parseInt("200000000") - Integer.parseInt(num);
                    break;
                default:
                    break;
            }
        }
    }
}
