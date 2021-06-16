package com.example.noteplan.ui.fragment

import androidx.fragment.app.Fragment
import com.example.noteplan.R
import com.example.noteplan.base.BaseFragment
import com.example.noteplan.databinding.FragmentNoteBinding

class NoteFragment:BaseFragment<FragmentNoteBinding>(){

    override fun getSubLayoutId(): Int {
        return R.layout.fragment_note
    }

}