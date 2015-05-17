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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Addnames extends Activity {

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
			View nv = li.inflate(R.layout.mylayout, null);
			TextView tv = (TextView)nv.findViewById(R.id.textView1);
			tv.setText(b[pos].getName());
			tv.setHint(pos+"");
			
			
			return nv;
		}
		
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		
				int f=0;
				BluetoothDevice k[]=new BluetoothDevice[b.length-1];
				for(int i=0;i<b.length;i++)
				{
					if(i!=onposition)
					{k[f]=b[i];
					f++;
					}
					
				}
				b=k;
				
				lv.setAdapter(new Addnames.MyArrarAdapter<BluetoothDevice>(Addnames.this, android.R.layout.simple_list_item_1,b));
				lv.setOnItemClickListener(new OnItemClickListener() {
					@Override
					    public void onItemClick(AdapterView<?> adapter, View view, int position, long arg)   {

					    // TODO Auto-generated method stub
					    Intent im=new Intent(Addnames.this,Form.class);
					    im.putExtra("objectform", b[position]);
					    onposition=position;
					     startActivityForResult(im, 567);
					     
					    }
					});
				
				
			
		
		
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addnames);
		Intent in = getIntent();
		ArrayList<BluetoothDevice> list=in.getParcelableArrayListExtra("dm");
	
	
		
		
		lv = (ListView)findViewById(R.id.list);
		
		 b=new BluetoothDevice[list.size()];
		for(int i=0;i<list.size();i++)
		{
			b[i]=list.get(i);
		}
		if(b!=null)
		{lv.setAdapter(new Addnames.MyArrarAdapter<BluetoothDevice>(this, android.R.layout.simple_list_item_1,b));
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			    public void onItemClick(AdapterView<?> adapter, View view, int position, long arg)   {

			    // TODO Auto-generated method stub
			    Intent im=new Intent(Addnames.this,Form.class);
			    im.putExtra("objectform", b[position]);
			    onposition=position;
			     startActivityForResult(im, 567);
			     
			    }
			});

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addnames, menu);
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
