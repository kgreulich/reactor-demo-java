# Reactor Demo 

### Was ist Reactor?
* reaktive Open-Source Bibliothek, basierend auf der Reactive Streams-Spezifikation
* wird zum Erstellen von nicht-blockierenden, asynchronen und ereignisgesteuerten Anwendungen auf der JVM verwendet

### Was ist reaktive Programmierung?
 * Ansatz zum Erstellen von Systemen, die reactive, resilient und elastic sind
 * Verarbeitung von Datenströmen und Ereignissen auf nicht-blockierende Weise
 * **hohen Datenvolumen** oder wenn Reaktionsfähigkeit und **Skalierbarkeit** entscheidend sind (Webanwendungen oder verteilte Systeme)

### Wie funktioniert es in der Theorie?
 * Project Reactor implementiert die reactive streams-Spezifikation
 * definiert Schnittstellen, Methoden und Protokollen für die reaktive Programmierung
 * bietet Bausteinen wie **Flux** (repräsentiert einen Datenstrom mit mehreren Werten) und **Mono** (repräsentiert einen Datenstrom mit null oder einem Wert)
 * reaktive Datenströme kombinieren und manipulieren
 * umfangreichen Sammlung von Operatoren: transformiert, gefiltert, kombiniert, verarbeitet
 
### Hauptmerkmale
* **Nicht-blockierend und asynchron**: Ausführungsthread wird nicht blockiert, was eine effiziente Behandlung gleichzeitiger Anfragen und I/O-Operationen ermöglicht
* **Unterstützung für backpressure**: Mechanismus zur Steuerung des Datenflusses zwischen Publishern und Subscribern -> Konsumenten nicht überlasten
* **Fehlerbehandlung und Ausfallsicherheit**: Operatoren und Mechanismen zur reaktiven Behandlung von Fehlern und Ausfällen
* **Komposition und Transformation**: Vielzahl von Operatoren um komplexe Datenverarbeitungspipelines einfach auszudrücken

### Integration
 * gut mit anderen reaktiven Bibliotheken und Frameworks in der Java-Umgebung integrieren,
 * Spring Framework | Micronaut
 * erhebliche Beliebtheit und Akzeptanz in der Java-Community -> defacto Standard
 
### Links
* [Project Reactor Main Website](https://projectreactor.io/)
* [Documentation](https://projectreactor.io/docs)
* [Learn](https://projectreactor.io/learn)