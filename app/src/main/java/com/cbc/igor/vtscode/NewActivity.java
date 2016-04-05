package com.cbc.igor.vtscode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Igor on 11/25/2015.
 */
public class NewActivity extends Activity {

    int uslov = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

                Intent intent = getIntent();

                String Browser = intent.getStringExtra("Browser");
                String tag_lista = intent.getStringExtra("tag_list");
                String tag_description = intent.getStringExtra("tag_description");
                String filename = intent.getStringExtra("filename");

                uslov = intent.getIntExtra("uslov", 1);

                TextView tw0 = (TextView) findViewById(R.id.textView);
                TextView tw3 = (TextView)findViewById(R.id.textView3);
                TextView tw5 = (TextView)findViewById(R.id.textView5);

                TextView header_tw = (TextView) findViewById(R.id.header_tw1);

                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/courbd.ttf");

                AssetManager assetManager = getAssets();

                InputStream input;

                try {

                    input = assetManager.open(filename);
                    int size = input.available();
                    byte[] buffer =  new byte[size];
                    input.read(buffer);
                    input.close();

                    String text = new String(buffer);

                    tw5.setTypeface(typeface);

                    tw5.setText(text);

                } catch (Exception e){
                    e.printStackTrace();
                    tw5.setText("File not found!");
                    Toast.makeText(getBaseContext(), "File not found!", Toast.LENGTH_SHORT).show();
                }

        tw3.setText(tag_description);


        header_tw.setTypeface(typeface);
        header_tw.setText(tag_lista);

        StringBuilder sb = new StringBuilder();

        try {
            FileInputStream inputStream = openFileInput("u_html.txt");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(isr);

            String line;
            while ((line = bufferReader.readLine()) != null){
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            if(uslov == 0) {

                ImageView im3 = (ImageView) findViewById(R.id.im3);
                ImageView im4 = (ImageView) findViewById(R.id.im4);
                ImageView im5 = (ImageView) findViewById(R.id.im5);
                ImageView im6 = (ImageView) findViewById(R.id.im6);
                ImageView im7 = (ImageView) findViewById(R.id.im7);

                tw0.setText("Browser-i koji podržavaju ovaj element:");

                char[] str = Browser.toCharArray();

                if (str == null){
                    str[0] = '0';
                }

                for (int i = 0; i < Browser.length(); i++) {

                    switch (str[i]) {
                        case 'C':
                            im3.setImageDrawable(getResources().getDrawable(R.drawable.chrome));
                            //Toast.makeText(this, "Chrome", Toast.LENGTH_SHORT).show();
                            break;
                        case 'F':
                            im4.setImageDrawable(getResources().getDrawable(R.drawable.firefox));
                            //Toast.makeText(this, "Firefox", Toast.LENGTH_SHORT).show();
                            break;
                        case 'O':
                            im5.setImageDrawable(getResources().getDrawable(R.drawable.opera));
                            //Toast.makeText(this, "Opera", Toast.LENGTH_SHORT).show();
                            break;
                        case 'S':
                            im6.setImageDrawable(getResources().getDrawable(R.drawable.safari));
                            //Toast.makeText(this, "Safari", Toast.LENGTH_SHORT).show();
                            break;
                        case 'I':
                            im7.setImageDrawable(getResources().getDrawable(R.drawable.ie));
                            //Toast.makeText(this, "IExplorer", Toast.LENGTH_SHORT).show();
                            break;

                        case '0':
                            tw0.setText("");
                            i=Browser.length();
                            Toast.makeText(this, "Element NIJE podržan!", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(NewActivity.this, "Pogrešan browser!", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

    }
}
