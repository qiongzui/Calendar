package com.zzh.calendar.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Switch;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.zzh.calendar.MainActivity;
import com.zzh.calendar.R;
import com.zzh.calendar.db.DateRecord;
import com.zzh.calendar.parameter.Parameter;
import com.zzh.calendar.util.ShowLog;

import org.litepal.crud.DataSupport;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.R.id.list;
import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class DateFragment extends Fragment implements View.OnClickListener{
    private MaterialCalendarView calendarView;
    private Switch carSwitch;

    private String dateTime;
    private String date_last;

    private LocalBroadcastManager localBroadcastManager;

    private boolean isSwitch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.date_context , container , false);

        calendarView = (MaterialCalendarView) view.findViewById(R.id.calendar_view);
        carSwitch = (Switch)view.findViewById(R.id.iscar_switch);

        carSwitch.setOnClickListener(this);

        //配置日历
        calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .commit();
        calendarView.setSelectedDate(Calendar.getInstance());
        //记录上次查看日期
        CalendarDay lastDay = calendarView.getCurrentDate();
        date_last = lastDay.getYear() + "-" + lastDay.getMonth() + "-" + lastDay.getDay();

        //日期改变
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                dateTime = date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
                if (!dateTime.equals(date_last)){
                    ShowLog.d("calendar" , "date is " + dateTime);
                    EventFragment eventFragment = (EventFragment)getFragmentManager().findFragmentById(R.id.event_fragment);
                    DateRecord dateRecord = (DateRecord)loadEvent(dateTime);
                    if (dateRecord != null){
                        eventFragment.refresh(dateRecord);
                    }
                }


            }
        });


        localBroadcastManager = LocalBroadcastManager.getInstance(this.getActivity());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iscar_switch:
                isSwitch = carSwitch.isChecked();
                sendLocalBroadCast(isSwitch);
                break;
            default:
        }
    }

    private void sendLocalBroadCast(boolean isSwitch){
        String action;
        if (isSwitch == true){
            action = Parameter.BORADCAST_OPEN;
        }else
            action = Parameter.BORADCAST_CLOSE;

        Intent intent = new Intent( action );
        localBroadcastManager.sendBroadcast(intent);
    }

    private Object loadEvent(String dateTime){
        String list[] = dateTime.split("-");
        String year = list[0];
        String month = list[1];
        String day = list[2];

        List<DateRecord> dateRecords = DataSupport.where("year = ? and month = ? and day = ?",year,month,day).find(DateRecord.class);
        if (dateRecords.size() > 0){
            DateRecord dateRecord = dateRecords.get(0);
            return dateRecord;
        }else
            return null;

    }

}
