package sk.esx.qrscanner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScannerActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    lateinit var scannerView: ZXingScannerView

    companion object {
        const val EXTRA_RESULT = "extraResult"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(scannerView)
        scannerView = ZXingScannerView(this)
    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }

    override fun handleResult(rawResult: Result?) {

        rawResult?.let {
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_RESULT, it.text)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

}
