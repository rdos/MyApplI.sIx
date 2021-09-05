package asu.thr.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import asu.thr.myapplication.database.Cat
import com.squareup.picasso.Picasso
import asu.thr.myapplication.z.TtestO

private const val TAG = "PhotoGalleryFragment"
private val integer15 = 2
// TODO: 11.09.2021 ][3       =х.3.  otherwise по-любому ну это уж соВсем всё грустно...
/*
    //x=экс!
        // TODO: 02.09.2021 o=оу!!  u=ю
        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            val galleryItem = "abcdefghIjklmnOp"[position]
 */

//sealed
class GalleryListFragment : Fragment() {

    var mItemShowN = 1
    private var mCallbacksAct: Callbacks? = null

    interface Callbacks {
        fun onGalleryItemSelected()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallbacksAct = context as? Callbacks
    }
    override fun onDetach() {
        super.onDetach()
        mCallbacksAct = null
    }


    private lateinit var mCatsViewModel: CatsListViewModel
    private lateinit var photoRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        mCatsViewModel = ViewModelProvider(this).get(CatsListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list_cats, container, false)

        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        //
        val layoutManager = LinearLayoutManager(context)
//        layoutManager.reverseLayout = true
//        layoutManager.stackFromEnd = true
        photoRecyclerView.layoutManager = layoutManager

//        photoRecyclerView.setOnClickListener(this)
        // TODO: 01.09.2021 https://vk.com/thr_1 гля котик на аватаРрр..
//        photoRecyclerView.adapter = PhotoAdapter()
//        var img: ImageView;
//        img.setImageBitmap()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCatsViewModel.catsLiveDate.observe(
            viewLifecycleOwner,
            { cats ->
                cats?.let {
                    Log.d(TAG, "mafka: 0)ne ${it.size}")
                    photoRecyclerView.adapter = PhotoAdapter(it, context)
                }
            }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_crime_menu, menu)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_crime -> {
//                val cat = Cat()
//                galleryViewModel.addCat(cat)
                mCallbacksAct?.onGalleryItemSelected()
                true
            }
            R.id.ttest -> {
//                val cat = Cat()
//                galleryViewModel.addCat(cat)
//                mCatsViewModel.showNewTODO(mItemShowN)
                mItemShowN++
                photoRecyclerView.adapter?.notifyDataSetChanged()
//                mCallbacksAct?.onGalleryItemSelected()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    inner class PhotoHolder(itemTextView: View) : RecyclerView.ViewHolder(itemTextView), View.OnLongClickListener  {
        val bindTitle: (CharSequence) -> Unit = itemTextView.findViewById<TextView>(R.id.textView2)::setText
        val bindImage: ImageView = itemTextView.findViewById(R.id.imageView2)
        var catIdL = 0

        init {
            itemTextView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            mCatsViewModel.deleteCat(catIdL)
            mItemShowN--
            return true
        }
    }


    inner class PhotoAdapter(private val galleryItems: List<Cat>, val context: Context?)
        : RecyclerView.Adapter<PhotoHolder>() {


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PhotoHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_cats_item, parent, false)
            return PhotoHolder(view)
        }

        override fun getItemCount(): Int = mItemShowN - 1

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            val cat = galleryItems[position]

            holder.bindTitle(cat.date_date)
            val urlS = cat.urlAddress
            holder.catIdL = cat.id!!
            TtestO().sayHello("$holder.catIdL")

            Picasso.with(context)
                .load(urlS)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_error_load)
                .into(holder.bindImage);

        }


    }

//    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
//        Log.d(TAG, "onClick:/:r_dos")
//    }

    companion object {
        fun newInstance() = GalleryListFragment()
    }

}