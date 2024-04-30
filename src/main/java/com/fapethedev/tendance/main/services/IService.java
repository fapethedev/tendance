package com.fapethedev.tendance.main.services;

import java.io.Serializable;
import java.util.List;

/**
 * {@code IService} is the top interface in service layer, and it provides a set of methods
 * for interacting witch repository in the controller layer <br/>
 *
 * @param <ENTITY> the entity type of the service
 * @param <ID> the entity id type
 * @param <FORM> the corresponding form object for the entity
 */
public interface IService <ENTITY extends Serializable, ID extends Serializable, FORM>
{
    /**
     * Create or Update an entity from an existing entity <br/>
     * A new entity will be created if there is no id value in the entity <br/>
     * An updated entity will be performed if there is an id
     * @param entity the entity
     * @return the most recent version of the entity
     */
    ENTITY save(ENTITY entity);

    /**
     * Create a new entity from a form object
     * @param form the corresponding form object for the entity
     * @return the newly created entity
     */
    ENTITY save(FORM form);

    /**
     * Delete an entity
     * @param entity the entity to delete
     * @return the deleted entity
     */
    ENTITY delete(ENTITY entity);

    /**
     * Delete an entity by its id
     * @param id the id of the entity
     * @return the deleted entity
     */
    ENTITY deleteById(ID id);

    /**
     * Get an entity given its id value
     * @param id the id of the entity
     * @return the entity
     */
    ENTITY findById(ID id);

    /**
     * Get all entities
     * @return {@code List} of entities
     */
    List<ENTITY> findAll();
}
