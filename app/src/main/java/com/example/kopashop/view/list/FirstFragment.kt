package com.example.kopashop.view.list


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kopashop.R
import com.example.kopashop.model.BootsAdapter
import com.example.kopashop.databinding.FragmentFirstBinding
import com.example.kopashop.model.BootsViewModel


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val bootsViewModel by lazy { ViewModelProviders.of(this).get(BootsViewModel::class.java) }


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

        val divItemDecor = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        val adapter = BootsAdapter()
        binding.listView.layoutManager = LinearLayoutManager(context)
        binding.listView.adapter = adapter

        binding.listView.addItemDecoration(divItemDecor)

        bootsViewModel.getListBoots().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.refreshList(it)
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing.not()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.swipeRefreshLayout -> {
                bootsViewModel.updateListBoots()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    /*
    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("\$Nike elements")}
        return data
    }
     */
}