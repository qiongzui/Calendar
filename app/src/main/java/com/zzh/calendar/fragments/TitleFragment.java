package com.zzh.calendar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zzh.calendar.R;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class TitleFragment extends Fragment implements View.OnClickListener{
    private Button prevButton;
    private Button nextButton;
    private TextView titleText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_title , container , false );
        prevButton = (Button)view.findViewById(R.id.previous_month_btn);
        nextButton = (Button)view.findViewById(R.id.next_month_btn);
        titleText = (TextView)view.findViewById(R.id.month_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        titleText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_month_btn:
                break;
            case R.id.next_month_btn:
                break;
            case R.id.month_text:
                break;
            default:
        }
    }
}
