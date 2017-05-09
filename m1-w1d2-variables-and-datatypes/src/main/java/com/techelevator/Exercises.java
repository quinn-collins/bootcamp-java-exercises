package com.techelevator;

import java.text.DecimalFormat;

public class Exercises {

	public static void main(String[] args) {
		DecimalFormat d = new DecimalFormat("'$'0.00");
        
        /* 
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch? 
        */
		int birds = 4;
		int birdsFlewAway = 1;
		int birdsLeft = birds - birdsFlewAway;
		System.out.println(birdsLeft);
        /* 
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests? 
        */
		int birds2 = 6;
		int nests = 3;
		int result = calculateSubtract(birds2, nests);
		System.out.println("The result is " + result);
        /* 
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods? 
        */
		int racoonWoods = 3;
		int racoonLeft = 2;
		result = calculateSubtract(racoonWoods, racoonLeft);
		System.out.println("The result is " + result);
        /* 
        4. There are 5 flowers and 3 bees. How many less bees than flowers? 
        */
		int flowers = 5;
		int bees = 3;
		result = calculateSubtract(flowers, bees);
		System.out.println("The result is " + result);
        /* 
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now? 
        */
		int pigeonEat = 1;
		int pigeonCome = 1;
		result = calculateAdd(pigeonEat, pigeonCome);
		System.out.println("The result is " + result);
        /* 
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now? 
        */
		int owlsSit = 3;
		int owlsJoin = 2;
		result = calculateAdd(owlsSit, owlsJoin);
		System.out.println("The result is " + result);
        /* 
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home? 
        */
		int beaversHome = 2;
		int beaversSwim = 1;
		result = calculateSubtract(beaversHome, beaversSwim);
		System.out.println("The result is " + result);
        /* 
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all? 
        */
		int toucansTree = 2;
		int toucans = 1;
		result = calculateAdd(toucansTree, toucans);
		System.out.println("The result is " + result);
        /* 
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts? 
        */
		int squirrelTree = 4;
		int nuts = 1;
		result = calculateSubtract(squirrelTree, nuts);
		System.out.println("The result is " + result);

        /* 
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find? 
        */
		double quarter = .25;
		double dime = .01;
		double nickel = .05;
		double result2 = quarter + dime + nickel * 2;
		System.out.println("The result is " + d.format(result2));
		
        /* 
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all? 
        */
		int hilt = 18;
		int macadams = 20;
		int flannery = 17;
		result = hilt + macadams + flannery;
		System.out.println("The result is " + result);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
        double yoyo = .24;
        double whistle = .14;
        result2 = yoyo - whistle;
        System.out.println("The result is " + d.format(result2));
        
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
        int x = 8;
        int y = 10;
        result = x + y;
        System.out.println("The result is " + result);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
        int hiltSnow = 29;
        int brecknockSnow = 17;
        result = hiltSnow + brecknockSnow;
        System.out.println("The result is " + result);
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
        double hiltMoney = 10;
        double toyTruck = 3;
        double pencilCase = 2;
        hiltMoney = hiltMoney - toyTruck - pencilCase;
        System.out.println("The result is " + d.format(hiltMoney));
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
        int joshMarbles = 16;
        int lostMarbles = 7;
        result = joshMarbles - lostMarbles;
        System.out.println("The result is " + result);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
        int seashellsWanted = 25;
        int seashellsMegan = 19;
        result = seashellsWanted - seashellsMegan;
        System.out.println("The result is " + result);
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
            int allBalloons = 17;
            int redBalloons = 8;
            result = allBalloons - redBalloons;
            System.out.println("The result is " + result);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
        int booksOnShelf = 38;
        int martaBooks = 10;
        result = booksOnShelf + martaBooks;
        System.out.println("The result is " + result);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
        int beeLegs = 6;
        int numberBees = 9;
        result = beeLegs * numberBees;
        System.out.println("The result is " + result);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
        double iceCream = .99;
        result2 = iceCream * 2;
        System.out.println("The result is " + d.format(result2));
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
        int borderRocks = 64;
        int rocksNeeded = 125;
        result = rocksNeeded - borderRocks;
        System.out.println("The result is " + result);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
        int hiltMarbles = 38;
        int lost = 15;
        result = hiltMarbles - lost;
        System.out.println("The result is " + result);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
        int concertMiles = 78;
        int droveMiles = 32;
        result = concertMiles - droveMiles;
        System.out.println("The result is " + result);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
        int saturdayMorning = 90;
        int saturdayAfternoon = 45;
        result = saturdayMorning + saturdayAfternoon;
        System.out.println("The result is " + result);
        /*    
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
        int hiltDogs = 6;
        double dogCost = .5;
        result2 = hiltDogs * dogCost;
        System.out.println("The result is " + d.format(result2));
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
        double hiltCents = .5;
        double pencilCost = .07;
        result2 = hiltCents / pencilCost;
        System.out.println("The result is " + (int)result2);
        /*    
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
        int allButterflies = 33;
        int orangeButterflies = 20;
        result = allButterflies - orangeButterflies;
        System.out.println("The result is " + result);
        /*    
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
        double kateMoney = 1;
        double candyCost = .54;
        result2 = kateMoney - candyCost;
        System.out.println("The result is " + d.format(result2));
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
        int markTrees = 13;
        int plantTrees = 12;
        result = markTrees + plantTrees;
        System.out.println("The result is " + result);
        /*    
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
        int days = 2;
        int hours = 24;
        result = days * hours;
        System.out.println("The result is " + result);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
        int kimCousins = 4;
        int gum = 5;
        result = kimCousins * gum;
        System.out.println("The result is " + result);
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
        double danMoney = 3;
        double candyBarCost = 1;
        result2 = danMoney - candyBarCost;
        System.out.println("The result is " + d.format(result2));
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
        int boatsLake = 5;
        int peopleInBoats = 3;
        result = boatsLake * peopleInBoats;
        System.out.println("The result is " + result);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
        int ellenLegos = 380;
        int lostLegos = 57;
        result = ellenLegos - lostLegos;
        System.out.println("The result is " + result);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
        int arthurBakes = 35;
        int totalBakes = 83;
        result = totalBakes - arthurBakes;
        System.out.println("The result is " + result);
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
        int willyCrayons = 1400;
        int lucyCrayons = 290;
        result = willyCrayons - lucyCrayons;
        System.out.println("The result is " + result);
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
        int pageStickers = 10;
        int pagesOfStickers = 22;
        result = pageStickers * pagesOfStickers;
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
        int cupcakes = 96;
        int children = 8;
        result = cupcakes / children;
        System.out.println("The result is " + result);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
        int gingerCookies = 47;
        int jarContain = 6;
        result = gingerCookies % jarContain;
        System.out.println("The result is " + result);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
        int croissants = 59;
        int giveCroissants = 8;
        result = croissants % giveCroissants;
        System.out.println("The result is " + result);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
        int oatCookies = 276;
        int cookiesOnTray = 12;
        result = oatCookies / cookiesOnTray;
        System.out.println("The result is " + result);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
        int totalPretzels = 480;
        int oneServing = 12;
        result = totalPretzels / oneServing;
        System.out.println("The result is " + result);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
        int lemonCupcakes = 53;
        int leftHome = 2;
        int boxes = 3;
        result = (lemonCupcakes - leftHome) / boxes;
        System.out.println("The result is " + result);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
        int carrotSticks = 74;
        int people = 12;
        result = carrotSticks % people;
        System.out.println("The result is " + result);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
        int allTeddys = 98;
        int shelves = 8;
        result = allTeddys / shelves;
        System.out.println("The result is " + result);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
        int album = 20;
        int pictures = 480;
        result = pictures / album;
        System.out.println("The result is " + result);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
        int joeTrading = 94;
        int fullBox = 8;
        result = joeTrading / fullBox;
        System.out.println("The result is " + result);
        result = joeTrading % fullBox;
        System.out.println("The result is " + result);
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
        int readingShelves = 10;
        int bookForShelves = 210;
        result = bookForShelves / readingShelves;
        System.out.println("The result is " + result);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
        double christBaked = 17;
        double guests = 7;
        result2 = christBaked / guests;
        System.out.println("The result is " + result2);
        
	}
	
	public static int calculateSubtract(int x, int y){
		int result = x - y;
		return result;
	}
	
	public static int calculateAdd(int x, int y){
		int result = x + y;
		return result;
	}

}
