package com.vitaldentcix.dentallawyer.dentallawyer;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabsPager extends FragmentStatePagerAdapter {
    String[] titles =  new String[] {"Buscar paciente", "Historia clínica", "Odontograma"};

    public TabsPager(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BuscarFragment buscarFragment = new BuscarFragment();
                return buscarFragment;
            case 1:
                HistoriaFragment historiaFragment = new HistoriaFragment();
                return historiaFragment;
            case 2:
                OdontogramaFragment odontogramaFragment = new OdontogramaFragment();
                return odontogramaFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
