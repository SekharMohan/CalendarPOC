package connect.nissan.com.calendarpoc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Renault Nissan Technology & Business Center India Pvt Ltd
 * Copyright (c) 2017 Renault Nissan Technology & Business Center India Pvt Ltd
 */

public class ListenerBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"calendar event listener",Toast.LENGTH_LONG).show();
    }
}
