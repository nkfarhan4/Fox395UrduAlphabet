package com.app.urduqaida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.app.urduqaida.R;

public class SplashActivity extends Activity{

	private static final long SPLASHTIME = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	Intent intent = new Intent(SplashActivity.this,MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
            }
        }, SPLASHTIME);
	}
}
