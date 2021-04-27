package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Objects;

public class skillCalculatorDetailsScreen extends AppCompatActivity {

    ImageButton minus, plus;

    ImageView skillImage;

    TextView currentLevel, nextLevel, nextXP;

    View smithing, mining, firemaking;

    String username, skill, num, smelting,
            pyro,
            prospect, gatherer,
            artisan, wisdom,
            nextLvl, bar, stringValue,
            title, imageSrc, jsonURL,
            //hiscore strings
            currentLvl, overallRankValue, attackLvlValue, attackXpValue, defenceLvlValue,
            defenceXpValue, strengthLvlValue, strengthXpValue, hitpointsLvlValue,hitpointsXpValue,
            rangedLvlValue, rangedXpValue, prayerLvlValue, prayerXpValue, magicLvlValue,
            magicXpValue, cookingLvlValue, cookingXpValue, woodcuttingLvlValue, woodcuttingXpValue,
            fletchingLvlValue, fletchingXpValue, fishingLvlValue, fishingXpValue,
            firemakingLvlValue, firemakingXpValue, craftingLvlValue, craftingXpValue,
            smithingLvlValue, smithingXpValue, miningLvlValue, miningXpValue, herbloreLvlValue,
            herbloreXpValue, agilityLvlValue, agilityXpValue, thievingLvlValue, thievingXpValue,
            slayerLvlValue, slayerXpValue, farmingLvlValue, farmingXpValue, runecraftingLvlValue,
            runecraftingXpValue, hunterLvlValue, hunterXpValue, constructionLvlValue,
            constructionXpValue;

    int resImage, sum, xpLeft, num2;

    private ProgressDialog pDialog;

    private RelativeLayout layout;
    private LayoutInflater inflate;

    calculateXP calcXP = new calculateXP();

    barsSmithingCalculator barsSmithCalc = null;
    bronzeSmithingCalculator bronzeSmithCalc = null;
    ironSmithingCalculator ironSmithCalc = null;
    steelSmithingCalculator steelSmithCalc = null;
    mithSmithingCalculator mithSmithCalc = null;
    addySmithingCalculator addySmithCalc = null;
    runeSmithingCalculator runeSmithCalc = null;
    miningCalculator mineCalc = null;
    firemakingCalculator fireCalc = null;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skillcalculatordetailsscreen);

        inflate = LayoutInflater.from(getApplicationContext());
        layout = findViewById(R.id.calculatorItems);

        minus = findViewById(R.id.buttonMinus);
        plus = findViewById(R.id.buttonPlus);

        skillImage = findViewById(R.id.chatHead);

        currentLevel = findViewById(R.id.currentLevel);
        nextLevel = findViewById(R.id.nextLevel);
        nextXP = findViewById(R.id.nextXP);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        smelting = extras.getString("smelting");
        pyro = extras.getString("pyro");
        prospect = extras.getString("prospect");
        gatherer = extras.getString("gatherer");
        artisan = extras.getString("artisan");
        wisdom = extras.getString("wisdom");
        username = extras.getString("username");
        skill = extras.getString("skill");
        bar = extras.getString("bar");
        title = skill.substring(0, 1).toUpperCase() + skill.substring(1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        try {
            assert skill != null;
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

        @SuppressLint("InflateParams")
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(overallRankValue != null) {

                //After we have obtained the JSON data
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

                DecimalFormat df = new DecimalFormat();
                df.setGroupingUsed(true);
                df.setGroupingSize(3);

                if(skill.equals("attack")) {
                    num = attackXpValue;
                    num2 = Integer.parseInt(attackLvlValue);
                    currentLevel.setText(attackLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("defence")) {
                    num = defenceXpValue;
                    num2 = Integer.parseInt(defenceLvlValue);
                    currentLevel.setText(defenceLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("strength")) {
                    num = strengthXpValue;
                    num2 = Integer.parseInt(strengthLvlValue);
                    currentLevel.setText(strengthLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("hitpoints")) {
                    num = hitpointsXpValue;
                    num2 = Integer.parseInt(hitpointsLvlValue);
                    currentLevel.setText(hitpointsLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("ranged")) {
                    num = rangedXpValue;
                    num2 = Integer.parseInt(rangedLvlValue);
                    currentLevel.setText(rangedLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("prayer")) {
                    num = prayerXpValue;
                    num2 = Integer.parseInt(prayerLvlValue);
                    currentLevel.setText(prayerLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("magic")) {
                    num = magicXpValue;
                    num2 = Integer.parseInt(magicLvlValue);
                    currentLevel.setText(magicLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("cooking")) {
                    num = cookingXpValue;
                    num2 = Integer.parseInt(cookingLvlValue);
                    currentLevel.setText(cookingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("woodcutting")) {
                    num = woodcuttingXpValue;
                    num2 = Integer.parseInt(woodcuttingLvlValue);
                    currentLevel.setText(woodcuttingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("fletching")) {
                    num = fletchingXpValue;
                    num2 = Integer.parseInt(fletchingLvlValue);
                    currentLevel.setText(fletchingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("fishing")) {
                    num = fishingXpValue;
                    num2 = Integer.parseInt(fishingLvlValue);
                    currentLevel.setText(fishingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("firemaking")) {
                    firemaking = inflate.inflate(R.layout.firemakingcalculator , null, false);
                    RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT);
                    firemaking.setLayoutParams(imageViewParam);
                    layout.addView(firemaking);
                    num = firemakingXpValue;
                    num2 = Integer.parseInt(firemakingLvlValue);
                    currentLevel.setText(firemakingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                    fireCalc = new firemakingCalculator();
                    fireCalc.calculate(num2, xpLeft, firemaking, pyro, gatherer, wisdom);
                }
                if(skill.equals("crafting")) {
                    num = craftingXpValue;
                    num2 = Integer.parseInt(craftingLvlValue);
                    currentLevel.setText(craftingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("smithing")) {
                    num = smithingXpValue;
                    num2 = Integer.parseInt(smithingLvlValue);
                    currentLevel.setText(smithingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                    if (bar.equals("smelting")) {
                        smithing = inflate.inflate(R.layout.barssmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        barsSmithCalc = new barsSmithingCalculator();
                        barsSmithCalc.calculate(num2, xpLeft, smithing, artisan, wisdom);
                    }
                    if (bar.equals("bronze")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.bronze_title);
                        smithing = inflate.inflate(R.layout.bronzesmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        bronzeSmithCalc = new bronzeSmithingCalculator();
                        bronzeSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                    if (bar.equals("iron")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.iron_title);
                        smithing = inflate.inflate(R.layout.ironsmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        ironSmithCalc = new ironSmithingCalculator();
                        ironSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                    if (bar.equals("steel")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.steel_title);
                        smithing = inflate.inflate(R.layout.steelsmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        steelSmithCalc = new steelSmithingCalculator();
                        steelSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                    if (bar.equals("mithril")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.mith_title);
                        smithing = inflate.inflate(R.layout.mithsmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        mithSmithCalc = new mithSmithingCalculator();
                        mithSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                    if (bar.equals("adamant")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.addy_title);
                        smithing = inflate.inflate(R.layout.addysmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        addySmithCalc = new addySmithingCalculator();
                        addySmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                    if (bar.equals("rune")) {
                        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.rune_title);
                        smithing = inflate.inflate(R.layout.runesmithingcalculator, null, false);
                        RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                                RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.MATCH_PARENT);
                        smithing.setLayoutParams(imageViewParam);
                        layout.addView(smithing);
                        runeSmithCalc = new runeSmithingCalculator();
                        runeSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
                    }
                }
                if(skill.equals("mining")) {
                    mining = inflate.inflate(R.layout.miningcalculator , null, false);
                    RelativeLayout.LayoutParams imageViewParam = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT);
                    mining.setLayoutParams(imageViewParam);
                    layout.addView(mining);
                    num = miningXpValue;
                    num2 = Integer.parseInt(miningLvlValue);
                    currentLevel.setText(miningLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                    mineCalc = new miningCalculator();
                    mineCalc.calculate(num2, xpLeft, mining, prospect, gatherer, wisdom);
                }
                if(skill.equals("herblore")) {
                    num = herbloreXpValue;
                    num2 = Integer.parseInt(herbloreLvlValue);
                    currentLevel.setText(herbloreLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("agility")) {
                    num = agilityXpValue;
                    num2 = Integer.parseInt(agilityLvlValue);
                    currentLevel.setText(agilityLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("thieving")) {
                    num = thievingXpValue;
                    num2 = Integer.parseInt(thievingLvlValue);
                    currentLevel.setText(thievingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("slayer")) {
                    num = slayerXpValue;
                    num2 = Integer.parseInt(slayerLvlValue);
                    currentLevel.setText(slayerLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("farming")) {
                    num = farmingXpValue;
                    num2 = Integer.parseInt(farmingLvlValue);
                    currentLevel.setText(farmingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("runecraft")) {
                    num = runecraftingXpValue;
                    num2 = Integer.parseInt(runecraftingLvlValue);
                    currentLevel.setText(runecraftingLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("hunter")) {
                    num = hunterXpValue;
                    num2 = Integer.parseInt(hunterLvlValue);
                    currentLevel.setText(hunterLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
                if(skill.equals("construction")) {
                    num = constructionXpValue;
                    num2 = Integer.parseInt(constructionLvlValue);
                    currentLevel.setText(constructionLvlValue);
                    currentLvl = currentLevel.getText().toString();
                    sum = Integer.parseInt(currentLvl) + Integer.parseInt("1");
                    nextLvl = String.valueOf(sum);
                    if (sum == 2) {
                        minus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(nextLvl);
                    } else if (sum == 100) {
                        plus.setVisibility(View.INVISIBLE);
                        nextLevel.setText(R.string.text_max);
                    } else {
                        nextLevel.setText(nextLvl);
                    }
                    calcXP.calculate(num, nextLevel);
                    xpLeft = calculateXP.xpLeft;
                    nextXP.setText(df.format(xpLeft));
                }
            } else {
                if (pDialog.isShowing())
                    pDialog.dismiss();
                Toast.makeText(getApplicationContext(), username + " was not found in the Overall table", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public void minusLevel(View view) {
        sum--;
        stringValue = Integer.toString(sum);

        if (Integer.parseInt(stringValue) == 1) {
            minus.setVisibility(View.INVISIBLE);
        } else {
            if (Integer.parseInt(stringValue) == 99) {
                plus.setVisibility(View.VISIBLE);
            }
            nextLevel.setText(stringValue);
        }
    }
    
    public void plusLevel(View view) {
        sum++;
        stringValue = Integer.toString(sum);

        if (Integer.parseInt(stringValue) > 99) {
            plus.setVisibility(View.INVISIBLE);
            nextLevel.setText(R.string.text_max);
        } else {
            if (Integer.parseInt(stringValue) == 2) {
                minus.setVisibility(View.VISIBLE);
            }
            nextLevel.setText(stringValue);
        }
    }

    public void update(View view) {

        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        calcXP.calculate(num, nextLevel);
        xpLeft = calculateXP.xpLeft;
        nextXP.setText(df.format(xpLeft));

        if(skill.equals("smithing")) {
            if (bar.equals("smelting")) {
                barsSmithCalc.calculate(num2, xpLeft, smithing, artisan, wisdom);
            }
            if (bar.equals("bronze")) {
                bronzeSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
            if (bar.equals("iron")) {
                ironSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
            if (bar.equals("steel")) {
                steelSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
            if (bar.equals("mithril")) {
                mithSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
            if (bar.equals("adamant")) {
                addySmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
            if (bar.equals("rune")) {
                runeSmithCalc.calculate(num2, xpLeft, smithing, smelting, artisan, wisdom);
            }
        }
        if(skill.equals("mining")) {
            mineCalc.calculate(num2, xpLeft, mining, prospect, gatherer, wisdom);
        }
        if(skill.equals("firemaking")) {
            fireCalc.calculate(num2, xpLeft, firemaking, pyro, gatherer, wisdom);
        }
    }

    public void onBackPressed() {
    }
}