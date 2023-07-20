package com.rafiansyahdesign.calsanicchatbot.mbti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rafiansyahdesign.calsanicchatbot.MainActivity;
import com.rafiansyahdesign.calsanicchatbot.R;

public class ResultActivity extends AppCompatActivity {

    TextView txtPersonality,txtCareers;
    Button btnReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);
        txtPersonality=(TextView)findViewById(R.id.textResult);
        txtCareers=(TextView)findViewById(R.id.textCareer);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int scoreM = sharedPref.getInt("scoreM", 0);
        int scoreE = sharedPref.getInt("scoreE", 0);
        int scoreN = sharedPref.getInt("scoreN", 0);
        int scoreT = sharedPref.getInt("scoreT", 0);
        String personalityType=testMind(scoreM)+testEnergy(scoreE)+testNature(scoreN)+testTactics(scoreT);
        txtPersonality.setText( personalityType+personalityName(personalityType));
        txtCareers.setText("Karakter Kamu:"+personalityCareer(personalityType));

        btnReturnHome = (Button) findViewById(R.id.btnReturn);

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ResultActivity.this, MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

    }

    public String testMind(int mind)
    {
        int compare = 0;
        if(mind > compare)
        { return "I"; }
        else
        { return "E"; }
    }
    public String testEnergy(int energy)
    {
        int compare = 0;
        if(energy > compare)
        { return "S"; }
        else
        { return "N"; }
    }

    public String testNature(int nature)
    {
        int compare = 0;
        if(nature > compare)
        { return "F"; }
        else
        { return "T"; }
    }
    public String testTactics(int tactics)
    {
        int compare = 0;
        if(tactics > compare)
        { return "P"; }
        else
        { return "J"; }
    }

    public String personalityName(String ptype)
    {
        switch(ptype) {
            case "ISTJ": return "-The Inspector";

            case "ISTP": return "-The Crafter";

            case "ISFJ": return "-The Protector";

            case "ISFP": return "-The Artist";

            case "INFJ": return "-The Advocate";

            case "INFP": return "-The Mediator";

            case "INTJ": return "-The Architect";

            case "INTP": return "-The Thinker";

            case "ESTP": return "-The Persuader";

            case "ESTJ": return "-The Director";

            case "ESFP": return "-The Performer";

            case "ESFJ": return "-The Caregiver";

            case "ENFP": return "-The Champion";

            case "ENFJ": return " - The Giver";

            case "ENTP": return "-The Debater";

            default: return "-The Commander";
        }
    }

    public String personalityCareer(String ptype)
    {
        switch(ptype) {
            case "ISTJ": return "\n" + "\n" + "ISTJ berkarakter tenang, serius, teliti, tekun, handal, realistis, praktis, dan logis. Orientasinya pada tanggung jawab dan fakta, mengedepankan logika saat memutuskan sesuatu. Ia menyukai pekerjaan dan kehidupan yang tertib dan teratur. Tak heran bila sosok ini loyal dan memegang teguh tradisi.\n";

            case "ISTP": return "\n" + "\n" + "Tipe kepribadian MBTI ini berkarakter toleran dan fleksibel. Ketenangannya dalam menganalisis membuatnya mampu bertindak cepat menemukan solusi. Berminat pada hubungan sebab-akibat, ISTP dapat mengolah fakta secara efisien dan logis.";

            case "ISFJ": return "\n" + "\n" + "ISFJ itu tenang, teliti, bertanggungjawab, berkomitmen, telaten, cermat, baik hati, loyal, dan perhatian. Sesuatu yang penting akan diingatnya secara spesifik. Kepribadian MBTI ini menyukai ketertiban di tempat tinggal maupun tempat kerja.";

            case "ISFP": return "\n" + "\n" + "Kepribadian MBTI ISFP adalah sosok yang tenang, sensitif, dan baik hati. Mereka membutuhkan ruang sendiri, bekerja sesuai dengan waktunya sendiri, hadir dan menikmati masa kini. Mereka berkomitmen pada orang atau prinsip yang penting bagi dirinya. Karena tak menyukai perselisihan atau konflik, ISFP takkan memaksakan pendapat atau prinsipnya.\n";

            case "INFJ": return "\n" + "\n" + "INFJ adalah si pencari makna. Ia tertarik untuk memahami pemikiran orang lain, hubungan antar ide, bahkan hubungan sosial. Punya komitmen tinggi dalam bekerja, tipe kepribadian MBTI ini ingin melayani orang-orang di sekitarnya sebaik mungkin.";

            case "INFP": return "\n" + "\n" + "INFP adalah seseorang yang idealis, teguh memegang prinsip, dan setia terutama pada orang-orang penting dalam hidupnya. Tipe kepribadian MBTI ini memiliki rasa ingin tahu yang tinggi, terbuka dengan berbagai kemungkinan. Ia adalah sosok yang fleksibel dan adaptif, kecuali pada prinsip yang dipegangnya.\n";

            case "INTJ": return "\n" + "\n" + "INTJ adalah orang-orang yang dapat dengan cepat memahami pola atas suatu peristiwa yang tengah terjadi, kemudian menyusun perspektif dalam jangka panjang. Mereka mandiri, terorganisir, serta memiliki standar kompetensi dan kinerja yang tinggi untuk diri sendiri dan orang lain.";

            case "INTP": return "\n" + "\n" + "Tipe kepribadian MBTI ini lebih tertarik dengan ide ketimbang interaksi sosial. Mereka adalah orang-orang yang teoretis dan abstrak, dengan tampilan yang cerdas dan tenang. Jika memiliki minat, mereka mampu fokus mendalami suatu masalah sampai menemukan solusi.";

            case "ESTP": return "\n" + "\n" + "Kepribadian MBTI ESTP adalah sosok yang fleksibel dan toleran, suka menjalin berkomunikasi aktif. Bagi ESTP, teori itu membosankan. Justru mereka belajar dengan baik saat harus melakukan sesuatu secara langsung.";

            case "ESTJ": return "\n" + "\n" + "ESTJ adalah tipe yang praktis, realistis, berorientasi fakta, dan tegas. Ia tahu bagaimana mengatur pekerjaan secara efisien agar diperoleh hasil terbaik. Standar logika yang dimiliki ESTJ membantunya membuat keputusan dengan cepat, hingga terkadang memaksakan rencananya.";

            case "ESFP": return "\n" + "\n" + "Tipe kepribadian MBTI ini adalah sosok yang ramah, bersahat, fleksibel, adaptif, spontan, mencintai kehidupannya sendiri dan orang lain. Ia suka belajar dan bekerja bersama orang lain dengan pendekatan yang logis dan realistis.\n";

            case "ESFJ": return "\n" + "\n" + "ESFJ adalah karakter yang suka bekerja sama dalam lingkungan yang harmonis. Mereka mampu memahami kebutuhan orang lain berusahan memenuhinya. Kepribadian MBTI ESFJ ingin dihargai sebagai pribadi dan atas apa yang telah dikerjakannya.";

            case "ENFP": return "\n" + "\n" + "ENFP juga berkarakter hangat. Ia adalah sosok yang imajinatif dengan antusiasme tinggi. Kemampuannya dalam memahami pola dan hubungan suatu informasi dengan kejadian tertentu membuat ENFP percaya diri dalam melakukan sesuatu. Tipe kepribadian MBTI ini suportif, fleksibel, spontan, dan fasih berbicara.";

            case "ENFJ": return "\n" + "\n" + "ENFJ adalah sosok yang hangat, berempati tinggi, dan pendengar yang baik. Tipe kepribadian MBTI ini senang bergaul, suka memudahkan urusan dan mendorong orang lain mencapai potensinya. Ia mampu menerima kritik dan pujian dengan baik.";

            case "ENTP": return "\n" + "\n" + "Sisi ekstrovert kepribadian MBTI ini menjadikannya sosok yang blak-blakan. Mereka tak ragu bila harus memecahkan masalah dengan cara-cara yang menantang, namun sekaligus strategis. Tipe ENTP menyukai kegiatan-kegiatan yang menarik dan mudah merasa jenuh dengan rutinitas.";

            default: return "\n" + "\n" + "Berkat pengetahuannya yang luas, ENTJ adalah pembaca keadaan yang baik. Ia peka dalam memilah prosedur atau kebijakan yang kurang efisien, bahkan mampu mengembangkan sistem guna mengatasi persoalan dalam organisasi. Tipe kepribadian MBTI ini tak segan memaksakan idenya.";
        }
    }
}