package `in`.nareshtechnologies.kotlinfunda

import java.util.Scanner

fun main() {
    var a: Int
    var b: Int

    var s: Scanner = Scanner(System.`in`)
    a = s.nextInt();
    b = s.nextInt();

    println(a+b)
/*
    if(a >0){
        println("Positive")
    }else{
        println("Negative")
    }*/

    /*var i:Int = 0;
    while(i<a){
        println("Pavan")
        i++
    }*/

    var array = arrayOf(1,2,3,4,5,6,7,8,9,10)
    var sum :Int = 0;
    for(a in array){
        sum+=a;
    }

    println(sum)
}