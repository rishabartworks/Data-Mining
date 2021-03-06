package benutzerSchnittstelle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menuleiste extends JMenuBar {

	public Menuleiste(final Gui oberflaeche) {
		JMenu datei = new JMenu("Datei");
		JMenu tabelle = new JMenu("Tabelle");
		
		// Menuepunkt Datei befuellen
		// Hinzufuegen der Auswahl 'neu' mit Tastenkuerzel Strg+n
		JMenuItem neu = new JMenuItem("Neu");
		neu.setAccelerator(KeyStroke.getKeyStroke("control N"));
		neu.addActionListener(new ereignislistener.Neu());
		datei.add(neu);
		
		// Hinzufuegen der Auswahl 'oeffnen' mit Tastenkuerzel Strg+o
		JMenuItem oeffnen = new JMenuItem("Oeffnen");
		oeffnen.setAccelerator(KeyStroke.getKeyStroke("control O"));
		oeffnen.addActionListener(new ereignislistener.Oeffnen(oberflaeche));
		datei.add(oeffnen);
		
		// Hinzufuegen der Auswahl 'speichern' mit Tastenkuerzel Strg+s
		JMenuItem speichern = new JMenuItem("Speichern");
		speichern.setAccelerator(KeyStroke.getKeyStroke("control S"));
		speichern.addActionListener(new ereignislistener.Speichern(oberflaeche));
		datei.add(speichern);
		
		// Hinzufügen eines Seperators zur optischen Trennung
		datei.addSeparator();
				
		// Hinzufuegen der Auswahl 'beenden'
		JMenuItem beenden = new JMenuItem("Beenden");
		// Listener zum Beenden der Anwendung aus dem Package "ereignisListener" registrieren
		beenden.addActionListener(new ereignislistener.Beenden()); 
		datei.add(beenden);
		
		// Menuepunkt Tabelle befuellen
		// Hinzufügen der Auswahl 'neu'
		JMenuItem tabelleneu = new JMenuItem("Neu ...");
		tabelleneu.setAccelerator(KeyStroke.getKeyStroke("alt N"));
		tabelleneu.addActionListener(new ereignislistener.NeueTabelle(oberflaeche));
		tabelle.add(tabelleneu);
		
		// Hinzufuegen der Auswahl 'hinzufuegen'
		JMenu hinzufuegen = new JMenu("Hinzufuegen");
		// Hinzufuegen der Auswahl 'spalte'
		JMenuItem spalteeinfuegenEnde = new JMenuItem("Spalte");
		spalteeinfuegenEnde.setAccelerator(KeyStroke.getKeyStroke("alt S"));
		spalteeinfuegenEnde.addActionListener(new ereignislistener.Hinzufuegen(oberflaeche));
		hinzufuegen.add(spalteeinfuegenEnde);
		// Hinzufuegen der Auswahl 'zeile'
		JMenuItem zeileeinfuegenEnde = new JMenuItem("Zeile");
		zeileeinfuegenEnde.setAccelerator(KeyStroke.getKeyStroke("alt Z"));
		zeileeinfuegenEnde.addActionListener(new ereignislistener.Hinzufuegen(oberflaeche));
		hinzufuegen.add(zeileeinfuegenEnde);
		tabelle.add(hinzufuegen);
		
		// Hinzufuegen der Auswahl 'einfuegen'
		JMenu einfuegen = new JMenu("Einfuegen");
		// Hinzufuegen der Auswahl "Spalte"
		JMenuItem spalteeinfuegen = new JMenuItem("Spalte");
		spalteeinfuegen.setAccelerator(KeyStroke.getKeyStroke("alt V"));
		spalteeinfuegen.addActionListener(new ereignislistener.Einfuegen(oberflaeche));
		einfuegen.add(spalteeinfuegen);
		// Hinzufuegen der Auswahl "Zeile"
		JMenuItem zeileeinfuegen = new JMenuItem("Zeile");
		zeileeinfuegen.setAccelerator(KeyStroke.getKeyStroke("alt C"));
		zeileeinfuegen.addActionListener(new ereignislistener.Einfuegen(oberflaeche));
		einfuegen.add(zeileeinfuegen);
		tabelle.add(einfuegen);
		
		// Hinzufuegen der Auswahl 'löschen'
		JMenu loeschen = new JMenu("Loeschen");
		// Hinzufuegen der Auswahl 'tabelle'
		JMenuItem tabelleloeschen = new JMenuItem("Tabelle");
		tabelleloeschen.setAccelerator(KeyStroke.getKeyStroke("alt R"));
		tabelleloeschen.addActionListener(new ereignislistener.Loeschen(oberflaeche));
		loeschen.add(tabelleloeschen);
		// Hinzufuegen der Auswahl 'spalte'
		JMenuItem spalteloeschen = new JMenuItem("Spalte");
		spalteloeschen.setAccelerator(KeyStroke.getKeyStroke("alt Q"));
		spalteloeschen.addActionListener(new ereignislistener.Loeschen(oberflaeche));
		loeschen.add(spalteloeschen);
		// Hinzufuegen der Auswahl Spalte löschen
		JMenuItem zeileloeschen = new JMenuItem("Zeile");
		zeileloeschen.setAccelerator(KeyStroke.getKeyStroke("alt W"));
		zeileloeschen.addActionListener(new ereignislistener.Loeschen(oberflaeche));
		loeschen.add(zeileloeschen);
		tabelle.add(loeschen);
		
		// Hinzufuegen der Auswahl 'importieren' mit Tastenkuerzel Strg+e
		JMenuItem importieren = new JMenuItem("Importieren");
		importieren.setAccelerator(KeyStroke.getKeyStroke("alt I"));
		importieren.addActionListener(new ereignislistener.Importieren(oberflaeche));
		tabelle.add(importieren);
		
		// Hinzufuegen der Auswahl 'exportieren' mit Tastenkuerzel Strg+e
		JMenuItem exportieren = new JMenuItem("Exportieren");
		exportieren.setAccelerator(KeyStroke.getKeyStroke("alt E"));
		exportieren.addActionListener(new ereignislistener.Exportieren(oberflaeche));
		tabelle.add(exportieren);
		
		// Hinzufuegen der Auswahl 'als Zielattribut festlegen'
		JMenuItem zielattribut = new JMenuItem("Als Zielattribut festlegen");
		zielattribut.setAccelerator(KeyStroke.getKeyStroke("alt A"));
		zielattribut.addActionListener(new ereignislistener.SpalteFaerben(oberflaeche));
		tabelle.add(zielattribut);
		
		// Den Menuepunkt 'Datei' der Menueleiste hinzufuegen
		add(datei);
		add(tabelle);
	}
	
}
