package com.ahdesigns.osrsbuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.CheckBox;

@SuppressWarnings("ALL")
public class woodcuttingDialogFragment extends DialogFragment {

    String username, skill;

    private AlertDialog dialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {

        Bundle bundle = getArguments();
        username = bundle.getString("username","");
        skill = bundle.getString("skill", "");

        View options = View.inflate(getContext(), R.layout.woodcuttingoptions, null);
        final CheckBox lumber = options.findViewById(R.id.lumber);
        final CheckBox gatherer = options.findViewById(R.id.gatherer);
        final CheckBox wisdom = options.findViewById(R.id.wisdom);
        final Intent intent = new Intent(getActivity(), skillCalculatorDetailsScreen.class);

        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.DialogTheme));
        builder.setTitle(R.string.bonuses)
                .setView(options)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (lumber.isChecked()) {
                            intent.putExtra("lumber", "true");
                        } else {
                            intent.putExtra("lumber", "false");
                        }
                        if (gatherer.isChecked()) {
                            intent.putExtra("gatherer", "true");
                        } else {
                            intent.putExtra("gatherer", "false");
                        }
                        if (wisdom.isChecked()) {
                            intent.putExtra("wisdom", "true");
                        } else {
                            intent.putExtra("wisdom", "false");
                        }
                        intent.putExtra("username", username);
                        intent.putExtra("skill", skill);
                        getActivity().startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        dialog = builder.create();
        return dialog;
    }
}