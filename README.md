# SER-502 - SiMPLE Language

## Team 9
**Team Members**

1. Subhradeep Biswas
2. Prashansa
3. Muhammad Sami


The language we made is called SiMple . The link to the youtube video is : (https://youtu.be/Dn-Unw8cHGg)


**Following is the structure of the repository :**

resources/Sample_Programs/ - contains various sample programs to test the language. Compiler generated intermediate code files will also be saved in this location.

doc - contains all the related documents for the project, including the pitch,design and implementation PPTs.

src - contains the entire source code with compiler and runtime packages for compilaton and execution of code.

lib - contains the dependencies used for this project (ANTLR)

compiler.jar - This jar is used by the compiler to generate intermediate code from source code.

runtime.jar - This jar is used to execute the intermediate and get output of the program.

  
**Platform**

MacOS

Windows


**Tools**<br>
`ANTLR` (ANother Tool for Language Recognition) is a powerful parser generator for reading, processing, executing, or translating structured text or binary files. It's widely used to build languages, tools, and frameworks. From a grammar, ANTLR generates a parser that can build and walk parse trees.

**Install Instructions**

git clone https://github.com/samimalik325/SER502-Spring2019-Team9.git

**Run Instructions**

cd SER502-Spring2019-Team9/

java -jar compiler.jar (path_to_file).simple

java -jar runtime.jar (path_to_file).simpleint

Example:

java -jar compiler.jar resources/SamplePrograms/Boolean.simple

java -jar runtime.jar resources/SamplePrograms/Boolean.simpleint


**Future Scope** 

We are planning to add:

Lists.

Multiple Datatypes

Datastructures.


