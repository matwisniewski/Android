import java.util.Scanner;

fun main(args: Array<String>)
{
    var `in` = Scanner(System.`in`)
    println("Ile chcesz wypłacić:")
    var amount = `in`.nextInt()
    CashMachine(amount)
}

fun CashMachine(amount: Int)
{
    var nominal = mutableListOf(200, 100, 50, 20, 10)
    var quantityMoney = mutableListOf(10, 10, 10, 0, 0)
    var quantityTaken = mutableListOf(0, 0, 0, 0, 0)
    var inBank = 0;
    for(i in 0..4){
        inBank += nominal[i] * quantityMoney[i]
    }
    var piniondz = amount;
    if(piniondz%10 != 0)
        println("Nieprawidłowa kwota!")
    else if(piniondz > inBank)
        println("Nie ma tyle pieniedzy w bankomacie")
    else{
        do {
            if (piniondz >= 200 && quantityMoney[0] > 0) {
                piniondz -= 200
                quantityTaken[0]++
            } else if (piniondz >= 100 && quantityMoney[1] > 0) {
                piniondz -= 100
                quantityTaken[1]++
            } else if (piniondz >= 50 && quantityMoney[2] > 0) {
                piniondz -= 50
                quantityTaken[2]++
            } else if (piniondz >= 20 && quantityMoney[3] > 0) {
                piniondz -= 20
                quantityTaken[3]++
            } else if (piniondz >= 10 && quantityMoney[4] > 0) {
                piniondz -= 10
                quantityTaken[4]++
            }else {
                println("Bankomat nie posiada banknotów umożliwiających wydanie pieniędzy.\nZawartość bankomatu:")
                for(i in 0..4){
                    print(nominal[i])
                    print(":")
                    println(quantityMoney[i])
                }
                println("Wprowadź inna kwotę")
                break
            }
        } while (piniondz > 0)
        if(piniondz == 0){
            for(i in 0..4){
                quantityMoney[i]-=quantityTaken[i]
            }
            println("Twoja kwota zostanie wypłacona w banknotach: ")
            inBank = 0
            for(i in 0..4){
                print(nominal[i])
                print(":")
                println(quantityTaken[i])
                inBank += nominal[i] * quantityMoney[i]
            }
            println("W bankomacie zostało $inBank zł")
        }
    }
}
