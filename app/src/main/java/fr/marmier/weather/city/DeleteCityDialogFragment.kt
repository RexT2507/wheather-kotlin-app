package fr.marmier.weather.city

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import fr.marmier.weather.R

/**
 * City suppression class
 *
 */
class DeleteCityDialogFragment: DialogFragment() {

    /**
     * Call on a positive or negative click
     *
     */
    interface  DeleteCityDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    /**
     * We go through a companion in order to be able to continue instantiating it while keeping the constructor
     */
    companion object {

        val EXTRA_CITY_NAME = "project.kotlin.weather.extras.EXTRA_CITY_NAME"

        /**
         * Allows you to pass the name of a city by a key
         *
         * @param cityName
         * @return
         */
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

    /**
     * Allows to initialize our key seen previously
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityName = arguments!!.getString(EXTRA_CITY_NAME)!!
    }

    /**
     * Allows you to display the messages according to the deletion context
     *
     * @param savedInstanceState
     * @return
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(getString(R.string.delete_city_title, cityName))
            .setPositiveButton(getString(R.string.delete_city_positive), DialogInterface.OnClickListener { _, _ -> listener?.onDialogPositiveClick()})
            .setNegativeButton(getString(R.string.delete_city_negative), DialogInterface.OnClickListener { _, _ -> listener?.onDialogNegativeClick()})
        return  builder.create()
    }
}
