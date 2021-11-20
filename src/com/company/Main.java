package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 800;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";

    public static String [] heroesAttackTypes = {"Physical", "Magical", "kinetic", "Medic"};
    public static int[] heroesHealth ={270, 280,240,300};
    public static int[] heroesDamage = {20, 25, 30, 0};






    public static int roundNumber = 0;

    public static void chooseDefence(){
        Random random = new Random();
       int randomIndex = random.nextInt(heroesAttackTypes.length);
       bossDefenceType = heroesAttackTypes[randomIndex];
        System.out.println(" Boss chose: " + bossDefenceType);
    }

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }

    }
    public static void round(){
        roundNumber++;
        chooseDefence();
        bossHits();
        heroesHit();
        printStatistics();
    }
    public static boolean isGameFinished(){
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i <heroesHealth.length; i++) {
            if (heroesHealth[i] > 0){
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead){
            System.out.println("Boss won!!!");

        }


        /*if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0 ) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;*/
        return allHeroesDead;

    }
    public static void printStatistics(){
        System.out.println("--------ROUND" + roundNumber + "---------");
        System.out.println("Boss health: " + bossHealth + " [" + bossDamage + "]" );
        for (int i = 0; i <heroesHealth.length; i++) {
            System.out.println( heroesAttackTypes[i] + " health: " + heroesHealth[i] +
                    " [" + heroesDamage[i] + "]" );

        }
        System.out.println("-----------------------------");


    }
    public static void bossHits(){
        for (int i = 0; i <heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0){
                    heroesHealth[i] = 0;

                }else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }

        }
    }
    public static void heroesHit(){
        for (int i = 0; i <heroesDamage.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossDefenceType == heroesAttackTypes[i]){
                    Random random =new Random();
                    int coeff = random.nextInt(9) + 2;

                    if (bossHealth - heroesDamage[i]* coeff < 0) {
                        bossHealth = 0;
                    } else {


                        bossHealth = bossHealth - heroesDamage[i]* coeff;
                    }
                    System.out.println("Critical damage: " + heroesDamage[i] * coeff);
                } else {
                }

            }

        }
    }
    public static void medicHeal(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackTypes.length);
         




    }


}
