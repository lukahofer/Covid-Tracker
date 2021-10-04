# Aufgabenstellung

## Inhalt Applikation:

Sie wollen der örtliche Gastronomie in der Kontaktverfolgung, engl. contact tracing, von Covid-19 Erkrankten helfen.
Dazu schreiben Sie ein lauffähiges Java-Programm ”CovidTracker”, das dabei unterstutzend wirken soll. Hierzu soll 
eine Person bei einem Besuch der Gastronomie ihren Namen, Telefonnummer und Verweildauer mit dem Programm abspeichern können. Die Person muss bereits bei ihrer Ankunft wissen, wann sie die Gastronomie wieder verlässt, um diesen
Zeitpunkt angeben zu können.
Wenn eine Person an Covid-19 erkrankt, sollen alle anderen Besucher, die zu der gleichen Zeit wie der/die Erkrankte in
der Gastronomie waren, ausgegeben werden.
Das Programm soll uber eine grafische Oberfläche (GUI) verfugen, die so klar gestaltet ist, dass auch nicht technikaffine Personen das Programm bedienen können.
Das Programm ist von jedem Studierenden individuell zu erstellen und hat folgende Anforderungen zu erfüllen:

## weitere Anforderungen:

* Alle Besucher sollen ihren Namen und Telefonnummer angeben. Zusätzlich sollen die genauen Zeitpunkte des Besuches gespeichert werden. Dazu wird das Datum und die Uhrzeit der Ankunft und des Verlassens angegeben. All diese
Angaben sollen uber eine gut bedienbare GUI eingegeben werden können und in einer internen Datenstruktur
gespeichert werden. Diese Funktion nennen wir Personenaufnahme.
* Zusätzlich soll eine Risikoermittlung implementiert werden. Ein Besucher, der positiv fur Covid-19 getestet wurde, 
soll uber die GUI seinen Namen und Telefonnummern angeben. Dann soll die dahinterliegende Datenstruktur nach
allen anderen Besuchern durchsucht werden, die zur gleichen Zeit in der Gastronomie waren. Anschließend sollen
diese anderen Personen mit Namen und Telefonnummer in der GUI ausgegeben werden. Auch hier soll die GUI gut
und leicht bedienbar sein.
* Achtung: Es gibt zwei Hauptfunktionalitäten des Programms: Die Personenaufnahme und die Risikoermittlung.
  Obwohl beide u.a. einen Namen und Telefonnummer als Eingabe erhalten, sollen sie klar getrennt als zwei unterschiedliche Funktionalit¨aten in der GUI dargestellt werden. 
* Achten Sie darauf, dass nur valide Eingaben getätigt werden können. Wenn eine fehlerhafte Eingabe erkannt wird,
  soll, mithilfe einer Exception, die GUI eine Fehlermeldung zeigen.
* Verwenden Sie zur Umsetzung der Anforderungen den MVC-Ansatz, der in P03 und P04 und T03 eingefuhrt wurde.
* Zusätzlich soll Ihr Programm mit Javadoc-Kommentaren versehen werden. Orientieren Sie sich hierzu an den
  Angaben in P03.
* Achten Sie auf einen gut lesbaren Quellcode, d.h. insbesondere strukturieren Sie ihren Code ubersichtlich und ¨
  verwenden Sie aussagekräftige Bezeichner.
