package com.example.reporthci.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.TabAdapter;
import com.example.reporthci.ui.send.DeviceFragment;
import com.example.reporthci.ui.share.ShareFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class DsTb extends Fragment {

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
            adapter.addFragment(new DeviceFragment(), "Tab 1");
            adapter.addFragment(new ShareFragment(), "Tab 2");
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

            ((MainActivity) getActivity()).setActionBarTitle("Báo cáo");
            ((MainActivity) getActivity()).setNavChecked1();


            return root;
        }

}