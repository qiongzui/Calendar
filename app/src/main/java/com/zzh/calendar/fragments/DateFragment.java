package com.zzh.calendar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Switch;

import com.zzh.calendar.R;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class DateFragment extends Fragment implements View.OnClickListener{
    private CalendarView calendarView;
    private Switch carSwitch;

    private boolean isSwitch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_context , container , false);

        calendarView = (CalendarView)view.findViewById(R.id.calendar_view);
        carSwitch = (Switch)view.findViewById(R.id.iscar_switch);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calendar_view:
                break;
            case R.id.iscar_switch:
                isSwitch = carSwitch.isChecked();
                break;
            default:
        }
    }


}
