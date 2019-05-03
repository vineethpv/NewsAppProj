package com.demo.newsfeedapp.ui.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.demo.newsfeedapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public static final String KEY_DETAILS = "key_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView detailsTV = findViewById(R.id.txtDetails);
        detailsTV.setText(getIntent().getStringExtra(KEY_DETAILS));
    }
}
