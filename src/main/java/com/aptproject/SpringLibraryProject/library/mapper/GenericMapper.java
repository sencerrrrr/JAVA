package com.aptproject.SpringLibraryProject.library.mapper;

import com.aptproject.SpringLibraryProject.library.dto.GenericDTO;
import com.aptproject.SpringLibraryProject.library.model.GenericModel;
import jakarta.annotation.PostConstruct;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Абстрактный маппер, который реализует основные операции конвертации ИЗ СУЩНОСТИ В ДТО
 * и обратно. С помощью этого класса мы фиксируем основные методы по работе с маппером,
 * а так же определили абстрактные методы, которые описывают правила формирования различающихся полей
 *
 * @param <E> - Сущность с который мы работаем
 * @param <D> - DTO, которую мы будем отдавать/принимать дальше
 */
@Component
public abstract class GenericMapper<E extends GenericModel, D extends GenericDTO>
        implements Mapper<E, D> {

    //Внедряем то, с чем ьудем работать
    private final Class<E> entityClass;
    private final Class<D> dtoClass;
    protected final ModelMapper modelMapper;

    public GenericMapper(Class<E> entityClass,
                         Class<D> dtoClass,
                         ModelMapper modelMapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.modelMapper = modelMapper;
    }

    //Описываем логику методов, обозначенных в интерфейсе Mapper
    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDTO(E entity) {
        return Objects.isNull(entity)
                ? null
                : modelMapper.map(entity, dtoClass);
    }

    @Override
    public List<E> toEntities(List<D> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    @Override
    public List<D> toDTOs(List<E> entities) {
        return entities.stream().map(this::toDTO).toList();
    }

    //Конвертеры для mapSpecificFields
    protected Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(source,destination);
            return context.getDestination();
        };
    }

    protected Converter<E, D> toDTOConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    //маппинг нестандартных полей
    protected abstract void mapSpecificFields(D source, E destination);
    protected abstract void mapSpecificFields(E source, D destination);

    /**
     * Настройка маппера (что делать и что вызывать в случае несовпадения типов данных сорса/дейстинейшена)
     */
    @PostConstruct
    protected abstract void setupMapper();

    protected abstract List<Long> getIds(E entity);

}