package com.gzeinnumer.mylibautotextviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.gzeinnumer.mylibautotextview.AdapterAutoCompleteText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSingleObject();
        initMultiObject();
    }

    private void initSingleObject() {
        AutoCompleteTextView act = findViewById(R.id.act_1);

        ArrayList<String> listString = new ArrayList<String>();
        listString.add("Satu");
        listString.add("Dua");
        listString.add("Tiga");
        listString.add("Empat");

        AdapterAutoCompleteText<String> adapter = new AdapterAutoCompleteText<String>(getApplicationContext(), listString);
        //adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
        act.setAdapter(adapter);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act.setText(listString.get(position).toString(), false);
            }
        });
    }

    private void initMultiObject() {
        AutoCompleteTextView act = findViewById(R.id.act_2);

        ArrayList<ExampleModel> listObject = new ArrayList<>();
        listObject.add(new ExampleModel(1, "Zein", "Balbar"));
        listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
        listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
        listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

        AdapterAutoCompleteText<ExampleModel> adapter = new AdapterAutoCompleteText<ExampleModel>(getApplicationContext(), listObject);
        //adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
        act.setAdapter(adapter);

        act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                act.setText(listObject.get(position).toString(), false);
            }
        });
    }
}