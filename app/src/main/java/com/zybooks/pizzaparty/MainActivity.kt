package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * Main activity
 *
 * This class calculates the number of slices for
 * each person.
 * @author Fahri Yildiz
 */
class MainActivity : ComponentActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    /**
     * Creates the view
     * @property savedInstanceState is the instance state
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Stores the Edit Text in a variable
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        // Stores the Text View in a variable
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        // Stores the Radio Group in a variable
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    /**
     * This function is activated when the user clicks on
     * the "calculate" button
     * @property view the actual view
     */
    fun calculateClick(view: View) {
        // Gets the value entered into Edit Text
        val numAttendStr = numAttendEditText.text.toString()
        // Parse the value to integer
        val numAttend = numAttendStr.toInt()
        // Determines which radio button was pressed to set slicesPerPerson
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }
        // Calculates the total number of pizzas
        val totalPizzas = ceil(numAttend * slicesPerPerson /
                SLICES_PER_PIZZA.toDouble()).toInt()
        // Shows the total pizzas in the Text View
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}

