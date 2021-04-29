package com.androidqr.qr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class dashboardSignedIn extends AppCompatActivity {
    private static final int CAMERA_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_signed_in);
        CardView generate = (CardView) findViewById(R.id.generate);
    CardView scan =(CardView) findViewById(R.id.scan);
    scan.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(Build.VERSION.SDK_INT >= 23){
                if(checkPermission((Manifest.permission.CAMERA))){

                    openScanner();
                }
                else{
                    requestPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION);
                }
            }
            else{
                openScanner();
            }
        }
    });

        // Set a click listener on that View
        generate.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent generateIntent = new Intent(dashboardSignedIn.this, ObjectDetailsActivity.class);

                // Start the new activity
                startActivity(generateIntent);
            }
        });
        CardView signout = (CardView) findViewById(R.id.logout);

        // Set a click listener on that View
        signout.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent logoutIntent = new Intent(dashboardSignedIn.this, dashboardSignedOut.class);

                // Start the new activity
                startActivity(logoutIntent);
            }
        });
    }

    private void openScanner() {

        IntentIntegrator intentIntegrator = new IntentIntegrator(dashboardSignedIn.this);
        intentIntegrator.setPrompt("For flash use volume up key");
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() == null) {
                Toast.makeText(dashboardSignedIn.this," Blank",Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                String text = result.getContents();
                String str =text;
                if(str.charAt(0) == '~')
                {
                    String res = "";
                    for (int i=1;i<str.length();i++){
                        char ch = str.charAt(i);
                        if (ch == ' ' || ch == '#'){
                            res += ch;
                        }
                        else{

                            if (ch == 'a')
                                res += 'z';
                            else if (ch == 'A')
                                res += 'Z';
                            else{
                                int x = (int)ch - 1;
                                res += (char)x;
                            }
                        }
                    }

                    Intent aa = new Intent(dashboardSignedIn.this,QrDetailsActivity.class);
                    aa.putExtra("key",res); //res
                    startActivity(aa);

                }

                else{
                    Intent zz =new Intent(dashboardSignedIn.this,DetailsDisplaybeforesignin.class);
                    zz.putExtra("key",text);
                    startActivity(zz);
                }

            }
        }
        else {
            Toast.makeText(dashboardSignedIn.this,"Blank",Toast.LENGTH_SHORT).show();
        }
    }


    private boolean checkPermission(String permission){

        int result = ContextCompat.checkSelfPermission(dashboardSignedIn.this,permission);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            return false;
        }

    }


    private void  requestPermission(String permission,int code){
        if(ActivityCompat.shouldShowRequestPermissionRationale(dashboardSignedIn.this,permission)){

        }
        else{
            ActivityCompat.requestPermissions(dashboardSignedIn.this,new String[]{permission},code);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CAMERA_PERMISSION:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openScanner();
                }

        }
    }

}