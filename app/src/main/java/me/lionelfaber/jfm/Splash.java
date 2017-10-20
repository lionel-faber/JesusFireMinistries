package me.lionelfaber.jfm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by lionel on 10/6/17.
 */

public class Splash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 2500;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);
        ImageView logo = (ImageView)findViewById(R.id.logo);
        Glide.with(this).load(R.drawable.jfmlogo).into(logo);
        TextView title = (TextView)findViewById(R.id.title);

        Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/ERASDEMI.TTF");
        title.setTextColor(Color.WHITE);
        title.setTextSize(60);
        title.setTypeface(tf);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
//                Toast.makeText(getApplication(), "Done", Toast.LENGTH_LONG).show();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
