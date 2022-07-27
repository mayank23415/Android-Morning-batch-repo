### Essentials of Java for Android application Development

***Pre-requisites***
- Use this notes as the reference for the concepts
- [Click Here](https://www.onlinegdb.com/online_java_compiler) to run your JAVA Programs online.

***Hello World! Program***
```java
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
```

*Output*
```
Hello World
```
**As JAVA is an Object oriented Programming langugage. Everything in JAVA is considered in Classes and Objects**

***Data-Types in JAVA***
1. Primitive Data types
2. Non Primitive Data types

***Primitive Data Types***
1. boolean  - 1 bit
3. byte     - 1 Byte = 8bits
4. char     - 2 Bytes = 16bits
5. short    - 2 Bytes = 16bits
6. int      - 4 Bytes = 32bits
8. long     - 8 Bytes = 64bits    When you define long values - always add ```L``` at the end
9. float    - 4 Bytes = 32bits    When you define float values - always add ```f``` at the end
11. double  - 8 Bytes = 64bits

***Example***
```java
public class Main
{
	public static void main(String[] args) {
		int x = 10;
		long y = 12356L;
		System.out.println(x+" "+y);
	}
}
```
*Output*
```
10 12356
```

***Reading values from the Output Screen***
- Generally for this, we can use two classes
    1. BufferedReader (java.io - Package)
    2. Scanner        (java.util - Package)

***Example - BufferedReader***
```java
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name");
		String a = br.readLine();
		System.out.println("Your Name is "+a);
	}
}
```
*Output*
```
Enter your name
Pavan Kumar Reddy Tadi
Your Name is Pavan Kumar Reddy Tadi
```

***Addition of Two Numbers example***
```java
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    int a,b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter First Number");
		a = Integer.parseInt(br.readLine());
		System.out.println("Enter Second Number");
		b = Integer.parseInt(br.readLine());
		System.out.println("The sum is "+(a+b));
	}
}
```

*Output*
```
Enter First Number
12
Enter Second Number
13
The sum is 25
```

***Example of using Scanner for reading  values from output console***
```java
import java.util.*;

public class Main
{
	public static void main(String[] args){
	    int a,b;
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter a Number: ");
	    a = s.nextInt();
	    System.out.println("Enter a Number: ");
	    b = s.nextInt();
	    System.out.println(a+b);
	    
	}
}
```
*Output*
```
Enter a Number: 
12
Enter a Number: 
14
26
```
***Control Statements***
- Three Types of Control Statements in Java
	- Decision Making Statements
		- if Statement
		- switch Statement
	- Loop Statements
		- for
		- while
		- for-each
		- do-while
	- Jump Statements
		- break
		- continue

***Relational Operators***
*>,<,>=,<=,==,!=*
***Logical Operators***
*&&,||,!*

***if statement example***
```java
import java.util.*;

public class Main
{
	public static void main(String[] args){
	    int a,b;
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter a Number: ");
	    a = s.nextInt();
	    if(a>0){
	        System.out.println("POSITIVE");
	    }else{
	        System.out.println("Negative");
	    }
	    
	}
}
```

*output*
```
Enter a Number: 
-89
Negative
```

***Combining two or more conditions as one - Example***
```java
import java.util.*;

public class Main
{
	public static void main(String[] args){
	    int a,b;
	    Scanner s = new Scanner(System.in);
	    System.out.println("Enter a Number: ");
	    a = s.nextInt();
	    System.out.println("Enter a Number: ");
	    b = s.nextInt();
	    if(a>0 && b<0){
	        System.out.println("a is pos and b is not");
	    }else{
	        System.out.println("something is fishy!!!");
	    }
	    
	}
}
```
*Output*
```
Enter a Number: 
10
Enter a Number: 
20
something is fishy!!!
```
***Assignment - 1***
```
A Certain grade of meat has to be graded according to the following conditions
Condition 1: if the meat  weights more than 10kgs
Condition 2: if the meat is having less than 0.5 days of age
Condition 3: if the meat is ready to cook

1. if all the conditions are matched, the meat can be rated with 10
2. if the first two conditions meet and the third condition fails, the meat can be given 9 rating
3. if the second, third conditions are met, the rating can be 8
4. if the first and third conditions are only met, the rating can be 7.
5. if the only one condition is meeting and the other conditions are failing, the meat can be rated as 6.
```

***Read the Values of boolean variable***
```java
import java.util.Scanner;
class Main{
    public static void main(String args[]){
        boolean tf;
        Scanner s = new Scanner(System.in);
        tf = s.nextBoolean();
        System.out.println(tf);
    }
}
```
***Switch in Java***
*Syntax*
```java
switch(variable){
	case 0:
		// write code here
		break;
	case 1:
		// write code here
		break;
	default:
		// write code here
}
```
***Example - Switch Program***
```java
import java.util.Scanner;
class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose Your option\n1. Covid Positive\n2. Covid Negative\n3. Haven't effected from Covid yet");
        int a = s.nextInt();
        switch(a){
            case 1:
                System.out.println("You need to take medicines");
                System.out.println("You need to stay away from others");
                break;
            case 2:
                System.out.println("You need to go for regular health chekup");
                System.out.println("COVID effects the lungs badly!");
                break;
            case 3:
                System.out.println("You need to be careful! so that you won't get effected!");
                break;
            default:
                System.out.println("Incorrect Option");
                break;
        }
    }
}
```

*Output*
```
Choose Your option
1. Covid Positive
2. Covid Negative
3. Haven't effected from Covid yet
1
You need to take medicines
You need to stay away from others
```

***Loops in Java***
- When you have to repeat a certain set of statements in a program for a certain number of times or until a condition becomes false, we can make use of loops
- Four Loops in JAVA
	- while
	- do-while
	- for
	- for-each
***Syntax of While***
```java
while(Condition){
  //statements
}
```
***Example - While***
```java
class Main{
    public static void main(String args[]){
            int i = 0;
            while(i<=10){
                System.out.print(i+" ");
                i++;
            }
    }
}
```
*Output*
```
0 1 2 3 4 5 6 7 8 9 10 
```

***Assignment-2***
```
Write a program to print all the prime numbers between any given range of numbers.
```

***Decide if a given number is prime or not using while loop***
```java
import java.util.Scanner;
class Main{
    public static void main(String args[]){
        System.out.println("Enter a Number");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        /*Prime Number is any number that has 1 and itself as the factors*/
        int i = 2;
        int factors = 0;
        while(i<a){
            if(a%i == 0){
                factors++;
            }
            i++;
        }
        if(factors>0){
            System.out.println("NOT PRIME NUMBER");
        }else{
            System.out.println("PRIME NUMBER");
        }
    }
}
```
*Output*
```
Enter a Number
13
PRIME NUMBER
```

***Print all the even numbers between any given range of numbers***
```java
import java.util.Scanner;
class Main{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Lower bound:");
        int lowerBound = s.nextInt();
        System.out.println("Enter Upper bound:");
        int upperBound = s.nextInt();
        while(lowerBound<=upperBound){
            if(lowerBound%2 == 0){
                System.out.print(lowerBound+" ");
            }
            lowerBound++;
        }
    }
}
```
*Output*
```
Enter Lower bound:
20
Enter Upper bound:
50
20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50
```

***do-while loop***
*Syntax*
```java
do{
// Statements
}while(condition);
```
*Difference between While and do-while*
```java
public class Main
{
	public static void main(String[] args) {
		int x = 0;
		while(x>0){
		    System.out.println("Hello, My value is 0");
		}
		
		do{
		  System.out.println("Hello, My value is 0");  
		}while(x>0);
		
	}
}
```
*Output*
```
Hello, My value is 0
```

*Program to Print 1 to 10 Numbers using do-while*
```java
		int x = 1;
		do{
		  System.out.print(x+" ");  
		  x++;
		}while(x<11);
```
*Output*
```
1 2 3 4 5 6 7 8 9 10
```

***Assignment -3 ***
```
print the factorial of any given number
```

***For loop***
```java
for(initilization;condition;increment/decrement)
{
// statements
}
```

```java
		for(int x = 1; x<11; x++){
		    System.out.print(x+" ");
		}
```
*Output*
```
1 2 3 4 5 6 7 8 9 10
```

***Assignment -4***
```
you are given number, decide if it is special Number or not. Special number is a number when the individual digits are added, generates an even number
```

***Java Arrays***
- An array is a collection of similar type of data elements under a single name and those elements will be stored in contigeous memory locations.
- You can put or get the elements from an array using the indcies of the array.
- An Array index starts at 0 and ends at 1 less than the actual size.

Two Kinds of Arrays
- Single dim arrays
- Multi dim arrays
*Syntax of creating an array*
```java
int[] a = new int[10];
```

***Example -1 (Creating a static integer array)***
```java
public class Main
{
	public static void main(String[] args) {
		// You can values of an array statically in the following way!
		int a[] = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		// you can access the individual elements of an array
		// in the following way
		System.out.println(a[2]);
		
		// if you want to change a particular value inside an array
		a[9] = 100;
		
		//you can use a loop to access all the elements and print them
		// a.length - returns the size of the array
		for(int i=0; i<a.length;i++)
		{
		    System.out.print(a[i]+" ");
		}
	}
}
```
*Output*
```
3
1 2 3 4 5 6 7 8 9 100
```
***for-each loop***
*Syntax*
```java
for(int b: collection_variable_name){
// statements
}
```
***Example***
```java
		for(int b : a)
		{
		    System.out.print(b+" ");
		}
```
*Output*
```
3
1 2 3 4 5 6 7 8 9 100
```

***JUMP Statements in JAVA***
- break
- continue

*A ```break``` statements breaks the loop*
```java
class Main{
    public static void main(String a[]){
        for(int i = 1; i<11; i++){
            System.out.print(i+" ");
            if(i%3 == 0){
                break;
            }
        }
    }
}
```
*Output*
```
1 2 3
```

*A ```Continue``` statement in java would allows us to go the next iteration skipping the code next to ```continue``` if there is any.*
```java
class Main{
    public static void main(String a[]){
        for(int i = 1; i<11; i++){
            if(i%3 == 0){
                continue;
            }
            System.out.print(i+" ");
        }
    }
}
```
*output*
```
1 2 4 5 7 8 10
```

***Java OOPs Concepts***
- OOPs --> Object oriented programming System
- You cannot write a program without declaring classes
- Everything is built around objects in Java.
- Java is a Pure Object oriented programming language.

***Important Concepts***
- objects
- classes
- Inheritance
- Polymophism
- Abstration (interfaces)
- Encapsulation

***Object***
- Any real world entity can be considered as an object if it exhibits properties and behavior. 
- An object is an instance (Copy) of a class.
	- Example: Dog (Properties - name, age, weight
		        Behavior - barking, sleeping, swiming)
	- All Properties will be variables in java
	- All behaviors will be Methods(Functions) in java
***Classes***
- Class is a blueprint of an object
	- classes does not occupy any space
	- Only when you create an object for a class, then the memory is allocated. 
- Always keep the first letter of the class name as a capital letter.
***Syntax of Creating a class***

```java
class Dog{
	// Properties - Variables 
	// behaviors  - Methods
}
```

***Example Class***
```java
class Dog{
	// Properties
	String name;
	int age;
	double weight;
	
	// Behaviors
	public void barkAtStrangers(){
		// Write functionality here.
	}
	
	public void swagTail(){
		// Write the Functionality here.
	}
}
```
***Example - Creating a class and object***
```java
class Dog{
    // Properties
    String name;
    int age;
    
    //Behaviors
    public void bark(){
        System.out.println(name+" Bow! Bow!");    
    }
    
    public void swim(){
        System.out.println("Swmming");
    }
}

class Main{
    public static void main(String args[]){
        // Creating an Object
        Dog tommy = new Dog();
        tommy.name = "Tommy Hifigler";
        tommy.age = 10;
        tommy.bark();
        tommy.swim();
        
        Dog d = new Dog();
        d.name = "Jimmy";
        d.age = 4;
        d.bark();
        d.swim();
        
        System.out.println(tommy.name);
    }
}
```
*Output*
```
Tommy Hifigler Bow! Bow!
Swmming
Jimmy Bow! Bow!
Swmming
Tommy Hifigler
```

***Constructors in Java***
- At the time of initializing an object, if you want to initialize a few variables of that object, you can use constructor.
- There is a Default constructor for every class that you create.
- In Java, we can have mutliple constructors for the same class (Overloading constructors)
- Types of Constructors
	- Default Constructors (No-Arguments)
	- Parameterized Constructors

- Constructors look like methods but does not have return types.
- The name of the constructor should be the same name as that of the class name.

***Example-1***
```java
class Dog{
    // Properties
    String name;
    int age;
    
    // Constructor
    Dog(String n, int a){
        name = n;
        age = a;
    }
    
    //Behaviors
    public void bark(){
        System.out.println(name+" Bow! Bow!");    
    }
    
    public void swim(){
        System.out.println("Swmming");
    }
}

class Main{
    public static void main(String args[]){
        // Creating an Object
        Dog tommy = new Dog("Tommy Hifigler",10);
        tommy.bark();
        tommy.swim();
        
        Dog d = new Dog("Jimmy",4);
        d.bark();
        d.swim();
        
        System.out.println(tommy.name);
    }
}
```
*Output*
```
Tommy Hifigler Bow! Bow!
Swmming
Jimmy Bow! Bow!
Swmming
Tommy Hifigler
```

***Example 2***
```java
class Student{
    String name;
    int age;
    int student_id;
    
    Student(){
        name = "Pavan";
        age = 30;
        student_id = 1;
    }
    
    Student(String n, int a){
        name = n;
        age = a;
    }
    
    Student(String n, int a, int id){
        name = n;
        age = a;
        student_id = id;
    }
    
    public void display(){
        System.out.println(name+" "+age+" "+student_id);
    }
}

class Main{
    public static void main(String args[]){
        Student s1 = new Student();
        Student s2 = new Student("Rakesh",22);
        Student s3 = new Student("Rajesh",21,121);
        s2.student_id = 222;
        
        s1.display();
        s2.display();
        s3.display();
    }
}
```
*Output*
```
Pavan 30 1
Rakesh 22 222
Rajesh 21 121
```

***COMMAND LINE ARGUMENTS IN JAVA***
- During the execution of the program, we can pass a few command line arguments. Please refer the examples below.
***Example-1***
```java
class Cla{
  public static void main(String args[]){
      for(String a: args){
        System.out.println(a);
      }
  }
}
```
*output*      
![Reeference](/reference.png)








