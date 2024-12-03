// Classe que representa cada registro
data class Registro(
    var nome: String,
    var endereco: String,
    var telefone: String
)

// Funções auxiliares
fun cadastrarRegistros(): MutableList<Registro> {
    val registros = mutableListOf<Registro>()
    for (i in 1..10) {
        println("\nCadastro $i")
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Endereço: ")
        val endereco = readLine() ?: ""
        print("Telefone: ")
        val telefone = readLine() ?: ""
        registros.add(Registro(nome, endereco, telefone))
    }
    return registros
}

fun pesquisarRegistro(registros: List<Registro>) {
    print("Digite o nome para pesquisar: ")
    val nomePesquisar = readLine() ?: ""
    val registroEncontrado = registros.find { it.nome.equals(nomePesquisar, ignoreCase = true) }
    if (registroEncontrado != null) {
        println("Registro encontrado:")
        println("Nome: ${registroEncontrado.nome}, Endereço: ${registroEncontrado.endereco}, Telefone: ${registroEncontrado.telefone}")
    } else {
        println("Registro não encontrado.")
    }
}

fun classificarRegistros(registros: MutableList<Registro>) {
    registros.sortBy { it.nome }
    println("Registros classificados com sucesso.")
}

fun apresentarRegistros(registros: List<Registro>) {
    if (registros.isEmpty()) {
        println("Nenhum registro cadastrado.")
    } else {
        println("\nTodos os registros:")
        registros.forEach { registro ->
            println("Nome: ${registro.nome}, Endereço: ${registro.endereco}, Telefone: ${registro.telefone}")
        }
    }
}

// Menu principal
fun menu() {
    var registros = mutableListOf<Registro>()
    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar registros")
        println("2. Pesquisar registro")
        println("3. Classificar registros por nome")
        println("4. Apresentar todos os registros")
        println("5. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> registros = cadastrarRegistros()
            2 -> if (registros.isNotEmpty()) pesquisarRegistro(registros) else println("Nenhum registro cadastrado.")
            3 -> if (registros.isNotEmpty()) classificarRegistros(registros) else println("Nenhum registro cadastrado.")
            4 -> apresentarRegistros(registros)
            5 -> {
                println("Saindo do programa.")
                break
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

// Função principal
fun main() {
    menu()
}