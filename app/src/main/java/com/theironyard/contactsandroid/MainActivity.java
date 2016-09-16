
package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ArrayAdapter<String> items;
    ListView listView;
    EditText name;
    EditText phone;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);

        items =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(items);


    }

    @Override
    public void onClick(View v) {
        String text = String.format("%s %s", name.getText().toString(), phone.getText().toString());
        items.add(text);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String itemToRemove = items.getItem(position);
        items.remove(itemToRemove);
        return true;
    }
}