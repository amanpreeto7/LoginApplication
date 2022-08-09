package com.o7services.loginapplication.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.o7services.loginapplication.R
import com.o7services.loginapplication.databinding.FragmentBaseAdapterListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BaseAdapterListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BaseAdapterListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentBaseAdapterListBinding
    var arrayList: ArrayList<BaseAdapterDataClass> = ArrayList()
    lateinit var baseAdapterClass: BaseAdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBaseAdapterListBinding.inflate(layoutInflater)
        arrayList.add(BaseAdapterDataClass(1,1001,"Sumit"))
        arrayList.add(BaseAdapterDataClass(2,1002,"Varun"))
        arrayList.add(BaseAdapterDataClass(3,1003,"Harman"))
        arrayList.add(BaseAdapterDataClass(4,1004,"Arshdeep"))
        baseAdapterClass = BaseAdapterClass(requireContext(), arrayList)
        binding.list.adapter = baseAdapterClass

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BaseAdapterListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BaseAdapterListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}