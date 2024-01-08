package com.hasanbilgin.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasanbilgin.composeintro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            //ComposeIntroTheme temz oluşturmuş
//            ComposeIntroTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }

//            //aslında alttakiler parametere lamda için böle yazılıyor
//            Greeting(name = "Android")
//            //::textTunctionLambda()  referans verimesimiş
//            //MainActivity.textfunctionLambda düşünebiliriz
//            //testFunction(5,::textfunctionLambda) // yada aynıdır
//            //alttkini lambda ile kullanabilmek için metot parametere sonra parametre olmak zorundadır
//            testFunction(5){
//                textfunctionLambda()
//            }
//            //setContent aynı mevzu var


//            Greeting(name = "Android")
            MainScreen()
        }

    }

    //birinci paramtere int, ikinci metoddut parametere yok döndürmesiz
    fun testFunction(int: Int, myFunction: () -> Unit) {
        //invoke çalıştır demek
        myFunction.invoke()
    }

    fun textfunctionLambda() {
        println("test")
    }
}

////https://developer.android.com/jetpack/compose/layouts/basics
//@Composable
//fun Greeting(name: String) {
////    Text(text = "Hello $name!",color= Color.Gray)
////    Text(text = "Hello $name!",color= MaterialTheme.colorScheme.onSurface)
//    Text(text = "Hello $name!", color = Color.Blue, fontSize = 22.sp, fontWeight = FontWeight.Bold)
//}

@Composable
fun MainScreen() {
//    //Column,Row,Box
//    //Column içindekileri satır satır dizdi üst ve sağ tarftan başlatır
//    //Column LinearLayout Vertical - Row ise LinearLayout Horizontal diye düşünebiliriz
//    //Box ise Edittexe yazarken altta adınızı yazın çıkması gibi
//    Column() {
//        //modifier composable modifiye için
//        //Modifier.background(Color.Black) arka plan rengi
//        //.padding(5.dp) verilebilir
//        //.clickeable // tıklandığında yapılcaklar yazılabilir
//        //width // height genişlik yükseklikverilebilir
//        //size de mevcut sizeIn de mevcut
//        ///*.width(100.dp).height(100.dp)*
//        //size(width = 100.dp, height = 100.dp)
//        //fillMaxSize //doldurabildiğin kadar doldur herikisi içinde //kaln kısmın %50 2.side kalan kısmın %50 gibi
//        //fillMaxHeight //doldurabildiğin kadar doldur height yükselik yani
//        //fillMaxWidth //doldurabildiğin kadar doldur widht genişlik
//        //fillMaxWidth().fillMaxHeight() genişliği ve yükseliği tam doldurduğu gittiği yere kadar match.parent gibi / default 1 dir //0.5te %50sini doldurur
//        Text(modifier = Modifier
//            .background(Color.Black)
//            .padding(top = 10.dp, start = 1.dp, end = 1.dp, bottom = 30.dp)
//            .clickable {
//                println("hello android clicked")
//            }.fillMaxSize(0.5f)
//             , text = "Hello Android!", color = Color.Blue, fontSize = 22.sp, fontWeight = FontWeight.Bold)
//        Text(text = "Hello World!", color = Color.Blue, fontSize = 22.sp, fontWeight = FontWeight.Bold)

    //modifier = Modifier.fillMaxSize() artık telefon görünümü çıkmaya başladı
    //Arrangement.SpaceAround aralarında boşluk bırakarak koydu(aralardakiler eşit)
    //Arrangement.SpaceBetween en üstün üstüne ve en altındakinin altına hariç boşluk koydu
    //Arrangement.SpaceEvenly bütün boşluklar eşit oldu
    //Arrangement //layoutta gibi ayarlar
    //Alignment //kendisini ayarlar(yazı)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        CustomText(text = "Hello Android")
        //Spacer boşluk demektir 5dplik koyduk
        Spacer(modifier = Modifier.padding(5.dp))
        CustomText(text = "Hello Wordl")
        Spacer(modifier = Modifier.padding(5.dp))
        CustomText(text = "Hello Kotlin")
        Spacer(modifier = Modifier.padding(5.dp))
        //modifier = Modifier.fillMaxSize() row da yukarı ittiği için centeri patlattı
        Row(/*modifier = Modifier.fillMaxSize(),*/horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            CustomText(text = "text1")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "text2")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "text3")

        }

    }


}

@Composable
fun CustomText(text: String) {
    //textAlign = TextAlign.Center  textin kendi içinde ortaya getirik
    //clickableilk başa getir diyor
    Text(modifier = Modifier
        .clickable {
            println("hello android clicked")
        }
        .background(Color.Black)
        .padding(top = 10.dp, start = 1.dp, end = 1.dp, bottom = 30.dp)
        /*.fillMaxSize(0.5f)*/
        /* .width(100.dp)*/, text = text, color = Color.Blue, fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

}

//Preview altında ne yazarsa splitte o görülür
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

//    Greeting("Android")
    MainScreen()
}

/*jetpack Compose
farklı şekilde kullanıcı ara yüzü oluşturma v tüm bu işlemleri native yapma fırsatı tanıyan
-xml yoktur
-api 23 en düşüktür
-sadece kotlinde vardır

 */