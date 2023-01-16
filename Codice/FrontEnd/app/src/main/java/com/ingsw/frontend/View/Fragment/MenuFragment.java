package com.ingsw.frontend.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingsw.frontend.Model.Menu;
import com.ingsw.frontend.Model.Restaurant;
import com.ingsw.frontend.Model.User;
import com.ingsw.frontend.Presenter.MenuPresenter;
import com.ingsw.frontend.Presenter.RestaurantPresenter;
import com.ingsw.frontend.R;

public class MenuFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private MenuElementsFragment menuElementsFragment = new MenuElementsFragment();
    private MenuCategoriesFragment menuCategoriesFragment = new MenuCategoriesFragment(menuElementsFragment);
    private MenuPresenter menuPresenter = new MenuPresenter(this);


    private Intent intent;
    private Restaurant restaurant;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        intent = getActivity().getIntent();

        restaurant = (Restaurant) intent.getSerializableExtra("restaurant");

        menuPresenter.getByRestaurantName(restaurant.getName());

        fragmentTransaction.replace(R.id.categories_menu_container, menuCategoriesFragment);
        fragmentTransaction.replace(R.id.elements_menu_container, menuElementsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    public void loadMenu(Menu menu){
        intent = getActivity().getIntent();
        intent.putExtra("menu",menu);
    }
}