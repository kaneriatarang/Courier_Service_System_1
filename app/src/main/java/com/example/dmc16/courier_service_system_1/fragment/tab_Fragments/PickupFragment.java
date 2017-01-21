package com.example.dmc16.courier_service_system_1.fragment.tab_Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dmc16.courier_service_system_1.R;
import com.example.dmc16.courier_service_system_1.activity.Pickup_Office_MapsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickupFragment extends Fragment {

    Button search_Button;

    public PickupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pickup, container, false);
        search_Button = (Button)view.findViewById(R.id.search_office_Button);

        search_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Pickup_Office_MapsActivity.class);
                startActivity(i);

//                Fragment fragment = new PickupMapFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.pickup_frame, fragment);
////                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

            }
        });
        return view;
    }

}
