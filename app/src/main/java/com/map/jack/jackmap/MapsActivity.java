package com.map.jack.jackmap;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener listener;
    private float last_x, last_y, last_z;

    long lastUpdateTime = 0;

//    /* put this into your activity class */
//    private SensorManager mSensorManager;
//    private float mAccel; // acceleration apart from gravity
//    private float mAccelCurrent; // current acceleration including gravity
//    private float mAccelLast; // last acceleration including gravity
//
//    private final SensorEventListener mSensorListener = new SensorEventListener() {
//        public void onSensorChanged(SensorEvent se) {
//            float x = se.values[0];
//            float y = se.values[1];
//            float z = se.values[2];
//            mAccelLast = mAccelCurrent;
//            mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
//            float delta = mAccelCurrent - mAccelLast;
//            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
//        }
//
//        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//        }
//    };
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mSensorManager.registerListener(mSensorListener,
//                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
//                SensorManager.SENSOR_DELAY_NORMAL);
//    }
//
//    @Override
//    protected void onPause() {
//        mSensorManager.unregisterListener(mSensorListener);
//        super.onPause();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //https://www.youtube.com/watch?v=rrC2ceMYT5o

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


//         /* do this in onCreate */
//        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        mSensorManager.registerListener(mSensorListener,
//                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
//                SensorManager.SENSOR_DELAY_NORMAL);
//        mAccel = 0.00f;
//        mAccelCurrent = SensorManager.GRAVITY_EARTH;
//        mAccelLast = SensorManager.GRAVITY_EARTH;
//
//        // Setup the sensor
//        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
//        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

//    public void onSensorChanged(SensorEvent event) {
//        Sensor sensor = event.sensor;
//        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//            float x = event.values[0];
//            float y = event.values[1];
//            float z = event.values[2];
//
//            long currentTime = System.currentTimeMillis();
//
//            if (Math.abs(currentTime - lastUpdateTime) > 2000) {
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                    SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//                    String currentDateTime = date.format(new Date());
//                    lastUpdateTime = currentTime;
//
//                    if (Math.abs(last_x - x) > 10) {
//                        mMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.23092, -80.72481))
//                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
//                                .title("Hey, you moved the x axis on:" + currentDateTime));
//                    }
//
//                    last_x = x;
//
//                    if (Math.abs(last_y - y) > 10) {
//                        mMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.26092, -80.72881))
//                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
//                                .title("Hey, you moved the y axis on:" + currentDateTime));
//                    }
//
//                    last_y = y;
//
//                    if (Math.abs(last_z - z) > 10) {
//                        mMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(37.25092, -80.726481))
//                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
//                                .title("Hey, you moved the z axis on:" + currentDateTime));
//                    }
//
//                    last_z = z;
//                }
//            }
//        }
//    }
//
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(33.966535, -117.739228);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17));
    }
}
