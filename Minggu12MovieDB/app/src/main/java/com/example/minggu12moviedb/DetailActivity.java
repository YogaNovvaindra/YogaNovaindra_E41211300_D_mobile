package com.example.minggu12moviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Query;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {

    private TextView mTitle, mDate, mRate, mOverview, mNotAvailable;
    private ImageView mImage;
    private String image, title,date,rate,overview,id;
    private URL traile;
    private String[] t_name,t_key;
    ListView t_listView;
    private LinearLayout fav_button;
    private Button review_button, add_fav_button, remove_fav_button;
    private String isFavorite="no", queryURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        review_button = (Button) findViewById(R.id.review_button);
        review_button.setOnClickListener(v -> {
            id = getIntent().getStringExtra("id");
            Intent intent2 = new Intent(DetailActivity.this, ReviewActivity.class);
            intent2.putExtra("id2", id);
            startActivity(intent2);
        });

        mImage = (ImageView) findViewById(R.id.imageID);
        mDate = (TextView) findViewById(R.id.date_tv);
        mRate = (TextView) findViewById(R.id.Rated_tv);
        mOverview = (TextView) findViewById(R.id.overview_tv);
        mTitle = (TextView) findViewById(R.id.titleID);

        fav_button = (LinearLayout) findViewById(R.id.fav_linear);

        title = getIntent().getStringExtra("title");
        date = getIntent().getStringExtra("date");
        rate = getIntent().getStringExtra("rate");
        overview = getIntent().getStringExtra("overview");
        image = getIntent().getStringExtra("image");
        id = getIntent().getStringExtra("id");
        String TRAILER_URL = "http://api.themoviedb.org/3/movie/" + id.toString() + "/videos?api_key=" + getResources().getString(R.string.API_Key);
        String REVIEW_URL = "https://api.themoviedb.org/3/movie/" + id.toString() + "/reviews?api_key=" + getResources().getString(R.string.API_Key);
        mTitle.setText(title);
        mDate.setText(date);
        mOverview.setText(overview);
        mRate.setText(rate + "/10");

        //SOURCE:https://square.github.io/picasso/
        Picasso.get()
                .load(image)
                .into(mImage);

        try {
            traile = new URL(TRAILER_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        new trailerAsyncTask().execute(traile);
        t_listView = findViewById(R.id.trailer_listview);
        t_listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent t_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + t_key[position]));
            startActivity(t_intent);
        });

        mImage.setOnClickListener(view -> {
            Intent t_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + t_key[0]));
            startActivity(t_intent);
        });





    }

    public class trailerAsyncTask extends AsyncTask<URL, Void, String> {
    @Override
    protected void onPostExecute(String s) {
        if(t_name.length!=0) {
            t_listView = findViewById(R.id.trailer_listview);
            ArrayList<MyTrailer> trailer_list = new ArrayList<>();

            for (int i = 0; i < t_name.length; i++) {
                trailer_list.add(new MyTrailer(t_name[i]));
            }

            TrailerAdapter adapter = new TrailerAdapter(DetailActivity.this, trailer_list);
            t_listView.setAdapter(adapter);

        }

        else{
            mNotAvailable=(TextView)findViewById(R.id.not_Availabe);
            mNotAvailable.setVisibility(View.VISIBLE);
            t_listView = findViewById(R.id.trailer_listview);
            t_listView.setVisibility(View.GONE);

        }
    }

    @Override
    protected String doInBackground(URL... urls) {

    URL url = urls[0];
    String trailer = null;

        try{

            trailer = Utils.getResponseFromHttpUrl(url);
            JSONObject jsonObj = new JSONObject(trailer);

            JSONArray resultArray = jsonObj.getJSONArray("results");

             t_name= new String[resultArray.length()];
             t_key= new String[resultArray.length()];

            for(int i=0;i<resultArray.length();i++){
                t_name[i]=resultArray.getJSONObject(i).getString("name");
                t_key[i]=resultArray.getJSONObject(i).getString("key");
                Log.v("TAG","The names are " + t_name[i]);
            }


        } catch (IOException | JSONException e) {
            Log.e("DetailActivity", e.getMessage());
            e.printStackTrace();
        }

return null;
    }

    }
}