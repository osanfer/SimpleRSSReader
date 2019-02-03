package com.examples.osanfer.simplerssreader.rssnew;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.examples.osanfer.simplerssreader.R;
import com.examples.osanfer.simplerssreader.pojo.Item;
import com.squareup.picasso.Picasso;

public class RSSNewActivity extends AppCompatActivity implements RSSNewView {

    RSSNewPresenterImpl presenter;
    ProgressBar progressBar;
    private TextView txtTitle;
    private TextView txtDescription;
    private ImageView imgEnclosure;
    private Button btWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_new);
        progressBar = findViewById(R.id.progressBar);
        presenter = new RSSNewPresenterImpl(this, getSharedPreferences("RSS", MODE_PRIVATE));
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        imgEnclosure = findViewById(R.id.imgEnclosure);
        btWeb = findViewById(R.id.btWeb);
        btWeb.setEnabled(false);

        btWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });

        presenter.loadData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showData(Item data) {
        if (data.getEnclosure().getType().startsWith("image")) {
            Picasso.get().load(data.getEnclosure().getUrl()).into(imgEnclosure);
        }
        txtTitle.setText(data.getTitle());
        txtDescription.setText(data.getDescription());
        btWeb.setEnabled(true);
    }

    @Override
    public void launchIntent(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
