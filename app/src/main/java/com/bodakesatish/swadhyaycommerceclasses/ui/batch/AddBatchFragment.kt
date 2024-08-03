package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddBatchBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AddBatchFragment : Fragment() {

    private var binding: FragmentAddBatchBinding? = null
    private val viewModel: AddBatchViewModel by viewModels()
    private var courseId : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBatchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseId = arguments?.getInt(Constants.COURSE_ID, 0) ?: 0

        binding?.btnAdd?.setOnClickListener {
            viewModel.addBatch(
                Batch(
                    0,
                    1,
                    1,
                    binding?.evBatchName?.text.toString(),
                    binding?.evBatchDescription?.text.toString(),
                    binding?.evBatchFee?.text.toString().toInt(),
                    binding?.evBatchDuration?.text.toString().toInt(),
                    Date(),
                    Date(),
                    binding?.evBatchMaxStrength?.text.toString().toInt()
                )
            )
        }

    }


}