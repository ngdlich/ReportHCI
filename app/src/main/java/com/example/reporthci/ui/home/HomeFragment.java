package com.example.reporthci.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.ui.SsAnhActivity;
import com.example.reporthci.ui.report.Reports;
import com.example.reporthci.ui.send.DeviceFragment;
import com.example.reporthci.ui.share.ShareFragment;
import com.example.reporthci.ui.tools.ToolsFragment;

import static androidx.core.app.ActivityCompat.invalidateOptionsMenu;

public class HomeFragment extends Fragment {


    GridLayout mainGrid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ((MainActivity) getActivity()).setActionBarTitle("Trang chủ");
        ((MainActivity) getActivity()).setNavChecked0();

        mainGrid = root.findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);





        return root;
    }



    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        //Toast.makeText(HomeFragment.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        //Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        //for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(0);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Fragment mFragment = new ReportFragment();
                    getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mFragment).commit();*/
                    /*Intent intent = new Intent(getActivity(), DsTb.class);
                    startActivity(intent);*/
                    Fragment mFragment = new Reports();
                    getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();


                }
            });
        //}

        CardView cardView1 = (CardView) mainGrid.getChildAt(1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment mFragment = new DeviceFragment();
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();

                /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, new FragmentB());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/


            }
        });

        CardView cardView2 = (CardView) mainGrid.getChildAt(2);
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment mFragment = new ToolsFragment();
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();


            }
        });

        CardView cardView3 = (CardView) mainGrid.getChildAt(3);
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment mFragment = new ShareFragment();
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mFragment).addToBackStack(null).commit();


            }
        });
    }

}