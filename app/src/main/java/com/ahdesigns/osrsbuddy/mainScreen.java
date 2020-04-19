package com.ahdesigns.osrsbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class mainScreen extends AppCompatActivity {

    String versionName = BuildConfig.VERSION_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.main_header);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        TextView textViewVersion = findViewById(R.id.textViewVersion);
        TextView textViewCopyright = findViewById(R.id.textViewCopyright);
        textViewVersion.setText(String.format("%s%s", getString(R.string.version), versionName));
        textViewCopyright.setText(String.format(Locale.getDefault(), "%s%d", getString(R.string.copyright), year));
    }

    public void priceActivity(View view) {
        startActivity(new Intent(this, priceSearchScreen.class));
    }

    public void statActivity(View view) {
        startActivity(new Intent(this, statSearchScreen.class));
    }

    public void onBackPressed() {
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Closes the activity as oppose to navigating up.
        return false;
    }
}