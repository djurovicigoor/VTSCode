package com.cbc.igor.vtscode;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Igor on 11/2/2015.
 */
public class MainActivity  extends AppCompatActivity{

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {

        SharedPreferences save = getSharedPreferences("login", Activity.MODE_PRIVATE);
        int default_fragment = save.getInt("default_fragment", 0);

            switch (default_fragment){
                case 0:
                    changeFragment(R.array.html, R.array.html_explanation, "html");
                    break;

                case 1:
                    changeFragment(R.array.css, R.array.css_explanation, "css");
                    break;

                case 2:
                    changeFragment(R.array.javascript, R.array.java_explanation, "javascript");
                    break;

                case 3:
                    changeFragment(R.array.jquery, R.array.jquery_explanation, "jquery");
                    break;

               /* case 4:
                    changeFragment(R.array.xml, R.array.xml_explanation, "xml");
                    break;*/

                case 5:
                    changeFragment(R.array.sql, R.array.sql_explanation, "sql");
                    break;

                case 6:
                    changeFragment(R.array.cpp, R.array.cpp_explanation, "cpp");
                    break;

                case 7:
                    changeFragment(R.array.csharp, R.array.csharp_explanation, "csh");
                    break;

                case 8:
                    changeFragment(R.array.java, R.array.java_explanation, "java");
                    break;

                case 9:
                    changeFragment(R.array.php, R.array.php_explanation, "php");
                    break;

                default:
                    changeFragment(R.array.html, R.array.html_explanation, "html");
                    break;
            }
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }

                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {

                    case R.id.html:
                        //Toast.makeText(getApplicationContext(),"HTML Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.html, R.array.html_explanation, "html");
                        //startHTML();
                        return true;

                    case R.id.css:
                        //Toast.makeText(getApplicationContext(),"CSS Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.css, R.array.css_explanation, "css");
                        //startCSS();
                        return true;

                    case R.id.javascript:
                        //Toast.makeText(getApplicationContext(),"JavaScript Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.javascript, R.array.java_explanation, "javascript");
                        //startJavaScript();
                        return true;

                    case R.id.jquery:
                        //Toast.makeText(getApplicationContext(),"jQuery Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.jquery, R.array.jquery_explanation, "jquery");
                        return true;

                    /*case R.id.xml:
                        //Toast.makeText(getApplicationContext(),"XML Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.xml, R.array.xml_explanation, "xml");
                        return true;*/

                    case R.id.sql:
                        //Toast.makeText(getApplicationContext(),"SQL Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.sql, R.array.sql_explanation, "sql");
                        return true;

                    case R.id.cplusplus:
                        //Toast.makeText(getApplicationContext(),"C++ Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.cpp, R.array.cpp_explanation, "cpp");
                        return true;

                    case R.id.csharp:
                        //Toast.makeText(getApplicationContext(),"C# Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.csharp, R.array.csharp_explanation, "csh");
                        return true;

                    case R.id.java:
                        //Toast.makeText(getApplicationContext(),"Java Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.java, R.array.java_explanation, "java");
                        return true;

                    case R.id.php:
                        //Toast.makeText(getApplicationContext(),"PHP Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(R.array.php, R.array.php_explanation, "php");
                        return true;

                    case R.id.aboutus:

                        Intent intent = new Intent(MainActivity.this, AboutUs.class);
                        intent.setAction(Intent.ACTION_VIEW);
                        startActivity(intent);
                        return true;

                    case R.id.settings:

                        Intent intent1 = new Intent(getBaseContext(), Settings.class);
                        startActivity(intent1);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Greška!", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }

        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
    }
    /* Metoda koja pita korisnika da li je siguran da zeli da napusti aplikaciju */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.quit)
                    .setMessage(R.string.quit_message)
                    .setPositiveButton("Da", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                            MainActivity.this.finish();
                        }

                    })
                    .setNegativeButton("Ne", null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }

    }

    public void changeFragment(int lista , int opislista , String jezik ){
        Bundle bundle = new Bundle();
        bundle.putInt("lista", lista);
        bundle.putInt("opislista", opislista);
        bundle.putString("jezik", jezik);

        ContainerFragment fragment = new ContainerFragment();
        fragment.setArguments(bundle);

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame , fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       /* int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}