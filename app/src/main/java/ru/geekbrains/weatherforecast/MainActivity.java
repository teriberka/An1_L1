package ru.geekbrains.weatherforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "INFO";
    private TextView temperatureTextView;
    private Button updateTemperatureBtn;

    private final String temperatureDataKey = "temperatureDataKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setOnClickToUpdateBtn();

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart: some info");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume: some info");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause: some info");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop: some info");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy: some info");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle saveInstanceState) {
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        String text = temperatureTextView.getText().toString();
        saveInstanceState.putString(temperatureDataKey, text);
        saveInstanceState.putSerializable("someKey", DataContainer.getInstance());

        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = savedInstanceState.getString(temperatureDataKey);
        temperatureTextView.setText(text);

        //DataContainer container = (DataContainer)savedInstanceState.getSerializable("someKey");
    }

    private void findViews() {
        temperatureTextView = findViewById(R.id.textViewTemperature);
        updateTemperatureBtn = findViewById(R.id.buttonUpdate);
    }

    private void setOnClickToUpdateBtn() {
        updateTemperatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(temperatureTextView.getText().toString());
                String newValue = String.valueOf(++count);
                temperatureTextView.setText(newValue);
            }
        });
    }

}