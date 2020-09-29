package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main(){
    println("Hello, Kotlin!")
}


// FUNCTIONS

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumInline(a: Int, b: Int) = a + b


// STRING TEMPLATE

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}


// LIST

fun listAdd(){
    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.add("five")   // this is OK
    println(numbers)
    //numbers = mutableListOf("six", "seven")      // compilation error
}

fun listAttr(){
    val numbers = listOf("one", "two", "three", "four")
    println("Number of elements: ${numbers.size}")
    println("Third element: ${numbers.get(2)}")
    println("Fourth element: ${numbers[3]}")
    println("Index of element \"two\" ${numbers.indexOf("two")}")
}

fun listMethods(){
    val numbers = mutableListOf(1, 2, 3, 4)
    println(numbers)

    numbers.add(5)
    println(numbers)

    numbers.removeAt(1)
    println(numbers)

    numbers[0] = 0
    println(numbers)

    numbers.shuffle()
    println(numbers)
}


// IF & WHEN

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOfInline(a: Int, b: Int) = if (a > b) a else b

fun whenInt(x: Int) {
    when {
        x == 1 -> print("x == 1")
        x == 2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }
}

fun whenCheck(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Float    -> "Float"
        !is String -> "Not a string"
        else       -> "Unknown"
    }


// FOR

fun forRange(){
    for (i in 1..3) {
        println(i)
    }
}

fun forUntil(){
    for (i in 1 until 3) {
        println(i)
    }
}

fun forList(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

fun forListIndices(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}


// while
fun whilePositive(){
    var x = 5
    while (x > 0) {
        x--
        println(x)
    }
}


// CLASS

class Person constructor(var name: String, var age: Int){
    fun printInfo() = println("name: $name, age: $age")
}

fun bob(){
    val bob = Person("Bob", 31)
    println("name: ${bob.name}, age: ${bob.age}")
    bob.age = 32
    println("name: ${bob.name}, age: ${bob.age}")
    bob.printInfo()
}

class TestClass {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

fun constructorTest(){
    val cons = TestClass(1)
}