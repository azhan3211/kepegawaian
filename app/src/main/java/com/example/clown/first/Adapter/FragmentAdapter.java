package com.example.clown.first.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.clown.first.DokumenP.FragmentDokumen;
import com.example.clown.first.Jabatan.FragmentJabatan;
import com.example.clown.first.Pegawai.FragmentPegawai;

/**
 * Created by cLown on 3/7/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    int countTab;

    public FragmentAdapter(FragmentManager fm, int countTab) {
        super(fm);
        this.countTab = countTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentJabatan();
            case 1:
                return new FragmentDokumen();
            case 2:
                return new FragmentPegawai();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
