# TP1

## Question 1 : Où se trouve ce fichier ? Donnez son nom et son emplacement dans l'arborescence du projet.

Ce fichier se trouve dans [`/app/src/main/res/layout/activity_main.xml`](./app/src/main/res/layout/activity_main.xml).
Il se trouve dans le `res/layout` du projet.

## Question 2 : Qu'avez-vous modifié ?

```diff
 <TextView
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
-        android:text="Hello World!"
+        android:text="Coucou j'ai trouvé comment faire"
         app:layout_constraintBottom_toBottomOf="parent"
         app:layout_constraintEnd_toEndOf="parent"
         app:layout_constraintStart_toStartOf="parent"
         app:layout_constraintTop_toTopOf="parent" />
```

On peut modifier le composant `TextView` pour changer le texte affiché dans le layout XML.


## Question 3 : Qu'avez-vous modifié pour changer l'icône ?

On doit modifier ces deux propriétés sur `<application>` dans `AndroidManifest.xml` :

```
android:icon="@mipmap/ic_launcher"
android:roundIcon="@mipmap/ic_launcher_round"
```

## Question 4 : Est-ce nécessaire de cliquer sur le bouton valider pour afficher le texte saisi sur la seconde activité ? Pourquoi ?

Oui, car je donne le contenu de la `TextView` à l'`Intent` à la place du contenu de l'`EditText`.

```kotlin
val prochainBouton: Button = findViewById(R.id.nextButton)
prochainBouton.setOnClickListener {
  val intent = Intent(this@MainActivity, MainActivity2::class.java)
  intent.putExtra(EXTRA_TEXT, textView.text.toString())
  startActivity(intent)
}
```

## Question 5 : Le comportement de la question 4 vous semble-t-il normal ?

Oui.

## Question 6 : Comment faire pour ne pas afficher le nouveau texte sur la deuxième activité tant que le bouton valider n'a pas été cliqué ?

> Je viens de réaliser que j'ai probablement évité le bug qui devait être présent dans le TP...

cf. ma réponse à la question 4.
