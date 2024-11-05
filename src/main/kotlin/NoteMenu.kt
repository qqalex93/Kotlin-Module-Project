class NoteMenu(private val mainMenu: MainMenu, private val archive: Archive) {
    private val options = listOf("Создать заметку", "Список заметок")

    fun start() {
        while (true) {
            mainMenu.displayMenu("Меню заметок для архива '${archive.name}':", options)
            println("0. Назад")
            when (mainMenu.readUserInput(options.size + 1)) {
                1 -> createNote()
                2 -> selectNotes()
                0 -> return
                else -> println("Некорректный выбор. Попробуйте ввести цифру снова")
            }
        }
    }

    private fun createNote() {
        val title = mainMenu.promptInput("Введите заголовок заметки:")
        val content = mainMenu.promptInput("Введите содержание заметки:")
        if(title.isNotEmpty() && content.isNotEmpty()) {
            archive.notes.add(Note(title, content))
            println("Заметка создана")
        } else {
            println("Заголовок и содержание заметки не могут быть пустыми")
        }
    }

    private fun selectNotes() {
        if (archive.notes.isEmpty()) {
            println("Список заметок пуст")
            return
        }

        while (true) {
            archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
            println("0. Назад")
            println("Введите номер заметки для просмотра")

            val choice = mainMenu.readUserInput(archive.notes.size + 1)
            if (choice == 0) {
                break
            } else if (choice in 1..archive.notes.size) {
                viewNoteContent(choice - 1)
            } else {
                println("Некорректный выбор")
            }
        }
    }

    private fun viewNoteContent(noteIndex: Int) {
        while (true) {
            val note = archive.notes[noteIndex]
            println("Просмотр заметки:\nНазвание: ${note.title}\nСодержание: ${note.content} ")
            println("0. Назад")

            val choice = mainMenu.readUserInput(1)
            if (choice != 0) {
                println("Некорректное значение")
            } else {
                break
            }
        }
    }
}