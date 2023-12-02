package com.symatechlabs.pinfailed.services

import android.app.Service
import android.content.Intent
import android.hardware.Camera
import android.hardware.Camera.PictureCallback
import android.os.*
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.symatechlabs.pinfailed.common.Constants
import java.io.*


class CameraService /*: Service()*/{

/*    private lateinit var sHolder: SurfaceHolder;

    private lateinit var mCamera: Camera;

    private var parameters: Camera.Parameters? = null


    override fun onStart(intent: Intent?, startId: Int) {

        super.onStart(intent, startId)

        val sv = SurfaceView(applicationContext)
        try {
            mCamera = Camera.open()
            mCamera.setPreviewDisplay(sv.holder)
            parameters = mCamera.getParameters()

            mCamera.setParameters(parameters)
            mCamera.startPreview()
            mCamera.takePicture(null, null, mCall)
        } catch (e: IOException) {
            Log.d(Constants.LOG_TAG, e.message.toString());
        }

        sHolder = sv.holder
        sHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }



    var mCall =
        PictureCallback { data, camera ->
            var outStream: FileOutputStream? = null
            try {
                outStream = FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))
                outStream.write(data)
                outStream.close()
            } catch (e: FileNotFoundException) {
                Log.d(Constants.LOG_TAG, e.message.toString());
            } catch (e: IOException) {
                Log.d(Constants.LOG_TAG, e.message.toString());
            }
        }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }*/
}