package com.example.phototest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class HomeActivity extends AppCompatActivity {

    private String URLToNekoWeb = "studioklondike.itch.io/nekojishi";
    private String phoneNumber = "tel: +52 5518478021";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewNeko = findViewById(R.id.imgViewNeko);
        Button btnChangeImage = findViewById(R.id.btnChangeImage);
        Button btnCall = findViewById(R.id.btnCall);
        LinearLayout llActions = findViewById(R.id.llActions);
        LinearLayout llLogin = findViewById(R.id.llLogin);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnPassword = findViewById(R.id.btnPassword);

        /**
         * Funcion para el fake login
         */
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = etPassword.getText().toString();
                if(password.equals("1407")) {
                    llLogin.setVisibility(view.GONE);
                    llActions.setVisibility(view.VISIBLE);
                }
                else
                    Toast.makeText(HomeActivity.this, "Ptsss is 1407", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Funcion para llamar
         */
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
        });


        /**
         * Funcion para abrir la web
         */
        imageViewNeko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(!URLToNekoWeb.contains("https://"))
                    if (!URLToNekoWeb.contains("http://"))
                        URLToNekoWeb = "http://" + URLToNekoWeb;
                intent.setData(Uri.parse(URLToNekoWeb));
                startActivity(intent);

            }
        });

        /**
         * Funcion para cambiar la imagen
         */
        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hacemos getResources()... por que tod o lo que este bajo R regresa un int
                //Entonces debemos convertir el int R.drawable.neko2 en un objeto Drawable
                //imageViewNeko.setImageDrawable(R.drawable.neko2);
                //imageViewNeko.setImageDrawable(getResources().getDrawable(R.drawable.neko2));

                //GLIDE API PARA IMAGENES
                Glide.with(HomeActivity.this).load("https://steamcdn-a.akamaihd.net/steam/apps/570840/logo.png?t=1574384831").into(imageViewNeko);
            }
        });
    }
}