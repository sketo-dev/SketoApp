package com.work.sketo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView phoneno, emailid, website, address;
    ImageButton imgPhone, imgEmail, imgWeb, imgAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        phoneno = (TextView)findViewById(R.id.phoneno);
        emailid = (TextView)findViewById(R.id.emailid);
        website = (TextView)findViewById(R.id.website);
        address = (TextView)findViewById(R.id.address);
        imgPhone = (ImageButton) findViewById(R.id.imgPhone);
        imgEmail = (ImageButton) findViewById(R.id.imgEmail);
        imgWeb = (ImageButton) findViewById(R.id.imgWeb);
        imgAddress = (ImageButton) findViewById(R.id.imgAddress);

        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callphone = new Intent(Intent.ACTION_DIAL);
                callphone.setData(Uri.parse("tel:+918830105752"));
                startActivity(callphone);
            }
        });
        phoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callphone = new Intent(Intent.ACTION_DIAL);
                callphone.setData(Uri.parse("tel:+918830105752"));
                startActivity(callphone);
            }
        });


        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"shantanupacharkar@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"call me");
                intent.putExtra(Intent.EXTRA_TEXT,"Call me on this number : 9967883199");
                intent.putExtra(Intent.EXTRA_CC,"shantanump@hotmail.com");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });
        emailid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"shantanupacharkar@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"call me");
                intent.putExtra(Intent.EXTRA_TEXT,"Call me on this number : 9967883199");
                intent.putExtra(Intent.EXTRA_CC,"shantanump@hotmail.com");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });


        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webSite = new Intent(Intent.ACTION_VIEW);
                webSite.setData(Uri.parse("https://shantanupacharkar.weebly.com/"));
                startActivity(webSite);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webSite = new Intent(Intent.ACTION_VIEW);
                webSite.setData(Uri.parse("https://shantanupacharkar.weebly.com/"));
                startActivity(webSite);
            }
        });

        imgAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:19.0228986,72.8428729?z=19");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:19.0228986,72.8428729?z=19");

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
    }
}