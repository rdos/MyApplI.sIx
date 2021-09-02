package ru.chibbistest.myapplication

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "PhotoGalleryFragment"
private val integer15 = 15
//sealed
class PhotoGalleryFragment : Fragment(), View.OnClickListener {

//    private lateinit var photoGalleryViewModel: PhotoGalleryViewModel
    private lateinit var photoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
//        photoGalleryViewModel =
//                ViewModelProviders.of(this).get(PhotoGalleryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)

        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        photoRecyclerView.layoutManager = GridLayoutManager(context, integer15)

        photoRecyclerView.setOnClickListener(this)
        // TODO: 01.09.2021 https://vk.com/thr_1 гля котик на аватаРрр..
        photoRecyclerView.adapter = PhotoAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        photoGalleryViewModel.galleryItemLiveData.observe(
//            viewLifecycleOwner,
//            Observer { galleryItems ->
//                Log.d(TAG, "Have gallery items from view model $galleryItems")
//                photoRecyclerView.adapter = PhotoAdapter(galleryItems)
//            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_crime_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_crime -> {
//                val crime = Crime()
//                crimeListViewModel.addCrime(crime)
//                callbacks?.onCrimeSelected(crime.id)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private class PhotoHolder(itemTextView: TextView)
        : RecyclerView.ViewHolder(itemTextView) {

        val bindTitle: (CharSequence) -> Unit = itemTextView::setText
    }

    private class PhotoAdapter()
        : RecyclerView.Adapter<PhotoHolder>(), View.OnClickListener {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PhotoHolder {
            val textView = TextView(parent.context)
            textView.setOnClickListener(this)
            return PhotoHolder(textView)
        }

        override fun getItemCount(): Int = integer15
            //x=экс!
        // TODO: 02.09.2021 o=оу!!  u=ю
        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            val galleryItem = "abcdefghIjklmnOp"[position]
            holder.bindTitle(galleryItem.toString())
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }


    override fun onClick(v: View?) {
        TODO("Not yet implemented")
        Log.d(TAG, "onClick:/:r_dos")
    }

    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }
}