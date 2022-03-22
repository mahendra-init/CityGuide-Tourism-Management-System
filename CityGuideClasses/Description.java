package CityGuideClasses;

import java.awt.Font;

public class Description {

    String[] loc;

    public Font derivedFont(String filename, int size) {
        Font fn = null;
        try {
            fn = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(filename + ".ttf"));
            fn = fn.deriveFont(Font.PLAIN, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fn;
    }

    Description() {
        loc = new String[]{
            //goa = 0
            "       \" One of India's tallest waterfalls, the Dudhsagar Falls is located inside \n"
            + "         the Mollem National Park. The Dudhsagar falls should be visited during\n"
            + "         the monsoon when it is in full flow and the surrounding deciduous\n"
            + "         forests are at their verdant best.\"",
            "               \"Anjuna Beach is among the most popular beaches in North Goa, \n"
            + "             stretching almost 2km. From family outings to adrenaline-filled \n"
            + "             adventures, Anjuna Beach is famed for its golden coastline, nightclubs,\n"
            + "              beach shacks, watersports, full-moon parties and flea markets.\"",
            "               \"Cruise in Goa allows one to explore the exotic scenery, pristine waters\n"
            + "             and marvel the breathtaking view of the sunset. There are several types\n"
            + "             of cruises in Goa ranging from simple evening cruises, elaborate and \n"
            + "             romantic dinner cruises, backwater cruises, and casino cruises. \n"
            + "                All of these usually originate from Miramar Beach in Panjim.\"",
            "         \"Fort Aguada is a 17th-century Portuguese fort looking out at the confluence\n"
            + "        of Mandovi River and the Arabian Sea. The crumbling ramparts of the \n"
            + "       fort stand on the Sinquerim Beach. The highlight of the fort is a lone \n"
            + "              four-storey lighthouse (which is one-of-its-kind in Asia) \n"
            + "                          and a stunning view of the sunset.\"",
            "               \"The Basilica of Bom Jesus Church is a UNESCO World Heritage Site. \n"
            + "                  It houses the tomb and remains of St. Francis Xavier. \n"
            + "                   Even after 400 years, the remains are in a good condition \n"
            + "                         and are taken out once every decade.\"",
            "               \"For carrying back an authentic Goan experience with you, you can buy \n"
            + "             some feni, cashew-nuts, Goan hats and handicrafts. There are lots\n"
            + "                 of shops in Panjim, the capital where you can buy interesting stuff.\n"
            + "                 Goa is also known for its hand-painted ceramics.\"",
            "               \"Located in the famous Titos lane, Mambos is a popular nightclub in Goa.\n"
            + "             The open-air lounge encircles a dancing area with a host of Indian \n"
            + "             and international DJs playing every night. They also serve a \n"
            + "                         variety of Hookahs.\"",
            "               \"Located on a yacht in River Mandovi, the casino is one of the coolest \n"
            + "             places to be when you're in the party state. The entry fee is placed \n"
            + "             high at Rs. 1600, and the casino holds ample number of tables of \n"
            + "             American Roulette, Blackjack and Rummy. Go ahead and try your luck!\"",
            //manali = 1
            "           \"Solang Valley is one of the most popular tourist destinations in Himachal \n"
            + "         Pradesh. It is popular for adventure sports. During winters, Solang valley\n"
            + "          is covered with snow making skiing is a popular sport here. There are training\n"
            + "          institutes and trainers located to supervise skiers and train beginners.\"",
            "           \"Jogini Waterfall is located about 3 kilometres away from the bustling town\n"
            + "             of Manali and around 2 kilometres away from Vashisht Temple. Tourists\n"
            + "             have to trek ahead from the temple to reach Jogini Waterfall.\"",
            "           \" Rohtang pass is the stretch which connects Manali to Himachal's more dreamy\n"
            + "          and dessert-like landscapes, Spiti and Lahaul. This vast snow desert is\n"
            + "          a landscape like only a few other and a view one should not miss. Popular\n"
            + "          adventure sports here are sledge ride, mountain biking, and skiing. \n"
            + "         Many blockbusters ranging from 'Jab We Met' to 'Yeh Jawani Hai Deewani' \n"
            + "                            have been shot here.\"",
            "           \"The newest addition to the list of National parks in India, The Great\n"
            + "          Himalayan National Park is quickly becoming what the wildlife scene in \n"
            + "                  the region is being identified with and defined by.\"",
            "       \"On the other side of the Manalsu river is a part of Manali, time left behind. \n"
            + "     With a sweet scent of an old world charm, interspersed with guesthouses and \n"
            + "     an increasing presence of tourism and hints of the present that it brings along, \n"
            + "     Old Manali is a tiny shift in the world and its rush, one must experience while here.\"",
            "\"River Beas and is considered ideal for expert rafters as well as beginners. \n"
            + "The section of rafting starts from a small district called Pirdi, usually at 10:00 AM \n"
            + "and takes about 1.5 hours. It is open throughout the week and people are advised to\n"
            + " avoid the time when there is heavy rainfall which can lead to the rise in water level. \n"
            + "The total cost of rafting in Kullu-Manali ranges from INR 500 to INR 2000 per person.\"",
            "\"Hadimba temple, away from the hustle and bustle of city life, is a peaceful place \n"
            + "surrounded by towering deodar trees. The temple is dedicated to Hidimba, the wife \n"
            + "of Bhima, one of the five Pandava prince from the great Indian epic Mahabharata.\n"
            + " The main attraction of the temple is the three day Hidimba Devi Festival, \n"
            + "which attracts devotees from all over the world and features colourful folk\n"
            + " dance performances.\"",
            "\"The hillside town of Manali is famous for paragliding. At 2050 metres above sea level,\n"
            + " it is an ultimate location for the sport, with its beautiful green valleys, stark blue\n"
            + " skies, and snow-capped mountain peaks. The picture-perfect valley boasts of ideal\n"
            + " wind conditions for paragliding and is thronged by both international and domestic\n"
            + " tourists. Starting with a basic training course, the operators are well organized, \n"
            + "competent and trustworthy.\"",
            //srinagar =  2
            "     \"A mountain pass in the Pir Panjal Mountain Ranges, Sithan Top is found along the \n"
            + "National Highway of Kokernag-Sinthan Top-Kishtwar Road. This pathway connects Jammu and \n"
            + "Kashmir. The snow-laden hilltop is lately emerging as a new tourist destination owing\n"
            + " to the beautiful views and the idyllic setting. It is also popular for mountaineering,\n"
            + "                  trekking and skiing.\"",
            "\"Situated 22km from the main town of Srinagar, Dachigam National Park is known for housing\n"
            + " rare Kashmir stag which is the only species of red deer in India. Other animals that can be \n"
            + "spotted here includes Himalayan brown bear to Pygmy Owlets to the predators, the leopards.\"",
            "\"The House of Fairies or Pari Mahal is a historic monument placed above the beautiful \n"
            + "Chashma Shahi Gardens near Srinagar. A well-laid spacious garden surrounds this structure,\n"
            + " which was once a Buddhist monastery and later served as a school of astrology promoted by\n"
            + "          the eldest son of Shah Jahan, Dara Shikoh.\"",
            "\"Char Chinar is an island in the Dal Lake of Srinagar, surrounded by the Chinar trees on all\n"
            + " four sides of it. Also known as Char Chinari (char chinari means four sides) and Rupa Lank, \n"
            + "it was constructed by Murad Baksh, the brother of Mughal emperor Aurangzeb. The Char Chinar \n"
            + "         is best explored during a shikara ride in the Dal Lake.\"",
            "\"Staying in a houseboat amidst pristine waters of the Dal Lake, is one of the most essential\n"
            + "    things to do in Srinagar. Made in wood and adorned in a typical Kashmir style decor, \n"
            + "         the houseboats are a perfect way to experience the quintessential \n"
            + "                     local life in the luxurious way.\"",
            "\"Srinagar is also popular for its floating vegetable markets where vegetable and fruits are \n"
            + "sold around in the waters on the Shikara. More than a sell-purchase transaction, it is an\n"
            + " interesting place to visit for sightseeing. One of the most unique things to do in Srinagar,\n"
            + " these markets are run at the corner of the Dal Lake and besides the regular traders and\n"
            + "          buyers, they attract a whole lot of tourists.\"",
            "\"Shalimar Bagh is the largest of the three Mughal gardens in Srinagar.  It is now a \n"
            + "public park and is known as the \"crown of Srinagar\". The chini khanas or arched\n"
            + " niches placed behind waterfalls and the chinar trees are the highlights here.\"",
            "\"The famous Dal Lake is the second-largest lake in Jammu & Kashmir. The mirror-like\n"
            + " lake reflects the peaks of the Pir Panjal mountains while the colourful shikaras\n"
            + " (gondolas) float around. The houseboats and shikaras are its main attractions.\"",
            //lonavla = 3
            "\"Located 8km away from Lonavala, Tiger's Leap is a popular tourist point. It is a cliff \n"
            + "top with a sheer drop of over 650 m, offering a comprehensive view of the hills \n"
            + "and the Western Ghats. The echo point on Tiger's Leap is another major attraction.\"",
            "\"Midway between Lonavala and Khandala is a fort by the name of Rajmachi Fort, a prominent\n"
            + " landmark that watches over some of the most breathtakingly beautiful and wide\n"
            + "                  sceneries of the region.\"",
            "\"A one of its kind, this place is known for its irreplaceable grandeur and plush signature\n"
            + " features. The fountains of ecstasy, Sahyadri peaks and the historic Koyarigarh fort\n"
            + " offer a spectacular view of the grand Aambey valley city.\"",
            "\"A world class entertainment park, Imagica Adlabs is a one of its kind destination picnic\n"
            + " spot with plethora of entertainment options. Located on Mumbai-Pune Expressway, \n"
            + "this theme park is one of the latest additions in the list of Mumbai's entrainment hubs.\"",
            "\"The Lonavala - Bhimashankar trek is popular countryside trail. It is known for deep \n"
            + "and dense rain forests, meadows blooming with flowers, tiny rivulets, ethnic tribal \n"
            + "villages or long forgotten temples. The popularity of Lonavala as a hill station only\n"
            + " adds to the appeal and makes your experience priceless.\"",
            "\"Bungee Jumping in Lonavala takes place in the  Della Adventures park. The equipment is\n"
            + " attached at a height of 150 ft and lasts for about 7-10 minutes. People above the\n"
            + " age of 10, with a body weight of above 35 kgs are allowed to take the jump. \"",
            "\"Kune Falls are the 14th highest waterfalls in India located in Lonavala. It is a \n"
            + "three-tiered waterfall set amidst the backdrop of Sahayadri mountains. Unfortunately,\n"
            + " the road to the Kune Falls is under private and hence visitor entry is restricted.\"",
            "\"Located in Rajmachi, the Bhairvanath Temple is dedicated to Lord Shiva, who is also known \n"
            + "as Bhairavnath. It is known for its architecture and design which is similar to \n"
            + "that of the other Shiva temples in the Konkan region.\"",
            //udaipur = 4
            "\"Built in 1746 by Maharana Jagat Singh II, Taj Lake Palace is possibly one of the most\n"
            + " romantic structures of Udaipur. The palace was used as a recreation spot and \n"
            + "pleasurable residence of the king. Boasting of 66 rooms, the grand palace has been\n"
            + " converted into a heritage hotel and hosts tourists from all over the world.\"",
            "\"Dating back to 17th century, Bada Mahal is an incredible structural marvel. Constructed \n"
            + "in Rajput-Mughal architectural style, the Mahal is considered as the Men''s section\n"
            + "                      of the City Palace.\"",
            "\"The oldest and one of the largest lakes of Udaipur, Lake Pichola is enveloped by lofty\n"
            + " Palaces, temples, bathing ghats and elevated hills on all its sides.\"",
            "\"The Mansapurna Karni Mata Temple, built by Maharana Karan Singh and located atop \n"
            + "the Machhala Magar hilltop, was quite a remote shrine for the general public \n"
            + "to access. For this reason, it was not a much-visited temple previously. \n"
            + "But in 2008, the ropeway line connecting the plain and the temple at the peak of the hill\n"
            + " was commenced to make it easier for the public to reach the holy shrine and seek blessings\n"
            + "                      of Goddess Karni.\"",
            "\"Located at the foot hills of Aravali Mountains in Udaipur, Shilpgram is a craftsmen's\n"
            + " village which encloses twenty-six huts constructed in traditional architectural\n"
            + " styles and these huts display many house hold decorative articles.\"",
            "\"A majestic garden located in one of the shores of Fateh Sagar Lake, Saheliyon-ki-Bari\n"
            + " has expensive lawns, shady cool walking lanes and imposing fountains. \n"
            + "It is one of the best places in Udaipur to relax.\"",
            "\"An exquisite palace placed in an estuary Island in Pichola Lake, Jag Mandir Palace \n"
            + "offer a blissful view of sunset and the spacious courtyard with black and white \n"
            + "marble tiles Is a striking feature of this architectural marvel.\"",
            "\"One of the best architectural marvels in the state of Rajasthan, the City Palace in Udaipur"
            + " is located on the banks of Lake Pichola. The grand white City Palace is a heritage building,\n"
            + " almost like a fairy-tale, and it showcases the best elements of Rajput Culture and arts.\"",
            // varanashi
            "\"Consider the holiest river for the Hindus, experience the feeling of dipping in the\n"
            + " holy waters, which are said to offer salvation for any sins that you have committed.\n"
            + " There is absolutely no money that you have to pay for taking a bath in River Ganga.\n"
            + "     If you look around,you will see countless people doing the same.\"",
            "\"Viewing Varanasi from a boat in the Holy Ganga will leave you mesmerized. Included\n"
            + " in the Varanasi packages, the best time to witness the magnificence of nature\n"
            + " is between 5:30-8:00 am. Boat rides range from about 200 INR to about 1500 INR\n"
            + " and differ from ghat to ghat, duration of the ride, and type of boat.\"",
            "           \" Situated in Thammampatti, this 11th-century fort is a marvelous sight.\n"
            + "        The stunning architecture of the fort and the surrounding areas will\n"
            + "        leave you awestruck and is part of the Varanasi holiday packages.\"",
            "\"Constructed by Sawai Jai Singh II in 1737, this observatory is built on the top of the\n"
            + " Man Singh Palace. It is situated in Bangali Tola and is now under the observation\n"
            + "                  of the Archaeological Survey of India.\"",
            "\"The most relevant fable that is still circulated is that this is the ghat where Lord\n"
            + " Brahma made the famous Dasa Ashwamedha (10 horses) sacrifice. This folklore contributes\n"
            + " to the name of the ghat and holds massive religious importance to the pilgrimages.\n"
            + " Situated in the Dashashwamedh Ghat Road, the Ganga aarti done here is simply surreal.\"",
            "\"Famous for being one of the 12 Jyotirlingas, the Kashi Vishwanath Temple, located in \n"
            + "Lahori Tola, is dedicated to Lord Shiva. The intricate carvings display the architectural \n"
            + "prowess of the long-gone era. The temple complex also consists of several small \n"
            + "         temples like Vishnu, Vinayaka, etc.\"",
            "\"Located near the Banaras Hindu University, Assi Ghat witnesses the convergence of River\n"
            + " Ganga and River Assi. With various ancient folklore weaved around the ghat, this place,\n"
            + "  included in the Varanasi Tour Packages, is often crowded by the staunch devotees of\n"
            + " Lord Shiva. Offering prayers to the Shiva Lingam placed under the peepal tree and watching\n"
            + "          the mesmerizing aarti will definitely soothe your soul.\"",
            "\"Built on the Guleria Ghat, this 18th-century river-front house is accessible only by boats.\n"
            + " The place strives to blend Indian hospitality with luxurious amenities.\n"
            + "              The price is provided on request.\""};

    }
}
