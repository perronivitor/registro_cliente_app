package com.perroni.registroclienteapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gruppe.cardapiofood.navigateWithAnimations
import com.perroni.registroclienteapp.MainActivity
import com.perroni.registroclienteapp.R
import com.perroni.registroclienteapp.databinding.FragmentHomeBinding
import com.perroni.registroclienteapp.domain.UserEntity


class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(
//            (requireActivity() as MainActivity),
//            HomeViewModel.HomeViewModelFactory(requireActivity().application))
//            .get(HomeViewModel::class.java)

        prepareRecyclerView()
        listeners()
        observers()
    }

    private fun observers() {
//        viewModel.success.nonNullObserve(viewLifecycleOwner) { message ->
//            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//            viewModel.success.value = null;
//        }
//
//        viewModel.error.nonNullObserve(viewLifecycleOwner) { message ->
//            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//            viewModel.success.value = null;
//        }
//
//        viewModel.getAllUsers.nonNullObserve(viewLifecycleOwner, {
//            (binding.recyclerView.adapter as HomeAdapter).setData(it)
//        })

    }

    private fun prepareRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = HomeAdapter {
                navToEditUser(it)
            }
        }
    }

    private fun navToEditUser(user: UserEntity) {
        findNavController().navigateWithAnimations(R.id.action_nav_home_to_nav_add_edit)
    }

    private fun listeners() {
        with(binding) {
            fabAdd.setOnClickListener {
                navToAddFragment()
            }
        }
    }

    private fun navToAddFragment() {
        findNavController().navigateWithAnimations(R.id.action_nav_home_to_nav_add_edit)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}