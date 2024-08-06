package com.bodakesatish.swadhyaycommerceclasses.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.security.SessionManager
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    private var validateInput = false

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("In LoginFragmnet", "onCreate")
        if(sessionManager.getBoolean(Constants.SESSION_REMEMBER_ME, false)) {
            findNavController().navigate(R.id.admin_dashboard_dest)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("In LoginFragmnet", "onCreateView")
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    handleLoginSuccess()
                    findNavController().navigate(R.id.admin_dashboard_dest)
                }

                else -> {

                }
            }
        })
    }

    private fun handleLoginSuccess() {
        if(binding.cbRememberMe.isChecked) {
            sessionManager.set(Constants.SESSION_REMEMBER_ME, true)
            sessionManager.set(Constants.SESSION_USERNAME, binding.evUsername.editText?.text.toString().trim())
        }
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            if(validateInputs()) {
                viewModel.login(
                    binding.evUsername.editText?.text.toString().trim(),
                    binding.evPassword.editText?.text.toString().trim()
                )
            }
        }

    }

    private fun validateInputs() : Boolean{
        validateInput = true
        if (binding.evUsername.editText?.text?.toString()?.isBlank() == true) {
            binding.evUsername.editText?.error = "This username is required"
            validateInput = false
        } else {
            binding.evUsername.editText?.error = null // Clear the error
        }

        if (binding.evPassword.editText?.text?.toString()?.isBlank() == true) {
            binding.evPassword.editText?.error = "This password is required"
            validateInput = false
        } else {
            binding.evPassword.editText?.error = null // Clear the error
        }
        return validateInput
    }

    override fun onDestroyView() {
        Log.i("In LoginFragmnet", "onDestroyView")
        viewModel.setLoginResponse(Resource.None())
        super.onDestroyView()
    }
}