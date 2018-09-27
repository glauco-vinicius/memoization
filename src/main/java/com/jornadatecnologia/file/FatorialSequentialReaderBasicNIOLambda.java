package com.jornadatecnologia.file;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Leitura simplificada estilo NIO
 * @author udesc
 *
 */
class FatorialSequentialReaderBasicNIOLambda extends FatorialFileReader {
	private Map<Integer, BigInteger> conteudo;

	/**
	 * Realiza a leitura usando java NIO
	 */
	public void reader(String nome, int key) throws IOException {
		super.setKey(key);
		conteudo = Files.lines(Paths.get(nome))
				  .filter(line -> line.split(SEPARATOR)[KEY_INDEX].equals(Integer.valueOf(key).toString()))
				  .map(line -> line.split(SEPARATOR))
                  .collect(Collectors.toMap(line -> Integer.valueOf(line[KEY_INDEX].trim()), line -> new BigInteger(line[DATA_INDEX].trim())));
        this.setValue(conteudo.get(key));
	}
	
}
