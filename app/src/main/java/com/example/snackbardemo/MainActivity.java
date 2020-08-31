package com.example.snackbardemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coordinatorLayout = findViewById(R.id.coordinator);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               snackbar();
            }
        });

    }

    protected void snackbar(){
        Snackbar snackbar = Snackbar.make(coordinatorLayout,"SnackBar Ready ",Snackbar.LENGTH_INDEFINITE)
                .setAction("ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*Snackbar snackbar1 = Snackbar.make(coordinatorLayout,"after click action",Snackbar.LENGTH_SHORT);

                        snackbar1.show();
*/

                        String url = "http://www.tutorialspoint.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                     // we can also make an implicit intent to view any website
                        /// basically snackbar is very important for the user
                        // to make any decision , in Toast we show any message but we dont take any decision
                        // using snackbar we can make decision help of setAction method

                        //**************************** dependencies of material for coordinate layout
                    //    implementation "com.google.android.material:material:1.1.0-alpha06"


                    }
                }).setActionTextColor(Color.RED);


        View view = snackbar.getView();
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();

        params.gravity = Gravity.TOP;

        view.setLayoutParams(params);

        snackbar.show();
    }



}
