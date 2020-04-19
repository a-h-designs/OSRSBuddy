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
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Objects;

public class priceDetailsScreen extends AppCompatActivity {

    /*

    IMPORTANT, THE BELOW ARE FOR THE TREE MENU SYSTEM

     */

    String geURL;

    int n1;
    int itemID;
    int itemPrice;

    double sn, sn1, sum, sum1;

    //Declare all of our TextViews
    TextView itemDescription;
    TextView currentPrice;
    TextView highAlch;
    TextView lowAlch;
    ImageView itemIcon;
    ImageView itemP2P;

    //Assign Strings for the data we will pull from the JSON
    String itemNameValue;
    String itemDescriptionValue;
    String currentPriceValue;
    String itemIconValue;
    String itemP2PValue;

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
        highAlch = findViewById(R.id.highAlch);
        lowAlch = findViewById(R.id.lowAlch);
        //Define icons
        itemIcon = findViewById(R.id.itemIcon);
        itemP2P = findViewById(R.id.itemP2P);

        // URL to get JSON
        geURL = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=" + itemID;

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

            // Creating service handler class
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(geURL, ServiceHandler.GET);

            //Log for debug, can be deleted later
            Log.d("Response: ", "> " + jsonStr);

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

                    itemP2PValue = item.getString("members");

                    //Catch any errors
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                //JSON was empty, there was an error on URL
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

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


            currentPrice.setText(currentPriceValue + " gp");

            if (sum >= 1000) {
                sn = sum / 1000;
                highAlch.setText(sn + "k gp");
            }
            if (sum >= 1000000) {
                sn = sum / 1000000;
                highAlch.setText(sn + "m gp");
            }
            if (sum <= 999) {
                highAlch.setText(Math.round(sum) + " gp");
            }

            if (sum1 >= 1000) {
                sn1 = sum1 / 1000;
                lowAlch.setText(sn1 + "k gp");
            }
            if (sum1 >= 1000000) {
                sn1 = sum1 / 1000000;
                lowAlch.setText(sn1 + "m gp");
            }
            if (sum1 <= 999) {
                lowAlch.setText(Math.round(sum1) + " gp");
            }
            if (itemP2PValue.equals("true")) {
                itemP2P.setBackgroundResource(R.drawable.p2picon);
            } else {
                itemP2P.setBackgroundResource(R.drawable.f2picon);
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

    public void onBackPressed() {
    }
}