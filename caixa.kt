//CAIXA ELETRÔNICO

var saldo: Double = 15000.0
var senha = 1501

fun main(){
    println("Seja Bem vindo ao Caixa Eletrônico Correia Bank")
    print("Insira seu Nome Completo: ")
    var nome = readln()
    println("Olá, $nome é uma honra ter você por aqui!")
    inicio()
}

fun inicio(){
    println("\nMENU DE OPÇÕES\n1- Saldo\n2- Extrato\n3- Saque\n4- Deposito\n5- Pix\n6- Sair\n")
    print("Escolha uma das Opções:  ")
    val escolha = readln().toIntOrNull()

    when(escolha){
        1 -> {
            validaSenha()
            verSaldo()
        }
        2 -> {
            validaSenha()
            verExtrato()
        }
        3 -> {
            validaSenha()
            fazerSaque()

        }
        4 -> {
            validaSenha()
            fazerDeposito()
        }
        5 -> {
            validaSenha()
            fazerTransferencia()
        }
        6 ->  {
            print("Obrigado e volte sempre ao Correia Bank!")
        }
        else -> erro()
    }
}

fun verSaldo(){
    println("Seu saldo atual é $saldo")
    inicio()
}

fun verExtrato(){
    println("Seu Extrato:\nSalário Ltda: +R$15.000\nAluguel: -R$1.800\nMercadorias: -R$500,50\n")
    inicio()
}

fun fazerSaque(){
    println("Quanto deseja Sacar:")
    var sacar = readLine()?.toIntOrNull()

    if(sacar == null){
        println("Valor inválido! Tente novamente.")
        fazerSaque()
    } else{
        saldo -= sacar
        println("O valor sacado foi: $sacar\nSaldo atual: $saldo")
    }
    inicio()
}

fun fazerDeposito(){
    println("Quanto deseja Depositar: ")
    var depositar = readLine()?.toIntOrNull()

    if(depositar == null){
        println("Valor inválido! Tente novamente.")
    } else{
        saldo += depositar
        println("O valor depositado foi: $depositar\nSaldo atual: $saldo")
    }
    inicio()
}

fun fazerTransferencia(){
    print("Insira a conta: ")
    var agencia = readln().toInt()
    println("Insira o valor do Pix: ")
    var transferir = readln().toInt()

    if(transferir > saldo){
        println("Saldo insuficiente!")
        fazerTransferencia()
    } else{
        saldo -= transferir
        println("Transferido com Sucesso!\n Número da Conta: $agencia\nValor da Transferência: $transferir\nSaldo atual: $saldo")
    }
    inicio()
}

fun validaSenha(){
    println("Insira sua Senha:  ")
    senha = readln().toInt()
    if (senha == 1501) {
        println("Acesso Permitido!")
    } else {
        println("Acesso Negado!")
        validaSenha()
    }
}

fun erro(){
    println("Opção inválida!\n")
    inicio()
}
