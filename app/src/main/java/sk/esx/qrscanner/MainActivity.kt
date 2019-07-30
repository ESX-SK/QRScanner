package sk.esx.qrscanner

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val SCANNER_RESULT_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivityForResult(
                Intent(this, ScannerActivity::class.java),
                SCANNER_RESULT_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SCANNER_RESULT_CODE && resultCode == Activity.RESULT_OK) {
            tvCode.text = data?.getStringExtra(ScannerActivity.EXTRA_RESULT)
        }
    }

}
