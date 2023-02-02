package com.ingsw.frontend.View.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ingsw.frontend.Model.Order;
import com.ingsw.frontend.R;
import com.ingsw.frontend.View.Fragment.TablesSelectedFragment;

public class OrderCreateDialog extends AppCompatDialogFragment {

    private OrderCreateDialogListener orderCreateDialogListener;
    private TablesSelectedFragment tablesSelectedFragment;

    private RecyclerView allElementsRecyclerView;
    private RecyclerView selectedElementsRecyclerView;

    public OrderCreateDialog(TablesSelectedFragment tablesSelectedFragment){
        this.tablesSelectedFragment = tablesSelectedFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.order_create_layout, null);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", null)
                .show();

        allElementsRecyclerView = view.findViewById(R.id.create_order_all_elements);
        selectedElementsRecyclerView = view.findViewById(R.id.create_order_selected_elements);

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return dialog;
    }


    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {
            orderCreateDialogListener = (OrderCreateDialog.OrderCreateDialogListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        getDialog().getWindow().getAttributes().width=800;
        getDialog().getWindow().setAttributes(
                getDialog().getWindow().getAttributes());
    }

    public interface OrderCreateDialogListener{
        void createOrder(Order order, TablesSelectedFragment tablesSelectedFragment);
    }
}