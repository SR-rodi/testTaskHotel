package ru.sr.coreui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import ru.sr.coreui.databinding.ButtonWidgetBinding

class ButtonWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ButtonWidgetBinding.inflate(LayoutInflater.from(context))

    init {
        setAttribute(attrs)
        addView(binding.root)
    }

    @SuppressLint("Recycle")
    private fun setAttribute(attrs: AttributeSet?) {
        val typArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonWidget)

        binding.title.text = typArray.getText(R.styleable.ButtonWidget_button_widget_title)
        binding.subtitle.text = typArray.getText(R.styleable.ButtonWidget_button_widget_subtitle)
        binding.divider.isVisible = typArray.getBoolean(R.styleable.ButtonWidget_button_widget_divider_visible,true)

        binding.icon.setImageResource(
            typArray.getResourceId(
                R.styleable.ButtonWidget_button_widget_icon,
                R.drawable.star_rate
            )
        )
        typArray.recycle()
    }

}