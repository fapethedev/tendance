package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.events.form.EventForm;
import com.fapethedev.tendance.events.repository.EventRepository;
import com.fapethedev.tendance.main.cdn.CdnUploader;
import com.fapethedev.tendance.users.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>Implementation of {@code IEventService}.</p>
 *
 * @see com.fapethedev.tendance.main.services.IService
 * @see com.fapethedev.tendance.events.services.IEventService
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class EventService implements IEventService
{
    /**
     * <p>Database layer for Event.</p>
     */
    private final EventRepository eventRepository;

    private final CdnUploader uploader;

    @Override
    public Event save(Event event)
    {
        log.info("Saving event");

        return eventRepository.save(event);
    }

    @Override
    public Event save(EventForm eventForm)
    {
        log.info("Saving event with form");

//        uploader.upload(eventForm.getImageOne(), uploader.getConf().imagePath(), eventForm.getName().concat("img_one"));
//        uploader.upload(eventForm.getImageOne(), uploader.getConf().imagePath(), eventForm.getName().concat("img_one"));
//        uploader.upload(eventForm.getImageOne(), uploader.getConf().imagePath(), eventForm.getName().concat("img_one"));
//
//        uploader.upload(eventForm.getVideoOne(), uploader.getConf().imagePath(), eventForm.getName().concat("vid_tw"));
//        uploader.upload(eventForm.getVideoTwo(), uploader.getConf().imagePath(), eventForm.getName().concat("vid_one"));
//        uploader.upload(eventForm.getVideoThree(), uploader.getConf().imagePath(), eventForm.getName().concat("vid_one"));




        return eventRepository.save(
                Event.builder()
                        .name(eventForm.getName())
                        .description(eventForm.getDescription())
                        .startDateTime(eventForm.getStartDateTime())
                        .endDateTime(eventForm.getEndDateTime())
                        .state(eventForm.getEventState())
                        .place(eventForm.getPlace())
                        .scope(eventForm.getScope())
                        .user(eventForm.getUser())
                        .build()
        );
    }

    @Override
    public Event delete(Event event)
    {
        log.info("Deleting event");

        eventRepository.delete(event);

        return event;
    }

    @Override
    public Event deleteById(UUID uuid)
    {
        log.info("Deleting event with id: " + uuid);

        return delete(findById(uuid));
    }

    @Override
    public Event findById(UUID uuid)
    {
        log.info("Finding event with id: " + uuid);

        return eventRepository.findById(uuid).orElseThrow();
    }

    @Override
    public List<Event> findAll()
    {
        log.info("Finding all events");

        return eventRepository.findAll();
    }

    @Override
    public List<Event> findByUser(User user)
    {
        log.info("Finding all events for user " + user.getUsername());

        return eventRepository.findByUser(user);
    }
}
