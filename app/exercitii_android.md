# Exerciții de scris cod, în stilul seminarelor

Alege un obiect din realitate **diferit de autobuz**, de exemplu Carte, Telefon, Restaurant sau Film. Mai jos, „clasa ta” înseamnă acest obiect nou.

## Exercițiul 1 (stil laborator 3: ciclu de viață, Intent, Bundle)

1. Creați o aplicație în Android Studio cu o activitate Empty Views, în Java, cu API 24.
2. Implementați metodele de ciclu de viață `onStart()`, `onResume()`, `onPause()`, `onStop()` și `onDestroy()`.
3. În fiecare metodă salvați câte un log de tipul `Log.e()`, `Log.w()`, `Log.d()`, `Log.i()` și `Log.v()`, fiecare cu un tag și un mesaj diferit.
4. Filtrați și căutați logurile în tab-ul Logcat, după nivel și după tag.
5. Adăugați o a doua activitate. Setați din AndroidManifest ca aceasta să fie lansată la deschiderea aplicației.
6. Adăugați o a treia activitate.
7. În cea de-a doua activitate adăugați un `Button`. La apăsare se deschide a treia activitate printr-un `Intent`.
8. La deschidere trimiteți un mesaj și trei valori de tip întreg printr-un `Bundle`.
9. În a treia activitate preluați informațiile și afișați-le într-un `Toast`.
10. În a treia activitate adăugați un buton care trimite către activitatea precedentă alt mesaj și **produsul** celor trei valori.
11. În a doua activitate afișați mesajul primit și valoarea calculată într-un `TextView`.

## Exercițiul 2 (stil laborator 4: formular și clasă)

1. Creați o aplicație cu o activitate Empty Views, în Java, API 24.
2. Creați o clasă pentru un obiect din realitate care conține inițialele numelui vostru. Obiectul are **6 atribute**, de tipuri diferite: două `String`, un `int`, un `float`, un `boolean` și o dată calendaristică sau un alt `String`.
3. Adăugați o activitate pentru preluarea datelor de creare a obiectelor. Activitatea conține câte un view pentru fiecare atribut, printre care: `TextView`, `EditText` (unul doar cu cifre, altul cu text), `Button`, `CheckBox`, `RadioButton` (într-un `RadioGroup`), `Spinner`, `RatingBar` și `Switch`. Câmpurile obligatorii sunt validate cu `setError`.
4. Activitatea de adăugare se deschide din prima printr-un buton. Datele introduse creează o instanță, care se întoarce în prima activitate printr-un `Bundle`.
5. Instanța primită se afișează într-un `TextView` și într-un `Toast`.
6. Butoanele din ambele activități **nu** folosesc `android:onClick` în XML: legați-le în cod cu `findViewById` și `setOnClickListener`.

## Exercițiul 3 (stil laborator 5: listă)

1. Obiectul întors de activitatea de adăugare se adaugă într-un `ArrayList` ținut în prima activitate.
2. Adăugați o a treia activitate care conține un `ListView` și afișează toate obiectele din listă. În clasa ta implementați `toString()`, iar în `ListView` obiectele se afișează prin această metodă, cu un `ArrayAdapter`.
3. Când utilizatorul selectează un obiect din `ListView`, acesta este afișat într-un `Toast`.
4. La `LongItemClick` pe un obiect, acesta este șters din `ListView` și din lista de obiecte.
5. Ștergerea trebuie să se vadă și în prima activitate: după ce te întorci din listă și o redeschizi, obiectul șters nu mai apare.

## Exercițiul 4 (stil laborator 6: adapter și modificare)

1. Folosiți proiectul de la exercițiul 3.
2. Modificați afișarea în `ListView` folosind un **Adapter personalizat** (`BaseAdapter`) și un layout propriu pentru un rând, care afișează cel puțin patru atribute ale obiectului. Cel puțin un atribut trebuie afișat altfel decât printr-un simplu `TextView`, de exemplu un `CheckBox` sau un `RatingBar`.
3. Modificați metoda abonată la `ItemClick`, astfel încât să se deschidă activitatea de completare date pentru **modificarea** obiectului selectat. La deschidere, **toate** câmpurile (inclusiv `Spinner`, `RadioButton`, `RatingBar` și `Switch`) sunt completate cu informațiile obiectului. La salvare, obiectul selectat este modificat. Atenție: nu adăugați alt obiect.
4. Pentru trimiterea obiectelor între activități folosiți `Parcelable`. Lista se trimite cu `putParcelableArrayList`.
5. Același formular servește și pentru adăugare, și pentru modificare. Activitatea decide în ce mod funcționează după cum a fost deschisă.

## Exercițiul 5 (variantă de dificultate mai mare, opțional)

1. Adăugați în prima activitate un buton „Sortează”. La apăsare, lista de obiecte este sortată după un atribut ales de voi (de exemplu preț sau rating), iar `ListView` se actualizează.
2. Adăugați un câmp de căutare (`EditText`) în a treia activitate. Pe măsură ce utilizatorul scrie, în `ListView` rămân doar obiectele care conțin textul respectiv.
3. Salvați lista de obiecte între porniri, în `SharedPreferences` sau într-un fișier. La repornirea aplicației lista e încărcată.
