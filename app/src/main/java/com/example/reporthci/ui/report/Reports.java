package com.example.reporthci.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class Reports extends Fragment {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_ds_tb, container, false);

        viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new ReportFragment(), "Chưa hoàn thành");
        adapter.addFragment(new ReportFragment2(), "Đã hoàn thành");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        ((MainActivity) getActivity()).setActionBarTitle("Báo cáo");
        ((MainActivity) getActivity()).setNavChecked();


        /*viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                if (manager.getBackStackEntryCount() > 0) {
                    while (manager.getBackStackEntryCount() > 0){
                        manager.popBackStackImmediate();
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

        return root;
    }

}
