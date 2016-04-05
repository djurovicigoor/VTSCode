package com.cbc.igor.vtscode;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Igor on 1/6/2016.
 */
public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_dialog);



        Button zatvori = (Button) findViewById(R.id.zatvori);

        zatvori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton rb = (RadioButton) findViewById(R.id.radioButton);
                RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
                RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
                RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
                RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
                RadioButton rb6 = (RadioButton)findViewById(R.id.radioButton6);
                RadioButton rb7 = (RadioButton)findViewById(R.id.radioButton7);
                RadioButton rb8 = (RadioButton)findViewById(R.id.radioButton8);
                RadioButton rb9 = (RadioButton)findViewById(R.id.radioButton9);
                RadioButton rb10 = (RadioButton) findViewById(R.id.radioButton10);

                if (rb.isChecked()==true){
                    Toast.makeText(Settings.this, "Izabrali ste 'HTML' za početni jezik!", Toast.LENGTH_SHORT).show();

                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 0);
                    editor.commit();
                } else if (rb2.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'CSS' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 1);
                    editor.commit();
                } else if (rb3.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'JavaScript' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 2);
                    editor.commit();
                } else if (rb4.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'jQuery za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 3);
                    editor.commit();
                } else if (rb5.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'XML' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 4);
                    editor.commit();
                } else if (rb6.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'SQL' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 5);
                    editor.commit();
                } else if (rb7.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'C++' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 6);
                    editor.commit();
                } else if (rb8.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'C#' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 7);
                    editor.commit();
                } else if (rb9.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'Java' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 8);
                    editor.commit();
                } else if (rb10.isChecked() == true){
                    Toast.makeText(Settings.this, "Izabrali ste 'PHP' za početni jezik!", Toast.LENGTH_SHORT).show();
                    SharedPreferences settings = getSharedPreferences("login", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("default_fragment", 9);
                    editor.commit();
                }

                Intent returnBtn = new Intent(getApplicationContext(),MainActivity.class);
                returnBtn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(returnBtn);
                finish();
            }

        });
    }
}
