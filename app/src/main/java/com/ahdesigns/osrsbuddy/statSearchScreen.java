package com.ahdesigns.osrsbuddy;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class statSearchScreen extends AppCompatActivity {

    EditText searchText;
    ImageButton buttonSearch;

    String username;

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

                DialogFragment dialog = new hiscoresDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                dialog.setArguments(bundle);
                dialog.show(this.getSupportFragmentManager(),"Hiscores Dialog");
            }
        } else {
            Toast.makeText(getApplicationContext(), "No Network Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
    }
}