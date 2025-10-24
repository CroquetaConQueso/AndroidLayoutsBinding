package com.example.ejemplobigmac;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ejemplobigmac.databinding.ActivityTabbedBinding;

public class TabbedActivity extends AppCompatActivity {
    private ActivityTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityTabbedBinding.inflate(getLayoutInflater())).getRoot());
    }
}
