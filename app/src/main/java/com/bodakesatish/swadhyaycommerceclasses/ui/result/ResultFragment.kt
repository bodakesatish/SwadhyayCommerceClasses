package com.bodakesatish.swadhyaycommerceclasses.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentExamListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private var binding: FragmentResultBinding? = null
    private val viewModel: ResultViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}