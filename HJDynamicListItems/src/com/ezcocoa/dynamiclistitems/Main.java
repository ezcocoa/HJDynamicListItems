package com.ezcocoa.dynamiclistitems;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

public class Main extends ListActivity {
    private static final String ITEM_KEY = "key";
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter adapter;
    private EditText editText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText = (EditText)findViewById(R.id.textEdit);
        this.adapter = new SimpleAdapter(this, list, R.layout.row, new String[] {ITEM_KEY},new int[] {R.id.listValue});
        setListAdapter(this.adapter);
        
        ((Button)findViewById(R.id.button)).setOnClickListener(getBtnClickListener());
    }

	private OnClickListener getBtnClickListener() {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				try{
					// Create HashMap OBJ. HashMap Class is structure of key and value.
					HashMap<String, String>item = new HashMap<String, String>();
					item.put(ITEM_KEY,editText.getText().toString());
					list.add(item);
					adapter.notifyDataSetChanged();
				} catch (NullPointerException e) {
					Log.i("Dynamic items","Tried to add null value");
				}
				
			}
			
		};
	}
    
    
}