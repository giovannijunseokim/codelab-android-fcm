package org.sopt.dosopt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.dosopt.databinding.ActivityPureLoginBinding

class PureLoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPureLoginBinding.inflate(layoutInflater) }

    // TODO : Declare the launcher at the top of your Activity/Fragment:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        askNotificationPermission()
        binding.btnLogin.setOnClickListener {
            getFcmToken()
        }
    }

    private fun getFcmToken() {
        // TODO : Get FCM Token

    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        // TODO : Ask Notification permission with launcher

    }
}