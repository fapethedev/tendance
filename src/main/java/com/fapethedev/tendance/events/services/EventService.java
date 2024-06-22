package com.fapethedev.tendance.events.services;

import com.fapethedev.tendance.events.entities.Event;
import com.fapethedev.tendance.events.entities.EventImages;
import com.fapethedev.tendance.events.entities.EventVideos;
import com.fapethedev.tendance.events.form.EventForm;
import com.fapethedev.tendance.events.repository.EventRepository;
import com.fapethedev.tendance.main.cdn.CdnUploader;
import com.fapethedev.tendance.users.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

        var event = eventRepository.save(
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

        try
        {
            var imgOne = uploader.upload(eventForm.getImageOne().getBytes(), uploader.getConf().imagePath(), event.getId() + "_one");
            var imgTwo = uploader.upload(eventForm.getImageTwo().getBytes(), uploader.getConf().imagePath(), event.getId() + "_two");
            var imgThree = uploader.upload(eventForm.getImageThree().getBytes(), uploader.getConf().imagePath(), event.getId() + "_three");

            event.setImages(EventImages.builder()
                    .main(imgOne)
                    .second(imgTwo)
                    .third(imgThree)
                    .build());
        }
        catch (Exception e)
        {
            log.warn("Failed to save images on cdn : " + e.getMessage());
        }

        try
        {
            var vidOne = uploader.upload(eventForm.getVideoOne().getBytes(), uploader.getConf().videoPath(), event.getId() + "_one");
            var vidTwo = uploader.upload(eventForm.getVideoTwo().getBytes(), uploader.getConf().videoPath(), event.getId() + "_two");
            var vidThree = uploader.upload(eventForm.getVideoThree().getBytes(), uploader.getConf().videoPath(), event.getId() + "_three");

            event.setVideos(EventVideos.builder()
                            .primary(vidOne)
                            .secondary(vidTwo)
                            .third(vidThree)
                    .build());
        }
        catch (Exception e)
        {
            log.warn("Failed to save videos on cdn : " + e.getMessage());
        }

        return event;
    }

    @Override
    public Event delete(Event event)
    {
        log.info("Deleting event: " + event.getId() + ", name: " + event.getName());

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

        var events = eventRepository.findAll();

        events.sort(Comparator.comparing(Event::getStartDateTime));

        return events;
    }

    @Override
    public List<Event> findByUser(User user)
    {
        log.info("Finding all events for user " + user.getUsername());

        return eventRepository.findByUser(user);
    }
}
