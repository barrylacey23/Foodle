package com.example.farre.foodle;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.AsyncTask;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;

public class SwipeActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference databaseName;
    private DatabaseReference databaseCalories;
    private DatabaseReference databaseIngredients;
    private DatabaseReference databaseDirections;

    private TextView Name;
    private TextView Calories;
    private TextView Ingredients;
    private TextView Directions;
    private ImageButton backButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        final ImageView iv = (ImageView) findViewById(R.id.imageView);
        final String imgURL  = "http://i.imgur.com/a85KE4T.jpg";
        new DownLoadImageTask(iv).execute(imgURL);
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
        Name = (TextView) findViewById(R.id.Name);
        Calories = (TextView) findViewById(R.id.Calories);
        Ingredients = (TextView) findViewById(R.id.Ingredients);
        Directions = (TextView) findViewById(R.id.Directions);
        backButton2 = (ImageButton) findViewById(R.id.backButton2);
        backButton2.setOnClickListener(this);



        databaseName = FirebaseDatabase.getInstance().getReference().child("recipes").child("0").child("Name");
        databaseCalories = FirebaseDatabase.getInstance().getReference().child("recipes").child("0").child("Calories");
        databaseIngredients = FirebaseDatabase.getInstance().getReference().child("recipes").child("0").child("Ingredients");
        databaseDirections = FirebaseDatabase.getInstance().getReference().child("recipes").child("0").child("Directions");


        databaseName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                Name.setText(text);
                //Calories.setText(text);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //database.child("recipes").child(userId).child("username").setValue(name);

    }

    @Override
    public void onClick(View view) {
        if(view == backButton2) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }


    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap>{
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();

                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }
}
