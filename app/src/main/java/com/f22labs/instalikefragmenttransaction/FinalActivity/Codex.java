package com.f22labs.instalikefragmenttransaction.FinalActivity;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.fragments.BaseFragment;
import com.f22labs.instalikefragmenttransaction.fragments.HomeFragment;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterContacts;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterEvents;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.f22labs.instalikefragmenttransaction.fragments.BaseFragment.ARGS_INSTANCE;

public class Codex extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_codex, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    public static Codex newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        Codex fragment = new Codex();
        fragment.setArguments(args);
        return fragment;
    }
}
