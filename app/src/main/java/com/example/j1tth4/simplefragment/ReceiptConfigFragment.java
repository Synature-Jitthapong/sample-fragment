package com.example.j1tth4.simplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReceiptConfigFragment extends Fragment {

    private RecyclerView mRcReceiptConfig;
    private RecyclerView mRcReceiptViewer;

    public static ReceiptConfigFragment newInstance(){
        ReceiptConfigFragment fragment = new ReceiptConfigFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRcReceiptConfig = (RecyclerView) view.findViewById(R.id.rcReceiptConfig);
        mRcReceiptViewer = (RecyclerView) view.findViewById(R.id.rcReceiptViewer);

        RecyclerView.LayoutManager rcReceiptConfigLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager rcReceiptViewerLayoutManager = new LinearLayoutManager(getActivity());

        mRcReceiptConfig.setLayoutManager(rcReceiptConfigLayoutManager);
        mRcReceiptViewer.setLayoutManager(rcReceiptViewerLayoutManager);

        mRcReceiptConfig.setHasFixedSize(true);
        mRcReceiptViewer.setHasFixedSize(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.receipt_config_layout, container, false);
    }
}
