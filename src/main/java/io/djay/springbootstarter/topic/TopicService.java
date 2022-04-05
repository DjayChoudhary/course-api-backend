package io.djay.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business Service are typically singletons in spring framework When
 * application start ups, spring creates an instance of that service and keep
 * that in its memory which can access that instance object
 * 
 * @author Dell
 *
 */
@Service
public class TopicService {
	/**
	 * <p>
		╔═════════════════════╦═══════════════════════╗
		║      Old name       ║       New name        ║
		╠═════════════════════╬═══════════════════════╣
		║ findOne(…)          ║ findById(…)           ║
		╠═════════════════════╬═══════════════════════╣
		║ save(Iterable)      ║ saveAll(Iterable)     ║
		╠═════════════════════╬═══════════════════════╣
		║ findAll(Iterable)   ║ findAllById(…)        ║
		╠═════════════════════╬═══════════════════════╣
		║ delete(ID)          ║ deleteById(ID)        ║
		╠═════════════════════╬═══════════════════════╣
		║ delete(Iterable)    ║ deleteAll(Iterable)   ║
		╠═════════════════════╬═══════════════════════╣
		║ exists()            ║ existsById(…)         ║
		╚═════════════════════╩═══════════════════════╝
	 *</p>
	 */
	@Autowired
	private TopicRepository topicRepository;
	
//	private List<Topic> topics = new ArrayList<>(
//			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
//					new Topic("java", "Core Java", "Core Java Description"),
//					new Topic("javascript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);	
		
		return topics;
	}

	public Topic getTopic(String id) {
//		return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);
		
	}

	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				topics.remove(i);
//				return;
//			}
//		}
		
//		topics.removeIf(topic -> topic.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
