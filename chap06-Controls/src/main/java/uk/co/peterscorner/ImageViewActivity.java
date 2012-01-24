package uk.co.peterscorner;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);

        ImageView imgView = (ImageView)findViewById(R.id.image3);
        
        imgView.setImageResource(R.drawable.icon);
        
        imgView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.manatee02));

        /* For these last 2 images to work, you need to provide link to existing images on your device
        * and either test it with device connected with IDE or manually upload application
        * on memory card and then install*/
        imgView.setImageDrawable(Drawable.createFromPath("/mnt/sdcard/dave2.jpg"));
        imgView.setImageURI(Uri.parse("file://mnt/sdcard/dave2.jpg"));
    }
}

