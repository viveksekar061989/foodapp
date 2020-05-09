package projctone.v2.com.navigationmenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         burger.setOnClickListener{viewDtlImg(R.drawable.burger)}
        sandwich.setOnClickListener{viewDtlImg(R.drawable.hotdog)}
        hotdog.setOnClickListener{viewDtlImg(R.drawable.sandwich)}

    }
 private fun viewDtlImg(imgId: Int){
     val intent= Intent(this,detaiImage::class.java)
     intent.setAction(Intent.ACTION_VIEW)
     val uri=Uri.parse("http://projectone.v2.comnavigationmenu/view?id=$imgId")

     intent.data=uri
     intent.putExtra("imgId",imgId)
     startActivity(intent)

 }

}
