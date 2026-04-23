package com.hifly.chaquopy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;


public class MainActivity extends AppCompatActivity {
	
	private GeckoView geckoView;
	private GeckoSession geckoSession;
	private static GeckoRuntime runtime; // reuse runtime
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		geckoView = new GeckoView(this,null);
		
		setContentView(geckoView);
		
		//geckoView = findViewById(R.id.engineView);
		
		// Create runtime only once
		if (runtime == null) {
			runtime = GeckoRuntime.create(this);
		}
		
		// Create session
		geckoSession = new GeckoSession();
		
		// Open session with runtime
		geckoSession.open(runtime);
		
		// Attach session to GeckoView
		geckoView.setSession(geckoSession);
		
		// Load URL
		geckoSession.loadUri("https://www.google.com");
	}
}