package digitalhouse.android.a0317moacns1c_02.Activities;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.R;

public class ImageViewActivity extends AppCompatActivity {

    public static final String IMAGE_PATH_KEY = "imagePath";
    public static final String LANDSCAPE_KEY = "landscape";

    @BindView(R.id.imageViewImageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        Boolean landscape = bundle.getBoolean(LANDSCAPE_KEY);
        landscape = landscape == null ? false : landscape;
        if (landscape) {
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        String imagePath = bundle.getString(IMAGE_PATH_KEY);
        String imageURL = ImageHelper.getOriginalSizeURL(imagePath);
        Picasso.with(this).load(imageURL).fit().centerInside().into(imageView);
    }
}
