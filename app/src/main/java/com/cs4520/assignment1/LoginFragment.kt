package com.cs4520.assignment1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment1.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {
    private var _binding: LoginFragmentBinding? = null

    private val binding get() = _binding!!
    private fun verifyLogin() : Boolean {
        return binding.loginUsernameInput.text.toString() == "admin"
                && binding.loginPwInput.text.toString() == "admin"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener {
            if (verifyLogin()) {
                Log.i("pressed login", "log")
                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            } else {
                val message = "Invalid login"
                val toast = Toast.makeText(this.context, "Invalid user credentials", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}