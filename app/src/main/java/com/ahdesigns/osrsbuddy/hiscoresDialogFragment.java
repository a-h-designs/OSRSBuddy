package com.ahdesigns.osrsbuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.view.ContextThemeWrapper;

@SuppressWarnings("ALL")
public class hiscoresDialogFragment extends DialogFragment {

    String username;

    private AlertDialog dialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {

        Bundle bundle = getArguments();
        username = bundle.getString("username","");

        final Intent intent = new Intent(getActivity(), statsDetailScreen.class);

        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.DialogTheme));
        builder.setTitle(R.string.hiscores_version)
                .setCancelable(false)
                .setSingleChoiceItems(R.array.hiscore_versions, -1,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                enable();
                                switch (which) {
                                    case 0:
                                        intent.putExtra("url", "normal");
                                        break;
                                    case 1:
                                        intent.putExtra("url", "ironman");
                                        break;
                                    case 2:
                                        intent.putExtra("url", "ultimate");
                                        break;
                                    case 3:
                                        intent.putExtra("url", "hardcore");
                                        break;
                                    case 4:
                                        intent.putExtra("url", "deadman");
                                        break;
                                    case 5:
                                        intent.putExtra("url", "seasonal");
                                        break;
                                    case 6:
                                        intent.putExtra("url", "tournament");
                                        break;
                                }
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        intent.putExtra("username", username);
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
