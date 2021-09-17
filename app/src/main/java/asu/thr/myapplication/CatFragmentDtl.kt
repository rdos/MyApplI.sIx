package asu.thr.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import asu.thr.myapplication.database.Cat
import asu.thr.myapplication.z.TtestO
import java.util.*

private const val TAG = "CrimeFragment"
private const val ARG_CRIME_ID = "crime_id"
private const val DIALOG_DATE = "DialogDate"
private const val REQUEST_DATE = 0
private const val REQUEST_CONTACT = 1
private const val REQUEST_PHOTO = 2
private const val DATE_FORMAT = "EEE, MMM, dd"

class CatFragmentDtl : Fragment(), DatePickerFragment.Callbacks {

    companion object {

        fun newInstance(): CatFragmentDtl {
            val args = Bundle().apply {
//                putSerializable(ARG_CRIME_ID, crimeId)
            }
            return CatFragmentDtl().apply {
                arguments = args
            }
        }
    }


    private val mCatDtlDtlViewModel: CatDtlViewModel by lazy {
        ViewModelProvider(this).get(CatDtlViewModel::class.java)
    }

    private val mCatsListViewModel: CatsListViewModel by lazy {
        ViewModelProvider(this).get(CatsListViewModel::class.java)
    }

    override fun onDateSelected(date: Date) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mGalleryViewModel.galleryItemLiveData.observe(
//            viewLifecycleOwner,
//            { flickrResponse ->
//                Log.d(TAG, "r_dosЗДЕЦ $flickrResponse")
//                mCatDtlViewModel.addCats(flickrResponse)
////                photoRecyclerView.adapter = GalleryListFragment.PhotoAdapter(galleryItems, context)
//                return@observe
//            }
//        )
    }

    override fun onStart() {
        super.onStart()
//        mCatDtlViewModel.catsLiveDate.observe(
//            viewLifecycleOwner,
//            Observer { cats ->
//                cats?.let {
//                    Log.i(TAG, "GoD r_dosЗДЕЦ ${it.size}")
//                    updateUI(cats)
//                }
//            }
//        )
    }

    private fun updateUI(catEntities: List<Cat>) {
        TtestO().sayHello(catEntities[catEntities.size-1].url_url)
        TtestO().sayHello("${catEntities[catEntities.size-1].id}")
        TtestO().sayHello("${catEntities.size}")

//        TODO("Not yet implemented")
    }
}