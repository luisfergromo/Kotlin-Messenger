package me.luisfergromo.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import android.view.View
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*







class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* */
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)


        registerBtn.setOnClickListener {
            val email = email_editText.text.toString()
            val password = password_editText.text.toString()

            wtf("MainActivity","Email is: $email")
            wtf("MainActivity", "Password: $password")
        }
        alreadyUser_TextView.setOnClickListener {
            //wtf("MainActivity","Try to show login activity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        registerBtn.setOnClickListener {
        }
    }

    fun forceCrash(view: View) {
        throw RuntimeException("This is a crash")
    }

}
