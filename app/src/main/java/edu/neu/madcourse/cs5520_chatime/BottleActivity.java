package edu.neu.madcourse.cs5520_chatime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.xml.sax.Locator;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BottleActivity extends AppCompatActivity {

    private TextView txtLatitude, txtLongitude;
    private EditText txtBottle;
    private Button sendBottleBtn;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private String key_latitude = "key_1", key_longitude = "key_2", key_message = "key_2";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle);

        txtLatitude = findViewById(R.id.latitude);
        txtLongitude = findViewById(R.id.longitude);
        txtBottle = findViewById(R.id.bottle_message);
        sendBottleBtn = findViewById(R.id.send_bottle_Btn);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if(savedInstanceState != null){
            txtLatitude.setText((savedInstanceState.getString(key_latitude)));
            txtLongitude.setText((savedInstanceState.getString(key_longitude)));
        }

        if (ActivityCompat.checkSelfPermission(BottleActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            getLocation();
        }

        else {
            ActivityCompat.requestPermissions(BottleActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        sendBottleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = txtBottle.getText().toString();
                Intent intent = new Intent(BottleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location != null){
                    try {
                        Geocoder geocoder = new Geocoder(BottleActivity.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(),location.getLongitude(),1);
                        txtLatitude.setText("Latitude: \n" + addresses.get(0).getLatitude()
                        );
                        txtLongitude.setText("Longitude: \n" + addresses.get(0).getLongitude() //TODO: May need to Add Country Code or String here
                        );

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(key_message, txtBottle.getText().toString());
        savedInstanceState.putString(key_latitude, txtLatitude.getText().toString());
        savedInstanceState.putString(key_longitude, txtLongitude.getText().toString());
    }
}