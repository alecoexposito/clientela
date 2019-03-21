package com.cubaback.unete.presentation.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.cubaback.unete.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_qrscan.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.jetbrains.anko.toast

class QRScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {


    private val MY_CAMERA_REQUEST_CODE = 1000;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscan)
    }


    private fun setScannerProperties() {
        qrCodeScanner.setFormats(listOf(BarcodeFormat.QR_CODE))
        qrCodeScanner.setAutoFocus(true)
        qrCodeScanner.setLaserColor(R.color.colorAccent)
        qrCodeScanner.setMaskColor(R.color.colorAccent)
//        if (Build.MANUFACTURER.equals(HUAWEI, ignoreCase = true))
//            qrCodeScanner.setAspectTolerance(0.5f)
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                        MY_CAMERA_REQUEST_CODE)
                return
            }
        }
        qrCodeScanner.startCamera()
        qrCodeScanner.setResultHandler(this)
    }


    override fun handleResult(p0: Result?) {
        if (p0 != null) {
            toast(p0.text)
        }
    }

    override fun onPause() {
        super.onPause()
        qrCodeScanner.stopCamera()
    }

}
