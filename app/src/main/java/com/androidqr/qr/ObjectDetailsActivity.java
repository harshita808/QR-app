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

public class ObjectDetailsActivity extends AppCompatActivity {
    ImageView gen;
    EditText title1,detail1;
    EditText title2,detail2;
    EditText title3,detail3;
    EditText title4,detail4;
    EditText title5,detail5;
    EditText title6,detail6;
    EditText title7,detail7;
    EditText title8,detail8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objec_details);

        //for back arrow
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow); // your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });



        gen = findViewById(R.id.gen);
        String finalize;

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
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = title1.getText().toString();
                String a2= detail1.getText().toString();

                String a3 = title2.getText().toString();
                String a4 = detail2.getText().toString();

                String a5 = title3.getText().toString();
                String a6 = detail3.getText().toString();

                String a7=title4.getText().toString();
                String a8=detail4.getText().toString();

                String a9=title5.getText().toString();
                String a10=detail5.getText().toString();

                String a11 =title6.getText().toString();
                String a12=detail6.getText().toString();

                String a13=title7.getText().toString();
                String a14=detail7.getText().toString();

                String a15=title8.getText().toString();
                String a16=title8.getText().toString();

                String finalize=' '+a1+"#"+' '+a2+"#"+" "+a3+"#"+" "+a4+"#"+" "+a5+"#"+" "+a6+"#"+" "+a7+"#"+" "+a8+"#"+" "+a9+"#"+" "+a10+"#"+" "+a11+"#"+" "+a12+"#"+" "+a13+"#"+" "+a14+"#"+" "+a15+"#"+" "+a16;
                String  str = finalize;
                String res = "";
                for (int i=0;i<str.length();i++){
                    char ch = str.charAt(i);
                    if (ch == ' ' || ch == '#'){
                        res += ch;
                    }
                    else{
                        if (ch == 'z')
                            res += 'a';
                        else if (ch == 'Z')
                            res += 'A';
                        else{
                            int x = (int)ch + 1;
                            res += (char)x;
                        }
                    }
                }
                String z ="~"+res;
                if((title1.getText().toString().equals("")) || (detail1.getText().toString().equals(""))){
                    openDialog();
                }
                else{


                    Intent i = new Intent(ObjectDetailsActivity.this,unsignqr.class);
                    i.putExtra("key",z);
                    startActivity(i);

                }








            }
        });

    }
    public void openDialog(){
     AlertDialog alertDialog=new AlertDialog();
     alertDialog.show(getSupportFragmentManager(),"example dialog");
    }
}