package com.o7services.loginapplication.room

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.o7services.loginapplication.R
import com.o7services.loginapplication.databinding.FragmentAddUpdateNotesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddUpdateNotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddUpdateNotesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAddUpdateNotesBinding
    private lateinit var roomActivity: RoomActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomActivity = activity as RoomActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddUpdateNotesBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.btnSave.setOnClickListener {
            if(binding.etTitle.text.toString().isNullOrEmpty()){
                binding.etTitle.error = resources.getString(R.string.enter_title)
                binding.etTitle.requestFocus()
            }else  if(binding.etDescription.text.toString().isNullOrEmpty()){
                binding.etDescription.error = resources.getString(R.string.enter_description)
                binding.etDescription.requestFocus()
            }else{
                saveNotes()
            }
        }
        return binding.root
    }

    private fun saveNotes() {
        class saveNote : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                var notes =  Notes()
                notes.id = 0
                notes.title = binding.etTitle.text.toString()
                notes.description = binding.etDescription.text.toString()
                NotesDatabase.getDatabase(roomActivity).userDao().insertNotes(notes)
                return  null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(roomActivity, resources.getString(R.string.data_saved), Toast.LENGTH_SHORT).show()
            }
        }
        saveNote().execute()


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddUpdateNotesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddUpdateNotesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}