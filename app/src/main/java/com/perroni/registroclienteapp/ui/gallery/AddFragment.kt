package com.perroni.registroclienteapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.perroni.registroclienteapp.databinding.FragmentAddEditBinding

class AddFragment : Fragment() {

    private lateinit var vm: AddViewModel
    private var _binding: FragmentAddEditBinding? = null

    private val bind get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentAddEditBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
    }

    private fun listeners() {
        with(bind){

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}