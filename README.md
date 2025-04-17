# mmbn-like
This is a small java game project inspired by mega man battle network style.

# About the game
Since the game is inspired by battle network series, we will follow its combat mechanics, which consists in a turn based battle of two players in a small grid map. All attacks and movements are quantified in squares and the objective is to kill your opponent before he does so. 

# Mechanics
The game will follow a rock paper scissors type of mechanic, where you and your opponent will both make your choices beforehand. These choices are defined in the format of cards (this will allow to introduce a deck building depth to the game), and they will be divided in three types: <code style="color : red">**ATTACK**</code>, <code style="color : blue">**DEFENSE**</code> and <code style="color : green">**MOVEMENT**</code>.

- <code style="color : red">**ATTACK**</code> - Quantified by **ATTACK DAMAGE** and **AREA**. These cards primarily objective is to inflict damage to your opponent life points.
- <code style="color : blue">**DEFENSE**</code> - Quantified by **SHIELD POINTS** and **DURATION**. These cards primarily objective is to add a shield to yourself.
- <code style="color : green">**MOVEMENT**</code> - Quantified by **DISTANCE**. These cards primarily objective is to move your character.
