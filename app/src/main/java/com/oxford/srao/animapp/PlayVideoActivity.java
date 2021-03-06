package com.oxford.srao.animapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;
import static org.bytedeco.javacpp.opencv_core.inRange;
import static org.bytedeco.javacpp.opencv_imgproc.circle;
import static org.bytedeco.javacpp.opencv_imgproc.contourArea;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.findContours;
import static org.bytedeco.javacpp.opencv_imgproc.minEnclosingCircle;
import static org.bytedeco.javacpp.opencv_imgproc.moments;
import static org.bytedeco.javacpp.opencv_imgproc.resize;

public class PlayVideoActivity extends Activity {
    public String selectedFile;
    int H_MIN;
    int S_MIN;
    int V_MIN;
    int H_MAX;
    int S_MAX;
    int V_MAX;
    boolean isChecked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        selectedFile = getIntent().getStringExtra("uri");
        H_MIN = getIntent().getIntExtra("Hmin", 0);
        S_MIN = getIntent().getIntExtra("Smin", 0);
        V_MIN = getIntent().getIntExtra("Vmin", 0);
        H_MAX = getIntent().getIntExtra("Hmax", 180);
        S_MAX = getIntent().getIntExtra("Smax", 255);
        V_MAX = getIntent().getIntExtra("Vmax", 30);
        isChecked = getIntent().getBooleanExtra("isChecked", false);
        Log.i(TAG, selectedFile.toString());
        CanvasView canvasView = (CanvasView) findViewById(R.id.cvVideo);
        canvasView.uri = Uri.parse(selectedFile);
        canvasView.H_MIN = H_MIN;
        canvasView.S_MIN = S_MIN;
        canvasView.V_MIN = V_MIN;
        canvasView.H_MAX = H_MAX;
        canvasView.S_MAX = S_MAX;
        canvasView.V_MAX = V_MAX;
        canvasView.isChecked = isChecked;
    }

}


