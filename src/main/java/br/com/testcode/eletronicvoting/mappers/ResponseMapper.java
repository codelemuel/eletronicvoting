package br.com.testcode.eletronicvoting.mappers;

public interface ResponseMapper<M, R> {

	R toResponse(M model);

}
