package com.perroni.registroclienteapp.presentation.add_adit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.perroni.registroclienteapp.databinding.FragmentAddEditBinding
import com.perroni.registroclienteapp.util.MaskEditUtil

class AddFragment : Fragment() {

    private lateinit var viewModel: AddViewModel
    private var _binding: FragmentAddEditBinding? = null

    private val bind get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(
//            (requireActivity() as MainActivity),
//            AddViewModel.AddViewModelFactory(requireActivity().application))
//            .get(AddViewModel::class.java)
        listeners()
        applyMask()
    }

    private fun applyMask() {
        bind.etCPF.addTextChangedListener(
            MaskEditUtil.mask(bind.etCPF, MaskEditUtil.FORMAT_CPF)
        )
    }

    private fun listeners() {
        with(bind) {

            //botao
            btFinish.setOnClickListener {
//                viewModel.addUser(
//                    User(
//                        name = etName.text.toString(),
//                        cpf = etCPF.text.toString(),
//                        matricula = etMatricula.text.toString(),
//                        email = etEmail.text.toString(),
//                        )
//                )
            }

            //Nome
            etName.setOnEditorActionListener { _, action, _ ->
//                if(sharedVm.verifyFieldName(etName.text.toString())){
//                    print("passou")
//                }else{print("nao passou")}
                false
            }
            //Matricula
            etMatricula.setOnEditorActionListener { _, action, _ ->
//                if(vm.verifyFieldName(etName.text.toString())){
//                    print("passou")
//                }else{print("nao passou")}
                false
            }

            //CPF
            etCPF.setOnEditorActionListener { _, action, _ ->
//                if(vm.verifyFieldName(etName.text.toString())){
//                    print("passou")
//                }else{print("nao passou")}
                false
            }

            //EMail
            etEmail.setOnEditorActionListener { _, action, _ ->
//                if(vm.verifyFieldName(etName.text.toString())){
//                    print("passou")
//                }else{print("nao passou")}
                false
            }

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}