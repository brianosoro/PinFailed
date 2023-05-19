package com.symatechlabs.pinfailed.common.utilities


import android.Manifest
import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import com.symatechlabs.pinfailed.common.Constants
import com.symatechlabs.pinfailed.common.Constants.SETTINGS_DEVICE_SETTINGS
import com.symatechlabs.pinfailed.common.Constants.SETTINGS_PACKAGE
import java.text.SimpleDateFormat
import java.util.*


class Utilities(context: Context) : UtilitiesInterface {

    var context: Context;
    private lateinit var deviceManger: DevicePolicyManager;
    private lateinit var powerManager: PowerManager;
    private lateinit var component: ComponentName;
    private lateinit var activityManager: ActivityManager;
    var compName: ComponentName? = null;

    init {
        this.context = context;
    }

    override
    fun isAdminActive(): Boolean {
        deviceManger =
            context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager;
        component =
            ComponentName(context.packageName, context.packageName + ".receivers.PinReceiver");
        activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager;
        return deviceManger.isAdminActive(component);
    }

    override
    fun setDeviceAdminSettings() {
        compName =
            ComponentName(SETTINGS_PACKAGE, SETTINGS_DEVICE_SETTINGS);
        val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
        context.startActivity(Intent().setComponent(compName))
    }

    override
    fun requestPermissions(fragment: Fragment) {

        val requestMultiplePermissionLauncher =
            fragment.registerForActivityResult(
                ActivityResultContracts.RequestMultiplePermissions()
            ) { result ->
                for (r in result){
                    Log.d(Constants.LOG_TAG, r.key+" : "+r.value.toString())
                }

            }
        requestMultiplePermissionLauncher.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,
                Manifest.permission.BIND_DEVICE_ADMIN, Manifest.permission.ACCESS_NOTIFICATION_POLICY, Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)
        )
    }

    override
    fun ignoreBatterOptimizations() {
        powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!powerManager.isIgnoringBatteryOptimizations(context.packageName)){
                val intent: Intent = Intent();
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData( Uri.parse("package:" + context.packageName));
                context.startActivity(intent);
            }else{

            }
        }
    }


    override
    fun getDateTime(): String?{
        try {
            val formatter = SimpleDateFormat("dd/MM/yyyy   HH:mm:ss", Locale.ENGLISH);
            val date = formatter.format(Calendar.getInstance().time);
            return date.toString();
        } catch (e: Exception){
           return null;
        }
    }

    override
    fun takeSelfie() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        cameraIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(cameraIntent);

    }

    override
    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

    override
    fun sendEmail(recipient: String, subject: String) {

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        try {
            this.context.startActivity(Intent.createChooser(emailIntent, "Select Mail App"))
        } catch (e: Exception){

        }

    }

    override
    fun openLink(link: String) {
        val openLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        try {
            this.context. startActivity(openLinkIntent)
        } catch (e: Exception){

        }
    }
}