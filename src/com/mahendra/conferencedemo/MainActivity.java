package com.mahendra.conferencedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.internal.telephony.ITelephony;

public class MainActivity extends Activity {

	Button conferenceButton;
	ITelephony phone = ITelephony.Stub.asInterface(
		    ServiceManager.getService(Context.TELEPHONY_SERVICE)
		);
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conferenceButton = (Button) findViewById(R.id.conferenceButton);
        conferenceButton.setOnClickListener(conferenceButtonClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private View.OnClickListener conferenceButtonClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			try {
				phone.call("1234567890");
				
//				 PhoneApp app = PhoneApp.getInstance();
//				 // As managing conference is only valid for GSM and not for CDMA
//				 if (app.phone.getPhoneName().equals("GSM")) {
//					 mInCallMenuView.addItemView(mManageConference, 0);
//				 }
//				 mInCallMenuView.addItemView(mShowDialpad, 0);
				 
			} catch (RemoteException e) {
				Log.d("mahendra", "Exception while calling the number");
				e.printStackTrace();
			}
		}
	};
}
