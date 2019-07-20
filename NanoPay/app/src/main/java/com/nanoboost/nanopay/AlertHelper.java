package com.nanoboost.nanopay;

import android.app.AlertDialog;
import android.content.Context;

public class AlertHelper {

    public static void showPopup(Context context, String title, String message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}
