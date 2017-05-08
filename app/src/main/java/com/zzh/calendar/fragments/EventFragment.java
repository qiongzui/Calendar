package com.zzh.calendar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zzh.calendar.R;
import com.zzh.calendar.db.DateRecord;

/**
 * Created by Administrator on 2017/4/26 0026.
 */

public class EventFragment extends Fragment {
    private EditText moneyEdit;
    private EditText noteEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_context , container , false);

        moneyEdit = (EditText)view.findViewById(R.id.money_edit);
        noteEdit = (EditText)view.findViewById(R.id.notes_edit);

        return view;
    }

    public EditText getMoneyEdit() {
        return moneyEdit;
    }

    public EditText getNoteEdit() {
        return noteEdit;
    }

    public void refresh(DateRecord dateRecord){
        moneyEdit.setText(dateRecord.getMoney());
        noteEdit.setText(dateRecord.getEvent());
    }
}
