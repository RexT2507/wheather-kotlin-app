package fr.marmier.weather.city

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.marmier.weather.App
import fr.marmier.weather.Database
import fr.marmier.weather.R
import fr.marmier.weather.databinding.FragmentCityBinding
import fr.marmier.weather.utils.toast

/**
 *  Display the content of cities and manipulate the various data of the corresponding cities
 *
 */
class CityFragment : Fragment(), CityAdapter.CityItemListener {


    interface CityFragmentListener{
        fun onCitySelected(city: City){

        }
    }

    var listener: CityFragmentListener? = null

    private lateinit var binding: FragmentCityBinding

    private lateinit var cities: MutableList<City>
    private lateinit var database: Database
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CityAdapter

    /**
     * Used to instantiate the Option Menu and the database
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = App.database
        setHasOptionsMenu(true)
    }

    /**
     * Allows to make the link with the Layout
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        val view = binding.root
        recyclerView = binding.citiesRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    /**
     * Allows us to instantiate the city view and retrieve the list of its lists
     *
     * @param view
     * @param savedInstanceState
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cities = database.getAllCities()
        adapter = CityAdapter(cities, this)
        recyclerView.adapter = adapter
    }

    /**
     * The flag is true so we can overload in order to populate the createOptionMenu
     *
     * @param menu
     * @param inflater
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater?.inflate(R.menu.fragment_city, menu)
    }

    /**
     * Allows click management
     *
     * @param item
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.action_create_city -> {
                showCreateCityDialog()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * The function displays the Dialog
     *
     */
    private fun showCreateCityDialog(){
        val createCityFragment = CreateCityDialogFragment()
        createCityFragment.listener = object: CreateCityDialogFragment.CreateCityDialogListener{
            override fun onDialogPositiveClick(cityName: String){
                saveCity(City(cityName))
            }

            override fun onDialogNegativeClick(){

            }
        }

        createCityFragment.show(fragmentManager!!, "CreateCityDialogFragment")
    }

    /**
     * Save a city in the database
     *
     * @param city
     */
    private fun saveCity(city: City){
        if(database.createCity(city)){
            cities.add(city)
            adapter.notifyDataSetChanged()
        }else {
            context?.toast(getString(R.string.error_message_city_create))
        }
    }

    /**
     * Remove a city from the database
     *
     * @param city
     */
    private fun deleteCity(city: City) {
        if(database.deleteCity(city)) {
            cities.remove(city)
            adapter.notifyDataSetChanged()
            context?.toast(getString(R.string.error_message_city_delete, city.name))
        }else {
            context?.toast(getString(R.string.error_message_city_canot_delete, city.name))
        }
    }

    /**
     * Select a city
     *
     * @param city
     */
    override fun onCitySelected(city: City) {
        listener?.onCitySelected(city)
    }

    /**
     * Delete a city
     *
     * @param city
     */
    override fun onCityDeleted(city: City) {
        showDeleteCityDialog(city)
    }

    /**
     * Display of the removal pop-up
     *
     * @param city
     */
    private fun showDeleteCityDialog(city: City) {
        val deleteCityFragment = DeleteCityDialogFragment.newInstance(city.name)

        deleteCityFragment.listener = object: DeleteCityDialogFragment.DeleteCityDialogListener {
            override fun onDialogPositiveClick() {
                deleteCity(city)
            }

            override fun onDialogNegativeClick() {

            }

        }
        deleteCityFragment.show(fragmentManager!!, "DeleteCityDialogFragment")

    }

}