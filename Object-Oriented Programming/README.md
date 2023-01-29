# Object-Oriented Programming

This project showcases my academic qualifications in Object-Oriented programming.

The menu-driven Java application provides a multi-threaded indexing API that allows a word index to be created from an
e-book. The index will contain a list of words that relate to the page numbers
on which they appear and the dictionary defined meaning of each word.

The application parses text using Java 19 virtual threads and then builds an index by examining every word. If a word
match is found in the English dictionary, it is added to the index.

The API should, however, exclude 1,000 most common words from indexing. Google's list of such words is enclosed.

Sample output:

<pre>
Building index...
Index has been built...
Outputting the index...

Index saved to d:\results.txt

-------------------------- STATUS --------------------------
Input file:	d:\1984Orwell.txt
Output file:	d:\results.txt
Dictionary:	Version 1
Unique words:	111515
Definitions:	175661
Google list:	Configured
Common words:	1000

--------------------------- MENU ---------------------------
(1) Specify Text File
(2) Configure Dictionary
(3) Configure Common Words
(4) Specify Output File
(5) Execute and Save
(6) Execute and Print
(9) Quit

</pre>

## Indicative Knowledge

- Software development using types, variables and operators; operator precedence, literals, control
  structures for decision and iteration, I/O. arrays, Exception handling.
- OOP programming using objects and classes; methods and parameter passing, pass by value and pass by reference,
  constructors. JVM structure: heap and stack.
- Code design, code style and quality, testing and debugging
- Abstraction, encapsulation, inheritance and polymorphism. Abstract classes and interfaces. Design principles and a
  sample of important design patterns. Serialization, persistence; The Java Collections Framework and generics.
- Designing concurrent applications, threading, object locks and synchronization.
- Data structures and algorithms and their implementation in an OO language e.g. analysis of algorithms lists, queues,
  trees and graphs.

## Requirements

- Java 19
- Enable **virtual threads** and structured concurrency by adding the VM
  arguments: `--enable-preview --add-modules jdk.incubator.concurrent`
- Maven

Execute the main() method in th **Runner.java** class

Run the application on Windows: `java.exe -cp "indexer.jar" --enable-preview ie.atu.sw.Runner`

Run the application on Linux: `java -cp ./indexer.jar --enable-preview ie.atu.sw.Runner`

## Licensing

This project is licensed under Unlicense license. This license does not require you to take the license with you to your
project.