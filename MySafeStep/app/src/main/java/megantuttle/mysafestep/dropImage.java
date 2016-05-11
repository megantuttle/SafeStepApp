package megantuttle.mysafestep;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by tuttlem on 5/11/2016.
 */
public class dropImage extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_stuff);
        ImageView imageView = (ImageView) findViewById(R.id.drop_image);
        imageView.setImageResource(R.drawable.force_drop);
    }

}
