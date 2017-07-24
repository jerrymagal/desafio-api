package br.com.muxi.converter;

import br.com.muxi.model.BasicEntity;

public interface Converter<T extends BasicEntity> {
	
	T toObject(String objeto);

}
