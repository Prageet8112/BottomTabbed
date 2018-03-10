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

        import android.media.Image;
        import android.os.Build;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.view.ViewCompat;
        import android.support.v7.widget.Toolbar;
        import android.transition.Fade;
        import android.transition.Slide;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
        import com.f22labs.instalikefragmenttransaction.Data.SubActData;
        import com.f22labs.instalikefragmenttransaction.DetailsTransition;
        import com.f22labs.instalikefragmenttransaction.FinalActivity.Codex;
        import com.f22labs.instalikefragmenttransaction.FinalActivity.TopCoder;
        import com.f22labs.instalikefragmenttransaction.R;
        import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
        import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterEvents;
        import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterSubAct;

        import java.util.ArrayList;

        import butterknife.BindView;
        import butterknife.ButterKnife;


public class CodeItOut extends BaseFragment {


    ListView lv;
    CustomAdapterSubAct adapter;
    ImageView arr;
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
        arr = (ImageView) rootView.findViewById(R.id.subactimage2);

        View gama =  inflater.inflate(R.layout.sub_act_model, container, false);

        ButterKnife.bind(this, rootView);

        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }


        lv = (ListView) rootView.findViewById(R.id.subActList);

        adapter = new CustomAdapterSubAct(this.getActivity() , getSubActivity() , gama );

        lv.setAdapter(adapter);

        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Codex codex = Codex.newInstance(0);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    codex.setSharedElementEnterTransition(new DetailsTransition());
                    codex.setEnterTransition(new Fade());
                    setExitTransition(new Fade());
                    codex.setSharedElementReturnTransition(new DetailsTransition());
                }

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement(arr, "kittens")
                        .replace(R.id.relative1,codex)
                        .addToBackStack(null)
                        .commit();

              //  mFragmentNavigation.pushFragment(codex);
                ((MainActivity)getActivity()).updateToolbarTitle("Codex 2.0");
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Codex codex = Codex.newInstance(0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        codex.setSharedElementEnterTransition(new DetailsTransition());
                        codex.setEnterTransition(new Slide());
                        codex.setExitTransition(new Slide());
                        codex.setSharedElementReturnTransition(new DetailsTransition());
                    }

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addSharedElement(arr , "kittens")
                            .replace(R.id.relative1,codex)
                            .addToBackStack("This is ot")
                            .commit();

                   //  mFragmentNavigation.pushFragment(codex);
                    ((MainActivity)getActivity()).updateToolbarTitle("Codex 2.0");

                }
                if(i==2)
                {
                    TopCoder topCoder = TopCoder.newInstance(0);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        topCoder.setSharedElementEnterTransition(new DetailsTransition());
                        topCoder.setEnterTransition(new Fade());
                        setExitTransition(new Fade());
                        topCoder.setSharedElementReturnTransition(new DetailsTransition());
                    }

                    mFragmentNavigation.pushFragment(topCoder);
                    ((MainActivity)getActivity()).updateToolbarTitle("Top Coder Event");
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

        SubActData ed = new SubActData("Freshers Code Zone",R.drawable.login1);
        arrayEvents.add(ed);

        ed = new SubActData("Codex 3.0",R.drawable.login1);
        arrayEvents.add(ed);
        ed = new SubActData("Top Coder Event",R.drawable.login1);
        arrayEvents.add(ed);

        return arrayEvents;

    }

    public FragmentManager send()
    {
        FragmentManager fg = getFragmentManager();
        return fg;
    }

}
