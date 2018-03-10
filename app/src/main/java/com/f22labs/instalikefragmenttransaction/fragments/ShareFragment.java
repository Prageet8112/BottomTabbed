package com.f22labs.instalikefragmenttransaction.fragments;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.f22labs.instalikefragmenttransaction.Data.Contact_Data;
import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterContacts;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterEvents;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShareFragment extends BaseFragment{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_share, container, false);

        ButterKnife.bind(this, rootView);

        ( (MainActivity)getActivity()).updateToolbarTitle("Contacts");

        ListView lv = (ListView) rootView.findViewById(R.id.contactlist);

        CustomAdapterContacts adapter = new CustomAdapterContacts(this.getActivity(),getContacts());

        lv.setAdapter(adapter);


        return rootView;
    }

    private ArrayList<Contact_Data> getContacts()
    {
        ArrayList<Contact_Data> arrayContacts = new ArrayList<>();
        Contact_Data cd;

        cd = new Contact_Data("Prageet N. Gupta","Head Coordinator",R.drawable.tab_profile,R.drawable.call);
        arrayContacts.add(cd);

        cd = new Contact_Data("Deepesh gupta","Head Coordinator",R.drawable.tab_profile,R.drawable.call);
        arrayContacts.add(cd);
        cd = new Contact_Data("Prageet N. Gupta","Head Coordinator",R.drawable.tab_profile,R.drawable.call);
        arrayContacts.add(cd);
        cd = new Contact_Data("Prageet N. Gupta","Head Coordinator",R.drawable.tab_profile,R.drawable.call);
        arrayContacts.add(cd);
        cd = new Contact_Data("Prageet N. Gupta","Head Coordinator",R.drawable.tab_profile,R.drawable.call);
        arrayContacts.add(cd);

        return arrayContacts;

    }


}
