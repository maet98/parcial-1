package com.pucmm.parcial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "INFO";
    TextView infoText;
    TextView internalCode;
    TextView version;
    TextView releaseDate;
    CheckBox supported;

    private PlaceholderContent.PlaceholderVersion info;

    public InfoFragment() {
    }

    public static InfoFragment newInstance(int index) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int index = getArguments().getInt("INFO");
            System.out.println(index);
            info = PlaceholderContent.ITEMS.get(index);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        infoText = view.findViewById(R.id.infoText);
        version = view.findViewById(R.id.Version);
        internalCode = view.findViewById(R.id.InternalCode);
        releaseDate = view.findViewById(R.id.releaseDate);
        supported = view.findViewById(R.id.supported);
        supported.setClickable(false);
        System.out.println(info);
        //infoText.setText(info.getDetails());
        Button btnLink = view.findViewById(R.id.linkBtn);
        btnLink.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(info.getLink()));
            startActivity(intent);
        });
        return view;
    }

    public void newInfo(PlaceholderContent.PlaceholderVersion info) {
        this.info = info;
        infoText.setText(info.getDetails());
        internalCode.setText("Internal Code: \t" + info.getInternalCodeName());
        version.setText("Version: \t" + info.getVersionNumber());
        releaseDate.setText("Release Date: \t" + info.getReleaseDate());
        supported.setChecked(info.isSupported());
    }



}