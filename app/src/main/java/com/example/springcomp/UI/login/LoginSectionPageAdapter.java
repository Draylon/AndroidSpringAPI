package com.example.springcomp.UI.login;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class LoginSectionPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList();
    private  final List<String> fragmentTitleList = new ArrayList();


    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }


    public CharSequence getPageTitle(int p){
        return fragmentTitleList.get(p);
    }

    public LoginSectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
