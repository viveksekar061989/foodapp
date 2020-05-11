package projctone.v2.com.navigationmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_image.*

class detaiImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)
        if (intent.action == Intent.ACTION_SEND) {
            val textFrmApp = intent?.getStringExtra(Intent.EXTRA_TEXT)?.toLowerCase()
            Toast.makeText(this, "you have selected $textFrmApp", Toast.LENGTH_SHORT).show()
            val toShowimg = resources.getIdentifier(textFrmApp?.trim(), "drawable", packageName)
            dtlImg.setImageResource(toShowimg)
            return

        }
        val lastpart = intent.data?.lastPathSegment
        if (lastpart!!.equals("view")) {
            val imgView = intent.data?.getQueryParameter("id")
            Log.i("intent", "queryparam=$imgView")
        }

        val img = intent.extras!!.getInt("imgId")
        val imgDtl= intent.extras!!.getString("imgDtl").toString()
        Log.i(getString(R.string.hello), "queryparam=$img")
        dtlImg.setImageResource(img)
        orderDtl.text = imgDtl
        Log.i(getString(R.string.hello2), "queryparam=$img")

        dtlImg.setOnClickListener{viewBookingLayout(img,imgDtl)}


    }

    private fun viewBookingLayout(orderImg: Int,imgDtl :String) {
        val bookingIntent = Intent(this, buttonlayout::class.java)
        bookingIntent.putExtra("orderedImg",orderImg)
        bookingIntent.putExtra("imgDtl",imgDtl)
        startActivity(bookingIntent)

}
}
