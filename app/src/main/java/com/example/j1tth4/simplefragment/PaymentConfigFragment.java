package com.example.j1tth4.simplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

/**
 * Created by j1tth4 on 7/29/15 AD.
 */
public class PaymentConfigFragment extends Fragment {

    private CheckedTextView mChkCash;
    private CheckedTextView mChkCreditCard;

    public static PaymentConfigFragment newInstance(){
        PaymentConfigFragment fragment = new PaymentConfigFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mChkCash = (CheckedTextView) view.findViewById(R.id.chkPayTypeCash);
        mChkCreditCard = (CheckedTextView) view.findViewById(R.id.chkPayTypeCreditCard);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payment_config_layout, container, false);
    }
}
