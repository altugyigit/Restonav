package com.altygtsoft.restonav;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exitFunc()
    {
        final AlertDialog.Builder adialogBuilder = new AlertDialog.Builder(this);

        adialogBuilder.setTitle("Çıkış");
        adialogBuilder.setMessage("Çıkmak istiyor musunuz ?");
        adialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.this.finishAffinity();

            }
        });
        adialogBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        final AlertDialog adialog = adialogBuilder.create();
        adialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int _id = item.getItemId();

        if (_id == R.id.itemCancel)
        {
            exitFunc();//Cikis
        }
        if(_id == R.id.itemInfo)
        {
            Toast _toast = Toast.makeText(MainActivity.this, "Portaloji Yazılım\nGörüşleriniz ve önerileriniz için bilgi@portaloji.com", Toast.LENGTH_LONG);
            TextView _tw = (TextView) _toast.getView().findViewById(android.R.id.message);
            if( _tw != null) _tw.setGravity(Gravity.CENTER);
            _toast.show();
        }

        return super.onOptionsItemSelected(item);

    }
}
