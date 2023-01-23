package com.ingsw.frontend.View.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.ingsw.frontend.Model.User;
import com.ingsw.frontend.R;

public class UserUpdateDialog extends AppCompatDialogFragment {
    private EditText editTextpwd;
    private User user;

    private UserUpdateDialogListener userUpdateDialogListener;

    public UserUpdateDialog(User user) {
        this.user = user;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.user_update_layout, null);

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", null)
                .show();

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editTextpwd.getText().toString().isEmpty())){
                    String pwd = editTextpwd.getText().toString();
                    user.setPwd(pwd);

                    userUpdateDialogListener.updateUser(user);
                    dialog.dismiss();
                }
            }
        });

        editTextpwd = view.findViewById(R.id.edit_user_pwd);

        return dialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            userUpdateDialogListener = (UserUpdateDialog.UserUpdateDialogListener) context;
        }
        catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().getAttributes().width=650;
        getDialog().getWindow().setAttributes(
                getDialog().getWindow().getAttributes());
    }

    public interface UserUpdateDialogListener {
        void updateUser(User user);
    }
}