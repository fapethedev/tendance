package com.fapethedev.tendance.users.publisher;

/**
 * <p>{@code IUserEventListener} defines methods for listening to user relate event when they
 * are trigger or publish.</p>
 *
 * @author Fapethedev
 * @version 1.0
 */
public interface IUserEventListener
{
    /**
     * <p>Invoked when a {@code UserRegisterEvent} is trigger or publish,
     * meaning users made their registration and need to confirm the registration.</p>
     *
     * @param event the {@link UserRegisterEvent} that will be listened
     */
    void onRegistrationEvent(UserRegisterEvent event);

    /**
     * <p>When a {@code UserRegisterCompleteEvent} is trigger or publish, this method is used to listen to
     * this event and process the right operation.</p>
     *
     * @param event the {@link UserRegisterCompleteEvent} event that will be listened to,
     * meaning users complete their registration and their account has to be activated
     */
    void onRegistrationCompleteEvent(UserRegisterCompleteEvent event);

    /**
     * <p>This method is invoked when a {@code UserTypeChangeEvent} is trigger or publish.</p>
     *
     * @param event the {@link UserTypeChangeEvent} that will be listened to
     * after using trying to change their {@code User.Type} from STANDARD to some others
     */
    void onUserTypeChangeEvent(UserTypeChangeEvent event);
}
