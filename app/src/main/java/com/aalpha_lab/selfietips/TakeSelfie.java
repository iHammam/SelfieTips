package com.aalpha_lab.selfietips;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TakeSelfie extends AppCompatActivity {

    Button btnTackPic;
    TextView tvHasCamera, tvHasCameraApp;
    ImageView ivThumbnailPhoto;
    Bitmap bitMap;
    static int TAKE_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_selfie);

        // Get reference to views
        tvHasCamera = (TextView) findViewById(R.id.tvHasCamera);
        tvHasCameraApp = (TextView) findViewById(R.id.tvHasCameraApp);
        btnTackPic = (Button) findViewById(R.id.button_take_selfie);
        ivThumbnailPhoto = (ImageView) findViewById(R.id.ivThumbnailPhoto);

        // Does your device have a camera?
        if (hasCamera()) {
            tvHasCamera.setBackgroundColor(0xFF00CC00);
            tvHasCamera.setText("WOW! You have a Camera.");
        }

        // Do you have Camera Apps?
        if (hasDefaultCameraApp(MediaStore.ACTION_IMAGE_CAPTURE)) {
            tvHasCameraApp.setBackgroundColor(0xFF00CC00);
            tvHasCameraApp.setText("And you have CameraApps too!");
        }

        // add onclick listener to the button
//        btnTackPic.setOnClickListener(this);

    }

    // on button "btnTackPic" is clicked
    public void onBtnClick(View view) {

        // create intent with ACTION_IMAGE_CAPTURE action
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // to save picture
//        File file = new File(Environment.getExternalStorageDirectory(),
//                "my-photo.jpg");
//        Uri photoPath = Uri.fromFile(file);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);

        // start camera activity
        startActivityForResult(intent, TAKE_PICTURE);

    }

    // The Android Camera application encodes the photo in the return Intent delivered to
    // onActivityResult()
    // as a small Bitmap in the extras, under the key "data"
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK && intent != null) {
            // get bundle
            Bundle extras = intent.getExtras();

            // get data
            bitMap = (Bitmap) extras.get("data");
            ivThumbnailPhoto.setImageBitmap(bitMap);

        }
    }

    // method to check you have a Camera
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    // method to check you have Camera Apps
    private boolean hasDefaultCameraApp(String action) {
        final PackageManager packageManager = getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return list.size() > 0;

    }

}
