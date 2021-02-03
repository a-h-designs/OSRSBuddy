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
public class smithingDialogFragment extends DialogFragment {

    String username, skill;

    private AlertDialog dialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {

        Bundle bundle = getArguments();
        username = bundle.getString("username","");
        skill = bundle.getString("skill", "");

        View options = View.inflate(getContext(), R.layout.smithingoptions, null);
        final CheckBox smelting = options.findViewById(R.id.smelting);
        final CheckBox artisan = options.findViewById(R.id.artisan);
        final CheckBox wisdom = options.findViewById(R.id.wisdom);
        final Intent intent = new Intent(getActivity(), skillCalculatorDetailsScreen.class);

        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.DialogTheme));
        builder.setTitle(R.string.bar_option)
                .setView(options)
                .setCancelable(false)
                .setSingleChoiceItems(R.array.bar_versions, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                enable();
                                switch (which) {
                                    case 0:
                                        intent.putExtra("bar", "smelting");
                                        break;
                                    case 1:
                                        intent.putExtra("bar", "bronze");
                                        break;
                                    case 2:
                                        intent.putExtra("bar", "iron");
                                        break;
                                    case 3:
                                        intent.putExtra("bar", "steel");
                                        break;
                                    case 4:
                                        intent.putExtra("bar", "mithril");
                                        break;
                                    case 5:
                                        intent.putExtra("bar", "adamant");
                                        break;
                                    case 6:
                                        intent.putExtra("bar", "rune");
                                        break;
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (smelting.isChecked()) {
                            intent.putExtra("smelting", "true");
                        } else {
                            intent.putExtra("smelting", "false");
                        }
                        if (artisan.isChecked()) {
                            intent.putExtra("artisan", "true");
                        } else {
                            intent.putExtra("artisan", "false");
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

    public void onStart() {
        super.onStart();
        dialog.getButton(Dialog.BUTTON_POSITIVE).setEnabled(false);
    }

    public void enable() {
        dialog.getButton(Dialog.BUTTON_POSITIVE).setEnabled(true);
    }
}