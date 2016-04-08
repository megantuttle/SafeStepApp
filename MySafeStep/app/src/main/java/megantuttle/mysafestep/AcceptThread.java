package megantuttle.mysafestep;

import android.bluetooth.*;

import java.io.IOException;

/** Making a class that will implement a Bluetooth server
 * Created by megan on 4/7/16.
 */
public class AcceptThread extends Thread {
    private final BluetoothServerSocket mmServerSocket;

    public AcceptThread() {
        // use a temporary object that is later assigned to mmServerSocket,
        // because mmServerSocket is final
        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID <megantuttle.mysafestep> is the app's UUID string, also used by the client code
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, megantuttle.mysafestep);
        } catch (IOException e) { }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        // keep listening until exception occurs or a socket is returned
        while (true) {
            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                break;
            }

            // if a connection was accepted
            if (socket != null) {
                // do work to manage the connection (in a separate thread)
                manageConnectedSocket(socket);
                mmServerSocket.close();
                break;
            }
        }
    }

    // cancel the listening socket and cause the thread to finish
    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
}
