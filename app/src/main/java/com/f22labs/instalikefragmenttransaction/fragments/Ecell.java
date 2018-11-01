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

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.transition.AutoTransition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.f22labs.instalikefragmenttransaction.Data.SubActData;
import com.f22labs.instalikefragmenttransaction.DetailsTransition;
import com.f22labs.instalikefragmenttransaction.FinalActivity.Admad;
import com.f22labs.instalikefragmenttransaction.FinalActivity.BizQuiz;
import com.f22labs.instalikefragmenttransaction.FinalActivity.CodeWars3;
import com.f22labs.instalikefragmenttransaction.FinalActivity.Codex;
import com.f22labs.instalikefragmenttransaction.FinalActivity.FreshersCodeZone;
import com.f22labs.instalikefragmenttransaction.FinalActivity.PitchStart;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterSubAct;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class Ecell extends BaseFragment {


    ListView lv;
    CustomAdapterSubAct adapter;
    ImageView arr;
    int fragCount;


    public static Ecell newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        Ecell fragment = new Ecell();
        fragment.setArguments(args);
        return fragment;
    }


    public Ecell() {
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


        lv = (ListView) rootView.findViewById(R.id.subActList);

        adapter = new CustomAdapterSubAct(this.getActivity() , getSubActivity());

        lv.setAdapter(adapter);

        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Admad admad = Admad.newInstance(0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        admad.setSharedElementEnterTransition(new DetailsTransition());
                        admad.setEnterTransition(new AutoTransition());
                        admad.setExitTransition(new AutoTransition());
                        admad.setSharedElementReturnTransition(new DetailsTransition());
                    }

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                         //   .addSharedElement(adapter.subactimage , "kittens")
                           // .replace(R.id.relative1,freshersCodeZone)
                           // .addToBackStack("This is to")
                            .commit();

                      mFragmentNavigation.pushFragment(admad);
                    ((MainActivity)getActivity()).updateToolbarTitle("Admad");

                }

                if(i==1)
                {
                    BizQuiz bizQuiz = BizQuiz.newInstance(0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        bizQuiz.setSharedElementEnterTransition(new DetailsTransition());
                        bizQuiz.setEnterTransition(new AutoTransition());
                        bizQuiz.setExitTransition(new AutoTransition());
                        bizQuiz.setSharedElementReturnTransition(new DetailsTransition());
                    }

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                           // .addSharedElement((ImageView)adapter.subactimage , "kittens")
                          //  .replace(R.id.relative1,codex)
                          //  .addToBackStack("This is to")
                            .commit();

                     mFragmentNavigation.pushFragment(bizQuiz);
                    ((MainActivity)getActivity()).updateToolbarTitle("Biz  Quiz");

                }

                if(i==2)
                {
                    PitchStart pitchStart = PitchStart.newInstance(0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        pitchStart.setSharedElementEnterTransition(new DetailsTransition());
                        pitchStart.setEnterTransition(new AutoTransition());
                        pitchStart.setExitTransition(new AutoTransition());
                        pitchStart.setSharedElementReturnTransition(new DetailsTransition());
                    }

                    mFragmentNavigation.pushFragment(pitchStart);
                    ((MainActivity)getActivity()).updateToolbarTitle("Pitch Start");
                }

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private ArrayList<SubActData> getSubActivity()
    {
        ArrayList<SubActData> arrayEvents = new ArrayList<>();

        SubActData ed = new SubActData("Admad",R.drawable.admad);
        arrayEvents.add(ed);

        ed = new SubActData("Biz Quiz",R.drawable.bizquiz);
        arrayEvents.add(ed);
        ed = new SubActData("Pitch Start",R.drawable.pitchstart);
        arrayEvents.add(ed);

        return arrayEvents;

    }

    public FragmentManager send()
    {
        FragmentManager fg = getFragmentManager();
        return fg;
    }

}
