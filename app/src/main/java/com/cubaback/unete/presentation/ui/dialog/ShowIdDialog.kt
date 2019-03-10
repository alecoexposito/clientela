package com.cubaback.unete.presentation.ui.dialog

import android.app.Dialog
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.cubaback.unete.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import kotlinx.android.synthetic.main.dialog_show_qr.view.*
import org.jetbrains.anko.layoutInflater

class ShowIdDialog : DialogFragment {
    constructor() : super()

    lateinit var customView: View
    lateinit var textToCode : String



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        return customView
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        customView = context!!.layoutInflater.inflate(R.layout.dialog_show_qr, null)

        val dialog = AlertDialog.Builder(context!!)
                .setTitle(R.string.scan_for_get_my_id)
                .setView(customView)
                .create()


        return dialog
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        textToCode = "Juan Miguel Rodriguez Sillero"
        showQrId()
    }

    private fun showQr(bitmap: Bitmap){
        customView.ivQr.setImageBitmap(bitmap)
        customView.progressCircular.visibility = View.GONE
        customView.ivQr.visibility = View.VISIBLE
    }

    // todo: Poner un progress mientras se este creando el Qr
    private fun showQrId(){
        val handler = Handler()
        handler.post {
            val bitmap : Bitmap? = textToImageEncode(textToCode)
            customView.ivQr.setImageBitmap(bitmap)
            customView.progressCircular.visibility = View.GONE
            customView.ivQr.visibility = View.VISIBLE
        }
    }


    @Throws(WriterException::class)
    private fun textToImageEncode(Value: String): Bitmap? {
        val bitMatrix: BitMatrix
        try {
            bitMatrix = MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            )

        } catch (Illegalargumentexception: IllegalArgumentException) {

            return null
        }

        val bitMatrixWidth = bitMatrix.getWidth()

        val bitMatrixHeight = bitMatrix.getHeight()

        val pixels = IntArray(bitMatrixWidth * bitMatrixHeight)

        for (y in 0 until bitMatrixHeight) {
            val offset = y * bitMatrixWidth

            for (x in 0 until bitMatrixWidth) {

                pixels[offset + x] = if (bitMatrix.get(x, y))
                    context!!.resources.getColor(R.color.black)
                else
                    context!!.resources.getColor(R.color.white)
            }
        }
        val bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444)

        bitmap.setPixels(pixels, 0, 100, 0, 0, bitMatrixWidth, bitMatrixHeight)
        return bitmap
    }



    companion object {
        val TAG = javaClass.canonicalName
        val QRcodeWidth = 100
        private val IMAGE_DIRECTORY = "/QRcodeDemonuts"
    }



}

