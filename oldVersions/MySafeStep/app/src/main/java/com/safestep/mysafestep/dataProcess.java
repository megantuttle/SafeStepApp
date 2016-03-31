package com.safestep.mysafestep;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by megan on 2/24/16.
 */
public class dataProcess {


    private Context mContext;

    public dataProcess(Context context) {
        this.mContext = context;
    }

    public List<String> readLine(String path) {
        List<String> mData = new ArrayList<>();

        AssetManager am = mContext.getAssets();

        try {
            InputStream is = am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                mData.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mData;
    }
}

/*

public static final String TAG = MainActivity.class.getSimpleName();

public static final String mPath = "data.txt";
private dataProcess mdataProcess;
private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdataProcess = new dataProcess(this);
        mData = mdataProcess.readLine(mPath);
        for (String string : mData)
            Log.d(TAG, string);
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
    }*/
