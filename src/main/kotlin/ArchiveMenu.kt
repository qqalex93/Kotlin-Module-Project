import kotlin.system.exitProcess

class ArchiveMenu(private val mainMenu: MainMenu, private val archives: MutableList<Archive>) {
    private val options = listOf("Создать архив", "Выбрать архив", "Выход")

    fun start() {
        while (true) {
            mainMenu.displayMenu("Главное меню:", options)
            when (mainMenu.readUserInput(options.size + 1)) {
                1 -> createArchive()
                2 -> selectArchive()
                3 -> {
                    println("Выход из программы...")
                    break
                }
                else -> println("Некорректный ввод. Попробуйте вести цифру снова")
            }
        }
    }

    private fun createArchive() {
        val name = mainMenu.promptInput("Введите имя архива: ")
        if (name.isNotEmpty()) {
            archives.add(Archive(name))
            println("Архив '$name' создан")
        } else {
            println("Имя архива не может быть пустым")
        }
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Нет созданных архивов")
            return
        }

        while (true) {
            println("Выберите архив:")
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
            println("0. Назад")

            val choice = mainMenu.readUserInput(archives.size + 1)
            if (choice == 0) {
                break
            } else if (choice in 1..archives.size) {
                val noteMenu = NoteMenu(mainMenu, archives[choice - 1])
                noteMenu.start()
            } else {
                println("Некорректный выбор")
            }
        }
    }
}