package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Objects;

public class activityFragment extends Fragment {

    TextView leaguerank, leaguescore,
            bhhrank, bhhscore,
            bhrrank, bhrscore,
            csarank, csascore,
            csbrank, csbscore,
            cserank, csescore,
            csmrank, csmscore,
            cshrank, cshscore,
            cselrank, cselscore,
            csmarank, csmascore,
            lmsrank, lmsscore,
            zealrank, zealscore,
            sirerank, sirescore,
            hydrarank, hydrascore,
            barrowsrank, barrowsscore,
            bryophytarank, bryophytascore,
            callistorank, callistoscore,
            cerberusrank, cerberusscore,
            coxrank, coxscore,
            coxcmrank, coxcmscore,
            elementalrank, elementalscore,
            fanaticrank, fanaticscore,
            zilyanarank, zilyanascore,
            corporealrank, corporealscore,
            carchaeologistrank, carchaeologistscore,
            primerank, primescore,
            rexrank, rexscore,
            supremerank, supremescore,
            darchaeologistrank, darchaeologistscore,
            graardorrank, graardorscore,
            molerank, molescore,
            guardiansrank, guardiansscore,
            hesporirank, hesporiscore,
            kqueenrank, kqueenscore,
            kbdrank, kbdscore,
            krakenrank, krakenscore,
            kreerank, kreescore,
            krilrank, krilscore,
            mimicrank, mimicscore,
            nightmarerank, nightmarescore,
            oborrank, oborscore,
            sarachnisrank, sarachnisscore,
            scorpiarank, scorpiascore,
            skotizorank, skotizoscore,
            gauntletrank, gauntletscore,
            cgauntletrank, cgauntletscore,
            tobrank, tobscore,
            tsdrank, tsdscore,
            zukrank, zukscore,
            jadrank, jadscore,
            venenatisrank, venenatisscore,
            vetionrank, vetionscore,
            vorkathrank, vorkathscore,
            wintertodtrank, wintertodtscore,
            zalcanorank, zalcanoscore,
            zulrahrank, zulrahscore;

    String jsonURL, username, url,
            leagueRankValue, leagueScoreValue,
            bhhRankValue, bhhScoreValue,
            bhrRankValue, bhrScoreValue,
            csaRankValue, csaScoreValue,
            csbRankValue, csbScoreValue,
            cseRankValue, cseScoreValue,
            csmRankValue, csmScoreValue,
            cshRankValue, cshScoreValue,
            cselRankValue, cselScoreValue,
            csmaRankValue, csmaScoreValue,
            lmsRankValue, lmsScoreValue,
            zealRankValue, zealScoreValue,
            sireRankValue, sireScoreValue,
            hydraRankValue, hydraScoreValue,
            barrowsRankValue, barrowsScoreValue,
            bryophytaRankValue, bryophytaScoreValue,
            callistoRankValue, callistoScoreValue,
            cerberusRankValue, cerberusScoreValue,
            coxRankValue, coxScoreValue,
            coxcmRankValue, coxcmScoreValue,
            elementalRankValue, elementalScoreValue,
            fanaticRankValue, fanaticScoreValue,
            zilyanaRankValue, zilyanaScoreValue,
            corporealRankValue, corporealScoreValue,
            carchaeologistRankValue, carchaeologistScoreValue,
            primeRankValue, primeScoreValue,
            rexRankValue, rexScoreValue,
            supremeRankValue, supremeScoreValue,
            darchaeologistRankValue, darchaeologistScoreValue,
            graardorRankValue, graardorScoreValue,
            moleRankValue, moleScoreValue,
            guardiansRankValue, guardiansScoreValue,
            hesporiRankValue, hesporiScoreValue,
            kqueenRankValue, kqueenScoreValue,
            kbdRankValue, kbdScoreValue,
            krakenRankValue, krakenScoreValue,
            kreeRankValue, kreeScoreValue,
            krilRankValue, krilScoreValue,
            mimicRankValue, mimicScoreValue,
            nightmareRankValue, nightmareScoreValue,
            oborRankValue, oborScoreValue,
            sarachnisRankValue, sarachnisScoreValue,
            scorpiaRankValue, scorpiaScoreValue,
            skotizoRankValue, skotizoScoreValue,
            gauntletRankValue, gauntletScoreValue,
            cgauntletRankValue, cgauntletScoreValue,
            tobRankValue, tobScoreValue,
            tsdRankValue, tsdScoreValue,
            zukRankValue, zukScoreValue,
            jadRankValue, jadScoreValue,
            venenatisRankValue, venenatisScoreValue,
            vetionRankValue, vetionScoreValue,
            vorkathRankValue, vorkathScoreValue,
            wintertodtRankValue, wintertodtScoreValue,
            zalcanoRankValue, zalcanoScoreValue,
            zulrahRankValue, zulrahScoreValue;

    private ProgressDialog pDialog;

    public activityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activityfragment, container, false);

        leaguerank = view.findViewById(R.id.leaguerank);
        leaguescore = view.findViewById(R.id.leaguescore);
        bhhrank = view.findViewById(R.id.bhhrank);
        bhhscore = view.findViewById(R.id.bhhscore);
        bhrrank = view.findViewById(R.id.bhrrank);
        bhrscore = view.findViewById(R.id.bhrscore);
        csarank = view.findViewById(R.id.csarank);
        csascore = view.findViewById(R.id.csascore);
        csbrank = view.findViewById(R.id.csbrank);
        csbscore = view.findViewById(R.id.csbscore);
        cserank = view.findViewById(R.id.cserank);
        csescore = view.findViewById(R.id.csescore);
        csmrank = view.findViewById(R.id.csmrank);
        csmscore = view.findViewById(R.id.csmscore);
        cshrank = view.findViewById(R.id.cshrank);
        cshscore = view.findViewById(R.id.cshscore);
        cselrank = view.findViewById(R.id.cselrank);
        cselscore = view.findViewById(R.id.cselscore);
        csmarank = view.findViewById(R.id.csmarank);
        csmascore = view.findViewById(R.id.csmascore);
        lmsrank = view.findViewById(R.id.lmsrank);
        lmsscore = view.findViewById(R.id.lmsscore);
        zealrank = view.findViewById(R.id.zealrank);
        zealscore = view.findViewById(R.id.zealscore);
        sirerank = view.findViewById(R.id.sirerank);
        sirescore = view.findViewById(R.id.sirescore);
        hydrarank = view.findViewById(R.id.hydrarank);
        hydrascore = view.findViewById(R.id.hydrascore);
        barrowsrank = view.findViewById(R.id.barrowsrank);
        barrowsscore = view.findViewById(R.id.barrowsscore);
        bryophytarank = view.findViewById(R.id.bryophytarank);
        bryophytascore = view.findViewById(R.id.bryophytascore);
        callistorank = view.findViewById(R.id.callistorank);
        callistoscore = view.findViewById(R.id.callistoscore);
        cerberusrank = view.findViewById(R.id.cerberusrank);
        cerberusscore = view.findViewById(R.id.cerberusscore);
        coxrank = view.findViewById(R.id.coxrank);
        coxscore = view.findViewById(R.id.coxscore);
        coxcmrank = view.findViewById(R.id.coxcmrank);
        coxcmscore = view.findViewById(R.id.coxcmscore);
        elementalrank = view.findViewById(R.id.elementalrank);
        elementalscore = view.findViewById(R.id.elementalscore);
        fanaticrank = view.findViewById(R.id.fanaticrank);
        fanaticscore = view.findViewById(R.id.fanaticscore);
        zilyanarank = view.findViewById(R.id.zilyanarank);
        zilyanascore = view.findViewById(R.id.zilyanascore);
        corporealrank = view.findViewById(R.id.corporealrank);
        corporealscore = view.findViewById(R.id.corporealscore);
        carchaeologistrank = view.findViewById(R.id.carchaeologistrank);
        carchaeologistscore = view.findViewById(R.id.carchaeologistscore);
        primerank = view.findViewById(R.id.primerank);
        primescore = view.findViewById(R.id.primescore);
        rexrank = view.findViewById(R.id.rexrank);
        rexscore = view.findViewById(R.id.rexscore);
        supremerank = view.findViewById(R.id.supremerank);
        supremescore = view.findViewById(R.id.supremescore);
        darchaeologistrank = view.findViewById(R.id.darchaeologistrank);
        darchaeologistscore = view.findViewById(R.id.darchaeologistscore);
        graardorrank = view.findViewById(R.id.graardorrank);
        graardorscore = view.findViewById(R.id.graardorscore);
        molerank = view.findViewById(R.id.molerank);
        molescore = view.findViewById(R.id.molescore);
        guardiansrank = view.findViewById(R.id.guardiansrank);
        guardiansscore = view.findViewById(R.id.guardiansscore);
        hesporirank = view.findViewById(R.id.hesporirank);
        hesporiscore = view.findViewById(R.id.hesporiscore);
        kqueenrank = view.findViewById(R.id.kqueenrank);
        kqueenscore = view.findViewById(R.id.kqueenscore);
        kbdrank = view.findViewById(R.id.kbdrank);
        kbdscore = view.findViewById(R.id.kbdscore);
        krakenrank = view.findViewById(R.id.krakenrank);
        krakenscore = view.findViewById(R.id.krakenscore);
        kreerank = view.findViewById(R.id.kreerank);
        kreescore = view.findViewById(R.id.kreescore);
        krilrank = view.findViewById(R.id.krilrank);
        krilscore = view.findViewById(R.id.krilscore);
        mimicrank = view.findViewById(R.id.mimicrank);
        mimicscore = view.findViewById(R.id.mimicscore);
        nightmarerank = view.findViewById(R.id.nightmarerank);
        nightmarescore = view.findViewById(R.id.nightmarescore);
        oborrank = view.findViewById(R.id.oborrank);
        oborscore = view.findViewById(R.id.oborscore);
        sarachnisrank = view.findViewById(R.id.sarachnisrank);
        sarachnisscore = view.findViewById(R.id.sarachnisscore);
        scorpiarank = view.findViewById(R.id.scorpiarank);
        scorpiascore = view.findViewById(R.id.scorpiascore);
        skotizorank = view.findViewById(R.id.skotizorank);
        skotizoscore = view.findViewById(R.id.skotizoscore);
        gauntletrank = view.findViewById(R.id.gauntletrank);
        gauntletscore = view.findViewById(R.id.gauntletscore);
        cgauntletrank = view.findViewById(R.id.cgauntletrank);
        cgauntletscore = view.findViewById(R.id.cgauntletscore);
        tobrank = view.findViewById(R.id.tobrank);
        tobscore = view.findViewById(R.id.tobscore);
        tsdrank = view.findViewById(R.id.tsdrank);
        tsdscore = view.findViewById(R.id.tsdscore);
        zukrank = view.findViewById(R.id.zukrank);
        zukscore = view.findViewById(R.id.zukscore);
        jadrank = view.findViewById(R.id.jadrank);
        jadscore = view.findViewById(R.id.jadscore);
        venenatisrank = view.findViewById(R.id.venenatisrank);
        venenatisscore = view.findViewById(R.id.venenatisscore);
        vetionrank = view.findViewById(R.id.vetionrank);
        vetionscore = view.findViewById(R.id.vetionscore);
        vorkathrank = view.findViewById(R.id.vorkathrank);
        vorkathscore = view.findViewById(R.id.vorkathscore);
        wintertodtrank = view.findViewById(R.id.wintertodtrank);
        wintertodtscore = view.findViewById(R.id.wintertodtscore);
        zalcanorank = view.findViewById(R.id.zalcanorank);
        zalcanoscore = view.findViewById(R.id.zalcanoscore);
        zulrahrank = view.findViewById(R.id.zulrahrank);
        zulrahscore = view.findViewById(R.id.zulrahscore);

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

                    // Getting the 'league' object from the JSON object
                    JSONObject league = jsonObj.getJSONObject("league");

                    //From the 'league' object, we want the below strings
                    //Assign all string and int to variables
                    leagueRankValue = league.getString("rank");
                    leagueScoreValue = league.getString("score");

                    // Getting the 'bhh' object from the JSON object
                    JSONObject bhh = jsonObj.getJSONObject("bhh");

                    //From the 'bhh' object, we want the below strings
                    //Assign all string and int to variables
                    bhhRankValue = bhh.getString("rank");
                    bhhScoreValue = bhh.getString("score");

                    // Getting the 'bhr' object from the JSON object
                    JSONObject bhr = jsonObj.getJSONObject("bhr");

                    //From the 'bhr' object, we want the below strings
                    //Assign all string and int to variables
                    bhrRankValue = bhr.getString("rank");
                    bhrScoreValue = bhr.getString("score");

                    // Getting the 'csa' object from the JSON object
                    JSONObject csa = jsonObj.getJSONObject("csa");

                    //From the 'csa' object, we want the below strings
                    //Assign all string and int to variables
                    csaRankValue = csa.getString("rank");
                    csaScoreValue = csa.getString("score");

                    // Getting the 'csb' object from the JSON object
                    JSONObject csb = jsonObj.getJSONObject("csb");

                    //From the 'csb' object, we want the below strings
                    //Assign all string and int to variables
                    csbRankValue = csb.getString("rank");
                    csbScoreValue = csb.getString("score");

                    // Getting the 'cse' object from the JSON object
                    JSONObject cse = jsonObj.getJSONObject("cse");

                    //From the 'cse' object, we want the below strings
                    //Assign all string and int to variables
                    cseRankValue = cse.getString("rank");
                    cseScoreValue = cse.getString("score");

                    // Getting the 'csm' object from the JSON object
                    JSONObject csm = jsonObj.getJSONObject("csm");

                    //From the 'csm' object, we want the below strings
                    //Assign all string and int to variables
                    csmRankValue = csm.getString("rank");
                    csmScoreValue = csm.getString("score");

                    // Getting the 'csh' object from the JSON object
                    JSONObject csh = jsonObj.getJSONObject("csh");

                    //From the 'csh' object, we want the below strings
                    //Assign all string and int to variables
                    cshRankValue = csh.getString("rank");
                    cshScoreValue = csh.getString("score");

                    // Getting the 'csel' object from the JSON object
                    JSONObject csel = jsonObj.getJSONObject("csel");

                    //From the 'csel' object, we want the below strings
                    //Assign all string and int to variables
                    cselRankValue = csel.getString("rank");
                    cselScoreValue = csel.getString("score");

                    // Getting the 'csma' object from the JSON object
                    JSONObject csma = jsonObj.getJSONObject("csma");

                    //From the 'csma' object, we want the below strings
                    //Assign all string and int to variables
                    csmaRankValue = csma.getString("rank");
                    csmaScoreValue = csma.getString("score");

                    // Getting the 'lms' object from the JSON object
                    JSONObject lms = jsonObj.getJSONObject("lms");

                    //From the 'lms' object, we want the below strings
                    //Assign all string and int to variables
                    lmsRankValue = lms.getString("rank");
                    lmsScoreValue = lms.getString("score");

                    // Getting the 'zeal' object from the JSON object
                    JSONObject zeal = jsonObj.getJSONObject("zeal");

                    //From the 'sire' object, we want the below strings
                    //Assign all string and int to variables
                    zealRankValue = zeal.getString("rank");
                    zealScoreValue = zeal.getString("score");

                    // Getting the 'sire' object from the JSON object
                    JSONObject sire = jsonObj.getJSONObject("sire");

                    //From the 'sire' object, we want the below strings
                    //Assign all string and int to variables
                    sireRankValue = sire.getString("rank");
                    sireScoreValue = sire.getString("score");

                    // Getting the 'hydra' object from the JSON object
                    JSONObject hydra = jsonObj.getJSONObject("hydra");

                    //From the 'hydra' object, we want the below strings
                    //Assign all string and int to variables
                    hydraRankValue = hydra.getString("rank");
                    hydraScoreValue = hydra.getString("score");

                    // Getting the 'barrows' object from the JSON object
                    JSONObject barrows = jsonObj.getJSONObject("barrows");

                    //From the 'barrows' object, we want the below strings
                    //Assign all string and int to variables
                    barrowsRankValue = barrows.getString("rank");
                    barrowsScoreValue = barrows.getString("score");

                    // Getting the 'bryophyta' object from the JSON object
                    JSONObject bryophyta = jsonObj.getJSONObject("bryophyta");

                    //From the 'bryophyta' object, we want the below strings
                    //Assign all string and int to variables
                    bryophytaRankValue = bryophyta.getString("rank");
                    bryophytaScoreValue = bryophyta.getString("score");

                    // Getting the 'callisto' object from the JSON object
                    JSONObject callisto = jsonObj.getJSONObject("callisto");

                    //From the 'callisto' object, we want the below strings
                    //Assign all string and int to variables
                    callistoRankValue = callisto.getString("rank");
                    callistoScoreValue = callisto.getString("score");

                    // Getting the 'cerberus' object from the JSON object
                    JSONObject cerberus = jsonObj.getJSONObject("cerberus");

                    //From the 'cerberus' object, we want the below strings
                    //Assign all string and int to variables
                    cerberusRankValue = cerberus.getString("rank");
                    cerberusScoreValue = cerberus.getString("score");

                    // Getting the 'cox' object from the JSON object
                    JSONObject cox = jsonObj.getJSONObject("cox");

                    //From the 'cox' object, we want the below strings
                    //Assign all string and int to variables
                    coxRankValue = cox.getString("rank");
                    coxScoreValue = cox.getString("score");

                    // Getting the 'coxcm' object from the JSON object
                    JSONObject coxcm = jsonObj.getJSONObject("coxcm");

                    //From the 'coxcm' object, we want the below strings
                    //Assign all string and int to variables
                    coxcmRankValue = coxcm.getString("rank");
                    coxcmScoreValue = coxcm.getString("score");

                    // Getting the 'elemental' object from the JSON object
                    JSONObject elemental = jsonObj.getJSONObject("elemental");

                    //From the 'elemental' object, we want the below strings
                    //Assign all string and int to variables
                    elementalRankValue = elemental.getString("rank");
                    elementalScoreValue = elemental.getString("score");

                    // Getting the 'fanatic' object from the JSON object
                    JSONObject fanatic = jsonObj.getJSONObject("fanatic");

                    //From the 'fanatic' object, we want the below strings
                    //Assign all string and int to variables
                    fanaticRankValue = fanatic.getString("rank");
                    fanaticScoreValue = fanatic.getString("score");

                    // Getting the 'zilyana' object from the JSON object
                    JSONObject zilyana = jsonObj.getJSONObject("zilyana");

                    //From the 'zilyana' object, we want the below strings
                    //Assign all string and int to variables
                    zilyanaRankValue = zilyana.getString("rank");
                    zilyanaScoreValue = zilyana.getString("score");

                    // Getting the 'corporeal' object from the JSON object
                    JSONObject corporeal = jsonObj.getJSONObject("corporeal");

                    //From the 'corporeal' object, we want the below strings
                    //Assign all string and int to variables
                    corporealRankValue = corporeal.getString("rank");
                    corporealScoreValue = corporeal.getString("score");

                    // Getting the 'carchaeologist' object from the JSON object
                    JSONObject carchaeologist = jsonObj.getJSONObject("carchaeologist");

                    //From the 'carchaeologist' object, we want the below strings
                    //Assign all string and int to variables
                    carchaeologistRankValue = carchaeologist.getString("rank");
                    carchaeologistScoreValue = carchaeologist.getString("score");

                    // Getting the 'prime' object from the JSON object
                    JSONObject prime = jsonObj.getJSONObject("prime");

                    //From the 'prime' object, we want the below strings
                    //Assign all string and int to variables
                    primeRankValue = prime.getString("rank");
                    primeScoreValue = prime.getString("score");


                    // Getting the 'rex' object from the JSON object
                    JSONObject rex = jsonObj.getJSONObject("rex");

                    //From the 'rex' object, we want the below strings
                    //Assign all string and int to variables
                    rexRankValue = rex.getString("rank");
                    rexScoreValue = rex.getString("score");

                    // Getting the 'supreme' object from the JSON object
                    JSONObject supreme = jsonObj.getJSONObject("supreme");

                    //From the 'supreme' object, we want the below strings
                    //Assign all string and int to variables
                    supremeRankValue = supreme.getString("rank");
                    supremeScoreValue = supreme.getString("score");

                    // Getting the 'darchaeologist' object from the JSON object
                    JSONObject darchaeologist = jsonObj.getJSONObject("darchaeologist");

                    //From the 'darchaeologist' object, we want the below strings
                    //Assign all string and int to variables
                    darchaeologistRankValue = darchaeologist.getString("rank");
                    darchaeologistScoreValue = darchaeologist.getString("score");

                    // Getting the 'graardor' object from the JSON object
                    JSONObject graardor = jsonObj.getJSONObject("graardor");

                    //From the 'graardor' object, we want the below strings
                    //Assign all string and int to variables
                    graardorRankValue = graardor.getString("rank");
                    graardorScoreValue = graardor.getString("score");

                    // Getting the 'mole' object from the JSON object
                    JSONObject mole = jsonObj.getJSONObject("mole");

                    //From the 'mole' object, we want the below strings
                    //Assign all string and int to variables
                    moleRankValue = mole.getString("rank");
                    moleScoreValue = mole.getString("score");

                    // Getting the 'guardians' object from the JSON object
                    JSONObject guardians = jsonObj.getJSONObject("guardians");

                    //From the 'guardians' object, we want the below strings
                    //Assign all string and int to variables
                    guardiansRankValue = guardians.getString("rank");
                    guardiansScoreValue = guardians.getString("score");

                    // Getting the 'hespori' object from the JSON object
                    JSONObject hespori = jsonObj.getJSONObject("hespori");

                    //From the 'hespori' object, we want the below strings
                    //Assign all string and int to variables
                    hesporiRankValue = hespori.getString("rank");
                    hesporiScoreValue = hespori.getString("score");

                    // Getting the 'kqueen' object from the JSON object
                    JSONObject kqueen = jsonObj.getJSONObject("kqueen");

                    //From the 'kqueen' object, we want the below strings
                    //Assign all string and int to variables
                    kqueenRankValue = kqueen.getString("rank");
                    kqueenScoreValue = kqueen.getString("score");

                    // Getting the 'kbd' object from the JSON object
                    JSONObject kbd = jsonObj.getJSONObject("kbd");

                    //From the 'kbd' object, we want the below strings
                    //Assign all string and int to variables
                    kbdRankValue = kbd.getString("rank");
                    kbdScoreValue = kbd.getString("score");

                    // Getting the 'kraken' object from the JSON object
                    JSONObject kraken = jsonObj.getJSONObject("kraken");

                    //From the 'kraken' object, we want the below strings
                    //Assign all string and int to variables
                    krakenRankValue = kraken.getString("rank");
                    krakenScoreValue = kraken.getString("score");

                    // Getting the 'kree' object from the JSON object
                    JSONObject kree = jsonObj.getJSONObject("kree");

                    //From the 'kree' object, we want the below strings
                    //Assign all string and int to variables
                    kreeRankValue = kree.getString("rank");
                    kreeScoreValue = kree.getString("score");

                    // Getting the 'kril' object from the JSON object
                    JSONObject kril = jsonObj.getJSONObject("kril");

                    //From the 'kril' object, we want the below strings
                    //Assign all string and int to variables
                    krilRankValue = kril.getString("rank");
                    krilScoreValue = kril.getString("score");

                    // Getting the 'mimic' object from the JSON object
                    JSONObject mimic = jsonObj.getJSONObject("mimic");

                    //From the 'mimic' object, we want the below strings
                    //Assign all string and int to variables
                    mimicRankValue = mimic.getString("rank");
                    mimicScoreValue = mimic.getString("score");

                    // Getting the 'nightmare' object from the JSON object
                    JSONObject nightmare = jsonObj.getJSONObject("nightmare");

                    //From the 'nightmare' object, we want the below strings
                    //Assign all string and int to variables
                    nightmareRankValue = nightmare.getString("rank");
                    nightmareScoreValue = nightmare.getString("score");

                    // Getting the 'obor' object from the JSON object
                    JSONObject obor = jsonObj.getJSONObject("obor");

                    //From the 'obor' object, we want the below strings
                    //Assign all string and int to variables
                    oborRankValue = obor.getString("rank");
                    oborScoreValue = obor.getString("score");

                    // Getting the 'sarachnis' object from the JSON object
                    JSONObject sarachnis = jsonObj.getJSONObject("sarachnis");

                    //From the 'sarachnis' object, we want the below strings
                    //Assign all string and int to variables
                    sarachnisRankValue = sarachnis.getString("rank");
                    sarachnisScoreValue = sarachnis.getString("score");

                    // Getting the 'scorpia' object from the JSON object
                    JSONObject scorpia = jsonObj.getJSONObject("scorpia");

                    //From the 'scorpia' object, we want the below strings
                    //Assign all string and int to variables
                    scorpiaRankValue = scorpia.getString("rank");
                    scorpiaScoreValue = scorpia.getString("score");

                    // Getting the 'skotizo' object from the JSON object
                    JSONObject skotizo = jsonObj.getJSONObject("skotizo");

                    //From the 'skotizo' object, we want the below strings
                    //Assign all string and int to variables
                    skotizoRankValue = skotizo.getString("rank");
                    skotizoScoreValue = skotizo.getString("score");

                    // Getting the 'gauntlet' object from the JSON object
                    JSONObject gauntlet = jsonObj.getJSONObject("gauntlet");

                    //From the 'gauntlet' object, we want the below strings
                    //Assign all string and int to variables
                    gauntletRankValue = gauntlet.getString("rank");
                    gauntletScoreValue = gauntlet.getString("score");

                    // Getting the 'cgauntlet' object from the JSON object
                    JSONObject cgauntlet = jsonObj.getJSONObject("cgauntlet");

                    //From the 'cgauntlet' object, we want the below strings
                    //Assign all string and int to variables
                    cgauntletRankValue = cgauntlet.getString("rank");
                    cgauntletScoreValue = cgauntlet.getString("score");

                    // Getting the 'tob' object from the JSON object
                    JSONObject tob = jsonObj.getJSONObject("tob");

                    //From the 'tob' object, we want the below strings
                    //Assign all string and int to variables
                    tobRankValue = tob.getString("rank");
                    tobScoreValue = tob.getString("score");

                    // Getting the 'tsd' object from the JSON object
                    JSONObject tsd = jsonObj.getJSONObject("tsd");

                    //From the 'tsd' object, we want the below strings
                    //Assign all string and int to variables
                    tsdRankValue = tsd.getString("rank");
                    tsdScoreValue = tsd.getString("score");

                    // Getting the 'zuk' object from the JSON object
                    JSONObject zuk = jsonObj.getJSONObject("zuk");

                    //From the 'zuk' object, we want the below strings
                    //Assign all string and int to variables
                    zukRankValue = zuk.getString("rank");
                    zukScoreValue = zuk.getString("score");

                    // Getting the 'jad' object from the JSON object
                    JSONObject jad = jsonObj.getJSONObject("jad");

                    //From the 'jad' object, we want the below strings
                    //Assign all string and int to variables
                    jadRankValue = jad.getString("rank");
                    jadScoreValue = jad.getString("score");


                    // Getting the 'venenatis' object from the JSON object
                    JSONObject venenatis = jsonObj.getJSONObject("venenatis");

                    //From the 'venenatis' object, we want the below strings
                    //Assign all string and int to variables
                    venenatisRankValue = venenatis.getString("rank");
                    venenatisScoreValue = venenatis.getString("score");

                    // Getting the 'vetion' object from the JSON object
                    JSONObject vetion = jsonObj.getJSONObject("vetion");

                    //From the 'vetion' object, we want the below strings
                    //Assign all string and int to variables
                    vetionRankValue = vetion.getString("rank");
                    vetionScoreValue = vetion.getString("score");

                    // Getting the 'vorkath' object from the JSON object
                    JSONObject vorkath = jsonObj.getJSONObject("vorkath");

                    //From the 'vorkath' object, we want the below strings
                    //Assign all string and int to variables
                    vorkathRankValue = vorkath.getString("rank");
                    vorkathScoreValue = vorkath.getString("score");

                    // Getting the 'wintertodt' object from the JSON object
                    JSONObject wintertodt = jsonObj.getJSONObject("wintertodt");

                    //From the 'wintertodt' object, we want the below strings
                    //Assign all string and int to variables
                    wintertodtRankValue = wintertodt.getString("rank");
                    wintertodtScoreValue = wintertodt.getString("score");

                    // Getting the 'zalcano' object from the JSON object
                    JSONObject zalcano = jsonObj.getJSONObject("zalcano");

                    //From the 'zalcano' object, we want the below strings
                    //Assign all string and int to variables
                    zalcanoRankValue = zalcano.getString("rank");
                    zalcanoScoreValue = zalcano.getString("score");

                    // Getting the 'zulrah' object from the JSON object
                    JSONObject zulrah = jsonObj.getJSONObject("zulrah");

                    //From the 'zulrah' object, we want the below strings
                    //Assign all string and int to variables
                    zulrahRankValue = zulrah.getString("rank");
                    zulrahScoreValue = zulrah.getString("score");

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

            if(leagueRankValue != null) {

                DecimalFormat df = new DecimalFormat();
                df.setGroupingUsed(true);
                df.setGroupingSize(3);

                //After we have obtained the JSON data
                // Dismiss the progress dialog
                if (pDialog.isShowing())
                    pDialog.dismiss();

                //Updating textviews with hiscore values.
                if (leagueRankValue.trim().length() > 0) {
                    leaguerank.setText(df.format(Long.valueOf(leagueRankValue)));
                    leaguescore.setText(df.format(Long.valueOf(leagueScoreValue)));
                }
                if (bhhRankValue.trim().length() > 0) {
                    bhhrank.setText(df.format(Long.valueOf(bhhRankValue)));
                    bhhscore.setText(df.format(Long.valueOf(bhhScoreValue)));
                }
                if (bhrRankValue.trim().length() > 0) {
                    bhrrank.setText(df.format(Long.valueOf(bhrRankValue)));
                    bhrscore.setText(df.format(Long.valueOf(bhrScoreValue)));
                }
                if (csaRankValue.trim().length() > 0) {
                    csarank.setText(df.format(Long.valueOf(csaRankValue)));
                    csascore.setText(df.format(Long.valueOf(csaScoreValue)));
                }
                if (csbRankValue.trim().length() > 0) {
                    csbrank.setText(df.format(Long.valueOf(csbRankValue)));
                    csbscore.setText(df.format(Long.valueOf(csbScoreValue)));
                }
                if (cseRankValue.trim().length() > 0) {
                    cserank.setText(df.format(Long.valueOf(cseRankValue)));
                    csescore.setText(df.format(Long.valueOf(cseScoreValue)));
                }
                if (csmRankValue.trim().length() > 0) {
                    csmrank.setText(df.format(Long.valueOf(csmRankValue)));
                    csmscore.setText(df.format(Long.valueOf(csmScoreValue)));
                }
                if (cshRankValue.trim().length() > 0) {
                    cshrank.setText(df.format(Long.valueOf(cshRankValue)));
                    cshscore.setText(df.format(Long.valueOf(cshScoreValue)));
                }
                if (cselRankValue.trim().length() > 0) {
                    cselrank.setText(df.format(Long.valueOf(cselRankValue)));
                    cselscore.setText(df.format(Long.valueOf(cselScoreValue)));
                }
                if (csmaRankValue.trim().length() > 0) {
                    csmarank.setText(df.format(Long.valueOf(csmaRankValue)));
                    csmascore.setText(df.format(Long.valueOf(csmaScoreValue)));
                }
                if (lmsRankValue.trim().length() > 0) {
                    lmsrank.setText(df.format(Long.valueOf(lmsRankValue)));
                    lmsscore.setText(df.format(Long.valueOf(lmsScoreValue)));
                }
                if (zealRankValue.trim().length() > 0) {
                    zealrank.setText(df.format(Long.valueOf(zealRankValue)));
                    zealscore.setText(df.format(Long.valueOf(zealScoreValue)));
                }
                if (sireRankValue.trim().length() > 0) {
                    sirerank.setText(df.format(Long.valueOf(sireRankValue)));
                    sirescore.setText(df.format(Long.valueOf(sireScoreValue)));
                }
                if (hydraRankValue.trim().length() > 0) {
                    hydrarank.setText(df.format(Long.valueOf(hydraRankValue)));
                    hydrascore.setText(df.format(Long.valueOf(hydraScoreValue)));
                }
                if (barrowsRankValue.trim().length() > 0) {
                    barrowsrank.setText(df.format(Long.valueOf(barrowsRankValue)));
                    barrowsscore.setText(df.format(Long.valueOf(barrowsScoreValue)));
                }
                if (bryophytaRankValue.trim().length() > 0) {
                    bryophytarank.setText(df.format(Long.valueOf(bryophytaRankValue)));
                    bryophytascore.setText(df.format(Long.valueOf(bryophytaScoreValue)));
                }
                if (callistoRankValue.trim().length() > 0) {
                    callistorank.setText(df.format(Long.valueOf(callistoRankValue)));
                    callistoscore.setText(df.format(Long.valueOf(callistoScoreValue)));
                }
                if (cerberusRankValue.trim().length() > 0) {
                    cerberusrank.setText(df.format(Long.valueOf(cerberusRankValue)));
                    cerberusscore.setText(df.format(Long.valueOf(cerberusScoreValue)));
                }
                if (coxRankValue.trim().length() > 0) {
                    coxrank.setText(df.format(Long.valueOf(coxRankValue)));
                    coxscore.setText(df.format(Long.valueOf(coxScoreValue)));
                }
                if (coxcmRankValue.trim().length() > 0) {
                    coxcmrank.setText(df.format(Long.valueOf(coxcmRankValue)));
                    coxcmscore.setText(df.format(Long.valueOf(coxcmScoreValue)));
                }
                if (elementalRankValue.trim().length() > 0) {
                    elementalrank.setText(df.format(Long.valueOf(elementalRankValue)));
                    elementalscore.setText(df.format(Long.valueOf(elementalScoreValue)));
                }
                if (fanaticRankValue.trim().length() > 0) {
                    fanaticrank.setText(df.format(Long.valueOf(fanaticRankValue)));
                    fanaticscore.setText(df.format(Long.valueOf(fanaticScoreValue)));
                }
                if (zilyanaRankValue.trim().length() > 0) {
                    zilyanarank.setText(df.format(Long.valueOf(zilyanaRankValue)));
                    zilyanascore.setText(df.format(Long.valueOf(zilyanaScoreValue)));
                }
                if (corporealRankValue.trim().length() > 0) {
                    corporealrank.setText(df.format(Long.valueOf(corporealRankValue)));
                    corporealscore.setText(df.format(Long.valueOf(corporealScoreValue)));
                }
                if (carchaeologistRankValue.trim().length() > 0) {
                    carchaeologistrank.setText(df.format(Long.valueOf(carchaeologistRankValue)));
                    carchaeologistscore.setText(df.format(Long.valueOf(carchaeologistScoreValue)));
                }
                if (primeRankValue.trim().length() > 0) {
                    primerank.setText(df.format(Long.valueOf(primeRankValue)));
                    primescore.setText(df.format(Long.valueOf(primeScoreValue)));
                }
                if (rexRankValue.trim().length() > 0) {
                    rexrank.setText(df.format(Long.valueOf(rexRankValue)));
                    rexscore.setText(df.format(Long.valueOf(rexScoreValue)));
                }
                if (supremeRankValue.trim().length() > 0) {
                    supremerank.setText(df.format(Long.valueOf(supremeRankValue)));
                    supremescore.setText(df.format(Long.valueOf(supremeScoreValue)));
                }
                if (darchaeologistRankValue.trim().length() > 0) {
                    darchaeologistrank.setText(df.format(Long.valueOf(darchaeologistRankValue)));
                    darchaeologistscore.setText(df.format(Long.valueOf(darchaeologistScoreValue)));
                }
                if (graardorRankValue.trim().length() > 0) {
                    graardorrank.setText(df.format(Long.valueOf(graardorRankValue)));
                    graardorscore.setText(df.format(Long.valueOf(graardorScoreValue)));
                }
                if (moleRankValue.trim().length() > 0) {
                    molerank.setText(df.format(Long.valueOf(moleRankValue)));
                    molescore.setText(df.format(Long.valueOf(moleScoreValue)));
                }
                if (guardiansRankValue.trim().length() > 0) {
                    guardiansrank.setText(df.format(Long.valueOf(guardiansRankValue)));
                    guardiansscore.setText(df.format(Long.valueOf(guardiansScoreValue)));
                }
                if (hesporiRankValue.trim().length() > 0) {
                    hesporirank.setText(df.format(Long.valueOf(hesporiRankValue)));
                    hesporiscore.setText(df.format(Long.valueOf(hesporiScoreValue)));
                }
                if (kqueenRankValue.trim().length() > 0) {
                    kqueenrank.setText(df.format(Long.valueOf(kqueenRankValue)));
                    kqueenscore.setText(df.format(Long.valueOf(kqueenScoreValue)));
                }
                if (kbdRankValue.trim().length() > 0) {
                    kbdrank.setText(df.format(Long.valueOf(kbdRankValue)));
                    kbdscore.setText(df.format(Long.valueOf(kbdScoreValue)));
                }
                if (krakenRankValue.trim().length() > 0) {
                    krakenrank.setText(df.format(Long.valueOf(krakenRankValue)));
                    krakenscore.setText(df.format(Long.valueOf(krakenScoreValue)));
                }
                if (kreeRankValue.trim().length() > 0) {
                    kreerank.setText(df.format(Long.valueOf(kreeRankValue)));
                    kreescore.setText(df.format(Long.valueOf(kreeScoreValue)));
                }
                if (krilRankValue.trim().length() > 0) {
                    krilrank.setText(df.format(Long.valueOf(krilRankValue)));
                    krilscore.setText(df.format(Long.valueOf(krilScoreValue)));
                }
                if (mimicRankValue.trim().length() > 0) {
                    mimicrank.setText(df.format(Long.valueOf(mimicRankValue)));
                    mimicscore.setText(df.format(Long.valueOf(mimicScoreValue)));
                }
                if (nightmareRankValue.trim().length() > 0) {
                    nightmarerank.setText(df.format(Long.valueOf(nightmareRankValue)));
                    nightmarescore.setText(df.format(Long.valueOf(nightmareScoreValue)));
                }
                if (oborRankValue.trim().length() > 0) {
                    oborrank.setText(df.format(Long.valueOf(oborRankValue)));
                    oborscore.setText(df.format(Long.valueOf(oborScoreValue)));
                }
                if (sarachnisRankValue.trim().length() > 0) {
                    sarachnisrank.setText(df.format(Long.valueOf(sarachnisRankValue)));
                    sarachnisscore.setText(df.format(Long.valueOf(sarachnisScoreValue)));
                }
                if (scorpiaRankValue.trim().length() > 0) {
                    scorpiarank.setText(df.format(Long.valueOf(scorpiaRankValue)));
                    scorpiascore.setText(df.format(Long.valueOf(scorpiaScoreValue)));
                }
                if (skotizoRankValue.trim().length() > 0) {
                    skotizorank.setText(df.format(Long.valueOf(skotizoRankValue)));
                    skotizoscore.setText(df.format(Long.valueOf(skotizoScoreValue)));
                }
                if (gauntletRankValue.trim().length() > 0) {
                    gauntletrank.setText(df.format(Long.valueOf(gauntletRankValue)));
                    gauntletscore.setText(df.format(Long.valueOf(gauntletScoreValue)));
                }
                if (cgauntletRankValue.trim().length() > 0) {
                    cgauntletrank.setText(df.format(Long.valueOf(cgauntletRankValue)));
                    cgauntletscore.setText(df.format(Long.valueOf(cgauntletScoreValue)));
                }
                if (tobRankValue.trim().length() > 0) {
                    tobrank.setText(df.format(Long.valueOf(tobRankValue)));
                    tobscore.setText(df.format(Long.valueOf(tobScoreValue)));
                }
                if (tsdRankValue.trim().length() > 0) {
                    tsdrank.setText(df.format(Long.valueOf(tsdRankValue)));
                    tsdscore.setText(df.format(Long.valueOf(tsdScoreValue)));
                }
                if (zukRankValue.trim().length() > 0) {
                    zukrank.setText(df.format(Long.valueOf(zukRankValue)));
                    zukscore.setText(df.format(Long.valueOf(zukScoreValue)));
                }
                if (jadRankValue.trim().length() > 0) {
                    jadrank.setText(df.format(Long.valueOf(jadRankValue)));
                    jadscore.setText(df.format(Long.valueOf(jadScoreValue)));
                }
                if (venenatisRankValue.trim().length() > 0) {
                    venenatisrank.setText(df.format(Long.valueOf(venenatisRankValue)));
                    venenatisscore.setText(df.format(Long.valueOf(venenatisScoreValue)));
                }
                if (vetionRankValue.trim().length() > 0) {
                    vetionrank.setText(df.format(Long.valueOf(vetionRankValue)));
                    vetionscore.setText(df.format(Long.valueOf(vetionScoreValue)));
                }
                if (vorkathRankValue.trim().length() > 0) {
                    vorkathrank.setText(df.format(Long.valueOf(vorkathRankValue)));
                    vorkathscore.setText(df.format(Long.valueOf(vorkathScoreValue)));
                }
                if (wintertodtRankValue.trim().length() > 0) {
                    wintertodtrank.setText(df.format(Long.valueOf(wintertodtRankValue)));
                    wintertodtscore.setText(df.format(Long.valueOf(wintertodtScoreValue)));
                }
                if (zalcanoRankValue.trim().length() > 0) {
                    zalcanorank.setText(df.format(Long.valueOf(zalcanoRankValue)));
                    zalcanoscore.setText(df.format(Long.valueOf(zalcanoScoreValue)));
                }
                if (zulrahRankValue.trim().length() > 0) {
                    zulrahrank.setText(df.format(Long.valueOf(zulrahRankValue)));
                    zulrahscore.setText(df.format(Long.valueOf(zulrahScoreValue)));
                }
            }
        }
    }
}