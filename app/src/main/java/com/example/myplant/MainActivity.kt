package com.example.myplant

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

val list = listOf(
    plantdata(1,"English Ivy","https://cdn.shopify.com/s/files/1/0579/7924/0580/articles/feature_image.jpg?v=1662976943&width=1100.jpg",
        Common_names = listOf("English ivy","Common Ivy","European Ivy"), "English ivy (Hedera helix) is an evergreen perennial. It is also classified as a woody vine. English ivy can act as a ground cover, spreading horizontally. But it is also a climber, due to its aerial rootlets, which allows it to climb to 80 feet high.\n" +
                "\n" +
                "The plant will eventually bear insignificant greenish flowers, but it is grown primarily for its evergreen leaves. In this regard, ivy can be classified as a foliage plant. The best time to plant English ivy is spring. It is a fast, aggressive grower that is considered invasive in many areas. Keep a watchful eye on children and pets because English ivy is toxic to humans and animals."
    ),
    plantdata(2,"Bamboo","https://www.thespruce.com/thmb/HKWFNnau1PtT5CJBCiDTLPmbGak=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/how-to-grow-golden-bamboo-5077107-01-667ff5f2e49c49928ab91724728b498a.jpg",
   listOf("Bamboo", "golden bamboo", "fishpole bamboo", "monk’s belly bamboo", "fairyland bamboo"),"Bamboo has over a thousand plant species, and several tower 50 feet or more in the wild. But don't confuse \"lucky bamboo\" or the popular compact houseplant often bundled in rocks and water for a bamboo plant; it's not. Golden bamboo (Phyllostachys aurea) is an authentic bamboo that can grow in containers indoors. It has narrow, lance-shaped leaves that grow in clusters on short stems from canes. It features bright green upright canes that turn to a golden color with age and sunlight exposure.\n" +
                "\n" +
                "Golden bamboo grows quickly and can easily spread. It's best planted in the spring or early fall, though indoors, you generally can plant it any time of year. Planting it in a pot is ideal, keeping it contained and much more manageable. Indoors, it won't grow as large." ),
    plantdata(3,"Philodendron","https://www.thespruce.com/thmb/zSzhkAqo3q1a82FjxvNwGnO78IE=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/grow-philodendron-houseplants-1902768-04-8bee1496f67e41c392304329eaea505e.jpg",
        listOf("Philodendron"),"The Philodendron genus contains hundreds of species of beautiful foliage plants. Their leaves are typically large, green, and glossy, and philodendrons are great for adding a bit of their native tropical flair to your home. These popular houseplants are known for their easy growing habits, and there are two types of philodendrons to choose from: vining and non-climbing. The vining varieties grow several feet, usually requiring some support structure to climb on, such as a trellis or around a basket. Non-climbing varieties grow upright and are excellent foliage plants for containers. In general, philodendrons have a fast growth rate.\n" +
                "\n" +
                "Philodendrons are also a great plant choice to purify the air in your home. They’re best planted in the spring, but houseplants typically can be started with success at any time of year. They are toxic to pets1 and humans2 if ingested."
    ),
    plantdata(4,"Eucalyptus","https://www.thespruce.com/thmb/oGFM8dHye2BoZQKdVRV72m9f8GQ=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/DryingEucalyptus_300-7063b7e0fd7f4ce9aea79223b6512ad3.jpg",
    listOf("Eucalyptus", "silver dollar tree", "argyle apple"),"You might be most familiar with eucalyptus plants (Eucalyptus cinerea) as a favorite food of the koala. This evergreen tree can grow to nearly 60 feet high in its natural Australian environment. But when planting eucalyptus in home gardens, it usually remains small at around 6 to 10 feet high. It features reddish-brown bark that peels on the smaller branches. The leaves are a silvery to blue-green color, and they give off the plant’s distinct menthol-like fragrance when bruised. Eucalyptus trees are best planted in the spring. They have a fast growth rate and can gain several feet per year. It's important to note that the bark, leaves, and sap of eucalyptus are toxic both to humans1 and pets.2 "
    ),
    plantdata(5,"Cattleya Orchids","https://www.thespruce.com/thmb/QeEaPurQETUnYCCQL6phZSaFN4Y=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/cattleya-orchids-overview-1902861-01-41afe3700488424698d11752a10eee27.jpg",
    listOf("Cattleya orchid", "orchid", "corsage orchid", "Queen of the Orchids"),"When many people think of orchids, they probably picture a flower from the Cattleya (pronounced kat-lee-uh) genus. Cattleya orchids typically feature showy, fragrant flowers that come in a wide variety of shapes, colors, and color combinations. Many of the species sport quite large blooms that stretch several inches across while others have smaller but no less beautiful blooms. Cattleya orchids usually only flower once a year with the timeframe varying by species, though some hybrids, especially those crossed with Laelia orchids, have been cultivated to bloom more than once.\n" +
                "\n" +
                "These orchids are epiphytic, meaning they naturally grow attached to other plants, such as tree branches. Their foliage is typically a dull green color. The plants grow from pseudobulbs, which store nutrients and water. Cattleya orchids are generally long-lived plants and slow growers, taking roughly between four and seven years to mature. The best time to plant these orchids is once new growth appears after they're done flowering. Seeds generally can be started at any point."
    ),
    plantdata(6,"African Iris","https://www.thespruce.com/thmb/D8qtWX6rhXInESlMl2Yxgi6ZZEw=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/africairis-4d42c2c407ab41fd919a3c02dabc8792.jpg"
    , listOf("African iris", "fortnight lily"),"The African Iris (Dietes iridioides) is an evergreen plant that grows well in warmer zones, with a long season of flowering from spring through fall. This plant originates in South Africa. It has strappy narrow blue-green leaves that remain upright throughout the season. It can be grown as a perennial in zones 8 to 11, and in colder zones is commonly grown as an annual. It is also sometimes known as Dietes grandiflora and its taxonomy classification has changed somewhat over the years.\n" +
                "\n" +
                "This attractive plant has a round, six-petalled creamy white flower with a smaller four-petalled blue-purple flower that emerges in its center, with bright yellow accents running down the center of the white petals. The blooms fade rather quickly but new ones are produced continually during the blooming season."
    ),
    plantdata(7,"Baby's tears" , "https://www.thespruce.com/thmb/rCY_8zS0qnKHS6HCPywgIHS9AWA=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/baby-tears-plant-4582879-01-966c6024c3a649919378f019971b204c.jpg"
    , listOf("Baby tears", "baby's tears", "angel's tears"),"Baby's tears (Soleirolia soleirolii) is a mat-forming tropical perennial with myriad tiny leaves. Often confused as a type of moss, it comes from the nettle family. What makes baby's tears special is its dense, delicate mat of fine round or bean-shaped leaves on short, fleshy stems. Baby's tears plants are easy to grow for beginners, but they require regular attention to look their best.\n" +
                "\n" +
                "It thrives in lower-light conditions and is commonly used in terrariums and mixed containers. In warmer climates, it's grown outdoors as an evergreen ground cover or filler plant for rock gardens. In colder zones, if planted outdoors, it's an annual that dies out as the winter season starts. This fast-growing plant is easy to grow from potted nursery plants in the spring. Although, it is an invasive plant in warmer, tropical climates."
    ),
    plantdata(8,"Ball Cactus","https://www.thespruce.com/thmb/0vdMkUCV3Y0HQ_KvWoaWlqA27hQ=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/grow-parodia-cacti-indoors-1902591-2-4dc216d2fc7743f598b97b9f617c6867.jpg"
    , listOf("Ball cactus", "balloon cactus", "silver ball cactus", "blue ball cactus", "rounded ball cactus"),
        "The Parodia magnifica genus includes a multitude of showy and easy-to-grow small ball cacti. Their round appearance is to credit for their shapely name, and they can grow in pots in clusters up to over a foot wide. Ball cacti are moderate growers, adding about four inches to their height each year. Older plants will frequently produce flowers in beautiful shades of yellow, red, orange, or pink, and all varietals feature ridges of spikes that start white and grow to a yellow-brown with age."
    ),
    plantdata(9,"Calathea Orbifolia","https://www.thespruce.com/thmb/GQ49jEraIhFQGYuyFT-EWt39dks=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/calathea-orbifolia-growing-guide-5270824-hero-2a3b8667f05b40a49b27da573d2486fb.jpg"
    , listOf(	"Round-leaved calathea"),"It's not hard to see why so many houseplant enthusiasts covet calathea species. These striking tropical beauties have distinct stripes and veining on their oblong foliage. However, they're not always the best choice for novice plant lovers as they're particular when it comes to the care and conditions they require (think frequent watering and high humidity).\n" +
                "\n" +
                "The round-leaved calathea (Calathea orbifolia or, the more recent synonym, Geoppertia orbifolia) is no exception. The silver-green stripes on its luxuriant, large leaves make it a bold statement plant, but it's somewhat fussy and definitely doesn't fall into the low-maintenance category.\n" +
                "\n" +
                "However, this tricky plant has lots going for it if you're willing to put in the extra effort. Calthea oribifolia is fast-growing, pet-friendly, lush, and eye-catching."
    )

)
lateinit var viewmodel: Viewmodel
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel= ViewModelProvider(this , viewmodelfactory(applicationContext)).get(Viewmodel::class.java)
        viewmodel.insertdatatoroom(list)
        viewmodel.getlist()
    }
}