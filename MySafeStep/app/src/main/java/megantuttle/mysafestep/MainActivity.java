package megantuttle.mysafestep;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.*;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Set;


public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // setting up bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            //Device does not support bluetooth
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        //query paired devices
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // if there are paired devices
        if (pairedDevices.size() > 0) {
            // loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // add the name and address to an array adapter to show in a ListView
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }


        // discovering devices
        //Create a Broadcast Receiver for ACTION_FOUND
        private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                // when discovery finds a device
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // get the bluetoothdevice object from the intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // add the name and address to an array adapter to show in a listview
                    mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            }
        };
        // register the broadcast receiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy

        // enable discoverability
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    //Defining stuff
    public final static String EXTRA_MESSAGE = "megantuttle.mysafestep.MESSAGE";
/**
    //Called when the user clicks the Send button, the other activity pops up on screen
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
*/
    //Make a new activity to be called when a user clicks the Gait Tracker button
    public void gaitTracker(View view){
        Intent intent = new Intent(this, GaitTrackerActivity.class);
        startActivity(intent);
    }

    /**
     Here is the xml file for the message thingy
     <EditText android:id="@+id/edit_message"
     android:layout_width="0dp"
     android:layout_height="wrap_content"
     android:hint="@string/edit_message"
     android:layout_weight="1" />
     <Button
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:text="@string/button_send"
     android:onClick="sendMessage" />
     */

}
