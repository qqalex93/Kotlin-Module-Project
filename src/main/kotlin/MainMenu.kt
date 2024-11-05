import java.util.Scanner

class MainMenu(private val scanner: Scanner) {

    fun displayMenu(title: String, options: List<String>) {
        println(title)
        options.forEachIndexed { index, option -> println("${index + 1}. $option") }
    }

    fun readUserInput(optionsCount: Int): Int {
        val choice = scanner.nextLine().toIntOrNull()
        return if (choice != null && choice in 0 until  optionsCount) choice else -1
    }

    fun promptInput(prompt: String): String {
        println(prompt)
        return scanner.nextLine().trim()
    }
}