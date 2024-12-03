// Classe que representa um Funcionário
data class Funcionario(
    val matricula: Int,
    val nome: String,
    val salario: Double
)

// Função para cadastrar 20 funcionários
fun cadastrarFuncionarios(): MutableList<Funcionario> {
    val funcionarios = mutableListOf<Funcionario>()
    for (i in 1..20) {
        println("\nCadastro do funcionário $i:")
        print("Matrícula: ")
        val matricula = readLine()?.toIntOrNull() ?: 0
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Salário: ")
        val salario = readLine()?.toDoubleOrNull() ?: 0.0
        funcionarios.add(Funcionario(matricula, nome, salario))
    }
    // Classificar os funcionários por matrícula após o cadastro
    funcionarios.sortBy { it.matricula }
    println("\nCadastro concluído e ordenado por matrícula!")
    return funcionarios
}

// Função para pesquisar funcionário por matrícula
fun pesquisarFuncionario(funcionarios: List<Funcionario>) {
    print("\nDigite a matrícula do funcionário para pesquisar: ")
    val matriculaPesquisa = readLine()?.toIntOrNull()
    val funcionario = funcionarios.find { it.matricula == matriculaPesquisa }
    if (funcionario != null) {
        println("\nFuncionário encontrado:")
        println("Matrícula: ${funcionario.matricula}")
        println("Nome: ${funcionario.nome}")
        println("Salário: R$ ${"%.2f".format(funcionario.salario)}")
    } else {
        println("Funcionário não encontrado.")
    }
}

// Função para apresentar funcionários com salário acima de R$1.000,00
fun apresentarPorSalario(funcionarios: List<Funcionario>, comparador: (Double) -> Boolean, descricao: String) {
    println("\nFuncionários com salário $descricao R$1.000,00:")
    val filtrados = funcionarios.filter { comparador(it.salario) }.sortedBy { it.matricula }
    if (filtrados.isEmpty()) {
        println("Nenhum funcionário encontrado.")
    } else {
        filtrados.forEach {
            println("Matrícula: ${it.matricula}, Nome: ${it.nome}, Salário: R$ ${"%.2f".format(it.salario)}")
        }
    }
}

// Menu principal
fun menuFuncionarios() {
    var funcionarios = mutableListOf<Funcionario>()
    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar funcionários")
        println("2. Pesquisar funcionário por matrícula")
        println("3. Apresentar funcionários com salário acima de R$1.000,00")
        println("4. Apresentar funcionários com salário abaixo de R$1.000,00")
        println("5. Apresentar funcionários com salário igual a R$1.000,00")
        println("6. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> funcionarios = cadastrarFuncionarios()
            2 -> pesquisarFuncionario(funcionarios)
            3 -> apresentarPorSalario(funcionarios, { it > 1000.0 }, "acima de")
            4 -> apresentarPorSalario(funcionarios, { it < 1000.0 }, "abaixo de")
            5 -> apresentarPorSalario(funcionarios, { it == 1000.0 }, "igual a")
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
    menuFuncionarios()
}
