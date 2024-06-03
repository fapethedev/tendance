package com.fapethedev.tendance.users.publisher;

import com.fapethedev.tendance.users.entities.User;

/**
 * <p>{@code IUserEventPublisher} is the interface which is links with
 * the publishing with user related event like Registration and more</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
public interface IUserEventPublisher
{
    /**
     * <p>This method will be use to publish the right event after an user registration.</p>
     * <p>Notify through the application that a new user submits
     * a registration which is valid and processed successfully.</p>
     * <p>When the form pass the validation a event will be triggered.</p>
     *
     * @param user the user who will be newly registered
     */
    void publishUserRegistrationEvent(User user);

    /**
     * <p>This method will be use to publish the right event after an user complete his registration.</p>
     * <p>When users are registered they need to activate their account. <br/>
     * The account activation can be done with many manner like a link in email, web page
     * or an otp.</p>
     *
     * @param user the user who will complete the registration and seen his account activated
     */
    void publishUserRegistrationCompleteEvent(User user);

    /**
     * <p>This method will be use to publish the right event after
     * an user setting a user change type request like being {@code User.Type.ORGANIZER}.</p>
     *
     * @param user the user that tries to change his type
     * @param type the new type {@linkplain User.Type} of the user
     */
    void publishUserTypeChangeEvent(User user, User.Type type);
}
