// Classe que representa um Aluno
data class Aluno(
    var nome: String,
    var notas: List<Double>
) {
    // Calcula a média do aluno
    val media: Double
        get() = notas.average()

    // Determina se o aluno está aprovado ou reprovado
    val situacao: String
        get() = if (media >= 5.0) "Aprovado" else "Reprovado"
}

// Funções auxiliares
fun cadastrarAlunos(): MutableList<Aluno> {
    val alunos = mutableListOf<Aluno>()
    for (i in 1..20) {
        println("\nCadastro do aluno $i:")
        print("Nome: ")
        val nome = readLine() ?: ""
        val notas = mutableListOf<Double>()
        for (j in 1..4) {
            print("Nota $j: ")
            val nota = readLine()?.toDoubleOrNull() ?: 0.0
            notas.add(nota)
        }
        alunos.add(Aluno(nome, notas))
    }
    // Classificar alunos por nome ao final do cadastro
    alunos.sortBy { it.nome }
    println("\nAlunos cadastrados e classificados por nome.")
    return alunos
}

fun pesquisarAluno(alunos: List<Aluno>) {
    print("\nDigite o nome do aluno para pesquisar: ")
    val nomePesquisa = readLine() ?: ""
    val alunoEncontrado = alunos.find { it.nome.equals(nomePesquisa, ignoreCase = true) }
    if (alunoEncontrado != null) {
        println("\nAluno encontrado:")
        println("Nome: ${alunoEncontrado.nome}")
        println("Notas: ${alunoEncontrado.notas.joinToString(", ")}")
        println("Média: %.2f".format(alunoEncontrado.media))
        println("Situação: ${alunoEncontrado.situacao}")
    } else {
        println("Aluno não encontrado.")
    }
}

fun apresentarAlunos(alunos: List<Aluno>) {
    if (alunos.isEmpty()) {
        println("Nenhum aluno cadastrado.")
    } else {
        println("\nLista de todos os alunos:")
        alunos.forEach { aluno ->
            println("Nome: ${aluno.nome}")
            println("Notas: ${aluno.notas.joinToString(", ")}")
            println("Média: %.2f".format(aluno.media))
            println("Situação: ${aluno.situacao}")
            println()
        }
    }
}

// Menu principal
fun exibirMenu() { // Alterado o nome para evitar conflito
    var alunos = mutableListOf<Aluno>()
    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar alunos")
        println("2. Pesquisar aluno")
        println("3. Apresentar todos os alunos")
        println("4. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> alunos = cadastrarAlunos()
            2 -> if (alunos.isNotEmpty()) pesquisarAluno(alunos) else println("Nenhum aluno cadastrado.")
            3 -> apresentarAlunos(alunos)
            4 -> {
                println("Saindo do programa.")
                break
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

// Função principal
fun main() {
    exibirMenu() // Chama a função renomeada
}