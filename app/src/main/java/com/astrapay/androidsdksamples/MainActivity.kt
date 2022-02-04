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
                authorizationToken = "AUTH_TOKEN",
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
