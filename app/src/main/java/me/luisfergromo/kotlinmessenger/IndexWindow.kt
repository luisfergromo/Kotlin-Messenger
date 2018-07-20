package me.luisfergromo.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_index.*

class IndexWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_index)

        logout.setOnClickListener {
            wtf("signOut", "SignOut of ${FirebaseAuth.getInstance().currentUser?.email}")
            FirebaseAuth.getInstance().signOut()
            finish()
        }
    }
}