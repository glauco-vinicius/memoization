package com.jornadatecnologia.file;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import 	java.util.List;
import java.util.Map;


/**
 * Leitura simplificada estilo NIO
 * @author udesc
 *
 */
class FatorialSequentialReaderBasicNIO extends FatorialFileReader {
	private Map<Integer, BigInteger> conteudo = new HashMap<Integer, BigInteger>();

	/**
	 * Realiza a leitura usando java NIO
	 */
	public void reader(String nome, int key) throws IOException {
		Path path = Paths.get(nome);
		super.setKey(key);
		List<String> linhasArquivo = Files.readAllLines(path);
		for (String linha : linhasArquivo) {
		    this.add( linha );
		}
	}

	private void add(String linha) {
			String[] value = linha.split(SEPARATOR);
			Integer key = Integer.parseInt(value[0]);
			BigInteger data = new BigInteger(value[1].trim());
			if( key.equals(super.getKey())) {
				super.setValue( data );
				conteudo.put(key, data);
			}
	}
}
