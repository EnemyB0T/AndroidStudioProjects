package com.example.testwordle

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private lateinit var attempts : List<List<TextView>>
    private lateinit var buttons : List<Button>
    private lateinit var solution : String
    private lateinit var solutionText : TextView
    private lateinit var checkSolution : List<Char>
    private lateinit var buttonBackspace : Button
    private lateinit var buttonEnter : Button
    private lateinit var winner : TextView
    private var slot = 0
    private var attempted : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val attemptAA: TextView = findViewById(R.id.attempt11)
        val attemptAB: TextView = findViewById(R.id.attempt12)
        val attemptAC: TextView = findViewById(R.id.attempt13)
        val attemptAD: TextView = findViewById(R.id.attempt14)
        val attemptAE: TextView = findViewById(R.id.attempt15)

        val attemptBA: TextView = findViewById(R.id.attempt21)
        val attemptBB: TextView = findViewById(R.id.attempt22)
        val attemptBC: TextView = findViewById(R.id.attempt23)
        val attemptBD: TextView = findViewById(R.id.attempt24)
        val attemptBE: TextView = findViewById(R.id.attempt25)

        val attemptCA: TextView = findViewById(R.id.attempt31)
        val attemptCB: TextView = findViewById(R.id.attempt32)
        val attemptCC: TextView = findViewById(R.id.attempt33)
        val attemptCD: TextView = findViewById(R.id.attempt34)
        val attemptCE: TextView = findViewById(R.id.attempt35)

        val attemptDA: TextView = findViewById(R.id.attempt41)
        val attemptDB: TextView = findViewById(R.id.attempt42)
        val attemptDC: TextView = findViewById(R.id.attempt43)
        val attemptDD: TextView = findViewById(R.id.attempt44)
        val attemptDE: TextView = findViewById(R.id.attempt45)

        val attemptEA: TextView = findViewById(R.id.attempt51)
        val attemptEB: TextView = findViewById(R.id.attempt52)
        val attemptEC: TextView = findViewById(R.id.attempt53)
        val attemptED: TextView = findViewById(R.id.attempt54)
        val attemptEE: TextView = findViewById(R.id.attempt55)


        // Initialize a nested list to hold all TextViews
//        attempts = List(5) { row ->
//            List(5) { col ->
//                val idString = "attempt${(row , 1 , 64).toChar()}${col , 1}"
//                val id = resources.getIdentifier(idString, "id", packageName)
//                findViewById<TextView>(id)
//            }
//        }




        attempts = (listOf(listOf<TextView>(attemptAA, attemptAB, attemptAC, attemptAD, attemptAE),
                           listOf<TextView>(attemptBA, attemptBB, attemptBC, attemptBD, attemptBE),
                           listOf<TextView>(attemptCA, attemptCB, attemptCC, attemptCD, attemptCE),
                           listOf<TextView>(attemptDA, attemptDB, attemptDC, attemptDD, attemptDE),
                           listOf<TextView>(attemptEA, attemptEB, attemptEC, attemptED, attemptEE)))


        // Letters for a standard QWERTY keyboard
        val letters = listOf("q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
                            "a", "s", "d", "f", "g", "h", "j", "k", "l",
                            "z", "x", "c", "v", "b", "n", "m")

        // Generate the list of buttons
        buttons = letters.map { letter ->
            val buttonId = resources.getIdentifier("button_$letter", "id", packageName)
            findViewById<Button>(buttonId).also { button ->
                button.text = letter.uppercase() // Set the text of the button, if not already set
            }
        }

        // Set up the buttons with the common click listener
        buttons.forEach { setupButtonClickListener(it) }
        // Buttons



        val score :TextView = findViewById(R.id.score)
        var scoreInt = 0

        buttonBackspace = findViewById(R.id.button_backspace)
        buttonBackspace.setOnClickListener(){
            if(valid(attempted, slot)) {
                if (slot >= 0) {
                    if (slot - 1 > -1)
                        slot--
                    fillSlot("", attempted, slot)
                } else {
                    val message = "Nothing to Delete!"
                    toast(message)
                }
            }
            else
                toast("YOU FAILED")
        }
        buttonEnter = findViewById(R.id.button_enter)
        buttonEnter.setOnClickListener() {
//            val mess : String = attempts[attempted][0].text.toString()
//            toast(mess)
            if (valid(attempted, slot)) {
                if (slot == 5) {

                    var win = mutableListOf<Boolean>(false, false, false, false, false)

                    for (i in 0..4) {

                        when (compareCharWithList(
                            attempts[attempted][i].text.toString()[0],
                            i,
                            checkSolution
                        )) {
                            2 -> {
                                attempts[attempted][i].setBackgroundResource(R.drawable.button_correct_base)
                                val buttonLetter = getButtonForLetter(
                                    letters,
                                    attempts[attempted][i].text.toString()
                                )
                                buttonLetter.setBackgroundResource(R.drawable.button_correct_base)
                                win[i] = true

                            }

                            1 -> {
                                attempts[attempted][i].setBackgroundResource(R.drawable.button_misplaced_base)
                                val buttonLetter = getButtonForLetter(
                                    letters,
                                    attempts[attempted][i].text.toString()
                                )
                                buttonLetter.setBackgroundResource(R.drawable.button_misplaced_base)
                            }

                            0 -> {
                                attempts[attempted][i].setBackgroundResource(R.drawable.button_wrong_base)
                                val buttonLetter = getButtonForLetter(
                                    letters,
                                    attempts[attempted][i].text.toString()
                                )
                                buttonLetter.setBackgroundResource(R.drawable.button_wrong_base)
                                buttonLetter.isEnabled = false

                            }
                        }
                    }

                    val youWon = won(win)

                    if(youWon) {
                        winner.text = "YOU WON!"
                        winner.visibility = android.view.View.VISIBLE
                        solutionText.visibility = android.view.View.VISIBLE
                        scoreInt += 5-attempted
                        score.text = (scoreInt*10).toString()
                        buttons.forEach{button ->
                            button.isEnabled = false
                        }
                        buttonEnter.isEnabled = false
                        buttonBackspace.isEnabled = false
                        showResultDialog(true, scoreInt*10, solution)
                    }
                    if (attempted < 5 && !youWon) {
                        attempted++
//                        score.text = attempted.toString()
                        slot = 0

                        if (attempted > 4) {
                            winner.text = "YOU LOST!"
                            winner.visibility = android.view.View.VISIBLE
                            solutionText.visibility = android.view.View.VISIBLE
                            showResultDialog(false, scoreInt*10, solution)
                        }
                        else
                            madeVisible(attempted)
                    }

                } else {
                    val message = "Fill the slot first!"
                    toast(message)
                }
            }else
                toast("YOU FAILED")


        }

        val buttonReset : Button = findViewById(R.id.button_reset)
        buttonReset.setOnClickListener(){
            resetViews()


        }

        //Reset on Start
        winner = findViewById(R.id.winner)
        resetViews()





    }
    private fun resetViews() {
        // Reset each letter button's background
        buttons.forEach { button ->
            button.setBackgroundResource(R.drawable.button_untested)
            button.isEnabled = true
        }


        // Reset each guess TextView's background
        attempts.forEach { row ->
            row.forEach { textView ->
                textView.setBackgroundResource(R.drawable.button_untested)
                textView.text = ""
                textView.visibility = android.view.View.INVISIBLE
            }
        }

        //Set the first row visible
        madeVisible(0)

        val listOfSolutions = listOf<String>("Apple" ,
            "Water" ,
            "House" ,
            "Table" ,
            "Chair" ,
            "Light" ,
            "Train" ,
            "Music" ,
            "Heart" ,
            "World" ,
            "Party" ,
            "Money" ,
            "Earth" ,
            "Beach" ,
            "Plant" ,
            "Sugar" ,
            "Happy" ,
            "Bread" ,
            "Drink" ,
            "Fruit" ,
            "Space" ,
            "Night" ,
            "Sound" ,
            "Movie" ,
            "Clock")

        attempted = 0
        slot = 0

        solution = listOfSolutions.random().uppercase()
        solutionText = findViewById(R.id.solution)
        solutionText.text = solution
        solutionText.visibility = android.view.View.INVISIBLE

        checkSolution = solution.toList()
        buttonBackspace.isEnabled = true
        buttonEnter.isEnabled = true
        winner.visibility = android.view.View.INVISIBLE


    }

    private fun madeVisible(num : Int)
    {
        for(i in 0..4)
        {
            attempts[num][i].visibility = android.view.View.VISIBLE
        }
    }

    private fun fillSlot(str: String, attempted: Int, slot: Int)
    {
        attempts[attempted][slot].text = str
    }
    private fun toast(str : String)
    {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun setupButtonClickListener(button: Button) {
        button.setOnClickListener {
            if (slot < 5) {
                if (slot < 0)
                    slot++
                fillSlot(button.text.toString(), attempted, slot)
                slot++
            } else {
                val message = "Slot is filled!"
                toast(message)
            }
        }
    }

    private fun compareCharWithList(character: Char, position: Int, charList: List<Char>): Int {
        // Check if the character matches the character in the list at the given position
        if (position in charList.indices && character == charList[position]) {
            return 2
        }

        // Check if the character exists anywhere in the list
        if (character in charList) {
            return 1
        }

        // If the character does not match any character in the list
        return 0
    }

    fun getButtonForLetter(letters: List<String>, letterToFind: String): Button {
        val buttons = letters.map { letter ->
            val buttonId = resources.getIdentifier("button_$letter", "id", packageName)
            findViewById<Button>(buttonId)
        }

        return buttons.find { it.text.toString().equals(letterToFind, ignoreCase = true) }
            ?: buttons.first() // Return the first button as a default if no match is found
    }

    fun valid(attempted: Int, slot: Int) : Boolean
    {
        if(attempted < 5 || slot < 5)
            return true
        return false
    }

    fun won(allGreen : MutableList<Boolean>) : Boolean
    {
        for(i in allGreen)
        {
            if(!i)
                return false
        }
        return true
    }

    private fun showResultDialog(isWin: Boolean, finalScore: Int, solutionWord : String) {
        val message = "Your score: $finalScore\nSolution: $solutionWord"

        AlertDialog.Builder(this)
            .setTitle(if (isWin) "Game Over - You Win" else "Game Over - You Lose")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("Reset") { dialog, _ ->
                resetViews()
                dialog.dismiss()
            }
            .create()
            .show()
    }




}