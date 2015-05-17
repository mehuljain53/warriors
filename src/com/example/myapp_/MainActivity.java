package com.example.myapp_;

import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	 ArrayList<BluetoothDevice> deviceList=new ArrayList<BluetoothDevice>(); 
	 ArrayList<BluetoothDevice> devicein=new ArrayList<BluetoothDevice>(); 

	static final int ENABLE_BLUETOOTH=1;
	BluetoothAdapter ad= BluetoothAdapter.getDefaultAdapter();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		IntentFilter filter = new IntentFilter();
		 
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		 
		registerReceiver(mReceiver, filter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void add(View v)
	{
		deviceList=new ArrayList<BluetoothDevice>(); 
		
		initBluetooth();
		Button b=(Button)findViewById(R.id.formbutton);
		b.setClickable(false);
         
		
		
	}
	
	public void initBluetooth()
	{
		if(!ad.isEnabled())
		{
			Intent intent= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent, ENABLE_BLUETOOTH );
			
			
		}
		else
		{
			ad.startDiscovery();
						//Toast.makeText(this, "button is pressed", Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	protected void onActivityResult(int requestcode,int resultcode,Intent data)
	{
		if(requestcode==ENABLE_BLUETOOTH)
			if(resultcode== RESULT_OK)
			{
				
				
				ad.startDiscovery();
			
				
			}
			else
			{
				Toast. makeText(this,"closing the app ", Toast.LENGTH_LONG).show();
			}
		
	}
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
 
            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                //discovery starts, we can show progress dialog or perform other tasks
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                //discovery finishes, dismis progress dialog
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                       //bluetooth device found
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                int m;
                for(m=0;m<strings.getlength();m++)
                {
                	if(strings.hardname(m).equals(device.getAddress()))
                	     {
                		   devicein.add(device);
                		   break;
                	     }
                }
                if(m==strings.getlength())
                	deviceList.add(device);
                Toast.makeText(getApplicationContext(),device.getName(),Toast.LENGTH_SHORT).show();
                
            }
        }
    };
      public void start(View v)
      {
    	  Intent in = new Intent(this,Addnames.class);
  		//in.putParcelableArrayListExtra("dm", deviceList);
    	  in.putExtra("dm", deviceList);
  		startActivity(in);
  		deviceList=new ArrayList<BluetoothDevice>();
  		Button b=(Button)findViewById(R.id.formbutton);
		b.setClickable(true);
  		
      }
      public void checking(View v)
      {
  		//deviceList=new ArrayList<BluetoothDevice>(); 

    	 /* initBluetooth();
    	  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	 /* ArrayList<BluetoothDevice> h= new ArrayList<BluetoothDevice>();
    	  for(int i=0;i<strings.getlength();i++)
    	  {
    		  for(int j=0;j<devicein.size();j++)
    		  {
    			  if(devicein.get(j).getAddress().equals(strings.hardname(i)))
    			  { h.add(devicein.get(j));
    			  break;
    			  }
    			  
    		  }
    	  }*/
    	  Intent in = new Intent(this,Attendance.class);
  		//in.putParcelableArrayListExtra("dm", deviceList);
    	  in.putExtra("dam", devicein);
  		startActivity(in);
  		devicein=new ArrayList<BluetoothDevice>();
  		Button b=(Button)findViewById(R.id.formbutton);
		b.setClickable(true);
    	  
    	  
      }
	
}