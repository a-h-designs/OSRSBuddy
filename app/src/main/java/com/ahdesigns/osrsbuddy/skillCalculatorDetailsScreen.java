package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Objects;

public class skillCalculatorDetailsScreen extends AppCompatActivity {

    ImageView skillImage;

    TextView currentLevel, nextLevel, nextXP;

    String username, skill, num, nextLvl, b,
            title, imageSrc, jsonURL,
            url, currentLvl, overallRankValue,
            attackLvlValue, attackXpValue,
            defenceLvlValue, defenceXpValue,
            strengthLvlValue, strengthXpValue,
            hitpointsLvlValue,hitpointsXpValue,
            rangedLvlValue, rangedXpValue,
            prayerLvlValue, prayerXpValue,
            magicLvlValue, magicXpValue,
            cookingLvlValue, cookingXpValue,
            woodcuttingLvlValue, woodcuttingXpValue,
            fletchingLvlValue, fletchingXpValue,
            fishingLvlValue, fishingXpValue,
            firemakingLvlValue, firemakingXpValue,
            craftingLvlValue, craftingXpValue,
            smithingLvlValue, smithingXpValue,
            miningLvlValue, miningXpValue,
            herbloreLvlValue, herbloreXpValue,
            agilityLvlValue, agilityXpValue,
            thievingLvlValue, thievingXpValue,
            slayerLvlValue, slayerXpValue,
            farmingLvlValue, farmingXpValue,
            runecraftingLvlValue, runecraftingXpValue,
            hunterLvlValue, hunterXpValue,
            constructionLvlValue, constructionXpValue;

    int resImage, sum, xpLeft;

    private ProgressDialog pDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skillcalculatordetailsscreen);

        skillImage = findViewById(R.id.chatHead);

        currentLevel = findViewById(R.id.currentLevel);
        nextLevel = findViewById(R.id.nextLevel);
        nextXP = findViewById(R.id.nextXP);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        username = extras.getString("username");
        skill = extras.getString("skill");
        title = skill.substring(0, 1).toUpperCase() + skill.substring(1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        try {
            assert url != null;
            jsonURL = "http://ahdesigns.coolpage.biz/old_hiscores.php?user=" + URLEncoder.encode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        imageSrc = ("calculator_icon_" + skill);
        resImage = getResources().getIdentifier(imageSrc , "drawable", getPackageName());
        skillImage.setImageResource(resImage);
        //Call the GetData class
        new GetData().execute();

    }

    //Get data class to get json data
    @SuppressLint("StaticFieldLeak")
    private class GetData extends AsyncTask<Void, Void, Void> {

        //Before data will be looked up
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Showing progress dialog
            pDialog = new ProgressDialog(skillCalculatorDetailsScreen.this);
            pDialog.setMessage("Searching Hiscores...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        //During the background operation
        @Override
        protected Void doInBackground(Void... arg0) {

            // Creating service handler class
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(jsonURL, ServiceHandler.GET);

            //Check to see if JSON string is not empty
            if (jsonStr != null) {
                try {

                    //Create a new JSON object
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting the 'overall' object from the JSON object
                    JSONObject overall = jsonObj.getJSONObject("overall");

                    //From the 'overall' object, we want the below strings
                    //Assign all string and int to variables
                    overallRankValue = overall.getString("rank");


                    // Getting the 'attack' object from the JSON object
                    JSONObject attack = jsonObj.getJSONObject("attack");

                    //From the 'attack' object, we want the below strings
                    //Assign all string and int to variables
                    attackLvlValue = attack.getString("level");
                    attackXpValue = attack.getString("xp");

                    // Getting the 'defence' object from the JSON object
                    JSONObject defence = jsonObj.getJSONObject("defence");

                    //From the 'defence' object, we want the below strings
                    //Assign all string and int to variables
                    defenceLvlValue = defence.getString("level");
                    defenceXpValue = defence.getString("xp");

                    // Getting the 'strength' object from the JSON object
                    JSONObject strength = jsonObj.getJSONObject("strength");

                    //From the 'strength' object, we want the below strings
                    //Assign all string and int to variables
                    strengthLvlValue = strength.getString("level");
                    strengthXpValue = strength.getString("xp");

                    // Getting the 'constitution' object from the JSON object
                    JSONObject hitpoints = jsonObj.getJSONObject("hitpoints");

                    //From the 'constitution' object, we want the below strings
                    //Assign all string and int to variables
                    hitpointsLvlValue = hitpoints.getString("level");
                    hitpointsXpValue = hitpoints.getString("xp");

                    // Getting the 'ranged' object from the JSON object
                    JSONObject ranged = jsonObj.getJSONObject("ranged");

                    //From the 'ranged' object, we want the below strings
                    //Assign all string and int to variables
                    rangedLvlValue = ranged.getString("level");
                    rangedXpValue = ranged.getString("xp");

                    // Getting the 'prayer' object from the JSON object
                    JSONObject prayer = jsonObj.getJSONObject("prayer");

                    //From the 'prayer' object, we want the below strings
                    //Assign all string and int to variables
                    prayerLvlValue = prayer.getString("level");
                    prayerXpValue = prayer.getString("xp");

                    // Getting the 'magic' object from the JSON object
                    JSONObject magic = jsonObj.getJSONObject("magic");

                    //From the 'magic' object, we want the below strings
                    //Assign all string and int to variables
                    magicLvlValue = magic.getString("level");
                    magicXpValue = magic.getString("xp");

                    // Getting the 'cooking' object from the JSON object
                    JSONObject cooking = jsonObj.getJSONObject("cooking");

                    //From the 'cooking' object, we want the below strings
                    //Assign all string and int to variables
                    cookingLvlValue = cooking.getString("level");
                    cookingXpValue = cooking.getString("xp");

                    // Getting the 'woodcutting' object from the JSON object
                    JSONObject woodcutting = jsonObj.getJSONObject("woodcutting");

                    //From the 'woodcutting' object, we want the below strings
                    //Assign all string and int to variables
                    woodcuttingLvlValue = woodcutting.getString("level");
                    woodcuttingXpValue = woodcutting.getString("xp");

                    // Getting the 'fletching' object from the JSON object
                    JSONObject fletching = jsonObj.getJSONObject("fletching");

                    //From the 'fletching' object, we want the below strings
                    //Assign all string and int to variables
                    fletchingLvlValue = fletching.getString("level");
                    fletchingXpValue = fletching.getString("xp");

                    // Getting the 'fishing' object from the JSON object
                    JSONObject fishing = jsonObj.getJSONObject("fishing");

                    //From the 'fishing' object, we want the below strings
                    //Assign all string and int to variables
                    fishingLvlValue = fishing.getString("level");
                    fishingXpValue = fishing.getString("xp");

                    // Getting the 'firemaking' object from the JSON object
                    JSONObject firemaking = jsonObj.getJSONObject("firemaking");

                    //From the 'firemaking' object, we want the below strings
                    //Assign all string and int to variables
                    firemakingLvlValue = firemaking.getString("level");
                    firemakingXpValue = firemaking.getString("xp");

                    // Getting the 'crafting' object from the JSON object
                    JSONObject crafting = jsonObj.getJSONObject("crafting");

                    //From the 'crafting' object, we want the below strings
                    //Assign all string and int to variables
                    craftingLvlValue = crafting.getString("level");
                    craftingXpValue = crafting.getString("xp");

                    // Getting the 'smithing' object from the JSON object
                    JSONObject smithing = jsonObj.getJSONObject("smithing");

                    //From the 'smithing' object, we want the below strings
                    //Assign all string and int to variables
                    smithingLvlValue = smithing.getString("level");
                    smithingXpValue = smithing.getString("xp");

                    // Getting the 'mining' object from the JSON object
                    JSONObject mining = jsonObj.getJSONObject("mining");

                    //From the 'mining' object, we want the below strings
                    //Assign all string and int to variables
                    miningLvlValue = mining.getString("level");
                    miningXpValue = mining.getString("xp");

                    // Getting the 'herblore' object from the JSON object
                    JSONObject herblore = jsonObj.getJSONObject("herblore");

                    //From the 'herblore' object, we want the below strings
                    //Assign all string and int to variables
                    herbloreLvlValue = herblore.getString("level");
                    herbloreXpValue = herblore.getString("xp");

                    // Getting the 'agility' object from the JSON object
                    JSONObject agility = jsonObj.getJSONObject("agility");

                    //From the 'agility' object, we want the below strings
                    //Assign all string and int to variables
                    agilityLvlValue = agility.getString("level");
                    agilityXpValue = agility.getString("xp");

                    // Getting the 'thieving' object from the JSON object
                    JSONObject thieving = jsonObj.getJSONObject("thieving");

                    //From the 'thieving' object, we want the below strings
                    //Assign all string and int to variables
                    thievingLvlValue = thieving.getString("level");
                    thievingXpValue = thieving.getString("xp");

                    // Getting the 'slayer' object from the JSON object
                    JSONObject slayer = jsonObj.getJSONObject("slayer");

                    //From the 'slayer' object, we want the below strings
                    //Assign all string and int to variables
                    slayerLvlValue = slayer.getString("level");
                    slayerXpValue = slayer.getString("xp");

                    // Getting the 'farming' object from the JSON object
                    JSONObject farming = jsonObj.getJSONObject("farming");

                    //From the 'farming' object, we want the below strings
                    //Assign all string and int to variables
                    farmingLvlValue = farming.getString("level");
                    farmingXpValue = farming.getString("xp");

                    // Getting the 'runecrafting' object from the JSON object
                    JSONObject runecrafting = jsonObj.getJSONObject("runecrafting");

                    //From the 'runecrafting' object, we want the below strings
                    //Assign all string and int to variables
                    runecraftingLvlValue = runecrafting.getString("level");
                    runecraftingXpValue = runecrafting.getString("xp");

                    // Getting the 'hunter' object from the JSON object
                    JSONObject hunter = jsonObj.getJSONObject("hunter");

                    //From the 'hunter' object, we want the below strings
                    //Assign all string and int to variables
                    hunterLvlValue = hunter.getString("level");
                    hunterXpValue = hunter.getString("xp");

                    // Getting the 'construction' object from the JSON object
                    JSONObject construction = jsonObj.getJSONObject("construction");

                    //From the 'construction' object, we want the below strings
                    //Assign all string and int to variables
                    constructionLvlValue = construction.getString("level");
                    constructionXpValue = construction.getString("xp");

                    //Catch any errors
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(overallRankValue != null) {

                //After we have obtained the JSON data
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

                if(skill.equals("attack")) {
                    num = attackXpValue;
                    currentLevel.setText(attackLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("defence")) {
                    num = defenceXpValue;
                    currentLevel.setText(defenceLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("strength")) {
                    num = strengthXpValue;
                    currentLevel.setText(strengthLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("hitpoints")) {
                    num = hitpointsXpValue;
                    currentLevel.setText(hitpointsLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("ranged")) {
                    num = rangedXpValue;
                    currentLevel.setText(rangedLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("prayer")) {
                    num = prayerXpValue;
                    currentLevel.setText(prayerLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("magic")) {
                    num = magicXpValue;
                    currentLevel.setText(magicLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("cooking")) {
                    num = cookingXpValue;
                    currentLevel.setText(cookingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("woodcutting")) {
                    num = woodcuttingXpValue;
                    currentLevel.setText(woodcuttingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("fletching")) {
                    num = fletchingXpValue;
                    currentLevel.setText(fletchingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("fishing")) {
                    num = fishingXpValue;
                    currentLevel.setText(fishingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("firemaking")) {
                    num = firemakingXpValue;
                    currentLevel.setText(firemakingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("crafting")) {
                    num = craftingXpValue;
                    currentLevel.setText(craftingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("smithing")) {
                    num = smithingXpValue;
                    currentLevel.setText(smithingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("mining")) {
                    num = miningXpValue;
                    currentLevel.setText(miningLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("herblore")) {
                    num = herbloreXpValue;
                    currentLevel.setText(herbloreLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("agility")) {
                    num = agilityXpValue;
                    currentLevel.setText(agilityLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("thieving")) {
                    num = thievingXpValue;
                    currentLevel.setText(thievingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("slayer")) {
                    num = slayerXpValue;
                    currentLevel.setText(slayerLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("farming")) {
                    num = farmingXpValue;
                    currentLevel.setText(farmingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("runecraft")) {
                    num = runecraftingXpValue;
                    currentLevel.setText(runecraftingLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("hunter")) {
                    num = hunterXpValue;
                    currentLevel.setText(hunterLvlValue);
                    calculateXP(num);
                }
                if(skill.equals("construction")) {
                    num = constructionXpValue;
                    currentLevel.setText(constructionLvlValue);
                    calculateXP(num);
                }
            } else {
                if (pDialog.isShowing())
                    pDialog.dismiss();
                Toast.makeText(getApplicationContext(), username + " was not found in the Overall table", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void calculateXP(String num){
        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        currentLvl = currentLevel.getText().toString();
        sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
        nextLvl = String.valueOf(sum);

        if(currentLevel.getText() != null) {
            switch (currentLvl) {
                case "15":
                    xpLeft = Integer.parseInt("2746") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "16":
                    xpLeft = Integer.parseInt("3115") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "17":
                    xpLeft = Integer.parseInt("3523") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "18":
                    xpLeft = Integer.parseInt("3973") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "19":
                    xpLeft = Integer.parseInt("4470") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "20":
                    xpLeft = Integer.parseInt("5018") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "21":
                    xpLeft = Integer.parseInt("5624") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "22":
                    xpLeft = Integer.parseInt("6291") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "23":
                    xpLeft = Integer.parseInt("7028") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "24":
                    xpLeft = Integer.parseInt("7842") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "25":
                    xpLeft = Integer.parseInt("8740") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "26":
                    xpLeft = Integer.parseInt("9730") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "27":
                    xpLeft = Integer.parseInt("10824") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "28":
                    xpLeft = Integer.parseInt("12031") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "29":
                    xpLeft = Integer.parseInt("13363") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "30":
                    xpLeft = Integer.parseInt("14833") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "31":
                    xpLeft = Integer.parseInt("16456") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "32":
                    xpLeft = Integer.parseInt("18247") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "33":
                    xpLeft = Integer.parseInt("20224") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "34":
                    xpLeft = Integer.parseInt("22406") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "35":
                    xpLeft = Integer.parseInt("24815") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "36":
                    xpLeft = Integer.parseInt("27473") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "37":
                    xpLeft = Integer.parseInt("30408") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "38":
                    xpLeft = Integer.parseInt("33648") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "39":
                    xpLeft = Integer.parseInt("37224") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "40":
                    xpLeft = Integer.parseInt("41171") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "41":
                    xpLeft = Integer.parseInt("45529") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "42":
                    xpLeft = Integer.parseInt("50339") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "43":
                    xpLeft = Integer.parseInt("55649") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "44":
                    xpLeft = Integer.parseInt("61512") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "45":
                    xpLeft = Integer.parseInt("67983") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "46":
                    xpLeft = Integer.parseInt("75127") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "47":
                    xpLeft = Integer.parseInt("83014") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "48":
                    xpLeft = Integer.parseInt("91721") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "49":
                    xpLeft = Integer.parseInt("101333") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "50":
                    xpLeft = Integer.parseInt("111945") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "51":
                    xpLeft = Integer.parseInt("123660") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "52":
                    xpLeft = Integer.parseInt("136594") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "53":
                    xpLeft = Integer.parseInt("150872") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "54":
                    xpLeft = Integer.parseInt("166636") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "55":
                    xpLeft = Integer.parseInt("184040") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "56":
                    xpLeft = Integer.parseInt("203254") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "57":
                    xpLeft = Integer.parseInt("224466") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "58":
                    xpLeft = Integer.parseInt("247886") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "59":
                    xpLeft = Integer.parseInt("273742") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "60":
                    xpLeft = Integer.parseInt("302288") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "61":
                    xpLeft = Integer.parseInt("333804") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "62":
                    xpLeft = Integer.parseInt("368599") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "63":
                    xpLeft = Integer.parseInt("407015") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "64":
                    xpLeft = Integer.parseInt("449428") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "65":
                    xpLeft = Integer.parseInt("496254") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "66":
                    xpLeft = Integer.parseInt("547953") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "67":
                    xpLeft = Integer.parseInt("605032") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "68":
                    xpLeft = Integer.parseInt("668051") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "69":
                    xpLeft = Integer.parseInt("737627") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "70":
                    xpLeft = Integer.parseInt("814445") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "71":
                    xpLeft = Integer.parseInt("899257") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "72":
                    xpLeft = Integer.parseInt("992895") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "73":
                    xpLeft = Integer.parseInt("1096278") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "74":
                    xpLeft = Integer.parseInt("1210421") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "75":
                    xpLeft = Integer.parseInt("1336443") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "76":
                    xpLeft = Integer.parseInt("1475581") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "77":
                    xpLeft = Integer.parseInt("1629200") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "78":
                    xpLeft = Integer.parseInt("1798808") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "79":
                    xpLeft = Integer.parseInt("1986068") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "80":
                    xpLeft = Integer.parseInt("2192818") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "81":
                    xpLeft = Integer.parseInt("2421087") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "82":
                    xpLeft = Integer.parseInt("2673114") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "83":
                    xpLeft = Integer.parseInt("2951373") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "84":
                    xpLeft = Integer.parseInt("3258594") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "85":
                    xpLeft = Integer.parseInt("3597792") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "86":
                    xpLeft = Integer.parseInt("3972294") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "87":
                    xpLeft = Integer.parseInt("4385776") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "88":
                    xpLeft = Integer.parseInt("4842295") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "89":
                    xpLeft = Integer.parseInt("5346332") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "90":
                    xpLeft = Integer.parseInt("5902831") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "91":
                    xpLeft = Integer.parseInt("6517253") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "92":
                    xpLeft = Integer.parseInt("7195629") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "93":
                    xpLeft = Integer.parseInt("7944614") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "94":
                    xpLeft = Integer.parseInt("8771558") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "95":
                    xpLeft = Integer.parseInt("9684577") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "96":
                    xpLeft = Integer.parseInt("10692629") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "97":
                    xpLeft = Integer.parseInt("11805606") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "98":
                    xpLeft = Integer.parseInt("13034431") - Integer.parseInt(num);
                    nextLevel.setText(nextLvl);
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                case "99":
                    xpLeft = Integer.parseInt("200000000") - Integer.parseInt(num);
                    nextLevel.setText("Max XP");
                    nextXP.setText(df.format(Long.valueOf(xpLeft)));
                    break;
                default:
                    nextLevel.setText("2");
                    nextXP.setText(df.format(Long.valueOf("83")));
                    break;
            }
        }
    }
}