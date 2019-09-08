package bearmaps.proj2ab;

import java.util.*;

public class TestShit
{

    public static void main(String[] args)
    {
        //System.out.println(cleanString("College Av & Woolsey St"));
        String mine = "85°C Bakery Cafe, C2020 Optometry, Car Service, Caravaggio, Cactus Taqueria, Casa de Cultura, Casa Latina, Casual Male XL, Catahoula Kaffeegarten, Catrina Rosalle, Cat's Cuts and Styles, Cato's Ale House, Cadet Chester F.M. Buchanan, Café Zeb, Café Leila, Cafe Panini, Cafe Raj, Cafe Rio, Cafe Blue Door, Cafe Strada, Cafe Crush, Cafe Colucci, Cafe Trieste, Cafe Tibet, Cafe Durant, Cafe Milano, Cafeína, Caffe Duetto, Caffe Trieste, Caffe Nefeli, Caviar & Cigarettes, Cakes and Purls, Cal Student Store, Cal Seasons, Cal Suds, Cal Copy, Cal Glass, Cal Moore Memorial Bench, Caltrans 55th Street Maintenance Station, Caltrans Ettie Street Maintenance Station, California, California Pizza Kitchen, California Bank & Trust, California Center for Innovative Transportation, California Historical Radio Society Bay Area Radio Museum, cam, Campus Auto Care, Campus Dr & Shasta Rd, Campus Dr & Del Mar Av, Campus Dr & Glendale Av, Campus Dental Care, Campus Veterinary Clinic, Camille, Cancún, Cannabis Dispensary, Cracked, Cragmont Park, Crepes A-Go-Go, Crepevine, Cream, Cresco, Crunch, Cricket, Crixa Cakes, Crops of the World, Crossroads, Crossroads Trading Co., Crossfit Oakland, Crossfit Oakland Uptown, César, Cest Cafe, Cedar Rose Park, Cedar Market, Celtic Inheritance, Celia's, Central Berkeley, Central Nail Spa, Center St & Oxford St, Center Street & Milvia Street, Center Street Garage, Centennial Dr & Parking Lot, Centennial Dr & Lawrence Hall of Science, Century 21 M&M, CU Sushi and Roll, Curbside Cream, Cuttin' up on College, Cugini, CVS, CVS Pharmacy, Chaparral, Chaparral Peak, Cha Ya Japanese Cuisine, Chaat Café, Charles Schwab, Charm School Salon, Chase, Chris Thai Cuisine, Christensen Heller Gallery, Christian Science Organization at the University, Christopher's, Cheapskate Hill, Cherished Tattoo, Check Cashing, Check Center, Cheese Steak Shop, Cheese 'n Stuff, Cheeseboard Parklet, Cheeseboard Pizza, Cheetah's Muay Thai Acadamy, Chevron, Chevys Fresh Mex, Chez Panisse, Chemistry and Chemical Engineering Library, Chengdu Style Restaurant, Church of Christ of the Golden Gate, Church of the Good Shepherd, Church of the Living God, Church's Chicken, Chipotle, Chipotle Mexican Grill, Chic, Chic Salon, Chick'n Rice, Children's Hospital & Research Center Oakland - Parking Garage, Child's Play, Chile Jalapeño, China Village Restaurant, Chinese Baptist Church, Chop Salon, CHORI Research Institute, Chocolaté Alegio, Chocolatier Blue, Choice Meat Market Wholesale Retail Packaging, Restaurant Supplies, Cholita Linda, Ciao Bella Gelato, City CarShare, City Hall Annex, City of Berkeley - Center & Shattuck (Center St Garage), City of Berkeley - Milvia & Center, City of Berkeley - MLK & Allston, City of Berkeley Permit Service Center, Citibank, Civicorps Elementary School, Cinnaholic, Cyprus, Cyclebar, CycloMedia Technology Inc., Claremoint Entrance, Claremont, Claremont Branch Berkeley Public Library, Claremont Canyon Regional Preserve, Claremont Club, Claremont Day Nursery, Claremont Diner (CLOSED), Claremont Veterinary Hospital, Claremont Lobby Lounge & Bar, Class of 1914 Fountain, Clawson School, Clean Cleaners, Clove and Hoof, Copy Central, Copy Express, Corso Trattoria, Corepower Yoga, Cornerstone, Cornology, Cosmic Cycles, Country Cheese Coffee Market, Coffee Conscious, Coldwell Bankers, Cole Coffee, College Point Cafe, College Av & Parker St, College Av & Ashby Av, College Av & Alcatraz Av, College Av & Russell St, College Av & Rock Ridge BART Station, College Av & Chabot Av, College Av & Claremont Av, College Av & Derby St, College Av & Webster St, College Av & Woolsey St, College Av & Haste St, College Av & Miles Av (Claremont Middle School), College Av & Oak Grove Av (Opp. Claremont), College of Environmental Design, ComputerLand, Comal, Comeback Cafe, Commis, Condominium, Congregation Beth Israel";
        String AG = "85°C Bakery Cafe, C2020 Optometry, Car Service, Caravaggio, Casa de Cultura, Casa Latina, Casual Male XL, Cactus Taqueria, Catahoula Kaffeegarten, Catrina Rosalle, Cat's Cuts and Styles, Cato's Ale House, Cadet Chester F.M. Buchanan, Café Zeb, Café Leila, Cafe Panini, Cafe Raj, Cafe Rio, Cafe Blue Door, Cafe Crush, Cafe Colucci, Cafe Strada, Cafe Trieste, Cafe Tibet, Cafe Durant, Cafe Milano, Cafeína, Caffe Trieste, Caffe Duetto, Caffe Nefeli, Caviar & Cigarettes, Cakes and Purls, Cal Copy, Cal Student Store, Cal Suds, Cal Seasons, Cal Glass, Cal Moore Memorial Bench, Caltrans 55th Street Maintenance Station, Caltrans Ettie Street Maintenance Station, California, California Pizza Kitchen, California Bank & Trust, California Center for Innovative Transportation, California Historical Radio Society Bay Area Radio Museum, cam, Campus Auto Care, Campus Dr & Shasta Rd, Campus Dr & Del Mar Av, Campus Dr & Glendale Av, Campus Dental Care, Campus Veterinary Clinic, Camille, Cancún, Cannabis Dispensary, Cracked, Cragmont Park, Crepes A-Go-Go, Crepevine, Cream, Cresco, Crunch, Cricket, Crixa Cakes, Crops of the World, Crossroads, Crossroads Trading Co., Crossfit Oakland, Crossfit Oakland Uptown, César, Cest Cafe, Cedar Rose Park, Cedar Market, Celtic Inheritance, Celia's, Central Berkeley, Central Nail Spa, Century 21 M&M, Center St & Oxford St, Center Street & Milvia Street, Center Street Garage, Centennial Dr & Parking Lot, Centennial Dr & Lawrence Hall of Science, CU Sushi and Roll, Curbside Cream, Cuttin' up on College, Cugini, CVS, CVS Pharmacy, Cha Ya Japanese Cuisine, Chaparral, Chaparral Peak, Chaat Café, Charles Schwab, Charm School Salon, Chase, Chris Thai Cuisine, Christensen Heller Gallery, Christian Science Organization at the University, Christopher's, Church of Christ of the Golden Gate, Church of the Good Shepherd, Church of the Living God, Church's Chicken, Cheapskate Hill, Cherished Tattoo, Check Cashing, Check Center, Cheese Steak Shop, Cheese 'n Stuff, Cheeseboard Parklet, Cheeseboard Pizza, Cheetah's Muay Thai Acadamy, Chevron, Chevys Fresh Mex, Chez Panisse, Chemistry and Chemical Engineering Library, Chengdu Style Restaurant, Chipotle, Chipotle Mexican Grill, Chic, Chic Salon, Chick'n Rice, Children's Hospital & Research Center Oakland - Parking Garage, Child's Play, Chile Jalapeño, China Village Restaurant, Chinese Baptist Church, Chop Salon, CHORI Research Institute, Chocolaté Alegio, Chocolatier Blue, Choice Meat Market Wholesale Retail Packaging, Restaurant Supplies, Cholita Linda, Ciao Bella Gelato, Citibank, citibank, City CarShare, City Hall Annex, City of Berkeley - Center & Shattuck (Center St Garage), City of Berkeley - Milvia & Center, City of Berkeley - MLK & Allston, City of Berkeley Permit Service Center, Civicorps Elementary School, Cinnaholic, Cyprus, Cyclebar, CycloMedia Technology Inc., Claremoint Entrance, Claremont, Claremont Branch Berkeley Public Library, Claremont Canyon Regional Preserve, Claremont Club, Claremont Day Nursery, Claremont Diner (CLOSED), Claremont Veterinary Hospital, Claremont Lobby Lounge & Bar, Class of 1914 Fountain, Clawson School, Clean Cleaners, Clove and Hoof, Copy Central, Copy Express, Corso Trattoria, Corepower Yoga, Cornerstone, Cornology, Cosmic Cycles, Country Cheese Coffee Market, Coffee Conscious, Coldwell Bankers, Cole Coffee, College Point Cafe, College Av & Parker St, College Av & Ashby Av, College Av & Alcatraz Av, College Av & Russell St, College Av & Rock Ridge BART Station, College Av & Chabot Av, College Av & Claremont Av, College Av & Derby St, College Av & Webster St, College Av & Woolsey St, College Av & Haste St, College Av & Miles Av (Claremont Middle School), College Av & Oak Grove Av (Opp. Claremont), College of Environmental Design, ComputerLand, Comal, Comeback Cafe, Commis, Condominium, Congregation Beth Israel";
        countWords(AG,mine);
    }

    private static void countWords(String AG, String mine)
    {
        String [] AGarr = AG.split(",");
        String [] mineArr = mine.split(",");

        List agList = Arrays.asList(AGarr);
        List mineList = Arrays.asList(mineArr);

        //System.out.println("AG had : "+AGarr.length+" words");
        //System.out.println("Mine had : "+mineArr.length+" words");

        System.out.println("AG had : "+agList.size()+" words");
        System.out.println("Mine had : "+mineList.size()+" words");
        System.out.println("-------------------------------------");


        Collections.sort(agList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Collections.sort(mineList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for(int i = 0; i <agList.size(); i++)
            System.out.println(agList.get(i) +" | "+mineList.get(i));




    }

    private static String cleanString(String s) {
        return s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

}
