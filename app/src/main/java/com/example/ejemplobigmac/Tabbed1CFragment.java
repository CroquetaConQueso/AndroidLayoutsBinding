package com.example.ejemplobigmac;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;

public class Tabbed1CFragment extends Fragment {
    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater i, @Nullable ViewGroup c, @Nullable Bundle b) {
        android.widget.TextView tv = new android.widget.TextView(requireContext());
        tv.setText("Contenido TAB C");
        tv.setGravity(android.view.Gravity.CENTER);
        return tv;
    }
}
