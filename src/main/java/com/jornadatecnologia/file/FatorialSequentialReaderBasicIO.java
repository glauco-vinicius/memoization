package com.jornadatecnologia.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * Leitura simples estilo java b�sico
 * @author udesc
 *
 */
class FatorialSequentialReaderBasicIO extends FatorialFileReader {
	private static final Logger LOG = Logger.getLogger(FatorialSequentialReaderBasicIO.class.getCanonicalName());

	 /**
	  * Realiza a leitura usando as classes do JAVA IO
	  */
	@Override
	public void reader(String nome, int key) throws IOException {
		File       arq  = new File( nome );
		FileReader read = new FileReader(arq);
		BufferedReader lerArq = new BufferedReader(read);
		super.setKey(key);
		readLine(lerArq);
		read.close();

	}

	private void readLine(BufferedReader lerArq) throws IOException {
		String linha = lerArq.readLine();
		byte[] b = linha.getBytes("UTF-8");
		LOG.info("Quantidade de bytes na linha -> "+ b.length);
		while (linha != null) {
			this.add( linha );
			linha = lerArq.readLine();
		}
	}
	
	private void add(String linha) {
		String[] value = linha.split(SEPARATOR);
		Integer key = Integer.parseInt(value[KEY_INDEX]);
		BigInteger data = new BigInteger(value[DATA_INDEX].trim());
		conteudo.put(key, data);
		if( key.equals(super.getKey())) {
			super.setValue( data );
		}
	}
}
