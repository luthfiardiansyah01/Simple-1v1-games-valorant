package com.practice;

import java.util.Random;
import java.util.Scanner;

//player
class Agent{
    String name;
    int health;
    //object
    Arsenal arsenal;
    Maps maps;

    Agent(String name, int health){
        this.name = name;
        this.health = health;
    }

    void attack(Agent opponent){
        int attackPower = this.arsenal.attackPower;
        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);
        opponent.defence(attackPower);
    }

    void defence(int attackPower){
        //will take damage
        int damage;
        if(this.arsenal.defencePower < attackPower) {
            damage = attackPower - this.arsenal.defencePower;
        }else{
            damage = this.arsenal.defencePower - attackPower;
        }
        this.health -= damage;
        System.out.println(this.name + " got damage " + damage);
    }

    void buyingWeapon(Arsenal arsenal){
        this.arsenal = arsenal;
    }

    void choosingMaps(Maps maps){
        this.maps = maps;
    }

    void display(){
        System.out.println("\nName: " + this.name);
        System.out.println("Health: " + this.health);
        this.arsenal.display();
        this.maps.display();
    }
}

//weapon
class Arsenal{
    int attackPower;
    int defencePower;
    long money;
    String buyWeapon;

    Arsenal(String buyWeapon, long money, int attackPower){
        this.buyWeapon = buyWeapon;
        this.money = money;
        this.attackPower = attackPower;
    }

    void display(){
        System.out.println("Have a money: " + this.money + " after buy a weapon: " + this.buyWeapon + " then attack an opponent: " + this.attackPower);
    }
}

//maps
class Maps{
    String chooseMaps;

    Maps(String chooseMaps){
        this.chooseMaps = chooseMaps;
    }

    void display(){
        System.out.println("Maps:" + this.chooseMaps);
    }
}
public class PracticeWar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        //input player object
        System.out.println("Input your name of agent");
        String name = scanner.nextLine();

        //random of health from each agent
        int healthRand = rand.nextInt(101);
        int healthRandom = rand.nextInt(healthRand - 1);

        //random of player or agent Valorant
        int randoms =(int) (Math.random()*15);
        String enemy = new String[]{"Brimstone","Phoenix","Sage","Sova","Viper","Cypher","Reyna",
                                    "Killjoy","Breach","Omen","Jett","Raze","Skye","Yoru"}[randoms];
        Agent firstPlayer = new Agent(name,healthRand);
        Agent twoPlayer = new Agent(enemy, healthRandom);

        //input weapon and money object
        System.out.println("Input your weapon");
        String buy = scanner.nextLine();
        System.out.println("Input your money");
        long cash = scanner.nextLong();

        //random a money and attack power object
        int cashes = rand.nextInt(250);
        int kill = rand.nextInt(65);
        int attacking = rand.nextInt(10);
        int defending = rand.nextInt(20);

        //random of weapon object
        int rnd =(int) (Math.random()*18);
        String buys = new String[]{"Classic","Shorty","Frenzy","Ghost","Sheriff","Stinger",
                                   "Spectre","Bucky","Judge","Bulldog","Guardian","Phantom",
                                   "Vandal","Marshal","Operator","Ares","Odin","Knife"}[rnd];
        Arsenal weapon = new Arsenal(buy, cash, attacking);
        Arsenal weapons = new Arsenal(buys,800-cashes+ 200 * kill, defending);

        //random of maps object
        int maps =(int) (Math.random()*5);
        String mapping = new String[]{"Ascent","Bind","Haven","Icebox","Split"}[maps];
        Maps map = new Maps(mapping);

        //player 1
        firstPlayer.buyingWeapon(weapon);
        firstPlayer.choosingMaps(map);
        firstPlayer.display();

        //player 2
        twoPlayer.buyingWeapon(weapons);
        twoPlayer.choosingMaps(map);
        twoPlayer.display();

        //Chapter of War
        System.out.println("\nLet's get started!!");
        System.out.println("********************");
        System.out.println("Player 1 kill Player 2 in near bombsite A but don't die");
        System.out.println(" ");
        firstPlayer.attack(twoPlayer);
        firstPlayer.display();
        twoPlayer.display();
        System.out.println(" ");
        System.out.println("Player 1 planting the bomb in site A");
        System.out.println("Player 2 looking for Player 1 and set a trap on the bombsite A");
        System.out.println(" ");
        twoPlayer.attack(firstPlayer);
        firstPlayer.display();
        twoPlayer.display();
        System.out.println("\nAll died\nThe bomb exploded");
    }
}
