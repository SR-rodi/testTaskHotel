package ru.sr.coreui

import android.annotation.SuppressLint
import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import ru.sr.coreui.databinding.ToolBarBinding

class ToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val binding = ToolBarBinding.inflate(LayoutInflater.from(context))

    init {
        setAttribute(attrs)
        addView(binding.root)
    }

    @SuppressLint("Recycle")
    private fun setAttribute(attrs: AttributeSet?) {
        val typArray = context.obtainStyledAttributes(attrs, R.styleable.ToolBar)

        binding.toolbarTitle.text = typArray.getText(R.styleable.ToolBar_toolBar_title)
        binding.toolbarTitle.gravity = View.TEXT_ALIGNMENT_CENTER
        typArray.recycle()
    }

    fun setArrowClickListener(action: () -> Unit) {
        binding.toolBar.setNavigationOnClickListener {
            action()
        }
    }

}