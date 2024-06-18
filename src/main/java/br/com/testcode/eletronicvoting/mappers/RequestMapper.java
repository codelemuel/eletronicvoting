package br.com.testcode.eletronicvoting.mappers;

public interface RequestMapper<M, R> {

	M toModel(R request);

}
