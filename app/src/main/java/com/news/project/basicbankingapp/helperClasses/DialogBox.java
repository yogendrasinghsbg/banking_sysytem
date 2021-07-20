package com.news.project.basicbankingapp.helperClasses;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.news.project.basicbankingapp.R;
import com.news.project.basicbankingapp.userData.TransactionDetails;

import org.jetbrains.annotations.NotNull;

public class DialogBox  extends AppCompatDialogFragment {

    EditText enterAmountToTransfer;

    int userCurrentBalance , userAccountNumber;
    String ToUser ;
    String fromUser  = "Vijedra Vishwakarma";


    public void setToUser(String toUser) {
        ToUser = toUser;
    }


    public void setUserAccountNumber(int userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }

    public void setUserCurrentBalance(int  userCurrentBalance) {
        this.userCurrentBalance = userCurrentBalance;
    }

    @NonNull
    @NotNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_get_amount , null);
        enterAmountToTransfer = view.findViewById(R.id.enterAmountField);
        builder.setView(view)
                .setTitle("Enter amount")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String enteredAmout = enterAmountToTransfer.getText().toString();
                        if(enteredAmout.isEmpty())
                            enterAmountToTransfer.setError("Amount can't be empty");
                        else if(Integer.parseInt(enteredAmout) < 0)
                            enterAmountToTransfer.setError("please enter valid amount");
                        else if(Integer.parseInt(enteredAmout) > userCurrentBalance)
                            enterAmountToTransfer.setError("you have insufficient balance ");
                        else
                        {
                            int updatedBalance = userCurrentBalance - Integer.parseInt(enteredAmout) ;
                            DatabaseHelper helper = new DatabaseHelper(getContext());
                            helper.updateAmount(userAccountNumber , updatedBalance);
                           UsersTransactionDatabaseHelper databaseHelper = new UsersTransactionDatabaseHelper(getContext());
                           boolean result = databaseHelper.insertTransferData(fromUser ,ToUser ,Integer.parseInt(enteredAmout) );
                           if(result)
                               Toast.makeText(getActivity(), "money transfer successful", Toast.LENGTH_SHORT).show();
                           else
                               Toast.makeText(getActivity(), "money transfer Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return builder.create();
    }
}
