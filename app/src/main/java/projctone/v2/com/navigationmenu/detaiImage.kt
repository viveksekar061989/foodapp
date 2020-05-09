package projctone.v2.com.navigationmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail_image.*

class detaiImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)
        if (intent.action==Intent.ACTION_SEND){
            val textFrmApp=intent?.getStringExtra(Intent.EXTRA_TEXT)?.toLowerCase()
            Toast.makeText(this,"you have selected $textFrmApp",Toast.LENGTH_SHORT).show()
             val toShowimg=resources.getIdentifier(textFrmApp?.trim(),"drawable",packageName)
            dtlImg.setImageResource(toShowimg)
            return

        }
        val lastpart=intent.data?.lastPathSegment
        if(lastpart!!.equals("view")){
            val imgView=intent.data?.getQueryParameter("id")
            Log.i("intent","queryparam=$imgView")
        }

        val img= intent.extras!!.getInt("imgId")
        Log.i("hello","queryparam=$img")
        dtlImg.setImageResource(img)
        Log.i("hello2","queryparam=$img")


    }
}
