package projctone.v2.com.navigationmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_buttonlayout.*

class buttonlayout : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttonlayout)
        val img = intent.extras!!.getInt("orderedImg")
        val imgDtl = intent.extras!!.getString("imgDtl").toString()
        orderImage.setImageResource(img)

        val msg = getString(R.string.orderDtls, imgDtl)
        orderText.setText(msg)
        orderButton.setOnClickListener {
            val name = nameText.text.toString()
            val flatNo = flatText.text.toString()

            val msgToUsr = getString(R.string.msgtoUsr, name, flatNo)
            // val msgToUsr="Hi"
            Snackbar.make(it, "Total amount is 500", Snackbar.LENGTH_LONG)
                .setAction("click Here to confirm", { showToastmsg(msgToUsr) }).show()
        }
    }

    private fun showToastmsg(msgToUsr: String) {
        Toast.makeText(this, msgToUsr, Toast.LENGTH_LONG).show()
        // Snackbar.make(this,"order Recieved by vendor",Snackbar.LENGTH_LONG).show()
    }


/* private fun showToastmsg(msg:String,viewobj :) {
     Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
     Snackbar.make(buttonlayout::class.java,"order Recieved by vendor",Snackbar.LENGTH_LONG).show()
 }
}*/
}