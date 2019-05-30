package my.company.app.presentation.base

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <E> the cached model input type
 * @param <E> the remote model input type
 * @param <D> the model return type
 */
internal interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

}