package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivityMainBinding;
import com.example.intent.databinding.ActivitySecondBinding;

public class MainActivity extends AppCompatActivity {
    final static int REQUESTCODE = 1234;
    public static int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (number == 0){
            binding.BT3.setVisibility(View.GONE);
        }
        else {
            binding.BT3.setVisibility(View.VISIBLE);
        }
        binding.TV.setText("ACTIVITY_1");
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                Intent intentt = new Intent(MainActivity.this, secondActivity.class);
                intentt.putExtra("number", number);
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                Intent intentt = new Intent(MainActivity.this, secondActivity.class);
                intentt.putExtra("number", number);
                Intent intent = new Intent(MainActivity.this, thirdActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(MainActivity.this, secondActivity.class);
                intentt.putExtra("number", number);
                number--;
                Intent intent = new Intent();
                intent.putExtra("key2", "Вы вышли из ACTIVITY1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}