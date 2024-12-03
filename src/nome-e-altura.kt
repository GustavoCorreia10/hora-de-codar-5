// Classe que representa uma Pessoa
data class Pessoa(
    var nome: String,
    var altura: Double
)
    
// Função para cadastrar 15 pessoas
fun cadastrarPessoas(): MutableList<Pessoa> {
    val pessoas = mutableListOf<Pessoa>()
    for (i in 1..15) {
        println("\nCadastro da pessoa $i:")
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Altura (em metros): ")
        val altura = readLine()?.toDoubleOrNull() ?: 0.0
        pessoas.add(Pessoa(nome, altura))
    }
    println("\nCadastro concluído!")
    return pessoas
}

// Função para apresentar pessoas com altura menor ou igual a 1.5m
fun apresentarMenoresOuIguais(pessoas: List<Pessoa>) {
    println("\nPessoas com altura menor ou igual a 1.5m:")
    val filtradas = pessoas.filter { it.altura <= 1.5 }
    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa encontrada.")
    } else {
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)}m") }
    }
}

// Função para apresentar pessoas com altura maior que 1.5m
fun apresentarMaioresQue(pessoas: List<Pessoa>, limite: Double) {
    println("\nPessoas com altura maior que $limite m:")
    val filtradas = pessoas.filter { it.altura > limite }
    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa encontrada.")
    } else {
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)}m") }
    }
}

// Função para apresentar pessoas com altura maior que 1.5m e menor que 2.0m
fun apresentarEntreAlturas(pessoas: List<Pessoa>, menor: Double, maior: Double) {
    println("\nPessoas com altura maior que $menor m e menor que $maior m:")
    val filtradas = pessoas.filter { it.altura > menor && it.altura < maior }
    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa encontrada.")
    } else {
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${"%.2f".format(it.altura)}m") }
    }
}

// Função para calcular a média de altura
fun calcularMediaAltura(pessoas: List<Pessoa>) {
    val media = pessoas.map { it.altura }.average()
    println("\nA média das alturas armazenadas é: ${"%.2f".format(media)}m")
}

// Menu principal
fun menuNomeAltura() { // Nome alterado para evitar conflitos
    var pessoas = mutableListOf<Pessoa>()
    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar pessoas")
        println("2. Apresentar pessoas com altura <= 1.5m")
        println("3. Apresentar pessoas com altura > 1.5m")
        println("4. Apresentar pessoas com altura > 1.5m e < 2.0m")
        println("5. Calcular média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> pessoas = cadastrarPessoas()
            2 -> apresentarMenoresOuIguais(pessoas)
            3 -> apresentarMaioresQue(pessoas, 1.5)
            4 -> apresentarEntreAlturas(pessoas, 1.5, 2.0)
            5 -> calcularMediaAltura(pessoas)
            6 -> {
                println("Saindo do programa.")
                break
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

// Função principal
fun main() {
    menuNomeAltura() // Chama a função renomeada
}