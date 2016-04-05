package com.cbc.igor.vtscode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Igor on 11/2/2015.
 */
public class ContainerFragment extends Fragment {

    private Adapter Adapter;
    private int fragmentarray;
    private int fragmentarray_opis;

    public ContainerFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        Bundle b = getArguments();
        fragmentarray = b.getInt("lista");
        fragmentarray_opis = b.getInt("opislista");

        final String jezik = b.getString("jezik");
        View v = inflater.inflate(R.layout.container_fragment,container,false);
        Adapter = new Adapter(getActivity(),fragmentarray_opis,fragmentarray);
        final ListView listView = (ListView)getActivity().findViewById(R.id.listView) ;

        listView.setAdapter(Adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String tag_list;
                String tag_description;
                String BSupport;
                String filename;

                Bundle bundle = new Bundle();
                Intent intent = new Intent(getContext(), NewActivity.class);

                switch (jezik) {
                    case "html":
                        tag_list = getResources().getStringArray(R.array.html)[position];
                        tag_description = getResources().getStringArray(R.array.html_explanation)[position];
                        BSupport = getResources().getStringArray(R.array.html_browser)[position];
                        filename = getResources().getStringArray(R.array.html_tagname)[position];

                        bundle.putString("Browser", BSupport);
                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);
                        bundle.putInt("uslov", 0);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "css":
                        tag_list = getResources().getStringArray(R.array.css)[position];
                        tag_description = getResources().getStringArray(R.array.css_explanation)[position];

                        showMyCustomDialog(tag_list, tag_description);
                        break;

                    case "javascript":
                        tag_list = getResources().getStringArray(R.array.javascript)[position];
                        tag_description = getResources().getStringArray(R.array.javascript_explanation)[position];
                        filename = getResources().getStringArray(R.array.javascript_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename" , filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "jquery":
                        tag_list = getResources().getStringArray(R.array.jquery)[position];
                        tag_description = getResources().getStringArray(R.array.jquery_explanation)[position];
                        filename = getResources().getStringArray(R.array.jquery_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "sql":
                        tag_list = getResources().getStringArray(R.array.sql)[position];
                        tag_description = getResources().getStringArray(R.array.sql_explanation)[position];
                        filename = getResources().getStringArray(R.array.sql_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "cpp":
                        tag_list = getResources().getStringArray(R.array.cpp)[position];
                        tag_description = getResources().getStringArray(R.array.cpp_explanation)[position];
                        filename = getResources().getStringArray(R.array.cpp_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "csh":
                        tag_list = getResources().getStringArray(R.array.csharp)[position];
                        tag_description = getResources().getStringArray(R.array.csharp_explanation)[position];
                        filename = getResources().getStringArray(R.array.csharp_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "java":
                        tag_list = getResources().getStringArray(R.array.java)[position];
                        tag_description = getResources().getStringArray(R.array.java_explanation)[position];
                        filename = getResources().getStringArray(R.array.java_filename)[position];

                        bundle.putString("tag_list", tag_list);
                        bundle.putString("tag_description", tag_description);
                        bundle.putString("filename", filename);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                    case "php":
                        tag_list = getResources().getStringArray(R.array.php)[position];
                        tag_description = getResources().getStringArray(R.array.php_explanation)[position];

                        showMyCustomDialog(tag_list, tag_description);
                        break;

                    default:
                        Toast.makeText(getContext(), "Loš izbor!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return v;
    }

    /*Metoda koja prikazuje novi Dialog sa CUSTOM podacima za odredjeni programski jezik
    * prosledjuju joj se dva parametara tipa String */
    private void showMyCustomDialog(String tag_list, String tag_description){

        final Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.dialog);
        dialog.setTitle(tag_list);

        TextView dialog_text = (TextView) dialog.findViewById(R.id.dialog_opis);
        dialog_text.setText(tag_description);

        Button okButton = (Button) dialog.findViewById(R.id.dialog_button);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}