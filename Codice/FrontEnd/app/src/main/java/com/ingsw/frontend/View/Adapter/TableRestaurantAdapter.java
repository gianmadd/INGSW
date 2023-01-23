package com.ingsw.frontend.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ingsw.frontend.Model.TableRestaurant;
import com.ingsw.frontend.R;

import java.util.ArrayList;

public class TableRestaurantAdapter extends RecyclerView.Adapter<TableRestaurantAdapter.TableRestaurantHolder> {

    public ArrayList<TableRestaurant> tableRestaurantArrayList;

    public TableRestaurantAdapter(Context context, ArrayList<TableRestaurant> tableRestaurantArrayList){
        this.tableRestaurantArrayList = tableRestaurantArrayList;
    }

    public ArrayList<TableRestaurant> getTableRestaurantArrayList() {
        return tableRestaurantArrayList;
    }

    public void setTableRestaurantArrayList(ArrayList<TableRestaurant> tableRestaurantArrayList) {
        this.tableRestaurantArrayList = tableRestaurantArrayList;
    }

    public void clearList(){
        tableRestaurantArrayList.clear();
    }

    // ***************************************************************************************

    @NonNull
    @Override
    public TableRestaurantAdapter.TableRestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TableRestaurantAdapter.TableRestaurantHolder(LayoutInflater
                                                                .from(parent.getContext())
                                                                .inflate(R.layout.row_table_clickable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TableRestaurantAdapter.TableRestaurantHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.table_10_free);
    }

    @Override
    public int getItemCount() {
        return tableRestaurantArrayList.size();
    }




    // ***************************************************************************************
    // ***************************************************************************************
    // ***************************************************************************************

    public class TableRestaurantHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public TableRestaurantHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.table_image);
        }
    }

}
