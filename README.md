# WhatYouEat

![ezgif com-gif-maker](https://user-images.githubusercontent.com/86586065/150668227-db59ba2f-f06f-486e-8ef2-8494e4fecd63.gif)


The Minecraft plugin for your post-dietary needs!

The goal of this project was to make people laugh. I hope it does. :)

This plugin adds some enhanced functionality to classic Minecraft gameplay -- namely adding the ability to shit yourself when you squat. By eating certain items, you can also excrete that out of your backside intact (well, mostly). Hence, "you are what you eat".

YAWYE was built with Java 17, Blockbench, and the Paper MC 1.18.1 API. It uses hashmaps to store each player's ID and what they've last eaten along with how many times they try to shit themselves, because some of these dookies are gonna be LARGE.

There were no tutorials on how to make a server resource pack with custom models, and Blockbench was useless with exporting in the correct format, so I had to take a crash course the day before by dissecting a few of them myself. On the Java side, apparently hashmaps delete themselves unless you instantiated them in the Main class and had the rest of the classes access them through there instead of, yk, through the data class itself. Debugging this was a pain in the ass (just like pooping in game ::) ) coupled with the fact that the MC client kicked you out ever 30 seconds when trying to remote debug the plugin.

In the future, I'd like to make sound effects random and increase the quantity and randomness of shit textures (so brown dye, bread, logs, etc instead of just cocoa nibs) so I can truly make something EXPLOSIVE!

## Usage
Every time you shift you poo. I guess you didn't drink enough water because they're the little pebbly shits that rapid fire plop into the toilet. Every shit will remove 1 saturation if full, or 1 hunger if saturation is zero. Yes, you can kill yourself from starvation from shitting too much.

Eating some foods (raw beef, raw pork, swords, apple) will make you shit out something... unique.

**Beef & Pork:** Takes 6 "pushes" to birth a cow or pig. Take 2.25 hearts of damage.
**Iron Sword:** Takes 1.5 hearts of damage, sword comes out your ass.
**Apple:** You shit out a tree. Don't swallow fruit seeds guys!

The first time you touch something with the name "Poo", you'll see a message from the game calling you nasty and inflicting you with poison since touching feces *is* unsanitary. Further touching is unnecessary and won't trigger anything (but really, don't touch poo) for the sake of not getting poisoned since the item pickup radius is relatively high.
