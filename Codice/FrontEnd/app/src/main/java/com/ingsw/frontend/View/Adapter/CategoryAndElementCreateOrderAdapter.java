package com.ingsw.frontend.View.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ingsw.frontend.Model.Category;
import com.ingsw.frontend.Model.Element;
import com.ingsw.frontend.Model.Enumerations.Aliment_Type;
import com.ingsw.frontend.R;
import com.ingsw.frontend.View.Dialog.OrderCreateDialog;

import java.util.ArrayList;

public class CategoryAndElementCreateOrderAdapter extends RecyclerView.Adapter<CategoryAndElementCreateOrderAdapter.CategoryAndElementHolder> {

    private ArrayList<Category> categoryArrayList;
    private ArrayList<Element> elementArrayList;
    private ArrayList mergeList = new ArrayList();

    private OrderCreateDialog orderCreateDialog;
    private ArrayList<Element> selectedElementArrayList = new ArrayList<>();

    public CategoryAndElementCreateOrderAdapter(Context context, ArrayList<Category> categoryArrayList, ArrayList<Element> elementArrayList, OrderCreateDialog orderCreateDialog){
        this.categoryArrayList = categoryArrayList;
        this.elementArrayList = elementArrayList;
        this.orderCreateDialog = orderCreateDialog;
    }

    private ArrayList mergeCategoryAndElementList(ArrayList<Category> categoryArrayList, ArrayList<Element> elementArrayList) {

        ArrayList result = new ArrayList();

        for(Category category : categoryArrayList){
            result.add(category);
            for(Element element : elementArrayList){
                if(element.getCategoryId() == category.getId())
                    result.add(element);
            }
        }

        return result;
    }

    @NonNull
    @Override
    public CategoryAndElementCreateOrderAdapter.CategoryAndElementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryList = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_create_order_category, parent, false);
        View elementList = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_create_order_element, parent, false);

        if(viewType == 0)
            return new CategoryAndElementHolder(categoryList);
        else
            return new CategoryAndElementHolder(elementList);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAndElementCreateOrderAdapter.CategoryAndElementHolder holder, int position) {

        if(mergeList.get(position) instanceof Category){
            if(((Category) mergeList.get(position)).getAliment() == Aliment_Type.food)
                holder.category.setTextColor(Color.parseColor("#4CDB21"));
            else
                holder.category.setTextColor(Color.BLUE);
            holder.category.setText(((Category) mergeList.get(position)).getName().toUpperCase());
        }
        else if(mergeList.get(position) instanceof Element)
            holder.element.setText(((Element) mergeList.get(position)).getName().toUpperCase());

        if(holder.cardView != null){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedElementArrayList.add((Element) mergeList.get(holder.getAdapterPosition()));
                    orderCreateDialog.loadSelectedElement(selectedElementArrayList);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return mergeList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mergeList.get(position) instanceof Category)
            return 0;
        else if(mergeList.get(position) instanceof Element)
            return 1;
        else
            return -1;
    }


    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    public ArrayList<Element> getElementArrayList() {
        return elementArrayList;
    }

    public void setElementArrayList(ArrayList<Element> elementArrayList) {
        this.elementArrayList = elementArrayList;
    }

    public ArrayList getMergeList() {
        return mergeList;
    }

    public void setMergeList(ArrayList<Category> categoryArrayList, ArrayList<Element> elementArrayList) {
        this.mergeList = mergeCategoryAndElementList(categoryArrayList, elementArrayList);
    }

    public void clearCategory(){
        categoryArrayList.clear();
    }

    public void clearElement(){
        elementArrayList.clear();
    }


    // ***************************************************************************************


    public class CategoryAndElementHolder extends RecyclerView.ViewHolder{

        private TextView category;
        private TextView element;
        private CardView cardView;

        public CategoryAndElementHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.order_create_category_text);
            element = itemView.findViewById(R.id.order_create_element_text);
            cardView = itemView.findViewById(R.id.row_clickable_item);
        }
    }
}
