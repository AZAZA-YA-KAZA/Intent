package com.example.intent;

import static com.example.intent.MainActivity.number;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivitySecondBinding;

public class secondActivity extends AppCompatActivity {
    final static int REQUESTCODEs = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TV.setText("ACTIVITY_2");
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number++;
                Intent intent = new Intent(secondActivity.this, thirdActivity.class);
                startActivityForResult(intent, REQUESTCODEs);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number++;
                Intent intent = new Intent(secondActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODEs);
            }
        });

        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number--;
                Intent intent = new Intent();
                intent.putExtra("key2", "Вы вышли из ACTIVITY2");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODEs && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
