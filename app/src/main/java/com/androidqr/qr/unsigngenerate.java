package com.androidqr.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class unsigngenerate extends AppCompatActivity {
    ImageView gen;
    EditText detail1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unsignscanner);
        gen = findViewById(R.id.gen);
        detail1 = findViewById(R.id.detail1);

        // for back arrow
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow); // your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

      gen.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String value = detail1.getText().toString();
              if(detail1.getText().toString().equals("")){
                  openDialog();
              }
              else{
                  Intent i = new Intent(unsigngenerate.this,unsignqr.class);
                  i.putExtra("key",value);
                  startActivity(i);

                

              }


          }
      });

    }

    private void openDialog() {

        AlertDialog alertDialog=new AlertDialog();
        alertDialog.show(getSupportFragmentManager(),"example dialog");
    }
}