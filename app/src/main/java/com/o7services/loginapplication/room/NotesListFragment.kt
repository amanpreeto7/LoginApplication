package com.o7services.loginapplication.room

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.o7services.loginapplication.R
import com.o7services.loginapplication.databinding.FragmentNotesListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotesListFragmen.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesListFragment : Fragment(), clickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentNotesListBinding
    private lateinit var roomActivity: RoomActivity
    private lateinit var roomRecycler: RoomRecycler
    private  var arrayList: ArrayList<Notes> = ArrayList()

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
        // Inflate the layout for this fragment
        binding = FragmentNotesListBinding.inflate(layoutInflater)
        binding.fabAdd.setOnClickListener {
            roomActivity.navController.navigate(R.id.addUpdateNotesFragment)
        }

        roomRecycler = RoomRecycler(arrayList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(roomActivity)
        binding.recyclerView.adapter = roomRecycler
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNotes()
    }

    private fun getNotes() {
        arrayList.clear()
        class getNotes: AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                 arrayList.addAll(NotesDatabase.getDatabase(roomActivity).userDao().getAll())
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                roomRecycler.notifyDataSetChanged()
            }
        }

        getNotes().execute()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotesListFragmen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun ClickInterface(notes: Notes) {
        class deleteNotes :AsyncTask<Notes, Void, Void>(){
            override fun doInBackground(vararg p0: Notes?): Void? {
                p0.get(0)?.let { NotesDatabase.getDatabase(roomActivity).userDao().deleteNotes(it) }
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                getNotes()
            }
        }
        deleteNotes().execute(notes)
    }
}