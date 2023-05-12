package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val personalities = createPersonalityList()

        val adapter = PersonalityAdapter(personalities)
        recyclerView.adapter = adapter
    }

    private fun createPersonalityList(): List<Personality> {
        // Здесь создаем список "личностей"
        val personalities = mutableListOf<Personality>()

        // Личности
        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_15,
                "Зи́гмунд Фрейд",
                " 6 мая 1856 - 23 сентября 1939",
                "Австрийский психолог, психоаналитик, психиатр и невролог.",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_19,
                "Галиле́о Галиле́й",
                "15 февраля 1564 -  8 января 1642",
                "итальянский физик, механик, астроном, философ, математик, оказавший значительное влияние на науку своего времени.",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_18,
                "Микела́нджело Буонарро́ти",
                "6 марта 1475 - 18 февраля 1564",
                "итальянский скульптор, художник, архитектор, поэт и мыслитель. Один из крупнейших мастеров эпохи Высокого Возрождения и раннего барокко — именно его считают подлинным «отцом барокко» в архитектуре.",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_13,
                "Пётр I Алексе́евич",
                "6 марта 1475 - 18 февраля 1564",
                "прозванный Вели́ким  — последний царь всея Руси и первый Император Всероссийский. Представитель династии Романовых",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_10,
                "Ма́о Цзэду́н,",
                "26 декабря 1893 – 9 сентября 1976",
                "также известный как Председа́тель Ма́о – китайский коммунистический революционер, основатель Китайской Народной Республики, которую он возглавлял в качестве председателя Китайской коммунистической партии с момента создания Китайской Народной Республики в 1949 году до своей смерти в 1976 году",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_08,
                "Чарлз Ро́берт Да́рвин",
                "12 февраля 1809 - 19 апреля 1882",
                " английский натуралист и путешественник, одним из первых пришедший к выводу и обосновавший идею о том, что все виды живых организмов эволюционируют со временем и происходят от общих предков. ",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_44_06,
                "Карл Ге́нрих Маркс",
                "5 мая 1818 - 14 марта 1883",
                "немецкий философ, социолог, экономист, писатель, поэт, политический журналист, лингвист, общественный деятель, историк. Наиболее известными его трудами являются «Манифест Коммунистической партии» и «Капитал. Критика политической экономии».",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.photo_2023_05_12_02_43_59,
                "́дам Смит",
                "5 июня 1723 -  17 июля 1790",
                "шотландский экономист и философ-этик, один из основоположников экономической теории как науки. Считается основателем классической политэкономии.",
                "Мужской"
            )
        )

        personalities.add(
            Personality(
                R.drawable.napoleon,
                "́Наполео́н I Бонапа́рт",
                "15 августа 1769 - 5 мая 1821",
                "Император французов в 1804—1814 и 1815 годах, полководец и государственный деятель, заложивший основы современного французского государства, один из наиболее выдающихся деятелей в истории Запада.",
                "Мужской"
            )
        )

        return personalities
    }
}

class PersonalityAdapter(private val personalities: List<Personality>) :
    RecyclerView.Adapter<PersonalityAdapter.PersonalityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalityViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.personality_item_layout, parent, false)
        return PersonalityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonalityViewHolder, position: Int) {
        val personality = personalities[position]
        holder.bind(personality)
    }

    override fun getItemCount(): Int {
        return personalities.size
    }

    inner class PersonalityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
        private val fullNameTextView: TextView = itemView.findViewById(R.id.fullNameTextView)
        private val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)

        fun bind(personality: Personality) {
            // Установка значений в элементы списка
            avatarImageView.setImageResource(personality.avatarResourceId)
            fullNameTextView.text = personality.fullName
            yearTextView.text = personality.yearsOfLife
            descriptionTextView.text = personality.description
            genderTextView.text = personality.gender

            itemView.setOnClickListener {
                val message = "Нажата карточка: ${personality.fullName}"
                showSnackbar(message)
            }

            // Обработчик нажатия на "лайк"
            val likeButton = itemView.findViewById<Button>(R.id.likeButton)
            likeButton.setOnClickListener {
                val message = "Нажат лайк: ${personality.fullName}"
                showSnackbar(message)
            }
        }

        private fun showSnackbar(message: String) {
            Snackbar.make(itemView, message, Snackbar.LENGTH_SHORT).show()
        }
    }
}

data class Personality(
    val avatarResourceId: Int,
    val fullName: String,
    val yearsOfLife: String,
    val description: String,
    val gender: String
)