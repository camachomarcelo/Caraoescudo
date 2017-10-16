package com.dranser.caraoescudo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private ImageView moneda;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneda = (ImageView) findViewById(R.id.moneda);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girarMoneda();
            }
        });
    }

    private void girarMoneda(){
        final Animation desaparecer = new AlphaAnimation(1, 0);
        desaparecer.setInterpolator(new AccelerateInterpolator());
        desaparecer.setDuration(1000);
        desaparecer.setFillAfter(true);
        desaparecer.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                moneda.setImageResource(RANDOM.nextFloat() > 0.5f ? R.drawable.escudo : R.drawable.cara);

                Animation aparecer = new AlphaAnimation(1, 0);
                desaparecer.setInterpolator(new DecelerateInterpolator());
                desaparecer.setDuration(3000);
                desaparecer.setFillAfter(true);

                moneda.startAnimation(aparecer);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        moneda.startAnimation(desaparecer);
    }

}
