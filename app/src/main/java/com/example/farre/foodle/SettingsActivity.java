package com.example.farre.foodle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backButton;
    private Button buttonReset;
    private Button buttonDelete;
    private FirebaseAuth firebaseAuth;
    private Switch Coeliac;
    private Switch Diabetic;
    private Switch Vegan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = (ImageButton) findViewById(R.id.backButton);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        backButton.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Switch");
        alertDialog.setMessage("ON");


        CompoundButton.OnCheckedChangeListener multiListener = new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.Coeliac:
                        // Do something
                        alertDialog.show();
                        break;
                    case R.id.Diabetic:
                        // Do something
                        alertDialog.show();
                        break;
                    case R.id.Vegan:
                        // Do something
                        alertDialog.show();
                        break;

                }
            }
        };

        ((Switch) findViewById(R.id.Coeliac)).setOnCheckedChangeListener(multiListener);
        ((Switch) findViewById(R.id.Diabetic)).setOnCheckedChangeListener(multiListener);
        ((Switch) findViewById(R.id.Vegan)).setOnCheckedChangeListener(multiListener);


    }

    @Override
    public void onClick(View view) {
        if(view == backButton) {
            finish();

            startActivity(new Intent(this, ProfileActivity.class));
        }
        if(view == buttonReset) {
            finish();

            startActivity(new Intent(this, ResetPassword.class));
        }
        if(view == buttonDelete) {
            firebaseAuth = FirebaseAuth.getInstance();
            final String TAG = "Tag";
            FirebaseUser currentUser = firebaseAuth.getCurrentUser();

            currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG,"OK! Works fine!");
                        startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        Log.w(TAG,"Something is wrong!");
                    }
                }
            });
        }
    }
}

