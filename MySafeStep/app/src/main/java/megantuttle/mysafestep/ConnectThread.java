package megantuttle.mysafestep;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;

/**  Creating a Bluetooth client
 * Created by megan on 4/7/16.
 */
public class ConnectThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;

    public ConnectThread(BluetoothDevice device) {
        // use a temporary object that is later assigned to mmSocket b/c mmSocket is final
        BluetoothSocket tmp = null;
        mmDevice = device;

        // get a BluetoothSocket to connect with the given Bluetooth Device
        try {
            // MY_UUID is megantuttle.mysafestep
            tmp = device.createRfcommSocketToServiceRecord(megantuttle.mysafestep);
        } catch (IOException e) { }
        mmSocket = tmp;
    }

    public void run() {
        // cancel discovery b/c it will slow down the connection
        mBluetoothAdapter.cancelDiscovery();

        try {
            // connect the device through the socket. this will block until it succeeds or throws exception
            mmSocket.connect();
        } catch (IOException connectException) {
            // unable to connect; close the socket and get out
            try {
                mmSocket.close();
            } catch (IOException closeException) { }
            return;
        }

        //Do work to manage the connection (in a separate thread)
        manageConnectedSocket(mmSocket);
    }

    // will cancel an in-progress connection, and close the socket
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }
}
