package com.safestep.megan.safestep;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash);
	   
	    Thread timer= new Thread()
		{

			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				
				try
				{
					sleep(2000);
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					
				}
				finally
				{
					Intent sta2= new Intent(Splash.this,MainActivity.class);
					startActivity(sta2);
					
				}
			
				
				
			}
		
		};
		timer.start();
		
	}
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}


	

}
