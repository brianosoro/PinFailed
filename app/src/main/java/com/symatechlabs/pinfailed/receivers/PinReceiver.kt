package com.symatechlabs.pinfailed.receivers

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.symatechlabs.pinfailed.common.Constants.LOG_TAG
import com.symatechlabs.pinfailed.common.Constants.PIN_FAILED_ATTEMPT
import com.symatechlabs.pinfailed.common.utilities.Utilities
import com.symatechlabs.pinfailed.data.entities.Pin
import com.symatechlabs.pinfailed.repository.PinRepository
import com.symatechlabs.pinfailed.services.CameraService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PinReceiver: DeviceAdminReceiver() {
    @Inject
    lateinit var pinRepository: PinRepository;
/*    lateinit var cameraIntentService: Intent;*/


    override fun onPasswordFailed(context: Context, intent: Intent) {
        super.onPasswordFailed(context, intent)
        try {
            var utilities = Utilities(context);
            pinRepository.insertPin(Pin(0, PIN_FAILED_ATTEMPT, utilities.getDateTime()));

/*            cameraIntentService = Intent(context, CameraService::class.java);
            cameraIntentService.putExtra("Front_Request", true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(cameraIntentService)
            }else{
                context.startService(cameraIntentService);
            }*/

            Log.d(LOG_TAG, "SUCCESS");
        }catch (exception: Exception){
            Log.d(LOG_TAG, exception.toString());
        }

    }

    override fun onPasswordSucceeded(context: Context, intent: Intent) {
        super.onPasswordSucceeded(context, intent)
        Log.d(LOG_TAG, "SUCCESS");
    }

}