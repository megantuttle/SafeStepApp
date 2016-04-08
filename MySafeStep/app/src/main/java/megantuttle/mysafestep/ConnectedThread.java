package megantuttle.mysafestep;

import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** managing bluetooth data connection stuff
 * Created by megan on 4/7/16.
 */
public class ConnectedThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final InputStream mmInStream;
    private final OutputStream mmOutStream;

    public ConnectedThread(BluetoothSocket socket) {
        mmSocket = socket;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;

        // get the input and output streams using temp objects because member streams are final
        try {
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();
        } catch (IOException e) { }

        mmInStream = tmpIn;
        mmOutStream = tmpOut;
    }

    public void run() {
        byte[] buffer = new byte[1024]; // buffer store for the stream
        int bytes; // bytes returned from read()

        // keep listening to the inputstream until an exception occurs
        while (true) {
            try {
                // read from the inputstream
                bytes = mmInStream.read(buffer);
                // send the obtained bytes to the UI activity
                mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer).sendToTarget();
            } catch (IOException e) {
                break;
            }
        }
    }

    // call this from the main activity to send data to the remote device
    public void write(byte[] bytes) {
        try {
            mmOutStream.write(bytes);
        } catch (IOException e) { }
    }

    // call this from the main activity to shutdown the connection
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }
}
