import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archives = mutableListOf<Archive>()
    val mainMenu = MainMenu(scanner)
    val archiveMenu = ArchiveMenu(mainMenu, archives)
    archiveMenu.start()
}