package me.luisfergromo.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            val email = email_TextEdit.text.toString()
            val password = password_EditText.text.toString()

            //Log.d("Login", "Attemp Login with email/pw $email/***")
            wtf("Login", "Attemp Login with email/pw $email/$password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            //.addOnCanceledListener

        }
        backToRegistrationBtn.setOnClickListener {
            finish()
        }
    }
}