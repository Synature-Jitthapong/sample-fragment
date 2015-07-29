package com.example.j1tth4.simplefragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j1tth4 on 7/13/15.
 */
public class ConfigurationFragment extends DialogFragment {

    public static final String TAG = "ConfigurationFragment";

    private List<ConfigNavItem> mConfigNavLst;

    private ConfigurationRcNavAdapter mRcNavAdapter;

    private RecyclerView mRcNavigation;
    private RecyclerView.LayoutManager mRcLayoutManager;

    public static ConfigurationFragment newInstance(){
        ConfigurationFragment f = new ConfigurationFragment();

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] navs = getResources().getStringArray(R.array.nav_configurations);
        mConfigNavLst = new ArrayList<>();
        for(int i = 0; i < navs.length; i++){
            String nav = navs[i];
            ConfigNavItem cfgNav = new ConfigNavItem();
            cfgNav.setTitle(nav);
            if(i == 0)
                cfgNav.setSelected(true);
            mConfigNavLst.add(cfgNav);
        }
        mRcNavAdapter = new ConfigurationRcNavAdapter();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initElements(view);

        showFragment(0);
    }

    private void showFragment(int idx){
        android.support.v4.app.FragmentTransaction trans = getChildFragmentManager().beginTransaction();

        Fragment fragment = ShopConfigurationFragment.newInstance();
        if(idx == 1){
            fragment = PaymentConfigFragment.newInstance();
        }else if(idx == 2){
            fragment = ReceiptConfigFragment.newInstance();
        }
        trans.replace(R.id.configFragmentContainer, fragment);
        trans.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return inflater.inflate(R.layout.configuration_fragment, container, false);
    }

    private void initElements(View view){
        mRcNavigation = (RecyclerView) view.findViewById(R.id.rcConfigNav);
        mRcLayoutManager = new LinearLayoutManager(getActivity());
        mRcNavigation.setHasFixedSize(true);
        mRcNavigation.setLayoutManager(mRcLayoutManager);

        mRcNavigation.setAdapter(mRcNavAdapter);
    }

    private class ConfigurationRcNavAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        class ViewHolder extends RecyclerView.ViewHolder{

            TextView tvTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.textView1);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.nav_config_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final ConfigNavItem cfgNavItem = mConfigNavLst.get(position);

            final ViewHolder myHolder = (ViewHolder) holder;
            myHolder.tvTitle.setText(cfgNavItem.getTitle());
            holder.itemView.setSelected(cfgNavItem.isSelected());

            if(cfgNavItem.isSelected()){
                myHolder.tvTitle.setTextAppearance(getActivity(),
                        R.style.TextAppearance_AppCompat_Large);
            }else{
                myHolder.tvTitle.setTextAppearance(getActivity(),
                        R.style.TextAppearance_AppCompat_Large_Inverse);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0; i < getItemCount(); i++){
                        if(i != position){
                            mConfigNavLst.get(i).setSelected(false);
                        }
                    }
                    cfgNavItem.setSelected(true);
                    notifyDataSetChanged();
                    showFragment(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mConfigNavLst != null ? mConfigNavLst.size() : 0;
        }
    }

    public static class ConfigNavItem{
        private String title;
        private boolean selected;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
