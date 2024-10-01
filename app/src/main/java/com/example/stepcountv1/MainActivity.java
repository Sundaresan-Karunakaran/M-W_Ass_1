package com.example.stepcountv1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int stepCounter = 0;
    private TextView showCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showCount = (TextView) findViewById(R.id.textView);
    }

    public void startCount(View view) {
        Toast toast = Toast.makeText(this, R.string.counterStarted, Toast.LENGTH_LONG);
        showCount.setText(String.format(("0")));
        stepCounter=0;
        toast.show();
    }

    public void countUP(View view) {
        stepCounter+=1;
        showCount.setText(String.format("%d",stepCounter));
    }
}