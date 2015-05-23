package com.app.urduqaida;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends Activity implements OnTouchListener , android.view.View.OnClickListener{

	private static float x1;
	private static ImageView img;
	private static RelativeLayout rel , rel_ad;
	private int width, widthChangeLeft ,widthChangeRight , noShown = 0;
	static MediaPlayer mp;
	private ImageView imgPrev, imgNext;
	AlertDialog.Builder alertDialog;
	AlertDialog dialog;
	int maincounter=0;
	InterstitialAd interstitial;
	com.google.android.gms.ads.AdRequest adRequest;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		interstitial = new InterstitialAd(MainActivity.this);
		interstitial.setAdUnitId("ca-app-pub-1878227272753934/3306814800");

		rel_ad = (RelativeLayout) findViewById(R.id.rel_top);
		AdView adView = (AdView) findViewById(R.id.adView);
		// Request for Ads
		adRequest = new com.google.android.gms.ads.AdRequest.Builder()
				.build();

		// Load ads into Banner Ads
		adView.loadAd(adRequest);

		alertDialog = new AlertDialog.Builder(MainActivity.this);

		img = (ImageView) findViewById(R.id.img);
		rel = (RelativeLayout) findViewById(R.id.rel_middle);
		imgNext = (ImageView) findViewById(R.id.imageViewNext);
		imgPrev = (ImageView) findViewById(R.id.imageViewPrev);
		imgNext.setOnClickListener(this);
		imgPrev.setOnClickListener(this);
		img.setOnClickListener(this);
		rel.setOnTouchListener(this);
		getWindowWidth();
		mp = MediaPlayer.create(this, R.raw.one);
		mp.start();

		alert();
		//add();
	}

	private void alert() {
		alertDialog.setIcon(R.drawable.urdu_small).setTitle("Really Exit?").
		setMessage("Are you sure you want to Exit?")
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				MainActivity.this.finish();
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		dialog = alertDialog.create();
	}

	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
			//isAdLod=true;
		}
	}

	@Override
	public void onBackPressed() {
		dialog.show();
		return;
	}

	private void getWindowWidth() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		width = displaymetrics.widthPixels;
		widthChangeRight = (width/2)+20;
		widthChangeLeft = (width/2)-20;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK))
		{

		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onTouch(View v, MotionEvent touchevent) {
		switch (touchevent.getAction()) {
		case MotionEvent.ACTION_DOWN:
		{
			x1 = touchevent.getX();
			if (x1 < widthChangeLeft)
			{
				if(noShown == 36){
					layoutNo(noShown = 0, this);
				}else{
					layoutNo(noShown = noShown + 1, this);
				}
			}

			if (x1 > widthChangeRight)
			{
				if(noShown == 0){
					layoutNo(noShown = 36, this);
				}else{
					layoutNo(noShown = noShown - 1, this);
				}
			}
			break;
		}
		default:
			break;
		}
		return false;
	}

	private static void layoutNo(int no, Context context){
		switch (no) {
		case 0:
			img.setBackgroundResource(R.drawable.one);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.one);
			mp.start();
			break;
		case 36:
			img.setBackgroundResource(R.drawable.two);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.two);
			mp.start();
			break;
		case 35:
			img.setBackgroundResource(R.drawable.three);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.three);
			mp.start();
			break;
		case 34:
			img.setBackgroundResource(R.drawable.four);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.four);
			mp.start();
			break;
		case 33:
			img.setBackgroundResource(R.drawable.five);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.five);
			mp.start();
			break;
		case 32:
			img.setBackgroundResource(R.drawable.six);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.six);
			mp.start();
			break;
		case 31:
			img.setBackgroundResource(R.drawable.seven);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.seven);
			mp.start();
			break;
		case 30:
			img.setBackgroundResource(R.drawable.eight);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.eight);
			mp.start();
			break;
		case 29:
			img.setBackgroundResource(R.drawable.nine);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.nine);
			mp.start();
			break;
		case 28:
			img.setBackgroundResource(R.drawable.ten);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.ten);
			mp.start();
			break;
		case 27:
			img.setBackgroundResource(R.drawable.eleven);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.eleven);
			mp.start();
			break;
		case 26:
			img.setBackgroundResource(R.drawable.twelve);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twelve);
			mp.start();
			break;
		case 25:
			img.setBackgroundResource(R.drawable.thirteen);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirteen);
			mp.start();
			break;
		case 24:
			img.setBackgroundResource(R.drawable.fourteen);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.fourteen);
			mp.start();
			break;
		case 23:
			img.setBackgroundResource(R.drawable.fifteen);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.fifteen);
			mp.start();
			break;
		case 22:
			img.setBackgroundResource(R.drawable.sixteen);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.sixteen);
			mp.start();
			break;
		case 21:
			img.setBackgroundResource(R.drawable.seventeen);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.seventeen);
			mp.start();
			break;
		case 20:
			img.setBackgroundResource(R.drawable.eighteen);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.eighteen);
			mp.start();
			break;
		case 19:
			img.setBackgroundResource(R.drawable.ninteen);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.nineteen);
			mp.start();
			break;
		case 18:
			img.setBackgroundResource(R.drawable.tweenty);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twenty);
			mp.start();
			break;
		case 17:
			img.setBackgroundResource(R.drawable.tweentyone);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentyone);
			mp.start();
			break;
		case 16:
			img.setBackgroundResource(R.drawable.tweentytwo);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentytwo);
			mp.start();
			break;
		case 15:
			img.setBackgroundResource(R.drawable.tweentythree);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentythree);
			mp.start();
			break;
		case 14:
			img.setBackgroundResource(R.drawable.tweentyfour);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentyfour);
			mp.start();
			break;
		case 13:
			img.setBackgroundResource(R.drawable.tweentyfive);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentyfive);
			mp.start();
			break;
		case 12:
			img.setBackgroundResource(R.drawable.tweentysix);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentysix);
			mp.start();
			break;
		case 11:
			img.setBackgroundResource(R.drawable.tweentyseven);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentyseven);
			mp.start();
			break;
		case 10:
			img.setBackgroundResource(R.drawable.tweentyeight);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentyeight);
			mp.start();
			break;
		case 9:
			img.setBackgroundResource(R.drawable.tweentynine);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.twentynine);
			mp.start();			
			break;
		case 8:
			img.setBackgroundResource(R.drawable.thirty);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirty);
			mp.start();
			break;
		case 7:
			img.setBackgroundResource(R.drawable.thirtyone);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtyone);
			mp.start();
			break;
		case 6:
			img.setBackgroundResource(R.drawable.thirtytwo);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtytwo);
			mp.start();
			break;
		case 5:
			img.setBackgroundResource(R.drawable.thirtythree);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtythree);
			mp.start();
			break;
		case 4:
			img.setBackgroundResource(R.drawable.thirtyfour);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtyfour);
			mp.start();
			break;
		case 3:
			img.setBackgroundResource(R.drawable.thirtyfive);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtyfive);
			mp.start();
			break;
		case 2:
			img.setBackgroundResource(R.drawable.thirtysix);
			rel.setBackgroundResource(R.drawable.card_backgroundtwo);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtysix);
			mp.start();
			break;
		case 1:
			img.setBackgroundResource(R.drawable.thirtyseven);
			rel.setBackgroundResource(R.drawable.card_background);
			mp.release();
			mp = MediaPlayer.create(context, R.raw.thirtyseven);
			mp.start();
			break;
		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageViewNext:
			maincounter +=1;

			if(maincounter==6){
				// Load ads into Interstitial Ads
				interstitial.loadAd(adRequest);
				// Prepare an Interstitial Ad Listener
				interstitial.setAdListener(new AdListener() {
					public void onAdLoaded() {
						// Call displayInterstitial() function
						maincounter=0;
						displayInterstitial();

					}
				});


			}


			if(noShown == 36){
				layoutNo(noShown = 0, this);
			}else{
				layoutNo(noShown = noShown + 1, this);
			}
			break;
		case R.id.imageViewPrev:
			maincounter+=1;

			if(maincounter==6){
				// Load ads into Interstitial Ads
				interstitial.loadAd(adRequest);
				// Prepare an Interstitial Ad Listener
				interstitial.setAdListener(new AdListener() {
					public void onAdLoaded() {
						// Call displayInterstitial() function
						maincounter=0;
						displayInterstitial();

					}
				});


			}

			if(noShown == 0){
				layoutNo(noShown = 36, this);
			}else{
				layoutNo(noShown = noShown - 1, this);
			}
			break;
		case R.id.img:
			if(mp.isPlaying()){
				mp.stop();
			}else{
				mp.start();
			}
			break;
		default:
			break;
		}
	}
}
