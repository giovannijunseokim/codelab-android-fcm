package org.sopt.dosopt

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class SolutionFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("SolutionFirebaseMessagingService", "fcm token : $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("SolutionFirebaseMessagingService", message.notification.toString())
        Log.d("SolutionFirebaseMessagingService", message.data.toString())
        Log.d("SolutionFirebaseMessagingService", "모티부 화이팅 ㅋ")
    }

}