package com.ahdesigns.osrsbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class skillCalculatorSearchScreen extends AppCompatActivity {

    EditText searchText;
    ImageView attack, hitpoints, mining,
            strength, agility, smithing,
            defence, herblore, fishing,
            ranged, thieving, cooking,
            prayer, crafting, firemaking,
            magic, fletching, woodcutting,
            runecraft, slayer, farming,
            construction, hunter;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skillcalculatorsearchscreen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.calculator_header);

        searchText = findViewById(R.id.searchText);
        attack = findViewById(R.id.attack);
        hitpoints = findViewById(R.id.hitpoints);
        mining = findViewById(R.id.mining);
        strength = findViewById(R.id.strength);
        agility = findViewById(R.id.agility);
        smithing = findViewById(R.id.smithing);
        defence = findViewById(R.id.defence);
        herblore = findViewById(R.id.herblore);
        fishing = findViewById(R.id.fishing);
        ranged = findViewById(R.id.ranged);
        thieving = findViewById(R.id.thieving);
        cooking = findViewById(R.id.cooking);
        prayer = findViewById(R.id.prayer);
        crafting = findViewById(R.id.crafting);
        firemaking = findViewById(R.id.firemaking);
        magic = findViewById(R.id.magic);
        fletching = findViewById(R.id.fletching);
        woodcutting = findViewById(R.id.woodcutting);
        runecraft = findViewById(R.id.runecraft);
        slayer = findViewById(R.id.slayer);
        farming = findViewById(R.id.farming);
        construction = findViewById(R.id.construction);
        hunter = findViewById(R.id.hunter);
    }

    public void calculatorSearch(View view) {
        final ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert conMgr != null;
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            if (searchText.getText().toString().trim().length() == 0) {
                Toast.makeText(getApplicationContext(), "Please enter a username", Toast.LENGTH_SHORT).show();
            } else {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(searchText.getWindowToken(), 0);

                username = searchText.getText().toString();
                Intent intent = new Intent(this, skillCalculatorDetailsScreen.class);
                intent.putExtra("username", username);

                int id = view.getId();
                if (id == R.id.attack) {
                    intent.putExtra("skill", "attack");
                    startActivity(intent);
                } else if (id == R.id.hitpoints) {
                    intent.putExtra("skill", "hitpoints");
                    startActivity(intent);
                } else if (id == R.id.mining) {
                    DialogFragment dialog = new miningDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("skill", "mining");
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(),"Mining Dialog");
                } else if (id == R.id.strength) {
                    intent.putExtra("skill", "strength");
                    startActivity(intent);
                } else if (id == R.id.agility) {
                    intent.putExtra("skill", "agility");
                    startActivity(intent);
                } else if (id == R.id.smithing) {
                    DialogFragment dialog = new smithingDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("skill", "smithing");
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(),"Smithing Dialog");
                } else if (id == R.id.defence) {
                    intent.putExtra("skill", "defence");
                    startActivity(intent);
                } else if (id == R.id.herblore) {
                    intent.putExtra("skill", "herblore");
                    startActivity(intent);
                } else if (id == R.id.fishing) {
                    intent.putExtra("skill", "fishing");
                    startActivity(intent);
                } else if (id == R.id.ranged) {
                    intent.putExtra("skill", "ranged");
                    startActivity(intent);
                } else if (id == R.id.thieving) {
                    intent.putExtra("skill", "thieving");
                    startActivity(intent);
                } else if (id == R.id.cooking) {
                    intent.putExtra("skill", "cooking");
                    startActivity(intent);
                } else if (id == R.id.prayer) {
                    intent.putExtra("skill", "prayer");
                    startActivity(intent);
                } else if (id == R.id.crafting) {
                    intent.putExtra("skill", "crafting");
                    startActivity(intent);
                } else if (id == R.id.firemaking) {
                    DialogFragment dialog = new firemakingDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("skill", "firemaking");
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(),"Firemaking Dialog");
                } else if (id == R.id.magic) {
                    intent.putExtra("skill", "magic");
                    startActivity(intent);
                } else if (id == R.id.fletching) {
                    intent.putExtra("skill", "fletching");
                    startActivity(intent);
                } else if (id == R.id.woodcutting) {
                    DialogFragment dialog = new woodcuttingDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username);
                    bundle.putString("skill", "woodcutting");
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(),"Woodcutting Dialog");
                } else if (id == R.id.runecraft) {
                    intent.putExtra("skill", "runecraft");
                    startActivity(intent);
                } else if (id == R.id.slayer) {
                    intent.putExtra("skill", "slayer");
                    startActivity(intent);
                } else if (id == R.id.farming) {
                    intent.putExtra("skill", "farming");
                    startActivity(intent);
                } else if (id == R.id.construction) {
                    intent.putExtra("skill", "construction");
                    startActivity(intent);
                } else if (id == R.id.hunter) {
                    intent.putExtra("skill", "hunter");
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Network Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
    }
}