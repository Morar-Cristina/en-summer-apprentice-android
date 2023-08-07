package com.example.tmsystemdemo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tmsystemdemo.Domain.ItemsDomain;
import com.example.tmsystemdemo.R;

public class UntoldActivity extends AppCompatActivity {
    private TextView titleTxt, descriptionTxt, typeTxt;
    private ItemsDomain item;
    ImageView imgPic, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_untold);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (ItemsDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(item.getEventName());
        descriptionTxt.setText(item.getEventDescription());
        typeTxt.setText(item.getEventType());

        int drawableResourceID = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResourceID)
                .into(imgPic);

        backBtn.setOnClickListener(view -> finish());

    }

    private void initView() {
        titleTxt = findViewById(R.id.titleTxt);
        typeTxt = findViewById(R.id.typeTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        imgPic = findViewById(R.id.picImg);
        backBtn = findViewById(R.id.backBtn);

    }
}