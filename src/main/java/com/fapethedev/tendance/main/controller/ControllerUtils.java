package com.fapethedev.tendance.main.controller;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Un Simple utilitaire pour des trucs dans les controlleurs.
 *
 * @author jordy jordy.fatigba[at]theopentrade.com
 * @author Fapethedev
 * @version 1.0
 */
public class ControllerUtils
{
    /**
     * <p>Transformer une liste d'erreur de champs en une Map dans lequel pour nom de champ,
     * il y a la liste de tout les messages d'erreurs de validation.</p>
     *
     * @see <a href="https://spring.io/guides/gs/validating-form-input/">Validating Form Input</a>
     *
     * @param errors La liste des erreurs de champs.
     *
     * @return Une Map avec chaque nom de champ et sa liste de messages d'erreurs.
     */
    public static Map<String, List<String>> fromListFieldErrorsToMap(List<FieldError> errors)
    {
        Objects.requireNonNull(errors) ;
        if(errors.isEmpty()) {
            throw new IllegalArgumentException() ;
        }

         return errors
                 .stream()
                 .collect(Collectors.toMap(FieldError::getField, (f) -> {
                    List<String> list = new ArrayList<>();
                    list.add(f.getDefaultMessage());
                    return list;
                 }, (oldvalue, newvalue) -> {oldvalue.addAll(newvalue); return oldvalue;}
            )
        );
    }
}
