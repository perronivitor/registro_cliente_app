package com.perroni.registroclienteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gruppe.cardapiofood.navigateWithAnimations
import com.perroni.registroclienteapp.R
import com.perroni.registroclienteapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var vm: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
    }

    private fun listeners() {
        with(binding){
            fabAdd.setOnClickListener {
                navToAddFragment()
            }
        }
    }

    private fun navToAddFragment(){
        findNavController().navigateWithAnimations(R.id.action_nav_home_to_nav_add_edit)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}