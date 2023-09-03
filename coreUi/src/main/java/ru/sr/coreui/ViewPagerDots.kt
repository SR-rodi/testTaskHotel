package ru.sr.coreui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import ru.sr.coreui.databinding.ViewPagerDotsBinding

class ViewPagerDots @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : CardView(context, attrs) {

    private var binding: ViewPagerDotsBinding? = ViewPagerDotsBinding.inflate(LayoutInflater.from(context))
    private val tabLayoutMediator =  TabLayoutMediator(binding!!.tabLayout, binding!!.viewPager){a,b->}

    fun setAdapter(adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) {
        binding?.viewPager?.adapter = adapter
        tabLayoutMediator.attach()
        addView(binding?.root)
    }

    fun detach() {
        binding = null
        tabLayoutMediator.detach()
    }

}