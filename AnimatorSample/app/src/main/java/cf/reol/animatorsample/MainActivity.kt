package cf.reol.animatorsample

import android.animation.ObjectAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mIntent = Intent(this@MainActivity, AnimationAct::class.java)
        btnValue.setOnClickListener {
            mIntent.putExtra("type", "value")
            startActivity(mIntent)
        }

        btnObject.setOnClickListener {
            mIntent.putExtra("type", "object")
            startActivity(mIntent)
        }

        btnView.setOnClickListener {
            mIntent.putExtra("type", "xml")
            startActivity(mIntent)
        }
    }
}
