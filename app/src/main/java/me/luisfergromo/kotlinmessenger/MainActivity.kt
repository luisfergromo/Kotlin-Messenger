package me.luisfergromo.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.wtf
import android.widget.Toast
import com.crashlytics.android.Crashlytics
import com.google.firebase.auth.FirebaseAuth
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

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter in email/pw", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            /*
                wtf("RegisterBtn", "Email is: " + email)
                wtf("RegisterBtn", "Password: $password")
            */

            // TODO: Firebase Auth to create a user with email and password
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener
                        //else is successful
                        wtf("firebaseCreate", "Successful created user uid ${it.result.user.uid}")
                        Toast.makeText(this, "Successful created user email:  ${it.result.user.email} uid assigned", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        wtf("firebaseCreate", "Failed to created user  ${it.message}")
                        Toast.makeText(this, "Failed to created user: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
        }
        alreadyUser_TextView.setOnClickListener {
            //wtf("MainActivity","Try to show login activity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    /*
    fun forceCrash(view: View) {
        throw RuntimeException("This is a crash")
    }
 */
}
