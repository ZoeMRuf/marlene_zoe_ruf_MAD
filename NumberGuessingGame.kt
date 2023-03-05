fun main (){

    var guess = false;
    val generatedNumber: Int = generateFourDigitNumber();

    var rightGuessedNumbers: Int = 0;
    var rightPositionedNumbers: Int = 0;

    // println("Generated Number: $generatedNumber"); //-> print generatedNumber, unknown during game

    while (!guess){

        print("User Input : " );
        val userInput:String? = readLine();

        if (generatedNumber.toString() == userInput){

            println("\n-----------------------------------------------------------")
            println("       Your guess -> $userInput | $generatedNumber <- Generated Number")
            println("               !!! Congratulations !!!")
            println("-----------------------------------------------------------")
            guess = true;
        }
        else {
            //-> needs a userInput check and try again if the input has TYP-O
            if (userInput.toString().length < 4 || userInput.toString().length > 4){
                println("Error: Please try again");
                continue;
            }
            else if (userInput == "exit"){
                println("Ending the Game. Good Bye. The Number was: $generatedNumber");
                return;
            }

            val userGuessList = userInput.toString().map { it.toString().toInt() }
            val generatedNumberList = generatedNumber.toString().map { it.toString().toInt() }

            for (number in userGuessList){
                if (generatedNumberList.contains(number)){rightGuessedNumbers++}
            }

            for (index in 0..3){
                if (userGuessList[index] == generatedNumberList[index]){rightPositionedNumbers++}
            }

            println("Output: $rightGuessedNumbers:$rightPositionedNumbers")
            rightGuessedNumbers = 0;
            rightPositionedNumbers = 0;
        }
    }
}

fun generateFourDigitNumber(): Int {
    var index: Int = 0;
    val randoms: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7 ,8, 9);
    var digitalNumber: Int = 0;

    while (index < 4){
        val randomNumber: Int = randoms.random();

        when (index) {
            0 -> digitalNumber += randomNumber * 1000
            1 -> digitalNumber += randomNumber * 100
            2 -> digitalNumber += randomNumber * 10
            3 -> digitalNumber += randomNumber * 1
        }
        randoms.remove(randomNumber);
        index++;
    }
    return digitalNumber;
}





/* First Try for NumberGenerator:

val randomNumber = { numberList: MutableList<Int> -> numberList.random() }

fun generateFourDigitNumber(): MutableList<Int> {
    var index: Int = 0;
    val randoms: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7 ,8, 9);
    val number: MutableList<Int> = mutableListOf();

    while (index < 4){
        val randomNumber: Int = randomNumber(randoms);
        number.add(index, randomNumber);
        randoms.remove(randomNumber);
        index++;
    }

    return number;
}

 */
