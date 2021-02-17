package com.example.kopashop.ui.list


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.kopashop.R
import com.example.kopashop.core.fragment.BaseBindingFragment
import com.example.kopashop.core.fragment.BaseVMFragment
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.model.BootsViewModel
import com.google.firebase.database.DatabaseReference


class FirstFragment : BaseBindingFragment<FragmentFirstBinding>() {

    private lateinit var database: DatabaseReference
    /*
    private val model: BootsViewModel by lazy {
        ViewModelProviders.of(this).get(BootsViewModel::class.java)
    }
     */


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView.adapter
    }

    override val layoutId: Int
        get() = R.layout.fragment_first

}


    /*
    private fun writeNewPost(title: String,
                             width: Int,
                             price: Int,
                             length: Int,
                             material: String) {
        val key = database.child("posts").push().key
        if (key == null) {
            Log.w(TAG, "Couldn't get push key for posts")
            return
        }

        val post = Boots(title, width, price, length, material)
        val postValues = post.toMap()

        val childUpdates = hashMapOf<String, Any>(
            "/posts/$key" to postValues,
            "boots-posts/$title/$key" to postValues
        )

        database.updateChildren(childUpdates)
    }
}

     */
        /*
        val divItemDecor = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        val adapter = BootsAdapter()
        binding.listView.layoutManager = LinearLayoutManager(context)
        binding.listView.adapter = adapter

        binding.listView.addItemDecoration(divItemDecor)

        model.getListBoots().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshList(it)
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing.not()
        }
    }
    */
        /*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.swipeRefreshLayout -> {
                model.updateListBoots()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

         */
    /*
    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("\$Nike elements")}
        return data
    }
     */