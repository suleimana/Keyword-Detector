# Keyword-Detector


 Create a small java program that will put <b></b> tags around keywords in a given body of text. The program will take in a file input location and output location as arguments (Ex: format.java input.txt output.txt). The first line of the input file contains the comma delimited keywords.  The rest of the input file contains the text that needs to be tagged.  The output file contains the text with the keywords tagged. Also provide the time complixty of the algorithm. 
 
 Example
--------
 
  
  **input.txt**
 
 ```
 they,Unlike,world
As players travel the real world, their avatar moves along the game's map. Different Pokémon species reside in different areas of the world; for example, water-type Pokémon are generally found near water. When a player encounters a Pokémon, they may view it either in augmented reality (AR) mode or with a live rendered, generic background. AR mode uses the camera and gyroscope on the player's mobile device to display an image of a Pokémon as though it were in the real world. Players can take screen shots of the Pokémon they encounter either with or without the AR mode activated.

Unlike other installments in the Pokémon series, players in Pokémon Go do not battle wild Pokémon to capture them. During an encounter with a wild Pokémon, the player may throw a Poké Ball at it by flicking it from the bottom of the screen up toward the Pokémon. If the Pokémon is successfully caught, it will come under the ownership of the player. Factors in the success rate of capture include the right force, the right time and the type of Poké Ball used. After capturing a wild Pokémon, the player is awarded two types of in-game currencies: candies and stardust. The candies awarded by a successful catch depends on what evolutionary chain a Pokémon belongs to. A player can use stardust and candies to raise a Pokémon's "combat power" (CP). However, only candies are needed to evolve a Pokémon. Each Pokémon evolution tree has its own type of candy which can only be used to evolve or level up. The player can also transfer the Pokémon back to the Pokémon professor to earn one more candy and create room for more Pokémon. The ultimate goal of the game is to complete the entries in the Pokédex, a comprehensive Pokémon encyclopedia, by capturing and evolving to obtain the original 151 Pokémon
 ```
 
 **output.txt**

 
 ```
 they,Unlike,world
As players travel the real <b>world</b>, their avatar moves along the game's map. Different Pokémon species reside in different areas of the <b>world</b>; for example, water-type Pokémon are generally found near water. When a player encounters a Pokémon, <b>they</b> may view it either in augmented reality (AR) mode or with a live rendered, generic background. AR mode uses the camera and gyroscope on the player's mobile device to display an image of a Pokémon as though it were in the real <b>world</b>. Players can take screen shots of the Pokémon <b>they</b> encounter either with or without the AR mode activated.

<b>Unlike</b> other installments in the Pokémon series, players in Pokémon Go do not battle wild Pokémon to capture them. During an encounter with a wild Pokémon, the player may throw a Poké Ball at it by flicking it from the bottom of the screen up toward the Pokémon. If the Pokémon is successfully caught, it will come under the ownership of the player. Factors in the success rate of capture include the right force, the right time and the type of Poké Ball used. After capturing a wild Pokémon, the player is awarded two types of in-game currencies: candies and stardust. The candies awarded by a successful catch depends on what evolutionary chain a Pokémon belongs to. A player can use stardust and candies to raise a Pokémon's "combat power" (CP). However, only candies are needed to evolve a Pokémon. Each Pokémon evolution tree has its own type of candy which can only be used to evolve or level up. The player can also transfer the Pokémon back to the Pokémon professor to earn one more candy and create room for more Pokémon. The ultimate goal of the game is to complete the entries in the Pokédex, a comprehensive Pokémon encyclopedia, by capturing and evolving to obtain the original 151 Pokémon
 ```
 
## Solution

 Code located under [src folder](https://github.com/suleimana/Keyword-Detector/tree/master/src) . It has the follwing strcture:
 ```
 .
└── com
    └── lab
        └── keyworddetector
            ├── KeywordDetector.java
            └── common
                └── util
                    └── FileUtil.java
 ```
 
KeywordDetector class contains the main algorithm to detect the and replace the keywords. 

## Running the code

* **IDE:** you can run the main method for KeywordDetector.java class where it will ask you enter the full path for the input the output files. 
* **Command Line:** you can use the jar file under [dist folder](https://github.com/suleimana/Keyword-Detector/tree/master/dist) or compile your own, and then run the following command: 
```
java -jar KeywordDetector.jar 
```



## Algorithm time complixty

The code go through the whole file (char by char) once to detect one keyword. We also comapre if we have match with the keyword. 

So for an input file with N chars and one Keyword with L length, it will take O(NL). 

Therefore, for K number of keywords (such **L<sub>1</sub>,L<sub>2</sub>,L<sub>3</sub>,...,L<sub>k</sub>**) the time will be: **NL<sub>1</sub> + NL<sub>2</sub> + NL<sub>3</sub> + NL<sub>k</sub>**. 

If we assume that L only contains ASCII chars **0-127** then can cosider it as contanct **C**.

**NL<sub>1</sub> + NL<sub>2</sub> + NL<sub>3</sub> + NL<sub>k</sub> = **

**NC + NC + NC .... + NC = **

**(NC)K = **

Drop the constant and the time comlixty will be become **O(NK)**.
