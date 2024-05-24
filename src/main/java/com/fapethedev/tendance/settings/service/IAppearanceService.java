package com.fapethedev.tendance.settings.service;

import com.fapethedev.tendance.main.services.IService;
import com.fapethedev.tendance.settings.entities.Appearance;
import com.fapethedev.tendance.settings.form.AppearanceForm;

import java.util.UUID;

/**
 * <p>Appearance service interface layer which will
 * help to get Appearance entities.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 *
 * @param <T> the type of user id
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 */
public interface IAppearanceService<T> extends IService<Appearance, UUID, AppearanceForm>
{
    /**
     * <p>Gets user custom appearance</p>
     *
     * @param userId the user who saves the appearance
     * @return the appearance
     */
    Appearance findAppearanceByUserId(T userId);
}
