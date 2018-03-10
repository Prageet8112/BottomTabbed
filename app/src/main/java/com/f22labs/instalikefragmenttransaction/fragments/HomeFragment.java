package com.f22labs.instalikefragmenttransaction.fragments;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
import com.f22labs.instalikefragmenttransaction.Data.ImageItem;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.listview.CustomAdapterEvents;
import com.f22labs.instalikefragmenttransaction.listview.GridVIewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.btn_click_me)
    Button btnClickMe;
    ListView lv;
    CustomAdapterEvents adapter;
    private GridView gridView;
    private GridVIewAdapter gridAdapter;

    int fragCount;


    public static HomeFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public HomeFragment() {
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

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        ButterKnife.bind(this, rootView);

        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }

        gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridAdapter = new GridVIewAdapter(this.getContext(), R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        /*
        lv = (ListView) rootView.findViewById(R.id.frag1list);

         adapter = new CustomAdapterEvents(this.getActivity(),getEvents());

        lv.setAdapter(adapter);
        */




        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mFragmentNavigation != null) {

                    mFragmentNavigation.pushFragment(CodeItOut.newInstance(fragCount+1));

                }
            }
        });



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

    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
       /* TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }*/

       ImageItem id = new ImageItem(R.drawable.logo1,"Category1");
        imageItems.add(id);
        id = new ImageItem(R.drawable.logo1,"Category2");
        imageItems.add(id);

        return imageItems;
    }
}
