package me.luisfergromo.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            val email = email_TextEdit.text.toString()
            val password = password_EditText.text.toString()

            /*
            val email = "l@l.com"
            val password = "01234567890"
             */


            //Log.d("Login", "Attemp Login with email/pw $email/***")
            wtf("Login", "Attemp Login with email/pw $email/$password")

            //TODO: Login Firebase
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    //wtf("FirebaseLogin", "user ${email} succesfull login")
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener
                        wtf("firebaseLogin", "Successful login user uid ${it.result.user.uid}")
                        Toast.makeText(this, "Successful login user email:  ${it.result.user.email} uid assigned", Toast.LENGTH_SHORT).show()

                        logged()
                    }
                    .addOnFailureListener {
                        wtf("firebaseLogin", "Failed to login user  ${it.message}")
                        Toast.makeText(this, "Failed to login user: ${it.message}", Toast.LENGTH_SHORT).show()
                    }

        }
        backToRegistrationBtn.setOnClickListener {
            finish()
        }
    }

    fun logged() {
        wtf("logged", "Trying to open next window")
        val loginIntent = Intent(this, IndexWindow::class.java)
        startActivity(loginIntent)
    }
}