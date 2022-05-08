# cnplisv1.0



## Librerias

Las librerias utilizadas para este proyecto se encuentran especificadas en el archivo gradel(app)

Para utilizar un patron de diseño MVVM
```
// ViewModel
androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
"androidx.activity:activity-ktx:1.4.0"
```

Para la injecion de dependencias
```
// Dagger hilt
     "com.google.dagger:hilt-android:2.41"
     "com.google.dagger:hilt-android-compiler:2.41"
```

Como complemento de funcionces con dagger
```
// Multidex
    'androidx.multidex:multidex:2.0.1'
```
Para el consumo de servicios

```
// Retrofit
     'com.squareup.retrofit2:retrofit:2.9.0'
```

Como complementos de retrofit y para modelado de respuestas
```
// Gson converter
     'com.squareup.retrofit2:converter-gson:2.9.0'
     'com.squareup.okhttp3:logging-interceptor:4.9.0'
```

Para el manejo de imagenes desde una Url
```
//Glide
    implementation 'com.github.bumptech.glide:glide:3.7.0'
```