package com.ingsw.frontend.View.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ingsw.frontend.View.Adapter.CategoryAdapter;
import com.ingsw.frontend.Model.Category;
import com.ingsw.frontend.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuCategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuCategoriesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<Category> arrayList;
    private ImageButton removeButton;
    private ImageButton addButton;
    private ImageButton backButton;
    private ImageButton confirmButton;

    private RecyclerView myView;
    private CategoryAdapter adapter;


    public MenuCategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuCategoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuCategoriesFragment newInstance(String param1, String param2) {
        MenuCategoriesFragment fragment = new MenuCategoriesFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_menu_categories, container, false);

        /////////////////////////////////////////////


        arrayList = new ArrayList();
        removeButton = rootView.findViewById(R.id.remove_category_button);
        addButton = rootView.findViewById(R.id.add_category_button);
        backButton = rootView.findViewById(R.id.back_category_button);
        confirmButton = rootView.findViewById(R.id.confirm_category_button);

        myView = rootView.findViewById(R.id.categories_listview);
        adapter = new CategoryAdapter(getContext(), new ArrayList<>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myView.setLayoutManager(linearLayoutManager);
        myView.setAdapter(adapter);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CategoryAdapter.currentLayout == -1){
                    CategoryAdapter.currentLayout = -2;
                    adapter.notifyDataSetChanged();
                }

                removeButton.setVisibility(View.INVISIBLE);
                backButton.setVisibility(View.VISIBLE);

                addButton.setVisibility(View.INVISIBLE);
                confirmButton.setVisibility(View.VISIBLE);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CategoryAdapter.currentLayout == -2){
                    CategoryAdapter.currentLayout = -1;
                    adapter.notifyDataSetChanged();
                }

                backButton.setVisibility(View.INVISIBLE);
                removeButton.setVisibility(View.VISIBLE);

                confirmButton.setVisibility(View.INVISIBLE);
                addButton.setVisibility(View.VISIBLE);

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        /////////////////////////////////////////////


        return rootView;
    }

    public void loadCategory(ArrayList<Category> categoryList){
        adapter.clearList();
        adapter.setArrayList(categoryList);
        adapter.notifyDataSetChanged();
    }
}