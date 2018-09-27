package com.jornadatecnologia.memoization;

import java.io.IOException;
import java.util.logging.Logger;

import com.jornadatecnologia.file.FatorialFileReader;
import com.jornadatecnologia.file.FatorialFileReaderFactory;


/**
 * Classe para demonstrar o uso dos métodos de leitura diferentes
 * @author udesc
 *
 */
public class App {
	private static final String SEQUENTIAL_FILE = "resource/sfatorial.csv";
	private static final String RANDOM_FILE = "resource/sfatorial2.csv";
	
	private static final String FILE = RANDOM_FILE;	
	
	private static final Logger LOG = Logger.getLogger(App.class.getCanonicalName());
	
	// número para o qual será calculado fatorial
	private static final int    KEY = 20;
	
	/**
	 * Inicia o programa realizando as leituras
	 * @param args
	 */
	public static void main(String args[]) {
		App.readAll();
	}
	
	/**
	 * Aplica todas técnicas de leitura
	 */
	static void readAll() {
		/*
		 * Técnicas de leitura que serão validadas
		 */
		FatorialFileReader io[]  = { FatorialFileReaderFactory.createBasicIO(),
		                             FatorialFileReaderFactory.createBasicNIO(),
		                             FatorialFileReaderFactory.createBasicLIO(),
		                             FatorialFileReaderFactory.createRandonIO()};
		
		for (FatorialFileReader fatorialFileReader : io) {
			App.read(fatorialFileReader);
			System.out.println("s("+  fatorialFileReader.getKey() + ")! = " + fatorialFileReader.getValue());
		}
	}

	/**
	 * Chama o método de leitura de cada arquivo
	 * @param io
	 */
	static void read(FatorialFileReader io) {
		LOG.info("started");
		try {
			io.reader(FILE,KEY);
		} catch (IOException e) {
			LOG.severe(e.getLocalizedMessage());
		}
		LOG.info("finished");
	}
}
