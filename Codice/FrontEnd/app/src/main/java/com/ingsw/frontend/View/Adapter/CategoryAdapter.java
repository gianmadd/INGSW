package com.ingsw.frontend.View.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ingsw.frontend.Model.Category;
import com.ingsw.frontend.R;
import com.ingsw.frontend.View.Fragment.MenuElementsFragment;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    public ArrayList<Category> arrayList;

    private final int NORMAL_LAYOUT = -1;
    private final int SELECTION_LAYOUT=-2;
    public static int currentLayout = -1;

    private MenuElementsFragment menuElementsFragment;


    public CategoryAdapter(Context context, ArrayList<Category> arrayList, MenuElementsFragment menuElementsFragment){
        this.arrayList = arrayList;
        this.menuElementsFragment = menuElementsFragment;
    }

    public ArrayList<Category> getArrayList(){
        return arrayList;
    }

    public void setArrayList(ArrayList<Category> arrayList) {
        this.arrayList = arrayList;
    }

    public void clearList(){
        arrayList.clear();
    }



 // ***************************************************************************************


    @NonNull
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View normalList = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_clickable, parent,false);
        View selectionList = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_selection, parent,false);

        if(getItemViewType(0) == -1)
            return new CategoryHolder(normalList);
        else
            return  new CategoryHolder(selectionList);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        holder.textView.setText(arrayList.get(position).getName());
        holder.checkBox.setChecked(false);


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.get(holder.getAdapterPosition()).setChecked(holder.checkBox.isChecked());
            }
        });


        if(arrayList.get(holder.getAdapterPosition()).getChecked() == true)
            holder.checkBox.setChecked(true);
        else
            holder.checkBox.setChecked(false);



        if(holder.cardView != null)
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    menuElementsFragment.getElementFromClick(arrayList.get(holder.getAdapterPosition()).getId());
                    System.out.println(arrayList.get(holder.getAdapterPosition()).getId());
                    System.out.println(arrayList.get(holder.getAdapterPosition()).getName());
                    System.out.println(arrayList.get(holder.getAdapterPosition()).getAliment());
                    System.out.println(arrayList.get(holder.getAdapterPosition()).getMenuId());
            }
        });

    }

    @Override
    public int getItemViewType(int position){

        return currentLayout;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    // ***************************************************************************************



    public class CategoryHolder extends RecyclerView.ViewHolder{
        private CheckBox checkBox;
        private TextView textView;
        private CardView cardView;


        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.row_clickable_item);
            textView = itemView.findViewById(R.id.text_cardview);
            checkBox = itemView.findViewById(R.id.checkbox_category);

        }

    }
}
