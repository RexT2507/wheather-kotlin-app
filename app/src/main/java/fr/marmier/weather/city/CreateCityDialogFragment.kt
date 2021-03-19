package fr.marmier.weather.city

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import fr.marmier.weather.R

class CreateCityDialogFragment : DialogFragment() {

    interface CreateCityDialogListener {
        fun onDialogPositiveClick(cityName: String)
        fun onDialogNegativeClick()
    }

    var listener: CreateCityDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(context)

        val input = EditText(context)
        with(input)
        {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = "Marseille, Istvaan"
        }

        builder.setTitle(getString(R.string.createcity_title)).setView(input)
                .setPositiveButton(getString(R.string.createcity_button),
                    DialogInterface.OnClickListener {_, _->
                        listener?.onDialogPositiveClick((input.text.toString()))
                    }
                )
                .setNegativeButton(getString(R.string.createcity_cancel),
                    DialogInterface.OnClickListener {_, _->
                        listener?.onDialogNegativeClick()
                    }
                )
        return builder.create()

    }
}