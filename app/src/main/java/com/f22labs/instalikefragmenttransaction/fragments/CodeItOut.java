/*package com.f22labs.instalikefragmenttransaction.subGroupAct;

import android.support.annotation.Nullable;
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

public class CodeItOut extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_code_it_out, container, false);

        ButterKnife.bind(this, rootView);

        return rootView;
    }

    public static CodeItOut newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        CodeItOut fragment = new CodeItOut();
        fragment.setArguments(args);
        return fragment;
    }
}*/
package com.f22labs.instalikefragmenttransaction.fragments;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
        import com.f22labs.instalikefragmenttransaction.FinalActivity.Codex;
        import com.f22labs.instalikefragmenttransaction.R;
        import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
        import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterEvents;

        import java.util.ArrayList;

        import butterknife.BindView;
        import butterknife.ButterKnife;


public class CodeItOut extends BaseFragment {


    @BindView(R.id.btn1)
    Button btnClickMe;
    ListView lv;
    CustomAdapterEvents adapter;

    int fragCount;


    public static CodeItOut newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        CodeItOut fragment = new CodeItOut();
        fragment.setArguments(args);
        return fragment;
    }


    public CodeItOut() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_code_it_out, container, false);


        ButterKnife.bind(this, rootView);

        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }

/*
        lv = (ListView) rootView.findViewById(R.id.frag1list);

        adapter = new CustomAdapterEvents(this.getActivity(),getEvents());

        lv.setAdapter(adapter);*/

        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mFragmentNavigation != null) {

                    mFragmentNavigation.pushFragment(Codex.newInstance(fragCount+1));

                }
            }
        });

        /*

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),"Working",Toast.LENGTH_SHORT).show();
            }
        });*/

      /*  Event_Data ed = (Event_Data) lv.getSelectedItem();

        final String selected1 = ed.getName1();
        final String selected2 = ed.getName2();



      //  Toast.makeText(view.getContext(),selected1 + " " + selected2 , Toast.LENGTH_SHORT);

         /*lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  if(selected1.equalsIgnoreCase("code it out"))
                {
                    Toast.makeText(view.getContext(),selected1 + " " + selected2 , Toast.LENGTH_SHORT);
                }
            }
        });*/

      /*  view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(selected2.equalsIgnoreCase("animated"))
                {
                 //   mFragmentNavigation.pushFragment(HomeFragment.newInstance(fragCount + 1));
                    Toast.makeText(view.getContext(),selected1 + " " + selected2 , Toast.LENGTH_SHORT).show();
                }
            }
        });
        */




        ( (MainActivity)getActivity()).updateToolbarTitle((fragCount == 0) ? "Home" :"Sub Home" + (fragCount + 1));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private ArrayList<Event_Data> getEvents()
    {
        ArrayList<Event_Data> arrayEvents = new ArrayList<>();

        Event_Data ed = new Event_Data("Code it Out",R.drawable.login1,"Fry the Bread Board",R.drawable.login1);
        arrayEvents.add(ed);
        ed = new Event_Data("Fun with Bots",R.drawable.login1,"Present And Exhibit",R.drawable.login1);
        arrayEvents.add(ed);
        ed = new Event_Data("ECell ",R.drawable.login1,"Animated",R.drawable.login1);
        arrayEvents.add(ed);
        ed = new Event_Data("Quizacal.ly",R.drawable.login1,"Why so Serious??",R.drawable.login1);
        arrayEvents.add(ed);

        return arrayEvents;

    }
}
