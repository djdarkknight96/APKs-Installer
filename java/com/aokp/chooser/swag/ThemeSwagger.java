package com.aokp.chooser.swag;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import com.faizmalkani.floatingactionbutton.FloatingActionButton;
public class ThemeSwagger extends Activity {
	FloatingActionButton mFab;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swagger);
        getActionBar().setTitle(Html.fromHtml("<font color='#baf13d'>AOKP Theme by EnricoD</font>"));
        getActionBar().setIcon(R.color.trasparent);
        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("Loading...");
        dialog.setCanceledOnTouchOutside(false);
        
        mFab = (FloatingActionButton) findViewById(R.id.fabbutton);
    }
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101){
            File file =  new File(getExternalFilesDir(null),"xyz.apk");
            if(file!=null)
                file.delete();
        }
    }
    public void fabClicked(View view) {
    	startActivity(new Intent(this, InfoActivity.class));
    }
    public void installOne(View v){
        Installer i = new Installer();
        i.execute("one.apk");
    }
    public void installTwo(View v){
        Installer i = new Installer();
        i.execute("two.apk");
    }
    public void install(String name){
        AssetManager assetManager = getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(name);
            out = new FileOutputStream( new File(getExternalFilesDir(null),"xyz.apk") );
            byte[] buffer = new byte[1024];
            int read;
            while((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(new File(getExternalFilesDir(null), "xyz.apk")),
                    "application/vnd.android.package-archive");
            startActivityForResult(intent, 101);
        } catch(Exception e) { e.printStackTrace(); }
    }
    private class Installer extends AsyncTask<String,Void,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }
        @Override
        protected Boolean doInBackground(final String... strings) {
            install(strings[0]);
            return true;
        }
        @Override
        protected void onPostExecute(final Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            dialog.cancel();
        }
    }
}
