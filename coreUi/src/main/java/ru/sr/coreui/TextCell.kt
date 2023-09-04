package ru.sr.coreui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.sr.coreui.databinding.TextCellBinding

class TextCell @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val binding = TextCellBinding.inflate(LayoutInflater.from(context))

    init {
        setAttribute(attrs)
        addView(binding.root)
    }


    @SuppressLint("Recycle")
    private fun setAttribute(attrs: AttributeSet?) {
        val typArray = context.obtainStyledAttributes(attrs, R.styleable.TextCell)

       /* binding.title.text = typArray.getText(R.styleable.TextCell_text_cell_title)*/
       /* binding.subtitle.text = typArray.getText(R.styleable.TextCell_text_cell_subtitle)*/

        typArray.recycle()
    }

    fun setSubtitle(text: String) {
//        binding.subtitle.text = text
    }
}