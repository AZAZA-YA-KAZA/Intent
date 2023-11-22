package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.intent.databinding.ActivitySecondBinding;
import com.example.intent.databinding.ActivityThirdBinding;

public class thirdActivity extends AppCompatActivity {
    final static int REQUESTCODEss = 1423;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.TV.setText("ACTIVITY_3");
        binding.BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number++;
                Intent intent = new Intent(thirdActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });
        binding.BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number++;
                Intent intent = new Intent(thirdActivity.this, secondActivity.class);
                startActivityForResult(intent, REQUESTCODEss);
            }
        });

        binding.BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = getIntent();
                int number = intentt.getIntExtra("number", 0);
                number--;
                Intent intent = new Intent();
                intent.putExtra("key2", "Вы вышли из ACTIVITY3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODEss && resultCode == RESULT_OK) {
            String str = data.getStringExtra("key2");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }
}