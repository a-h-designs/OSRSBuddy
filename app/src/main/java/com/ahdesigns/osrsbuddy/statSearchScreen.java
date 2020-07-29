package com.ahdesigns.osrsbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class statSearchScreen extends AppCompatActivity {

    EditText searchText;
    ImageButton buttonSearch;
    RadioButton normal, ironman, uironman,
            hironman, deadman, leagues,
            tournament;

    String username, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsearchscreen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.stats_header);

        searchText = findViewById(R.id.searchText);
        buttonSearch = findViewById(R.id.buttonSearch);
        normal = findViewById(R.id.normal);
        ironman = findViewById(R.id.ironman);
        uironman = findViewById(R.id.uironman);
        hironman = findViewById(R.id.hironman);
        deadman = findViewById(R.id.deadman);
        leagues = findViewById(R.id.leagues);
        tournament = findViewById(R.id.tournament);

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    buttonSearch.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    public void statSearch(View view) {
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
                Intent intent = new Intent(getApplicationContext(), statsDetailScreen.class);
                intent.putExtra("username", username);
                if (normal.isChecked()) {
                    intent.putExtra("url", "normal");
                } else if (ironman.isChecked()) {
                    intent.putExtra("url", "ironman");
                } else if (uironman.isChecked()) {
                    intent.putExtra("url", "ultimate");
                } else if (hironman.isChecked()) {
                    intent.putExtra("url", "hardcore");
                } else if (deadman.isChecked()) {
                    intent.putExtra("url", "deadman");
                } else if (leagues.isChecked()) {
                    intent.putExtra("url", "seasonal");
                } else  if (tournament.isChecked()) {
                    intent.putExtra("url", "tournament");
                }
                startActivity(intent);
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Network Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
    }
}