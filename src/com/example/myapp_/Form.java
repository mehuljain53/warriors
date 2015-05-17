package com.example.myapp_;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Form extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
	}
	public void pressSubmit(View v)
	{
		EditText t1=(EditText) findViewById(R.id.editform1);
		EditText t2=(EditText)findViewById(R.id.editform2);
		Intent ini=getIntent();
		BluetoothDevice bb=ini.getParcelableExtra("objectform");
		String s1=t1.getText().toString();
		String s2=t2.getText().toString();
		if(s1!=null&&s2!=null)
		{
			
			strings.putOurname( s1);
			strings.putrollno( s2);
			strings.putBluename( bb.getName());
			strings.puthardname( bb.getAddress());
			strings.inclength();
			//Toast.makeText(getApplicationContext(), bb.getAddress(),Toast.LENGTH_LONG).show();
			
			Toast.makeText(this, "Data is Stored", Toast.LENGTH_LONG).show();
			setResult(200);
			finish();
			
		}
		else
		{
			Toast.makeText(this, "Please enter data ", Toast.LENGTH_LONG).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form, menu);
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
