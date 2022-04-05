package io.djay.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/topics")
@CrossOrigin("*")
public class TopicController {

	// Marked for DI
	@Autowired
	private TopicService topicService;

//	@RequestMapping("/topics")
    @GetMapping
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

//	@RequestMapping("/topics/{id}")
    @GetMapping("/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/topics")
    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    @PutMapping("/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
