Aufgabe:
Web Anwendung soll Anfragen GET, POST, DELETE, PUT verarbeite.

Web Anwendung funktioniert immer gleich:
1) Frond-end aktiviert Backend
2) Backend aktiviert DB und beinhaltet Geschäftslogic
3) Überagung von Back-end nach Frondend

Backend:
1) ist mit dem Internet verbunden
2) Haputaufgabe ist die Verabreitung von Anfragen eines Clients

Web Server:
1) Ist etwas das auf HTTP Anfragen antwortet und Daten zurückgibt.
2) z.B. statische Website auf GET wird eine HTML zurück gegeben.

Database:
1) Wichtigeste Aufgabe von Backend
2) Persists Data: bestehende Daten

Webserver + Database:
1) sind auf verschiedenen Computer
2) Trennen um möglichst viel Leistung für Anwendung zu haben

Frontend:
1) alles was bei Client(Browser, Phone) ausgeführt wird
2) Frontend mach request an Backend und Backend kommuniziert mit Database

Ablauf Antwort:
1) Backend gibt Daten zurück
2) Browser/Client generiert aus Datan html usw.

Weiteres:
1) Webserver und Databse sind zwei verschiedene Dinge

Background Prozesse und Zwischenspeiher/cache:
1) Backgroudn Prozesse: mehrere klicks werden verarbeitet
2) Zwischenspeichern z.B. Anfragen von Database um Zeit zu sparen, es muss keine neue Anfrage gestartet werden.



![grafik](https://user-images.githubusercontent.com/75083505/110251381-788d4e00-7f80-11eb-9e7a-5a88696e4131.png)


![grafik](https://user-images.githubusercontent.com/75083505/110251508-0832fc80-7f81-11eb-8920-2beda8f6ff1e.png)
