package com.example.ih_hi.digitalbloodbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    private Button donation,myProfile,findDonor,exitButton;
    private int userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        donation = (Button)findViewById(R.id.addDonoationBTN);
        myProfile = (Button)findViewById(R.id.myProfileBTN);
        findDonor = (Button)findViewById(R.id.findDonorBTN);
        exitButton = (Button)findViewById(R.id.exitButtonBTN);

        //Recieve ID
        Intent rIntent = getIntent();
        Bundle rBundle = rIntent.getBundleExtra("USER_DATA");
        userID = rBundle.getInt("USER_ID");

        findDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,DonorListActivity.class));
            }
        });

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,DonorProfileActivity.class);
                Bundle data = new Bundle();
                data.putInt("USER_ID",userID);
                i.putExtra("USER_DATA",data);
                startActivity(i);
            }
        });

        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,DonationActivity.class));
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(HomeActivity.this,LogInActivity.class));
            }
        });
    }
}
