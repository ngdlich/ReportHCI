package com.example.reporthci.ui.send;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthci.MainActivity;
import com.example.reporthci.R;
import com.example.reporthci.adapter.DeviceAdapter;
import com.example.reporthci.model.Device;
import com.example.reporthci.ui.ReportActivity;

import java.util.ArrayList;

public class DeviceFragment extends Fragment {

    private ArrayList<Device> mDevices;
    private RecyclerView mRecyclerDevice;
    private DeviceAdapter mDeviceAdapter;

    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null);
        View root = inflater.inflate(R.layout.fragment_list_device, container, false);


        ((MainActivity) getActivity()).setActionBarTitle("Thiết bị cần kiểm tra");
        ((MainActivity) getActivity()).setNavChecked1();

        setHasOptionsMenu(true);
        //handleIntent(getActivity().getIntent());

        mRecyclerDevice = root.findViewById(R.id.recyclerDevice);
        mDevices = new ArrayList<>();
        createDeviceList();
        mDeviceAdapter = new DeviceAdapter(getActivity(), mDevices);
        mRecyclerDevice.setAdapter(mDeviceAdapter);
        mRecyclerDevice.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }

    /*@Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.action_search);
        if(item!=null)
            item.setVisible(true);
        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) item.getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow



            Toast.makeText(getActivity(), "Test search", Toast.LENGTH_SHORT).show();
        }
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        if(searchItem!=null)
            searchItem.setVisible(true);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                mDeviceAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // Not implemented here
                return false;
            default:
                break;
        }
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onOptionsItemSelected(item);
    }*/

    private void createDeviceList() {
        mDevices.add(new Device("Recloser MPD11200", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Tụ bù TB675", "Dây điện trần","Thanh Nhàn 1", "478TN/234/63/1", "recloserjpg"));
        mDevices.add(new Device("Kháng điện KD8475", "Dây điện trần","Tạ Quang Bửu 2", "478TN/234/63/1", "tu_bu"));
        mDevices.add(new Device("Recloser RCL76", "Dây điện trần","Bệnh viện Bạch Mai ", "478TN/234/63/1", "lbs"));
        mDevices.add(new Device("Cáp treo CT6578", "Dây điện trần","Đống Đa 4", "478TN/234/63/1", "cot_dien"));
        mDevices.add(new Device("Sứ đứng SD53748", "Dây điện trần","Hai Bà Trưng 10", "478TN/234/63/1", "tram_bien_ap"));
        mDevices.add(new Device("Tụ bù TB492", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Recloser MPD14200", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Tụ bù TB685", "Dây điện trần","Thanh Nhàn 1", "478TN/234/63/1", "recloserjpg"));
        mDevices.add(new Device("Kháng điện KD84555", "Dây điện trần","Tạ Quang Bửu 2", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Recloser RCL736", "Dây điện trần","Bệnh viện Bạch Mai ", "478TN/234/63/1", "tu_bu"));
        mDevices.add(new Device("Cáp treo CT65738", "Dây điện trần","Đống Đa 4", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Sứ đứng SD537428", "Dây điện trần","Hai Bà Trưng 10", "478TN/234/63/1", "recloserjpg"));
        mDevices.add(new Device("Tụ bù TB4922", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Recloser MPD111400", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "tu_bu"));
        mDevices.add(new Device("Tụ bù TB6745", "Dây điện trần","Thanh Nhàn 1", "478TN/234/63/1", "lbs"));
        mDevices.add(new Device("Kháng điện KD84745", "Dây điện trần","Tạ Quang Bửu 2", "478TN/234/63/1", "cot_dien"));
        mDevices.add(new Device("Recloser RCL746", "Dây điện trần","Bệnh viện Bạch Mai ", "478TN/234/63/1", "recloserjpg"));
        mDevices.add(new Device("Cáp treo CT65778", "Dây điện trần","Đống Đa 4", "478TN/234/63/1", "cong_to_dien"));
        mDevices.add(new Device("Sứ đứng SD537048", "Dây điện trần","Hai Bà Trưng 10", "478TN/234/63/1", "tu_bu"));
        mDevices.add(new Device("Tụ bù TB4902", "Dây điện trần","ĐH Bách khoa Hà Nội", "478TN/234/63/1", "lbs"));

    }
}