package com.example.myapp_;

import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Attendance extends Activity {

	ListView lv ;
	int onposition;
	BluetoothDevice b[];
	class MyArrarAdapter<T> extends ArrayAdapter<T>
	{
		
		public MyArrarAdapter(Context context, int resource,
			T[] objects) {
			super(context, resource, objects);
			
		}
		@Override
		public View getView(int pos, View v,ViewGroup g)
		{
			LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View nv = li.inflate(R.layout.att_check, null);
			TextView tv = (TextView)nv.findViewById(R.id.textView2);
			tv.setText(strings.getOurname(pos));
			
			
			
			return nv;
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance);
		Intent in = getIntent();
		ArrayList<BluetoothDevice> list=in.getParcelableArrayListExtra("dam");
	  
	
		
		
		lv = (ListView)findViewById(R.id.list1);
		
		 b=new BluetoothDevice[list.size()];
		for(int i=0;i<list.size();i++)
		{
			b[i]=list.get(i);
			  

		}
		lv.setAdapter(new Attendance.MyArrarAdapter<BluetoothDevice>(this, android.R.layout.simple_list_item_1,b));
	     Toast.makeText(this,"percentage of attendance  "+(list.size()*100.0)/strings.getlength(),Toast.LENGTH_LONG);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attendance, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
