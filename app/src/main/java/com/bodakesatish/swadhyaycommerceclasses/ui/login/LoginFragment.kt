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
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    private val viewModel: LoginViewModel by viewModels()

    private var oneTapClient: SignInClient? = null
    private var signInRequest: BeginSignInRequest? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            this.btnLogin.setOnClickListener {
                viewModel.login(
                    evUsername.editText?.text.toString(),
                    evPassword.editText?.text.toString()
                )
            }
        }

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            response ->
                when (response) {
                    is Resource.Success -> {
                        findNavController().navigate(R.id.admin_dashboard_dest)
                    }

                    else -> {

                    }
                }
        })

    }

    fun onTapSignIn() {
        oneTapClient = Identity.getSignInClient(requireActivity());
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(
                BeginSignInRequest.PasswordRequestOptions.builder()
                .setSupported(true)
                .build())
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)

                .setServerClientId(getString(R.string.default_web_client_id))

                .setFilterByAuthorizedAccounts(true)
                .build())

            .setAutoSelectEnabled(true)
            .build();
    }

    override fun onDestroyView() {
        Log.i("In LoginFragmnet","onDestroyView")
        viewModel.setLoginResponse(Resource.None())
        binding = null
        super.onDestroyView()
    }
}