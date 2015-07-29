package com.example.j1tth4.simplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by j1tth4 on 7/23/15 AD.
 */
public class ShopConfigurationFragment extends Fragment {

    public static final String TAG = ShopConfigurationFragment.class.getSimpleName();

    public static ShopConfigurationFragment newInstance(){
        ShopConfigurationFragment fragment = new ShopConfigurationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shop_configuration_layout, container, false);
    }
}
