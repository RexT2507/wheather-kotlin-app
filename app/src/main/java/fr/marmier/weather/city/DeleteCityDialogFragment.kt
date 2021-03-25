package fr.marmier.weather.city

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import fr.marmier.weather.R

/**
 * City deletion class
 *
 */
class DeleteCityDialogFragment: DialogFragment() {

    /**
     * TODO
     *
     */
    interface  DeleteCityDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    companion object {

        val EXTRA_CITY_NAME = "project.kotlin.weather.extras.EXTRA_CITY_NAME"

        fun newInstance(cityName: String) : DeleteCityDialogFragment {

            val fragment = DeleteCityDialogFragment()

            fragment.arguments = Bundle().apply {
                putString(EXTRA_CITY_NAME, cityName)
            }
            return fragment
        }
    }

    var listener: DeleteCityDialogListener? = null
    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityName = arguments!!.getString(EXTRA_CITY_NAME)!!
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.delete_city_title, cityName))
            .setPositiveButton(getString(R.string.delete_city_positive), DialogInterface.OnClickListener { _, _ -> listener?.onDialogPositiveClick()})
            .setNegativeButton(getString(R.string.delete_city_negative), DialogInterface.OnClickListener { _, _ -> listener?.onDialogNegativeClick()})
        return  builder.create()
    }
}
