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
