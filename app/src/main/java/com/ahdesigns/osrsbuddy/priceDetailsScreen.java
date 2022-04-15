package com.ahdesigns.osrsbuddy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

public class priceDetailsScreen extends AppCompatActivity {

    private final String TAG = priceDetailsScreen.class.getSimpleName();

    /*

    IMPORTANT, THE BELOW ARE FOR THE TREE MENU SYSTEM

     */

    int n1, itemID, itemPrice, finalAmount;

    double sn, sn1, sum, sum1;

    //Declare all of our TextViews
    TextView itemDescription, currentPrice,
            changeToday, change1Month,
            change3Month, change6Month,
            highAlch, lowAlch,
            finalamountText;

    EditText amountText;

    ImageView itemIcon, itemP2P,
            changeTodayTrend, change1MonthTrend,
            change3MonthTrend, change6MonthTrend;

    //Assign Strings for the data we will pull from the JSON
    String itemIconValue, itemP2PValue,
            itemNameValue, itemDescriptionValue, currentPriceValue,
            changeTodayTrendValue, changeTodayValue,
            change1MonthTrendValue, change1MonthValue,
            change3MonthTrendValue, change3MonthValue,
            change6MonthTrendValue, change6MonthValue;

    //Set a progress dialog to show loading of data
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pricedetailsscreen);

        //Get the extras from the tree
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        itemID = extras.getInt("itemID");
        itemPrice = extras.getInt("itemPrice");

        //Define textviews
        itemDescription = findViewById(R.id.itemDescription);
        currentPrice = findViewById(R.id.itemPrice);
        changeToday = findViewById(R.id.changeToday);
        change1Month = findViewById(R.id.change1Month);
        change3Month = findViewById(R.id.change3Month);
        change6Month = findViewById(R.id.change6Month);
        highAlch = findViewById(R.id.highAlch);
        lowAlch = findViewById(R.id.lowAlch);
        finalamountText = findViewById(R.id.finalamountText);

        amountText = findViewById(R.id.amountText);
        //Define icons
        itemIcon = findViewById(R.id.itemIcon);
        itemP2P = findViewById(R.id.itemP2P);
        changeTodayTrend = findViewById(R.id.changeTodayTrend);
        change1MonthTrend = findViewById(R.id.change1MonthTrend);
        change3MonthTrend = findViewById(R.id.change3MonthTrend);
        change6MonthTrend = findViewById(R.id.change6MonthTrend);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //Call the getdata class
        new geData().execute();
    }

    //Get geData class to get json data
    @SuppressLint("StaticFieldLeak")
    private class geData extends AsyncTask<Void, Void, Void> {

        //Before data will be looked up
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Showing progress dialog
            pDialog = new ProgressDialog(priceDetailsScreen.this);
            pDialog.setMessage("Getting Grand Exchange Prices...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        //During the background operation
        @Override
        protected Void doInBackground(Void... arg0) {

            // Creating http handler class
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String geURL = "https://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=" + itemID;
            String jsonStr = sh.makeServiceCall(geURL);

            Log.e(TAG, "Response from url: " + jsonStr);

            //Check to see if JSON string is not empty
            if (jsonStr != null) {
                try {

                    //Create a new JSON object
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting the 'item' object from the JSON object
                    JSONObject item = jsonObj.getJSONObject("item");

                    //From the 'item' object, we want the below strings
                    //Assign all string and int to variables
                    itemNameValue = item.getString("name");
                    itemDescriptionValue = item.getString("description");

                    //Get string of the URL for the item icon
                    itemIconValue = item.getString("icon_large");

                    // Getting the 'current' object from the 'item' JSON object
                    JSONObject current = item.getJSONObject("current");

                    //From the 'current' object, we want the below strings
                    //Assign all string and int to variables
                    currentPriceValue = current.getString("price");

                    // Getting the 'today' object from the 'item' JSON object
                    JSONObject today = item.getJSONObject("today");

                    //From the 'today' object, we want the below strings
                    //Assign all string and int to variables
                    changeTodayTrendValue = today.getString("trend");
                    changeTodayValue = today.getString("price");

                    itemP2PValue = item.getString("members");

                    // Getting the 'day30' object from the 'item' JSON object
                    JSONObject day30 = item.getJSONObject("day30");

                    //From the 'day30' object, we want the below strings
                    //Assign all string and int to variables
                    change1MonthTrendValue = day30.getString("trend");
                    change1MonthValue = day30.getString("change");

                    // Getting the 'day90' object from the 'item' JSON object
                    JSONObject day90 = item.getJSONObject("day90");

                    //From the 'day90' object, we want the below strings
                    //Assign all string and int to variables
                    change3MonthTrendValue = day90.getString("trend");
                    change3MonthValue = day90.getString("change");

                    // Getting the 'day180' object from the 'item' JSON object
                    JSONObject day180 = item.getJSONObject("day180");

                    //From the 'day180' object, we want the below strings
                    //Assign all string and int to variables
                    change6MonthTrendValue = day180.getString("trend");
                    change6MonthValue = day180.getString("change");

                    //Catch any errors
                } catch (final JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } else {
                //JSON was empty, there was an error on URL
                Log.e(TAG, "Couldn't get any data from the url");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            DecimalFormat df = new DecimalFormat();
            DecimalFormat df1 = new DecimalFormat();
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setGroupingSeparator(',');
            dfs.setDecimalSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            df.setMinimumFractionDigits(1);
            df.setMaximumFractionDigits(1);
            df1.setDecimalFormatSymbols(dfs);
            df1.setMinimumFractionDigits(0);
            df1.setMaximumFractionDigits(0);

            //After we have obtained the JSON data
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            //Update our textviews with new data (eventually including all data we need and images)
            itemDescription.setText(itemDescriptionValue);
            Objects.requireNonNull(getSupportActionBar()).setTitle(itemNameValue);

            n1 = Integer.parseInt(String.valueOf(itemPrice));
            sum = n1 * 0.6;
            sum1 = n1 * 0.4;

            currentPrice.setText(currentPriceValue);
            changeToday.setText(changeTodayValue);
            change1Month.setText(change1MonthValue);
            change3Month.setText(change3MonthValue);
            change6Month.setText(change6MonthValue);

            if (changeTodayTrendValue.equals("positive")) {
                changeTodayTrend.setBackgroundResource(R.drawable.app_icon_positive);
            } else if (changeTodayTrendValue.equals("negative")) {
                changeTodayTrend.setBackgroundResource(R.drawable.app_icon_negative);
            } else {
                changeTodayTrend.setBackgroundResource(R.drawable.app_icon_no_change);
            }
            if (change1MonthTrendValue.equals("positive")) {
                change1MonthTrend.setBackgroundResource(R.drawable.app_icon_positive);
            } else if (change1MonthTrendValue.equals("negative")) {
                change1MonthTrend.setBackgroundResource(R.drawable.app_icon_negative);
            } else {
                change1MonthTrend.setBackgroundResource(R.drawable.app_icon_no_change);
            }
            if (change3MonthTrendValue.equals("positive")) {
                change3MonthTrend.setBackgroundResource(R.drawable.app_icon_positive);
            } else if (change3MonthTrendValue.equals("negative")) {
                change3MonthTrend.setBackgroundResource(R.drawable.app_icon_negative);
            } else {
                change3MonthTrend.setBackgroundResource(R.drawable.app_icon_no_change);
            }
            if (change6MonthTrendValue.equals("positive")) {
                change6MonthTrend.setBackgroundResource(R.drawable.app_icon_positive);
            } else if (change6MonthTrendValue.equals("negative")) {
                change6MonthTrend.setBackgroundResource(R.drawable.app_icon_negative);
            } else {
                change6MonthTrend.setBackgroundResource(R.drawable.app_icon_no_change);
            }

            if (sum < 10000) {
                highAlch.setText(df1.format(sum));
            }
            if (sum >= 10000) {
                sn = sum / 1000;
                highAlch.setText(df.format(sn) + "k");
            }
            if (sum >= 1000000) {
                sn = sum / 1000000;
                highAlch.setText(df.format(sn) + "m");
            }

            if (sum1 < 10000) {
                lowAlch.setText(df1.format(sum1));
            }
            if (sum1 >= 10000) {
                sn1 = sum1 / 1000;
                lowAlch.setText(df.format(sn1) + "k");
            }
            if (sum1 >= 1000000) {
                sn1 = sum1 / 1000000;
                lowAlch.setText(df.format(sn1) + "m");
            }

            if (itemP2PValue.equals("true")) {
                itemP2P.setBackgroundResource(R.drawable.app_icon_p2p);
            } else {
                itemP2P.setBackgroundResource(R.drawable.app_icon_f2p);
            }

            //Use the download image task to assign the imageview the item icon
            new DownloadImageTask(itemIcon).execute(itemIconValue);
        }

    }

    //Downloading an image and setting to imageview
    @SuppressLint("StaticFieldLeak")
    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", Objects.requireNonNull(e.getMessage()));
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    public void update(View view) {

        String value= amountText.getText().toString();
        int amount = Integer.parseInt(value);
        int original = Integer.parseInt(currentPriceValue);

        finalAmount = original * amount;
        String aString = Integer.toString(finalAmount);
        finalamountText.setText(aString);
    }

    public void onBackPressed() {
    }
}