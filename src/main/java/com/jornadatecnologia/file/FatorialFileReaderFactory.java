package com.jornadatecnologia.file;

public class FatorialFileReaderFactory {
	
	/**
	 * Impede a instancicaao j� que a classe � utilit�ria e possui apenas m�todos est�ticos
	 */
	private FatorialFileReaderFactory() {
		// do nothing
	}

	/**
	 * Retorna uma instancia de FatorialSequentialReaderBasicIO
	 * @return
	 */
	public static FatorialFileReader createBasicIO() {
		return new FatorialSequentialReaderBasicIO();
	}
	
	/**
	 * Retorna uma instancia de FatorialSequentialReaderBasicNIO
	 * @return
	 */
	public static FatorialFileReader createBasicNIO() {
		return new FatorialSequentialReaderBasicNIO();
	}

	/**
	 * Retorna uma instancia de FatorialSequentialReaderBasicNIOLambda
	 * @return
	 */
	public static FatorialFileReader createBasicLIO() {
		return new FatorialSequentialReaderBasicNIOLambda();
	}

	public static FatorialFileReader createRandonIO() {
		return  new FatorialRandomAccessReaderIO();
	}

}
