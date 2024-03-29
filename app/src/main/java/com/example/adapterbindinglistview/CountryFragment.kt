package com.example.adapterbindinglistview

import android.content.Intent
import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterbindinglistview.adapter.CountryAdapter
import com.example.adapterbindinglistview.databinding.FragmentCountryBinding
import com.example.adapterbindinglistview.model.country.Country

class CountryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCountryBinding.inflate(inflater, container, false)

        val countries = mutableListOf<Country>()

        countries.add(
            Country(
                "Russia",
                "143400000",
                "474.5 km^2",
                "https://pbs.twimg.com/media/EJZqyDYXsAAQJbW.png:large",
                "" +
                        "Russia is a country in Eastern Europe and Northern Asia. \n" +
                        "The territorial state has a size of over 17 million km² and a total coastal length of 37,653 km. \n" +
                        "This land mass is almost 48 times the size of Germany. Russia is thus the largest country in the world in terms of area, \n" +
                        "ahead of Canada and the USA. With 8.4 inhabitants per km², it is also one of the most sparsely populated countries in the world.\n" +
                        "A considerable proportion of the population (75%) is urban. Russia is divided into numerous geographical zones over its \n" +
                        "exceptionally large area. On average, it lies at an altitude of 600 m above sea level. The highest mountain peak (Elbrus) \n" +
                        "is 5,642 meters above sea level. The country has direct borders with 14 neighboring countries: Azerbaijan, Belarus, China, \n" +
                        "Estonia, Finland, Georgia, Kazakhstan, North Korea, Latvia, Lithuania, Mongolia, Norway, Poland and Ukraine.\n" +
                        "Russia is generally counted as part of Europe, although about three quarters of the country is located in \n" +
                        "the geographical area of Asia. However, this part is hardly inhabited. 85% of the population lives west of \n" +
                        "the Ural Mountains, which run from north to south and form the border between Europe and Asia. Especially \n" +
                        "the vast Siberia in the northwest is to a large extent uninhabited."
            )
        )

        countries.add(
            Country(
                "Antarctica",
                "143400000",
                "474.5 km^2",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Proposed_flag_of_Antarctica_%28Graham_Bartram%29.svg/1200px-Proposed_flag_of_Antarctica_%28Graham_Bartram%29.svg.png",
                "Antarctica, the southernmost continent and site of the South Pole, is a virtually uninhabited, ice-covered landmass. \n" +
                        "Most cruises to the continent visit the Antarctic Peninsula, which stretches toward South America. It’s known for \n" +
                        "the Lemaire Channel and Paradise Harbor, striking, iceberg-flanked passageways, and Port Lockroy, a former British \n" +
                        "research station turned museum. The peninsula’s isolated terrain also shelters rich wildlife, including many penguins.\n" +
                        "The continent of Antarctica makes up most of the Antarctic region. The Antarctic is a cold, remote area in the Southern \n" +
                        "Hemisphere encompassed by the Antarctic Convergence. The Antarctic Convergence is an uneven line of latitude where cold, \n" +
                        "northward-flowing Antarctic waters meet the warmer waters of the world’s oceans. The Antarctic covers approximately 20 percent \n" +
                        "of the Southern Hemisphere."
            )
        )

        countries.add(
            Country(
                "Canada",
                "143400000",
                "474.5 km^2",
                "https://avatars.mds.yandex.net/i?id=cd050444ff495d6ceb199245e4c79742a6aecd53-9225226-images-thumbs&n=13",
                "Canada is a country in North America between the US and Greenland, which consists of the rugged island regions \n" +
                        "of the Arctic in the north. The land has a total area of 9,984,670 km² (four million mi²) and a total coastline \n" +
                        "of 202,080 km (125,566.7 mi). This land area is only slightly larger than the United States. This makes Canada the second largest country \n" +
                        "in the world in terms of area after Russia. With 3.8 inhabitants per km² it is one of the most sparsely populated countries on earth. \n" +
                        "An exceptionally high proportion of residents (82%) belongs to the urban population.Canada is divided into numerous geographical zones \n" +
                        "in its exceptionally large area. The average elevation is 487 m above sea level. The highest mountain peak (Mount Logan) is at 5,959 meters. \n" +
                        "The country has 52,455 mostly uninhabited islands in the open sea. The United States ist the only directly neighboring country of Canada. \n" +
                        "The distance between New York City and the Capital Ottawa is about 540 km (336 mi)."
            )
        )

        countries.add(
            Country(
                "United States",
                "143400000",
                "474.5 km^2",
                "https://freepngimg.com/thumb/logo/127389-logo-american-flag-picture-free-download-png-hd.png",
                "The United States of America is a country between the Atlantic and the Pacific. The land has a total area of 9,831,510 km² \n" +
                        "(four million mi²) and a total coastline of 19,924 km (12,380.2 mi). This land area is about 1.3 times \n" +
                        "the size of Australia or 2.3 times the size of the European Union. This makes the United States the third \n" +
                        "largest country in the world in terms of area after Russia and Canada. An exceptionally high proportion of \n" +
                        "residents (83%) belongs to the urban population.The United States of America is divided into numerous geographical \n" +
                        "zones in its exceptionally large area. The average elevation is 760 m above sea level. The highest mountain peak \n" +
                        "(Denali, formerly Mount McKinley) is at 6,194 meters. The country has 18,617 mostly uninhabited islands in the open sea. \n" +
                        "There are direct national borders with the two neighboring countries Canada and Mexico. The distance between San\n" +
                        " Francisco and the capital, Washington, D.C., is about 3,920 km (2,436 mi).\n"
            )
        )

        countries.add(
            Country(
                "China",
                "143400000",
                "474.5 km^2",
                "https://www.hollandvlaggen.nl/wp-content/uploads/2019/07/Wereldvlaggen20-20Vlag20China.png",
                "China is a country in East Asia. The land has a total area of 9,562,910 km² (four million mi²) and a total coastline of 14,500 km (9,009.9 mi). \n" +
                        "This land area is only slightly smaller than the United States. China is thus the largest country in Asia and the fourth largest country in the world. \n" +
                        "More than half of all residents (63%) live within cities. China is divided into numerous geographical zones in its exceptionally large area. \n" +
                        "The average elevation is 1840 m above sea level. The highest mountain peak (Mount Everest) is at 8,848 meters. The country has about 5,000 partially \n" +
                        "uninhabited islands. There are direct national borders with the 15 neighboring countries Afghanistan, Bhutan, Myanmar, Hong Kong, India, Kazakhstan, \n" +
                        "North Korea, Kyrgyzstan, Laos, Macao, Mongolia, Pakistan, Russia, Tajikistan and Vietnam. The distance between New York City and the Capital Beijing \n" +
                        "is about 11,000 km (6,835 mi)."
            )
        )

        countries.add(
            Country(
                "Brazil",
                "143400000",
                "474.5 km^2",
                "https://naurok-test2.nyc3.digitaloceanspaces.com/uploads/test/2225640/1287696/204682_1644400839.png",
                "Brazil is a country on the Altantic Coast of South America. The land has a total area of 8,515,770 km² (three million mi²) and a total coastline of \n" +
                        "7,491 km (4,654.7 mi). This land area is only slightly larger than the Australia. In terms of area, Brazil is the third largest country in the Americas \n" +
                        "after Canada and the United States and the fifth largest in the world. An exceptionally high proportion of residents (87%) belongs to the urban population.\n" +
                        "Brazil is divided into numerous geographical zones in its exceptionally large area. The average elevation is 320 m above sea level. \n" +
                        "The highest mountain peak (Pico da Neblina) is at 2,994 meters. The country has about 60 islands. \n" +
                        "There are direct national borders with the ten neighboring countries Argentina, Bolivia, Colombia, French Guiana, Guyana, Paraguay, Peru, Suriname, \n" +
                        "Uruguay and Venezuela. The distance between New York City and the Capital Brasilia is about 6,840 km (4,250 mi)."
            )
        )

        countries.add(
            Country(
                "Australia",
                "143400000",
                "474.5 km^2",
                "https://www.ixpa-interim.com/wp-content/uploads/2022/09/australia-flag.png",
                "Australia is a country on the Australian continent as well as the Tasmanian island. The land has a total area of 7,741,220 km² \n" +
                        "(three million mi²) and a total coastline of 25,760 km (16,006.5 mi). This land area is equivalent to about 79% of the United States. \n" +
                        "Australia is thus the largest country on the Australian continent and the sixth largest country in the world. With 3.3 inhabitants per km² \n" +
                        "it is also the most sparsely populated country on the Australian continent. An exceptionally high proportion of residents (86%) belongs to the urban population.\n" +
                        "Australia is divided into numerous geographical zones in its exceptionally large area. The average elevation is 330 m above sea level. \n" +
                        "The highest mountain peak (Mount Kosciuszko) is at 2,228 meters. The country has 8,222 mostly uninhabited islands in the open sea. \n" +
                        "Australia has no direct neighbors. The distance between New York City and the Capital Canberra is about 16,250 km (10,097 mi)."
            )
        )

        countries.add(
            Country(
                "India",
                "143400000",
                "474.5 km^2",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/8c90dabd-7315-4b3a-b525-87b37df9dea7/dep7owd-ce5dbfd3-cb15-4805-a21e-917d6d68cf84.png/v1/fill/w_1095,h_730,strp/happy_75th_independence_day_india__by_brady2009_dep7owd-pre.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODU0IiwicGF0aCI6IlwvZlwvOGM5MGRhYmQtNzMxNS00YjNhLWI1MjUtODdiMzdkZjlkZWE3XC9kZXA3b3dkLWNlNWRiZmQzLWNiMTUtNDgwNS1hMjFlLTkxN2Q2ZDY4Y2Y4NC5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.qEHxBbMSosMfrQGja4iPtgSR-4cLBM3UdAP7SzIPwCo",
                "India is a country between the Indian Ocean and the Himalayas. The land has a total area of 3,287,259 km² (one million mi²) \n" +
                        "and a total coastline of 7,000 km (4,349.6 mi). This land area is approximately 473% of the area of Texas. In terms of area, \n" +
                        "India is the second largest country in Asia after China and the seventh largest country in the world. Most of the population (65%) \n" +
                        "resides within rural regions. India is divided into numerous geographical zones in its exceptionally large area. \n" +
                        "The average elevation is 621 m above sea level. The highest mountain peak (Kangchendzönga) is at 8,586 meters. \n" +
                        "The country has about 1,200 partially uninhabited islands. There are direct national borders with the eight neighboring countries \n" +
                        "Afghanistan, Bangladesh, Bhutan, Myanmar, China, Nepal, Pakistan and Sri Lanka. The distance between New York City and the Capital New Delhi\n" +
                        "is about 11,770 km (7,314 mi)."
            )
        )

        countries.add(
            Country(
                "Argentina",
                "143400000",
                "474.5 km^2",
                "https://www.pinclipart.com/picdir/big/197-1970607_icona-argentina-download-gratuito-png-e-vettoriale-clipart.png",
                "Argentina is a country in the southern half of South America on the Atlantic Ocean. The land has a total area of 2,780,400 km² (one million mi²) \n" +
                        "and a total coastline of 4,989 km (3,100.0 mi). This land area is approximately 400% of the area of Texas. \n" +
                        "Argentina is thus one of the largest countries in the Americas and the eighth biggest in the world. \n" +
                        "An exceptionally high proportion of residents (92%) belongs to the urban population. Argentina is divided into numerous geographical zones in its exceptionally \n" +
                        "large area. The average elevation is 595 m above sea level. The highest mountain peak (Aconcagua) is at 6,959 meters. \n" +
                        "The country has about 50 islands. There are direct national borders with the five neighboring countries Bolivia, Brazil, Chile, \n" +
                        "Paraguay and Uruguay. The distance between New York City and the Capital Buenos Aires is about 8,530 km (5,300 mi)."
            )
        )

        countries.add(
            Country(
                "Kazakhstan",
                "143400000",
                "474.5 km^2",
                "https://intersexrights.org/wp-content/uploads/2020/07/Kazakhstan-1000px.png",
                "Kazakhstan is a landlocked country east of the Caspian Sea on the border with Europe. \n" +
                        "The land has a total area of 2,724,902 km² (one million mi²). This land area is approximately 392% of the area of Texas. \n" +
                        "In terms of area, Kazakhstan is the third largest country in Asia after China and India and the ninth largest in the world. \n" +
                        "With 7.0 inhabitants per km² it is one of the most sparsely populated countries on earth. More than half of all residents (58%) live within cities. \n" +
                        "Every ninth resident lives in Almaty alone. Kazakhstan is comparatively low at an average elevation of 387 meters above sea level. \n" +
                        "The highest mountain peak (Khan Tängiri Shyngy) is at 7,010 meters. There is no access to the open sea. There are direct national \n" +
                        "borders with the five neighboring countries China, Kyrgyzstan, Russia, Turkmenistan and Uzbekistan. The distance between New York City \n" +
                        "and the Capital Nursultan is about 9,270 km (5,760 mi)."
            )
        )

        val rvAdapter = CountryAdapter(requireContext(), countries, object : CountryAdapter.MyInterface {
            override fun myOnClick(country: Country, img: ImageView) {
                val bundle = bundleOf("country" to country)
//                val extras = FragmentNavigatorExtras(img to "img_big")
                findNavController().navigate(R.id.action_countryFragment_to_detailFragment, bundle)
            }
        })

        val touchHelper = object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                rvAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                rvAdapter.onItemDismiss(viewHolder.adapterPosition)
            }

        }

        val itemTouchHelper = ItemTouchHelper(touchHelper)
        itemTouchHelper.attachToRecyclerView(binding.rv)
        binding.rv.adapter = rvAdapter

        return binding.root
    }
}