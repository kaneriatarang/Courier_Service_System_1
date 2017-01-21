package com.example.dmc16.courier_service_system_1.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmc16.courier_service_system_1.R;
import com.example.dmc16.courier_service_system_1.fragment.tab_Fragments.PaymentFragment;
import com.example.dmc16.courier_service_system_1.fragment.tab_Fragments.PickupFragment;
import com.example.dmc16.courier_service_system_1.fragment.tab_Fragments.RateInfoFragment;
import com.example.dmc16.courier_service_system_1.fragment.tab_Fragments.TrackingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static int int_items = 4 ;
    private int[] tabIcons = {
            R.drawable.tab_pickup_white_48,
            R.drawable.tab_payment_white_50,
            R.drawable.tab_tracking_white_48,
            R.drawable.tab_rateinfo_white_48,
    };

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View view =  inflater.inflate(R.layout.fragment_home,null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);


        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                setupTabIcons();
            }
        });


/*
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
*/

        return view;
    }

/*
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new PickupFragment(), "PICKUP");
        adapter.addFragment(new PaymentFragment(), "PAYMENT");
        adapter.addFragment(new PaymentFragment(), "TRACKING");
        adapter.addFragment(new PaymentFragment(), "RATE INFO");
        viewPager.setAdapter(adapter);
    }
*/

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new PickupFragment();
                case 1 : return new PaymentFragment();
                case 2 : return new TrackingFragment();
                case 3 : return new RateInfoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return " PICKUP ";
                case 1 :
                    return " PAYMENT ";
                case 2 :
                    return " TRACKING";
                case 3 :
                    return "RATE INFO";
            }
            return null;
        }

/*
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
*/
    }
}
