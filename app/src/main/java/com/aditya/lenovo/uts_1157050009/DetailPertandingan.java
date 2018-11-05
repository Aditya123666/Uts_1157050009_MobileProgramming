package com.aditya.lenovo.uts_1157050009;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPertandingan extends AppCompatActivity {

    String nameHome = "", nameAway = "", descriptionMatch = "", scoreHome = "", scoreAway = "", news = "";
    @BindView(R.id.iv_homee)
    ImageView ivHomee;
    @BindView(R.id.tv_name_homee)
    TextView tvNameHomee;
    @BindView(R.id.iv_awayy)
    ImageView ivAwayy;
    @BindView(R.id.tv_name_awayy)
    TextView tvNameAwayy;
    @BindView(R.id.tv_score_home)
    TextView tvScoreHome;
    @BindView(R.id.tv_score_away)
    TextView tvScoreAway;
    @BindView(R.id.description)
    TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pertandinga);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Pertandingan");

        nameHome = getIntent().getStringExtra("namehome");
        nameAway = getIntent().getStringExtra("nameaway");
        scoreHome = getIntent().getStringExtra("scorehome");
        scoreAway = getIntent().getStringExtra("scoreaway");
        descriptionMatch = getIntent().getStringExtra("description");
        news = getIntent().getStringExtra("news");

        // Toast.makeText(DetailMatchActivity.this, nameAway + nameHome + scoreHome + scoreAway + descriptionMatch, Toast.LENGTH_LONG).show();
        tvNameHomee.setText(nameHome);
        tvNameAwayy.setText(nameAway);
        tvScoreHome.setText(scoreHome);
        tvScoreAway.setText(scoreAway);
        description.setText(descriptionMatch);
        ivHomee.setImageResource(getIntent().getIntExtra("imagehome", 0));
        ivAwayy.setImageResource(getIntent().getIntExtra("imageaway", 0));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void newsApps() {
        String url = news;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        switch (item.getItemId()) {
            case R.id.news:
                newsApps();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
