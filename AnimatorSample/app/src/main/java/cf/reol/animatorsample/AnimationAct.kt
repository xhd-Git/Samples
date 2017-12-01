package cf.reol.animatorsample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationAct : AppCompatActivity() {
    private var mType = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        initExtra()
        initView()
        initEvent()
    }

    private fun initEvent() {
        mColorView.setOnClickListener {
            mColorView.valueAnimator.start()
        }

        //ObjectAnimator 实现loading动画，线性插值器
        ivLoadingLeft.setOnClickListener {
            val anim = ObjectAnimator.ofFloat(ivLoadingLeft,"rotation",0f,360f)
            anim.repeatCount = ObjectAnimator.INFINITE
            anim.repeatMode = ObjectAnimator.RESTART
            anim.interpolator = LinearInterpolator()
            anim.duration = 800
            anim.start()
        }

        //View.animate() 实现loading动画，默认插值器
        ivLoadingRight.setOnClickListener {
            ivLoadingRight.animate()
                    .rotationBy(360f)
                    .setDuration(800)
//                    .setInterpolator(LinearInterpolator())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            ivLoadingRight.animate()
                                    .rotationBy(360f)
                                    .setDuration(800)
//                                    .setInterpolator(LinearInterpolator())
                                    .start()
                        }
                    }).start()
        }

        btnShowDialog.setOnClickListener{
            ExampleDialog(this@AnimationAct).show()
        }
    }

    private fun initView() {
        when (mType) {
            "value" -> {
                mColorView.visibility = View.VISIBLE
                tvAnimTitle.setText(R.string.value_animator_title)
                tvAnimDetail.setText(R.string.value_animator_detail)
            }
            "object" -> {
                layoutLoadingAnim.visibility = View.VISIBLE
                tvAnimTitle.setText(R.string.object_animator_title)
                tvAnimDetail.setText(R.string.object_animator_detail)
            }
            "xml" -> {
                btnShowDialog.visibility = View.VISIBLE
                tvAnimTitle.setText(R.string.xml_animator_title)
                tvAnimDetail.setText(R.string.xml_animator_detail)
            }
            else -> {

            }
        }
    }

    private fun initExtra() {
        mType = intent.getStringExtra("type")
    }


}
