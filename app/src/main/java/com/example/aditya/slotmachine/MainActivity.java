package com.example.aditya.slotmachine;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    Button Play, option1, option2, option3;
    ImageView image1, image2, image3;
    final String[] ans = {""};

    HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Play = (Button) findViewById(R.id.playBtn);
        option1 = (Button) findViewById(R.id.opt1);
        option2 = (Button) findViewById(R.id.opt2);
        option3 = (Button) findViewById(R.id.opt3);

        image1 = (ImageView) findViewById(R.id.imgleft);
        image2 = (ImageView) findViewById(R.id.imgcent);
        image3 = (ImageView) findViewById(R.id.imgright);

        hmap.put(1, "Bear");
        hmap.put(2, "Dog");
        hmap.put(3, "Tiger");

        final Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        rotate.setAnimationListener(this);

        final MediaPlayer win = MediaPlayer.create(getApplicationContext(), R.raw.win);
        final MediaPlayer lose = MediaPlayer.create(getApplicationContext(), R.raw.lose);

        final int[] playClicked = {0};

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playClicked[0] = 1;

                image1.startAnimation(rotate);
                image2.startAnimation(rotate);
                image3.startAnimation(rotate);
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playClicked[0] == 1){
                    String clickTxt = option1.getText().toString();
                    if(clickTxt.equals(ans[0])){
                        win.start();
                    }
                    else {
                        lose.start();
                    }
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playClicked[0] == 1){
                    String clickTxt = option2.getText().toString();
                    if(clickTxt.equals(ans[0])){
                        win.start();
                    }
                    else {
                        lose.start();
                    }
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playClicked[0] == 1){
                    String clickTxt = option3.getText().toString();
                    if(clickTxt.equals(ans[0])){
                        win.start();
                    }
                    else {
                        lose.start();
                    }
                }
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Play.setEnabled(false);
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        final int[] imagesb = {R.drawable.bear_01, R.drawable.bear_02, R.drawable.bear_03};
        final int[] imagesd = {R.drawable.dog_01, R.drawable.dog_02, R.drawable.dog_03};
        final int[] imagest = {R.drawable.tiger_01, R.drawable.tiger_02, R.drawable.tiger_03};

        Play.setEnabled(true);
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);

        option1.setText(hmap.get(1));
        option2.setText(hmap.get(2));
        option3.setText(hmap.get(3));

        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);

        Random rand = new Random();
        int number = rand.nextInt(3) + 1;

        switch (number){
            case 1:
                image1.setImageResource(imagest[0]);
                image3.setImageResource(imagest[1]);
                image2.setImageResource(imagest[2]);
                ans[0] = "Tiger";
                break;

            case 2:
                image1.setImageResource(imagesb[0]);
                image3.setImageResource(imagesb[1]);
                image2.setImageResource(imagesb[2]);
                ans[0] = "Bear";
                break;

            case 3:
                image1.setImageResource(imagesd[0]);
                image3.setImageResource(imagesd[1]);
                image2.setImageResource(imagesd[2]);
                ans[0] = "Dog";
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
