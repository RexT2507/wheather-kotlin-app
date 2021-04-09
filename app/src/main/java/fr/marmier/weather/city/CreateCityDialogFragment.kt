package fr.marmier.weather.city

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import fr.marmier.weather.R

/**
 * CreateCityDialogFragment is a dialog that allow to display a modal to add new city in the list
 *
 */
class CreateCityDialogFragment : DialogFragment() {

    /**
     * CreateCityDialogListener is a interface that contain referencies of two action: add city or close dialog
     *
     */
    interface CreateCityDialogListener {
        fun onDialogPositiveClick(cityName: String)
        fun onDialogNegativeClick()
    }

    var listener: CreateCityDialogListener? = null

    /**
     * onCreateDialog create dialog with the native android component and initilize it with some string values
     *
     * @param savedInstanceState
     * @return
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(context)

        val input = EditText(context)
        with(input)
        {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = "Marseille, Istvaan"
        }

        /**
         * here we set all label and attach button to specific action
         */
        builder.setTitle(getString(R.string.create_city_title)).setView(input)
                .setPositiveButton(getString(R.string.create_city_button),
                    DialogInterface.OnClickListener {_, _->
                        listener?.onDialogPositiveClick((input.text.toString()))
                    }
                )
                .setNegativeButton(getString(R.string.create_city_cancel),
                    DialogInterface.OnClickListener {_, _->
                        listener?.onDialogNegativeClick()
                    }
                )
        return builder.create()

    }
}