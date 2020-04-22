package com.ahdesigns.osrsbuddy;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Objects;

public class statDetailsScreen extends AppCompatActivity {

    TableRow overall,
            attack, defence, strength,
            hitpoints, ranged, prayer,
            magic, cooking, woodcutting,
            fletching, fishing, firemaking,
            crafting, smithing, mining,
            herblore, agility, thieving,
            slayer, farming, runecraft,
            hunter, construction;

    TextView overallrank, overalllvl, overallxp,
            attackrank, attacklvl, attackxp,
            defencerank, defencelvl, defencexp,
            strengthrank, strengthlvl, strengthxp,
            hitpointsrank, hitpointslvl, hitpointsxp,
            rangedrank, rangedlvl, rangedxp,
            prayerrank, prayerlvl, prayerxp,
            magicrank, magiclvl, magicxp,
            cookingrank, cookinglvl, cookingxp,
            woodcuttingrank, woodcuttinglvl, woodcuttingxp,
            fletchingrank, fletchinglvl, fletchingxp,
            fishingrank, fishinglvl, fishingxp,
            firemakingrank, firemakinglvl, firemakingxp,
            craftingrank, craftinglvl, craftingxp,
            smithingrank, smithinglvl, smithingxp,
            miningrank, mininglvl, miningxp,
            herblorerank, herblorelvl, herblorexp,
            agilityrank, agilitylvl, agilityxp,
            thievingrank, thievinglvl, thievingxp,
            slayerrank, slayerlvl, slayerxp,
            farmingrank, farminglvl, farmingxp,
            runecraftingrank, runecraftinglvl, runecraftingxp,
            hunterrank, hunterlvl, hunterxp,
            constructionrank, constructionlvl, constructionxp;

    String jsonURL, username,
            overallRankValue, overallLvlValue, overallXpValue,
            attackRankValue, attackLvlValue, attackXpValue,
            defenceRankValue, defenceLvlValue, defenceXpValue,
            strengthRankValue, strengthLvlValue, strengthXpValue,
            hitpointsRankValue, hitpointsLvlValue, hitpointsXpValue,
            rangedRankValue, rangedLvlValue, rangedXpValue,
            prayerRankValue, prayerLvlValue, prayerXpValue,
            magicRankValue, magicLvlValue, magicXpValue,
            cookingRankValue, cookingLvlValue, cookingXpValue,
            woodcuttingRankValue, woodcuttingLvlValue, woodcuttingXpValue,
            fletchingRankValue, fletchingLvlValue, fletchingXpValue,
            fishingRankValue, fishingLvlValue, fishingXpValue,
            firemakingRankValue, firemakingLvlValue, firemakingXpValue,
            craftingRankValue, craftingLvlValue, craftingXpValue,
            smithingRankValue, smithingLvlValue, smithingXpValue,
            miningRankValue, miningLvlValue, miningXpValue,
            herbloreRankValue, herbloreLvlValue, herbloreXpValue,
            agilityRankValue, agilityLvlValue, agilityXpValue,
            thievingRankValue, thievingLvlValue, thievingXpValue,
            slayerRankValue, slayerLvlValue, slayerXpValue,
            farmingRankValue, farmingLvlValue, farmingXpValue,
            runecraftingRankValue, runecraftingLvlValue, runecraftingXpValue,
            hunterRankValue, hunterLvlValue, hunterXpValue,
            constructionRankValue, constructionLvlValue, constructionXpValue;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statdetailsscreen);

        overall = findViewById(R.id.overall);
        attack = findViewById(R.id.attack);
        defence = findViewById(R.id.defence);
        strength = findViewById(R.id.strength);
        hitpoints = findViewById(R.id.hitpoints);
        ranged = findViewById(R.id.ranged);
        prayer = findViewById(R.id.prayer);
        magic = findViewById(R.id.magic);
        cooking = findViewById(R.id.cooking);
        woodcutting = findViewById(R.id.woodcutting);
        fletching = findViewById(R.id.fletching);
        fishing = findViewById(R.id.fishing);
        firemaking = findViewById(R.id.firemaking);
        crafting = findViewById(R.id.crafting);
        smithing = findViewById(R.id.smithing);
        mining = findViewById(R.id.mining);
        herblore = findViewById(R.id.herblore);
        agility = findViewById(R.id.agility);
        thieving = findViewById(R.id.thieving);
        slayer = findViewById(R.id.slayer);
        farming = findViewById(R.id.farming);
        runecraft = findViewById(R.id.runecraft);
        hunter = findViewById(R.id.hunter);
        construction = findViewById(R.id.construction);

        overallrank = findViewById(R.id.overallrank);
        overalllvl = findViewById(R.id.overalllvl);
        overallxp = findViewById(R.id.overallxp);
        attackrank = findViewById(R.id.attackrank);
        attacklvl = findViewById(R.id.attacklvl);
        attackxp = findViewById(R.id.attackxp);
        defencerank = findViewById(R.id.defencerank);
        defencelvl = findViewById(R.id.defencelvl);
        defencexp = findViewById(R.id.defencexp);
        strengthrank = findViewById(R.id.strengthrank);
        strengthlvl = findViewById(R.id.strengthlvl);
        strengthxp = findViewById(R.id.strengthxp);
        hitpointsrank = findViewById(R.id.hitpointsrank);
        hitpointslvl = findViewById(R.id.hitpointslvl);
        hitpointsxp = findViewById(R.id.hitpointsxp);
        rangedrank = findViewById(R.id.rangedrank);
        rangedlvl = findViewById(R.id.rangedlvl);
        rangedxp = findViewById(R.id.rangedxp);
        prayerrank = findViewById(R.id.prayerrank);
        prayerlvl = findViewById(R.id.prayerlvl);
        prayerxp = findViewById(R.id.prayerxp);
        magicrank = findViewById(R.id.magicrank);
        magiclvl = findViewById(R.id.magiclvl);
        magicxp = findViewById(R.id.magicxp);
        cookingrank = findViewById(R.id.cookingrank);
        cookinglvl = findViewById(R.id.cookinglvl);
        cookingxp = findViewById(R.id.cookingxp);
        woodcuttingrank = findViewById(R.id.woodcuttingrank);
        woodcuttinglvl = findViewById(R.id.woodcuttinglvl);
        woodcuttingxp = findViewById(R.id.woodcuttingxp);
        fletchingrank = findViewById(R.id.fletchingrank);
        fletchinglvl = findViewById(R.id.fletchinglvl);
        fletchingxp = findViewById(R.id.fletchingxp);
        fishingrank = findViewById(R.id.fishingrank);
        fishinglvl = findViewById(R.id.fishinglvl);
        fishingxp = findViewById(R.id.fishingxp);
        firemakingrank = findViewById(R.id.firemakingrank);
        firemakinglvl = findViewById(R.id.firemakinglvl);
        firemakingxp = findViewById(R.id.firemakingxp);
        craftingrank = findViewById(R.id.craftingrank);
        craftinglvl = findViewById(R.id.craftinglvl);
        craftingxp = findViewById(R.id.craftingxp);
        smithingrank = findViewById(R.id.smithingrank);
        smithinglvl = findViewById(R.id.smithinglvl);
        smithingxp = findViewById(R.id.smithingxp);
        miningrank = findViewById(R.id.miningrank);
        mininglvl = findViewById(R.id.mininglvl);
        miningxp = findViewById(R.id.miningxp);
        herblorerank = findViewById(R.id.herblorerank);
        herblorelvl = findViewById(R.id.herblorelvl);
        herblorexp = findViewById(R.id.herblorexp);
        agilityrank = findViewById(R.id.agilityrank);
        agilitylvl = findViewById(R.id.agilitylvl);
        agilityxp = findViewById(R.id.agilityxp);
        thievingrank = findViewById(R.id.thievingrank);
        thievinglvl = findViewById(R.id.thievinglvl);
        thievingxp = findViewById(R.id.thievingxp);
        slayerrank = findViewById(R.id.slayerrank);
        slayerlvl = findViewById(R.id.slayerlvl);
        slayerxp = findViewById(R.id.slayerxp);
        farmingrank = findViewById(R.id.farmingrank);
        farminglvl = findViewById(R.id.farminglvl);
        farmingxp = findViewById(R.id.farmingxp);
        runecraftingrank = findViewById(R.id.runecraftrank);
        runecraftinglvl = findViewById(R.id.runecraftlvl);
        runecraftingxp = findViewById(R.id.runecraftxp);
        hunterrank = findViewById(R.id.hunterrank);
        hunterlvl = findViewById(R.id.hunterlvl);
        hunterxp = findViewById(R.id.hunterxp);
        constructionrank = findViewById(R.id.constructionrank);
        constructionlvl = findViewById(R.id.constructionlvl);
        constructionxp = findViewById(R.id.constructionxp);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        username = extras.getString("username");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(username);

        // URL to get JSON
        try {
            jsonURL = "http://ahdesigns.coolpage.biz/old_hiscores.php?user=" + URLEncoder.encode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //Call the getdata class
        new GetData().execute();
    }

    //Get data class to get json data
    private class GetData extends AsyncTask<Void, Void, Void> {

        //Before data will be looked up
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Showing progress dialog
            pDialog = new ProgressDialog(statDetailsScreen.this);
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
                    overallLvlValue = overall.getString("level");
                    overallXpValue = overall.getString("xp");


                    // Getting the 'attack' object from the JSON object
                    JSONObject attack = jsonObj.getJSONObject("attack");

                    //From the 'attack' object, we want the below strings
                    //Assign all string and int to variables
                    attackRankValue = attack.getString("rank");
                    attackLvlValue = attack.getString("level");
                    attackXpValue = attack.getString("xp");

                    // Getting the 'defence' object from the JSON object
                    JSONObject defence = jsonObj.getJSONObject("defence");

                    //From the 'defence' object, we want the below strings
                    //Assign all string and int to variables
                    defenceRankValue = defence.getString("rank");
                    defenceLvlValue = defence.getString("level");
                    defenceXpValue = defence.getString("xp");

                    // Getting the 'strength' object from the JSON object
                    JSONObject strength = jsonObj.getJSONObject("strength");

                    //From the 'strength' object, we want the below strings
                    //Assign all string and int to variables
                    strengthRankValue = strength.getString("rank");
                    strengthLvlValue = strength.getString("level");
                    strengthXpValue = strength.getString("xp");

                    // Getting the 'constitution' object from the JSON object
                    JSONObject hitpoints = jsonObj.getJSONObject("hitpoints");

                    //From the 'constitution' object, we want the below strings
                    //Assign all string and int to variables
                    hitpointsRankValue = hitpoints.getString("rank");
                    hitpointsLvlValue = hitpoints.getString("level");
                    hitpointsXpValue = hitpoints.getString("xp");

                    // Getting the 'ranged' object from the JSON object
                    JSONObject ranged = jsonObj.getJSONObject("ranged");

                    //From the 'ranged' object, we want the below strings
                    //Assign all string and int to variables
                    rangedRankValue = ranged.getString("rank");
                    rangedLvlValue = ranged.getString("level");
                    rangedXpValue = ranged.getString("xp");

                    // Getting the 'prayer' object from the JSON object
                    JSONObject prayer = jsonObj.getJSONObject("prayer");

                    //From the 'prayer' object, we want the below strings
                    //Assign all string and int to variables
                    prayerRankValue = prayer.getString("rank");
                    prayerLvlValue = prayer.getString("level");
                    prayerXpValue = prayer.getString("xp");

                    // Getting the 'magic' object from the JSON object
                    JSONObject magic = jsonObj.getJSONObject("magic");

                    //From the 'magic' object, we want the below strings
                    //Assign all string and int to variables
                    magicRankValue = magic.getString("rank");
                    magicLvlValue = magic.getString("level");
                    magicXpValue = magic.getString("xp");

                    // Getting the 'cooking' object from the JSON object
                    JSONObject cooking = jsonObj.getJSONObject("cooking");

                    //From the 'cooking' object, we want the below strings
                    //Assign all string and int to variables
                    cookingRankValue = cooking.getString("rank");
                    cookingLvlValue = cooking.getString("level");
                    cookingXpValue = cooking.getString("xp");

                    // Getting the 'woodcutting' object from the JSON object
                    JSONObject woodcutting = jsonObj.getJSONObject("woodcutting");

                    //From the 'woodcutting' object, we want the below strings
                    //Assign all string and int to variables
                    woodcuttingRankValue = woodcutting.getString("rank");
                    woodcuttingLvlValue = woodcutting.getString("level");
                    woodcuttingXpValue = woodcutting.getString("xp");

                    // Getting the 'fletching' object from the JSON object
                    JSONObject fletching = jsonObj.getJSONObject("fletching");

                    //From the 'fletching' object, we want the below strings
                    //Assign all string and int to variables
                    fletchingRankValue = fletching.getString("rank");
                    fletchingLvlValue = fletching.getString("level");
                    fletchingXpValue = fletching.getString("xp");

                    // Getting the 'fishing' object from the JSON object
                    JSONObject fishing = jsonObj.getJSONObject("fishing");

                    //From the 'fishing' object, we want the below strings
                    //Assign all string and int to variables
                    fishingRankValue = fishing.getString("rank");
                    fishingLvlValue = fishing.getString("level");
                    fishingXpValue = fishing.getString("xp");

                    // Getting the 'firemaking' object from the JSON object
                    JSONObject firemaking = jsonObj.getJSONObject("firemaking");

                    //From the 'firemaking' object, we want the below strings
                    //Assign all string and int to variables
                    firemakingRankValue = firemaking.getString("rank");
                    firemakingLvlValue = firemaking.getString("level");
                    firemakingXpValue = firemaking.getString("xp");

                    // Getting the 'crafting' object from the JSON object
                    JSONObject crafting = jsonObj.getJSONObject("crafting");

                    //From the 'crafting' object, we want the below strings
                    //Assign all string and int to variables
                    craftingRankValue = crafting.getString("rank");
                    craftingLvlValue = crafting.getString("level");
                    craftingXpValue = crafting.getString("xp");

                    // Getting the 'smithing' object from the JSON object
                    JSONObject smithing = jsonObj.getJSONObject("smithing");

                    //From the 'smithing' object, we want the below strings
                    //Assign all string and int to variables
                    smithingRankValue = smithing.getString("rank");
                    smithingLvlValue = smithing.getString("level");
                    smithingXpValue = smithing.getString("xp");

                    // Getting the 'mining' object from the JSON object
                    JSONObject mining = jsonObj.getJSONObject("mining");

                    //From the 'mining' object, we want the below strings
                    //Assign all string and int to variables
                    miningRankValue = mining.getString("rank");
                    miningLvlValue = mining.getString("level");
                    miningXpValue = mining.getString("xp");

                    // Getting the 'herblore' object from the JSON object
                    JSONObject herblore = jsonObj.getJSONObject("herblore");

                    //From the 'herblore' object, we want the below strings
                    //Assign all string and int to variables
                    herbloreRankValue = herblore.getString("rank");
                    herbloreLvlValue = herblore.getString("level");
                    herbloreXpValue = herblore.getString("xp");

                    // Getting the 'agility' object from the JSON object
                    JSONObject agility = jsonObj.getJSONObject("agility");

                    //From the 'agility' object, we want the below strings
                    //Assign all string and int to variables
                    agilityRankValue = agility.getString("rank");
                    agilityLvlValue = agility.getString("level");
                    agilityXpValue = agility.getString("xp");

                    // Getting the 'thieving' object from the JSON object
                    JSONObject thieving = jsonObj.getJSONObject("thieving");

                    //From the 'thieving' object, we want the below strings
                    //Assign all string and int to variables
                    thievingRankValue = thieving.getString("rank");
                    thievingLvlValue = thieving.getString("level");
                    thievingXpValue = thieving.getString("xp");

                    // Getting the 'slayer' object from the JSON object
                    JSONObject slayer = jsonObj.getJSONObject("slayer");

                    //From the 'slayer' object, we want the below strings
                    //Assign all string and int to variables
                    slayerRankValue = slayer.getString("rank");
                    slayerLvlValue = slayer.getString("level");
                    slayerXpValue = slayer.getString("xp");

                    // Getting the 'farming' object from the JSON object
                    JSONObject farming = jsonObj.getJSONObject("farming");

                    //From the 'farming' object, we want the below strings
                    //Assign all string and int to variables
                    farmingRankValue = farming.getString("rank");
                    farmingLvlValue = farming.getString("level");
                    farmingXpValue = farming.getString("xp");

                    // Getting the 'runecrafting' object from the JSON object
                    JSONObject runecrafting = jsonObj.getJSONObject("runecrafting");

                    //From the 'runecrafting' object, we want the below strings
                    //Assign all string and int to variables
                    runecraftingRankValue = runecrafting.getString("rank");
                    runecraftingLvlValue = runecrafting.getString("level");
                    runecraftingXpValue = runecrafting.getString("xp");

                    // Getting the 'hunter' object from the JSON object
                    JSONObject hunter = jsonObj.getJSONObject("hunter");

                    //From the 'hunter' object, we want the below strings
                    //Assign all string and int to variables
                    hunterRankValue = hunter.getString("rank");
                    hunterLvlValue = hunter.getString("level");
                    hunterXpValue = hunter.getString("xp");

                    // Getting the 'construction' object from the JSON object
                    JSONObject construction = jsonObj.getJSONObject("construction");

                    //From the 'construction' object, we want the below strings
                    //Assign all string and int to variables
                    constructionRankValue = construction.getString("rank");
                    constructionLvlValue = construction.getString("level");
                    constructionXpValue = construction.getString("xp");

                    //Catch any errors
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(overallRankValue != null) {

                DecimalFormat df = new DecimalFormat();
                df.setGroupingUsed(true);
                df.setGroupingSize(3);

                //After we have obtained the JSON data
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

                //Updating textviews with hiscore values.
                if (overallRankValue.trim().length() == 0) {
                    overall.setVisibility(View.GONE);
                } else {
                    overallrank.setText(df.format(Long.valueOf(overallRankValue)));
                    overalllvl.setText(df.format(Long.valueOf(overallLvlValue)));
                    overallxp.setText(df.format(Long.valueOf(overallXpValue)));
                }
                if (attackRankValue.trim().length() == 0) {
                    attack.setVisibility(View.GONE);
                } else {
                    attackrank.setText(df.format(Long.valueOf(attackRankValue)));
                    attacklvl.setText(df.format(Long.valueOf(attackLvlValue)));
                    attackxp.setText(df.format(Long.valueOf(attackXpValue)));
                }
                if (defenceRankValue.trim().length() == 0) {
                    defence.setVisibility(View.GONE);
                } else {
                    defencerank.setText(df.format(Long.valueOf(defenceRankValue)));
                    defencelvl.setText(df.format(Long.valueOf(defenceLvlValue)));
                    defencexp.setText(df.format(Long.valueOf(defenceXpValue)));
                }
                if (strengthRankValue.trim().length() == 0) {
                    strength.setVisibility(View.GONE);
                } else {
                    strengthrank.setText(df.format(Long.valueOf(strengthRankValue)));
                    strengthlvl.setText(df.format(Long.valueOf(strengthLvlValue)));
                    strengthxp.setText(df.format(Long.valueOf(strengthXpValue)));
                }
                if (hitpointsRankValue.trim().length() == 0) {
                    hitpoints.setVisibility(View.GONE);
                } else {
                    hitpointsrank.setText(df.format(Long.valueOf(hitpointsRankValue)));
                    hitpointslvl.setText(df.format(Long.valueOf(hitpointsLvlValue)));
                    hitpointsxp.setText(df.format(Long.valueOf(hitpointsXpValue)));
                }
                if (rangedRankValue.trim().length() == 0) {
                    ranged.setVisibility(View.GONE);
                } else {
                    rangedrank.setText(df.format(Long.valueOf(rangedRankValue)));
                    rangedlvl.setText(df.format(Long.valueOf(rangedLvlValue)));
                    rangedxp.setText(df.format(Long.valueOf(rangedXpValue)));
                }
                if (prayerRankValue.trim().length() == 0) {
                    prayer.setVisibility(View.GONE);
                } else {
                    prayerrank.setText(df.format(Long.valueOf(prayerRankValue)));
                    prayerlvl.setText(df.format(Long.valueOf(prayerLvlValue)));
                    prayerxp.setText(df.format(Long.valueOf(prayerXpValue)));
                }
                if (magicRankValue.trim().length() == 0) {
                    magic.setVisibility(View.GONE);
                } else {
                    magicrank.setText(df.format(Long.valueOf(magicRankValue)));
                    magiclvl.setText(df.format(Long.valueOf(magicLvlValue)));
                    magicxp.setText(df.format(Long.valueOf(magicXpValue)));
                }
                if (cookingRankValue.trim().length() == 0) {
                    cooking.setVisibility(View.GONE);
                } else {
                    cookingrank.setText(df.format(Long.valueOf(cookingRankValue)));
                    cookinglvl.setText(df.format(Long.valueOf(cookingLvlValue)));
                    cookingxp.setText(df.format(Long.valueOf(cookingXpValue)));
                }
                if (woodcuttingRankValue.trim().length() == 0) {
                    woodcutting.setVisibility(View.GONE);
                } else {
                    woodcuttingrank.setText(df.format(Long.valueOf(woodcuttingRankValue)));
                    woodcuttinglvl.setText(df.format(Long.valueOf(woodcuttingLvlValue)));
                    woodcuttingxp.setText(df.format(Long.valueOf(woodcuttingXpValue)));
                }
                if (fletchingRankValue.trim().length() == 0) {
                    fletching.setVisibility(View.GONE);
                } else {
                    fletchingrank.setText(df.format(Long.valueOf(fletchingRankValue)));
                    fletchinglvl.setText(df.format(Long.valueOf(fletchingLvlValue)));
                    fletchingxp.setText(df.format(Long.valueOf(fletchingXpValue)));
                }
                if (fishingRankValue.trim().length() == 0) {
                    fishing.setVisibility(View.GONE);
                } else {
                    fishingrank.setText(df.format(Long.valueOf(fishingRankValue)));
                    fishinglvl.setText(df.format(Long.valueOf(fishingLvlValue)));
                    fishingxp.setText(df.format(Long.valueOf(fishingXpValue)));
                }
                if (firemakingRankValue.trim().length() == 0) {
                    firemaking.setVisibility(View.GONE);
                } else {
                    firemakingrank.setText(df.format(Long.valueOf(firemakingRankValue)));
                    firemakinglvl.setText(df.format(Long.valueOf(firemakingLvlValue)));
                    firemakingxp.setText(df.format(Long.valueOf(firemakingXpValue)));
                }
                if (craftingRankValue.trim().length() == 0) {
                    crafting.setVisibility(View.GONE);
                } else {
                    craftingrank.setText(df.format(Long.valueOf(craftingRankValue)));
                    craftinglvl.setText(df.format(Long.valueOf(craftingLvlValue)));
                    craftingxp.setText(df.format(Long.valueOf(craftingXpValue)));
                }
                if (smithingRankValue.trim().length() == 0) {
                    smithing.setVisibility(View.GONE);
                } else {
                    smithingrank.setText(df.format(Long.valueOf(smithingRankValue)));
                    smithinglvl.setText(df.format(Long.valueOf(smithingLvlValue)));
                    smithingxp.setText(df.format(Long.valueOf(smithingXpValue)));
                }
                if (miningRankValue.trim().length() == 0) {
                    mining.setVisibility(View.GONE);
                }  else {
                    miningrank.setText(df.format(Long.valueOf(miningRankValue)));
                    mininglvl.setText(df.format(Long.valueOf(miningLvlValue)));
                    miningxp.setText(df.format(Long.valueOf(miningXpValue)));
                }
                if (herbloreRankValue.trim().length() == 0) {
                    herblore.setVisibility(View.GONE);
                } else {
                    herblorerank.setText(df.format(Long.valueOf(herbloreRankValue)));
                    herblorelvl.setText(df.format(Long.valueOf(herbloreLvlValue)));
                    herblorexp.setText(df.format(Long.valueOf(herbloreXpValue)));
                }
                if (agilityRankValue.trim().length() == 0) {
                    agility.setVisibility(View.GONE);
                } else {
                    agilityrank.setText(df.format(Long.valueOf(agilityRankValue)));
                    agilitylvl.setText(df.format(Long.valueOf(agilityLvlValue)));
                    agilityxp.setText(df.format(Long.valueOf(agilityXpValue)));
                }
                if (thievingRankValue.trim().length() == 0) {
                    thieving.setVisibility(View.GONE);
                } else {
                    thievingrank.setText(df.format(Long.valueOf(thievingRankValue)));
                    thievinglvl.setText(df.format(Long.valueOf(thievingLvlValue)));
                    thievingxp.setText(df.format(Long.valueOf(thievingXpValue)));
                }
                if (slayerRankValue.trim().length() == 0) {
                    slayer.setVisibility(View.GONE);
                } else {
                    slayerrank.setText(df.format(Long.valueOf(slayerRankValue)));
                    slayerlvl.setText(df.format(Long.valueOf(slayerLvlValue)));
                    slayerxp.setText(df.format(Long.valueOf(slayerXpValue)));
                }
                if (farmingRankValue.trim().length() == 0) {
                    farming.setVisibility(View.GONE);
                } else {
                    farmingrank.setText(df.format(Long.valueOf(farmingRankValue)));
                    farminglvl.setText(df.format(Long.valueOf(farmingLvlValue)));
                    farmingxp.setText(df.format(Long.valueOf(farmingXpValue)));
                }
                if (runecraftingRankValue.trim().length() == 0) {
                    runecraft.setVisibility(View.GONE);
                } else {
                    runecraftingrank.setText(df.format(Long.valueOf(runecraftingRankValue)));
                    runecraftinglvl.setText(df.format(Long.valueOf(runecraftingLvlValue)));
                    runecraftingxp.setText(df.format(Long.valueOf(runecraftingXpValue)));
                }
                if (hunterRankValue.trim().length() == 0) {
                    hunter.setVisibility(View.GONE);
                } else {
                    hunterrank.setText(df.format(Long.valueOf(hunterRankValue)));
                    hunterlvl.setText(df.format(Long.valueOf(hunterLvlValue)));
                    hunterxp.setText(df.format(Long.valueOf(hunterXpValue)));
                }
                if (constructionRankValue.trim().length() == 0) {
                    construction.setVisibility(View.GONE);
                } else {
                    constructionrank.setText(df.format(Long.valueOf(constructionRankValue)));
                    constructionlvl.setText(df.format(Long.valueOf(constructionLvlValue)));
                    constructionxp.setText(df.format(Long.valueOf(constructionXpValue)));
                }

            } else {
                if (pDialog.isShowing())
                    pDialog.dismiss();
                Toast.makeText(getApplicationContext(), username + " was not found in the Overall table", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public void onBackPressed() {
    }
}