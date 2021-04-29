package com.androidqr.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QrDetailsActivity extends AppCompatActivity {
    TextView title1,detail1;
    TextView title2,detail2;
    TextView title3,detail3;
    TextView title4,detail4;
    TextView title5,detail5;
    TextView title6,detail6;
    TextView title7,detail7;
    TextView title8,detail8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_details);

        title1= findViewById(R.id.title1);
        detail1=findViewById(R.id.detail1);
        title2= findViewById(R.id.title2);
        detail2=findViewById(R.id.detail2);
        title3= findViewById(R.id.title3);
        detail3=findViewById(R.id.detail3);
        title4= findViewById(R.id.title4);
        detail4=findViewById(R.id.detail4);
        title5= findViewById(R.id.title5);
        detail5=findViewById(R.id.detail5);
        title6= findViewById(R.id.title6);
        detail6=findViewById(R.id.detail6);
        title7= findViewById(R.id.title7);
        detail7=findViewById(R.id.detail7);
        title8= findViewById(R.id.title8);
        detail8=findViewById(R.id.detail8);

        String details = getIntent().getStringExtra("key");
        String s1=details;
        String[] words=s1.split("#");

        title1.setText(words[0]);
        detail1.setText(words[1]);

        title2.setText(words[2]);
        detail2.setText(words[3]);

        title3.setText(words[4]);
        detail3.setText(words[5]);

        title4.setText(words[6]);
        detail4.setText(words[7]);

        title5.setText(words[8]);
        detail5.setText(words[9]);

        title6.setText(words[10]);
        detail6.setText(words[11]);

        title7.setText(words[12]);
        detail7.setText(words[13]);

        title8.setText(words[14]);
        detail8.setText(words[15]);


        Toast.makeText(this, s1, Toast.LENGTH_LONG).show();

        //for back arrow
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow); // your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });
    }
}