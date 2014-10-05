package com.aokp.chooser.swag;


import main.java.de.psdev.licensesdialog.LicensesDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.MenuItem;
import android.widget.Toast;

public class InfoActivity extends PreferenceActivity{

	Preference lice, developer, developer2, rush, anand, pla, aokp, kiern;
	
	Context context;
	Intent intent;

	

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.info_pref);
		
		
        getActionBar().setDisplayHomeAsUpEnabled(true);	
        getActionBar().setTitle("About");	
       
		context = getBaseContext();
				
		lice = (Preference) this.findPreference("lic1");
		lice.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick(Preference preference) {				
				LicensesDialog licdial = new LicensesDialog(InfoActivity.this, R.raw.notices, false, true);			
		        licdial.show();
			return false;
			}
		});

		aokp = (Preference) this.findPreference("aokappa");
		aokp.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://aokp.co/"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
		
		kiern = (Preference) this.findPreference("moore");
		kiern.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/+KiernanMoore/posts"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
		
		pla = (Preference) this.findPreference("thaplash");
		pla.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thaphlash.com/"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
		
		rush = (Preference) this.findPreference("rush");
		rush.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=4337046"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
		
		anand = (Preference) this.findPreference("bibek");
		anand.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/+AnandaBibek"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});

		developer = (Preference) this.findPreference("buddy1");
		
		developer.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=4884893"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
		
        developer2 = (Preference) this.findPreference("buddy2");
		
		developer2.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			public boolean onPreferenceClick (Preference preference) {
			// TODO Auto-generated method stub
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://forum.xda-developers.com/member.php?u=5266287"));
			if(intent != null) {
				startActivity(intent);
			} else {
				Toast.makeText(InfoActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
			}
			return false;
				}
			});
				
	}
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			switch (item.getItemId()) {

			case android.R.id.home:
				// app icon in action bar clicked; finish activity to go home
				finish();
				return true;
			}
			return super.onOptionsItemSelected(item);
		}
}
