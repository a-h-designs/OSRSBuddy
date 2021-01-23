package com.ahdesigns.osrsbuddy;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.view.ContextThemeWrapper;

public class hiscoresDialogFragment extends DialogFragment {

    String username;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {

        Bundle bundle = getArguments();
        username = bundle.getString("username","");

        // Use the Builder class for convenient dialog construction.
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.DialogTheme));
        builder.setTitle(R.string.hiscores_version)
                //Set radio buttons.
                .setItems(R.array.versions, new DialogInterface.OnClickListener() {
                    final Intent intent = new Intent(getActivity(), statsDetailScreen.class);
                    public void onClick(DialogInterface dialog, int which) {
                        intent.putExtra("username", username);
                        switch (which) {
                            case 0:
                                intent.putExtra("url", "normal");
                                getActivity().startActivity(intent);
                                break;
                            case 1:
                                intent.putExtra("url", "ironman");
                                getActivity().startActivity(intent);
                                break;
                            case 2:
                                intent.putExtra("url", "ultimate");
                                getActivity().startActivity(intent);
                                break;
                            case 3:
                                intent.putExtra("url", "hardcore");
                                getActivity().startActivity(intent);
                                break;
                            case 4:
                                intent.putExtra("url", "deadman");
                                getActivity().startActivity(intent);
                                break;
                            case 5:
                                intent.putExtra("url", "seasonal");
                                getActivity().startActivity(intent);
                                break;
                            case 6:
                                intent.putExtra("url", "tournament");
                                getActivity().startActivity(intent);
                                break;
                        }
                    }
                });
        return builder.create();
    }
}
