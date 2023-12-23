package org.sopt.dosopt

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessaging
import org.sopt.dosopt.databinding.ActivitySolutionLoginBinding

class SolutionLoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySolutionLoginBinding.inflate(layoutInflater) }

    // TODO : Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        askNotificationPermission()
        binding.btnLogin.setOnClickListener {
            getFcmToken()
        }
    }

    private fun getFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { regTokenTask ->
            if (regTokenTask.isSuccessful) {
                Log.d("SolutionLoginActivity", "FCM registration token: ${regTokenTask.result}")
                // TODO : Pass that value during the login process
            } else {
                Log.e(
                    "SolutionLoginActivity", "Unable to retrieve registration token",
                    regTokenTask.exception
                )
            }
        }
    }

    // TODO : ask notification permission for API level >= 33 (TIRAMISU)
    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this, POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(POST_NOTIFICATIONS)) {
                // If the user has previously denied the permission request, it is supposed to pass a value of 'true'.
                // Gets whether you should show UI with rationale before requesting a permission.
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(POST_NOTIFICATIONS)
            }
        }
    }

}