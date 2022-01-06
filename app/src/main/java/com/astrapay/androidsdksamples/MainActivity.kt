package com.astrapay.androidsdksamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.astrapay.qrissdk.helper.AstraPayQris
import com.astrapay.qrissdk.helper.AstraPayQrisListener
import com.astrapay.qrissdk.helper.EventType
import com.astrapay.qrissdk.helper.data.AstraPayQrisAuth

class MainActivity : AppCompatActivity(), AstraPayQrisListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowQr: Button = findViewById(R.id.btn_show_qr)

        btnShowQr.setOnClickListener {
            val astraPayAuth = AstraPayQrisAuth(
                context = this,
                authorizationToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiIwODc3ODU0NTEyODkiLCJyb2xlcyI6WyJMT0dJTiJdLCJpc3MiOiJBc3RyYVBheS1EZXYiLCJ0eXBlIjoiQUNDRVNTIiwidXNlcklkIjo1ODEsImRldmljZUlkIjoiMzFhNzMzMDYtYWU5MS00ZjZiLTliOTgtYjc3YzZiYjM1YWI5IiwidHJhbnNhY3Rpb25JZCI6IiIsInRyYW5zYWN0aW9uVHlwZSI6IiIsIm5iZiI6MTY0MDgzOTQzNiwiZXhwIjoxNjQwODQzMDM2LCJpYXQiOjE2NDA4Mzk0MzYsImp0aSI6IjE5ZWVlMjk4LWVkZWQtNDc0Zi1hMTU5LTdlMmJhYjhlNWMwMiIsImVtYWlsIjpbImphc29ubmF0aGFuYWVsMThAZ21haWwuY29tIl19.bx6B3DTOJvsg4O2TQ18wL_RxVBjzWCR38GEQX5YfywXj-sAKQyRHTxpKjh8GnuZ_uyxmklFjeyxdyN-qNOifzHcyQye82Gzu0-kn6uNL52WbJoA3_1XA6KUwk6lexbl80BJqXeQ8R9-slOm9YXotCl6ekqIJLfjaZF9R7gpwTAHphHrOhY5hXOtAVMDr3GOUWRv-1XdkQK4yXPqkN1_Ohjmw3JSz5CFilmgf5ACdqAteZXEig9gvWBBV12eWgjfnJhlL2Gr4_PaJ9ip8qbM1LNLz2cMG2CaEwhIpNiYwyzqsVv4gfQIn9fKuB7vLGSduhFAtVsK_8LLFKYsngOi2eg",
                listener = this
            )

            AstraPayQris.execute(
                astraPayQrisAuth = astraPayAuth
            )
        }
    }

    //On Transaction Complete
    override fun onComplete(type: EventType) {
        Toast.makeText(this, "Transaction Complete", Toast.LENGTH_SHORT).show()
    }

    //On Transaction Failed
    override fun onFailed() {
        Toast.makeText(this, "Transaction Failed", Toast.LENGTH_SHORT).show()
    }

    //On User token forbidden
    override fun onForbidden() {
        Toast.makeText(this, "user access forbidden", Toast.LENGTH_SHORT).show()
    }

    //On User Cancel Transaction
    override fun onCancel() {
        Toast.makeText(this, "User cancel the transaction", Toast.LENGTH_SHORT).show()
    }
}