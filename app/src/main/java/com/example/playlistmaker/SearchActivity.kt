package com.example.playlistmaker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.view.isVisible

class SearchActivity : AppCompatActivity() {
    private var searchText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val backButSearch = findViewById<ImageButton>(R.id.backButtonSearch)
        backButSearch.setOnClickListener {
            finish()
        }

        val editText = findViewById<EditText>(R.id.edit_text)
        editText.setText(searchText)
        val clearButton = findViewById<Button>(R.id.clear_button)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchText = s.toString()
                clearButton.isVisible = s.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        clearButton.setOnClickListener {
            editText.text.clear()

            val keyboard = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            keyboard.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("searchText", searchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchText = savedInstanceState.getString("searchText", "")
        val editText = findViewById<EditText>(R.id.edit_text)
        editText.setText(searchText)
    }
}