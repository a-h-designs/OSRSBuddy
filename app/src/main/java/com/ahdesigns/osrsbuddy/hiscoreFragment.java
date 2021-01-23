package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Objects;

import static java.lang.Math.floor;

public class hiscoreFragment extends Fragment {

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
            constructionrank, constructionlvl, constructionxp,
            combat, style;

    String jsonURL, username, url,
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

    ImageView chatHead;

    double warrior, ranger, mager, baseCombatLevel, warriorCombatLevel, rangeCombatLevel, mageCombatLevel,
            prayer, range, magic;

    private ProgressDialog pDialog;

    public hiscoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hiscorefragment, container, false);

        chatHead = getActivity().findViewById(R.id.chatHead);
        combat = getActivity().findViewById(R.id.combat);
        style = getActivity().findViewById(R.id.style);

        overallrank = view.findViewById(R.id.overallrank);
        overalllvl = view.findViewById(R.id.overalllvl);
        overallxp = view.findViewById(R.id.overallxp);
        attackrank = view.findViewById(R.id.attackrank);
        attacklvl = view.findViewById(R.id.attacklvl);
        attackxp = view.findViewById(R.id.attackxp);
        defencerank = view.findViewById(R.id.defencerank);
        defencelvl = view.findViewById(R.id.defencelvl);
        defencexp = view.findViewById(R.id.defencexp);
        strengthrank = view.findViewById(R.id.strengthrank);
        strengthlvl = view.findViewById(R.id.strengthlvl);
        strengthxp = view.findViewById(R.id.strengthxp);
        hitpointsrank = view.findViewById(R.id.hitpointsrank);
        hitpointslvl = view.findViewById(R.id.hitpointslvl);
        hitpointsxp = view.findViewById(R.id.hitpointsxp);
        rangedrank = view.findViewById(R.id.rangedrank);
        rangedlvl = view.findViewById(R.id.rangedlvl);
        rangedxp = view.findViewById(R.id.rangedxp);
        prayerrank = view.findViewById(R.id.prayerrank);
        prayerlvl = view.findViewById(R.id.prayerlvl);
        prayerxp = view.findViewById(R.id.prayerxp);
        magicrank = view.findViewById(R.id.magicrank);
        magiclvl = view.findViewById(R.id.magiclvl);
        magicxp = view.findViewById(R.id.magicxp);
        cookingrank = view.findViewById(R.id.cookingrank);
        cookinglvl = view.findViewById(R.id.cookinglvl);
        cookingxp = view.findViewById(R.id.cookingxp);
        woodcuttingrank = view.findViewById(R.id.woodcuttingrank);
        woodcuttinglvl = view.findViewById(R.id.woodcuttinglvl);
        woodcuttingxp = view.findViewById(R.id.woodcuttingxp);
        fletchingrank = view.findViewById(R.id.fletchingrank);
        fletchinglvl = view.findViewById(R.id.fletchinglvl);
        fletchingxp = view.findViewById(R.id.fletchingxp);
        fishingrank = view.findViewById(R.id.fishingrank);
        fishinglvl = view.findViewById(R.id.fishinglvl);
        fishingxp = view.findViewById(R.id.fishingxp);
        firemakingrank = view.findViewById(R.id.firemakingrank);
        firemakinglvl = view.findViewById(R.id.firemakinglvl);
        firemakingxp = view.findViewById(R.id.firemakingxp);
        craftingrank = view.findViewById(R.id.craftingrank);
        craftinglvl = view.findViewById(R.id.craftinglvl);
        craftingxp = view.findViewById(R.id.craftingxp);
        smithingrank = view.findViewById(R.id.smithingrank);
        smithinglvl = view.findViewById(R.id.smithinglvl);
        smithingxp = view.findViewById(R.id.smithingxp);
        miningrank = view.findViewById(R.id.miningrank);
        mininglvl = view.findViewById(R.id.mininglvl);
        miningxp = view.findViewById(R.id.miningxp);
        herblorerank = view.findViewById(R.id.herblorerank);
        herblorelvl = view.findViewById(R.id.herblorelvl);
        herblorexp = view.findViewById(R.id.herblorexp);
        agilityrank = view.findViewById(R.id.agilityrank);
        agilitylvl = view.findViewById(R.id.agilitylvl);
        agilityxp = view.findViewById(R.id.agilityxp);
        thievingrank = view.findViewById(R.id.thievingrank);
        thievinglvl = view.findViewById(R.id.thievinglvl);
        thievingxp = view.findViewById(R.id.thievingxp);
        slayerrank = view.findViewById(R.id.slayerrank);
        slayerlvl = view.findViewById(R.id.slayerlvl);
        slayerxp = view.findViewById(R.id.slayerxp);
        farmingrank = view.findViewById(R.id.farmingrank);
        farminglvl = view.findViewById(R.id.farminglvl);
        farmingxp = view.findViewById(R.id.farmingxp);
        runecraftingrank = view.findViewById(R.id.runecraftrank);
        runecraftinglvl = view.findViewById(R.id.runecraftlvl);
        runecraftingxp = view.findViewById(R.id.runecraftxp);
        hunterrank = view.findViewById(R.id.hunterrank);
        hunterlvl = view.findViewById(R.id.hunterlvl);
        hunterxp = view.findViewById(R.id.hunterxp);
        constructionrank = view.findViewById(R.id.constructionrank);
        constructionlvl = view.findViewById(R.id.constructionlvl);
        constructionxp = view.findViewById(R.id.constructionxp);

        Bundle extras = Objects.requireNonNull(getActivity()).getIntent().getExtras();
        assert extras != null;
        username = extras.getString("username");
        url = extras.getString("url");

        // URL to get JSON
        try {
            assert url != null;
            if ("normal".equals(url)) {
                jsonURL = "http://ahdesigns.coolpage.biz/old_hiscores.php?user=" + URLEncoder.encode(username, "UTF-8");
            } else {
                jsonURL = "http://ahdesigns.coolpage.biz/old_hiscores_" + url + ".php?user=" + URLEncoder.encode(username, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //Call the getdata class
        new GetData().execute();

        return view;
    }

    //Get data class to get json data
    @SuppressLint("StaticFieldLeak")
    private class GetData extends AsyncTask<Void, Void, Void> {

        //Before data will be looked up
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
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
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if(overallRankValue != null) {

                DecimalFormat df = new DecimalFormat();
                DecimalFormat df1 = new DecimalFormat("#.##");
                df.setGroupingUsed(true);
                df.setGroupingSize(3);

                //After we have obtained the JSON data
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

                //Updating textviews with hiscore values.
                if (overallRankValue.trim().length() > 0) {
                    overallrank.setText(df.format(Long.valueOf(overallRankValue)));
                }
                if (overallLvlValue.trim().length() > 0) {
                    overalllvl.setText(df.format(Long.valueOf(overallLvlValue)));
                } else {
                    overallLvlValue = "0";
                }
                if (overallXpValue.trim().length() > 0) {
                    overallxp.setText(df.format(Long.valueOf(overallXpValue)));
                }

                if (attackRankValue.trim().length() > 0) {
                    attackrank.setText(df.format(Long.valueOf(attackRankValue)));
                }
                if (attackLvlValue.trim().length() > 0) {
                    attacklvl.setText(df.format(Long.valueOf(attackLvlValue)));
                } else {
                    attackLvlValue = "0";
                }
                if (attackXpValue.trim().length() > 0) {
                    attackxp.setText(df.format(Long.valueOf(attackXpValue)));
                }

                if (defenceRankValue.trim().length() > 0) {
                    defencerank.setText(df.format(Long.valueOf(defenceRankValue)));
                }
                if (defenceLvlValue.trim().length() > 0) {
                    defencelvl.setText(df.format(Long.valueOf(defenceLvlValue)));
                } else {
                    defenceLvlValue = "0";
                }
                if (defenceXpValue.trim().length() > 0) {
                    defencexp.setText(df.format(Long.valueOf(defenceXpValue)));
                }

                if (strengthRankValue.trim().length() > 0) {
                    strengthrank.setText(df.format(Long.valueOf(strengthRankValue)));
                }
                if (strengthLvlValue.trim().length() > 0) {
                    strengthlvl.setText(df.format(Long.valueOf(strengthLvlValue)));
                } else {
                    strengthLvlValue = "0";
                }
                if (strengthXpValue.trim().length() > 0) {
                    strengthxp.setText(df.format(Long.valueOf(strengthXpValue)));
                }

                if (hitpointsRankValue.trim().length() > 0) {
                    hitpointsrank.setText(df.format(Long.valueOf(hitpointsRankValue)));
                }
                if (hitpointsLvlValue.trim().length() > 0) {
                    hitpointslvl.setText(df.format(Long.valueOf(hitpointsLvlValue)));
                } else {
                    hitpointsLvlValue = "0";
                }
                if (hitpointsXpValue.trim().length() > 0) {
                    hitpointsxp.setText(df.format(Long.valueOf(hitpointsXpValue)));
                }

                if (rangedRankValue.trim().length() > 0) {
                    rangedrank.setText(df.format(Long.valueOf(rangedRankValue)));
                }
                if (rangedLvlValue.trim().length() > 0) {
                    rangedlvl.setText(df.format(Long.valueOf(rangedLvlValue)));
                } else {
                    rangedLvlValue = "0";
                }
                if (rangedXpValue.trim().length() > 0) {
                    rangedxp.setText(df.format(Long.valueOf(rangedXpValue)));
                }

                if (prayerRankValue.trim().length() > 0) {
                    prayerrank.setText(df.format(Long.valueOf(prayerRankValue)));
                }
                if (prayerLvlValue.trim().length() > 0) {
                    prayerlvl.setText(df.format(Long.valueOf(prayerLvlValue)));
                } else {
                    prayerLvlValue = "0";
                }
                if (prayerXpValue.trim().length() > 0) {
                    prayerxp.setText(df.format(Long.valueOf(prayerXpValue)));
                }

                if (magicRankValue.trim().length() > 0) {
                    magicrank.setText(df.format(Long.valueOf(magicRankValue)));
                }
                if (magicLvlValue.trim().length() > 0) {
                    magiclvl.setText(df.format(Long.valueOf(magicLvlValue)));
                } else {
                    magicLvlValue = "0";
                }
                if (magicXpValue.trim().length() > 0) {
                    magicxp.setText(df.format(Long.valueOf(magicXpValue)));
                }

                if (cookingRankValue.trim().length() > 0) {
                    cookingrank.setText(df.format(Long.valueOf(cookingRankValue)));
                }
                if (cookingLvlValue.trim().length() > 0) {
                    cookinglvl.setText(df.format(Long.valueOf(cookingLvlValue)));
                } else {
                    cookingLvlValue = "0";
                }
                if (cookingXpValue.trim().length() > 0) {
                    cookingxp.setText(df.format(Long.valueOf(cookingXpValue)));
                }

                if (woodcuttingRankValue.trim().length() > 0) {
                    woodcuttingrank.setText(df.format(Long.valueOf(woodcuttingRankValue)));
                }
                if (woodcuttingLvlValue.trim().length() > 0) {
                    woodcuttinglvl.setText(df.format(Long.valueOf(woodcuttingLvlValue)));
                } else {
                    woodcuttingLvlValue = "0";
                }
                if (woodcuttingXpValue.trim().length() > 0) {
                    woodcuttingxp.setText(df.format(Long.valueOf(woodcuttingXpValue)));
                }

                if (fletchingRankValue.trim().length() > 0) {
                    fletchingrank.setText(df.format(Long.valueOf(fletchingRankValue)));
                }
                if (fletchingLvlValue.trim().length() > 0) {
                    fletchinglvl.setText(df.format(Long.valueOf(fletchingLvlValue)));
                } else {
                    fletchingLvlValue = "0";
                }
                if (fletchingXpValue.trim().length() > 0) {
                    fletchingxp.setText(df.format(Long.valueOf(fletchingXpValue)));
                }

                if (fishingRankValue.trim().length() > 0) {
                    fishingrank.setText(df.format(Long.valueOf(fishingRankValue)));
                }
                if (fishingLvlValue.trim().length() > 0) {
                    fishinglvl.setText(df.format(Long.valueOf(fishingLvlValue)));
                } else {
                    fishingLvlValue = "0";
                }
                if (fishingXpValue.trim().length() > 0) {
                    fishingxp.setText(df.format(Long.valueOf(fishingXpValue)));
                }

                if (firemakingRankValue.trim().length() > 0) {
                    firemakingrank.setText(df.format(Long.valueOf(firemakingRankValue)));
                }
                if (firemakingLvlValue.trim().length() > 0) {
                    firemakinglvl.setText(df.format(Long.valueOf(firemakingLvlValue)));
                } else {
                    firemakingLvlValue = "0";
                }
                if (firemakingXpValue.trim().length() > 0) {
                    firemakingxp.setText(df.format(Long.valueOf(firemakingXpValue)));
                }

                if (craftingRankValue.trim().length() > 0) {
                    craftingrank.setText(df.format(Long.valueOf(craftingRankValue)));
                }
                if (craftingLvlValue.trim().length() > 0) {
                    craftinglvl.setText(df.format(Long.valueOf(craftingLvlValue)));
                } else {
                    craftingLvlValue = "0";
                }
                if (craftingXpValue.trim().length() > 0) {
                    craftingxp.setText(df.format(Long.valueOf(craftingXpValue)));
                }

                if (smithingRankValue.trim().length() > 0) {
                    smithingrank.setText(df.format(Long.valueOf(smithingRankValue)));
                }
                if (smithingLvlValue.trim().length() > 0) {
                    smithinglvl.setText(df.format(Long.valueOf(smithingLvlValue)));
                } else {
                    smithingLvlValue = "0";
                }
                if (smithingXpValue.trim().length() > 0) {
                    smithingxp.setText(df.format(Long.valueOf(smithingXpValue)));
                }

                if (miningRankValue.trim().length() > 0) {
                    miningrank.setText(df.format(Long.valueOf(miningRankValue)));
                }
                if (miningLvlValue.trim().length() > 0) {
                    mininglvl.setText(df.format(Long.valueOf(miningLvlValue)));
                } else {
                    miningLvlValue = "0";
                }
                if (miningXpValue.trim().length() > 0) {
                    miningxp.setText(df.format(Long.valueOf(miningXpValue)));
                }

                if (herbloreRankValue.trim().length() > 0) {
                    herblorerank.setText(df.format(Long.valueOf(herbloreRankValue)));
                }
                if (herbloreLvlValue.trim().length() > 0) {
                    herblorelvl.setText(df.format(Long.valueOf(herbloreLvlValue)));
                } else {
                    herbloreLvlValue = "0";
                }
                if (herbloreXpValue.trim().length() > 0) {
                    herblorexp.setText(df.format(Long.valueOf(herbloreXpValue)));
                }

                if (agilityRankValue.trim().length() > 0) {
                    agilityrank.setText(df.format(Long.valueOf(agilityRankValue)));
                }
                if (agilityLvlValue.trim().length() > 0) {
                    agilitylvl.setText(df.format(Long.valueOf(agilityLvlValue)));
                } else {
                    agilityLvlValue = "0";
                }
                if (agilityXpValue.trim().length() > 0) {
                    agilityxp.setText(df.format(Long.valueOf(agilityXpValue)));
                }

                if (thievingRankValue.trim().length() > 0) {
                    thievingrank.setText(df.format(Long.valueOf(thievingRankValue)));
                }
                if (thievingLvlValue.trim().length() > 0) {
                    thievinglvl.setText(df.format(Long.valueOf(thievingLvlValue)));
                } else {
                    thievingLvlValue = "0";
                }
                if (thievingXpValue.trim().length() > 0) {
                    thievingxp.setText(df.format(Long.valueOf(thievingXpValue)));
                }

                if (slayerRankValue.trim().length() > 0) {
                    slayerrank.setText(df.format(Long.valueOf(slayerRankValue)));
                }
                if (slayerLvlValue.trim().length() > 0) {
                    slayerlvl.setText(df.format(Long.valueOf(slayerLvlValue)));
                } else {
                    slayerLvlValue = "0";
                }
                if (slayerXpValue.trim().length() > 0) {
                    slayerxp.setText(df.format(Long.valueOf(slayerXpValue)));
                }

                if (farmingRankValue.trim().length() > 0) {
                    farmingrank.setText(df.format(Long.valueOf(farmingRankValue)));
                }
                if (farmingLvlValue.trim().length() > 0) {
                    farminglvl.setText(df.format(Long.valueOf(farmingLvlValue)));
                } else {
                    farmingLvlValue = "0";
                }
                if (farmingXpValue.trim().length() > 0) {
                    farmingxp.setText(df.format(Long.valueOf(farmingXpValue)));
                }

                if (runecraftingRankValue.trim().length() > 0) {
                    runecraftingrank.setText(df.format(Long.valueOf(runecraftingRankValue)));
                }
                if (runecraftingLvlValue.trim().length() > 0) {
                    runecraftinglvl.setText(df.format(Long.valueOf(runecraftingLvlValue)));
                } else {
                    runecraftingLvlValue = "0";
                }
                if (runecraftingXpValue.trim().length() > 0) {
                    runecraftingxp.setText(df.format(Long.valueOf(runecraftingXpValue)));
                }

                if (hunterRankValue.trim().length() > 0) {
                    hunterrank.setText(df.format(Long.valueOf(hunterRankValue)));
                }
                if (hunterLvlValue.trim().length() > 0) {
                    hunterlvl.setText(df.format(Long.valueOf(hunterLvlValue)));
                } else {
                    hunterLvlValue = "0";
                }
                if (hunterXpValue.trim().length() > 0) {
                    hunterxp.setText(df.format(Long.valueOf(hunterXpValue)));
                }

                if (constructionRankValue.trim().length() > 0) {
                    constructionrank.setText(df.format(Long.valueOf(constructionRankValue)));
                }
                if (constructionLvlValue.trim().length() > 0) {
                    constructionlvl.setText(df.format(Long.valueOf(constructionLvlValue)));
                } else {
                    constructionLvlValue = "0";
                }
                if (constructionXpValue.trim().length() > 0) {
                    constructionxp.setText(df.format(Long.valueOf(constructionXpValue)));
                }

                prayer = Integer.parseInt(prayerLvlValue);
                range = Integer.parseInt(rangedLvlValue);
                magic = Integer.parseInt(magicLvlValue);

                baseCombatLevel = 0.25 * (Integer.parseInt(defenceLvlValue) + Integer.parseInt(hitpointsLvlValue) + floor(prayer/2));
                warrior = 0.325 * (Integer.parseInt(attackLvlValue) + Integer.parseInt(strengthLvlValue));
                ranger = 0.325 * (floor(range/2) + Integer.parseInt(rangedLvlValue));
                mager =  0.325 * (floor(magic/2) + Integer.parseInt(magicLvlValue));

                if (warrior > mager  && warrior > ranger)
                {
                    warriorCombatLevel = baseCombatLevel + warrior;
                    warriorCombatLevel = Double.parseDouble(df1.format(warriorCombatLevel));
                    combat.setText(String.valueOf(warriorCombatLevel));
                    style.setText("Warrior");
                    chatHead.setImageResource(R.drawable.app_icon_meleechat);
                } else if (mager > warrior && mager > ranger) {
                    mageCombatLevel = baseCombatLevel + mager;
                    mageCombatLevel = Double.parseDouble(df1.format(mageCombatLevel));
                    combat.setText(String.valueOf(mageCombatLevel));
                    style.setText("Mage");
                    chatHead.setImageResource(R.drawable.app_icon_magicchat);
                } else if (ranger > warrior && ranger > mager) {
                    rangeCombatLevel = baseCombatLevel + ranger;
                    rangeCombatLevel = Double.parseDouble(df1.format(rangeCombatLevel));
                    combat.setText(String.valueOf(rangeCombatLevel));
                    style.setText("Archer");
                    chatHead.setImageResource(R.drawable.app_icon_rangedchat);
                }
            } else {
                if (pDialog.isShowing())
                    pDialog.dismiss();
                Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), username + " was not found in the Overall table", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        }
    }
}