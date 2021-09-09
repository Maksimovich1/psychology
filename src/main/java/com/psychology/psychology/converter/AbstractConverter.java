package com.psychology.psychology.converter;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;

/**
 * Абстрактный конвертер
 * Позволяет зарегистрировать в ModelMapper текущий конвертер с пост обработкой,
 * т.е сразу будет промаплено все по имени а потом будет использоваться пост мапинг
 *
 * @author andrew.maksimovich
 */
public abstract class AbstractConverter<S, D> {

    private final ModelMapper modelMapper;
    protected Class<S> sourceType;
    protected Class<D> destinationType;

    @SuppressWarnings("unchecked")
    protected AbstractConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.sourceType = (Class<S>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.destinationType = (Class<D>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PostConstruct
    protected void init() {
        modelMapper.typeMap(sourceType, destinationType)
                .setPostConverter(getPostConverter());
    }

    /**
     * Пост опработка над моделями
     *
     * @return конвертер пост обработки
     */
    protected abstract Converter<S, D> getPostConverter();
}
